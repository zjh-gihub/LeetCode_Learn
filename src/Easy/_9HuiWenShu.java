package Easy;


/**
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。*/
public class _9HuiWenShu {
    public static void main(String[] args) {
        System.out.println(IsPalindrome(1221));

    }

    //方法-bymyself
    public static boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        int num = x;
        int res = 0;
        while(num!=0){
            int tmp = num%10;
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return false;
            }

            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return false;
            }
            res = res*10+tmp;
            num=num/10;
        }

        return (res==x);
    }

    //方法2-byanswer
//    反转一半数字
//    考虑翻转数位数的奇偶性
    public static boolean IsPalindrome(int x){
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x<0||(x %10 == 0 && x!=0)){
            return false;
        }



        int res = 0;
        while(x>res){
            res = res*10+x%10;
            x=x/10;
        }


        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x==res||x==res/10;


    }


}
