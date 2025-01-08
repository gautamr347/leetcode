package org.example.util;

import org.example.model.ListNode;

public class LinkedList {

    public static int getLength(ListNode head){
        if(head == null) return 0;
        ListNode current = head;
        int counter = 0;
        while (current != null){
            counter++;
            current = current.next;
        }
        return counter;
    }
}
