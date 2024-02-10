import java.util.*;
/*
* Реализация интерфейса List с изменяемым размером массива. Реализует  необязательные операции со списком.
* Помимо реализации интерфейса List, этот класс предоставляет методы для управления размером массива,
* который используется внутри для хранения списка
* Операции size, isEmpty, get, set, iterator выполняются за постоянное время.
* Операция добавления выполняется за амортизированное постоянное время,
* то есть добавление n элементов требует времени O(n).
* Все остальные операции выполняются за линейное время.
* Каждый экземпляр MyArrayList имеет размер.  Его размер всегда равен размеру списка.
* По мере добавления элементов в MyArrayList его емкость автоматически увеличивается.
* Приложение может увеличить емкость экземпляра MyArrayList перед добавлением
*  большого количества элементов с помощью операции increaseSize
*/

public class MyArrayList<E> implements List<E> {
    private int size = 0;
    private final int DEFAULTSIZE = 0;
    private Object[] array;

    /*
    Конструктор для создания экземпляра, по уполчанию создаёт массив с 0-м размером
     */
    public MyArrayList() {
        this.size = DEFAULTSIZE;
        array = new Object[size];
    }
    /*
    Конструктор для создания класса,
    @param - int размер массива
     */
    public MyArrayList(int size) {
        this.size = size;
        array = new Object[size];
    }
    /*Конструктор для создания класса
    @param - Object[] array
     */
    public MyArrayList(Object[] array){
        this.array = array;
        this.size = array.length;

    }
    /*
    Метод расширает размер массива
    @param - int increaseTo
    Увеличивает массив на переданное значение
     */
    private void increaseSize(int increaseTo){
        int previousSize = size;
        size = size + increaseTo;
        Object[] newArray = new Object[size];
        for (int i = 0; i < previousSize; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }
/*
Метод возвращает размер текущего массива
@return - int size
 */
    @Override
    public int size() {
        return this.size;
    }
/*
Проверка массива на пустоту
@return - boolean
 */
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }
    /*
    Поиск наличия элемента в массиве
    @param - Object o необходимый элемент
    @return - boolean, true - при наличии значени
     */
    @Override
    public boolean contains(Object o) {
        for (Object el: array) {
            if (el == o){
                return true;
            }
        }
        return false;
    }
    /*
    Итератор для прохождения по массиву
    @return Iterator
     */
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new myArrayIterator<>(array);
    }
    /*
     Основная логика создания итератора
     */
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
    /*
    Метод возвращает основной массив
    @return - Object[]
     */
    @Override
    public Object[] toArray() {
        return this.array;
    }
/*
Метод добавления элемента в конец колекции
@return - boolean, true при удачном добавлении
 */
    @Override
    public boolean add(Object o) {
        increaseSize(1); // Увеличение размера на 1
        array[size-1] = o; // Перемещение объекта в конец массива
        return true;
    }
    /*
    Метод снижения размера массива до минимума (убирает null элементы в конце массива),
    для экономии места в памяти.
     */
    protected void treamToSize(){
        array = Arrays.copyOfRange(array,0,size);
    }

    /*
    Метод сдвига всего массива на 1 шаг влево.
    @param - int, принимает индекс элемента, который необходимо удалить
     */
    protected void shiftToLeft(int indexOfRemove){
        size--;
        System.arraycopy(array, indexOfRemove + 1, array, indexOfRemove, size - indexOfRemove);
        array[size] = null;
        treamToSize();
    }

    /*
    Метод удаления объекта
    @param - Object o, ообъект для удаления
    @raturn - boolean, true при удачном удалении
     */
    @Override
    public boolean remove(Object o) {
        if(size == 0){return false;}
        int i;
        for (i = 0; i < size; i++) {
            if (array[i].equals(o)){ // Проверка на наличие объекта
                break;
            }
        }
        if (i < size){
            shiftToLeft(i);// логика удаления
            return true;
        }
        return false;
    }
/*
Метод добавления в конец массива коллекции
@param - Collection c, коллекция для добавления
@raturn - boolean, true при удачном удалении
 */
    @Override
    public boolean addAll(Collection c) {
        for (Object el: c) {
            add(el);// Вызов добавления одного элемента
        }
        return true;
    }
/*
Метод добавления коллекции по индексу, со сдвигом массива влево
@param - int index, Collection c
@return - boolean true при удачном удалении
 */
    @Override
    public boolean addAll(int index, Collection c) {
        Object[] lastPartOfArray = new Object[size - index];// Переменная для правой части массива
        System.arraycopy(array, index, lastPartOfArray, 0 , size-index); // Создание копии правой части
        size = index;// Снижение длинны массива т.к. метод add() добавляет +1 к size при каждой итерации
        for (Object el: c) {
            add(el); // Добавление всех элементов по одному в коллекцию
        }
        addAll(List.of(lastPartOfArray)); // Рекурсивно добавление правой части (глубина рекурсии - 1)

        return true;
    }
/*Метод полной очистки массива
 */
    @Override
    public void clear() {
        array = null;
    }
    /*
    Метод получения значения по интексу
    @param - int index
    @return - E
     */
    @Override
    public E get(int index) {
         return (E) array[index];
    }
/*
Метод замены элемента по индексу, и возврата старого значения
@param - int index (Индекс элемента для замены) Object element (Новый элемент)
@return - Object - Старое значение
 */
    @Override
    public Object set(int index, Object element) {
        Object removedElement = array[index];
        array[index] = element;
        return removedElement;
    }
/*
Метод добавления элемента по индексу, со сдвигом вправо
@param - int index (Индекс элемента для замены) Object element (Новый элемент)

 */
    @Override
    public void add(int index, Object element) {
        Object[] lastPartOfArray = new Object[size - index]; // Переменная для правой части массива
        System.arraycopy(array, index, lastPartOfArray, 0 , size-index);// Создание копии правой части
        size = index;// Снижение длинны массива т.к. метод add() добавляет +1 к size при каждой итерации
        add(element);
        addAll(List.of(lastPartOfArray));// Рекурсивно добавление правой части (глубина рекурсии - 1)
    }
/*
Метод удаления элемента по индекси и его возврат
@param - int index - Индекс нужного элемента
@return - E - Удаленный элемент
 */
    @Override
    public E remove(int index) {
            Object removedObject;
            removedObject = array[index];
            shiftToLeft(index);
            return (E) removedObject;
    }
/*
Поиск по элементу 0(n), возврат первого вхождения
@param - Object o
@return - int-индекс элемента
При неудачном поиске пробрасывает RuntimeException()
 */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        throw new RuntimeException();
    }
    /*
Поиск по элементу 0(n), возврат последнего вхождения
@param - Object o
@return - int-индекс элемента
При неудачном поиске пробрасывает RuntimeException()
 */

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

    public String toString (){
        return Arrays.toString(array);
    }
}

