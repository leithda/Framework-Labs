package cn.leithda;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/2/24
 * Description: 面试题
 *
 * 给定一个字符串，请你找出其中最多有一个重复字符(该字符重复次数不受限)的最长子串的长度
 * 示例1：
 * 输入:  abcabcbb
 * 输出:5
 * 解释：最长子串abcbb，重复字符为b，长度为5
 */
public class Test {

    public static void test(char[] str, int n) {
        int stop = 1, start = 0, index = -1, max = 0;
        while (stop < n) {
            char stopValue = str[stop]; // 结束位置元素
            
            if (index == -1) {    // 当前无重复元素
                for (int i = stop - 1; i >= start; i--) {  // 判断新加入元素是否存在重复并更新重复元素下标
                    if (stopValue == str[i]) {
                        index = i;
                        break;
                    }
                }
            } else {  // 存在重复元素，即index != -1
                if (stopValue == str[index]) {    // 新元素和原有重复元素相同，更新重复元素下标
                    for (int j = stop - 1; j >= start; j--) {
                        if (stopValue == str[j]) {
                            index = j;
                            break;
                        }
                    }
                } else {  // 新元素和原有重复元素不相同，判断是否存在冲突
                    for (int k = stop - 1; k >= start; k--) {
                        if (stopValue == str[k]) {
                            System.out.println("存在冲突:(起:" + start + " -- 终：" + stop + " -- 重复下标:" + index + ")");
                            // 存在冲突
                            max = Math.max(stop - start, max);
                            start = ++index;
                            index = -1;
                            stop--;
                        }
                    }
                }
            }
            System.out.println("起:" + start + " -- 终：" + stop + " -- 重复下标:" + index + " -- 长度:" + max);
            stop++;
        }
        max = Math.max(stop - start, max);  // 计算结束子串长度
        System.out.println("Max：" + max);
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b', 'c', 'd'};
        test(str, str.length);
    }
}
