import java.util.PriorityQueue;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/11 17:43
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(0);
        for (Integer integer : priorityQueue) {
            System.out.println(integer);
        }
    }
}
