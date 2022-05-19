package ProblemSolving;
import java.util.*;

class StringObj {
    String string;

    public StringObj() {
        this(null);
    }

    public StringObj(String string) {
        this.string = string;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        result = prime * result + ((string == null) ? 0 : String.valueOf(charArray).hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StringObj other = (StringObj) obj;
        if (string == null) {
            if (other.string != null)
                return false;
        }
        return true;
    }

    public static boolean anagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                if (map.get(b.charAt(i)) == 1) {
                    map.remove(b.charAt(i));
                } else {
                    map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }
        return (map.size() == 0);
    }
}

public class GroupOfAnagrams {

    public static List<List<String>> groupOfAnangramsUtil(String[] strs) {
        Map<StringObj, ArrayList<String>> map = new HashMap<StringObj, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            ArrayList<String> list = new ArrayList<String>();
            StringObj strObj = new StringObj(strs[i]);
            if (map.containsKey(strObj)) {
                list = map.get(strObj);
                list.add(strs[i]);
            } else {
                list.add(strs[i]);
                map.put(strObj, list);
            }
        }
        List<List<String>> values = new ArrayList<List<String>>();
        for (Map.Entry<StringObj, ArrayList<String>> entry : map.entrySet()) {
            values.add(entry.getValue());
        }
        return values;
    }

    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat", "abccccc", "abccd"};
        List<List<String>> result = groupOfAnangramsUtil(strs);
        System.out.println(result);
    }
}