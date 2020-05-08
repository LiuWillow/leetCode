import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * author liuweilong
 * date 2020/4/5 8:28 下午
 * desc
 */
public class TestBackTrace {
    private char[] chars = new char[]{'A', 'B', 'C'};
    private boolean[] usedList = new boolean[3];

    public void test(){
        List<String> result = new ArrayList<>();
        backTrace(result, "", 0);
        result.forEach(System.out::println);
    }

    public void backTrace(List<String> resultList, String str, int level) {
        if (level == chars.length) {
            resultList.add(str);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (usedList[i]) {
                continue;
            }
            String tmpStr = str;
            tmpStr += chars[i];
            usedList[i] = true;
            backTrace(resultList, tmpStr, level + 1);
            usedList[i] = false;
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        new TestBackTrace().test();
    }
}
