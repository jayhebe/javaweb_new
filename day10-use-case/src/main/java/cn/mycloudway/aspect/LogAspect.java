package cn.mycloudway.aspect;

import cn.mycloudway.mapper.AuditLogMapper;
import cn.mycloudway.pojo.AuditLog;
import cn.mycloudway.util.JWTUtils;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AuditLogMapper auditLogMapper;
    @Autowired
    private JWTUtils jwtUtils;

    @Around("@annotation(cn.mycloudway.annotation.Log)")
    public Object recordAuditLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String jwtToken = request.getHeader("token");
        Claims claims = jwtUtils.verifyJWT(jwtToken);
        Integer operateUser = (Integer) claims.get("id");
        LocalDateTime operateTime = LocalDateTime.now();
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String methodParams = Arrays.toString(proceedingJoinPoint.getArgs());

        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();

        String returnValue = JSONObject.toJSONString(result);
        long costTIme = endTime - startTime;

        AuditLog auditLog = new AuditLog();
        auditLog.setOperateUser(operateUser);
        auditLog.setOperateTime(operateTime);
        auditLog.setClassName(className);
        auditLog.setMethodName(methodName);
        auditLog.setMethodParams(methodParams);
        auditLog.setReturnValue(returnValue);
        auditLog.setCostTime(costTIme);

        auditLogMapper.add(auditLog);
        log.info("AOP记录操作日志：{}", auditLog);

        return result;
    }
}
