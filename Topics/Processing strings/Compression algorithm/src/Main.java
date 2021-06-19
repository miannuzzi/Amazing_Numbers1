import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char previous = input.charAt(0);
        String compression = "";
        int c = 0;   
        
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != previous ) {
                compression = compression + previous + c;
                c = 0;
            }
            
            c++;
            previous = input.charAt(i);
            
        }
        
        compression = compression + previous + c;
        System.out.println(compression);
    }
}
