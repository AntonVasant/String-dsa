package pattern;

public class X {
    public static void main(String[] args) {
        String input = "geeksforgeeks";
        int length = input.length();

        // Print the upper half including the middle line
        for (int i = 0; i < (length + 1) / 2; i++) {
            printLine(input, length, i);
        }

        // Print the lower half excluding the middle line
        for (int i = (length - 1) / 2 - 1; i >= 0; i--) {
            printLine(input, length, i);
        }
    }

    private static void printLine(String input, int length, int row) {
        int spacesBefore = row;
        int spacesBetween = length - 2 * row - 2;

        // Print leading spaces
        for (int i = 0; i < spacesBefore; i++) {
            System.out.print(" ");
        }

        // Print the first character
        System.out.print(input.charAt(row));

        // Print the spaces between the characters if it's not the middle line
        if (spacesBetween >= 0) {
            for (int i = 0; i < spacesBetween; i++) {
                System.out.print(" ");
            }
            // Print the second character if it's not the middle line
            if (row != length / 2) {
                System.out.print(input.charAt(length - row - 1));
            }
        }

        // Move to the next line
        System.out.println();
    }
}
