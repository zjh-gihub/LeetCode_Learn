package Tests.LeetCode.easy;

public class _53MaxXuHe {
    public static void main(String[] args) {
        int [] nums = {-1};
        int max = maxSubArray(nums);
        System.out.println(max);

    }


    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                j = i;
            }
        }
        if (max <= 0) {
            return max;
        }

        for (int k = j; k < j + max && k < nums.length; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
