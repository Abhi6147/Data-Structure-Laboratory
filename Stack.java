import java.util.Scanner;

public class StackProgram {
    static int[] stack = new int[100];
    static int top = -1;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, x;

        System.out.print("Enter size of stack: ");
        size = sc.nextInt();

        do {
            System.out.println("\n1.Push\n2.Pop\n3.Top\n4.isEmpty\n5.isFull\n6.Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            if (ch == 1) {
                if (top == size - 1)
                    System.out.println("Stack Full");
                else {
                    System.out.print("Enter element: ");
                    x = sc.nextInt();
                    top++;
                    stack[top] = x;
                }
            } 
            else if (ch == 2) {
                if (top == -1)
                    System.out.println("Stack Empty");
                else {
                    System.out.println("Deleted element " + stack[top]);
                    top--;
                }
            } 
            else if (ch == 3) {
                if (top == -1)
                    System.out.println("Stack Empty");
                else
                    System.out.println("Top element " + stack[top]);
            } 
            else if (ch == 4) {
                if (top == -1)
                    System.out.println("Stack is Empty");
                else
                    System.out.println("Stack is Not Empty");
            } 
            else if (ch == 5) {
                if (top == size - 1)
                    System.out.println("Stack is Full");
                else
                    System.out.println("Stack is Not Full");
            }

        } while (ch != 6);
    }
            }
