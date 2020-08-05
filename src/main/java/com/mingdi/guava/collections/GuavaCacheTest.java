package com.mingdi.guava.collections;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * An expirable map.
 * define the expiration duration after certain access(read/write).
 * Could be use for JWT token local storage, temp value
 */
public class GuavaCacheTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Cache cache = CacheBuilder.newBuilder().expireAfterWrite(5l, TimeUnit.SECONDS).build();

        cache.put("first","first cache value");

        Thread.sleep(1000);
        System.out.println(" should stil exists : " + cache.get("first",()->{
            return "shall not appear";
        }));
        Thread.sleep(5000);
        System.out.println(" should not exists : " + cache.get("first",()->{
            return "it is gone";
        }));

    }
}
