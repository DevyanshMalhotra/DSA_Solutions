// Equal 0, 1 and 2 solution using extra function
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int[] pc0=countN(str,'0');
        int[] pc1=countN(str,'1');
        int[] pc2=countN(str,'2');
        HashMap<String,Long> map=new HashMap<>();
        map.put("0@0",1L);
        long ans=0;
        for(int ep=0 ; ep<str.length() ; ep++){
            int diff1=pc0[ep]-pc1[ep];
            int diff2=pc0[ep]-pc2[ep];
            String diff=diff1+"@"+diff2;
            ans+=map.getOrDefault(diff,0L);
            map.put(diff,map.getOrDefault(diff,0L)+1);
        }
        return  ans;
    }
    int[] countN(String s, char c)
    {
        int[] a=new int[s.length()];
        int chk=0;
        for(int i=0 ; i< a.length ; i++){
            if(s.charAt(i)==c){
                chk++;
            }
            a[i]=chk;
        }
        return a;
    }
} 
