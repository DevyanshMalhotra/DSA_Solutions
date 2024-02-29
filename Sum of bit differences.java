// Sum of bit differences java solution brute force followed by optimal


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().sumBitDifferences(arr, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java



// class Solution {
//     long sumBitDifferences(int[] arr, int n) {
//         // code here
//         long ans=0;
//         for(int i=0 ; i<n-1 ; i++){
//             for(int j=i+1 ; j<n ; j++){
                
//                 ans+=2*Integer.bitCount(arr[i]^arr[j]);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    long sumBitDifferences(int[] arr, int n) {
        long ans = 0;

        for (int i = 0; i < 32; i++) {
            int setBitsCount = 0;

            for (int j = 0; j < n; j++) {
                setBitsCount += (arr[j] >> i) & 1;
            }

            ans += (long) setBitsCount * (n - setBitsCount) * 2;
        }

        return ans;
    }
}

