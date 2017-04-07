package Test;

public class Test2 {

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4};
		int[] b = new int[]{1,2,3,4};
		int[] c = new int[8];
		System.arraycopy(a, 0, c, 4, 4);
		for (int i : c) {
			System.out.println(i);
		}
	}
	
}
