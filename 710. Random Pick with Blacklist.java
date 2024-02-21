// 710. Random Pick with Blacklist
class Solution {
    HashMap<Integer,Integer> map;
    Random r;
    int valid;
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();
        for(int i =0; i<blacklist.length; i++){
            map.put(blacklist[i],-1);
        }
        valid = n - blacklist.length;
        for(int i = 0; i<blacklist.length; i++){
            if(blacklist[i]<valid){
                while(map.containsKey(n-1)==true){
                    n--;
                }
                
                map.put(blacklist[i],n-1);
                n--;
            }
        }
        
    }
    
    public int pick() {
        int val = r.nextInt(valid);
        if(map.containsKey(val) == true ){
            return map.get(val);
        } else {
            return val;
        }
    }
}


