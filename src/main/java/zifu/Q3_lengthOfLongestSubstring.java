package zifu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * author liuweilong
 * date 2019/8/28 11:32
 * desc
 */
public class Q3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || s.isEmpty()){
            return 0;
        }
        int begin = 0;
        int realIndex = begin;
        int maxLength = 1;
        char[] chars = s.toCharArray();
        int existIndex;
        while (++realIndex < s.length()) {
            //如果在begin（包含）和realIndex（不包含）之间已经存在字符
            existIndex = exist(chars, begin, realIndex - 1);
            if (existIndex != -1){
                maxLength = Math.max(realIndex - begin, maxLength);
                begin = existIndex + 1;
            }
        }
        return Math.max(realIndex - begin, maxLength);
    }

    private int exist(char[] chars, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (chars[i] == chars[end + 1]){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "aaad";
        System.out.println(new Q3_lengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
