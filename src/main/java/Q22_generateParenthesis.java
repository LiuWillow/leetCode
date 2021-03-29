import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/3/29
 * @description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Q22_generateParenthesis {
    private StringBuilder current = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, result);
        return result;
    }
    //n ln rn list

    void generateParenthesis(int n, int ln, int rn, List<String> resultList) {
        if (ln == n && rn == n) {
            resultList.add(current.toString());
            return;
        }
        if (ln < n) {
            current.append("(");
            generateParenthesis(n, ln + 1, rn, resultList);
            current.deleteCharAt(current.length() - 1);
        }
        if (rn < ln) {
            current.append(")");
            generateParenthesis(n, ln, rn + 1, resultList);
            current.deleteCharAt(current.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> strings = new Q22_generateParenthesis().generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
