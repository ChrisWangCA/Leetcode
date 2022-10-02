package Algorithm.RedBlackTree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public boolean color;


        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }



        public int size(){
            return N;
        }

        private boolean isRed(Node x){
            if (x==null){
                return false;
            }
            return x.color==RED;
        }

        private Node rotateLeft(Node h){
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.color = h.color;
            h.color = RED;
            return x;
        }

        private Node rotateRight(Node h){
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.color = h.color;
            h.color = RED;
            return x;
        }

        private void flipColors(Node h){
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }

        private void put(Key key,Value value){
            root = put(root,key,value);
            root.color=BLACK;
        }

        private Node put(Node h,Key key,Value value){
            if (h == null){
                N++;
                return new Node(key,value,null,null,RED);
            }

            int cmp = key.compareTo(h.key);
            if (cmp<0){
                h.left = put(h.left,key,value);
            }else if (cmp>0){
                h.right = put(h.right,key,value);
            }else{
                h.value = value;
            }

            if (isRed(h.right) && !isRed(h.left)){
                rotateLeft(h);
            }
            if (isRed(h.left) && isRed(h.left.left)){
                rotateRight(h);
            }

            if (isRed(h.left) && isRed(h.right)){
                flipColors(h);
            }
            return h;
        }


    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x,Key key){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp<0){
            return get(x.left,key);
        }else if(cmp>0){
            return get(x.right,key);
        }else{
            return x.value;
        }
    }
}
