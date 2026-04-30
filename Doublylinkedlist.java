import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int value) {
        data = value;
        prev = null;
        next = null;
    }
}

public class DoublyLinkedList {
    static Node head = null;

    static void insertBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
        System.out.println("Inserted " + value + " at beginning.");
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
            newNode.prev = temp;
        }

        System.out.println("Inserted " + value + " at end.");
    }

    static void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        System.out.println("Deleted from beginning");
    }

    static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }

        System.out.println("Deleted from end");
    }

    static void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Current List: ");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, value;
        boolean running = true;

        while (running) {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert Beginning");
            System.out.println("2. Insert End");
            System.out.println("3. Delete Beginning");
            System.out.println("4. Delete End");
            System.out.println("5. Display List");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Value: ");
                    value = sc.nextInt();
                    insertBeginning(value);
                    displayForward();
                    break;

                case 2:
                    System.out.print("Value: ");
                    value = sc.nextInt();
                    insertEnd(value);
                    displayForward();
                    break;

                case 3:
                    deleteBeginning();
                    displayForward();
                    break;

                case 4:
                    deleteEnd();
                    displayForward();
                    break;

                case 5:
                    displayForward();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
