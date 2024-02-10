import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class QuickSortTest {
    @BeforeAll
    public static void startMassage(){
        System.out.println("==========START TESTING QickSortTest==========");
    }
    @AfterAll
    public static void endMassage(){
        System.out.println("==========END TESTING QickSortTest==========");
    }
    @Test
    void quickSorttest() {
        System.out.println("==========TEST size STARTED==========");
        Object[] array = {10,9,8,7,6,5,4,3,2,1,0,55,7784, -1};
        Object[] expectedArray = { -1,0,1,2,3,4,5,6,7,8,9,10,55,7784};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.quicksort(myArrayList, 0, myArrayList.size()-1);

        Assertions.assertArrayEquals(expectedArray, myArrayList.toArray());
    }}

