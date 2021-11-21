package Tests.LeetCode.easy;

import java.util.Arrays;

public class _88MergeSortArray {
    public static void main(String[] args) {
        int [] num1 = {7,8,9,0,0,0};
        int []num2={2,7,8};
        merge2(num1,3,num2,3);
        System.out.println(Arrays.toString(num1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);


    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        while(n>0&&m>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[n+m-1]=nums1[m-1];
                m--;
            }else{
                nums1[n+m-1]=nums2[n-1];
                n--;
            }
        }
        for(int i=0;i<n;i++){
            nums1[i]=nums2[i];
        }
    }



}
