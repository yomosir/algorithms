package leetcode.string;

/**
 * @author zhengguochun
 * @description
 * @date 2022-03-29
 */
public class Solution05 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababd"));
    }

    public static String longestPalindrome(String s) {
        if (null == s || s.length() == 0){
            return "";
        }
        int len = s.length();
        if (1 == len){
            return s;
        }
        int maxLength = 0;
        int left = 0;
        int right = 0;
        // 记录dp公式状态的数组
        boolean[][] dp = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if (s.charAt(i) == s.charAt(j) && ( j - i <= 1 || dp[i+1][j-1])){
                    // 如果当前位置的字符串相等 & （两个是相邻的或者他们的上一步的状态是回文）
                    dp[i][j] = true;
                }
                // 如果此时的长度已经比之前长，则可以替换
                if (dp[i][j] && j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
