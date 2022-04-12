package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhengguochun
 * @description
 * @date 2022-04-12
 */
public class LRUCache {
    // 定义数据存储map
    Map<Integer, Node> cache;
    // 定义记录操作记录的queue
    Node head;
    int cap = 0;
    int capacity;
    // 双向链表
    static class Node{
        int val;
        int key;
        Node pre;
        Node next;

        Node(){}
        Node(int val, int key){
            this.val = val;
            this.key = key;
        }

        Node remove(){
            next.pre = pre;
            pre.next = next;
            next = null;
            pre = null;
            return this;
        }

        void insert(Node node){
            node.next = next;
            node.pre = this;
            next.pre = node;
            next = node;
        }
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        // 一个类似环形的存在
        head = new Node();
        head.pre = head;
        head.next = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        // 获取值
        Node value = cache.get(key);
        if (null == value){
            return -1;
        }else{
            value = value.remove();
            head.insert(value);
            return value.val;
        }

    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (null == node){
            if (capacity == cap){
                // 如果此时缓存已经满了，则需要清理一个历史的
                Node eldest = head.pre.remove();
                cache.remove(eldest.key);
                // 长度减小
                cap--;
            }
            // 如果不存在 需要新建节点
            node = new Node(value, key);
            cache.put(key, node);
            cap++;
        }else{
            // 先要
            node = node.remove();
            node.val = value;
        }
        head.insert(node);
    }

    private void log(){
        Set<Integer> keySet = cache.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : keySet) {
            stringBuilder.append(integer).append(",");
        }
        System.out.println(stringBuilder);
        Node temp = head.next;
        stringBuilder = new StringBuilder();
        while (temp != head){
            stringBuilder.append(temp.key);
            temp = temp.next;
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
    }
}
