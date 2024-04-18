package javaLAB.exp1;

public class findDigit {
    public static void main(String args[]) {
        int no = 456789, first_digit = 0;
        int last_digit = no % 10;
        while (no != 0) {
            first_digit = no % 10;
            no = no / 10;
        }
        System.out.println("First digit of no=" + first_digit);
        System.out.println("Last digit of no=" + last_digit);

    }

}