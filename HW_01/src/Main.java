import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList=new MyArrayList<>();

        myArrayList.addAll(Arrays.asList("Mercedes","Volkswagen"));

        myArrayList.add("Ford");
        myArrayList.add("BMW");
        myArrayList.add("Lada");
        myArrayList.add("Audi");

        System.out.println(myArrayList);
        System.out.println("----------------------");
        QuickSort.quickSort(myArrayList);
        System.out.println(myArrayList);
    }
}
