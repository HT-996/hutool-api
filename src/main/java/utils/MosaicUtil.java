package utils;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 脱敏工具类
 *
 * @author HuTing
 * @date 2020-05-07 16:52
 */
public class MosaicUtil {

    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    public static void main(String[] args) {
        String name = "李文";
        System.out.println(desensitizedName(name));
        String id = "450934199708096678";
        System.out.println(desensitizedIdNumber1(id));
//        String bankId = "6225456709887656";
//        System.out.println(replaceStr(bankId));
    }

    /**
     * 中文名字：只展示姓名第一个字
     *    * 身份证号：年月日脱敏，前6后4不脱敏
     *    * 手机号：前三后四不脱敏，中间脱敏
     *    * 银行卡：前6位和后4位不脱敏，中间脱敏
     *    
     */
    private static String replaceStr(String param) {
        int len = param.length();
        if (isContainChinese(param)) {
            return param.replaceAll("(.{1})(.*)(.{0})", "$1" + "*" + "$3");
        }
        return param.replaceAll("(.{" + (len < 12 ? 3 : 4) + "})(.*)(.{4})", "$1" + "****" + "$3");
    }

    /**
     * @description:
     * @return: 判断字符串中是否含中文
     * @author: Administrator
     * @date: 2019/10/4
     */
    private static boolean isContainChinese(String str) {
        Matcher m = NUMBER_PATTERN.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 姓名脱敏
     *
     * @param fullName
     * @return
     */
    private static String desensitizedName(String fullName) {
        if (!Strings.isNullOrEmpty(fullName)) {
            String name = StringUtils.left(fullName, 1);
            return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
        }
        return fullName;
    }

    /**
     * 手机号脱敏
     *
     * @param phoneNumber
     * @return
     */
    private static String desensitizedPhoneNumber(String phoneNumber) {
        if (StringUtils.isNotEmpty(phoneNumber)) {
            phoneNumber = phoneNumber.replaceAll("(\\w{3})\\w*(\\w{4})", "$1****$2");
        }
        return phoneNumber;
    }

    /**
     * 身份证脱敏方式一
     *
     * @param idNumber
     * @return
     */
    private static String desensitizedIdNumber1(String idNumber) {
        if (!Strings.isNullOrEmpty(idNumber)) {
            if (idNumber.length() == 15) {
                idNumber = idNumber.replaceAll("(\\w{6})\\w*(\\w{3})", "$1******$2");
            }
            if (idNumber.length() == 18) {
                idNumber = idNumber.replaceAll("(\\w{6})\\w*(\\w{3})", "$1*********$2");
            }
        }
        return idNumber;
    }

    /**
     * 身份证脱敏方式二
     *
     * @param idNumber
     * @return
     */
    private static String desensitizedIdNumber2(String idNumber) {
        if (!Strings.isNullOrEmpty(idNumber)) {
            return StringUtils.left(idNumber, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(idNumber, 3), StringUtils.length(idNumber), "*"), "******"));
        }
        return idNumber;
    }

    /**
     * 地址脱敏
     *
     * @param address
     * @return
     */
    private static String desensitizedAddress(String address) {
        if (!Strings.isNullOrEmpty(address)) {
            return StringUtils.left(address, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(address, address.length() - 11), StringUtils.length(address), "*"), "***"));
        }
        return address;
    }

}
