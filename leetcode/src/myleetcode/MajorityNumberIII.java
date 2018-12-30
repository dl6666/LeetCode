package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MajorityNumberIII {

	public int majorityNumber(ArrayList<Integer> nums, int k) {
        MyList list = new MyList();
        Map<Integer, Bucket> map = new HashMap<Integer, Bucket>();
        for (int i = 0; i < nums.size(); i++) {
            int curt = nums.get(i);
            if (map.containsKey(curt)) {
            	map.put(curt, list.moveAhead(map.get(curt), curt));
            } else if (map.size() >= k - 1) {
            	for (int j : list.head.pre.set) {
            		map.remove(j);
            	}
            	list.removeLast();
            } else {
            	map.put(curt, list.add(curt));
            }
        }
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i : map.keySet()) {
        	count.put(i, 0);
        }
        for (int i = 0; i < nums.size(); i++) {
        	int curt = nums.get(i);
        	if (count.containsKey(curt)) {
        		count.put(curt, count.get(curt) + 1);
        	}
        }
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
        	if (e.getValue() > nums.size() / k) {
        		return e.getKey();
        	}
        }
        return -1;
    }
	private class MyList {
		public Bucket head;
		public MyList() {
			head = new Bucket();
			head.pre = head;
			head.next = head;
		}
		public void addLast(Bucket b) {
			b.pre = head.pre;
			head.pre = b;
			b.next = head;
			b.pre.next = b;
		}
		public void removeLast() {
			head.pre =head.pre.pre;
			head.pre.next = head;
		}
		public Bucket moveAhead(Bucket b, int i) {
			b.set.remove(i);
			if (b.pre == head) {
				Bucket newBucket = new Bucket();
				newBucket.set.add(i);
				newBucket.pre = head;
				head.next = newBucket;
				b.pre = newBucket;
				newBucket.next = b;
				return newBucket;
			} else {
				b.pre.set.add(i);
				return b.pre;
			}
		}
		public Bucket add(int i) {
			if (head.pre == head) {
				Bucket newBucket = new Bucket();
				newBucket.set.add(i);
				addLast(newBucket);
				return newBucket;
			} else {
				head.pre.set.add(i);
				return head.pre;
			}
		}
	}
    private class Bucket {
        public HashSet<Integer> set;
        public Bucket pre;
		public Bucket next;
        public Bucket() {
            set = new HashSet<Integer>();
        }
    }
}
