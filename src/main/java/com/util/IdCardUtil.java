package com.util;


import java.time.LocalDate;
import java.time.Period;

/**
 * 身份证工具
 */
public class IdCardUtil {


    /**
     * 获取年龄
     *
     * @param idCard 身份证号码
     * @return
     */
    public static Integer getAge(String idCard) {
        if (StringUtil.isBlank(idCard)) {
            return 0;
        }
        if (idCard.length() < 18) {
            return 0;
        }
        // 得到年份
        int year = Integer.valueOf(idCard.substring(6).substring(0, 4));
        // 得到月份
        int month = Integer.valueOf(idCard.substring(10).substring(0, 2));
        // 得到日
        int day = Integer.valueOf(idCard.substring(12).substring(0, 2));

        LocalDate today = LocalDate.now();
        System.out.println("Today : " + today);
        LocalDate birthDate = LocalDate.of(year, month, day);
        System.out.println("BirthDate : " + birthDate);
        Period p = Period.between(birthDate, today);
        System.out.printf("年龄 : %d 年 %d 月 %d 日", p.getYears(), p.getMonths(), p.getDays());

        return p.getYears();
    }

}