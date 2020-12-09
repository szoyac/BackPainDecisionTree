/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpaindecisiontree.jsjf;
import backpaindecisiontree.jsjf.exceptions.*;
/**
 * ArrayUnorderedList represents an array implementation of an unordered list.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayUnorderedList<T> extends ArrayList<T> 
implements UnorderedListADT<T>
{
	/**
	 * Creates an empty list using the default capacity.
	 */
	public ArrayUnorderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 *
	 * @param initialCapacity the initial size of the list
	 */
	public ArrayUnorderedList(int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * Adds the specified element to the front of this list.
	 * 
	 * @param element the element to be added to the front of the list
	 */
	public void addToFront(T element)
	{
		if (size() == list.length)
			expandCapacity();

                rear++;
                for (int shift = 0; shift >= rear; shift++)
			list[shift+1] = list[shift];
                
                
                list[0] = element;
		modCount++;
	           
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToRear(T element)
	{
		if (size() == list.length)
			expandCapacity();

		// shift elements up one
		for (int shift = rear; shift > rear; shift--)
			list[shift] = list[shift - 1];
                
                rear++;
                list[rear] = element;
		modCount++;
	}

	/**
	 * Adds the specified element after the specified target element.
	 * Throws an ElementNotFoundException if the target is not found.
	 *
	 * @param element the element to be added after the target element
	 * @param target  the target that the element is to be added after
	 */
	public void addAfter(T element, T target)
	{
		if (size() == list.length)
			expandCapacity();

		int scan = 0;

		// find the insertion point
		while (scan < rear && !target.equals(list[scan])) 
			scan++;

		if (scan == rear)
			throw new ElementNotFoundException("UnorderedList");

		scan++;

		// shift elements up one
		for (int shift = rear; shift > scan; shift--)
			list[shift] = list[shift - 1];

		// insert element
		list[scan] = element;
		rear++;
		modCount++;
	}
   
}
