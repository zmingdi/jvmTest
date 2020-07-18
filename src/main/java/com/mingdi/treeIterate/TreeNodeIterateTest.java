package com.mingdi.treeIterate;

import com.mingdi.TreeNode;

/**
 * Tree iterator test.
 * Use different iterator to different iterate sequence.
 * The iterators shall implements a interface (Iterator or something) to reduce the dependencies
 * @author mzhang457
 *
 */
public class TreeNodeIterateTest {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode();
		n1.setValue("n1");
		TreeNode n1l = new TreeNode();
		n1l.setValue("n1l");
		TreeNode n1r = new TreeNode();
		n1r.setValue("n1r");
		n1.setLeft(n1l);
		n1.setRight(n1r);
		
		TreeNode n1ll = new TreeNode();
		n1ll.setValue("n1ll");
		TreeNode n1lr = new TreeNode();
		n1lr.setValue("n1lr");
		n1l.setLeft(n1ll);
		n1l.setRight(n1lr);
		
		TreeNode n1rl = new TreeNode();
		n1rl.setValue("n1rl");
		TreeNode n1rr = new TreeNode();
		n1rr.setValue("n1rr");
		n1r.setLeft(n1rl);
		n1r.setRight(n1rr);
		
		// Iterator
		MidIterator iterator = new MidIterator();
		iterator.iterate(n1);
		
	}
}
