class Solution {
    public int countDigits(int num) {
        int copy=num;
        int count=0;
        while(copy!=0){
            int digit=copy%10;
            if(digit!=0 && num % digit == 0){
            count++;
            }
            copy/=10;
        }
        return count++;
    }
}