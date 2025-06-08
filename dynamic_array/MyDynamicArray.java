package dynamic_array;

class DynArray {
    int lastIndex = -1;
    int[] array = null;

    public DynArray(int size) {
        this.array = new int[size];
    }

    // make the array double
    public void makeDoubleSize() {
        int[] newArray = new int[this.array.length * 2];
        for (int i = 0; i <= lastIndex; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;

    }

    // make the array half size
    public void makeHalfSize() {
    int newSize = Math.max(1, this.array.length / 2); // never 0 size
    int[] newArray = new int[newSize];

    for (int i = 0; i <= lastIndex && i < newSize; i++) {
        newArray[i] = this.array[i];
    }

    this.array = newArray;

    }

    // append
    public void append(int data) {
        if (lastIndex == this.array.length - 1) {
            makeDoubleSize();
        }
        this.array[lastIndex + 1] = data;
        ++lastIndex;
    }

    // is valid index
    public boolean isValidIndex(int index) {
        if (index >= 0 && index <= this.lastIndex)
            return true;
        return false;
    }

    // insert
    public void insert(int data, int index) {

        if (index < 0 || index > lastIndex + 1) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (lastIndex == this.array.length - 1) {
            makeDoubleSize();
        }

        for (int i = lastIndex; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = data;
        lastIndex++;

    }

    // edit
    public void edit(int data, int index) {
        if (isValidIndex(index)) {
            this.array[index] = data;
        }

    }

    // delete
    public void delete(int index) {

        if (isValidIndex(index)) {
            // make element left shift
            for (int i = index; i < lastIndex; i++) {
                this.array[i] = this.array[i + 1];
            }
            --lastIndex;
            if (lastIndex+1 < this.array.length / 2 && this.array.length > 1) {
                makeHalfSize();
            }
        }
    }

    // total element
    public int getTotalElement() {
        return lastIndex + 1;
    }

    // is empty
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    // get value at
    public int getAt(int index) {
        try {
            if (isValidIndex(index)) {
                return this.array[index];
            } else {

                throw new Exception("index is invalid");
            }
        } catch (Exception e) {
            e.getMessage();
            return -1;
        }

    }

    // capacity
    public int capacity() {
        return this.array.length;
    }

}

public class MyDynamicArray {

    public static void main(String[] args) {
        DynArray arr = new DynArray(2); // Start with small size to test doubling quickly

        System.out.println("Appending values:");
        arr.append(10);
        arr.append(20);
        arr.append(30); // Should trigger doubling
        arr.append(40);
        arr.append(50);

        printArray(arr);

        System.out.println("\nInsert 25 at index 2:");
        arr.insert(25, 2);
        printArray(arr);

        System.out.println("\nEdit index 1 to 15:");
        arr.edit(15, 1);
        printArray(arr);

        System.out.println("\nDelete index 3:");
        arr.delete(3);
        printArray(arr);

        System.out.println("\nGet value at index 2:");
        System.out.println(arr.getAt(2));

        System.out.println("\nTotal Elements: " + arr.getTotalElement());
        System.out.println("Capacity: " + arr.capacity());
        System.out.println("Is Empty: " + arr.isEmpty());

        System.out.println("\nDeleting multiple times to trigger half sizing...");
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        printArray(arr);

        System.out.println("Capacity after deletions: " + arr.capacity());
    }

    public static void printArray(DynArray arr) {
        System.out.print("Array content: ");
        for (int i = 0; i < arr.getTotalElement(); i++) {
            System.out.print(arr.getAt(i) + " ");
        }
        System.out.println();
    }
}