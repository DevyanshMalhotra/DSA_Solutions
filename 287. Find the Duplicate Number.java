// 287. Find the Duplicate Number java solution

class Solution {
    public int findDuplicate(int[] nums) {
        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            if(map.get(i)>1)
            return i;
        }
        return -1;
    }
}
