import java.util.HashMap;

public class JavaLab2 {
    public class AnagramChecker {

        public static boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            HashMap<Character, Integer> charCounts = new HashMap<>();

            // Count each character in string s
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }

            // Reduce the count for each character found in t
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (!charCounts.containsKey(c) || charCounts.get(c) == 0) {
                    return false;
                }
                charCounts.put(c, charCounts.get(c) - 1);
                if (charCounts.get(c) == 0) {
                    charCounts.remove(c);
                }
            }

            // If the map is empty, then t is an anagram of s
            return charCounts.isEmpty();
        }

        public static void main(String[] args) {
            String s = "listen";
            String t = "silent";

            System.out.println("Is \"" + t + "\" an anagram of \"" + s + "\"? " + isAnagram(s, t));
        }
    }

}
