public class CircularLinkedList {

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

    // properties
    Node last;

    // is empty
    public boolean isEmpty() {
        return this.last == null;
    }

    // insert node at begin
    public void insertAtBegin(int data) {
        Node n = new Node(data);

        if (this.last == null) {
            n.setNext(n);
            last = n;
        } else {

            n.setNext(this.last.next);
            this.last.setNext(n);
        }

    }

    // insert node at last
    public void insertAtLast(int data) {
        Node n = new Node(data);

        if (isEmpty()) {
            n.setNext(n);
            this.last = n;
        } else {
            n.setNext(this.last.getNext());
            this.last.setNext(n);
        }

    }

    // search with given value
    // insert after a given node
    // delete first node
    // delete last node
    // delete node with given ite,
    // display
    public void display() {
      if (isEmpty()) {
        System.out.println("List is empty.");
        return;
    }

    Node temp = this.last.next; // Start from the first node

    while (true) {
        System.out.print(temp.getItem() + ", ");

        temp = temp.next; // Move to next node

        if (temp == this.last.next) { // If we came back to start, stop
            break;
        }
    }
    System.out.println();

    }

    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtBegin(10);
        cll.insertAtBegin(20);
        cll.display();
        cll.insertAtLast(90);
        cll.insertAtLast(100);
        cll.display();
        

    }

}
