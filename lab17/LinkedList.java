package lab17;

public class LinkedList<T> {
    public static final class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public static final class EmptyListException extends Exception {
        public EmptyListException(String errorMessage) {
            super(errorMessage);
        }
    }

    protected Node<T> head;

    public boolean isEmpty() {
        return this.head == null;
    }

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(Node<T> newNode) {
        //Inserts an element after head, using O(1) operations.

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            newNode.setNext(this.head.getNext());
            this.head.setNext(newNode);
        }

    }

    public void addToTail(Node<T> newNode) {
        //Adding to tail requires O(n) operations

        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            Node<T> curNode = head;

            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(newNode);

            /*This is unnecessary if we can guarantee
            that all the entered nodes point to null.
             */
            newNode.setNext(null);
        }
    }

    public Node<T> search(T searchData) throws EmptyListException {
        //Returned value set to null in case element does not exist

        if (this.isEmpty()) {
            throw new EmptyListException("Tried searching an empty list");
        }
        Node<T> curNode = head;

        while (curNode.getNext() != null) {
            if (curNode.getData().equals(searchData)) {
                return curNode;
            } else {
                curNode = curNode.getNext();
            }
        }

        if (curNode.getData().equals(searchData)) {
            return curNode;
        }
        return null;
    }

    public void remove(T removeData) throws EmptyListException {
        //Removes a node, that follows given Node

        if (this.isEmpty()) {
            throw new EmptyListException("Tried removing from empty list.");
        }
        if (this.head.getNext() == null) {
            this.head = null;
        }

        Node<T> curNode = head;

        while (curNode.getNext() != null) {
            if (curNode.getNext().getData().equals(removeData)) {
                curNode.setNext(curNode.getNext().getNext());
                break;
            }
            else {
                curNode = curNode.getNext();
            }
        }
    }

    public void setBlank() {
        this.head = null;
    }
}
