package datastructures;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import interfaces.Callable;

public class ExtendedLinkedList implements Iterable {


	private class ListElement {
		private Integer  data;
		private ListElement next;

		public ListElement(Integer data, ListElement next) {
			this.data = data;
			this.next = next;
		}

		public ListElement(Integer data) {
			this(data,null);
		}

		//getters and setters
		public Integer getData() {
			return this.data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public ListElement getNext() {
			return this.next;
		}

		public void setNext(ListElement next) {
			this.next = next;
		}

	}

	private class LListIterator implements Iterator<Integer> {
		ExtendedLinkedList.ListElement current;


		public LListIterator (ExtendedLinkedList l) {
			this.current = l.getHead();
		}

		public boolean hasNext() {
			return this.current != null;
		}

		@Override
		public Integer next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			Integer data = this.current.getData();
			this.current=this.current.getNext();
			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}


	private ListElement head;
	private  int size;

	public ExtendedLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public ExtendedLinkedList(Integer data) {
		this();
		this.addFirst(data);
	}

	public ListElement getHead() {return this.head;}
	public int getSize() {return this.size;}
	public boolean isEmpty() {return this.getSize() == 0;}

	public void addFirst(Integer data) {
		this.head = new ListElement(data, this.head);
		this.size++;
	}

	public void addLast(Integer data) {
		ListElement e = new ListElement(data);

		this.size++;

		// handle special case of an empty list
		if (this.head == null) {
			this.head = e;
			return;
		}


		//iterate until we find last element
		ListElement curr = this.head;

		while(curr.getNext() != null) {

			curr=curr.getNext();
		}

		curr.setNext(e);


	}


	public Integer get(final int i) {
		if (i > this.getSize()) {
			throw new IndexOutOfBoundsException("List index" +  i +" is out of bounds.");
		}

		int j =i;
		ListElement curr=this.head;
		while ((curr) != null && (j> 0)) {
			curr = curr.getNext();
			j--;
		}

		return curr.getData();

	}



	public Integer removeFirst() {
		if (this.head == null) {
			throw new NoSuchElementException("List is Empty!");
		}
		Integer data = this.head.getData();


		this.head = this.head.getNext();
		this.size--;


		return data;
	}

	public Integer removeLast() {
		if (this.head == null) {
			throw new NoSuchElementException("List is Empty!");
		}

		// check if list of size 1, if so use removeFirst
		if (this.size == 1) {
			return this.removeFirst();
		}

		ListElement curr = this.head;

		while (curr.getNext().getNext() != null) {
			curr = curr.getNext();
		}


		Integer data = curr.getNext().getData();

		curr.setNext(null);
		this.size--;


		return data;
	}

	public void clearFirstN(int n) {

		if (this.size < n) {
			this.size = 0;
			this.head = null;
		}

		// clear the first n-elements
		for (int i = 0; i<n && this.head != null ;i++) {
			this.removeFirst();
		}

	}

	public ExtendedLinkedList getSubList(int i, int j) {
		ExtendedLinkedList output = new ExtendedLinkedList();

		if ((i < 0) || (j < 0)) {
			throw new IndexOutOfBoundsException();
		}

		if (i > j) {
			throw new UnsupportedOperationException("getSubList requires that i <= j");
		}

		int  newSize = j - i;

		// check if result would be the empty list
		if ((newSize <= 0) || (this.size < j)) {
			System.out.println("newSize " + newSize + "this size :" + this.size);
			return output;
		}

		ListElement curr = this.head;
		for (int currIndex = 0; currIndex < this.size;currIndex++) {
			if ((currIndex >= i) && (currIndex < j) ) {
				output.addLast(curr.getData());
			}
			curr = curr.getNext();
		}
		return output;
	}

	@Override
	public String toString() {
		StringBuilder  sb = new StringBuilder();

		Iterator<Integer> it = this.iterator();

		while (it.hasNext()) {
			var e = it.next();
			sb.append(e.toString());

			if (it.hasNext()) {
				sb.append(", ");
			}
		}

		return sb.toString();
	}


	@Override
	public Iterator<Integer> iterator() {
		return new LListIterator(this);
	}


	/**
	 * addI(Integer data, int i): adds data into list at position i
	 */
	public void addI(Integer data, int i) {
		// error handling
		// throw if index is out of bounds
		if (i > this.getSize()) {
			throw new IndexOutOfBoundsException("List index" +  i +" is out of bounds.");
		}

		// set first element when index = 0
		if (i == 0) {
			addFirst(data);
			return;
		}

		// make new list element
		ListElement e = new ListElement(data);

		// find element for position i-1
		// (because we can only do setNext())
		ListElement curr = this.head;
		for (int j = 0; j < i-1; j++) {
			curr = curr.getNext();
		}

		// set element
		e.setNext(curr.getNext());
		curr.setNext(e);

		// increase size of list
		this.size++;
	}

