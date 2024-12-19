package com.hs.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @PostMapping("/test")
    public String test() {
        return "test";
    }

    public static void main(String[] args) {
        int number = 6; // 可以修改这个值来计算其他整数的阶乘
        System.out.println(6 * 5 * 4 * 3 * 2);
        System.out.println("阶乘计算: " + number + "! = " + getFactorial(number));
        System.out.println(isPalindrome("dfssfd1"));
        System.out.println(getNumTimes(66955875));
        System.out.println(getTheThirdLargest(new Integer[]{20}));
        System.out.println(getReverseWords("Hello World! Java is fun."));
        Vector<String> list = new Vector<>();
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(200);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1l, TimeUnit.DAYS, arrayBlockingQueue);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        new Thread(runnable).start();

        list.add("sfs");
        Hashtable<String, String> map = new Hashtable<>();
        map.put("3453", "sfs");
        HashMap<String, String> map1 = new HashMap<>();
        map1.put(null, null);
    }

    public static String getReverseWords(String str) {
        if (null == str) {
            throw new RuntimeException("字符串不能为空");
        }
        StringBuilder builder = new StringBuilder();
        String[] words = str.split(" ");
        for (String word : words) {
            builder.append(new StringBuilder(word).reverse().toString());
            builder.append(" ");
        }
        // 移除最后的空格
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
    public static Integer getTheThirdLargest(Integer[] numArray) {
        if (null == numArray || numArray.length == 0) {
            throw new RuntimeException("数组不能为空");
        }
        // 去重
        Set<Integer> set = new HashSet<>(Arrays.asList(numArray));
        int n=set.size();
        int[] rs=new int[n];
        int i=0;
        //  循环把去重后的set值添加进数组
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            rs[i] = (Integer) iterator.next();
            i++;
        }
        //  排序
        Arrays.sort(rs);
        if(n>=3) {
            return rs[n-3];
        }

        return rs[n-1];

    }

    public static Map<Integer, Integer> getNumTimes(Integer num) {
        if (null == num) {
            throw new RuntimeException("入参不能为空");
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        while (num > 0) {
            int digit = num % 10;
            countMap.put(digit, countMap.getOrDefault(digit, 0) + 1);
            num /= 10;
        }
        return countMap;
    }


        public static boolean isPalindrome(String str) {
            if (null == str) {
                throw new RuntimeException("字符串不能为空");
            }
            int start = 0;
            int end = str.length() - 1;
            while (start < end) {
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

    private static Long getFactorial(Integer num) {
        if (null == num) {
            throw new IllegalArgumentException("输入的数字不能为空");
        }
        if (num < 0) {
            throw new IllegalArgumentException("输入的数字必须是非负整数");
        }
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

}
