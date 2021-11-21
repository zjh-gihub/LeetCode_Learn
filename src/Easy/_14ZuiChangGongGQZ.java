package Tests.LeetCode.easy;

public class _14ZuiChangGongGQZ {
    public static void main(String[] args) {
        String [] strs = new String[]{"flower","flow","flight","fl0"};
        System.out.println(longestCommonPrefix(strs));
    }

    //别人的轻便解法
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String s = strs[0];
        for(String string : strs){
            while(!string.startsWith(s)){
                if(s.length()==0){
                    return "";
                }
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }

    //我的暴力解法
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length==0||strs.length==1){
            return "";
        }
        String s =new String();
        int len = strs[0].length()<strs[1].length()?strs[0].length():strs[1].length();
//        System.out.println(len);
        int j=0;
        for(;j<len;j++){
            if(strs[0].charAt(j)!=strs[1].charAt(j)){
                break;
            }
        }
        s=strs[0].substring(0,j);
        int k=2;
        while(k<strs.length){
            int lens = s.length()<strs[k].length()?s.length():strs[k].length();
            int i=0;
            for(;i<lens;i++){
                if(s.charAt(i)!=strs[k].charAt(i)){
                   break;
                }
            }
            s=s.substring(0,i);
            k++;
        }


        return s;




        }

}
