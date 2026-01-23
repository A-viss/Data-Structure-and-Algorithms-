public class AVLTree {
    
    static class Node {
        int data, height;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }
    
    private Node root;
    
    // Get height
    private int height(Node n) {
        return n == null ? 0 : n.height;
    }
    
    // Get balance factor
    private int getBalance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }
    
    // Right rotation
    private Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    // Left rotation
    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    // Insert
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node node, int data) {
        if (node == null) return new Node(data);
        
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        } else {
            return node;
        }
        
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        
        // Left-Left
        if (balance > 1 && data < node.left.data) {
            return rotateRight(node);
        }
        
        // Right-Right
        if (balance < -1 && data > node.right.data) {
            return rotateLeft(node);
        }
        
        // Left-Right
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        
        // Right-Left
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        
        return node;
    }
    
    // Delete
    public void delete(int data) {
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node node, int data) {
        if (node == null) return null;
        
        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            
            Node temp = minNode(node.right);
            node.data = temp.data;
            node.right = deleteRec(node.right, temp.data);
        }
        
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        
        // Left-Left
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        
        // Left-Right
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        
        // Right-Right
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }
        
        // Right-Left
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        
        return node;
    }
    
    private Node minNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    // Search
    public boolean search(int data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node node, int data) {
        if (node == null) return false;
        if (data == node.data) return true;
        return data < node.data ? searchRec(node.left, data) : searchRec(node.right, data);
    }
    
    // Inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }
}
