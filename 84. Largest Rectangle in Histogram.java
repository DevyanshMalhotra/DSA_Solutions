// 84. Largest Rectangle in Histogram leetcode hard problem java code

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int ans=0;
        for(int i=0;i<=n;i++){
            int temp=0;
            if(i!=n){
                temp=heights[i];
            }
            while(st.size()>0 && temp<heights[st.peek()]){
                int tbs=st.pop();
                int ler=i;
                int x1=i-1;
                int lel=-1;
                if(st.size()>0){
                    lel=st.peek();
                }
                int x2=lel+1;
                int area=heights[tbs]*(x1-x2+1);
                ans=Math.max(ans,area);
            }
            st.push(i);
        }
        return ans;
    }
}
