// Maximum Sum Problem

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxSum(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return maxSumDivide(n, memo);
    }

    private int maxSumDivide(int n, Map<Integer, Integer> memo) {
        if(n==0){
            return 0;
        }
        if(memo.containsKey(n)==true){
            return memo.get(n);
        }
        
        int maxS=Math.max(n,maxSumDivide(n/2,memo)+maxSumDivide(n/3,memo)+maxSumDivide(n/4,memo));
        memo.put(n,maxS);
        return maxS;
    }
}
