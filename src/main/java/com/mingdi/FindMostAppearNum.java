package com.mingdi;

import java.util.Random;

/**
 * find the number with most appearance in list
 * if the appearance is greater than half of the elements, return the number directly.
 */
public class FindMostAppearNum {

	public int find(int[] arr) {
		int[] tmp = new int[arr.length];
		for(int i = 0 ; i<arr.length;i++) {
			tmp[arr[i]] = tmp[arr[i]]+1;
		}
		int mTemp = 0;
		int mIndex = 0;
		for(int t = 0;t<tmp.length;t++ ) {
			if(tmp[t]>mTemp) {
				mTemp = tmp[t];
				mIndex = t;
			}
		}
		for(int i : arr) {
			System.out.print(i+",");
		}
		System.out.println();
		System.out.println(mIndex +" :" + mTemp);
		return 0;
	}
	public static void main(String[] args) {
		int[] input = new int[new Random().nextInt(20)];
		for(int i =0; i<input.length;i++) {
			input[i] = new Random().nextInt(input.length);
		}
		FindMostAppearNum m = new FindMostAppearNum();
		int max = m.find(input);
		System.out.println(max);
	}
}
