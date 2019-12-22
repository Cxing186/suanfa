package tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author kirit
 * @date 2019-11-30
 */
public class TreeTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                3, 2, 9, null, null, 10, null, null, 8, null, 4, null, null
        }));
        TreeNode treeNode = TreeProcess.createBinaryTree(list);
        System.out.println("前序遍历");
        TreeProcess.preOrderTraveral(treeNode);
        System.out.println();
        System.out.println(" 中序遍历");
        TreeProcess.inOrderTraveral(treeNode);
        System.out.println( );
        System.out.println("后序遍历");
        TreeProcess.postOrderTraveral(treeNode);
    }
}
