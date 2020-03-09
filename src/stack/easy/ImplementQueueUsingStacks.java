package stack.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {
//    Stack<Integer> stack1,stack2;
//
//
//    /** Initialize your data structure here. */
//    public ImplementQueueUsingStacks() {
//        stack1=new Stack<Integer>();
//        stack2=new Stack<Integer>();
//    }
//
//    //每次放入新元素都进行洗牌,时时刻刻保持stack1栈顶的是最旧的元素
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        while(!stack1.empty())
//            stack2.push(stack1.pop());
//        stack2.push(x);
//        while(!stack2.empty())
//            stack1.push(stack2.pop());
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//        return stack1.pop();
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        return stack1.peek();
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return stack1.empty();
//    }
Stack<Integer> stack1,stack2;
    int front;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
//    来的时候直接放到s1里，省时间，但是要注意新来的值
//      直接往stack1里放，但是需要记录最早放进去的那个以便在没有pop过（stack2为空）或比现在stack1中最早的值更早的值(这些值在stack2中)的值都返回的时候快速返回队头
    public void push(int x) {
        if(stack1.empty())
            front=x;
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
//    只有当stack2空的时候，才进行洗牌（因为stack2中的最上面的元素是最旧的，不能在stack2还有东西的时候往上堆），将stack1的后出序列反向成stack2中的正向序列，这样减少了摊还复杂度，也就是说不用每次都洗牌
    public int pop() {
        if(!stack1.empty())
            while(!stack1.empty())
                stack2.push(stack1.pop());
        int ans = stack2.pop();
        front = stack2.peek();
        return ans;
    }

//    stack2中的顶部数据 旧于 stack2中的其他数据 旧于 stack1中的底部数据
    /** Get the front element. */
    public int peek() {
        if(stack2.empty())
            return front;
        else
            return stack2.peek();
    }

//    s1和s2存的都是Queue里的数据
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack1.empty()&&stack2.empty());
    }
}
