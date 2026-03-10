public class QueueProgram {
    static int[] queue = new int[5];
    static int front = -1, rear = -1;

    static void enqueue(int x) {
        if (rear == 4)
            System.out.println("Queue Full");
        else {
            if (front == -1) front = 0;
            queue[++rear] = x;
        }
    }

    static void dequeue() {
        if (front == -1 || front > rear)
            System.out.println("Queue Empty");
        else
            front++;
    }

    static void display() {
        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        enqueue(60);
        enqueue(70);
        display();

        dequeue();
        display();
    }
}
