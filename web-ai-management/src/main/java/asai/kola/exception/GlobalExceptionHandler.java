package asai.kola.exception;

import asai.kola.pojo.Result;
import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler
    public Result HandleException(RuntimeException r) {
        log.error("程序出错了：", r);
        return Result.error(r.getMessage());
    }

    @ExceptionHandler
    public Result DataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("出错了：", e);
        String message = e.getMessage();
        int i = message.indexOf("Column");
        String errMessage = message.substring(i);
        String err = errMessage.split(" ")[1];
        if (err.equals("'clazz_id'")) {
            return Result.error("班级不能为空");
        }
        return Result.error("数据完整性错误");
    }
}
