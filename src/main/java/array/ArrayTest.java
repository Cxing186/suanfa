package array;

/**
 * @author kirit
 * @date 2019-11-10
 */
public class ArrayTest {
    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(5);
        myArray.insert(0, 0);
        myArray.insert(1,1);
        myArray.insert(2,2);
        myArray.insert(3,3);
        myArray.insert(4,4);
        myArray.insert(5,5);
        myArray.insert(6,6);
        myArray.insert(7,7);
        myArray.insert(8,8);
        myArray.insert(2,8);
        myArray.delete(2);
        myArray.delete(2);
        myArray.delete(2);
        myArray.output();
    }

}
