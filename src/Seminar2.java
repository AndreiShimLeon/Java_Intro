import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

public class Seminar2 {
    public static void main(String[] args) {
//        String s = "Hello world!";
//        s+= "!";
//        int index = s.indexOf("H");
//        String[] sa = s.split(" ");
//
//        byte[] b = s.getBytes();
//
//        String message = "Всем привет ";
//        StringBuilder builder = new StringBuilder(message);
//        builder.append("как как вот так").append(" Hello World");//.reverse();
////        System.out.println(builder);
//
//        s = builder.toString();
//
//        // работа с файлами - import java.io.* - выгружаем все классы из библиотеки
//        //
//        try {
//            FileWriter fw = new FileWriter("file.txt"); // если поставить вторым параметром true, то будет дозапись, если файл существует
//            fw.write(s);
//            fw.close(); //
//
//            FileReader fr = new FileReader("file.txt");
//            int c;
//            while ((c = fr.read())!= -1){
//                System.out.print((char)c);
//            }
//            fr.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        // создать две строки, если первая строка входит во вторую, то вывести индекс этой строки. Если несколько раз - несколько индексов
//        String first = "123";
//        String second = "51234 551234 53452 234523 411241 23145 1234123";
////        System.out.println(second.indexOf("first")); // находим первое вхождение
//        int temp = 0;
//        while (second.indexOf(first, temp) != -1) { // second.indexOf(first, temp) != -1 - проверка на тот случай, если она отсутствует
//            System.out.println(second.indexOf(first, temp));
//            temp = second.indexOf(first, temp) + 1; // индекс, с которого начинаем искать в следующей итерации
//        }

        // создать две строки, если вторая является реверсом первой, вывести ОК.
        String first = "123";
        String second = "321";
//        StringBuilder builder = new StringBuilder(second);
        if(new StringBuilder(second).reverse().toString().equals(first)){ // создали анонимный объект. После проверки условия он будет удален.
//        if(builder.reverse().toString().equals(first)){
            System.out.println("OK");
        }
        // в строке 3 + 56 = 59 заменить "=" на "равно" средствами String и StringBuilder
        String equation = "3 + 56 = 59";
        System.out.println(equation);
        equation = equation.replace("=", "равно");
        System.out.println(equation);
        System.out.println("-".repeat(20));
        StringBuilder newEquation = new StringBuilder("3 + 56 = 59");
        System.out.println(newEquation);
        newEquation.replace(newEquation.indexOf("="), newEquation.indexOf("=")+1, "РАВНО");
        System.out.println(newEquation);

        // измерить скорость, с которой String заменяет все элементы в строке другим элементом. Сравнить со StringBuilder
        // измерить скорость добавления 1000 элементов к строке и к StringBuilder
//         String line = "";
//         long start = System.currentTimeMillis();
//        for (int i = 0; i < 90000; i++) {
//            line+= Character.getName(i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.printf("%d - string \n", end-start);
//
//        start = System.currentTimeMillis();
//        StringBuilder builder = new StringBuilder("");
//        for (int i = 0; i < 90000; i++) {
//            builder.append(Character.getName(i));
//        }
//        end = System.currentTimeMillis();
//        System.out.printf("%d - builder\n", end-start);

        // сравнить время replace в строке и билдере как минимум 10 элементов
        // показываем, что replace у строки работает в тысячи раз быстрее, чем у SB

        String line = "11111111111111111";
        line = line.repeat(2);
        long start = System.currentTimeMillis();
        line.replace("1","2");
        long end = System.currentTimeMillis();
        System.out.printf("%d - string \n", end-start);

        start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder(line);
        for (int i = 0; i < builder.length(); i++) {
            builder.replace(i, i+1, "3");
        }
        end = System.currentTimeMillis();
        System.out.printf("%d - builder\n", end-start);
        System.out.println(builder);




    }
}
