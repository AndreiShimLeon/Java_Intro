import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Arrays;

public class Train {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;

        try {
            File file = new File("newFile.txt");
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            pw.println("12? + 4?5 = 591");
            pw.println("everything is working fine");
            pw.println("everything is working fine 2");
            pw.close();

            br = new BufferedReader(new FileReader("newFile.txt"));
            String line;
            line = br.readLine();
            System.out.printf("Given the equation: %s\n", line);

            String[] equation = line.split(" ");
            String[] numbers = {equation[0],equation[2],equation[4]};
            boolean flag = false;
            for (int i = 0; i < 10; i++) {
                int first = Integer.parseInt(numbers[0].replace("?", Integer.toString(i)));
                for (int j = 0; j < 10; j++) {
                    int second = Integer.parseInt(numbers[1].replace("?", Integer.toString(j)));
                    if (first+second == Integer.parseInt(numbers[2])){
                        numbers[0] = Integer.toString(first);
                        numbers[1] = Integer.toString(second);
                        flag = true;
                    }
                }
            }
            if (flag){
                System.out.printf("Result: %s + %s = %s\n", numbers[0], numbers[1], numbers[2]);
            } else{
                System.out.println("No solution");
            }

//            System.out.printf("%s + %s = %s", numbers[0], numbers[1], numbers[2]);



//            while((line = br.readLine()) != null){
//                System.out.println(line);
//

        } catch(IOException e) {
            System.out.print("Error: " + e);
        } finally {
            br.close();
            System.out.println("pw Done");
        }

    }
}
