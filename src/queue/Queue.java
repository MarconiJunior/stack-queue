package queue;

import common.Node;

public class Queue<T> {
    protected Node<T> first;
    protected Node<T> last;
    protected Integer size;

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        if (this.size == 0) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }

        this.last = newNode;
        this.size++;
    }

    public Node<T> dequeue() {
        if (this.size == 0) {
            return null;
        }

        Node<T> tempNode = this.first;

        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
            tempNode.setNext(null);
        }

        this.size--;

        return tempNode;
    }

    public Node<T> peek() {
        return this.first;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
