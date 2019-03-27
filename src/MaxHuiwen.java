/**
 * @author lwl
 * @date 2019/2/14 11:37
 * @description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class MaxHuiwen {
    /**
     * 传统方法，遍历每个中心，向两边扩展
     *
     * @param s
     * @return
     */
    public String longestPalindromeTradition(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int length = 1;
        int L = 0;
        int R = 0;
        for (int center = 0; center < s.length(); center++) {
            int tempLengthJiShu = lengthsSpreadCenter(s, center, center);
            int tempLengthOuShu = lengthsSpreadCenter(s, center, center + 1);
            int tempMax = Math.max(tempLengthJiShu, tempLengthOuShu);
            if (tempMax > length) {
                L = center - (length - 1) / 2;
                R = center + length / 2;
                length = tempMax;
            }
        }
        return s.substring(L, R + 1);
    }

    private int lengthsSpreadCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L + 1;
    }

    public static void main(String[] args) {
        System.out.println(new MaxHuiwen().longestPalindromeTradition("ssdfdqwewewe"));
        System.out.println(new MaxHuiwen().longestPalindromeTradition("shddhsaas"));
        System.out.println(new MaxHuiwen().longestPalindromeTradition("aa"));
        System.out.println(new MaxHuiwen().longestPalindromeTradition("a"));
    }
}