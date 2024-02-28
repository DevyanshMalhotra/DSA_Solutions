// Anagram Palindrome
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String s)
    {
        // your code here
        int slen=s.length();
        int count=0;
        HashMap<Character,Integer> smap=new HashMap<>();
        for(int i=0;i<slen;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character c:smap.keySet()){
            if(smap.get(c)%2!=0){
                count++;
            }
            if(count>1)
            return 0;
        }
        return 1;
    }
}
