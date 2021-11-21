package Tests.LeetCode.easy;

public class _27Remove_elements {
    public static void main(String[] args) {
        int[] nums = {4};
        System.out.println(removeElement2(nums, 3));

    }

    //该方法超出时间限制
    public static int removeElement(int[] nums, int val) {
        int p = 0;
        int q = 0;
        while (q < nums.length) {
            if (nums[p] != val) {
                q++;
                p++;
            }
            if (p<nums.length&&nums[p] == val) {
                for(;q<nums.length;q++){
                    if(nums[q]!=nums[p]){
                        int temp=nums[p];
                        nums[p]=nums[q];
                        nums[q]=temp;
                        p++;
                    }
                }
            }

        }

        for(int i=0;i<nums.length;i++){
            System.out.printf("%d"+" ",nums[i]);
        }
        System.out.println();
        return p ;
    }

    public static int removeElement2(int[] nums, int val) {
        int p = 0;
        int q = 0;
        while (q < nums.length) {
            if (nums[p] != val) {
                q++;
                p++;
            }else {
                if(nums[q]!=nums[p]){
                int temp=nums[p];
                nums[p]=nums[q];
                nums[q]=temp;
                p++;
            }else {q++;}}

        }


        for(int i=0;i<p;i++){
            System.out.printf("%d"+" ",nums[i]);
        }
        System.out.println();
        return p ;
    }
}
