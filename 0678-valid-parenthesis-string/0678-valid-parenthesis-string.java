class Solution {
    public boolean checkValidString(String s) {
        int max=0;
        int min=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                min++;
                max++;
            }
            else if(c== ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min<0){
                min=0;
            }
            if(max<0){
                return false;
            }
           
        }
         return(min==0);
    }
}