package cn.leithda;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: leithda
 * Date: 2021/3/4
 * Description: 测试
 */
public class Test {


    public static int[] findOrder(int nodeCount,int[][] edges){


        int prev,after; // 键值对前值和后值
        int sum = 0; // 全部节点索引之和
        Set<Integer> elementSet = new HashSet<>();

        for(int i = 1;i<nodeCount;i++){
            sum += i;
        }

        // 1. 找到开始节点
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            after = edge[1];
            elementSet.add(after);
        }

        for (Integer elem : elementSet) {
            sum-=elem;  // 开始节点
        }

        // 2. 构建执行树
        Multimap<Integer,Integer> tree = ArrayListMultimap.create();    // 借助 guaua 中的Multimap做 Map<Integer,List<Integer>>结构，避免手动初始化List


        return null;

    }

    public static void main(String[] args) {

    }
}
