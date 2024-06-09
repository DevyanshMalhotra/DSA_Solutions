// 153. Find Minimum in Rotated Sorted Array java solution
class Solution {
    public int findMin(int[] nums) {
        int lo=0,hi=nums.length-1;
        int ans=-1;
        while(lo<=hi){
            int m=lo+((hi-lo)/2);
            if(nums[m]<=nums[hi]){
                if(ans==-1 || nums[ans]>nums[m]){
                    ans=m;
                }
                hi=m-1;
            }else{
                if(ans==-1 || nums[ans]>nums[m]){
                    ans=m;
                }
                lo=m+1;
            }
        }
        return nums[ans];
    }
}
