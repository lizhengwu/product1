package com.lzw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 题库答案
 */
public class LeetCode {

	public static void main(String[] args) {

		int process = process2(9);
		System.out.println(process);

	}

	/**
	 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
	 * <p>
	 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
	 * <p>
	 * <p>
	 * 滑动窗口可以看成数组中框起来的一个部分。在一些数组类题目中，我们可以用滑动窗口来观察可能的候选结果。当滑动窗口从数组的左边滑到了右边，我们就可以从所有的候选结果中找到最优的结果。
	 *
	 * @param
	 */
	private static int[][] process(int target) {
		// (start + end) * size/2

		List<int[]> result = new ArrayList<>();

		int i = 1;
		int j = 2;
		int maxSize = (target + 1) / 2;

		while (j <= maxSize) {
			int sum = (i + j) * (j - i + 1) / 2;
			if (sum < target) {
				j++;
			}
			if (sum == target) {

				int[] arr = new int[j - i + 1];
				for (int k = i; k <= j; k++) {
					arr[k - i] = k;
				}
				result.add(arr);
				i++;
			}
			if (sum > target) {
				i++;
			}
		}

		return result.toArray(new int[result.size()][]);

	}

	/**
	 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
	 */
	private static int[] process1(int[] numbers) {
		numbers[0] = numbers[0] + numbers[1];
		numbers[1] = numbers[0] - numbers[1];
		numbers[0] = numbers[0] - numbers[1];

		// 异或运算
		// a = a^b
		numbers[0] = numbers[0] ^ numbers[1];
		// b = a^b^b
		numbers[1] = numbers[0] ^ numbers[1];
		// a = a^b^a^b^b
		numbers[0] = numbers[0] ^ numbers[1];

		return numbers;
	}

	/**
	 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 *
	 * 短路原则，如果前面的判断做过了，后面的判断就不会做了，所以利用 && 来
	 * @param target
	 * @return
	 */

	private static int process2(int target) {
		//int sum = n;
		boolean b = (target > 0) && (target += process2(target - 1)) > 0;//&&左右两边均为boolean类型
		return target;//返回int类型

	}

	/**
	 *
	 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param target
	 * @return
	 */
	private static String  process3(String str,int n) {
		return str.substring(n)+str.substring(0, n);
	}
}
