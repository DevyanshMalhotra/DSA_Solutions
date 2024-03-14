// 895. Maximum Frequency Stack

class FreqStack {
    HashMap<Integer, Stack<Integer>> st;
    HashMap<Integer, Integer> fmap;
    int maxfreq;

    public FreqStack() {
        st = new HashMap<>();
        fmap = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int val) {
        int f = fmap.getOrDefault(val, 0);
        f++;
        fmap.put(val, f);
        if (!st.containsKey(f)) {
            st.put(f, new Stack<Integer>());
        }
        st.get(f).push(val);
        maxfreq = Math.max(maxfreq, f);
    }

    public int pop() {
        int ans = st.get(maxfreq).pop();
        fmap.put(ans, fmap.get(ans) - 1);
        if (st.get(maxfreq).isEmpty()) {
            st.remove(maxfreq);
            maxfreq--;
        }
        return ans;
    }
}
