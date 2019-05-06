
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/6 18:04
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Q22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        int length = n * 2;
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                chars[i] = '(';
            } else {
                chars[i] = ')';
            }
        }
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(chars));

        for (int i = 1; i < length - 1; i++) {
            if (i % 2 != 0) {
                //需要交换到最后
                for (int j = i + 1; j < length; j += 2) {
                    exchangeAndRevert(chars, result, i, j);
                }
            }

            if (i % 2 == 0) {
                //不需要交换到最后
                for (int j = i + 1; j < length - 1 && j % 2 != 0; j += 2) {
                    exchangeAndRevert(chars, result, i, j);
                }
            }
        }
        return result;
    }

    private void exchangeAndRevert(char[] chars, List<String> result, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
        result.add(String.valueOf(chars));

        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        List<String> strings = new Q22_GenerateParenthesis().generateParenthesis(3);
        System.out.println(Arrays.toString(strings.toArray()));

        char[] chars = {'(', ')'};
        System.out.println(String.valueOf(chars));
    }
}
