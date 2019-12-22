package tree;

import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedList;

/**
 * @author kirit
 * @date 2019-11-30
 */
public class TreeProcess {
    /**
     * 将链表转化成二叉树,通过递归调用
     * @param linkedList 链表内的数据必须为前序遍历的顺序
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> linkedList){
        TreeNode treeNode = null;
        if(CollectionUtils.isEmpty(linkedList)){
            return treeNode;
        }
        Integer data = linkedList.removeFirst();
        if(data != null){
            treeNode = new TreeNode(data);
            treeNode.setLeftChild(createBinaryTree(linkedList));
            treeNode.setRightChild(createBinaryTree(linkedList));
        }
        return treeNode;
    }

    /**
     * 前序遍历
     */
    public static void preOrderTraveral(TreeNode treeNode){
        if(null == treeNode){
            return;
        }
        System.out.print(treeNode.getData()+",");
        preOrderTraveral(treeNode.getLeftChild());
        preOrderTraveral(treeNode.getRightChild());
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraveral(TreeNode treeNode){
        if(null == treeNode){
            return;
        }
        inOrderTraveral(treeNode.getLeftChild());
        System.out.print(treeNode.getData()+",");
        inOrderTraveral(treeNode.getRightChild());
    }

    /**
     * 后序遍历
     */
    public static void postOrderTraveral(TreeNode treeNode){
        if(null == treeNode){
            return;
        }
        postOrderTraveral(treeNode.getLeftChild());
        postOrderTraveral(treeNode.getRightChild());
        System.out.print(treeNode.getData()+",");
    }
}
