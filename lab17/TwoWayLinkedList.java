package lab17;

public class TwoWayLinkedList<T> {
    public static final class Node<T> {
        private T data;
        private Node<T> next;
        private Node <T> prev;

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

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
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

    public TwoWayLinkedList() {
        this.head = null;
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
            curNode.getNext().setPrev(curNode);

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

        Node<T> curNode = this.search(removeData);
        Node<T> prevNode = curNode.getPrev();
        prevNode.setNext(curNode.getNext());

    }

    public void setBlank() {
        //Thank you garbage collector!
        this.head = null;
    }
}
