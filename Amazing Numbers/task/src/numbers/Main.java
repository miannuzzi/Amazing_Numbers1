package numbers;

import java.util.Scanner;



public class Main {

    public enum Property {
        EVEN("ODD"),
        ODD("EVEN"),
        BUZZ(""),
        DUCK("SPY"),
        PALINDROMIC(""),
        GAPFUL(""),
        SPY("DUCK"),
        SQUARE("SUNNY"),
        SUNNY("SQUARE"),
        JUMPING(""),
        HAPPY("SAD"),
        SAD("HAPPY");

        String mutuallyExclusive;

        Property(String me) {
            this.mutuallyExclusive = me;
        }

        public String getMutuallyExclusive() {
            return this.mutuallyExclusive;
        }

        public boolean isMutuallyExclusive(String property) {
            boolean result = false;
            if (!this.mutuallyExclusive.isEmpty()) {
                result = this.mutuallyExclusive.equals(property.toUpperCase());
            }

            return result;
        }
    }

    private static Property[] properties;
    private static Property[] excludedProperties;

    public static void main(String[] args) {

        greet();

        String[] input = inputValue();

        while (!"0".equals(input[0])) {

            boolean isValid = validateInput(input);

            if (isValid) {
                displayProperties(input);
            }

            input = inputValue();
        }

        System.out.println("Goodbye!");
    }

    public static void greet() {

        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("\t* the first parameter represents a starting number;");
        System.out.println("\t* the second parameters show how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and a properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- Enter 0 to exit.");
    }

    public static String[] inputValue() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a request: ");

