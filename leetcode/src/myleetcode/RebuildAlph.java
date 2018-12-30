package myleetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RebuildAlph {

	private HashMap<Character,Node> map;
	private Comparator<Node> comp = new Comparator<Node>(){
		@Override
		public int compare (Node node1, Node node2) {
			return node1.indegree - node2.indegree;
		}
	};
	private PriorityQueue<Node> heap = new PriorityQueue<Node>(26, comp);
	
	public String buildAlph (String[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			insertConstraint(inputs[i]);
		}
		String output = getTSort();
		return output;
	}
	public String getTSort() {
		if (this.map.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		while (!heap.isEmpty() && heap.peek().indegree == 0) {
			Node curt = heap.poll();
			sb.append(curt.l);
			for (Node n : curt.decs) {
				if (n != null) {
					n.indegree--;
				}
			}
		}
		return sb.toString();
	}
	public void insertConstraint(String input) {
		char pre = '0';
		for (int i = 0; i < input.length(); i++) {
			char curt = input.charAt(i);
			if (pre != '0') {
				if (map.containsKey(pre)) {
					Node temp = map.get(pre);
					if (map.containsKey(curt)) {
						temp.decs[curt - 'a'] = map.get(curt);
					} else {
						Node newOne = new Node(curt);
						map.get(pre).decs[curt - 'a'] = newOne;
						map.put(curt, newOne);
						heap.add(newOne);
					}
				} else {
					Node temp = new Node(pre);
					heap.add(temp);
					map.put(pre, temp);
					if (map.containsKey(curt)) {
						temp.decs[curt - 'a'] = map.get(curt);
					} else {
						Node newOne = new Node(curt);
						map.get(pre).decs[curt - 'a'] = newOne;
						map.put(curt, newOne);
						heap.add(newOne);
					}
				}
				map.get(curt).indegree++;
			}
			pre = curt;
		}
	}
	public RebuildAlph() {
		this.map = new HashMap<Character, Node>();
	}
	private class Node {
		public Node[] decs;
		public char l;
		int indegree = 0;
		public Node (char l) {
			decs = new Node[26];
			this.l = l;
		}
	}
}
