/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
      ListNode res = head;
ListNode fast = head.next;
ListNode slow = head;
while(fast!=null && fast.next!=null){
    fast=fast.next.next;
    slow=slow.next;
}

ListNode half= reverse(slow.next);
slow.next=null;

while(half!=null){
   ListNode tmp= res.next;
   res.next=half;
   half=half.next;
   res.next.next=tmp;
   res=tmp;
}







        
    }

    private ListNode reverse(ListNode head){

       

ListNode prev=  null;
ListNode curr = head;
while(curr!=null){
    ListNode tmp = curr.next;
    curr.next=prev;
    prev=curr;
    curr=tmp;

}
return prev;


    }
}
