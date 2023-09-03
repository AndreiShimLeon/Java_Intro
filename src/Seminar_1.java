import java.util.Arrays;
import java.util.Random;

public class Seminar_1 {

    public static int rightBitRandomNumber(){
        Random random = new Random();
        int number = random.nextInt(0,2001);
        System.out.println(number);
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toBinaryString(number).length());
        return (Integer.toBinaryString(number).length());
    }
    public static void main(String[] args) {

        // случайное число от  0 до 2000 - найти самый старший значащий бит
        // случайное число и самый старший значащий бит вывести в отдельные переменные.
        int result1 = rightBitRandomNumber();
        // сохранить в массив все элементы от нуля до максимального шорта кратные найденному номеру
        // значащего бита
        // массив не должен превышать количества кратных чисел
        int[] buf = new int[32767];
        int counter = 0;
        for (int i = 0; i < Short.MAX_VALUE; i++) {
            if(i%result1 == 0){
                buf[counter] = i;
                counter++;
            }
        }
        int []result2 = new int[counter];
//        for (int i = 0; i < result2.length; i++){
//            result2[i] = buf[i];
//        }
        System.arraycopy(buf, 0, result2, 0, result2.length);

        System.out.println(result2.length);
//        for (int item: result2
//             ) {
//            System.out.print(item);
//            System.out.print(" ");
//        }
//        System.out.println(Arrays.toString(result2));
        // от минимального шорта до нуля, сохраняем все некратные
        
        counter = 0;
        for (int i = 0; i > Short.MIN_VALUE; i--) {
            if(i%result1 != 0) counter++;
        }
        int []result3 = new int[counter];
        counter = 0;
        for (int i = 0; i > Short.MIN_VALUE; i--) {
            if (i%result1 != 0) result3[counter++] = i;
        }
//        System.out.println(Arrays.toString(result3));
        // арифметическая прогрессия от 0 до result1
        int progression = 0;
        for (int i = 0; i < result1; progression+= i++) {
        }
        System.out.println(progression);
        // цикл в котором вы будете прохродить от начала до середины массива
        // и от конца до середины и по очереди выводить значения
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        for (int i = 0; i < arr.length/2; i++) {
//            System.out.println(i);
//        }
//        for(int i = arr.length-1; i >= arr.length/2; i--){
//            System.out.println(i);
//        }
        int counter2 = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length/2) System.out.println(arr[i]);
            else{
                System.out.println(arr[counter2--]);
            }
        }

    }
}