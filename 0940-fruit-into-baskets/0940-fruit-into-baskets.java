class Solution {
    public int totalFruit(int[] fruits) {
             int left=0;
        int sum=0;
        int res=0;
        int right=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            if(map.size()>=3){
                map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}