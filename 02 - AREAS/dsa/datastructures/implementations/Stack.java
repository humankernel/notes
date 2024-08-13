import java.util.Iterator;

// using singly linkedList
public class Stack <T> implements Iterable <T> {

    private int size = 0;
    private Node <T> head;

    class Node <T> {
        public T data;
        public Node <T> prev;

        public Node(T data, Node<T> prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    public Stack(){}

    public int size(){return size;}
    public boolean isEmpty(){return size() > 0;}

    public void push(T value){
        if (isEmpty())
            head = new Node(value, null);
        else
            head = new Node<T>(value, head);
        size++;
    }

    public T pop(){
        if (isEmpty())
            throw new RuntimeException("stack is empty");

        T value = head.data;
        head = head.prev;
        size--;

        return value;
    }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override public boolean hasNext() {return size > 1;}
            @Override public T next() {return pop();}
        };
    }
}
