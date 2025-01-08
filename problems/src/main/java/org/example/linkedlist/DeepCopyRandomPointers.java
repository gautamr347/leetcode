package org.example.linkedlist;

import java.util.Objects;

public class DeepCopyRandomPointers {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node iterator = head;
        Node deepCopy = head;
        //create a copy and introduce in middle
        while (iterator != null){
            Node copyNode = new Node(iterator.val);
            copyNode.next = iterator.next;
            iterator.next = copyNode;
            iterator = iterator.next.next;
        }

        //update random pointer
        iterator = head;
        while (iterator != null){
            Node random = iterator.random;
            if(Objects.nonNull(random)){
                iterator.next.random = random.next;
            }
            iterator = iterator.next.next;
        }

        var originalCopyIterator = head;
        iterator = head.next;
        deepCopy = head.next;
        //disjoint old nodes
        while (originalCopyIterator != null && iterator != null){
            originalCopyIterator.next = iterator.next;
            if(Objects.isNull(iterator.next)){
                iterator = null;
            } else {
                iterator.next = iterator.next.next;
                originalCopyIterator = originalCopyIterator.next;
                iterator = iterator.next;
            }
        }
        return deepCopy;
    }

    public static void main(String[] args) {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head = new Node(7);
        Node secondNode = new Node(13);
        secondNode.random = head;
        head.next = secondNode;

        Node thirdNode = new Node(11);
        secondNode.next = thirdNode;
        Node fourthNode = new Node(10);
        thirdNode.next = fourthNode;
        Node fifthNode = new Node(1);
        fourthNode.next = fifthNode;

        thirdNode.random = fifthNode;
        fourthNode.random = thirdNode;
        fifthNode.random = head;
        copyRandomList(head);

    }
}
