package Tests.LeetCode.easy;

public class _1ADD {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,1};
        int []ans = twoSum(nums,2);
        System.out.println(ans);
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] arr = new int[2];
        int  len = nums.length;
        for(int i = 0;i<len;i++){
            for(int j = len-1;j>=0;j--){
                if ((nums[i]+nums[j])==target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}
