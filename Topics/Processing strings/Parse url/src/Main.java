import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] url = scanner.nextLine().split("\\?");
        String[] parameters = url[1].split("&");

        String pass = "";

        for (int i = 0; i < parameters.length; i++) {
            String[] token = parameters[i].split("=");

            String value = "not found";
            if (token.length == 2) {
                value = token[1];
            }
            System.out.println(token[0] + " : " + value);
            if ("pass".equals(token[0])) {
                pass = token[1];
            }
        }

        if (!pass.isEmpty()) {
            System.out.println("password : " + pass);
        }
    }
}