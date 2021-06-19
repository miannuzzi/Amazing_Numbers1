import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        int c = 0;
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'g' || input.charAt(i) == 'G'
                || input.charAt(i) == 'c' || input.charAt(i) == 'C') {
                    c++;
                }
        }
        
        double proc = (double) c / input.length() * 100;
        System.out.println(proc);
        
        
    }
}
