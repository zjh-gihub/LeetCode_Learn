package Tests.LeetCode.easy;

public class _58ZuiHouDanCiLength {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(s.length()-1);
        System.out.println(lengthOfLastWord(s));

    }

    public  static int lengthOfLastWord(String s) {
        int j=s.length()-1;
        int i = j;
        while(i>=0){
            while(i>=0&&j>=0&&s.charAt(i)==' '&&s.charAt(j)==' '){
                i-=1;
                j-=1;
            }
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            break;
        }
        return j-i;
    }

    public static int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
