// 525. Contiguous Array java solution

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] arr) {
        int pc0 = 0;
        int pc1 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        int maxLength = 0; 

        for (int ep = 0; ep < arr.length; ep++) {
            if (arr[ep] == 0)
                pc0++;
            else
                pc1++;
            int diff = pc1 - pc0; 

            if (map.containsKey(diff)) {
                
                maxLength = Math.max(maxLength, ep - map.get(diff));
            } else {
                
                map.put(diff, ep);
            }
        }
        return maxLength;
    }
}
