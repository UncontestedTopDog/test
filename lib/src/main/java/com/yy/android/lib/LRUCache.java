package com.yy.android.lib;
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//         cache.put(1, 1);
//         cache.put(2, 2);
//         cache.get(1);       // 返回  1
//         cache.put(3, 3);    // 该操作会使得关键字 2 作废
//         cache.get(2);       // 返回 -1 (未找到)
//         cache.put(4, 4);    // 该操作会使得关键字 1 作废
//         cache.get(1);       // 返回 -1 (未找到)
//         cache.get(3);       // 返回  3
//         cache.get(4);       // 返回  4

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRUCache {

    int length;
    List<Integer> keys;
    Map<Integer,Integer> maps;

    public LRUCache(int capacity) {
        length = capacity;
        keys = new ArrayList<>();
        maps = new HashMap<>();
    }


    public int get(int key) {
        if (maps.get(key) != null) {
            int index = hasKey(key);
            keys.remove(index);
            keys.add(key);
            return maps.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        int index = hasKey(key);
        if (index>=0) {
            keys.remove(index);
            keys.add(key);
            maps.put(key,value);
        } else {
            if (keys.size() < length) {
                keys.add(key);
                maps.put(key,value);
            } else {
                maps.remove(keys.get(0));
                maps.put(key,value);
                keys.remove(0);
                keys.add(key);
            }
        }
    }

    private int hasKey(int key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i)==key){
                return i;
            }
        }
        return -1;
    }

}

