package com.wq.boot.service.ex;

/**
 * Description   空指针异常
 *
 * @author WangQian
 * @create 2022-07-19 15:03
 */
public class NullPointException extends RuntimeException{
    public NullPointException() {
        super();
    }

    public NullPointException(String message) {
        super(message);
    }

    public NullPointException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPointException(Throwable cause) {
        super(cause);
    }

    protected NullPointException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}