package src.stack_queue;

import java.util.Stack;


public class ReverseStack {

    //只用递归和不申请额外空间逆序一个栈
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }
    }
}
