package com.cc.common.utils;

import com.cc.common.utils.StringUtil;

public class DesensitizedUtil {
    /**
     * 密码的全部字符都用*代替，比如：******
     *
     * @param password 密码
     * @return 脱敏后的密码
     */
    public static String password(String password) {
        if (StringUtil.isBlank(password)) {
            return StringUtil.EMPTY;
        }
        return StringUtil.repeat('*', password.length());
    }

    /**
     * 车牌中间用*代替，如果是错误的车牌，不处理
     *
     * @param carLicense 完整的车牌号
     * @return 脱敏后的车牌
     */
    public static String carLicense(String carLicense) {
        if (StringUtil.isBlank(carLicense)) {
            return StringUtil.EMPTY;
        }
        // 普通车牌
        if (carLicense.length() == 7) {
            carLicense = StringUtil.hide(carLicense, 3, 6);
        } else if (carLicense.length() == 8) {
            // 新能源车牌
            carLicense = StringUtil.hide(carLicense, 3, 7);
        }
        return carLicense;
    }
}