        return scanner.nextLine().split(" ");
    }

    private static boolean validateInput(String[] input) {
        boolean isValid = true;

        if (!"0".equals(input[0]) && !isNatural(input[0])) {
            System.out.println("The first parameter should be a natural number or zero.");
            isValid = false;
        } else {
            if (input.length >= 2 && !isNatural(input[1])) {
                System.out.println("The second parameter should be a natural number.");
                isValid = false;
            }
            isValid = validateProperties(input);
        }

        return isValid;
    }
    private static boolean isMutuallyExclusive() {

        boolean isME = false;
        int meIndex         = -1;
        int equalMeIndex    = -1;
        int removalMeIndex    = -1;

        for (int i = 0; i < properties.length -1; i++) {
            for (int j = i + 1; j < properties.length; j++) {
                if (properties[i].isMutuallyExclusive(properties[j].name())) {
                    meIndex = i;
                }
            }
        }

        if (meIndex >= 0) {
            System.out.printf("The request contains mutually exclusive properties: [%s, %s]", properties[meIndex], properties[meIndex].getMutuallyExclusive());
            System.out.println("There are no numbers with these properties.");
            isME = true;
        }

        if (meIndex == -1) {
            for (int i = 0; i < properties.length; i++) {

                for (Property value: excludedProperties) {
                    if (properties[i] == value) {
                        equalMeIndex = i;
                    }
                }
            }
        }

        if (equalMeIndex >= 0) {
            System.out.printf("The request contains mutually exclusive properties: [%s, -%s]", properties[equalMeIndex], properties[equalMeIndex].getMutuallyExclusive());
            System.out.println("There are no numbers with these properties.");
            isME = true;
        }


        for (int i = 0; i < excludedProperties.length -1; i++) {
            for (int j = i + 1; j < excludedProperties.length; j++) {
                if (excludedProperties[i].isMutuallyExclusive(excludedProperties[j].name())) {
                    removalMeIndex = i;
                }
            }
        }

        if (removalMeIndex >= 0) {
            System.out.printf("The request contains mutually exclusive properties: [-%s, -%s]", excludedProperties[removalMeIndex], excludedProperties[removalMeIndex].getMutuallyExclusive());
            System.out.println("There are no numbers with these properties.");
            isME = true;
        }

        return isME;
    }
    private static boolean isPropertyValid(String property) {
        boolean exist = false;
        String propertyName;


        for (Property value: Property.values()) {
            propertyName = property.toUpperCase();

            if (propertyName.startsWith("-")) {
                propertyName = propertyName.substring(1);
            }
            exist = exist || value.name().equals(propertyName);
        }

        return exist;
    }

    private static boolean validateProperties(String[] input) {
        boolean isValid = true;

        int offset = 2;
        int propertiesLength = input.length - offset;

        if (propertiesLength > 0) {
            int propertySize = 0;
            int excludedPropertySize = 0;

            for (int i = offset; i < input.length; i++) {
                if (input[i].startsWith("-")) {
                    excludedPropertySize++;
                } else {
                    propertySize++;
                }
            }

            properties          = new Property[propertySize];
            excludedProperties  = new Property[excludedPropertySize];

            StringBuilder invalidProperties = new StringBuilder();
            boolean plural = false;

            int propertyIndex   = 0;
            int excludedIndex   = 0;

            for (int i = offset; i < input.length; i++) {
                if (isPropertyValid(input[i])) {
                    if (input[i].startsWith("-")) {
                        excludedProperties[excludedIndex] = Property.valueOf(input[i].toUpperCase().substring(1));
                        excludedIndex++;
                    } else {
                        properties[propertyIndex] = Property.valueOf(input[i].toUpperCase());
                        propertyIndex++;
                    }

                } else {
                    if (!invalidProperties.toString().isEmpty()){
                        invalidProperties.append(", ");
                        plural = true;
                    }
                    invalidProperties.append(input[i]);
                }

            }

            if (invalidProperties.length() != 0) {
                if (!plural){
                    System.out.printf("The property [%s] is wrong.\n", invalidProperties);
                } else {
                    System.out.printf("The properties [%s] are wrong.\n", invalidProperties);
                }

                StringBuilder propertyListMessage = new StringBuilder("Available properties: [");

                for (Property value: Property.values()) {
                    if (value.ordinal() != 0) {
                        propertyListMessage.append(", ");
                    }
                    propertyListMessage.append(value.name());
                }

                propertyListMessage.append("]");
                System.out.println(propertyListMessage);

                isValid = false;
            }
            if (isValid&& propertiesLength > 1 && isMutuallyExclusive()) {
                isValid = false;
            }
        }

        return isValid;
    }

    public static void displayProperties(String[] input) {

        if (input.length == 1) {
                singleNumberProperties(input[0]);
        } else if (input.length == 2) {
            repetitions(input[0], Integer.valueOf(input[1]));
        } else if (input.length >= 3) {
            search(input);
        }
    }

    private static void search(String[] input) {
        String seedNumber = input[0];
        int occurrences = Integer.valueOf(input[1]);

        int i = 0;
        int o = 0;

        while (o < occurrences) {

            long currentValue = Long.valueOf(seedNumber) + i;
            String number = String.valueOf(currentValue);
            boolean even = isEven(number);
            boolean buzz = isBuzz(number);
            boolean duck = isDuck(number);
            boolean palindromic = isPalindromic(number);
            boolean gapful = isGapful(number);
            boolean spy = isSpy(number);
            boolean sunny = isSunny(number);
            boolean square = isSquare(number);
            boolean jumping = isJumping(number);
            boolean happy = isHappy(number);

            boolean matches = matchesProperty(properties, number, buzz, duck, palindromic, gapful, spy, even, sunny, square, jumping, happy);
            boolean excluded = containsProperty(excludedProperties, number, buzz, duck, palindromic, gapful, spy, even, sunny, square, jumping, happy);

            if (matches && !excluded) {
                printProperty(number, buzz, duck, palindromic, gapful, spy, even, sunny, square, jumping, happy);
                o++;
            }
            i++;
        }
    }

    private static boolean matchesProperty(Property[] properties, String number, boolean buzz, boolean duck,
                                           boolean palindromic, boolean gapful, boolean spy, boolean even,
                                           boolean sunny, boolean square, boolean jumping, boolean happy) {
        boolean matches  = true;

        for (int j = 0; j < properties.length; j++) {
            switch (properties[j]) {
                case EVEN:
                    if (!even) {
                        matches = false;
                    }
                    break;
                case ODD:
                    if (even) {
                        matches = false;
                    }
                    break;
                case BUZZ:
                    if (!buzz) {
                        matches = false;
                    }
                    break;
                case DUCK:
                    if (!duck) {
                        matches = false;
                    }
                    break;
                case PALINDROMIC:
                    if (!palindromic) {
                        matches = false;
                    }
                    break;
                case GAPFUL:
                    if (!gapful) {
                        matches = false;
                    }
                    break;
                case SPY:
                    if (!spy) {
                        matches = false;
                    }
                    break;
                case SUNNY:
                    if (!sunny) {
                        matches = false;
                    }
                    break;
                case SQUARE:
                    if (!square) {
                        matches = false;
                    }
                    break;
                case JUMPING:
                    if (!jumping) {
                        matches = false;
                    }
                    break;
                case HAPPY:
                    if (!happy) {
                        matches = false;
                    }
                    break;
                case SAD:
                    if (happy) {
                        matches = false;
                    }
                    break;
            }

        }
        return matches;
    }

    private static boolean containsProperty(Property[] properties, String number, boolean buzz, boolean duck,
                                           boolean palindromic, boolean gapful, boolean spy, boolean even,
                                           boolean sunny, boolean square, boolean jumping, boolean happy) {
        boolean matches  = false;

        for (int j = 0; j < properties.length; j++) {

            switch (properties[j]) {
                case EVEN:
                    if (even) {
                        matches = matches || true;
                    }
                    break;
                case ODD:
                    if (!even) {
                        matches = matches || true;
                    }
                    break;
                case BUZZ:
                    if (buzz) {
                        matches = matches || true;
                    }
                    break;
                case DUCK:
                    if (duck) {
                        matches = matches || true;
                    }
                    break;
                case PALINDROMIC:
                    if (palindromic) {
                        matches = matches || true;
                    }
                    break;
                case GAPFUL:
                    if (gapful) {
                        matches = matches || true;
                    }
                    break;
                case SPY:
                    if (spy) {
                        matches = matches || true;
                    }
                    break;
                case SUNNY:
                    if (sunny) {
                        matches = matches || true;
                    }
                    break;
                case SQUARE:
                    if (square) {
                        matches = matches || true;
                    }
                    break;
                case JUMPING:
                    if (jumping) {
                        matches = matches || true;
                    }
                    break;
                case HAPPY:
                    if (happy) {
                        matches = matches || true;
                    }
                    break;
                case SAD:
                    if (!happy) {
                        matches = matches || true;
                    }
                    break;
            }
        }
        return matches;
    }

    private static boolean isSunny(String number) {

        long square = Long.parseLong(number) + 1;

        return isSquare(String.valueOf(square));
    }

    private static boolean isJumping(String number) {
        boolean jumping = true;

        int previous = Integer.valueOf(number.charAt(0));

        for (int i = 1; i < number.length(); i++ ){

            jumping = jumping && (Math.abs(Integer.valueOf(number.charAt(i)) - previous) == 1);

            previous = Integer.valueOf(number.charAt(i));
        }

        return jumping;
    }

    private static void singleNumberProperties(String number) {
        boolean even = isEven(number);
        boolean buzz = isBuzz(number);
        boolean duck = isDuck(number);
        boolean palindromic = isPalindromic(number);
        boolean gapful = isGapful(number);
        boolean spy = isSpy(number);
        boolean sunny = isSunny(number);
        boolean square = isSquare(number);
        boolean jumping = isJumping(number);
        boolean happy = isHappy(number);

        System.out.printf("Properties of %s\nbuzz: %b\nduck: %b\npalindromic: %b\ngapful: %b\nspy: %b\neven: %b\nodd: %b\nsunny: %b\nsquare: %b\njumping: %b\nhappy: %b\nsad: %b\n",
                number, buzz, duck, palindromic, gapful, spy, even, !even, sunny, square, jumping, happy, !happy);
    }

    private static void repetitions(String seedNumber, int repetitions) {

        for (int i = 0; i < repetitions ; i++) {
            long currentValue = Long.valueOf(seedNumber) + i;
            String number = String.valueOf(currentValue);

            boolean even = isEven(number);
            boolean buzz = isBuzz(number);
            boolean duck = isDuck(number);
            boolean palindromic = isPalindromic(number);
            boolean gapful = isGapful(number);
            boolean spy = isSpy(number);
            boolean sunny = isSunny(number);
            boolean square = isSquare(number);
            boolean jumping = isJumping(number);
            boolean happy   = isHappy(number);

            printProperty(number, buzz, duck, palindromic, gapful, spy, even, sunny, square, jumping, happy);

        }
    }

    private static boolean isHappy(String number) {
        boolean happy = false;
        long sum = Long.parseLong(number);
        StringBuffer seenNumbers = new StringBuffer();
        boolean seen = false;

        do {
            String nextSequence = String.valueOf(sum);
            sum = 0;

            for (int i = 0; i < nextSequence.length(); i++) {
                int digit = Character.getNumericValue(nextSequence.charAt(i));

                sum += digit * digit;
            }

            String[] previousNumbers = seenNumbers.toString().split(" ");
            seen = false;

            for (String value: previousNumbers) {
                seen = seen || value.equals(String.valueOf(sum));
            }

            seenNumbers.append(sum + " ");

            happy = sum == 1;

        } while (!happy && !seen);

        return happy;
    }

    private static void printProperty(String number, boolean buzz, boolean duck, boolean palindromic, boolean gapful, boolean spy, boolean even
                            ,boolean sunny, boolean square, boolean jumping, boolean happy) {

        System.out.print(number + " is");

        if (buzz) {
            System.out.print(" buzz");
        }
        if (duck) {
            System.out.print(" duck");
        }
        if (palindromic) {
            System.out.print(" palindromic");
        }
        if (gapful) {
            System.out.print(" gapful");
        }
        if (spy) {
            System.out.print(" spy");
        }
        if (even) {
            System.out.print(" even");
        }
        if (!even) {
            System.out.print(" odd");
        }
        if (sunny) {
            System.out.print(" sunny");
        }
        if (square) {
            System.out.print(" square");
        }
        if (jumping) {
            System.out.print(" jumping");
        }
        if (happy) {
            System.out.print(" happy");
        }
        if (!happy) {
            System.out.print(" sad");
        }

        System.out.println();
    }
    //A number is said to be Spy if the sum of all digits is equal to the product of all digits.
    private static boolean isSpy(String number) {

        long sum = 0;
        long product = 1;

        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
            product *= Character.getNumericValue(number.charAt(i));
        }

        return sum == product;
    }
    private static boolean isGapful(String number) {
        boolean gapful = false;

        if (number.length() > 2) {
            String rawValue = String.valueOf(number.charAt(0)) + String.valueOf(number.charAt(number.length() -1));
            int divisor = Integer.valueOf(rawValue);
            long dividend = Long.valueOf(number);
            gapful = dividend % divisor == 0;
        }

        return gapful;
    }

    private static boolean isSquare(String number) {
        double value = Long.valueOf(number);

        double result = Math.sqrt(value);
        int integerPart = (int) result;
        return (result - integerPart) == 0d;
    }

    private static boolean isDuck(String number) {
        boolean heading = true;
        boolean isDuck = false;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0' && heading) {
                heading = false;
            } else if (number.charAt(i) == '0' && !heading ){
                isDuck = true;
            }

        }
        return isDuck;

    }

    private static boolean isBuzz(String number) {
        long remainder = Long.valueOf(number) % 7;
        return  (remainder == 0)
                    || number.charAt(number.length() - 1) == '7';
    }

    private static boolean isEven(String number) {
        return number.charAt(number.length() - 1) % 2 == 0;
    }

    public static boolean isNatural(String input) {
        long number = Long.parseLong(input);
        boolean isNatural = number > 0;

        return isNatural;
    }

    public static boolean isPalindromic(String value) {
        boolean result = true;

        if (value.length() > 1) {
            for (int i = 0; i < value.length() / 2; i++) {
                result = result && value.charAt(i) == value.charAt(value.length() - 1 - i);
            }
        }

        return result;
    }
}
