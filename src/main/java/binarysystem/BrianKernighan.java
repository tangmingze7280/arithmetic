package binarysystem;

/**
 * @program: arithmetic
 * @description: Brian Kernighan法 求二进制中 1的个数 n&(n-1)==0 证明 n为2的n次幂
 * 1111 ->15
 *
 * @author: tmz
 * @create: 2020-08-19 09:22
 */
public class BrianKernighan {
    public static void main(String[] args) {
        System.out.println(0xFF);
        System.out.println(getBrianKernighan(15));
    }
    private static int getBrianKernighan(int aim){
        int count = 0;
        while (aim!=0){
            //左移
            aim&=aim-1;
            count++;
        }
        return count;
    }
}
