package sparseArray;

/**
 * @author tmz
 * @data 2020/08/17
 * @version 1.0
 */
public class ArrUtil {
    private ArrUtil(){

    }

    /**
     * 将二维数组转化成稀疏数组
     * 步骤 ：1. 先求出二维数组的行和列 再求二维数组有多少个有值得个数
     * 2. 遍历数组 得到全部的值 分别求出每一个值得 行和列 、值 并记录在第二个开始
     * @param arr 二维数组 [行][列]
     * @return
     */
    public static int[][] parseArrSpare(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int cout = 0;
        int[][] sparearr = new int[][]{};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

            }
        }
        return null;
    }

    /**
     * 稀疏数组转 二维数组
     * 步骤 ： 1.根据稀疏数组第一行数据创建数组
     * 便利稀疏数组 根据 每个值的坐标赋值
     * @param spare
     * @return
     */
    public static  int[][] parseSpareToArr(int[][] spare){

        return null;
    }
}
