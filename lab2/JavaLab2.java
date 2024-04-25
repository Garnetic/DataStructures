public class JavaLab2 {
    public static void main(String[] args) {
        String s = "listen";
        String t = "silent";

        System.out.println("Is \"" + t + "\" an anagram of \"" + s + "\"? " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // If they are not the same length,
            return false; // Then they're not an anagram
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j == s.length() - 1 && s.charAt(i) != t.charAt(j)) {
                    return false;
                }
                if (s.charAt(i) == t.charAt(j)) {
                    break;
                }
            }
        }

        return true;
    }
}
