import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        
        StringBuilder sb = new StringBuilder();
        
        int n = scanner.nextInt();
        if (n <= input.length()) {              
        
            for (int i = n; i < input.length(); i++) {
                sb.append(input.charAt(i));                
            }
            
            for (int i = 0; i < n; i++) {
                sb.append(input.charAt(i));                
            }
        } else {
            sb = new StringBuilder(input);
        }
        
        System.out.println(sb);
        
    }
}
