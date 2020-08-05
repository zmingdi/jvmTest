package com.mingdi.guava.collections;

import com.google.common.collect.HashBiMap;

/**
 * HashBiMap allows non-duplicated key and value
 */
public class HashBiMapTest {

    public static void main(String[] args) {
        HashBiMap<String, String> map = HashBiMap.create();
        map.put("first", "first ele");
        map.put("first", "first ele");
        map.forEach((k,v)->{
            System.out.println(String.format("k = %s, v=%s",k,v));
        });
        //System.out.println(map.size());
    }

}
