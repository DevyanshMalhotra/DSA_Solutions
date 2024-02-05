// Equal 0, 1 and 2 solution without using extra function
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int pc0=0;
        int pc1=0;
        int pc2=0;
        HashMap<String,Long> map=new HashMap<>();
        map.put("0@0",1L);
        long ans=0;
        for(int ep=0 ; ep<str.length() ; ep++){
            if(str.charAt(ep)=='0')
            pc0++;
            else if(str.charAt(ep)=='1')
            pc1++;
            else
            pc2++;
            int diff1=pc0-pc1;
            int diff2=pc0-pc2;
            String diff=diff1+"@"+diff2;
            ans+=map.getOrDefault(diff,0L);
            map.put(diff,map.getOrDefault(diff,0L)+1);
        }
        return  ans;
    }
} 
