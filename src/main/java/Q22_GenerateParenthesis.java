
import java.util.*;

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
    private String leftKuohao = "(";
    private String rightKuohao = ")";
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        f(resultList, "", 0, 0, n);
        return resultList;
    }

    public void f(List<String> resultList, String str, int open, int close, int max) {
        if (open == max && close == max) {
            resultList.add(str);
            return;
        }
        if (open < max) {
            f(resultList, str + "(", open + 1, close, max);
        }
        if (close < open) {
            f(resultList, str + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Q22_GenerateParenthesis().generateParenthesis(2);
        System.out.println(Arrays.toString(strings.toArray()));
    }
}
