import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] input = scanner.nextLine().split(" ");
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() > max) {
                max = input[i].length();
                maxIndex = i;
            }
        }
        
        System.out.println(input[maxIndex]);
    }
}
