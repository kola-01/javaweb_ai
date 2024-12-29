package asai.kola.exception;

import asai.kola.pojo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错了：", e);
        return Result.error("服务器端错误，请稍后重试");
    }

    @ExceptionHandler
    public Result DuplicateKeyException(DuplicateKeyException D) {
        log.error("出错了：",D);
        String message = D.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMessage = message.substring(i);
        String err = errMessage.split(" ")[2];
        return Result.error(err+"已存在");
    }
}
