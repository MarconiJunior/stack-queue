package common;

/**
 * Represents a node in a singly linked list.
 *
 * @param <T> The type of the value stored in the node.
 */
public class Node<T> {
    private final T value;
    private Node<T> next;

    /**
     * Constructs a new node with a specified value. The next node is initialized as null.
     *
     * @param value The value to store in the node.
     */
    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Retrieves the next node in the linked list.
     *
     * @return The next node, or null if this node is the last one in the list.
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next The node to be set as the next node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Retrieves the value stored in the node.
     *
     * @return The value stored in the node.
     */
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
