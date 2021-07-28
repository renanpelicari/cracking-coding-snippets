import java.util.HashMap;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 01_ArraysAndString_Snippets {

    /**
     * =============================================================================
     * 1.0.
     * How to create: Hash Table / Hash Map
     * =============================================================================
     */
    // Java 7
    public HashMap<Integer, User> getUserMapA(final List<User> users) {

        HashMap<Integer, User> userMap = new HashMap<>();
        for (User u : users) {
            userMap.add(u.getId(), u);
        }
        return userMap;
    }

    // Java 8
    public HashMap<Integer, User> getUserMapB(final List<User> users) {
        return users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
    }



    /**
     * =============================================================================
     * 1.1.
     * Algorithm to check if string has only unique characters
     * =============================================================================
     */
    public static boolean stringHasOnlyUniqueChars(final String text) {

        final Set<Character> charMap = new Set<>();

        for (final char c : text.toCharArray()) {

            if (charMap.contains(c)) {
                return false;
            }
            charMap.add(c);
        }

        return true;
    }



    /**
     * =============================================================================
     * 1.2.
     * Reverse the String
     * =============================================================================
     */
    //  Solution 1 (with reverse loop)
    public static String reverseStringA(final String text) {
        final StringBuilder sb = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }

        return sb.toString();
    }

    // Solution 2 (using reverse method from StringBuilder)
    public static String reverseStringB(final String text) {
        return new StringBuilder(text)
                .reverse()
                .toString();
    }



    /**
     * =============================================================================
     * 1.3.
     * Remove duplicate chars without using any additional buffer (allow to create maximum of 2 variables)
     * =============================================================================
     */
    public static String removeDuplicateChar(final String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            boolean found = false;

            // check the chars before the current, since the addition occurs only at the first occurrence
            for (int j = i - 1; j >= 0; j--) {

                if (text.charAt(i) == text.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                sb.append(text.charAt(i));
        }
        return sb.toString();
    }



    /**
     * =============================================================================
     * 1.4.
     * Decide if 2 string are anagrams
     *
     * Assumptions: For this algorithm I ignored the spaces and insensitive case
     * =============================================================================
     */
    // Solution 1: sum the ascii and compare the total
    public static boolean areAnagrams(final String textA, final String textB) {
        return (sumAsciiOfString(textA) == sumAsciiOfString(textB));
    }
    private static int sumAsciiOfString(final String text) {
        int res = 0;
        for (final char c : text.toUpperCase().replace(" ", "").toCharArray()) {
            res += (int) c;
        }
        return res;
    }
    // Solution 2 (not implemented) -> convert string into array, sort and compare



    /**
     * =============================================================================
     * 1.5.
     * Method to replace all occurrences to another string (this case spaces by '%20')
     * =============================================================================
     */
    public static String replaceSpace(final String text) {
        return text.replaceAll(" ", "%20");
    }

    /**
     * =============================================================================
     * 1.6.
     * NOT IMPLEMENTED
     * =============================================================================
     */

    /**
     * =============================================================================
     * 1.7.
     * NOT IMPLEMENTED
     * =============================================================================
     */



    /**
     * =============================================================================
     * 1.8.
     * Check if the first string contains the second one, even when the second
     * string was rotated (not anagram, just rotation).
     *
     * e.g.
     * isRotationSubstring("apple", "pleap") -> true   (rotation)
     * isRotationSubstring("apple", "ppale") -> false  (anagram)
     * =============================================================================
     */
    public static boolean isRotationSubstring(final String textA, final String textB) {

        if (textA.length() > 0 && textA.length() == textB.length()) {
            final String textToCompare = textA + textA;
            return textToCompare.contains(textB);
        }

        return false;
    }

}
