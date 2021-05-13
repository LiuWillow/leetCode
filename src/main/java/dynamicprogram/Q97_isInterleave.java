package dynamicprogram;

/**
 * @author liuweilong
 * @date 2021/5/12
 * @description 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 */
public class Q97_isInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        //f(i,j)=(f(i - 1, j) and s1[i] == s3[i + j - 1]) or (f(i, j - 1) and s2[j] == s3[i + j - 1])
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (m + n != l) {
            return false;
        }
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    //这里的i不是指字符下标，而是字符个数
                    f[i][j] = f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[m][n];
    }

    public boolean isInterleave_official(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[] f = new boolean[m + 1];

        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[m];
    }


    public static void main(String[] args) {
        String s1 = "ssaaqqq";
        String s2 = "ddllkk";
        String s3 = "ssddlaalkqqqk";
        System.out.println(new Q97_isInterleave().isInterleave(s1, s2, s3));
    }
}