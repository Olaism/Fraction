package myutil;
/** 
 * An instance of this class represents a fraction
 * 
 * 
 */

public class Fraction {
	// data members

	/** the numerator of this fraction */
	private int numerator;

	/** the denominator of this fraction */
	private int denominator;

// -----------------------------------------------------
// Constructors
// -----------------------------------------------------
	/**
	 * Creates a fraction 0/1
	 */
	public Fraction() {
		this(0, 1);
	}

	/**
	 * Creates a fraction number/1
	 * 
	 * @param number the numerator
	 */
	public Fraction(int number) {
		this(number, 1);
	}

	/**
	 * Creates a copy of frac
	 * 
	 * @param frac a copy of this parameter is created
	 */
	public Fraction(Fraction frac) {
		this(frac.getNumerator(), frac.getDenominator());
	}

	/**
	 * Create a fraction num/denom. Create a negative fraction
	 * as -num and denom. if negative values are specified for 
	 * both num and denom, the fraction is converted to a 
	 * positive. If num is positive and denom is negative, the 
	 * fraction will be converted to have negative num and 
	 * positive denom. When the num is zero, denom is set to one.
	 * Zero is always represented as 0/1.
	 * 
	 * @param num the numerator;
	 * @param denom the denominator;
	 */
	public Fraction(int num, int denom) {
		if (denom < 0) {
			num = -num;
			denom = -denom;
		}
		if (num == 0) {
			denom = 1;
		}
		setNumerator(num);
		setDenominator(denom);
	}

// -----------------------------------------------------------------
// Class Methods
//
// -----------------------------------------------------------------

	/**
	 * Returns the greatest common divisor of the parameters m and n.
	 * 
	 * @param m the first number
	 * @param n the second number
	 * 
	 * @return the greatest common divisor of m and n
	 */
	public static int gcd(int m, int n) {
		int r = n % m;
		while (r != 0) {
			n = m;
			m = r;
			r = n % m;
		}
		return m;
	}

	/**
	 * Returns the smaller of the two parameters f1 and f2
	 * 
	 * @param f1 the first fraction to compare
	 * @param f2 the second fraction to compare
	 * 
	 * @return the smaller of the two parameters
	 */
	public static Fraction min(Fraction f1, Fraction f2) {
		// converts to decimal and then compare
		double f1_dec, f2_dec;
		f1_dec = f1.decimal();
		f2_dec = f2.decimal();

		if (f1_dec <= f2_dec) {
			return f1;
		}
		return f2;
	}

// ---------------------------------------------------------
// Public Instance Methods

// ---------------------------------------------------------
	/**
	 * Returns the sum of this Fraction and the parameter 
	 * frac. The sum returned is NOT simplified.
	 * 
	 * @param frac the Fraction to add to this Fraction
	 * 
	 * @return the sum of this and frac
	 */
	public Fraction add(Fraction frac) {
		int a, b, c, d;
		a = this.getNumerator();
		b = this.getDenominator();
		c = frac.getNumerator();
		d = frac.getDenominator();

		return new Fraction(a*d + b*c, b*d);
	}

	/**
	 * Returns the sum of this Fraction and the int 
	 * parameter number. The sum returned is NOT simplified.
	 * 
	 * @param number the integer to add to this Fraction
	 * 
	 * @return the sum of this Fraction and number
	 */
	public Fraction add(int number) {
		Fraction f = new Fraction(number, 1);
		return add(f);
	}

	/**
	 * Returns the difference of this Fraction and the parameter 
	 * frac. The difference returned is NOT simplified.
	 * 
	 * @param frac the Fraction to subtract from this Fraction
	 * 
	 * @return the difference of this and frac
	 */
	public Fraction subtract(Fraction frac) {
		int a, b, c, d;
		a = getNumerator();
		b = getDenominator();
		c = frac.getNumerator();
		d = frac.getDenominator();

		return new Fraction(a*d - b*c, b*d);
	}

