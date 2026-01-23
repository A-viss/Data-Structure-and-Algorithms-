public class BinarySearchTree {
    
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    private Node root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    // Insert a value
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    // Search for a value
    public boolean search(int data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node root, int data) {
        if (root == null) return false;
        if (data == root.data) return true;
        
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }
    
    // Delete a value
    public void delete(int data) {
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node root, int data) {
        if (root == null) return null;
        
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node found - handle deletion
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // Two children - replace with inorder successor
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        
        return root;
    }
    
    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    
    // Inorder traversal (sorted order)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    
    // Preorder traversal
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }
    
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    
    // Postorder traversal
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }
    
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    // Tree height
    public int height() {
        return heightRec(root);
    }
    
    private int heightRec(Node root) {
        if (root == null) return 0;
        return Math.max(heightRec(root.left), heightRec(root.right)) + 1;
    }
    
    // Count nodes
    public int countNodes() {
        return countNodesRec(root);
    }
    
    private int countNodesRec(Node root) {
        if (root == null) return 0;
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
}
