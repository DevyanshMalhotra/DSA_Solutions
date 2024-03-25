// 442. Find All Duplicates in an Array java solution

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int i:map.keySet()){
            if(map.get(i)>1){
                ans.add(i);
            }
        }
        return ans;
    }
}
