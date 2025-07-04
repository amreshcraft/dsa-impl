public class DoublyLinkedList {
    class Node {
        Node prev;
        int item;
        Node next;

        public Node() {
            this.prev = null;
            this.item = 0;
            this.next = null;
        }

        public Node(int data) {
            this.item = data;
        }

        public Node(Node prev, int data, Node next) {
            this.prev = prev;
            this.item = data;
            this.next = next;
        }

        public int getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

// is empty
public boolean isEmpty(){
    return this.start == null;
}
// insert at begining
public void insertAtBegin(int data){
    Node newNode = new Node(data);
    if(isEmpty()) {
        this.start.prev = newNode;
    }
    newNode.next = this.start;
    this.start = newNode;
}
// insert at end of the list
public void insertAtLast(int data){
    Node newNode = new Node(data); 
    if(isEmpty()){
        this.start = newNode;
        return;
    }
    Node temp = this.start;
    while (temp.next !=null) {
        temp = temp.next;
    }
    newNode.prev = temp;
    temp.next = newNode;

}
// search by value
public boolean search(int value){
    Node temp = this.start;
    while (temp != null) {
        if(temp.item == value){
            return true;
        }        
        temp = temp.next;
        
    }
    return false;
}
// insert new node after a given node
public void insertAfterNode(int data, int afterThis){
    if(isEmpty()) {
        System.out.println("list is empty, no item to add after ");
        return;
    }
    Node temp = this.start;
    while(temp !=null){

        if(temp.item == afterThis){
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
            return;
        }
        temp = temp.next;
    }
  System.out.println("no " + afterThis + " is found to add after this");
}
// delete from begin
public void deleteFromBegin(){
    if(isEmpty()) return;
    this.start = this.start.next;
    if(this.start !=null){

        this.start.prev = null;
    }
}
// delete from end
public void deleteFromEnd(){
    // list is empty
    if(isEmpty()) return;
    Node temp = this.start;
    
       // if only one node
    if(this.start.next == null){
        this.start = null;
        return;
    }
    // list have many item
    while (temp.next != null) {
     temp = temp.next;   
    }
    
    temp.prev.next = null;
}
// delete by value
public void deleteByValue(int value) {
    if (isEmpty()) {
        System.out.println("List is empty.");
        return;
    }

    Node temp = this.start;

    while (temp != null) {
        if (temp.item == value) {

            // Deleting the first node
            if (temp.prev == null) {
                this.start = temp.next;
                if (this.start != null) { // If list is not empty after deletion
                    this.start.prev = null;
                }
            } 
            // Deleting middle or last node
            else {
                temp.prev.next = temp.next;
                if (temp.next != null) { // If it's not the last node
                    temp.next.prev = temp.prev;
                }
            }

            System.out.println("Deleted node with value: " + value);
            return;
        }
        temp = temp.next;
    }

    System.out.println("Node with value " + value + " not found.");
}

// display
public void display(){
Node temp = this.start;
while (temp != null) {
    System.out.print(temp.item + ", ");
    temp = temp.next;
  }
System.out.println();

}



    Node start;

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtLast(10);
        dll.insertAtLast(20);
        dll.insertAtLast(30);
        dll.insertAtLast(40);
        System.out.println("Insert at last");
        dll.display();
        dll.insertAtBegin(11);
        dll.insertAtBegin(12);
        dll.insertAtBegin(13);
        System.out.println("insert at start");
        dll.display();
        dll.deleteFromBegin();
        System.out.println("delete at begin");
        dll.display();
        dll.deleteByValue(12);
        System.out.println("Delete by value");
        dll.display();
    }
}
