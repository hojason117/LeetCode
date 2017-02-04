public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		for(int i = 0; i < numbers.length-1; i++) {
			int left = i + 1;
			int right = numbers.length - 1;
			int j = (left + right) / 2;

			while(true) {
				if(numbers[i] + numbers[j] == target) {
					int[] result = {i+1, j+1};
					return result;
				}
				else if(numbers[i] + numbers[j] < target) {
					if(j >= right)
						break;
					left = j + 1;
					j = (left + right) / 2;
				}
				else {
					if(j <= left)
						break;
					right = j - 1;
					j = (left + right) / 2;
				}
			}
		}

		int[] result = {0, 0};
		return result;
	}
}
