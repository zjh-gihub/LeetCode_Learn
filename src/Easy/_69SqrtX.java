package Tests.LeetCode.easy;

public class _69SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt3(99));
        System.out.println(Math.sqrt(2147395600));


    }
    /**
     * 乘法会溢出，导致结果错误
     * */
    public static  int mySqrt1(int x) {
        if(x==1){
            return 1;
        }
        int m=0;
        int j=0;
        int i =x/2;
        while(true){
            /**
             * 乘法会溢出，导致结果错误
            * */
            if(i*i<=x){
                j=i;
                break;
            }
            i =i/2;
        }

        for(int k =j;k<+2*j+1;k++){
            if(k*k<=x&&((k+1)*(k+1))>x){
                m=k;
                break;
            }
        }
        return m;
    }

    /**
     * 乘法会溢出，导致结果错误  我来改用除法
     * */
    public static  int mySqrt2(int x) {
        if(x==1){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int m=0;
        int j=0;
        int i =x/2;
        while(true){
            if(x/i>=i){
                j=i;
                break;
            }
            i =i/2;
        }

        for(int k =j;k<=2*j+1;k++){
            if((x/k)>=k&&(x/(k+1))<(k+1)){
                m=k;
                break;
            }
        }
        return m;
    }

    /**
        优质解答*/
    public static int mySqrt3(int x){
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;
    }
}
