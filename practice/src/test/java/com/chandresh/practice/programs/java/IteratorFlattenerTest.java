package com.chandresh.practice.programs.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IteratorFlattenerTest {

	@Test
	public void hasNext_null_false() {
		Iterator<Iterator<Integer>> root = null;
		boolean actual = new IteratorFlattener<Integer>(root).hasNext();
		assertEquals(false, actual);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void next_null_null() {
		Iterator<Iterator<Integer>> root = null;
		new IteratorFlattener<Integer>(root).next();
	}
	
	@Test(expected=IllegalStateException.class)
	public void remove_null_exception(){
		Iterator<Iterator<Integer>> root = null;
		new IteratorFlattener<Integer>(root).remove();
		
	}
	
	@Test
	public void iterate_validIterator_printAllValues() {
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);
		
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();

		l1.add(1);
		l1.add(2);
		l1.add(3);

		l2.add(4);
		l2.add(5);

		Iterator<Integer> i1 = l1.iterator();
		Iterator<Integer> i2 = l2.iterator();

		List<Iterator<Integer>> itr = new ArrayList<Iterator<Integer>>();
		itr.add(i1);
		itr.add(i2);

		Iterator<Iterator<Integer>> root = itr.iterator();

		IteratorFlattener<Integer> iFlattener = new IteratorFlattener<Integer>(
				root);
		List<Integer> actual = new ArrayList<Integer>();
		while (iFlattener.hasNext()) {
			actual.add(iFlattener.next());
		}
		assertEquals(expected, actual);
	}
	
	@Test
	public void iterate_singleRemove_removeLastElement() {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();

		l1.add(1);
		l1.add(2);
		l1.add(3);

		l2.add(4);
		l2.add(5);

		Iterator<Integer> i1 = l1.iterator();
		Iterator<Integer> i2 = l2.iterator();

		List<Iterator<Integer>> itr = new ArrayList<Iterator<Integer>>();
		itr.add(i1);
		itr.add(i2);

		Iterator<Iterator<Integer>> root = itr.iterator();

		IteratorFlattener<Integer> iFlattener = new IteratorFlattener<Integer>(
				root);
		while (iFlattener.hasNext()) {
			Integer current = iFlattener.next();
			if(current==2)
			iFlattener.remove();
		}
		boolean actual = iFlattener.contains(2);
		assertEquals(false, actual);
	}


	@Test(expected=IllegalStateException.class)
	public void iterate_multipleRemove_error() {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();

		l1.add(1);
		l1.add(2);
		l1.add(3);

		l2.add(4);
		l2.add(5);

		Iterator<Integer> i1 = l1.iterator();
		Iterator<Integer> i2 = l2.iterator();

		List<Iterator<Integer>> itr = new ArrayList<Iterator<Integer>>();
		itr.add(i1);
		itr.add(i2);

		Iterator<Iterator<Integer>> root = itr.iterator();

		IteratorFlattener<Integer> iFlattener = new IteratorFlattener<Integer>(
				root);
		while (iFlattener.hasNext()) {
			iFlattener.next();
			iFlattener.remove();
			iFlattener.remove();
		}
	}
}
