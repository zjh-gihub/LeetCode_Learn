package Easy;

import java.util.Arrays;

public class _977sortedSquares {
    public static void main(String[] args) {
        int [] nums ={-4,-3,2,1,10};
        int[] ints = sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int [] res = new int[len];
        res[0]=nums[0]*nums[0];
        for(int i=1;i<len;i++){
            res[i]=nums[i]*nums[i];
        }
        quicksort(res,0,res.length-1);
        return res;
    }
    public static void quicksort(int [] nums,int left,int right){
        int i,j,t,temp;
        if(left>right){
            return ;
        }

        //基准数
        temp = nums[left];
        i=left;
        j=right;
        while(i!=j){
            while(nums[j]>=temp&&i<j){
                j--;
            }
            while(nums[i]<=temp&&i<j){
                i++;
            }

            if(i<j){
                t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
            }
        }
        nums[left]=nums[i];
        nums[i]=temp;
        quicksort(nums,left,i-1);
        quicksort(nums,i+1,right);

    }
}
