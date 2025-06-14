
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
    public boolean isFound(int value){
        Node temp = this.start;
        while(temp != null){
            if(temp.item == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    // insert a new node after a given node
    public void insertAfterNode(int data, int afterThis) {
    if (isEmpty()) {
        System.out.println("List is empty. Cannot insert after " + afterThis);
        return;
    }

    Node newNode = new Node(data);
    Node temp = this.start;

    while (temp != null) {
        if (temp.item == afterThis) {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Inserted " + data + " after " + afterThis + " successfully.");
            return;
        }
        temp = temp.next;
    }

    System.out.println("Node with value " + afterThis + " not found.");
}

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
    public void deleteByValue(int value) {
        Node temp = this.start;
        if (isEmpty())
            return;
        if (temp.item == value) {
            this.start = this.start.next;
              System.out.println("Deleted node with value: " + value);
            return;
        }
        while (temp.next != null) {
            if (temp.next.item == value) {
                temp.next = temp.next.next;
                  System.out.println("Deleted node with value: " + value);
                return;
            }

            temp = temp.next;

        }
    System.out.println("Node with value " + value + " not found.");
    }

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
        sll.insertAtLast(20);
        sll.insertAtLast(30);
        sll.insertAtLast(40);
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
        System.out.println("delete by value:");
        sll.deleteByValue(10);
        sll.display(sll.start);
        System.out.println("insert after by value: ");
        sll.insertAfterNode(101,20);
        sll.display(sll.start);
    }
}