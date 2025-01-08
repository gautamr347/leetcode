package org.example.linkedlist;

import org.example.model.ListNode;

public class RotateList {

    //https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150

    public ListNode rotateRight(ListNode head, int k) {
        //get Size
        int size = getSize(head);
        int rotate = k % size;
        if(rotate == 0) return head;

        //break from size - k
        // add in beginning

        var iter = head;
        int counter = 0;
        ListNode newHead = null;
        ListNode toBreak = null;
        while (iter != null){
            counter++;
            if(counter == size - rotate){
                newHead = iter.next;
                toBreak = iter;
            }
            if(iter.next == null){
                break;
            }
            iter = iter.next;
        }

        iter.next = head;
        toBreak.next = null;
        return newHead;
    }

    private int getSize(ListNode listNode){
        var iter = listNode;
        int counter = 0;
        while (iter != null){
            counter++;
            iter = iter.next;
        }
        return counter;
    }

}
