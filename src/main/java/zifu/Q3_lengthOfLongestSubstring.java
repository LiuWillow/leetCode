package zifu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * author liuweilong
 * date 2019/8/28 11:32
 * desc
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Q3_lengthOfLongestSubstring {
    /**
     * 记录最长子串长度初始值 maxLength 为1
     * 双指针扫描
     * 第一个指针 l 记录起始位置，第二个指针 r 记录结束为止，
     * 第二个指针从第一个指针位置开始扫描。扫描过的位置一旦有重复的就暂停，记录第二个指针的下标 - 第一个指针下标，更新到 maxLength
     * 第一个指针移动到与第二个指针所指的元素重复的位置 + 1的位置   第二个指针不变
     * 循环完毕，计算第二个指针和第一个指针的差 + 1的值，与result比较，取更大的
     * <p>
     * <p>
     * 怎么判断是否有重复的，并记录重复的位置？hashMap
     */

    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }
        int maxLength = 1;
        int l = 0;
        int r = l;
        Map<Character, Integer> existedMap = new HashMap<>();
        while (r < s.length()) {
            char key = s.charAt(r);
            Integer existedIndex = existedMap.get(key);
            if (existedIndex == null) {
                existedMap.put(key, r);
                r++;
            } else {
                existedMap.remove(key);
                maxLength = Math.max(maxLength, r - l);
                for (int i = l; i < existedIndex + 1; i++) {
                    existedMap.remove(s.charAt(i));
                }
                l = existedIndex + 1;
            }
        }

        return Math.max(maxLength, r - l);
    }


    public static void main(String[] args) {
        System.out.println(new Q3_lengthOfLongestSubstring().lengthOfLongestSubstring("abba"));
        System.out.println(new Q3_lengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Q3_lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Q3_lengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}
