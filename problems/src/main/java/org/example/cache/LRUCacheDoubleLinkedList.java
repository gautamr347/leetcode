package org.example.cache;

import org.example.model.DoubleListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCacheDoubleLinkedList {
    //https://leetcode.com/problems/lru-cache/submissions/1496531563/

    Map<Integer, Integer> keyValueMap = new HashMap<>();
    DoubleListNode head = new DoubleListNode();
    Integer totalCapacity = 0;
    Integer currentCapacity = 0;

    public LRUCacheDoubleLinkedList(int capacity) {
        this.totalCapacity = capacity;
    }

    public int get(int key) {
        if(keyValueMap.containsKey(key)){
            //make head;
            makeCurrentNodeHead(key);
            return keyValueMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(keyValueMap.containsKey(key)){
            keyValueMap.put(key, value);
            //search and make head
            makeCurrentNodeHead(key);
            return;
        }
        //check size if full, remove last node.
        if(Objects.equals(currentCapacity, totalCapacity)){
            deleteLastNode();
            currentCapacity--;
        }
        keyValueMap.put(key, value);
        if(currentCapacity == 0){
            head = new DoubleListNode(key);
        } else if(currentCapacity == 1){
            addNewNodeForSize1(key);
        } else {
            //create new node and make head
            addNewNode(key);
        }
        currentCapacity++;
    }

    private void makeCurrentNodeHead(int key){
        DoubleListNode iterator = head;
        if(currentCapacity == 0 || currentCapacity == 1){
            return;
        }
        if(head.val == key) return;

        while (iterator != null){
            if(iterator.val == key){
                if(currentCapacity == 2){
                    head = iterator;
                    return;
                }

                DoubleListNode firstPrevious = iterator.previous;
                DoubleListNode firstNext = iterator.next;
                firstPrevious.next = firstNext;
                firstNext.previous = firstPrevious;

                addNewNode(key);
                break;
            } else {
                iterator = iterator.next;
            }
        }
    }

    private void addNewNodeForSize1(int key){
        DoubleListNode newNode = new DoubleListNode(key);
        head.previous = newNode;
        newNode.next = head;
        head.next = newNode;
        newNode.previous = head;
        head = newNode;
    }

    private void addNewNode(int key){
        DoubleListNode newNode = new DoubleListNode(key);
        DoubleListNode temp = head.previous;
        head.previous = newNode;
        temp.next = newNode;
        newNode.next = head;
        newNode.previous = temp;
        head = newNode;
    }

    private void deleteLastNode(){
        if(currentCapacity == 1){
            int keyToDelete = head.val;
            keyValueMap.remove(keyToDelete);
            head = null;
            return;
        }
        if(currentCapacity == 2){
            int keyToDelete = head.next.val;
            keyValueMap.remove(keyToDelete);
            head.next = null;
            head.previous = null;
            return;
        }
        int keyToDelete = head.previous.val;
        keyValueMap.remove(keyToDelete);
        DoubleListNode temp = head.previous.previous;
        temp.next = head;
        head.previous = temp;
    }

    public static void main(String[] args) {
        //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        //[4,3,2,-1,-1,2,3,-1,5]

        LRUCacheDoubleLinkedList lruCacheDoubleLinkedList = new LRUCacheDoubleLinkedList(3);
        lruCacheDoubleLinkedList.put(1, 1);
        lruCacheDoubleLinkedList.put(2, 2);
        lruCacheDoubleLinkedList.put(3, 3);
        lruCacheDoubleLinkedList.put(4, 4);
        System.out.println(lruCacheDoubleLinkedList.get(4));
        System.out.println(lruCacheDoubleLinkedList.get(3));
        System.out.println(lruCacheDoubleLinkedList.get(2));
        System.out.println(lruCacheDoubleLinkedList.get(1));
        lruCacheDoubleLinkedList.put(5, 5);
        System.out.println(lruCacheDoubleLinkedList.get(1));
        System.out.println(lruCacheDoubleLinkedList.get(2));
        System.out.println(lruCacheDoubleLinkedList.get(3));
        System.out.println(lruCacheDoubleLinkedList.get(4));
        System.out.println(lruCacheDoubleLinkedList.get(5));
    }
}
