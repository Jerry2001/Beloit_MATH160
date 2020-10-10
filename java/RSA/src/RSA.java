import java.util.Scanner;

/**
 * RSA
 * @author Jerry Ngo
 *
 */

public class RSA {
	static int N; 
	
	/**
	 * Extended GCD
	 * @param p first number
	 * @param q second number
	 * @return the gcd of p and q
	 */
	static int[] gcd(int p, int q) {
		if (q == 0)
			return new int[] {p, 1, 0};
		
		int[] vals = gcd(q, p % q);
		int a = vals[2];
		int b = vals[1] - (p / q) * vals[2];
		return new int[] {vals[0], a, b};
	}
	
	static int ciper(int m, int e) {
		if(e == 0) return 1;
		int halve = (ciper(m, e / 2)) % N;
		if(e % 2 == 1) return ((halve * halve) % N * m) % N;
		return (halve * halve) % N;
	}
	
	static int deciper(int m, int d) {
		if(d == 0) return 1;
		int halve = (ciper(m, d / 2)) % N;
		if(d % 2 == 1) return ((halve * halve) % N * m) % N;
		return (halve * halve) % N;
	}
	
	/*Sample Input
	31
	59
	859
	1211
	*/
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.print("p: ");
		int p = scnr.nextInt();
		System.out.print("q: ");
		int q = scnr.nextInt();
		N = p*q;
		int phi = (p - 1) * (q - 1);
		System.out.print("e: ");
		int e = scnr.nextInt();
		while(gcd(e, phi)[0] != 1) {
			System.out.println("Invalid e");
			System.out.print("e: ");
			e = scnr.nextInt();
		}
		System.out.print("m: ");
		int m = scnr.nextInt();
		while(m >= N || gcd(m, N)[0] != 1) {
			System.out.println("Invalid m");
			System.out.print("m: ");
			m = scnr.nextInt();
		}
		int d = gcd(e, phi)[1];
		System.out.println("Private key d: " + d);
		int c = ciper(m, e);
		System.out.println("Cipher: " + c);
	}
}



