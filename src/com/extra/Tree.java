package com.extra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

    public static void main(String[] args) {
        ArrayList<Integer> reslt = new ArrayList<>();
        TreeNode tree = new TreeNode(6, new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(7, null, new TreeNode(9, new TreeNode(8), null)));

       // prepordertreversaliterative(tree,reslt);
        //prepordertreversalrecurive(tree, reslt);
        //inpordertreversaliterative(tree,reslt);
        inpordertreversalrecursive(tree,reslt);

        for (Integer integer : reslt) {
            System.out.println(integer);
        }
    }
    public static ArrayList<Integer> inpordertreversaliterative(TreeNode tree, ArrayList<Integer> reslt) {
        Deque<TreeNode> queue = new ArrayDeque<>();


        while (tree!=null ||queue.size() > 0) {

                while(tree!=null){
                    queue.push(tree);
                    tree=tree.left;
                }
                tree=queue.pop();
                reslt.add(tree.val);
                    tree=tree.right;

        }
        return reslt;


    }
    public static ArrayList<Integer> inpordertreversalrecursive(TreeNode tree, ArrayList<Integer> reslt) {
        if(tree==null)return null;
        inpordertreversalrecursive(tree.left,reslt);
        reslt.add(tree.val);
        inpordertreversalrecursive(tree.right,reslt);


        return reslt;


    }

    public static void prepordertreversaliterative(TreeNode tree, ArrayList<Integer> reslt) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(tree);

        while (queue.size() > 0) {

            tree = queue.peek();
            reslt.add(queue.remove().val);
            if (tree.right != null) queue.push(tree.right);
            if (tree.left != null) queue.push(tree.left);
        }


    }
    public static List<Integer> prepordertreversalrecurive(TreeNode tree, ArrayList<Integer> result) {
        if(tree==null)return null;
        result.add(tree.val);
        prepordertreversalrecurive(tree.left,result);
        prepordertreversalrecurive(tree.right,result);
        return result;

    }

    public static void postpordertreversaliterative(TreeNode tree, ArrayList<Integer> reslt) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(tree);

        while (queue.size() > 0) {

            tree = queue.peek();
            reslt.add(queue.remove().val);
            if (tree.right != null) queue.push(tree.right);
            if (tree.left != null) queue.push(tree.left);
        }


    }
    public static List<Integer> postpordertreversalrecurive(TreeNode tree, ArrayList<Integer> result) {
        if(tree==null)return null;
        result.add(tree.val);
        prepordertreversalrecurive(tree.left,result);
        prepordertreversalrecurive(tree.right,result);
        return result;

    }




}



