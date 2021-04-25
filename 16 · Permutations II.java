public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		
		if (nums == null) {
			return results;
		}
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		bfs(nums, results, list, visited);
		return results;
	}
	
	private void bfs(int[] nums, List<List<Integer>> results, List<Integer> list, boolean[] visited) {
		if (list.size() == nums.length) {
			results.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
				continue;
			}
			visited[i] = true;
			list.add(nums[i]);
			bfs(nums, results, list, visited);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}

};
