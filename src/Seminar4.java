import java.util.*;

public class Seminar4 {


    public static void main(String[] args) {


        ArrayList<String[]> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String person = "";

        // Заполняем людьми
        while (true) {
            System.out.println("Введите данные пользователя (Ф И О возраст  пол): ");
            person = in.nextLine();
            if (person.equalsIgnoreCase("end")) break;
            String[] splittedPerson = person.split(" ");
            people.add(splittedPerson);
        }

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> surnames = new ArrayList<>();
        ArrayList<String> middleNames = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<Boolean> sexes = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        people.forEach(n -> {
            surnames.add(n[0]); names.add(n[1]); middleNames.add(n[2]); ages.add(Integer.parseInt(n[3]));
            if(n[4].equals("Мужчина")) sexes.add(true);
            else sexes.add(false);
            ids.add(people.indexOf(n)); // возможна ошибка в случае полных дублей записей
        });

        // Печатаем всех заполненных людей
        System.out.println("~*".repeat(16) + "Исходный список людей" + "~*".repeat(16));
        people.forEach(n -> System.out.println(Arrays.toString(n)));

        System.out.println("~*".repeat(16) + "Сортировка по возрасту" + "~*".repeat(16));
        int[] tempArr = new int[ages.size()];
        for (int i = 0; i < ages.size(); i++) {
            tempArr[i] = ages.get(i);
        }
        // BubbleSort
        for (int i = 0; i < ages.size(); i++) {
            for (int j = 0; j < ages.size() - i - 1; j++) {
                if (tempArr[j] > tempArr[j + 1]) {
                    // изменяем временный массив
                    int temp = tempArr[j];
                    tempArr[j] = tempArr[j+1];
                    tempArr[j+1] = temp;

                    //  параллельно изменяем ids
                    int tempAge = ids.get(j);
                    ids.set(j, ids.get(j+1));
                    ids.set(j+1, tempAge);

                }
            }
        }

        ids.forEach(n -> System.out.println(Arrays.toString(people.get(n))));

        // под индексом 3 имеем возраст человека
//        people.sort((o1, o2) -> Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]));
//        people.forEach(n -> System.out.println(Arrays.toString(n)));



        System.out.println("~*".repeat(16) + "Сортировка по возрасту и полу" + "~*".repeat(16));
//        ArrayList<String[]> men = new ArrayList<>();
//        ArrayList<String[]> women = new ArrayList<>();
//
//        people.forEach(n -> {
//            if(n[4].equals("Мужчина")){
//                men.add(n);
//            } else {
//                women.add(n);
//            }
//        });
//
//        men.addAll(women);
//        men.forEach(n -> System.out.println(Arrays.toString(n)));
//        women.forEach(n -> System.out.println(Arrays.toString(n)));



    }
}




