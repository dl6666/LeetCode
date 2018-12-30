package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeZigZagOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        boolean reverse = false;
        if (root != null) {
            que.offer(root);
        }
        while (!que.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curt = que.poll();
                temp.add(curt.val);
                if (curt.left != null) {
                    que.offer(curt.left);
                }
                if (curt.right != null) {
                    que.offer(curt.right);
                }
            }
            if (reverse) {
                int start = 0;
                int end = size - 1;
                while (start < end) {
                    int t = temp.get(start);
                    temp.set(start, temp.get(end));
                    temp.set(end, t);
                    start++;
                    end--;
                }
            }
            res.add(temp);
            reverse = !reverse;
        }
        return res;
    }
}
