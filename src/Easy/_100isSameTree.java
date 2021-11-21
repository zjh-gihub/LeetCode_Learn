package Tests.LeetCode.easy;



public class _100isSameTree {
    public static void main(String[] args) {
        BinaryTree100 b1 = new BinaryTree100();
        BinaryTree100 b2= new BinaryTree100();
        TreeNode100 a1= new TreeNode100(1);
        TreeNode100 a2 = new TreeNode100(1);
        b1.setRoot(a1);;
        b2.setRoot(a2);

        System.out.println(isSameTree(b1.getRoot(),b2.getRoot()));
    }
    public static boolean isSameTree( TreeNode100 p, TreeNode100 q) {
        if(p==null&&q==null){
            return true;
        }
        else if (p==null||q==null){
            return false;
        }else if(p.val==q.val){
            return true;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
//Definition for a binary tree node.
class TreeNode100 {
  int val;
  TreeNode100 left;
  TreeNode100 right;
  TreeNode100() {}
  TreeNode100(int val) { this.val = val; }
  TreeNode100(int val, TreeNode100 left, TreeNode100 right) {
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
}

class BinaryTree100{
    private TreeNode100 root;

    public void setRoot(TreeNode100 root) {
        this.root = root;
    }

    public TreeNode100 getRoot() {
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
