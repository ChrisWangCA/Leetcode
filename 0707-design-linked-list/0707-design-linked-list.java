class MyLinkedList {
    
    int N;
    ListNode head;
    
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new ListNode();
    }
    
    public int get(int index) {
        if(index < 0 || index >= N) return -1;
        ListNode cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.next.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        newNode.next = cur.next;
        cur.next = newNode;
        N++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        if(cur == null){
            head = newNode;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            N++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0) index = 0;
        if(index > N) return;
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        N++;
    }
    
    public void deleteAtIndex(int index) {
        ListNode cur = head;
        if(index < 0 || index >= N) return;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        N--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */