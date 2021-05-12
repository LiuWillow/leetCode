package util;

import java.util.List;

/**
 * @author liuweilong
 * @date 2021/5/12
 * @description
 */
public class Lists {
    public static <T> void print(List<T> list) {
        System.out.println(list.stream().map(Object::toString).reduce((a, b) -> a + "," + b).map(a -> "[" + a + "]").orElse("[]"));
    }
}
