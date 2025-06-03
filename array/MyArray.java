package array;

class Array {
    private int[] array = null;
    private int lastIndex = -1;

    Array(int size) {
        this.array = new int[size];
    }
 
    public void append(int data){
        try {
            if (lastIndex +1 < array.length) {
                
                array[lastIndex+1] = data;
                lastIndex++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
                   e.printStackTrace();
        }
    }

    public void display(){
       for(int i = 0; i <= lastIndex; i++) {
            System.out.print(this.array[i]+", ");
            
        }
    }
    
}

public class MyArray {

    public static void main(String[] args) {

          Array arr = new Array(10);
          arr.append(10);
          arr.append(20);
          arr.append(30);
          arr.append(40);
          arr.append(50);
          arr.append(60);
          arr.append(70);
          arr.append(80);
          arr.display();
    }

}