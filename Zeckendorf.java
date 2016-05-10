import java.util.List;
import java.util.ArrayList;

public class Zeckendorf {

	public static boolean I_AM_DEBUGGING = false;

	public static List<Integer> fibs;
	public static int fibLength;
	public static int zecks;


	public static void main(String[] args) {
		fibs = new ArrayList<Integer>();
		fibLength = 10;
		for (int i=0; i<fibLength; i++) {
			fibs.add(fibonacci(i));
		}

		for (int i=0; i<51; i++) {
			System.out.println(i + ": " + zeckendorf(i, fibLength-1, "0").replaceFirst("^0+(?!$)", ""));
		}



		if (I_AM_DEBUGGING) {
			for (int i=0; i<fibLength; i++) {
				System.out.println(i + ": " + fibs.get(i));
			}
		}
	}

	public static int fibonacci(int n) {
		if (n == 0) return 1;
		if (n == 1) return 2;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static String zeckendorf(int num, int index, String zeck) {
		if (num >= fibs.get(index) && zeck.endsWith("0")) {
			zeck += "1";
			num -= fibs.get(index);
		} else {
			zeck += "0";
		}
		if (index == 0) {
			if (num == 0) return zeck;
			return "NONE";
		}
		return zeckendorf(num, index - 1, zeck);
	}
}
