package com.wq.store.service.ex;

/**
 * Description   用户数据不存在异常
 *
 * @author WangQian
 * @create 2022-06-25 20:22
 */
public class UsernameNoFoundException extends ServiceException{
    public UsernameNoFoundException() {
        super();
    }

    public UsernameNoFoundException(String message) {
        super(message);
    }

    public UsernameNoFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNoFoundException(Throwable cause) {
        super(cause);
    }

    protected UsernameNoFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}