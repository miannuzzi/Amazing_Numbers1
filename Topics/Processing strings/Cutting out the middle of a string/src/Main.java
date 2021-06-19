import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        boolean isEven = input.length() % 2 == 0;
        int middle = input.length() / 2;      
        
        for (int i = 0; i < input.length(); i++) {            
            if (isEven) {
                
                if (i != (middle - 1) && i != (middle)) {
                    System.out.print(input.charAt(i));
                }
            } else {
                if (i != middle ) {
                    System.out.print(input.charAt(i));
                }
            }
        }
    }
}
