// 76. Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {
        int slen=s.length();
        int tlen=t.length();
        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> tmap=new HashMap<>();

        if(slen < tlen){
            return "";
        }

        int matchCount=0;

        for(int i=0;i<tlen;i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }

        int sp=0;
        int ep=0;
        int anssp=0;
        int ansep=0;
        int anslen=Integer.MAX_VALUE;
        while(ep<slen){
            if(matchCount == tlen){
                if(ep-sp < anslen){
                    anssp=sp;
                    ansep=ep;
                    anslen=(ep-sp);
                }
                smap.put(s.charAt(sp),smap.get(s.charAt(sp))-1);
                if(smap.get(s.charAt(sp)) < tmap.getOrDefault(s.charAt(sp),0)){
                    matchCount--;
                }
                sp++;
            }else{
                smap.put(s.charAt(ep),smap.getOrDefault(s.charAt(ep),0)+1);
                if(smap.get(s.charAt(ep)) <= tmap.getOrDefault(s.charAt(ep),0)){
                    matchCount++;
                }
                ep++;
            }
        }

        while(matchCount == tlen){
            if(ep-sp < anslen){
                anssp=sp;
                ansep=ep;
                anslen=ep-sp;
            }
            smap.put(s.charAt(sp),smap.get(s.charAt(sp))-1);
            if(smap.get(s.charAt(sp)) < tmap.getOrDefault(s.charAt(sp),0)){
                matchCount--;
            }
            sp++;
        }

        return s.substring(anssp,ansep);
    }
}
