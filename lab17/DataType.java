package lab17;

public class DataType {

    private final String[] arr;
    private int arr_size;

    public DataType() {
        this.arr = new String[5];
        this.arr_size = 0;
    }

    public String[] getArr() {
        return arr;
    }

    public int getArr_size() {
        return arr_size;
    }
    public void addStr(String string) {
        this.arr[arr_size] = string;
        this.arr_size+=1;
        
        int i = arr_size - 1;
        // if (arr_size > 1){}
        while (i > 0 && this.arr[i].compareTo(this.arr[i - 1]) == 1) {
            String temp = this.arr[i];
            this.arr[i] = this.arr[i - 1];
            this.arr[i - 1] = temp;
        }
    }
    // public void addArr(int num) {
    //     //Returns True if list was not overflown

    //     this.arr_size += 1;
    //     this.arr[arr_size] = num;

    //     int i = arr_size - 1;
    //     while (i > 0 && this.arr[i] < this.arr[i - 1]) {
    //         int temp = this.arr[i];
    //         this.arr[i] = this.arr[i - 1];
    //         this.arr[i - 1] = temp;

    //         i--;
    //     }
    // }

    public boolean checkArr() {
        return (this.arr_size >= 5);
    }
}
