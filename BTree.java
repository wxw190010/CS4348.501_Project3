import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTree{
    
    private BTreeNode root;
    
    //Initialize constants 
    private static final int MIN_DEGREE = 10;
    private static final int MAX_KEYS = 2 * MIN_DEGREE - 1;
    private static final int MAX_CHILDREN = 2 * MIN_DEGREE;
    
    //Constructor for B-Tree makes root a leaf node
    public BTree(){
        this.root = new BTreeNode(true);
    }

    //Insert a key-value pair into the B-Tree
    public void insert(int key, int value) {
        BTreeNode rootNode = root;

        //If root is full, split it
        if(rootNode.numKeys == MAX_KEYS){
            BTreeNode leafNode = new BTreeNode(false);
            leafNode.children.add(rootNode);
            leafNode.splitChild(0, rootNode);
            root = leafNode;
            root.insertNonFull(key, value);
        } 
        else{
            rootNode.insertNonFull(key, value);
        }
    }

    //Search for a key in B-Tree
    public int search(int key) {
        return root.search(key);
    }

    //Print all key-value pairs in B-Tree 
    //Uses in-order traversal
    public void print() {
        root.print();
    }

    //Extract all key-value pairs as a list of "key,value" strings
    public List<String> extractAll() {
        return root.extractAll();
    }



    //BTreeNode Class
    private static class BTreeNode {
        //Initialize variables and lists
        int numKeys;
        boolean isLeaf;
        List<Integer> keys;
        List<Integer> values;
        List<BTreeNode> children;

        //Constructor
        public BTreeNode(boolean isLeaf) {
            this.isLeaf = isLeaf;
            this.keys = new ArrayList<>(Collections.nCopies(MAX_KEYS, 0));
            this.values = new ArrayList<>(Collections.nCopies(MAX_KEYS, 0));
            this.children = new ArrayList<>(Collections.nCopies(MAX_CHILDREN, null));
            this.numKeys = 0;
        }

        //Insert a key-value pair into a node that is not full
        public void insertNonFull(int key, int value) {
            int i = numKeys - 1;

            if (isLeaf) {
                //Insert key in the correct position
                while (i >= 0 && key < keys.get(i)) {
                    keys.set(i + 1, keys.get(i));
                    values.set(i + 1, values.get(i));
                    i--;
                }
                keys.set(i + 1, key);
                values.set(i + 1, value);
                numKeys++;
            } else {
                //Find the child to insert the key into
                while (i >= 0 && key < keys.get(i)) {
                    i--;
                }
                i++;
                if (children.get(i).numKeys == MAX_KEYS) {
                    splitChild(i, children.get(i));
                    if (key > keys.get(i)) {
                        i++;
                    }
                }
                children.get(i).insertNonFull(key, value);
            }
        }

        //Split child at index i
        public void splitChild(int i, BTreeNode y) {
            BTreeNode z = new BTreeNode(y.isLeaf);
            z.numKeys = MIN_DEGREE - 1;

            //Move the last (t - 1) keys and values from y to z
            for (int j = 0; j < MIN_DEGREE - 1; j++) {
                z.keys.set(j, y.keys.get(j + MIN_DEGREE));
                z.values.set(j, y.values.get(j + MIN_DEGREE));
            }

            if (!y.isLeaf) {
                for (int j = 0; j < MIN_DEGREE; j++) {
                    z.children.set(j, y.children.get(j + MIN_DEGREE));
                }
            }

            y.numKeys = MIN_DEGREE - 1;

            //Insert z as child of node
            children.add(i + 1, z);
            keys.add(i, y.keys.get(MIN_DEGREE - 1));
            values.add(i, y.values.get(MIN_DEGREE - 1));
            numKeys++;
        }

        //Search for a key in subtree rooted at node
        public int search(int key) {
            int i = 0;

            //Find key in current node
            while (i < numKeys && key > keys.get(i)) {
                i++;
            }

            //If the key is found, return its value
            if (i < numKeys && key == keys.get(i)) {
                return values.get(i);
            }

            //If leaf node, key does not exist
            if (isLeaf) {
                return -1;
            }

            return children.get(i).search(key);
        }

        //Print B-Tree 
        //In in-order traversal
        public void print() {
            int i;
            for (i = 0; i < numKeys; i++) {
                if (!isLeaf) {
                    children.get(i).print();
                }
                System.out.println(keys.get(i) + " -> " + values.get(i));
            }
            if (!isLeaf) {
                children.get(i).print();
            }
        }

        //Extract all key-value pairs as a list of "key,value" strings
        public List<String> extractAll() {
            List<String> result = new ArrayList<>();
            int i;
            for (i = 0; i < numKeys; i++) {
                if (!isLeaf) {
                    result.addAll(children.get(i).extractAll());
                }
                result.add(keys.get(i) + "," + values.get(i));
            }
            if (!isLeaf) {
                result.addAll(children.get(i).extractAll());
            }
            return result;
        }
    }
}
