public class BinarySearchTree<T extends Comparable<T>> {

    private Node root = null;
    private int size = 0;

    private class Node {
        T data;
        Node left, right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T elem) {
        // no duplicates
        if (contains(elem))
            return false;

        root = add(root, elem);
        size++;
        return true;
    }

    private Node add(Node node, T elem) {
        if (node == null)
            return new Node(elem, null, null);

        if (elem.compareTo(node.data) < 0)
            node.left = add(node.left, elem);
        else
            node.right = add(node.right, elem);

        return node;
    }

    public boolean remove(T elem) {
        if (!contains(elem))
            return false;

        root = remove(root, elem);
        size--;
        return true;
    }

    private Node remove(Node node, T elem) {
        if (node == null) return null;

        int cmp = elem.compareTo(node.data);
        if (cmp < 0) //recursive left
            node.left = remove(node.left, elem);
        else if (cmp > 0) //recursive right
            node.right = remove(node.right, elem);
        else {
            if (node.left == null && node.right == null)
                return null;
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            //change node with leftmost of right
            //remove leftmost of right
            Node leftMost = leftmostNode(node.right);
            node.data = leftMost.data;
            node.right = remove(node.right, leftMost.data);
        }

        return node;
    }

    private Node leftmostNode(Node node) {
        if (node.left == null)
            return node;
        return leftmostNode(node.left);
    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem) {
        if (node == null) return false;

        int cmp = elem.compareTo(node.data);
        if (cmp < 0)
            return contains(node.left, elem);
        if (cmp > 0)
            return contains(node.right, elem);
        return true;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

}