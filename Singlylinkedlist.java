import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

public class LinkedListProgram {
    static Node head = null;

    static void insertBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println(">> Inserted " + value + " at the beginning.");
    }

    static void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println(">> Inserted " + value + " at the end.");
    }

    static void deleteBeginning() {
        if (head == null) {
            System.out.println("!! List is already empty.");
            return;
        }
        head = head.next;
        System.out.println(">> Deleted the first node.");
    }

    static void deleteEnd() {
        if (head == null) {
            System.out.println("!! List is already empty.");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        System.out.println(">> Deleted the last node.");
    }

    static void search(int key) {
        Node temp = head;
        int pos = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println(">> Found " + key + " at position " + pos + ".");
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println(">> " + key + " not found in the list.");
    }

    static void display() {
        if (head == null) {
            System.out.println("Current List: (Empty)");
            return;
        }

        Node temp = head;
        System.out.print("Current List: ");
        while (temp != null) {
            System.out.print("[" + temp.data + "] -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\n1. Insert (Start)");
            System.out.println("2. Insert (End)");
            System.out.println("3. Delete (Start)");
            System.out.println("4. Delete (End)");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Value to insert: ");
                    value = sc.nextInt();
                    insertBeginning(value);
                    display();
                    break;

                case 2:
                    System.out.print("Value to insert: ");
                    value = sc.nextInt();
                    insertEnd(value);
                    display();
                    break;

                case 3:
                    deleteBeginning();
                    display();
                    break;

                case 4:
                    deleteEnd();
                    display();
                    break;

                case 5:
                    System.out.print("Value to search: ");
                    value = sc.nextInt();
                    search(value);
                    break;

                case 6:
                    display();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
