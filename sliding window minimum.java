// sliding window minimum java solution

import java.util.*;

class SlidingWindowMinimum {
	
	public ArrayList<Integer> getMinimums(ArrayList<Integer> nums, int k) {
		if (nums.size() == 0 || k <= 0) {
			return new ArrayList<>();
		}

		ArrayList<Integer> ans = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < nums.size(); i++) {
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.poll();
			}

			while (!dq.isEmpty() && nums.get(dq.peekLast()) > nums.get(i)) {
				dq.pollLast();
			}

			dq.offer(i);

			if (i >= k - 1) {
				ans.add(nums.get(dq.peek()));
			}
		}
		return ans;
	}
}
