import org.junit.jupiter.api.*;

import java.util.Iterator;

class MyArrayListTest {

    @Test
    void size() {
        System.out.println("==========TEST size STARTED==========");
        Object[] array = {1,2,3,4,5,6,7,8,9,10};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(array);
        Assertions.assertEquals(10, myArrayList.size());
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
    void add() {// не работает, почему то он длинной 16
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

    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }
}