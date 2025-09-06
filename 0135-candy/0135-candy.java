class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: everyone gets 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        
        boolean changed = true;
        
        // Step 2: keep adjusting until stable
        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    changed = true;
                }
                if (i < n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    changed = true;
                }
            }
        }
        
        // Step 3: sum up candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        
        return total;
    }
}