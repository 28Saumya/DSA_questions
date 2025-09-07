class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int[] temp = new int[nums.length];
        int j = 0; // index for temp

        temp[j++] = nums[0]; // first element is always unique

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                temp[j++] = nums[i];
            }
        }

        // Copy unique elements back to original array
        for (int i = 0; i < j; i++) {
            nums[i] = temp[i];
        }

        return j;
    }
}