// D. Same Differences
// "static void main" must be defined in a public class.
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static int[] newArr(Scanner scn,int n){
        int[] a=new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i]=scn.nextInt();
        }
        return a;
    }
    public static long getDiff(int[] arr,int n){
        HashMap<Integer,Integer> map=new HashMap<>();
        long ans=0;
        for(int i=0;i<n;i++){
            int diff=arr[i]-i;
            ans+=map.getOrDefault(diff,0);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        for(int i=0 ; i < t ; i++){
            int n= scn.nextInt();
            int[] arr=newArr(scn,n);
            long ans=getDiff(arr,n);
            System.out.println(ans);
        }
    }
}
