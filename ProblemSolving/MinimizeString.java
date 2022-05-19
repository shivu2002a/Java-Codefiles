package ProblemSolving;
public class MinimizeString {

    public static void main(String[] args) {
        System.out.println(minimize("aaaabccdddeffff"));
        System.out.println(minimize("aabcdeeddwwqff"));
        System.out.println(minimize("a"));
        System.out.println(minimize("abcdef"));
        System.out.println(minimize("aaaabccdddeffff"));

    }

    public static String minimize(String s) {
        if(s.length() == 1) return s;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char curr = s.charAt(i);
            sb.append(s.charAt(i));
            while (i < s.length() && curr == s.charAt(i)) {
                count++;
                i++;
            }
            if (count != 1) {
                sb.append(count);
            }
            i--;
        }
        return sb.toString();
    }
    
}