	/**
	 * Returns the difference of this Fraction and the int 
	 * parameter number. The difference returned is NOT simplified.
	 * 
	 * @param number the int value to subtract
	 * 
	 * @return the difference of this and number
	 */
	public Fraction subtract(int number) {
		Fraction f = new Fraction(number, 1);
		return subtract(f);
	}

	/**
	 * Returns the quotient of this Fraction divided by the 
	 * parameter frac. The quotient returned is NOT simplified.
	 * 
	 * @param frac the divisor of the division
	 * 
	 * @return the quotient of this fraction divided by frac
	 */
	public Fraction divide(Fraction frac) {
		int a, b, c, d;
		a = this.getNumerator();
		b = this.getDenominator();
		c = frac.getNumerator();
		d = frac.getDenominator();

		return new Fraction(a*d, b*c);
	}

	/**
	 * Returns the quotient of this Fraction divided by the 
	 * int parameter number. The quotient returned is 
	 * NOT simplified.
	 * 
	 * @param number the divisor
	 * 
	 * @return the quotient of this Fraction divided by number
	 */
	public Fraction divide(int number) {
		Fraction f = new Fraction(number, 1);
		return divide(f);
	}

	/**
	 * Returns the product of this Fraction and the 
	 * parameter frac. The product returned is NOT simplified.
	 * 
	 * @param frac the multiplier of the multiplication
	 * 
	 * @return the product of this fraction and the parameter frac
	 */
	public Fraction multiply(Fraction frac) {
		int a, b, c, d;
		a = getNumerator();
		b = getDenominator();
		c = frac.getNumerator();
		d = frac.getDenominator();

		return new Fraction(a*c, b*d);
	}

	/**
	 * Returns the product of this Fraction and the 
	 * int parameter number. The product returned is 
	 * NOT simplified.
	 * 
	 * @param number the multiplier
	 * 
	 * @return the product of this Fraction and parameter number
	 */
	public Fraction multiply(int number) {
		Fraction f = new Fraction(number, 1);
		return multiply(f);
	}

	/**
	 * Compare this fraction and the parameter frac for equality.
	 * This method compares the two by first reducing them to the 
	 * simplest form.
	 * 
	 * @param frac the fraction object to compare
	 * 
	 * @return true if this Fraction object and frac are equal
	 */
	public boolean equals(Fraction frac) {
		Fraction f1 = simplify();        // simplify itself
		Fraction f2 = frac.simplify();   // simplify frac

		return (f1.getNumerator() == f2.getNumerator() && f1.getDenominator() == f2.getDenominator());
	}

	/**
	 * Returns the numerator of this fraction
	 * 
	 * @return the numerator of this fraction
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Returns the denominator of this fraction
	 * 
	 * @return the denominator of this fraction
	 */
	public int getDenominator() {
		return denominator;
	}

	/**
	 * Returns the decimal equivalent of this Fraction
	 * 
	 * @return the decimal equivalent of this Fraction
	 */
	private double decimal() {
		return (double) (getNumerator() / getDenominator());
	}

	/**
	 * Sets the numerator of this fraction
	 * 
	 * @param num the numerator of this fraction
	 */
	public void setNumerator(int num) {
		numerator = num;
	}

	/**
	 * Sets the denominator of this fraction
	 * 
	 * @param denom the denominator of this fraction
	 */
	public void setDenominator(int denom) {
		if (denom == 0) {
			// fatal error
			System.out.println("Fatal Error");
			System.exit(1);
		}
		denominator = denom;
	}

	/**
	 * Returns a new Fraction object that is in the 
	 * simplest form of this Fraction object. If this 
	 * fraction is zero, then a simple copy of it is 
	 * returned
	 * 
	 * @return a Fraction object in the simplest form
	 *         of this fraction
	 */
	public Fraction simplify() {
		int num = getNumerator();
		int denom = getDenominator();

		int divisor = 1;

		if (num != 0) {
			divisor = gcd(Math.abs(num), denom);
		}

		return new Fraction(num/divisor, denom/divisor);
	}

	/**
	 * Returns the String representation of this number
	 * 
	 * @return the String representation of this number
	 */
	public String toString() {
		return getNumerator() + " / " + getDenominator();
	}
}