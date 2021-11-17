package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Regular Expressions

public class reg {

    public static void main(String[] args) {

        String s = "Hi there. How are you?";
        System.out.println(s);
        String secondString = s.replaceAll("[A-Z][a-z]", "There");
        System.out.println(secondString);
        // US Phone Number
        String a = "(^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$";
        String phone1 = "(800) 123-4675";
        String phone2 = "(3728) 123-4675";
        String phone3 = "(80075";
        String phone4 = "() 123-4675"; 
        System.out.print(phone1.matches(a)+ " ");
        System.out.print(phone2.matches(a)+ " "); 
        System.out.print(phone3.matches(a)+" ");
        System.out.println(phone4.matches(a)+"\n");

        // Visa Card Number
        String visa = "^4[0-9]{12}([0-9]{3})?$";
        String visa1 = "4589475893847";
        String visa2 = "4859823459607905";
        String visa3 = "949347543748";
        String visa4 = "9475844";
        System.out.println(visa1.matches(visa));
        System.out.println(visa2.matches(visa));  
        System.out.println(visa3.matches(visa));
        System.out.println(visa4.matches(visa));
        String s1 = "I want a bike.";
        String s2 = "I want a ball.";
        String s3 = "I am going for a ride."; 
        String reg = "^[A-Z]{1}[ ][a-z]{4}[ ][a-z]{1}[ ][a-z]{4}[.]$";
        System.out.print(s1.matches(reg)+ " ");
        System.out.print(s3.matches(reg) + " ");
        System.out.println(s2.matches(reg)+ " ");

        var pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s1);
        System.out.print(matcher.matches()+ " ");
        matcher = pattern.matcher(s3);
        System.out.print(matcher.matches()+ " ");
        matcher = pattern.matcher(s2);
        System.out.println(matcher.matches()+ " ");

        String s4 = "Replace all the spaces by underscores, Ha ha";
        System.out.println(s4 + " " +s4.replaceAll(" ", "_"));
        System.out.println(s4 + " " +s4.replaceAll("\\s ", "_"));

        String s5 = "aaabccccccccdddefffg";
        // [abcdefg]+, [a-g]+, "^a{3}c{8}d{3}ef{3}g$"
        System.out.println(s5.matches("^a{3}b{1}c{8}d{3}e{1}f{3}g$"));

        String s6 = "ancde.47463";
        // ^[A-z]+\\.\\d+$, ^[A-z]+.[0-9]+$
        System.out.println(s6.matches("^[A-z]+\\.\\d+$"));

        String s7 = "abcd.135uvqz.7tzik.999";
        pattern = Pattern.compile("[A-z]+\\.(\\d+)");
        matcher = pattern.matcher(s7);
        while(matcher.find()){
            System.out.println(matcher.group(1)+ " ");
        }

        String s8 = "abcd.135\tuvqz.7\ttzik.999\n";
        pattern = Pattern.compile("[A-z]+\\.(\\d+)\\s");

        //s -> catches whitespaces that occurs after each occurence of letters, digits and other characters.  
        
        matcher = pattern.matcher(s8);
        while(matcher.find()){
            System.out.println(matcher.group(1)+ " Start: "+ matcher.start(1) + " End: "+ (matcher.end(1)-1));
        }

        String s9 = "{1, 2}, {0, 5}, {5, 7}, {6, 9}";
        pattern = Pattern.compile("\\{(.+?)\\}");
        matcher = pattern.matcher(s9);
        while (matcher.find()) {
            System.out.print(matcher.group(1)+ " ");
        }
        System.out.println();

//      Difference of "?" quantifier;
        pattern = Pattern.compile("\\{(.+)\\}");
        matcher = pattern.matcher(s9);
        while (matcher.find()) {
            System.out.print(matcher.group(1)+ " ");
        }
        System.out.println();

        String s10 = "{1, 2}, {0, 5}, {5, 7}, {6, 9}, {f, h}, {s, f}";
        pattern = Pattern.compile("\\{(\\d, \\d)\\}");
        matcher = pattern.matcher(s10);
        while (matcher.find()) {
            System.out.print("Occurence: " +matcher.group(1) +"\n");
        }

        String s11 = "shivu.a.1945@gmail.com";
        String s12 = "shivanagoudaagasimani@gmail.com";

        //  ^[A-Z0-9+_.-]+@[A-Z0-9.-]+$
        pattern = Pattern.compile("\\A\\S+@\\S+\\Z"); 
        matcher = pattern.matcher(s11);
        System.out.print(matcher.matches() + "\t");
        matcher = pattern.matcher(s12);
        System.out.print(matcher.matches() + "\t");



        

    }
    
}
