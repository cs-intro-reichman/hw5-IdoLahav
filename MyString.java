/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        // String hello = "helslo world";
        // System.out.println(countChar(hello, 'h'));
        // System.out.println(countChar(hello, 'l'));
        // System.out.println(countChar(hello, 'z'));
        // System.out.println(spacedString(hello));
        // System.out.println(remove("committee", "meet"));
        // System.out.println(insertRandomly('n', ""));
        System.out.println("1 " + subsetOf("space", "space")); // 1 true
        System.out.println("2 " + subsetOf("capse", "space")); // 2 true
        System.out.println("3 " + subsetOf("claim", "space")); // 3 false *
        System.out.println("4 " + subsetOf("sapce", "claim")); // 4 false *
        System.out.println("5 " + subsetOf("sap", "space")); // 5 true
        System.out.println("6 " + subsetOf("pass", "space")); // 6 false
        System.out.println("7 " + subsetOf("", "")); // 7 true
        System.out.println("8 " + subsetOf("ss", "")); // 8 false
        System.out.println("9 " + subsetOf("runi", "running")); // 9 true
        System.out.println("10 " + subsetOf("runix", "runi")); // 10 false 
        System.out.println("11 " + subsetOf("runi", "quiz")); // 11 false *
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++){
		   if (str.charAt(i) == ch){
			  count++;
		   }
		}
  
		return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1.isEmpty() || str1.equals(str2)){
            return true;
        }

        if (str1.length() > str2.length()){
            return false;
        } 
        else{
            for (int i = 0; i < str1.length(); i++){
                if (countChar(str1, str1.charAt(i)) > countChar(str2, str1.charAt(i))){
                    return false;
                }
            }
        }

        return true;
    } 

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newStr = "";

        if (str.isEmpty()){
            return str;
        }

        for (int i = 0; i < str.length() - 1; i++){
            newStr += str.charAt(i) + " ";
        }
        newStr += str.charAt(str.length() - 1);
        return newStr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomStr = "";
        for (int i = 0; i < n; i++){
            char randomCh = (char)(97 + (int)(Math.random() * 26));
            randomStr += randomCh;
        }
        return randomStr;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("committee","meet") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {

        for (int i = 0; i < str2.length(); i++) {
            char charToRemove = str2.charAt(i);           
            int indexToRemove = str1.indexOf(charToRemove);
    
            if (indexToRemove != -1) {
                str1 = str1.substring(0, indexToRemove) + str1.substring(indexToRemove + 1);
            }
        }
    
        return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }   
    
}
