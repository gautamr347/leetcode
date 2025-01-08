package org.example.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    Node element ;
    Node headNode;

    class Node {
        Node nextNode;
        Integer minElement;
        Integer val;
        Node previousNode;

        Node(Integer val){
            this.val = val;
        }

        Node(Integer val, Integer minElement){
            this.val = val;
            this.minElement = minElement;
        }
    }

    public MinStack() {
        this.element = null;
    }

    public void push(int val) {
        if(element == null) {
            element = new Node(val, val);
            return;
        }
        Node newNode = new Node(val);
        if(element.minElement > val){
            newNode.minElement = val;
        } else {
            newNode.minElement = element.minElement;
        }
        element.nextNode = newNode;
        newNode.previousNode = element;
        element = element.nextNode;

    }

    public void pop() {
        element = element.previousNode;
        element.nextNode = null;
    }

    public int top() {
        return element.val;

    }

    public int getMin() {
        return this.element.minElement;
    }
}
