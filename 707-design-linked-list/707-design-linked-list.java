class MyLinkedList {
    int N;
    ListNode head;
    class ListNode{
        ListNode next;
        int val;
        public ListNode(){};
        ListNode(int val){this.val = val;}
    }
    public MyLinkedList() {
        N = 0;
        head = new ListNode(0);
    }
    
    public int get(int index) {
        if(index < 0 || index >= N) return -1;
        ListNode cur = head;
        for(int i=0;i<=index;i++){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        N++;
        
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        if(head == null){
            head = newNode;
        }else{
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = newNode;
        }
        N++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0) index=0;
        if(index>N) return;
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
        if(index < 0 || index >= N) return;
        ListNode cur = head;
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