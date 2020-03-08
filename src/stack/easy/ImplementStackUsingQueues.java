package stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
//    Queue<Integer> queue;
//    Queue<Integer> tmpqueue;
//    /** Initialize your data structure here. */
//    public ImplementStackUsingQueues() {
//        queue= new LinkedList<Integer>();
//        tmpqueue = new LinkedList<Integer>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        queue.offer(x);
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        Integer ans = null;
//        while(!queue.isEmpty()){
//            tmpqueue.offer(ans=queue.poll());
//        }
//        while(!tmpqueue.isEmpty()){
//            if(tmpqueue.size()>1)
//                queue.offer(tmpqueue.poll());
//            else
//                tmpqueue.poll();
//        }
//        return ans;
//    }
//
//    /** Get the top element. */
//    public int top() {
//        Integer ans = null;
//        while(!queue.isEmpty()){
//            tmpqueue.offer(ans=queue.poll());
//        }
//        while(!tmpqueue.isEmpty()){
//            queue.offer(tmpqueue.poll());
//        }
//        return ans;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue.isEmpty();
//    }
    Queue<Integer> queue;
    Queue<Integer> tmpqueue;
    int top;
    public ImplementStackUsingQueues(){
        queue = new LinkedList<Integer>();
        tmpqueue = new LinkedList<Integer>();
    }
    public void push(int x){
        queue.offer(x);
        top=x;
    }
    public int pop(){
        int ans;
        while(queue.size()>1)
            tmpqueue.offer(top=queue.remove());
        ans = queue.remove();
        Queue<Integer> tmp = queue;
        queue=tmpqueue;
        tmpqueue=tmp;
        return ans;
    }
    public int top(){
        return top;
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
