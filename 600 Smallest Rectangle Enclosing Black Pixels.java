// 600 Smallest Rectangle Enclosing Black Pixels

// use binary search to find the up, down, left and right limit

public class Solution {

    public int minArea(char[][] image, int x, int y) {
        // write your code here
		if (image == null || image.length == 0 || image[0].length == 0) {
			return 0;
		}
		int m = image.length;
		int n = image[0].length;
		
		if (x < 0 || y < 0 || x > m || y > n) {
			return 0;
		};
		
		int up = 0, down = 0, left = 0, right = 0;
		
		int start = 0;
		int end = x;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (checkRow(image, mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (checkRow(image, start)) {
			up = start;
		} else {
			up = end;
		}
		
		start = x;
		end = m - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (checkRow(image, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (checkRow(image, end)) {
			down = end;
		} else {
			down = start;
		}
		
		start = 0;
		end = y;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (checkCol(image, mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (checkCol(image, start)) {
			left = start;
		} else {
			left = end;
		}
		
		start = y;
		end = n - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (checkCol(image, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (checkCol(image, end)) {
			right = end;
		} else {
			right = start;
		}
		
		return (down - up + 1) * (right - left + 1);
	}
	
	private boolean checkCol(char[][] image, int col) {
		for (int i = 0; i < image.length; i++) {
			if (image[i][col] == '1') {
				return true;
			} 
		}
		return false;
	}
	
	private boolean checkRow(char[][] image, int row) {
		for (int i = 0; i < image[0].length; i++) {
			if (image[row][i] == '1') {
				return true;
			}
		}
		return false;
	}
}
