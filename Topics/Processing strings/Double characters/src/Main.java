import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        String doubled = "";
        
        for (int i = 0; i < input.length(); i++) {
            doubled = doubled + input.charAt(i)  + input.charAt(i);
        }
        
        System.out.println(doubled);
    }
}
