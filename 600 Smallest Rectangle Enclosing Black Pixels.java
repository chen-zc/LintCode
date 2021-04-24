// 600 Smallest Rectangle Enclosing Black Pixels

// use binary search to find the up, down, left and right limit

public class Solution {

	public int findArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return 0;
		}
		int m = image.length;
		int n = image[0].length;
		
		if (x < 0 || y < 0 || x > m || y > n) {
			return 0;
		};
		
		int up, down, left, right;
		
		int start = 0;
		int end = x;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (checkCol(image, mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
	}
	
	private boolean checkCol(char[][] image, int col) {
	
	}

}
