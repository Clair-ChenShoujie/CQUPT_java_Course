class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = insertRecursive(root, value);
    }

    Node insertRecursive(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data)
            root.left = insertRecursive(root.left, value);
        else if (value > root.data)
            root.right = insertRecursive(root.right, value);
        return root;
    }

    void delete(int value) {
        root = deleteRecursive(root, value);
    }

    Node deleteRecursive(Node root, int value) {
        if (root == null)
            return root;

        if (value < root.data)
            root.left = deleteRecursive(root.left, value);
        else if (value > root.data)
            root.right = deleteRecursive(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);

            root.right = deleteRecursive(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    void inorder() {
        inorderRecursive(root);
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }
}
