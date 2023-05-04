package cn.mycloudway.exception;

import cn.mycloudway.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleAllExceptions(Exception e) {
        log.error(e.getMessage());
        return Result.error("操作失败，请联系管理员");
    }
}
