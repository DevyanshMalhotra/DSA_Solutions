// 1255. Maximum Score Words Formed by Letters java solution
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }
        
        return backtrack(words, letterCount, score, 0);
    }
    
    private int backtrack(String[] words, int[] letterCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        
        int maxScore = backtrack(words, letterCount, score, index + 1);
        
        int wordScore = 0;
        boolean canForm = true;
        int[] currentLetterCount = new int[26];
        
        for (char c : words[index].toCharArray()) {
            int letterIndex = c - 'a';
            currentLetterCount[letterIndex]++;
            if (currentLetterCount[letterIndex] > letterCount[letterIndex]) {
                canForm = false;
            }
            wordScore += score[letterIndex];
        }
        
        if (canForm) {
            for (int i = 0; i < 26; i++) {
                letterCount[i] -= currentLetterCount[i];
            }
            
            maxScore = Math.max(maxScore, wordScore + backtrack(words, letterCount, score, index + 1));
            
            for (int i = 0; i < 26; i++) {
                letterCount[i] += currentLetterCount[i];
            }
        }
        
        return maxScore;
    }

}
