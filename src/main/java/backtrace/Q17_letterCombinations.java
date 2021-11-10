package backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuweilong
 * @date 2021/11/8 2:18 下午
 * @description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q17_letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        int index = 0;
        StringBuilder temp = new StringBuilder();
        backTrace(digits, result, phoneMap, index, temp);
        return result;
    }

    private void backTrace(String digits, List<String> result, Map<Character, String> phoneMap, int index, StringBuilder temp) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }

        char c = digits.charAt(index);
        String characters = phoneMap.get(c);
        for (int i = 0; i < characters.length(); i++) {
            char candidate = characters.charAt(i);
            temp.append(candidate);
            backTrace(digits, result, phoneMap, index + 1, temp);
            temp.deleteCharAt(index);
        }
    }
}
