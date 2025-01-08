package org.example.model;

public class DoubleListNode {

    public int val;
    public DoubleListNode next;
    public DoubleListNode previous;
    public DoubleListNode() {}
    public DoubleListNode(int val) { this.val = val; }
    public DoubleListNode(int val, DoubleListNode next) { this.val = val; this.next = next; }
    public DoubleListNode(int val, DoubleListNode prev, DoubleListNode next){
        this.previous = prev;
        this.next = next;
    }
}
