import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Lection_1{

    /*
    Первая лекция по Java от Камянецкого.
        1. Задана натуральная степень k. Сформировать случайным
    образом список коэффициентов (значения от 0 до 100)
    многочлена многочлен степени k.
    *Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0
        2. Даны два файла, в каждом из которых находится запись
    многочлена. Сформировать файл содержащий сумму
    многочленов.
     */

    public static String Polynom(int k){
        Random random = new Random();
        String result = "";
        for (int i = k; i >= 0; i--) {
            int C = random.nextInt(100);
            if (C != 0) {
                if (i == 0) result += String.format("%d", C);
                else result += String.format("%d*x^%d + ", C, i);
            }
        }
        result+= " = 0";
        return result;
    }

    public static Integer Input_int(String message){
        Scanner iScanner = new Scanner(System.in);
        System.out.println(message);
        int input = iScanner.nextInt();
        iScanner.close();
        return input;
    }
    public static void main(String[] args) {
//        int k = Input_int("Введите степень многочлена: ");
//        String res = Polynom(k);
//        System.out.println(res);
        int [] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        for (int item : arr) {
            System.out.print(item + " ");
        }

        try (FileWriter fw = new FileWriter("polynom#1.txt", false)) {
            fw.write(Polynom(random.nextInt(10)));
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileWriter fw = new FileWriter("polynom#2.txt", false)) {
            fw.write(Polynom(random.nextInt(10)));
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }



    }
}