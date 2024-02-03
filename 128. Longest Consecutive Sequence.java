// 128. Longest Consecutive Sequence
// t.c.:O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(!map.containsKey(num)){
                int sp=num;
                int ep=num;
                if(map.containsKey(num-1)){
                    sp=sp-map.get(num-1);
                }
                
                if(map.containsKey(num+1)){
                    ep=ep+map.get(num+1);
                }
                int l=ep-sp+1;
                map.put(sp,l);
                map.put(ep,l);
                if(sp!=num && ep!=num){
                    map.put(num,l);
                }
                max=Math.max(max,l);
            }
        }
        return max;
    }
}
