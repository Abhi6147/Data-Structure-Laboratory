import java.util.*;

public class SearchProgram {

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, target, choice;

        System.out.print("Enter the number of elements: ");
        n = sc.nextInt();

        int[] data = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        System.out.print("\nEnter the number to search for: ");
        target = sc.nextInt();

        System.out.println("\nChoose search method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search (Will sort array first)");
        System.out.print("Choice: ");
        choice = sc.nextInt();

        int index = -1;

        if (choice == 1) {
            index = linearSearch(data, target);
        } 
        else if (choice == 2) {
            Arrays.sort(data);

            System.out.print("\nSorted array for Binary Search: ");
            for (int x : data) {
                System.out.print(x + " ");
            }
            System.out.println();

            index = binarySearch(data, target);
        } 
        else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }

        sc.close();
    }
}
