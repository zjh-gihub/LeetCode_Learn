package Easy;

import java.util.Arrays;

public class _189rotate {
    public static void main(String[] args) {
        int [] nums ={-4,-3,2,1,10};
        rotate(nums,2);
        System.out.println(Arrays.toString(nums));
    }
    /** ways1使用额外的数组来将每个元素放至正确的位置。
    用 nnn 表示数组的长度，我们遍历原数组，
    将原数组下标为 iii 的元素放至新数组下标为
    i的元素放置新数组下标为（i+k）%n的位置，
    最后将新数组拷贝到原数组
    * */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**ways2
     * 第一步：翻转整个数组
     * 第二步:从第k个元素后，将数组划分为左右两块子数组
     * 第三步：左右两子数组，各自翻转
     * 第四步：合并完成
     * */
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
