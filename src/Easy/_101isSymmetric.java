package Tests.LeetCode.easy;



import org.omg.PortableInterceptor.INACTIVE;
import sun.nio.cs.ext.MacThai;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.util.*;

public class _101isSymmetric {
    public static void main(String[] args) {

        int []nums= {-10,-3,-2,0,5,9};
        BinaryTree101 b1 = new BinaryTree101();

        TreeNode t0 = new TreeNode(4);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(9);

        t0.left=t1;
        t0.right=t2;
        t1.left=t3;
        t1.right=t4;
        t2.left=t5;
        t2.right=t6;


        b1.setRoot(t0);

//        //中序遍历
//        System.out.println("----中序遍历----");
//        b1.infixOrder();
//        System.out.println();
//
//        //判断是否为对称树
//        System.out.println("----判断是否为对称树------");
//        System.out.println(isSymmetric2(b1.getRoot()));
//        System.out.println();

        //将有序数组转换为二叉搜索树(二叉查找树)
        System.out.println("---将有序数组转换为二叉搜索树(二叉查找树)---");
        TreeNode TreeNode = TNode(nums,0,nums.length-1);
        TreeNode.inprilist();
        System.out.println();

//        //判断是否为平衡二叉树
//        System.out.println("--------判断是否为平衡二叉树-----");
//        System.out.println(isBalanced(b1.getRoot()));
//        System.out.println();
//
//        //返回最小深度
//        System.out.println("--------返回最小深度--------");
//        System.out.println(minDepth4(b1.getRoot()));
//        System.out.println();

//        //路径总和
//        System.out.println("-----------路径总和-----------");
//        System.out.println(hasPathSum(b1.getRoot(),7));
//        System.out.println();
//
//        //反转二叉树
//        System.out.println("---------反转二叉树---------");
//        invertTree(b1.getRoot());
//        b1.infixOrder();
//        System.out.println();
//
//        //二叉树的所有路径
//        System.out.println("---------二叉树的所有路径---------");
//        List<String> strings = binaryTreePaths(b1.getRoot());
//        System.out.println(strings);
//        System.out.println();
//
//        //左叶子之和
//        System.out.println("---------左叶子之和-----------");
//        int i = sumOfLeftLeaves(b1.getRoot());
//        System.out.println(i);
//        System.out.println();

    }
    /**
     * 104判断是否为对称树way1
    */
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return issame(root.left,root.right);

    }
    //判断是否为对称树
    public static boolean issame(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return issame(left.left,right.right);
    }

    /**
     * 判断是否为对称树way2
     */
    public static boolean isSymmetric2(TreeNode root2) {
        if (root2 == null || (root2.left == null && root2.right == null)) {
            return true;
        }
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root2.left);
        queue.add(root2.right);
        while (queue.size() > 0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }


    /**
     * 104返回最大深度
     * */
    public static int maxDepth(TreeNode root) {

        return Math.max(root.left == null ? 0 : maxDepth(root.left), root.right == null ? 0 : maxDepth(root.right))+1;
    }

    /**
     * 108. 将有序数组转换为二叉搜索树(二叉查找树)
    * */
    //----------递归-------------
    public static TreeNode TNode(int []nums,int left,int right){
        if(left>right){
            return null;
        }

        //总是选择中间的点作为根节点
        int mid =(left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=TNode(nums,left,mid-1);
        root.right=TNode(nums,mid+1,right);
        return root;
    }

    /** 110判断二叉树是否为平衡二叉树
    * */
    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        

    }
    public static int height (TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(root.left == null ? 0 : height(root.left), root.right == null ? 0 : height(root.right))+1;
    }

    /**111.返回二叉树的最小深度
     * */
    public static int minDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        if(left==0){
            return right+1;
        }else if(right==0){
            return left+1;
        }
        return Math.min(left,right)+1;
    }

    public static int minDepth(TreeNode root){
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和右孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }

    //深度优先遍历方式
    public static int minDepth3(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if(root.left!=null){
           min = Math.min(minDepth3(root.left),min);
        }
        if(root.right!=null){
            min = Math.min(minDepth3(root.right),min);
        }
        return min+1;

    }

    //广度优先遍历方式
    public static int minDepth4(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        root.deep=1;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left==null&&node.right==null){
                return node.deep;
            }
            if(node.left!=null){
                node.left.deep=node.deep+1;
                queue.offer(node.left);
            }
            if(node.right!=null){
                node.right.deep=node.deep+1;
                queue.offer(node.right);
            }
        }
        return 0;

    }

    /**112. 路径总和(遇到一个节点减去对应节点地值)
    * */
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
        {
            return targetSum-root.val==0;
        }
        boolean a = hasPathSum(root.left,targetSum-root.val);
        boolean b = hasPathSum(root.right,targetSum-root.val);
        return a||b;


    }

    /**226.反转二叉树     * */

    public static TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    /** 257. 二叉树的所有路径*/
    static List<String> res = new ArrayList<>();    // 存储结果
    static LinkedList<String> path = new LinkedList<>();  // 存储单个路径
    public static List<String> binaryTreePaths(TreeNode root) {
        Zui(root);
        return res;
    }

    public static void Zui(TreeNode root){
        if (root == null) {
            return;
        }
        // 前序遍历位置
        path.add(String.valueOf(root.val));
        // 到叶子节点就返回
        if (root.left == null && root.right == null) {
            // 添加到结果中
            res.add(String.join("->", path));
        }
        Zui(root.left);
        Zui(root.right);
        path.removeLast();

    }


    /** 235. 二叉搜索树的最近公共祖先
    解析：
     * 如果两个节点值都小于根节点，说明他们都在根节点的左子树上，我们往左子树上找
     * 如果两个节点值都大于根节点，说明他们都在根节点的右子树上，我们往右子树上找
     * 如果一个节点值大于根节点，一个节点值小于根节点，说明他们他们一个在根节点的左子树上一个在根节点的右子树上，那么根节点就是他们的最近公共祖先节点。
    */
    //非递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果根节点和p,q的差相乘是正数，说明这两个差值要么都是正数要么都是负数，也就是说
        //他们肯定都位于根节点的同一侧，就继续往下找
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        //如果相乘的结果是负数，说明p和q位于根节点的两侧，如果等于0，说明至少有一个就是根节点
        return root;
    }

    //递归
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        //如果小于等于0，说明p和q位于root的两侧，直接返回即可
        if ((root.val - p.val) * (root.val - q.val) <= 0)
            return root;
        //否则，p和q位于root的同一侧，就继续往下找
        return lowestCommonAncestor2(p.val < root.val ? root.left : root.right, p, q);
    }

    /** 404. 左叶子之和*/
    static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        //树为空直接返回0
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }//题目中说的左叶子需要注意！！！  叶子节点指左右子节点都为空
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }

    /** ----------------------- */





}



//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  int deep;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }

    //中序遍历
    public void inprilist(){
        //向左遍历
        if(this.left!=null){
            this.left.inprilist();
        }
        System.out.println(this);
        //向右遍历
        if(this.right!=null){
            this.right.inprilist();
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

class BinaryTree101{
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    //中序遍历
    public void infixOrder() {
        if(this.root != null) {
            this.root.inprilist();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}