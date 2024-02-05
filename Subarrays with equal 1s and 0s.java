// Subarrays with equal 1s and 0s solution with t.c:O(n)

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        int[] pc0=pcount0(arr);
        int[] pc1=pcount1(arr);
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        for(int ep=0 ; ep<arr.length ; ep++){
            int diff=pc1[ep]-pc0[ep];
            ans+=map.getOrDefault(diff,0);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return  ans;
    }

// using separate functions
    public static int[] pcount0(int arr[]){
        int q=0;
        int[] p=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                q++;
            }
            p[i]=q;
        }
        return p;
    }
    public static int[] pcount1(int arr[]){
        int q=0;
        int[] p=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                q++;
            }
            p[i]=q;
        }
        return p;
    }
}
