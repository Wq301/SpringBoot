package com.wq.store.service.ex;

/**
 * Description  收货地址非当前用户的收货地址的异常
 *
 * @author WangQian
 * @create 2022-07-18 17:40
 */
public class AddressNotFoundException extends ServiceException{
    public AddressNotFoundException() {
        super();
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}