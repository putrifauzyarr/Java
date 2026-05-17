import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input: ");
        String sentence = scanner.nextLine();
        
        // 1. Total number of characters (including spaces)
        int totalCharacters = sentence.length();
        
        // 2. Total number of words
        String[] words = sentence.trim().split("\\s+");
        int totalWords = words.length;
        
        // 3. Uppercase
        String uppercase = sentence.toUpperCase();
        
        // 4. Lowercase
        String lowercase = sentence.toLowerCase();
        
        // 5. Reverse the sentence
        String reverse = new StringBuilder(sentence).reverse().toString();
        
        // 6. Count vowels & 7. Count consonants
        int vowels = 0, consonants = 0;
        String lowerSentence = sentence.toLowerCase();
        for (char c : lowerSentence.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        // 8. Check palindrome (ignore spaces and case)
        String stripped = sentence.replaceAll("\\s+", "").toLowerCase();
        String strippedReverse = new StringBuilder(stripped).reverse().toString();
        String palindrome = stripped.equals(strippedReverse) ? "Yes" : "No";
        
        System.out.println("Total Characters: " + totalCharacters);
        System.out.println("Total Words: " + totalWords);
        System.out.println("Uppercase: " + uppercase);
        System.out.println("Lowercase: " + lowercase);
        System.out.println("Reverse: " + reverse);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Palindrome: " + palindrome);
        
        scanner.close();
    }
}