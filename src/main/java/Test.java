import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.ForkJoinPool;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/11 17:43
 */
public class Test {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            System.out.println("sdfdf");
        });
    }
}
