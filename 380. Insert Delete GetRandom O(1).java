// 380. Insert Delete GetRandom O(1)
class RandomizedSet {
    HashMap<Integer, Integer> hm;
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (hm.containsKey(val)) {
            return false;
        }else{
            hm.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (hm.containsKey(val) == false) {
            return false;
        }

        int idx = hm.get(val);
          hm.remove(val);
        if (idx == list.size()-1) {
            list.remove(list.size()-1);
            return true;
        }
        int idx2 = list.size()-1;
        int temp = list.get(idx2);
        swap(idx,idx2);
        list.remove(list.size()-1);
        
        hm.put(temp,idx);
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
