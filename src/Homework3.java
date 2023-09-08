import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Homework3 {

    class MergeSort {

        public static int[] buffer = new int[100000];

        public static int[] mergeSort(int[] array) {
            if (array.length > 1) {
                MSort(array, 0, array.length - 1);
            }
            return array;
        }

        public static void MSort(int[] array, int left, int right) {
            if (left == right) {
                return;
            }
            int mid = (left + right) / 2;
            MSort(array, left, mid);
            MSort(array, mid + 1, right);
            int left_index = left, right_index = mid + 1, counter = left;
            while (left_index <= mid && right_index <= right) {
                if (array[left_index] < array[right_index]) {
                    buffer[counter++] = array[left_index++];
                } else {
                    buffer[counter++] = array[right_index++];
                }
            }
            while (left_index <= mid) {
                buffer[counter++] = array[left_index++];
            }
            while (right_index <= right) {
                buffer[counter++] = array[right_index++];
            }
            for (int i = left; i <= right; i++) {
                array[i] = buffer[i];
            }

        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 6, 2, 3, 4};
        int[] result = MergeSort.mergeSort(a);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}
