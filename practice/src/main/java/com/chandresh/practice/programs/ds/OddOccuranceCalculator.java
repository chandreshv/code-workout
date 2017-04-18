package com.chandresh.practice.programs.ds;

public class OddOccuranceCalculator {

	public int[] findOddOccurance(int[] inp) {
		int result[] = new int[2];

		if (inp == null || inp.length == 0)
			return result;

		int xor = inp[0];
		for (int i = 1; i < inp.length; i++)
			xor ^= inp[i];

		int set_bit = findSetBit(xor);

		int x = 0, y = 0;

		for (int i = 0; i < inp.length; i++) {
			if (((1 << set_bit) & inp[i]) == 1)
				x ^= inp[i];
			else
				y ^= inp[i];
		}

		result[0] = x;
		result[1] = y;

		return result;
	}

	private int findSetBit(int inp) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			if (((1 << i) & inp) > 0) {
				result = i;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] inp = { 12, 23, 34, 12, 12, 23, 12, 45 };
		int[] result = new OddOccuranceCalculator().findOddOccurance(inp);
		System.out.println(result[0]+ "    " + result[1]);
	}



}
