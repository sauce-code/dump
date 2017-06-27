package mandelbrot;

import org.apache.commons.math3.complex.Complex;

public class Mandelbrot {

	public int compute(Complex c, int iterations, double length) {
		int n = 0;
		Complex z = c;
		while (z.abs() < length && n < iterations) {
			z = z.pow(2).add(c);
			n++;
		}
		return n;
	}
	
}
