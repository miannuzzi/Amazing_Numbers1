import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int index = input.toLowerCase().indexOf("the");
        System.out.println(index);
    }
}
