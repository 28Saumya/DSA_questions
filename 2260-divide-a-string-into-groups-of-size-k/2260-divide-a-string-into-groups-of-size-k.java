class Solution {
    public String[] divideString(String s, int k, char fill) {
        int size = s.length();
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < size; i +=k){
           
           StringBuilder  tmpS = new StringBuilder(s.substring(i, Math.min(i + k, size)));
           
            while (tmpS.length() < k){
              tmpS.append(fill);
            }

            res.add(tmpS.toString());
        }
        return res.toArray(new String[0]);
    }
}