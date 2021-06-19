import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        int firstSum = 0;
        int secondSum = 0;
        
        for (int i = 0; i < input.length() /2; i++) {
            firstSum += Integer.valueOf(input.charAt(i));
            secondSum += Integer.valueOf(input.charAt(i + 3));
        }
        
        if (firstSum == secondSum) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
