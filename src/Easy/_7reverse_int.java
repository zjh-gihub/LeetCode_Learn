package Tests.LeetCode.easy;


/**  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。*/

import java.util.Scanner;

public class _7reverse_int {
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("反转后：%d\n",reverse(num));



    }

    /**该方法没有考虑到溢出的情况（有问题）
    public static int reverse(int x) {
        int n = 0;
        if (x <= -1*Math.pow(2, 31) && x >= Math.pow(2, 31) - 1 || x == 0) {
            return 0;
        }

        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }*/

    //该方法考虑到溢出情况
    public static int reverse(int x){
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;

    }

}