package zifu;

import java.util.List;
import java.util.Objects;

/**
 * author liuweilong
 * date 2019/8/29 11:54
 * desc
 */
public class Q6_convert {
    public String convert(String s, int numRows) {
        if (Objects.isNull(s) || s.length() == 1) {
            return s;
        }
        if (numRows == 0) {
            return s;
        }

        //实际行数减一
        int currentRow;
        int stepLength = (numRows - 1) * 2;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            int reali = i % stepLength;
            if (reali <= (numRows - 1)){
                currentRow = reali;
            } else {
                currentRow = stepLength - reali;
            }
            builders[currentRow].append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : builders) {
            result.append(builder.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "lsdjfasdfasdf";
        int numRows = 4;
        System.out.println(new Q6_convert().convert(str, numRows));
    }
}
