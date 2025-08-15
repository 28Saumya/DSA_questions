class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       int n=asteroids.length;
       Stack<Integer>st=new Stack<>();
       for(int i=0; i<n; i++){
        int curr=asteroids[i];
        boolean dest=false;
        while(!st.isEmpty() && curr<0 && st.peek()>0){
            int top=st.peek();
            if(top< -curr){
                st.pop();
                continue;
            }else if(top== -curr){
                st.pop();
            }dest=true;
            break;
        }
         if(!dest){
            st.push(curr);
            } 
       }
            int[] res=new int[st.size()];
            for(int j=st.size()-1; j>=0; j--){
                res[j]=st.pop();

            }
       
       return res;
    }
 }   

