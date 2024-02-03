import java.util.*;

public class MyArrayList<E> implements List<E> {
    private int capacity = 0;
    private int size = 0;
    private Object[] array;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public MyArrayList(Object[] array){
        this.array = array;
        this.size = array.length;
        this.capacity = array.length;

    }
    private void increaseCapacity(){
        capacity = capacity * 3 / 2 + 1;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Object el: array) {
            if (el == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new myArrayIterator<>(array);
    }
    protected static class myArrayIterator <E> implements java.util.Iterator<E>    {
        protected int cursor = 0;
        protected final E[] array;
        myArrayIterator (E[] array){this.array = array;}

        @Override
        public boolean hasNext() {
            return cursor < array.length;
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= array.length){
                throw new NoSuchElementException();
            }
            cursor ++;
            return array[i];
        }
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public boolean add(Object o) {
        if (size >= capacity){
            increaseCapacity();
        }
        array[size + 1] = o;
        size ++;
        return true;
    }

    protected void shiftToLeft(int indexOfRemove){
        size--;
        System.arraycopy(array, indexOfRemove + 1, array, indexOfRemove, size - indexOfRemove);
        array[size+1] = null;
    }

    @Override
    public boolean remove(Object o) {
        if(size == 0){return false;}
        int i;
        for (i = 0; i < size; i++) {
            if (array[i].equals(o)){
                break;
            }
        }
        if (i < size){
            shiftToLeft(i);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if (size >= capacity){
            increaseCapacity();
            capacity = capacity + c.size();
        }
        for (Object el: c) {
            add(el);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (size >= capacity){
            increaseCapacity();
            capacity = capacity + c.size();
        }
        Object[] lastPartOfArray = new Object[size - index];
        System.arraycopy(array, index, lastPartOfArray, 0 , size-index);
        size = index;
        for (Object el: c) {
            add(el);
        }
        addAll(List.of(lastPartOfArray));
        return true;
    }

    @Override
    public void clear() {
        array = null;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public Object set(int index, Object element) {
        Object removedElement = array[index];
        array[index] = element;
        return removedElement;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public E remove(int index) {
            Object removedObject = new Object();
            removedObject = array[index];
            shiftToLeft(index);
            return (E) removedObject;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        throw new RuntimeException();
    }
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i >= 0; i--) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return Arrays.stream(a).toArray();
    }
}