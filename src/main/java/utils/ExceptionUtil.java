package utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @Author HuTing
 * @Date 2020-04-02 11:33
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
