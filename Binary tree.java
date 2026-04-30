import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    static Scanner sc = new Scanner(System.in);

    static Node buildTree() {
        int val = sc.nextInt();

        if (val == -1) {
            return null;
        }

        Node newNode = new Node(val);

        System.out.print("Enter left child of " + val + " (-1 for none): ");
        newNode.left = buildTree();

        System.out.print("Enter right child of " + val + " (-1 for none): ");
        newNode.right = buildTree();

        return newNode;
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        System.out.print("Enter root value: ");
        Node root = buildTree();

        System.out.print("Pre-order:  ");
        preorder(root);
        System.out.println();

        System.out.print("In-order:   ");
        inorder(root);
        System.out.println();

        System.out.print("Post-order: ");
        postorder(root);
        System.out.println();

        sc.close();
    }
}
