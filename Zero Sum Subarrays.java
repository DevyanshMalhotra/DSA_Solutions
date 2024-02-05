// Zero Sum Subarrays O(n) solution
class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long,Integer> map=new HashMap<>();
        long ans=0;
        long[] ps=new long[n];
        ps[0]=arr[0];
        for(int i=1;i<n;i++){
            ps[i]=arr[i]+ps[i-1];
        }
        map.put(0L,1);
        for(int ep=0;ep<n;ep++){
            ans=ans+map.getOrDefault(ps[ep],0);
            map.put(ps[ep],map.getOrDefault(ps[ep],0)+1);
        }
        return ans;
    }
}
