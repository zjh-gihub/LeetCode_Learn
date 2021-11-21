package Tests.LeetCode.easy;

import com.sun.scenario.animation.shared.ClipEnvelope;

public class _83DeleteDuplicates {
    public static void main(String[] args) {

    }
    public static  listNode deleteDuplicates(listNode head) {
        if(head==null){
            return null;
        }
        listNode temp =head;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }
}

class listNode {
    int val;
    listNode next;

    listNode() {
    }

    listNode(int val) {
        this.val = val;
    }

    listNode(int val, listNode next) {
        this.val = val;
        this.next = next;
    }
}