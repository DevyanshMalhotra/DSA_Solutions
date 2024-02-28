// 438. Find All Anagrams in a String

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen=s.length();
        int plen=p.length();
        List<Integer> ans=new ArrayList<>();
        int matchCount=0;
        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> pmap=new HashMap<>();
        if(plen > slen){
            return new ArrayList<>();
        }
        for(int i=0;i<plen;i++){
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
        }

        for(int i=0;i<plen;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            if(smap.get(s.charAt(i))<=pmap.getOrDefault(s.charAt(i),0)){
                matchCount++;
            }
        }
        if(matchCount == plen)
        ans.add(0);

        int sp=0;
        int ep=plen;

        while(ep<slen){
            smap.put(s.charAt(ep),smap.getOrDefault(s.charAt(ep),0)+1);
            if(smap.get(s.charAt(ep)) <= pmap.getOrDefault(s.charAt(ep),0)){
                matchCount++;
            }
            smap.put(s.charAt(sp),smap.get(s.charAt(sp))-1);
            if(smap.get(s.charAt(sp)) < pmap.getOrDefault(s.charAt(sp),0)){
                matchCount--;
            }
            if(matchCount == plen){
                ans.add(sp+1);
            }
            sp++;
            ep++;
        }
        return ans;
    }
}
