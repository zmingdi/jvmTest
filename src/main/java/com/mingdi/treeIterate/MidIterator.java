package com.mingdi.treeIterate;

import com.mingdi.TreeNode;

public class MidIterator {
	public void iterate(TreeNode n) {
		n.show();
		if(n.getLeft()!=null) {
			iterate(n.getLeft());
		}
		if(n.getRight()!=null) {
			iterate(n.getRight());
		}
	}
}
