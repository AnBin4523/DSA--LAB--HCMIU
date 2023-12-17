// -------------------------------------------------------------
// Representing arithmetic expressions by binary tree
// CS 501 
// Zdravko Markov
// -------------------------------------------------------------
public class Tree {
    public static boolean areIdentical(Node t1, Node t2) {
        // if both trees are empty, they are identical
        if (t1 == null && t2 == null) {
            return true;
        }

        return (t1 != null && t2 != null) &&
                (t1.value == t2.value) &&
                areIdentical(t1.leftChild, t2.leftChild) &&
                areIdentical(t1.rightChild, t2.rightChild);
    }

    public static void main(String[] args) {
        Node a1 = node(2);
        Node b1 = node(3);
        Node c1 = node('+', a1, b1);
        Node d1 = node(5);
        Node e1 = node(1);
        Node f1 = node('-', d1, e1);
        Node g1 = node('*', c1, f1);
        Node h1 = node(8);
        Node i1 = node('/', g1, h1);

        System.out.println("First Tree:");
        showTree(0, i1);

        // Construct the second tree
        Node a2 = node(2);
        Node b2 = node(3);
        Node c2 = node('+', a2, b2);
        Node d2 = node(5);
        Node e2 = node(1);
        Node f2 = node('-', d2, e2);
        Node g2 = node('*', c2, f2);
        Node h2 = node(8);
        Node i2 = node('/', g2, h2);

        System.out.println("\nSecond Tree:");
        showTree(0, i2);

        boolean result = areIdentical(i1, i2);
        System.out.println("Are the trees identical? " + result);
    }

    // -------------------------------------------------------------
    public static Node node(char op, Node l, Node r) {
        Node a = new Node();
        a.operation = op;
        a.leftChild = l;
        a.rightChild = r;
        return a;
    }

    // -------------------------------------------------------------
    public static Node node(int val) {
        Node a = new Node();
        a.value = val;
        return a;
    }

    // -------------------------------------------------------------
    public static void prefix(Node t) {
        if (t.leftChild == null && t.rightChild == null)
            System.out.print(t.value + " ");
        else {
            System.out.print(t.operation + " ");
            prefix(t.leftChild);
            prefix(t.rightChild);
        }
    }

    // -------------------------------------------------------------
    public static void postfix(Node t) {
        if (t.leftChild == null && t.rightChild == null)
            System.out.print(t.value + " ");
        else {
            postfix(t.leftChild);
            postfix(t.rightChild);
            System.out.print(t.operation + " ");
        }
    }

    // -------------------------------------------------------------
    public static void infix(Node t) {
        if (t.leftChild == null && t.rightChild == null)
            System.out.print(t.value);
        else {
            System.out.print("(");
            infix(t.leftChild);
            System.out.print(t.operation);
            infix(t.rightChild);
            System.out.print(")");
        }
    }

    // -------------------------------------------------------------
    public static double eval(Node t) {
        double val = 0;
        if (t.leftChild == null && t.rightChild == null)
            val = t.value;
        else
            switch (t.operation) {
                case '+':
                    val = eval(t.leftChild) + eval(t.rightChild);
                    break;
                case '-':
                    val = eval(t.leftChild) - eval(t.rightChild);
                    break;
                case '*':
                    val = eval(t.leftChild) * eval(t.rightChild);
                    break;
                case '/':
                    val = eval(t.leftChild) / eval(t.rightChild);
            }
        return val;
    }

    // -------------------------------------------------------------
    public static void showTree(int n, Node t) {
        tab(n);
        if (t.leftChild == null && t.rightChild == null)
            System.out.println(t.value);
        else {
            System.out.println(t.operation);
            showTree(n + 2, t.leftChild);
            showTree(n + 2, t.rightChild);
        }
    }

    // -------------------------------------------------------------
    public static void tab(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");
    }
}
// -------------------------------------------------------------

class Node {
    char operation;
    int value;
    Node leftChild;
    Node rightChild;
}