package com.dilin.java.practice.imp.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactsSearch {

	public List<List<Contact>> merge(List<Contact> list) {
		List<List<Contact>> res = new ArrayList<List<Contact>>();
		HashMap<String, List<Contact>> map = new HashMap<String, List<Contact>>();
		for (Contact c : list) {
			List<String> emails = c.emails;
			for (String e : emails) {
				if (map.containsKey(e)) {
					map.get(e).add(c);
				} else {
					List<Contact> lc = new ArrayList<Contact>();
					lc.add(c);
					map.put(e, lc);
				}
			}
		}
		for (List<Contact> lc : map.values()) {
			for (Contact c : lc) {
				
			}
		}
		return res;
	}
	private class Contact {
		public String name;
		public List<String> emails;
		public Contact (String name, List<String> emails) {
			this.name = name;
			this.emails = emails;
		}
	}
}
