import javax.naming.AuthenticationNotSupportedException;
import javax.naming.StringRefAddr;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.spi.CalendarDataProvider;

public class Homework2 {

    static class Calculator{
        public int calculate(char op, int a, int b) {
            // Введите свое решение ниже
            int result = 0;
            switch (op){
                case ('+'):
                    result = a+b;
                    break;
                case ('-'):
                    result = a - b;
                    break;
                case ('*'):
                    result = a * b;
                    break;
                case ('/'):
                    if(b == 0){
                        System.out.println("на ноль делить нельзя");
                        result = -1;
                        break;
                    } else {
                        result = a/b;
                        break;
                    }
                default:
                    System.out.println("Некорректный оператор: 'оператор'");
                    break;
            }
            calculatorLog(op,a,b,result);
            return result;
        }
//            "гггг-мм-дд чч:мм User entered the first operand = {первое число}"
//            "гггг-мм-дд чч:мм User entered the operation = {оператор}"
//            "гггг-мм-дд чч:мм User entered the second operand = {второе число}"
//            "гггг-мм-дд чч:мм Result is {результат}"
        void calculatorLog(char op, int a, int b, int result){
            try {
                File file = new File("log.txt");
                FileWriter fw = new FileWriter(file);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String date = dateFormat.format(new Date());
                fw.write(date + " User entered the first operand = " + a + "\n");
                fw.write(date + " User entered the operation = " + op + "\n");
                fw.write(date + " User entered the second operand = " + b + "\n");
                fw.write(date + " Result is " + result + "\n");
                fw.close();
            } catch (IOException e){
            }

        }
    }
    class Answer {
        public static void answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {
            // Напишите свое решение ниже
            // Студент [фамилия] получил [оценка] по предмету [предмет].
            String[] elements = new String[3];
            elements[0] = ELEMENT1;
            elements[1] = ELEMENT2;
            elements[2] = ELEMENT3;
            String[] json = JSON.split("}, *");
            String[][][] json3D = new String[json.length][3][2];
            String result = "";
            Answer.trimExcess(json);
            for (int i = 0; i < json.length; i++) { // разбиваем строку на трехмерный массив
                String[] temp = json[i].split(",");
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        json3D[i][j] = temp[j].split(":");
                    }
                }
            }

