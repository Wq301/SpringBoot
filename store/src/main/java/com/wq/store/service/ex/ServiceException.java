package com.wq.store.service.ex;

/**
 * Description  业务层异常的基类
 *              throws new ServiceException()
 *              根据业务层不同的功能来详细定义具体的异常类型，统一继承ServiceException异常类
 * @author WangQian
 * @create 2022-06-24 22:41
 */
public class ServiceException extends  RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {           //常用
        super(message);
    }

    public ServiceException(String message, Throwable cause) {      //常用
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}