package com.qw.support.currency.log;

/**
 * description: 抽象接口
 *
 * @author suwenguang
 * @since 1.0
 * @version 1.0.0
 */
@SuppressWarnings(value = "all")
public interface ILogDetail {
    /** {@inheritDoc} */
    @Override
    String toString();

    /**
     * 说明: 获取接口返回的消息
     *
     * @author suwenguang
     * @return a {@link String} object.
     */
    String getRes();

    /**
     * 说明: 设置信息
     *
     * @author suwenguang
     * @param format a {@link String} object.
     * @param arg a {@link Object} object.
     * @return a {@link LogDetail} object.
     */
    LogDetail setMsg(String format, Object... arg);

}
