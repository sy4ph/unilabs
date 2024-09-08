package lab17;

public class CircularlyLinked<T> {
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

    public CircularlyLinked() {
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
            curNode.getNext().setNext(this.head);
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

    public void setBlank() {
        //Thank you garbage collector!
        this.head = null;
    }
}


