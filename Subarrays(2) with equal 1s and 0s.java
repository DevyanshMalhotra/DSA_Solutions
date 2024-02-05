class Solution
{
    //Function to count subarrays with 1s and 0s without extra functions usage
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        int pc0=0;
        int pc1=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        for(int ep=0 ; ep<arr.length ; ep++){
            if(arr[ep]==0)
            pc0++;
            else
            pc1++;
            int diff=pc1-pc0;
            ans+=map.getOrDefault(diff,0);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return  ans;
    }
}
