/*
 * This class sets up the has table data structure along with
 * the utility methods to manipulate it.
 */
public class HashTable {

	private Node[] map;
	private int tableSize;
	
	// constructor
	public HashTable(int tableSize) {
		map = new Node[tableSize];
		this.tableSize = tableSize;
	}
	
	/*
	 * This is the hash function.
	 * For this hash function, return 0 if key is the empty string.
	 * Otherwise, calculate the sum of the ASCII values of the characters in key
	 * and find the remainder when divided by 8 (remember mod divisision %).
	 * Check the java API for String methods that may be helpful.
	 */
	private int hash(String key) {
		if (key == null) {
			return 0;
		} else {
			String[] code = key.split("");
			int num = 0;
			for (int i = 0; i < code.length; i ++) {
				num = code[i].hashCode() + num;
			}
			num = num % 8;
			return Math.abs(num);
		}
		// your code here
	}
	
	/*
	 * This method should insert a node containing the given key
	 * in the proper bucket in the hash table.  Insert new nodes
	 * at the head of each linked list for ease of implementation.
	 */
	public void insert(String key) {
		Node n = new Node(key);
		if (map[hash(key)] != null) {
			Node temp = new Node(map[hash(key)].record);
			map[hash(key)].record = key;
			map[hash(key)].next = temp;
		} else {
			map[hash(key)] = n;
		}
		// your code here
	}
	
	/*
	 * This method returs true if the search key is contained in the
	 * hash table, and false otherwise.
	 */
	public boolean search(String key) {
		int num = hash(key);
		Node pointer = map[num];
		int i = 0;
		while (pointer != null && i == 0) {
			if (pointer.record == map[num].record) {
				i ++;
			} else {
				pointer = pointer.next;
			}
		}
		if (i == 1) {
			return false;
		} else {
			return true;
		}
		// your code here
	}
	
	/*
	 * This method should print out the hash table row by row.
	 * Each line should print out a separate row of the table.
	 * Print the index followed a colon and then the records in that
	 * bucket with spaces between them.
	 * 
	 * For example:
	 * 1: Nicholas Mary Kim Jack
	 */
	public void printTable() {
		Node pointer = map[0];
		for (int i = 0; i < map.length; i++) {
			while (pointer != null) {
				System.out.println(i + ": " + pointer.record);
				pointer = pointer.next;
			}
			pointer = map[i];
			
		}
		// your code here
	}
	
	/*
	 * This method should delete ALL nodes matching the search key.
	 */
	public void delete(String key) {
		int num = hash(key);
		Node pointer = map[num];
		int i = 0;
		while (pointer != null && i == 0) {
			if (pointer.next.record.equals(key)) {
				pointer.next = null;
				i ++;
			} else {
				pointer = pointer.next;
			}
		
		}
		// your code here
	}
	
}
