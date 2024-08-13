public class UnionFind {

    // number of elements
    private int size;

    //used to track the sizes of each components
    private int[] sz;

    // parent[i] points to the parent of i
    // if id[i] == i then i is a root node
    private int[] parent;

    // number of components
    private int numComponents;

    public UnionFind(int size) throws IllegalAccessException {
        if (size <= 0)
            throw new IllegalAccessException();
        this.size = numComponents = size;
        sz = new int[size];
        parent = new int[size];

        for (int i=0; i< size; i++){
            parent[i] = i; //link to itself (self root)
            sz[i] = 1;     //each component is originally of size one
        }
    }

    // find which component/set 'p' belongs to
    public int find(int p){

        // find the root of the component/set
        int root = p;
        while (root != parent[root])
            root = parent[root];

        // compress the path leading back to the root.
        // doing this operation is called "path-compression"
        // this is what gives us amortized constant time complexity
        while (p != root){
            int next = parent[p];
            parent[p] = root;
            p = next;
        }

        return root;
    }

    // return whether the elements 'p' and 'q' are in the same components/set
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    // return the size of the components/set 'p' belongs to
    public int componentSize(int p){
        return sz[find(p)];
    }

    // return the number of elements in the UnionFind/Disjoint set
    public int size() {return size;}
    // return the number of remaining components/set
    public int components() {return numComponents;}

    public void union(int p, int q){

        int root1 = find(p);
        int root2 = find(q);
        // if (root1 == root2) return;
        if ( connected(p,q) ) return;

        // merge two components/sets together
        // smaller into larger one
        if ( sz[root1] < sz[root2] ){
            sz[root2] += sz[root1]; //only update the larger one
            parent[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            parent[root2] = root1;
        }

        // since the roots found are different and know connected to each other
        // know the number of components/set has decreased by one
        numComponents--;
    }
}
