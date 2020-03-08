package stack.easy;

import java.lang.reflect.Array;
import java.util.Stack;

public class MinStack {
    /**自己写的重新实现了一个栈**/
//    private int data;
//    private MinStack next;
//    private Integer small;
//    public MinStack() {
//        this.next=null;
//        this.data=0;
//        this.small=null;
//    }
//
//    public MinStack(MinStack node,int data,Integer small){
//        this.next=node;
//        this.data=data;
//        this.small=small;
//    }
//
//    public void push(int x) {
//        MinStack ms = new MinStack(this.next,x,this.small);
//        if(this.small==null||x<this.small)
//            this.small=x;
//
//        this.next=ms;
//    }
//
//    public void pop() {
//        this.small=this.next.small;
//        this.next=this.next.next;
//    }
//
//    public int top() {
//        return this.next.data;
//    }
//
//    public int getMin() {
//        return this.small;
//    }
    /**辅助栈法（同步）**/
//    private Stack<Integer> stack;
//    private Stack<Integer> helper;
//    public MinStack(){
//        stack=new Stack<Integer>();
//        helper=new Stack<Integer>();
//    }
//    public void push(int x){
//        stack.push(x);
//        if(helper.empty()||helper.peek()>x)
//            helper.push(x);
//        else
//            helper.push(helper.peek());
//    }
//    public void pop(){
//        stack.pop();
//        helper.pop();
//    }
//    public int top(){
//        return stack.peek();
//    }
//    public int getMin(){
//        return helper.peek();
//    }
    /**辅助栈法（不同步）**/
    private Stack<Integer> stack;
    private Stack<Integer> helper;
    public MinStack(){
        stack = new Stack<Integer>();
        helper = new Stack<Integer>();
    }
    public void push(int x){
        stack.push(x);
        if(helper.empty()||helper.peek()>=x)
            helper.push(x);
    }
    public void pop(){
        if(stack.pop().equals(helper.peek()))
            helper.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return helper.peek();
    }
}
