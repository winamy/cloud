package com.winamy.user.service.common.aspects;

import com.alibaba.fastjson.JSON;
import com.winamy.common.constants.CommonConstants;
import com.winamy.common.utils.ReqDedupHelper;
import com.winamy.exception.enums.CommonExceptionEnum;
import com.winamy.exception.exceptions.CommonException;
import com.winamy.user.service.common.annotations.DuplicateRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @description: 重复请求切面处理
 * @author: wym
 * @createDate: 2020/12/1
 */
@Aspect
@Component
@Slf4j
public class DuplicateRequestAspect {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 横切点
     */
    @Pointcut("execution(* com.winamy..*.*(..))")
    public void dupPoint() {
    }

    @Around("dupPoint() && @annotation(dumRequest)")
    public void handle(ProceedingJoinPoint point, DuplicateRequest dumRequest) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Object[] args = point.getArgs();
        String methodName = point.getSignature().getName();
        long expireTime = dumRequest.expireTime();
        String[] excludeFields = dumRequest.excludeField();
        String md5Str = ReqDedupHelper.dedupParamMD5(JSON.toJSONString(parameterMap),excludeFields);

        String userId= "12345678";  //用户
        String KEY = CommonConstants.DUPLICATE_REQUEST_PREFIX + "U=" + userId + "M=" + methodName + "P=" + md5Str;

        long expireAt = System.currentTimeMillis() + expireTime;
        String val = "expireAt@" + expireAt;

        // NOTE:直接SETNX不支持带过期时间，所以设置+过期不是原子操作，极端情况下可能设置了就不过期了，后面相同请求可能会误以为需要去重，所以这里使用底层API，保证SETNX+过期时间是原子操作
        Boolean firstSet = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> connection.set(KEY.getBytes(), val.getBytes(), Expiration.milliseconds(expireTime),
                RedisStringCommands.SetOption.SET_IF_ABSENT));

        final boolean isConsiderDup;
        if (firstSet != null && firstSet) {
            isConsiderDup = false;
        } else {
            isConsiderDup = true;
        }
        if(isConsiderDup){
            log.error("重复请求,参数：{}",JSON.toJSONString(parameterMap));
            throw new CommonException(CommonExceptionEnum.DUPLICATE_REQUEST);
        }else{
            point.proceed();
        }
    }


}
