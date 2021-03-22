package zifu;

/**
 * author liuweilong
 * date 2019/8/29 10:31
 * desc
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * babada
 */
public class Q5_longestPalindrome {
    public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int realLeft = 0;
        int realRight = 0;
        int length = s.length();

        for (int i = 2; i <= length * 2 - 2; i++) {
            int gap = (i % 2) == 0 ? 1 : 2;
            int iLeft = i - gap;
            int iRight = i + gap;
            while (iLeft > 0 && iRight < length * 2 && s.charAt(iLeft / 2) == s.charAt(iRight / 2)) {
                iLeft -= 2;
                iRight += 2;
            }
            //循环结束时，left和right处于不相等的字符处
            int resultLength = realRight - realLeft + 1;
            //转换成相等的，真实的字符下标处
            int rightIndex = (iRight - 2) / 2;
            int leftIndex = (iLeft + 2) / 2;
            if (rightIndex - leftIndex + 1 > resultLength) {
                realLeft = leftIndex;
                realRight = rightIndex;
            }
        }
        return s.substring(realLeft, realRight + 1);
    }
}
