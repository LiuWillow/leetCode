/**
 * author liuweilong
 * date 2020/5/8 10:05 上午
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q28_strStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        final char[] hayChars = haystack.toCharArray();
        final char[] needleChars = needle.toCharArray();
        int j = 0;
        while (j < hayChars.length) {
            if (hayChars[j] == needleChars[0]) {
                int x = j;
                j++;
                int tempj = j;
                for (int i = 1; i < needleChars.length; i++) {
                    if (tempj < hayChars.length && hayChars[tempj] == needleChars[i]) {
                        tempj++;
                    }
                }
                if (tempj - x == needle.length()) {
                    return x;
                }
            } else {
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q28_strStr().strStr("acabacacab", "acac"));
    }
}
