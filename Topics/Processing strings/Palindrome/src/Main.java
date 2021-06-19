import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        
        boolean result = true;

        if (value.length() > 1) {
            for (int i = 0; i < value.length() / 2; i++) {
                result = result && value.charAt(i) == value.charAt(value.length() - 1 - i);
            }
        }

        if (result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        
    }
}
