package com.wq.boot.service.ex;

/**
 * Description  数组下标越界异常
 *
 * @author WangQian
 * @create 2022-07-19 15:04
 */
public class IndexOutBoundsException extends RuntimeException{
    public IndexOutBoundsException() {
        super();
    }

    public IndexOutBoundsException(String message) {
        super(message);
    }

    public IndexOutBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutBoundsException(Throwable cause) {
        super(cause);
    }

    protected IndexOutBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}