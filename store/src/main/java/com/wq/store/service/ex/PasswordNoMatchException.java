package com.wq.store.service.ex;

/**
 * Description   密码验证失败异常
 *
 * @author WangQian
 * @create 2022-06-25 20:22
 */
public class PasswordNoMatchException extends ServiceException{
    public PasswordNoMatchException() {
        super();
    }

    public PasswordNoMatchException(String message) {
        super(message);
    }

    public PasswordNoMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNoMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNoMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}