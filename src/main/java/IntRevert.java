import java.util.LinkedList;

/**
 * @author lwl
 * @date 2019/3/26 17:55
 * @description
 */
public class IntRevert {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        } else if (x > 0) {
            //i初始化10，x对i取模，一个个放到stack里，然后x / 10，当x！=0的时候循环结束，
            // 同时记录位，加一位，j初始化1，加一个数i * 10，然后取出来乘以对应的i，并将i / 10
           return reverseBig(x);
        }else {
            //小于0
            return 0 - reverseBig(-x);
        }
    }

    private int reverseBig(int x){
        int i = 10;
        long j = 1L;
        long temp = x;
        LinkedList<Long> queue = new LinkedList<>();
        while (temp != 0){
            long element = temp % i;
            queue.add(element);
            temp = temp / 10;
            if (temp != 0){
                j *= 10;
            }
        }
        long result = 0;
        while (!queue.isEmpty()){
            Long pop = queue.poll();
            result += pop * j;
            j = j / 10;
        }
        int intResult = (int) result;
        if (intResult != result){
            return 0;
        }
        return intResult;
    }

    public static void main(String[] args) {
        System.out.println(new IntRevert().reverse(1534236469));
        System.out.println(new IntRevert().reverse(342115));
        System.out.println(new IntRevert().reverse(-342115));
    }
}