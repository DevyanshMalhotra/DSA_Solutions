// 381. Insert Delete GetRandom O(1) - Duplicates allowed
class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> map;
    ArrayList<Integer> list;
    Random r;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        HashSet<Integer> set;
        boolean flag;
        if(map.containsKey(val)){
            set = map.get(val);
            flag = false;
        } else {
            set = new HashSet<>();
            flag = true;
        }
        set.add(list.size());
        map.put(val,set);
        list.add(val);
        return flag;
    }
    
    public boolean remove(int val) {
        HashSet<Integer> set;
        if(map.containsKey(val)==true){
            set = map.get(val);
        } else {
            return false;
        }
        int remidx = -1;
        for(int x : set){
            remidx = x;
            break;
        }
        set.remove(remidx);
        map.put(val,set);
        if(remidx == list.size()-1){
            list.remove(list.size()-1);
        }else{
            int idx2 = list.size()-1;
            int temp = list.get(idx2);
            swap(remidx,idx2);
            list.remove(list.size()-1);
            HashSet<Integer> s = map.get(temp);
            s.remove(idx2);
            s.add(remidx);
            map.put(temp,s);
        }
        if(map.get(val).size()==0){
            map.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
      public void swap(int i,int j){
        int a = list.get(i);
        int b = list.get(j);
        list.set(i,b);
        list.set(j,a);
    }
}
