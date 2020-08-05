package com.mingdi.guava.collections.forwarding;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * ForwardingMap is a implementation of decorator pattern for Map.class.
 * It is enhanced the functions of Map collection.
 * E.G., when adding elements to collection, it is requested to log or
 * send event, use forwarding map will delegate the function before/after
 * actual put .
 */
public class ForwardingMapTest {
    public static void main(String[] args) {
        ForwardingMap<String, String> map = new ForwardingMap<String, String>() {
            final Map<String, String> map = Maps.newHashMap();
            @Override
            protected Map<String, String> delegate() {
                return map;
            }
            @Override
            public String put(String k  ,String v){
                System.out.println(String.format("key: %s added with value %s.",k,v));
                return delegate().put(k,v);
            }
        };

        map.put("first","ele");
    }
}
