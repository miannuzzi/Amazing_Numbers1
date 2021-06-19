import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        boolean isA = true;
        boolean isAm = true;
        boolean isOne = true;
        String password = "";
        
        for (int i = 0; i < n; i++) {
            if ( i < a || i >= (a + b + c)) {
                if (isA) {                    
                    password = password + "A";
                } else {
                    password = password + "B";
                }
                isA = !isA;
            } else if (a <= i && i < (a + b)) {
                if (isAm) {                    
                    password = password + "a";
                } else {
                    password = password + "b";
                }
                isAm = !isAm;                
            } else if ((a + b) <= i && i < (a + b + c)) {
                if (isOne) {                    
                    password = password + "1";
                } else {
                    password = password + "2";
                }
                isOne = !isOne;
            
            }
        }
        System.out.println(password);
    }
}
