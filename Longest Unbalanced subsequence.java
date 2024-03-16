// Longest Unbalanced subsequence java solution

import java.io.*;
import java.util.*;

public class Solution {
    public static int chkString(String s){
        Stack<Character> st = new Stack<>();
        int n=s.length();
        int i=0;
        while(i<n){
            if(st.size()==0){
                st.push(s.charAt(i));
            }else{
                if(s.charAt(i)==')' && st.peek()=='('){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
            i++;
        }
        int flag=0;
        
        if(st.size()==0){
            flag=1;
        }
        
        if(flag==0){
            return n;
        }else{
            return n-1;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String s= scn.nextLine();
        System.out.println(chkString(s));
    }
}
