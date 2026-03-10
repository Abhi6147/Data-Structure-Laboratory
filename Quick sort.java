import java.util.*;

public class QuickSort {
    static void quickSort(int[] a, int l, int h) {
        if (l < h) {
            int p = partition(a, l, h);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, h);
        }
    }

    static int partition(int[] a, int l, int h) {
        int pivot = a[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (a[j] <= pivot) {
                i++;
                int t = a[i]; a[i] = a[j]; a[j] = t;
            }
        }
        int t = a[i + 1]; a[i + 1] = a[h]; a[h] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = {10,7,8,9,1,5};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
