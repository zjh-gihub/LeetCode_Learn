package Medium;

import org.omg.PortableInterceptor.INACTIVE;
import sun.security.krb5.internal.ktab.KeyTabInputStream;

import java.util.*;

public class _98isValidBST {
    public static void main(String[] args) {
        int []nums= {-10,-3,0,5,9};
        BinaryTree98 b1 = new BinaryTree98();

        TreeNode t0 = new TreeNode (4);
        TreeNode t1 = new TreeNode (2);
        TreeNode t2 = new TreeNode (7);
        TreeNode t3 = new TreeNode (1);
        TreeNode t4 = new TreeNode (3);
        TreeNode t5 = new TreeNode (9);
        TreeNode t6 = new TreeNode (3);

        t0.left=t1;
        t0.right=t2;
        t1.left=t3;
        t1.right=t4;
        t2.left=t6;
        t2.right=t5;

        b1.setRoot(t0);

        //中序遍历
        b1.infixOrder();

        //98. 验证二叉搜索树
        System.out.println("------验证二叉搜索树--------");
        System.out.println(isValidBST2(b1.getRoot()));
        System.out.println();

        //102. 二叉树的层序遍历
        System.out.println("-----二叉树的层序遍历-----");
        List<List<Integer>> lists = levelOrder(b1.getRoot());

        List<List<Integer>> lists1 = zigzagLevelOrder(b1.getRoot());


        levelOrderBottom(b1.getRoot());
    }

    /**98. 验证二叉搜索树*/
    //递归解法
    public static  boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    //中序遍历解法
    static long pre = Long.MIN_VALUE;
    public static boolean isValidBST2(TreeNode root){
        return inorder(root);
    }
    public static boolean inorder(TreeNode node) {
        if(node == null) return true;
        boolean l = inorder(node.left);
        if(node.val <= pre) return false;
        pre = node.val;
        boolean r = inorder(node.right);
        return l && r;
    }


    /** 102. 二叉树的层序遍历*/

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null){
            return null;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    /** 103. 二叉树的锯齿形层序遍历*/
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null){
            return null;
        }
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            Deque<Integer> leverlList = new LinkedList<Integer>();
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode curnode = queue.poll();
                if(flag){
                    leverlList.offerLast(curnode.val);
                }else{
                    leverlList.offerFirst(curnode.val);
                }
                if(curnode.left!=null){
                    queue.offer(curnode.left);
                }
                if(curnode.right!=null){
                    queue.offer(curnode.right);
                }
            }
            res.add(new LinkedList<Integer>(leverlList));
            flag=!flag;
        }

        return  res;
    }

    /** 107. 二叉树的层序遍历 II*/
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;



    }

    /** 109. 有序链表转换二叉搜索树*/
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode fast = head;
        ListNode slow = head;
        // 记录一下最中间节点的前驱结点
        ListNode pre = slow;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        // 断开链表，slow这个节点已经用过了，前后都需要断开
        slow.next = null;
        pre.next = null;
        root.left = sortedListToBST(head);
        return root;
    }

}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
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

class BinaryTree98{
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

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
