package zifu;

/**
 * author liuweilong
 * date 2019/8/27 16:47
 * desc
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Q28_strStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int result = -1;
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int hayLength = haystack.length();
        int needleLength = needle.length();

        out:
        for (int i = 0; i < haystackChars.length; i++) {
            if (haystackChars[i] != needleChars[0]) {
                continue;
            }
            //这里循环needle
            for (int j = 1; j < needleChars.length; j++) {
                if (hayLength - i < needleLength) {
                    break out;
                }
                if (needleChars[j] != haystackChars[i + j]) {
                    continue out;
                }
            }
            result = i;
            break;
        }
        return result;
    }

    public static void main(String[] args) {
        String hayStack = "lalalalaa";
        String needle = "lal";
        System.out.println(new Q28_strStr().strStr(hayStack, needle));
    }
}
