import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char previous = input.charAt(0);
        boolean ordered = true;
        
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != previous + 1) {
                ordered = false;
            }
            previous = input.charAt(i);
        }
        
        System.out.println(ordered);
    }
}
