package com.mingdi;

/**
 * Tree data model
 */
public class TreeNode {
	
	private String value;
	private TreeNode left;
	private TreeNode right;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public void show() {
		System.out.print(this.value+"=>");
	}
}