    /**
	 * removeI(int i): removes element from position i
	 */
	public void removeI(int i) {
		// error handling
        if (i < 0 || i > this.getSize()) {
			throw new IndexOutOfBoundsException("List Index " + i +" is out of Bounds");
		}
		// find element for position i-1
		ListElement curr = this.head;
		for (int j = 0; j < i-1; j++){
			curr = curr.getNext();
		}

		// delete element
		curr.setNext(curr.getNext().getNext());

		// decrease size of list
		this.size--;
	}


	/**
	 * combineLists(list2): appends list2 to this list
	 */
	public void combineLists(ExtendedLinkedList list2) {
        if (list2 == null || list2.head == null) {
			return;
		}

		
		// find end of current List

		// in case current List empty
		if (this.head == null) {
			ListElement curr2 = list2.head;
			this.head = new ListElement(curr2.getData());
			ListElement currNew = this.head;
			curr2 = curr2.getNext();
			this.size++;

			while (curr2 != null) {
				currNew.setNext(new ListElement(curr2.getData()));
				currNew = currNew.getNext();
				curr2 = curr2.getNext();
				this.size++;
			}
		}

		// if not empty, get attached to end
		else{


			ListElement curr = this.head;
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}

			ListElement curr2 = list2.head;
			while (curr2 != null) {
				curr.setNext(new ListElement(curr2.getData()));
				curr = curr.getNext();
				curr2 = curr2.getNext();
				this.size++;
			}
		}
	}

    /**
	 * This function returns, whether the list is sorted or not.
     *
     * @return whether the list is sorted or not
	 */
	public boolean isSorted() {
		//error handling
        if(this.head == null){
			return false;
		}
		ListElement curr = this.head;
		while (curr.getNext() != null) {
			// need comparable to compare objects
			Comparable currentValue = curr.getData();
			Comparable nextValue = curr.getNext().getData();
			if (currentValue.compareTo(nextValue) > 0) {
				//not sorted
				return false;
			}
			else{
				curr = curr.getNext();
			}
		}
        return true;
	}

	/**
	 * addSorted(Integer data): given list is already sorted. data has to
	 * be added to the list but at the correct position so that list is at the end also sorted
     * @throws UnsupportedOperationException if the list is not sorted.
	 */
	public void addSorted(Integer data) throws UnsupportedOperationException {
		//Exception in cas of not Sorted list
		if (!this.isSorted()) {
			throw new UnsupportedOperationException("The given list is not sorted ");
		}
        
		ListElement newElement = new ListElement(data);

		// special case if List is empty or element has to be first in List
		if (this.head == null || data < (Integer) this.head.getData()) {
			newElement.setNext(this.head);
			this.head = newElement;
			this.size++;
			return;
		}

		// search correct position for data
		ListElement currentElement = this.head;
		while (currentElement.getNext() != null && data >= (Integer) currentElement.getNext().getData()) {
			currentElement = currentElement.getNext();
		}
		newElement.setNext(currentElement);
		currentElement.setNext(newElement);
		this.size++;
	}





	/**
	 * filterElements(): outputs all even elements in the list, where
	 * the function func evaluates to true.
	 *
	 * @return outputs a new list containing only the filtered elements
	 */
	public ExtendedLinkedList filterElements(Callable<Boolean, Integer> func) {
		return null;
	}

	/**
	 * evenElements(): outputs all even elements in list
	 *
	 * @return outputs all even elements in list
	 */
	public ExtendedLinkedList evenElements() {
		return filterElements(new evenFilter());
	}

	/**
	 * oddElements(): outputs all odd elements in list (pay attention to negative elements)
	 *
	 *
	 * @return outputs all odd elements in list
	 */
	public ExtendedLinkedList oddElements() {
		return filterElements(new oddFilter());
	}

	/**
	 * positiveElements(): outputs all positive elements >0 in list
	 *
	 *
	 * @return outputs all positive elements in list
	 */
	public ExtendedLinkedList positiveElements() {
		return filterElements(new positiveFilter());
	}

	/**
	 * negativeElements(): outputs all negative elements <0 in list
	 *
	 *
	 * @return outputs all negative elements in list
	 */
	public ExtendedLinkedList negativeElements() {
		return filterElements(new negativeFilter());
		
	}

	/**
	 * rotation(int i, String direction): rotates all elements by i to the direction (right or left)
	 * example: rotation(2): [1, 2, 3, 4] → [3, 4, 1, 2]
	 * i>size is also possible.
	 *
	 */
	public void rotation(int i, String direction) throws UnsupportedOperationException {
		// TODO: implement this method
	}

	/**
	 * removeDuplicates(): removes all duplicates of list
     * The first occurence is kept.
	 *
	 */
	public void removeDuplicates() {
		// TODO: implement this method
	}

    public ExtendedLinkedList map(Callable<Integer, Integer> m) {
        return null;
        // TODO: implement this method
    }

}
