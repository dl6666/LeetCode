package com.dilin.java.practice.myLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        if (node == null) return null;
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode curt = queue.poll();
            List<UndirectedGraphNode> neighbors = curt.neighbors;
            for (int i  = 0; i < neighbors.size(); i++) {
                UndirectedGraphNode curtNeighbor = neighbors.get(i);
                if (!map.containsKey(curtNeighbor)) {
                    map.put(curtNeighbor, new UndirectedGraphNode(curtNeighbor.label));
                    queue.offer(curtNeighbor);
                }
            }
        }
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curt = queue.poll();
            if (!set.contains(curt)) {
                List<UndirectedGraphNode> neis = curt.neighbors;
                UndirectedGraphNode newCurt = map.get(curt);
                for (int i = 0; i < neis.size(); i++) {
                    UndirectedGraphNode curtNei = neis.get(i);
                    newCurt.neighbors.add(map.get(curtNei));
                    queue.offer(curtNei);
                }
                set.add(curt);
            }
        }
        return map.get(node);
    }
//	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
//        ArrayList<UndirectedGraphNode> que = new ArrayList<UndirectedGraphNode>();
//        if (node == null) return null;
//        que.add(node);
//        map.put(node, new UndirectedGraphNode(node.label));
//        int tail = 0;
//        while(tail < que.size()) {
//            UndirectedGraphNode curt = que.get(tail++);
//            for (UndirectedGraphNode n : curt.neighbors) {
//                if (!map.containsKey(n)) {
//                    que.add(n);
//                    map.put(n, new UndirectedGraphNode(n.label));//should be added to the map once it is added to the queue
//                }
//            }
//        }
//        tail = 0;
//        while(tail < que.size()) {
//            UndirectedGraphNode curt = que.get(tail++);
//            List<UndirectedGraphNode> newNeighbors = map.get(curt).neighbors;
//            for (UndirectedGraphNode n : curt.neighbors) {
//                newNeighbors.add(map.get(n));
//            }
//        }
//        return map.get(node);
//    }
	class UndirectedGraphNode {
	    int label;
	    List<UndirectedGraphNode> neighbors;
	    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
}
