
package com.yy.android.lib.algorithm;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class LRUCache {

    Stack<KeyValue> stack = new Stack<>();
    Map<Integer,KeyValue> maps = new HashMap<>();
    int capacaity;

    public LRUCache(int capacity) {
        this.capacaity = capacity;
    }


    public int get(int key) {
        if (!maps.containsKey(key))
        return -1;
        KeyValue keyValue = maps.get(key);
        stack.removeElement(keyValue);
        stack.addElement(keyValue);
        return maps.get(key).value;
    }

    public void put(int key, int value) {
        if (maps.containsKey(key)) {
            KeyValue keyValue = maps.get(key);
            stack.removeElement(keyValue);
            keyValue = new KeyValue(key, value);
            stack.addElement(keyValue);
            maps.remove(key);
            maps.put(key, keyValue);
            return;
        }
        if (stack.size() < capacaity) {
            KeyValue keyValue = new KeyValue(key, value);
            stack.removeElement(keyValue);
            stack.addElement(keyValue);
            maps.put(keyValue.key, keyValue);
        } else {
            KeyValue head = stack.remove(0);
            KeyValue keyValue = new KeyValue(key, value);
            stack.addElement(keyValue);
            maps.remove(head.key);
            maps.put(key, keyValue);
        }
    }

    public class KeyValue{
        int key;
        int value;

        public KeyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

}

