import java.util.*;

public class Seminar4 {


    public static void main(String[] args) {
        // фио + возраст

        LinkedList<String[]> people = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        String man = "";
        while (true) {
            System.out.println("Введите данные пользователя (Ф И О возраст  пол): ");
            man = in.nextLine();
            if (man.equalsIgnoreCase("end")) break;
            String[] man2 = man.split(" ");
            people.add(man2);
        }
        people.forEach(n -> System.out.println(Arrays.toString(n)));
        System.out.println(people.size());
        System.out.println("~*".repeat(16));
        people.sort((o1, o2) -> Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]));
        people.forEach(n -> System.out.println(Arrays.toString(n)));
        System.out.println("~*".repeat(16));

        LinkedList<String[]> men = new LinkedList<>();
        LinkedList<String[]> women = new LinkedList<>();
//        for (int i = 0; i < people.size(); i++) {
//            if(people.get(i)[4].equals("муж")){
//                men.add(people.get(i));
//            } else {
//                women.add(people.get(i));
//            }
//        }
//        men.forEach(n -> System.out.println(Arrays.toString(n)));
//        women.forEach(n -> System.out.println(Arrays.toString(ng(n)));

        people.forEach(n -> {
            if(n[4].equals("Мужчина")){
                men.add(n);
            } else {
                women.add(n);
            }
        });

        men.forEach(n -> System.out.println(Arrays.toString(n)));
        women.forEach(n -> System.out.println(Arrays.toString(n)));






        // 4) реализовать сортировку по возрасту и полу

    }}




