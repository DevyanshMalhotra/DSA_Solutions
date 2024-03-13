import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        List<Integer> a1=new LinkedList<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=n-1 ; i>=0;i--){
            while(st.size()>0 && a[i]<a[st.peek()]){
                int tbs=st.pop();
                ans[tbs]=a[i];
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            a1.add(ans[i]);
        }
        return a1;
    }
}
