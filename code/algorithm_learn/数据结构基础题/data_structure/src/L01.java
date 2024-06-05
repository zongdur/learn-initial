//fitten code 编程


//得到x的平方根的整数部分
//由于得到的是平方根的整数部分，所以在成绩小于x的时候，对index做出变动
//二分查找

public class L01 {
    public static void main(String[] args) {
        int x = 25;
        int result = sqrt(x);
        System.out.println(result);
    }

    public static int sqrt(int x) {
        //如果x小于2，直接返回x
        if (x < 2) {
            return x;
        }
        //取不到0，所以从1开始
        int left = 1;
        //一个数的平方根不会超过它的二分之一
        int right = x / 2;
        return binarySearch(left, right, x);
    }

    private static int binarySearch(int left, int right, int x) {
        int index = -1;
        while (left <= right) {
            //使用这种方法计算mid，防止溢出
            int mid = left + (right - left) / 2;
            //当给出的数不是整数时，找到它的整数部分
            if (mid * mid <= x) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }


}
