
public class SinglyLinkedList {
    // inner node class
    class Node {
        int item;
        Node next;

        Node() {
            this.item = 0;
            this.next = null;
        }

        Node(int data) {
            this.item = data;
            this.next = null;
        }

        int getItem() {
            return this.item;
        }

        Node getNext() {
            return this.next;
        }

        void setItem(int item) {
            this.item = item;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }

    // start
    Node start;

    // is empty
    boolean isEmpty() {
        return this.start == null;
    }

    // insert at begin
    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            this.start = newNode;
        }
        Node temp = this.start;
        newNode.next = temp;
        this.start = newNode;
    }

    // insert at last
    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            this.start = newNode;
            return;
        }

        Node temp = this.start;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // search node by given value
    // insert a new node after a given node
    // delete first node
    public void deleteFromBegin() {
        this.start = this.start.next;
    }

    // delete last node
    public void deleteFromEnd() {
        if (isEmpty())
            return;
        Node temp = this.start;
        if (temp.next == null) {
            this.start = null;
            return;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // delete a node with given item value
    
    // display
    public void display(Node start) {
        while (start != null) {
            System.out.print(start.item + ", ");
            start = start.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtLast(10);
        System.out.println("insert at last");
        sll.display(sll.start);
        sll.insertAtBegin(60);
        System.out.println("insert at begin");
        sll.display(sll.start);
        System.out.println("delete from last");
        sll.deleteFromEnd();
        sll.display(sll.start);
        System.out.println("delete from first");
        sll.deleteFromBegin();
        sll.display(sll.start);

    }
}