package Regex;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Code to validate password

public class password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password to validate: ");
        do {
            int number = minimumNumber(scanner.next());
            if(number > 0) System.out.println( "Minimum number of characters to add : " + number);
            System.out.print("\n" + "Enter the password to validate: ");
        } while(scanner.hasNext());
        scanner.close();
    }

    public static int minimumNumber(String s) {
        int count = 0;
        Pattern digit = Pattern.compile("\\d");
        Pattern lower = Pattern.compile("[a-z]");
        Pattern higher = Pattern.compile("[A-Z]");
        Pattern ch = Pattern.compile("\\W");
        
        Matcher digitM = digit.matcher(s);
        Matcher lowerM = lower.matcher(s);
        Matcher higherM = higher.matcher(s);
        Matcher chM = ch.matcher(s);
        
        if (s.length() < 6 ) {
            System.out.println("Your password should be at least 6 characters long");
            return (6 - s.length());
        }

        if(!digitM.find()) {
            count++;
            System.out.println("There is no digit");
        }

        if(!higherM.find()) {
            count++;
            System.out.println("There is not at least a single Capital letter");
        }

        if(!lowerM.find()) {
            count++;
            System.out.println("There is not at least a single lowercase letter");
        }

        if(!chM.find()) {
            count++;
            System.out.println("There is no any alpha-numeric character");
        }

        if(count == 0){
            System.out.println("Everything's Cool!!");
        }

        return count;
    }

}
