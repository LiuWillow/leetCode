/**
 * author liuweilong
 * date 2020/5/20 10:25 上午
 * desc
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * ()())()())()()()(()()(
 * ()))((()))
 */
public class Q32_longestValidParenttheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char left = '(';
        char right = ')';
        int[] dp = new int[s.length()];
        int max = 0;
        if (s.charAt(0) == left && s.charAt(1) == right) {
            dp[0] = 0;
            dp[1] = 2;
            max = 2;
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == right) {
                if (s.charAt(i - 1) == left) {
                    dp[i] = dp[i - 2] + 2;
                    max = Math.max(dp[i], max);
                } else {
                    int p = i - dp[i - 1] - 1;
                    if (p > -1 && s.charAt(p) == left) {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                        max = Math.max(dp[i], max);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(new Q32_longestValidParenttheses().longestValidParentheses(s));
    }
}