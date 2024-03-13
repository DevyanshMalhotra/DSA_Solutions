// Help Classmates gfg problem



import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 


class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> st=new Stack<>();
	    int[] ans=new int[n];
	    Arrays.fill(ans,-1);
	    for(int i=0 ; i<n ;i++){
	        while(st.size()>0 && arr[i]<arr[st.peek()]){
	            int tbf=st.pop();
	            ans[tbf]=arr[i];
	        }
	        st.push(i);
	    }
	    return ans;
	} 
}
