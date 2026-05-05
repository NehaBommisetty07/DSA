class Solution {
    public String sortVowels(String s) {
        // Step 1: Collect all vowels from the string
        StringBuilder vowels = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.append(c);
            }
        }

        // Step 2: Sort the vowels by their ASCII values
        char[] sortedVowels = vowels.toString().toCharArray();
        java.util.Arrays.sort(sortedVowels);

        // Step 3: Reconstruct the string
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                // Place the sorted vowel
                result.append(sortedVowels[vowelIndex++]);
            } else {
                // Keep the consonant in place
                result.append(c);
            }
        }

        return result.toString();
    }

    // Helper method to check if a character is a vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}