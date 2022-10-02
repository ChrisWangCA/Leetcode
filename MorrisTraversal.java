package src.binaryTree;

public class MorrisTraversal {

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static void morris(Node head) {
        if (head == null) return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null) { //过流程
            if (mostRight != null) { //有左子树
                while (mostRight.right != null && mostRight.right != cur) { //因为人为的改过后续的指向所以要有第二个条件
                    mostRight = mostRight.right;
                }
                //mostRight变成了cur左子树上最右的节点
                if (mostRight.right == null) { // 这是第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }


        public static void morrisIn (Node head){
            if (head == null) {
                return;
            }
            Node cur1 = head;
            Node cur2 = null;
            while (cur1 != null) {
                cur2 = cur1.left;
                if (cur2 != null) {
                    while (cur2.right != null && cur2.right != cur1) {
                        cur2 = cur2.right;
                    }
                    if (cur2.right == null) {
                        cur2.right = cur1;
                        cur1 = cur1.left;
                        continue;
                    } else {
                        cur2.right = null;
                    }
                }
                System.out.print(cur1.value + " ");
                cur1 = cur1.right;
            }
            System.out.println();
        }

        public static void morrisPre (Node head){
            if (head == null) {
                return;
            }
            Node cur1 = head;
            Node cur2 = null;
            while (cur1 != null) {
                cur2 = cur1.left;
                if (cur2 != null) {
                    while (cur2.right != null && cur2.right != cur1) {
                        cur2 = cur2.right;
                    }
                    if (cur2.right == null) {
                        cur2.right = cur1;
                        System.out.print(cur1.value + " ");
                        cur1 = cur1.left;
                        continue;
                    } else {
                        cur2.right = null;
                    }
                } else {
                    System.out.print(cur1.value + " ");
                }
                cur1 = cur1.right;
            }
            System.out.println();
        }

        public static void morrisPos (Node head){
            if (head == null) {
                return;
            }
            Node cur1 = head;
            Node cur2 = null;
            while (cur1 != null) {
                cur2 = cur1.left;
                if (cur2 != null) {
                    while (cur2.right != null && cur2.right != cur1) {
                        cur2 = cur2.right;
                    }
                    if (cur2.right == null) {
                        cur2.right = cur1;
                        cur1 = cur1.left;
                        continue;
                    } else {
                        cur2.right = null;
                        printEdge(cur1.left);
                    }
                }
                cur1 = cur1.right;
            }
            printEdge(head);
            System.out.println();
        }

        public static void printEdge (Node head){
            Node tail = reverseEdge(head);
            Node cur = tail;
            while (cur != null) {
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
            reverseEdge(tail);
        }

        public static Node reverseEdge (Node from){
            Node pre = null;
            Node next = null;
            while (from != null) {
                next = from.right;
                from.right = pre;
                pre = from;
                from = next;
            }
            return pre;
        }

        // for test -- print tree
        public static void printTree (Node head){
            System.out.println("Binary Tree:");
            printInOrder(head, 0, "H", 17);
            System.out.println();
        }

        public static void printInOrder (Node head,int height, String to,int len){
            if (head == null) {
                return;
            }
            printInOrder(head.right, height + 1, "v", len);
            String val = to + head.value + to;
            int lenM = val.length();
            int lenL = (len - lenM) / 2;
            int lenR = len - lenM - lenL;
            val = getSpace(lenL) + val + getSpace(lenR);
            System.out.println(getSpace(height * len) + val);
            printInOrder(head.left, height + 1, "^", len);
        }

        public static String getSpace ( int num){
            String space = " ";
            StringBuffer buf = new StringBuffer("");
            for (int i = 0; i < num; i++) {
                buf.append(space);
            }
            return buf.toString();
        }

        public static void main (String[]args){
            Node head = new Node(4);
            head.left = new Node(2);
            head.right = new Node(6);
            head.left.left = new Node(1);
            head.left.right = new Node(3);
            head.right.left = new Node(5);
            head.right.right = new Node(7);
            printTree(head);
            morrisIn(head);
            morrisPre(head);
            morrisPos(head);
            printTree(head);

        }

    }
