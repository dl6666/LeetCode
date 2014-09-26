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
        // Set<UndirectedGraphNode> keySet = map.keySet();
        // for (UndirectedGraphNode curt : keySet) {
        //     UndirectedGraphNode newCurt = map.get(curt);
        //     List<UndirectedGraphNode> neighbors = curt.neighbors;
        //     for (UndirectedGraphNode nei : neighbors) {
        //         newCurt.neighbors.add(map.get(nei));
        //     }
        // }
        return map.get(node);
    }
	class UndirectedGraphNode {
	    int label;
	    List<UndirectedGraphNode> neighbors;
	    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
}
