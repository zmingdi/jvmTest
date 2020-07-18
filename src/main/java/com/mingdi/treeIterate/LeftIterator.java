package com.mingdi.treeIterate;

import com.mingdi.TreeNode;

public class LeftIterator {
	
	
	public void iterate(TreeNode n) {
		if(n.getLeft()!=null) {
			iterate(n.getLeft());
		}
		n.show();
		if(n.getRight()!=null) {
			iterate(n.getRight());
		}
	}
}
