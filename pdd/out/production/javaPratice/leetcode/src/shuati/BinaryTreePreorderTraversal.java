package shuati;

import Lei.TreeNode;

import java.util.ArrayList;
import java.util.List;

//二叉树的前序遍历
public class BinaryTreePreorderTraversal {
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res){
        if (root == null)
            return ;
        res.add(root.val);
        preOrder(root.left,res);
    }
}
