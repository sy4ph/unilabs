package lab17;

public final class Wrapper extends LinkedList<DataType> {

    // public void addNumber(int number) {
    //     if (this.isEmpty()) {
    //         DataType data = new DataType();
    //         data.addArr(number);
    //         this.head = new Node<DataType>(data);
    //     }

    //     var curNode = this.head;
    //     while (curNode.getNext() != null) {
    //         curNode = curNode.getNext();
    //     }

    //     if (curNode.getData().checkArr()) {
    //         this.addToTail(new Node<DataType>(new DataType()));
    //         curNode = curNode.getNext();
    //     }

    //     curNode.getData().addStr(number);

    // }
    public void addString(String string) {
        if (this.isEmpty()) {
            DataType data = new DataType();
            data.addStr(string);
            this.head = new Node<DataType>(data);
        }

        var curNode = this.head;
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
        }

        if (curNode.getData().checkArr()) {
            this.addToTail(new Node<DataType>(new DataType()));
            curNode = curNode.getNext();
        }

        curNode.getData().addStr(string);

    }
}
