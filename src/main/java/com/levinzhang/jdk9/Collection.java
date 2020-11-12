package com.levinzhang.jdk9;

import java.util.List;
import java.util.Map;

public class Collection {

    public static void main(String[] args) {
        // cannot to be changed anymore
        List<String> stringList = List.of("sss", "ddd");
        System.out.println(stringList.get(0));
        //stringList.add("ttt");

        Map<String, Long> map = Map.of("key1", 12L, "key2", 21L);
        //System.out.println(map.get("key1"));
        //map.put("key3", 22L);
    }
}
