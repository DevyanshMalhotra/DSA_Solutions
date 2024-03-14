// 930. Binary Subarrays With Sum

import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        
        map.put(0, 1);
        
        for (int num : nums) {
            sum += num;
            int diff = sum - goal;
            ans += map.getOrDefault(diff, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ans;
    }
}
