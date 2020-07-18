package com.mingdi.treeNode.switcher;

import com.mingdi.TreeNode;

/**
 * switch all left-right node in single tree
 */
public class TreeNodeSwitcher {

	
	public TreeNode _switch(TreeNode node) {
		if(node != null) {
			TreeNode left = node.getLeft();
			TreeNode right = node.getRight();
			node.setRight( _switch( left ));
			node.setLeft( _switch( right ) );
			return node;
		} else return null;
	}
}
