package com.free.system.service.common.exception;

/**
 * description:
 * @author suwenguang
 * @date 2019/5/24
 * @version 1.0.0
 **/
public class SystemException extends Exception {

    /**
     * Constructor for TransactionException.
     * @param msg the detail message
     */
    public SystemException(String msg) {
        super(msg);
    }

    /**
     * Constructor for TransactionException.
     * @param msg the detail message
     * @param cause the root cause from the transaction API in use
     */
    public SystemException(String msg, Throwable cause) {
        super(msg, cause);
    }
}