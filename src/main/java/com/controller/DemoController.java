package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author YeGuanWei
 * @since 2021-12-29
 */
@RestController
@RequestMapping("/forum/demo")
public class DemoController {

    private static List<String> oldList = new ArrayList<String>() {{
        this.add("111");
        this.add("222");
        this.add("333");
    }};

    private static List<String> newList = new ArrayList<String>() {{
        this.add("111");
        this.add("222");
        this.add("444");
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("请输入姓名：");
            String name = sc.nextLine();
            System.out.printf("%n欢迎你：%s。", name);
            String[] list = name.split(" ");
            System.out.println(count + "=====" + list);
        }
    }

}