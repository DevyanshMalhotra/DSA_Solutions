// 239. Sliding Window Maximum java solution
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int n=nums.length;
        for(int i=0 ; i<k ; i++){
            while(dq.size()>0 && nums[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        list.add(dq.getFirst());
        for(int i=k ; i< n ; i++){
            while(dq.size()>0 && nums[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
            if(nums[i-k]==dq.getFirst()){
                dq.removeFirst();
            }
            list.add(dq.getFirst());
        }
        int[] ans=new int[list.size()];
        int j=0;
        for(int i:list){
            ans[j]=i;
            j++;
        }
        return ans;
    }
}
