package Tests.LeetCode.easy;

public class _35InsertPositons {
    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        int target =6;
        System.out.println(searchInsert(nums,target));

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                //向右移动
                left += 1;
            } else if (target < nums[mid]) {
                right -= 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
