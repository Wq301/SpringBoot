package com.wq.store.service.ex;

/**
 * Description  商品数据不存在的异常
 *
 * @author WangQian
 * @create 2022-07-19 22:12
 */
public class ProductNotFoundException extends ServiceException{
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}