import java.util.*;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/5 18:21
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Q20_IsValid {
    public boolean isValid(String s) {
        Map<Character, Character> kuohao = new HashMap<>();
        kuohao.put(')', '(');
        kuohao.put(']', '[');
        kuohao.put('}', '{');

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c: chars) {
            if (c == ']' || c == '}' || c == ')'){
                if (stack.isEmpty()){
                    return false;
                }
                Character character = kuohao.get(c);
                Character pop = stack.pop();
                if (pop == null){
                    return false;
                }
                if (!character.equals(pop)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Q20_IsValid().isValid("{}}"));
        System.out.println(new Q20_IsValid().isValid("{}"));
        System.out.println(new Q20_IsValid().isValid("({})"));
        System.out.println(new Q20_IsValid().isValid("}"));
    }
}
