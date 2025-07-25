class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         int[] result = new int[nums1.length]; // array to store answers

        for (int i = 0; i < nums1.length; i++) {
            int number = nums1[i];       // take one number from nums1
            int answer = -1;             // default is -1 if not found
            boolean found = false;       // to mark when we find this number in nums2

            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == number) {
                    found = true; // we found the number in nums2, now look to the right
                }
                else if (found && nums2[j] > number) {
                    answer = nums2[j]; // we found a greater number to the right
                    break;             // stop checking after finding the first greater
                }
            }

            result[i] = answer; // store the result
        }

        return result;
    }
}