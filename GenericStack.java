package com.prasad;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<T> {
    private ArrayList<T> stack;

    public GenericStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
      
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Prasad");
        stringStack.push("Sai");
        stringStack.push("Pavan");
        System.out.println("\nStack size: " + stringStack.size());
        System.out.println("Top element : " + stringStack.peek()); 
        System.out.println("Popped element: " + stringStack.pop()); 
        System.out.println("Stack size after pop: " + stringStack.size()); 
    }
}

