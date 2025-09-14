import java.util.*;

class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Replace vowels with '*' for easier masking
    private String maskVowels(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) arr[i] = '*';
        }
        return new String(arr);
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 1. Exact match set
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));

        // 2. Case-insensitive map (lowercase -> original)
        Map<String, String> lowerMap = new HashMap<>();

        // 3. Vowel-masked map (masked lowercase -> original)
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            lowerMap.putIfAbsent(lower, word);

            String masked = maskVowels(lower);
            vowelMap.putIfAbsent(masked, word);
        }

        // Answer array
        String[] ans = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // Case 1: Exact match
            if (exactWords.contains(query)) {
                ans[i] = query;
                continue;
            }

            // Case 2: Case-insensitive match
            String queryLower = query.toLowerCase();
            if (lowerMap.containsKey(queryLower)) {
                ans[i] = lowerMap.get(queryLower);
                continue;
            }

            // Case 3: Vowel-error match
            String queryMasked = maskVowels(queryLower);
            if (vowelMap.containsKey(queryMasked)) {
                ans[i] = vowelMap.get(queryMasked);
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }
}
