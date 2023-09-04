import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Arrays;

public class Train {

    public static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    public static void heapSort(int[] array){
        for (int i = array.length/2-1; i >= 0 ; i--) {
            heapify(array,i, array.length);
        }

        for (int i = array.length-1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array,0,i);
        }
    }

    public static void heapify(int[] array, int index, int size){
        int leftChild = index*2 + 1;
        int rightChild = index*2 +2;
        if(rightChild < size && array[rightChild] > array[index]){
            swap(array, rightChild, index);
            heapify(array, rightChild, size);
        }
        if(leftChild < size && array[leftChild] > array[index]){
            swap(array, leftChild, index);
            heapify(array, leftChild, size);
        }
    }
    public static void main(String[] args)  {
        int[] array = {1,6,7,234,57,7,8,2,34,6,7,2345,1,3};
        System.out.println("Origin array: ");
        for (int item: array
             ) {
            System.out.print(item);
            System.out.print(" ");
        }
        heapSort(array);
        System.out.println("\nSorted array: ");
        for (int item: array
        ) {
            System.out.print(item);
            System.out.print(" ");
        }

        // Seminar3 - САКОД


    }
}