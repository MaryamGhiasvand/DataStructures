package DataStructure;

public class DoubleLinkedList {

	Node header;

	DoubleLinkedList() {
		header = new Node(null, null, null);
	}

	public boolean isEmpty() {
		if (header.next == null)
			return true;
		else
			return false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node curr = header.next;
		while (curr != null) {
			if (curr.next != null)
				sb.append(curr.value + "-> ");
			else
				sb.append(curr.value);
			curr = curr.next;
		}
		return sb.toString();
	}

	class Node {
		Node previous;
		String value;
		Node next;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}
	}

	private void addLast(String string) {
		if (header.next == null) {
			// EMPTY
			Node n = new Node(header, string, null);
		} else {
			Node t = header.next;
			while (t.next != null) {
				t = t.next;
			}
			Node newNode = new Node(t, string, null);
			t.next = newNode;
		}
	}

	public void addFirst(String s) {
		if (header.next == null) {
			Node n = new Node(header, s, null);
			header.next = n;
		} else {
			Node n = new Node(header, s, header.next);
			header.next.previous = n;
			header.next = n;
		}
	}

	public int size() {
		int count = 0;
		for (Node n = header.next; n != null; n = n.next) {
			count++;
		}
		return count;
	}

	public Node get(int index) {
		if (index < 0 || index > size()) {
			return null;
		} else {
			Node t = header.next;
			while (index > 0) {
				t = t.next;
				index--;
			}
			return t;
		}
	}

	public void insert(String s, int pos) {
		Node t = header.next;

		if (pos < 0 || pos > size())
			System.out.println("Out of band");

		if (pos == 0)
			addFirst(s);
		else if (pos == size())
			addLast(s);

		else {
			for (int i = 1; i < pos; i++) {
				t = t.next;
			}
			Node n = new Node(t.next.previous, s, t.next);
			t.next = n;
			t.next.previous = n;
		}
	}

	public Node findFirst() {
		if (header.next == null)
			return null;
		else
			return header.next;
	}

	public Node findLast() {
		if (header.next == null)
			return null;
		else {
			Node t = header.next;
			while (t.next != null) {
				t = t.next;
			}
			return t;
		}
	}

	public boolean find(String s) {
		Node t = header.next;
		while (t.next != null) {
			if (t.value == s) {
				return true;
			}
			t = t.next;
		}

		return false;
	}

	public int findIndex(String s) {
		int counter = 0;
		Node t = header.next;
		while (t.next != null) {
			if (t.value == s) {
				return counter;
			}
			t = t.next;
			counter++;
		}
		return -1;
	}

	public String removeFirst() {
		if (header.next != null) {
			header.next = header.next.next;
			header.next.previous = header;
			return toString();
		} else
			return null;
	}

	public String removeLast() {
		if (header.next != null) {
			Node t = header.next;
			while (t.next != null) {
				t = t.next;
			}
			t.previous.next = null;
			return toString();
		} else
			return null;
	}

	public boolean remove(int index) {
		if (index > 0 && index < size()) {
			if (header.next != null) {
				Node t = header.next;
				while (index != 0) {
					t = t.next;
					index--;
				}
				t.next.previous = t.previous;
				t.previous.next = t.next;
				return true;
			}
		}
		return false;
	}

	public boolean remove(String element) {
		Node t = header.next;
		while (t.next != null) {
			if (t.value == element) {
				t.next.previous = t.previous;
				t.previous.next = t.next;
				return true;
			}
			t = t.next;
		}

		return false;
	}

	public String findMin() {
		if (header.next != null) {
			Node min = header.next;
			Node t = min;
			while (t.next != null) {
				t = t.next;
				if (min.value.compareTo(t.value) > 0) {
					min = t;
				}
			}
			return min.value;
		}
		return null;
	}

	public String findMax() {
		if (header.next != null) {
			Node max = header.next;
			Node t = max;
			while (t.next != null) {
				t = t.next;
				if (max.value.compareTo(t.value) < 0) {
					max = t;
				}
			}
			return max.value;
		}
		return null;
	}

	public void sort() {
		//Implement
		
		if (size() >= 1) {
			///Selection sort
			for (Node i = header.next; i != null; i = i.next) {
				for(Node j=i.next;j!= null;j=j.next){
					if (i.value.compareTo(j.value) > 0) {
						//swap t and min
						String temp = i.value;
						i.value=j.value;
						j.value=temp;
					}
				}
			}
		}
//			
//			
//			///2
//			//	create new linked list
//			DoubleLinkedList list2 = new DoubleLinkedList();
//			String min="";
//			for (Node i = header.next; i != null; i = i.next) {
//				min=list2.findMin();
//				list2.addLast(min);
//			}
//		}
	}
	public void minSort(){
		Node t;
		for(Node i= header.next;i!= null;i=i.next) {
			t=minNode(i);
			swap(i,t);
		}
	}
	void swap(Node n1, Node n2){

		String temp= n1.value;
		n1.value = n2.value;
		n2.value=temp;
	}

	public Node minNode(Node n){
		Node min = n;
		for(Node t= min.next; t!= null;t=t.next) {
			if(min.value.compareTo(t.value)>0)
				min= t;
		}
		return min;		
	}
	
	public String recurMax() {
		if (header.next != null) {
			//implement
		}
		return null;
	}
	public Node findMinNode() {
		if (header.next != null) {
			Node min = header.next;
			Node t = min;
			while (t.next != null) {
				t = t.next;
				if (min.value.compareTo(t.value) > 0) {
					min = t;
				}
			}
			return min;
		}
		return null;
	}

//********************************8
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.addFirst("John");
		list.addLast("Harry");
		list.addLast("Steve");
		list.addFirst("Bob");
		list.addFirst("Alice");
		list.insert("Nina", 5);

		System.out.println(list.size() + ": " + list.toString());

		Node first = list.findFirst();
		System.out.println("first is: " + first.value);

		Node last = list.findLast();
		System.out.println("last is: " + last.value);

		System.out.println(list.find("Bob"));
		System.out.println(list.find("Sara"));

		System.out.println(list.findIndex("Bob"));
		System.out.println(list.findIndex("Sara"));

		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());

		System.out.println(list.remove(4));
		System.out.println(list.remove(-1));
		System.out.println(list.remove(100));

		// System.out.println(list.remove("Bob"));
		System.out.println(list.remove("Alex"));
		list.addLast("AAA");
		// list.addLast("zzz");

		System.out.println(list.size() + ": " + list.toString());

		System.out.println("Min is" + list.findMin());
		System.out.println("Max is" + list.findMax());
		
		list.minSort();
		System.out.println("after minSort : "+ list.toString());

	}

}