            for (int i = 0; i < json.length; i++) {
                for (int j = 0; j < 3; j++) {
                    result += elements[j] + (json3D[i][j][1]);
                }
                System.out.println(result);
                result = "";
            }

        }
        static void trimExcess(String[] str){
            for (int i = 0; i < str.length; i++) {
                str[i] = str[i].replace("{", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("}", "")
                        .replace("\"", "");
            }
        }
    }
        public static StringBuilder answer(String QUERY, String PARAMS) {
            StringBuilder result = new StringBuilder(QUERY);
                if(PARAMS.contains("null")){
                    String[] params = PARAMS
                            .replace("{", "")
                            .replace("}", "")
//                            .replace("}", "")
//                            .replace("\":\"", "=")
                            .split(",");
                    PARAMS = "";
                    for (int i = 0; i < params.length; i++) {
                        String[] temp = params[i].split(":");
                        temp[1] = "=\'" + temp[1] + "\'";
                        params[i] = temp[0]+temp[1];
                        if (!params[i].contains("null")){
                            PARAMS += params[i];
                        }

                    }
//                    System.out.println(PARAMS);
                }
            result.append(PARAMS.replace(" ", " and ").replace("\"", ""));
            return result;
        }

    class BubbleSort {
        private static File log;
        private static FileWriter fileWriter;


        public static void sort(int[] mas){
                        Calendar calendar = GregorianCalendar.getInstance();
            FileWriter fw = null;
            try {
                fw = new FileWriter(new File("log.txt"));
                ////          2023-05-19 07:53 [4, 8, 3, 1, 9]
                //            год-месяц-день час:минуты;
                fw.write("");
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < mas.length; i++) {
                    boolean flag = false;
                for (int j = 0; j < mas.length - 1 - i; j++) {
                    if (mas[j] > mas[j + 1]) {
                        int temp = mas[j];
                        mas[j] = mas[j + 1];
                        mas[j + 1] = temp;
                        flag = true;
                    }
                }


                        String array = Arrays.toString(mas);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String date = dateFormat.format(new Date());
                        fw = null;
                        try {
                            fw = new FileWriter(new File("log.txt"), true);
                            ////          2023-05-19 07:53 [4, 8, 3, 1, 9]
                            //            год-месяц-день час:минуты
                            String log = date.concat(" ").concat(array).concat("\n");
                            fw.write(log);
                            fw.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                }
                if(!flag) break;
            }






        }
    }

        public static void main(String[] args) {
//        1
////        Дана строка sql-запроса:
////
////        select * from students where "
////
////        Сформируйте часть WHERE этого запроса, используя StringBuilder.
////        Пример данных для фильтрации приведены ниже в виде json-строки.
////        Если значение null, то параметр не должен попадать в запрос.
////
////        {"name": "Ivanov", "country": "Russia", "city": "Moscow", "age": "null"}
////
////        Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:
////
////        String QUERY - начало SQL-запроса
////        String PARAMS - JSON с параметрами
////
////        WHERE first_name = "Grigorij" AND YEAR(birthday) > 2000;

        String QUERY = "select * from students where ";
        String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        System.out.println(PARAMS);
        System.out.println(answer(QUERY, PARAMS));
        System.out.println("select * from students where name='Ivanov' and country='Russia' and city='Moscow'");

//        Реализуйте алгоритм сортировки пузырьком числового массива,
//        результат после каждой итерации запишите в лог-файл.
//
//        Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:
//
//
//        После каждой итерации, ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}.
//
//// При чтении лог-файла получим:
//        2023-05-19 07:53 [4, 8, 3, 1, 9]
//        2023-05-19 07:53 [4, 3, 1, 8, 9]
//        2023-05-19 07:53 [3, 1, 4, 8, 9]
//        2023-05-19 07:53 [1, 3, 4, 8, 9]
//        2023-05-19 07:53 [1, 3, 4, 8, 9]
//        int[] arr - числовой массив

//            int[] arr = new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10};
//            BubbleSort.sort(arr);
//            for (int item : arr) {
//                System.out.print(item + " ");
//            }

//            Внутри класса Answer напишите метод answer,
//            который распарсит json и, используя StringBuilder, создаст строки вида:
//
//            Студент [фамилия] получил [оценка] по предмету [предмет].
//            На вход метода answer подаются аргументы:
//
//            String JSON
//            String ELEMENT1
//            String ELEMENT2
//            String ELEMENT3
            String JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
            String ELEMENT1 = "Студент ";
            String ELEMENT2 = " получил ";
            String ELEMENT3 = " по предмету ";
// Студент Иванов получил 5 по предмету Математика
// Студент Петрова получил 4 по предмету Информатика
// Студент Краснов получил 5 по предмету Физика
//        }


////            Answer.answer(JSON,  ELEMENT1,  ELEMENT2,  ELEMENT3);
//            String newJSON = JSON.replaceAll("\\{", "").replaceAll("\\}", "")
//                    .replaceAll("\"", "").replace('[', ' ').replace(']', ' ');
//            System.out.println(JSON);
//            System.out.println(newJSON);

//            Возьмите код от калькулятора с прошлого урока.
//
//                    К этому калькулятору нужно добавить логирование.
//
//                    Логи запишите в файл log.txtв формате:
//
//            "гггг-мм-дд чч:мм User entered the first operand = {первое число}"
//            "гггг-мм-дд чч:мм User entered the operation = {оператор}"
//            "гггг-мм-дд чч:мм User entered the second operand = {второе число}"
//            "гггг-мм-дд чч:мм Result is {результат}"

            Calculator cal = new Calculator();
            int result = cal.calculate('+', 10, 5);
            System.out.println(result);
        }
}
