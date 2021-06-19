import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] room1 = scanner.nextLine().split(" ");
        String[] room2 = scanner.nextLine().split(" ");
        String[] room3 = scanner.nextLine().split(" ");
        String[] room4 = scanner.nextLine().split(" ");
        
        
        for (int i = room4.length - 1; i >= 0; i--){
            System.out.println(room4[i]);
        }
        
        for (int i = room3.length - 1; i >= 0; i--){
            System.out.println(room3[i]);
        }
        
        for (int i = room2.length - 1; i >= 0; i--){
            System.out.println(room2[i]);
        }
        
        for (int i = room1.length - 1; i >= 0; i--){
            System.out.println(room1[i]);
        }
    }
}
