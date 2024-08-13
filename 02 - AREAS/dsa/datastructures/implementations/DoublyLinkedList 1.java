import java.util.Iterator;

public class DoublyLinkedList <T> implements Iterable <T> {

    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;

    // internal node class to represent data
    private class Node <T> {
        T data;
        Node <T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // O(n)
    public void clear() {
        Node <T> trav = head;

        while (trav != null) {
            Node <T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() { return size;}
    public boolean isEmpty() { return size() == 0; }

    // insert at front O(1)
    public void addFirst(T elem){
        if (isEmpty())
            head = tail = new Node<T>(elem, null, null);
        else {
            head.prev = new Node <T> (elem, null, head);
            head = head.prev; //the link to the old head it doesn't lose
        }
        size++;
    }
    // insert at back O(1)
    public void addLast(T elem){
        if (isEmpty())
            head = tail = new Node<T>(elem, null, null);
        else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // remove first O(1)
    public T removeFirst(){
        if (isEmpty()) throw new RuntimeException("Empty list");

        // 1. take the data and move the head forwards
        T data = head.data;
        head = head.next;
        --size;
        // 2. if list is empty set the tail to null
        if (isEmpty()) tail = null;
        // 3. do a memory clean of the previous node
        else head.prev = null;

        return data;
    }
    public T removeLast(){
        if (isEmpty()) throw new RuntimeException("Empty list");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmpty()) head = null;
        else tail.next = null;

        return data;
    }

    // O(1)  (cuz you access directly, without a search)
    private T remove(Node <T> node){

        // if the node is (head|tail)
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        // join the neighbors meet each other
        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;
        node.data = null;
        node = node.prev = node.next = null;
        --size;

        return data;
    }

    // O(n)
    private T removeAt(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) throw new IllegalAccessException();

        int i;
        Node <T> trav;

        // search from the front (faster)
        if (index < size/2) {
            for (i=0, trav=head; i!=index; i++)
                trav = trav.next;
        } else { //search from the back (faster)
            for (i=size-1, trav=tail; i!=index; i--)
                trav = trav.prev;
        }
        return remove(trav);
    }

    // O(n) remove a particular value in the linked-list
    public boolean remove(Object obj){
        Node <T> trav = head;

        // support searching for null
        if (obj == null){
            for (trav=head; trav!=null; trav=trav.next){
                if (trav.data == null){
                    remove(trav);
                    return true;
                }
            }
        } else { //support for non-null object
            for (trav=head; trav!=null; trav=trav.next){
                if (trav.data.equals(obj)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // O(n) find the index of a particular value
    public int indexOf(Object obj){
        int index = 0;
        Node <T> trav;

        // Support searching for null
        if (obj == null) {
            for (trav=head; trav!=null; trav=trav.next, index++)
                if (trav.data == null)  return index;
        } else {
            for (trav=head; trav!=null; trav=trav.next, index++)
                if (trav.data.equals(obj)) return index;
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node <T> trav = head;
            @Override public boolean hasNext() {
                return trav != null;
            }
            @Override public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }
}
