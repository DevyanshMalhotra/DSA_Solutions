// 85. Maximal Rectangle leetcode hard java solution

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
              if(i==0){
                  arr[j]= matrix[i][j]-'0';
              }else {
                  if(matrix[i][j]=='1'){
                      arr[j] +=  matrix[i][j]-'0';
                  }else{
                      arr[j]=0;
                  } 
              }
            }
          maxi = Math.max(maxi,largestRectangleArea(arr));
      }
        
      return maxi;  
        
    }
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(int i = 0; i<=heights.length; i++){
            int temp = 0;
            if(i != heights.length) temp = heights[i];
            while(s.size()>0 && temp < heights[s.peek()]){
                int tbs = s.pop();
                int nsr = i;
                int x1 = nsr-1;
                int nsl = -1;
                if(s.size() != 0) nsl = s.peek();
                int x2 = nsl+1;
                int area = heights[tbs] * (x1 -x2 +1);
                ans = Math.max(ans,area);
            }
            s.push(i);
        }
        return ans;
    }
}

