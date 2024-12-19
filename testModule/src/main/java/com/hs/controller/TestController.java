package com.hs.controller;

import com.Bean.ListNode;
import com.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("test")
    public String test() {
        return "test";
    }

    @PostMapping("setRedisValue")
    public String setRedisValue(@RequestBody Map<String, String> map) {
        redisUtil.set(map.get("key"), map.get("value"), 30L);
        return "success";
    }

    @PostMapping("getRedisValue")
    public Object getRedisValue(@RequestBody Map<String, String> map) {
        Object key = redisUtil.get(map.get("key"));
        return key;
    }

    @PostMapping("redisTest")
    public String redisTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("fsss");
        HashMap<String, String> map = new HashMap<>();
        map.put("sjlfls","jflsjfls");
        HashSet<String> set = new HashSet<>();
        set.add("fjsljf");
        return "redisTest";
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (null == list1 && null == list2) {
            return new ListNode();
        }
        if (null == list1) {
            list1 = list2;
            list2 = null;
        }
        // 最后一个节点next为null, 将list2加入到最后
        ListNode next = list1.getNext();
        if (next == null) {
            list1.setNext(list2);
        } else {
            while (next != null) {
                ListNode next1 = next.getNext();
                if (next1 == null) {
                    if (null != list2) {
                        next.setNext(list2);
                    }
                    break;
                } else {
                    next = next1;
                }
            }
        }
        List<ListNode> nodeList = new ArrayList<>();
        ListNode first = list1.getNext();
        if (null == first) {
            nodeList.add(list1);
        } else {
            nodeList.add(list1);
            while (first != null) {
                ListNode first1 = first.getNext();
                nodeList.add(first);
                if (first1 == null) {
                    break;
                } else {
                    first = first1;
                }
            }
        }
        // 对val进行排序
        List<ListNode> collect = nodeList.stream().sorted(Comparator.comparing(ListNode::getVal)).collect(Collectors.toList());
        // 新链表(是collect的第一个节点)是通过拼接给定的两个链表的所有节点组成的
        for (int i = 0; i < collect.size() - 1; i++) {
            ListNode listNode = collect.get(i);
            ListNode listNode1 = collect.get(i+1);
            listNode.setNext(listNode1);
            if (i == (collect.size() - 2)) {
                listNode1.setNext(null);
            }
        }
        return collect.get(0);
    }

}
