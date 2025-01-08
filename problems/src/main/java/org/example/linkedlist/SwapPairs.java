package org.example.linkedlist;

import org.example.model.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode current = head;
        while (current.next != null){
            int temp = current.next.val;
            current.next.val = current.val;
            current.val = temp;
            current = current.next;
            if(current.next == null){
                break;
            }
            current = current.next;
        }
        return head;
    }
}
