package array;

class Array {
    private int[] array = null;
    private int lastIndex = -1;

    Array(int size) {
        this.array = new int[size];
    }

    // chech valid index
  public boolean isValidIndex(int index) {
    return index >= 0 && index <= lastIndex;
}


    // insert
   public void insert(int data, int index) {
    try {
        if (index < 0 || index > lastIndex + 1) {
            throw new Exception("Invalid insert index: " + index);
        }

        if (isFull()) {
            throw new Exception("Container is full. Can't add more items.");
        }

        if (isEmpty() && index == 0) {
            append(data);
            return;
        }

        // Shift elements to the right
        for (int i = lastIndex; i >= index; i--) {
            this.array[i + 1] = this.array[i];
        }

        this.array[index] = data;
        ++lastIndex;

    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public boolean isFull() {
        return this.lastIndex == array.length - 1;
    }

    // is empty
    public boolean isEmpty() {
        return this.lastIndex < 0;
    }

    // total element
    public int totalElement() {
        if (this.lastIndex < 0)
            return 0;
        return this.lastIndex + 1;
    }

    // delete
    public void delete(int index) {
        if (isValidIndex(index)) {
            // shift toward left
            for (int i = index; i < lastIndex; i++) {
                this.array[i] = this.array[i + 1];
            }
            --lastIndex;
        }
    }

    // edit
    public void edit(int data, int index) {
        if (isValidIndex(index)) {
            this.array[index] = data;
        }
    }

    // append
public boolean append(int data) {
    if (isFull()) {
        System.out.println("Append failed: Array is full.");
        return false;
    }
    array[++lastIndex] = data;
    return true;
}

    // get value at given index
    public int getAt(int index) {
        try {
            if (index < 0)
                throw new Exception("Index can't be negative");
            if (index > lastIndex)
                throw new Exception("index out of the bound");
            return array[index];
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // get capacity of the array
    public int capacity() {
        return this.array.length;
    }

    // display
public void display() {
    if (isEmpty()) {
        System.out.println("[empty]");
        return;
    }
    for (int i = 0; i <= lastIndex; i++) {
        System.out.print(this.array[i] + (i < lastIndex ? ", " : "\n"));
    }
}

}

public class MyArray {

 public static void main(String[] args) {
    Array arr = new Array(5);

    System.out.println("Initial append:");
    arr.append(10);
    arr.append(20);
    arr.append(30);
    arr.display();

    System.out.println("\nInsert 15 at index 1:");
    arr.insert(15, 1);
    arr.display();

    System.out.println("\nInsert 5 at index 0:");
    arr.insert(5, 0);
    arr.display();

    System.out.println("\nInsert 99 at index 5 (end):");
    arr.insert(99, 5);
    arr.display();

    System.out.println("\nTrying to insert into full array:");
    arr.insert(111, 2); // Should give error

    System.out.println("\nDelete at index 0:");
    arr.delete(0);
    arr.display();

    System.out.println("\nEdit index 2 to 100:");
    arr.edit(100, 2);
    arr.display();

    System.out.println("\nGet element at index 3: " + arr.getAt(3));

    System.out.println("\nTotal elements: " + arr.totalElement());
    System.out.println("Capacity: " + arr.capacity());
}


}