package myleetcode;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(longestIncreasingSubsequence(new int[] {88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59}));
		
	}
	public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    max = Math.max(max, f[j]);
                }
            }
            f[i] = max + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
        	max = Math.max(max, f[i]);
        }
        return max;
    }
}
