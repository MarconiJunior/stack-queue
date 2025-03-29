package queue;

import common.Node;

/**
 * Represents a generic queue implementation using linked nodes.
 * It supports enqueueing, dequeue, and checking the queue's state.
 *
 * @param <T> The type of elements in the queue.
 */
public class Queue<T> {
    protected Node<T> first;
    protected Node<T> last;
    protected Integer size;

    /**
     * Constructs a new empty queue.
     */
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Adds a new item to the end of the queue.
     *
     * @param item The item to be added to the queue.
     */
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

    /**
     * Removes and returns the first item from the queue.
     *
     * @return The first node of the queue, or null if the queue is empty.
     */
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

    /**
     * Returns the first item in the queue without removing it.
     *
     * @return The first node in the queue.
     */
    public Node<T> peek() {
        return this.first;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
}
