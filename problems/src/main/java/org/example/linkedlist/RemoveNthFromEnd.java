package org.example.linkedlist;

import org.example.model.ListNode;
import org.example.util.LinkedList;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //find length of linkedList
        int length = LinkedList.getLength(head);
        if(n > length){
            return head;
        }
        if(length == 1 && n == 1){
            return null;
        }
        int fromBeginning = length - n;
        if(fromBeginning == 0){
            head = head.next;
            return head;
        }
        ListNode currentNode = head;
        int counter = 1;
        while (currentNode != null){
            if(fromBeginning == counter){
                ListNode temp = currentNode.next;
                if(temp != null){
                    currentNode.next = temp.next;
                }
                break;
            } else {
                currentNode = currentNode.next;
                counter++;
            }
        }
        return head;
    }
}
