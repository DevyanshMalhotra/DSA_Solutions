// 560. Subarray Sum Equals K o(n) t.c. solution
class Solution {
    public int[] psum(int[] nums){
        int[] ps=new int[nums.length];
        ps[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ps[i]=nums[i]+ps[i-1];
        }
        return ps;
    }
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int ans=0;
        int[] ps=psum(nums);
        map.put(0,1);
        for(int ep=0;ep<n;ep++){
            int diff=ps[ep]-k;
            ans=ans+map.getOrDefault(diff,0);
            map.put(ps[ep],map.getOrDefault(ps[ep],0)+1);
        }
        return ans;
    }
}
