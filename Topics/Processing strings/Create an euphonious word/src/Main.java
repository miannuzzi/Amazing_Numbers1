import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isVowel = input.charAt(0) == 'a' || input.charAt(0) == 'e' || input.charAt(0) == 'i'
                || input.charAt(0) == 'o' || input.charAt(0) == 'u' || input.charAt(0) == 'y';

        boolean previousLetter = isVowel;
        int c = 0;
        int letters = 0;

        for (int i = 0; i < input.length(); i++) {

            isVowel = input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i'
                    || input.charAt(i) == 'o' || input.charAt(i) == 'u' || input.charAt(i) == 'y';

            if (isVowel == previousLetter) {
                c++;
                if (c > 2) {
                    letters++;
                    c = 1;
                }
            } else {
                c = 1;
            }
            previousLetter = isVowel;
        }

        System.out.println(letters);
    }
}