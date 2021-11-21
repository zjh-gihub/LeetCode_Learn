package Tests.LeetCode.easy;

import java.util.*;

public class _20Valid_parentheses {
    public static boolean isValid(String s) {
        if (s.length() == 0 && s.length() % 2 != 0) {
            return false;
        }
        boolean valid = false;
//        String s1 = s.substring(0, s.length() / 2);
//        String s2 = s.substring(s.length() / 2);
        int sum = 0;
        for (int i = s.length()/2 - 1; i >= 0; i--) {
                if (s.charAt(i) == '(' && s.charAt(s.length()-i-1) == ')'
                    || s.charAt(i) == '[' && s.charAt(s.length()-i-1) == ']'
                    || s.charAt(i) == '{' && s.charAt(s.length()-i-1) == '}') {
                    sum++;
            }

        }
        System.out.println(sum);
        return sum == (s.length()/2);
    }


    public static boolean isValid2(String s){
        Map<Character,Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stc = new Stack<Character>();
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stc.push(s.charAt(i));
            }
            if(stc.size()!=0&&s.charAt(i)==map.get(stc.peek())){
                stc.pop();
                sum++;
            }
        }
        return stc.size()==0&&sum==s.length()/2;

    }

    public static void main(String[] args) {
        String s =  ")()[()]}";
        System.out.println(isValid2(s));
    }

}