import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] tokens = input.split("-");
        
        System.out.println(tokens[1] + "/" + tokens[2] + "/" + tokens[0]);
    }
}
