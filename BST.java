package ClassroomAssingment;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;
        private List<Value>list;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.list = new LinkedList<>();
        }
    }
    public BST() {
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public List<Value> get(Key key) {
        return get(root, key);
    }

    private List<Value> get(Node root, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        List<Value>list;
        if     (cmp < 0) {
            return get(root.left, key);
        }
        else if (cmp > 0) {
            return get(root.right, key);
        }
        else {
            if (root.list.isEmpty()){
                list = Collections.singletonList(root.val);
            }else {
                list = new LinkedList<>();
            }
            for (int i = 0; i<root.list.size();i++){
                list.add(root.list.get(i));
            }

        }
        return list;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        root = put(root, key, val);


    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else              return size(x.left);
    }
}
