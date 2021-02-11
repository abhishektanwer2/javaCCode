package com.company;

import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack ;
    Stack<Integer> minstack ;
    int tempnew;

    public MinStack() {
stack=new Stack<>();
        minstack=new Stack<>();
tempnew=0;
    }

    public void push(int x) {
        stack.push(x);
        if(minstack.empty())minstack.push(x);
        if(stack.peek()<minstack.peek())
            minstack.push(x);
    }

    public void pop() {
        int temp=stack.pop();
        if(temp==minstack.peek())minstack.pop();
    }

    public int top() {
return stack.peek();
    }



    public int getMin() {
return minstack.peek();
    }
}
