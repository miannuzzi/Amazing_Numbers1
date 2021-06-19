import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String value = scanner.nextLine();
        int c = 0;
        int index = input.indexOf(value);

        while (index != -1) {
            c++;
            input = input.substring(index + value.length());
            index = input.indexOf(value);
        }


        System.out.println(c);
    }

}