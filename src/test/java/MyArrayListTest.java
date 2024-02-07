import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyArrayListTest {

    @BeforeAll
    public static void startMassage(){
        System.out.println("==========START TESTING MyArrayList==========");
    }
    @AfterAll
    public static void endMassage(){
        System.out.println("==========END TESTING MyArrayList==========");
    }
    @Test
    void size() {
        System.out.println("==========TEST size STARTED==========");
        Object[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        myArrayList.add(11);
        Assertions.assertEquals(11, myArrayList.size());
    }

    @Test
    void isEmpty() {
        System.out.println("==========TEST isEmpty STARTED==========");
        MyArrayList myArrayList = new MyArrayList<>(0);
        Assertions.assertTrue(myArrayList.isEmpty());
    }

    @Test
    void contains1() {
        System.out.println("==========TEST contains1 STARTED==========");
        Object[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Assertions.assertTrue(myArrayList.contains(8));
    }

    @Test
    void contains2() {
        System.out.println("==========TEST contains2 STARTED==========");
        Object[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Assertions.assertFalse(myArrayList.contains(77));
    }

    @Test
    void iterator() {
        System.out.println("==========TEST iterator STARTED==========");
        Object[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Iterator<Integer> iterator = myArrayList.iterator();
        int i = 0;
        while (iterator.hasNext()){
            iterator.next();
            i++;
        }
        Assertions.assertEquals(i, 10);
    }

    @Test
    void toArray() {
        System.out.println("==========TEST toArray STARTED==========");
        Object[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Object[] newArray = myArrayList.toArray();
        Assertions.assertSame(newArray, array);
    }

    @Test
    void add() {
        System.out.println("==========TEST add STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        myArrayList.add(12);
        myArrayList.add(999);
        myArrayList.add(0);
        Integer[] expectedArray = {1,2,3,4,5,6,7,8,9,10,12,999,0};
        Assertions.assertArrayEquals(expectedArray, myArrayList.toArray());
    }

    @Test
    void remove() {
        System.out.println("==========TEST remove STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Integer[] expectedArray = {1,2,3,4,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Assertions.assertTrue(myArrayList.remove((Object) 5));
        Assertions.assertArrayEquals(expectedArray, myArrayList.toArray());
    }

    @Test
    void addAll() {
        System.out.println("==========TEST addAll STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Integer[] checkArray = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        ArrayList<Integer> addArray = new ArrayList<>(List.of(array));
        myArrayList.addAll(addArray);
        Assertions.assertArrayEquals(checkArray, myArrayList.toArray());
    }

    @Test
    void addAllIndex() {
        System.out.println("==========TEST addAllIndex STARTED==========");
        int index = 5;
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Integer[] checkArray = {1,2,3,4,5,1,2,3,4,5,6,7,8,9,10,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        ArrayList<Integer> addArray = new ArrayList<>(List.of(array));
        myArrayList.addAll(index,addArray);
        Assertions.assertArrayEquals(checkArray, myArrayList.toArray());
    }

    @Test
    void clear() {
        System.out.println("==========TEST clear STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        myArrayList.clear();
        Assertions.assertArrayEquals(null, myArrayList.toArray());
    }

    @Test
    void get() {
        System.out.println("==========TEST get STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Integer expected = 6;
        Assertions.assertEquals(expected, myArrayList.get(5));
    }

    @Test
    void set() {
        System.out.println("==========TEST set STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Integer[] expectedArray = {1,2,3,4,99999,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        myArrayList.set(4,99999);
        Assertions.assertArrayEquals(expectedArray, myArrayList.toArray());

    }

    @Test
    void addIndex() {
        System.out.println("==========TEST addIndex STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Integer[] expectedArray = {1,2,3,4,99999,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        myArrayList.add(4,99999);
        Assertions.assertArrayEquals(expectedArray, myArrayList.toArray());
    }

    @Test
    void testIndex() {
        System.out.println("==========TEST testIndex STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Integer[] expectedArray = {1,2,3,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        myArrayList.remove(3);
        Assertions.assertArrayEquals(expectedArray, myArrayList.toArray());
    }

    @Test
    void indexOf() {
        System.out.println("==========TEST indexOf STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Integer indexInArray = myArrayList.indexOf(5);
        Integer expectedIndex = 4;
        Assertions.assertEquals(expectedIndex, indexInArray);

    }

    @Test
    void lastIndexOf() {
        System.out.println("==========TEST lastIndexO STARTED==========");
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Integer indexInArray = myArrayList.indexOf(5);
        Integer expectedIndex = 4;
        Assertions.assertEquals(expectedIndex, indexInArray);
    }
}