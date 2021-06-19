import java.util.Scanner;//put imports you need here

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String firstName = scanner.nextLine();
        String cuccine = scanner.nextLine();
        cuccine = scanner.nextLine();
        cuccine = scanner.nextLine();
        cuccine = scanner.nextLine();
        

        System.out.printf("The form for %s is completed. We will contact you if we need a chef that cooks %s dishes.",
                firstName, cuccine);
    }
}
