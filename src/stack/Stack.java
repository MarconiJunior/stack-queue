package stack;

import common.Node;

public class Stack<T> {
    private Node<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(top);
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) return null;
        T value = top.getValue();
        top = top.getNext();
        return value;
    }
}
