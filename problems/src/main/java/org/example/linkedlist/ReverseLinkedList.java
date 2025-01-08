package org.example.linkedlist;

import org.example.model.ListNode;

import java.util.Stack;

public class ReverseLinkedList {

    //https://leetcode.com/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode result = head;
        ListNode leftNode = null;
        int counter = 0;
        Stack<Integer> elements = new Stack<>();
        while (head != null){
            counter++;
            if(counter == left){
                leftNode = head;
            }
            if(counter >= left && counter <= right){
                elements.add(head.val);
            }
            if(counter == right) break;
            head = head.next;
        }
        while (!elements.isEmpty()){
            Integer element = elements.pop();
            assert leftNode != null;
            leftNode.val = element;
            leftNode = leftNode.next;
        }
        return result;
    }


}
