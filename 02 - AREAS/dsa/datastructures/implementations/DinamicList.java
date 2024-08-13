import java.util.Iterator;

interface List <T> {
    public int size();
    public T get(int index);
    public void add(T elem);
    public void set(int index, T elem);
    public T removeAt(int index);
}

@SuppressWarnings("unchecked")
public class DynamicArray <T>  implements List<T>, Iterable <T> {
    private T [] arr;
    private int len=0; //length user thinks array is
    private int capacity = 0; // actual array size

    // constructor
    public DynamicArray() throws IllegalAccessException {this(16);}
    public DynamicArray(int capacity) throws IllegalAccessException {
        if (capacity < 0) throw new IllegalAccessException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {return len;}
    public boolean isEmpty() {return size() == 0;}

    // O(1)
    public T get(int index) {return arr[index];}
    public void set(int index, T elem) {arr[index] = elem;}

    // O(n)
    public void clear() {
        for (int i=0; i< capacity; i++)
            arr[i] = null;
        len = 0;
    }
    // O(n)
    public void add(T elem) {
        // Time to resize!
        if (len+1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *=2; //double the size

            // create new array
            T[] new_arr = (T[]) new Object[capacity];
            for (int i=0; i<len; i++)
                new_arr[i] = arr[i];
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    // O(n)
    public T removeAt(int index) {
        if (index >= len && index < 0) throw new IndexOutOfBoundsException();
        T data = arr[index];
        T[] new_arr = (T[]) new Object[len-1];
        for (int i=0, j=0; i<len; i++, j++){
            if (i == index) j--;  // skip over index by fixing j temp
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    // O(n)
    public boolean remove(Object obj){
        for (int i=0; i<len; i++){
            if (arr[i].equals(obj))  {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // O(n)
    public int indexOf(Object obj) {
        for (int i=0; i<len; i++)
            if (arr[i].equals(obj)) return i;
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index=0;
            public boolean hasNext() { return index < len; }
            public T next() { return arr[index++];}
        };
    }
}
