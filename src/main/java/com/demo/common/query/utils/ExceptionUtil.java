package com.demo.common.query.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author HuTing
 * @date 2020-08-20 11:26
 */
public class ExceptionUtil {

    /**
     * 异常栈转为字符串
     *
     * @param e
     * @return
     */
    public static String getStackMsg(Exception e) {
        ByteArrayOutputStream exception = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(exception));
        return exception.toString();
    }
}
