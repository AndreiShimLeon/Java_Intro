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
        int[] arr = new int[10];
        for (int i = 0; i < Short.MAX_VALUE; i++) {

        }




    }
}