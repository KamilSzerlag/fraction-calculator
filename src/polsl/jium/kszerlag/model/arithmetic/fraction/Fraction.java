package polsl.jium.kszerlag.model.arithmetic.fraction;

import polsl.jium.kszerlag.model.arithmetic.Calculable;

/**
 * Immutable class representing fraction.
 * In maths fraction represents a part of a whole or, more generally, any 
 * number of equal parts
 * 
 * @version 2.0
 * @author Kamil Szerląg
 */
public class Fraction implements Calculable, Comparable<Fraction>{
    
    /**
     * Numerator is top part of fraction.
     */
    private int numerator;
    
    /**
     * Denominator is button part of fraction.
     */
    private int denominator;
    
    /**
     * Fraction could also contains optional integer part.
     * For example, fraction 5/2 could be converted to 2 and 1/2, 
     * where 2 is integer part of fraction.
     */
    private int fractionInteger;
    
    /**
     * Constructing Fraction object from passed numerator and denominator values.
     * 
     * @param numerator integer value.
     * @param denominator integer value, must be different then zero.
     * @throws FractionArithmeticException - is thrown when passed denominator value is zero.
     */
    public Fraction(int numerator, int denominator) throws FractionArithmeticException {
        if (denominator == 0) {
            throw new FractionArithmeticException("Denominator must not be 0!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    /**
     * Constructing Fraction object with optional fraction integer part.
     * 
     * @param numerator integer value.
     * @param denominator integer value, must be different then zero.
     * @param fractionInteger integer value.
     */
    public Fraction(int numerator, int denominator, int fractionInteger) {
        this(numerator, denominator);
        this.fractionInteger = fractionInteger;
    }

    /**
     * Returns a Fraction object holding the value of the specified <code>String</code>.
     * <code>String</code> must be in strictly specified format.
     * 
     * <b>Format:</b> "A/B" , where A is numerator, B is denominator.<br>
     * Example:<br>
     *  "5/4", "1/3", "3/2" 
     * 
     * <b>Note:</b> Actually integer part of of fraction is unsupported.
     * @version 1.0
     * @param fraction <code>String</code> contains fraction in "X/B" format.
     * @throws InvalidFractionFormatException when <code>String</code> format is unsupported.
     * @throws NullPointerException
     * @return Fraction object from <code>String</code> passed value.
     */
    public static Fraction valueOf(String fraction) throws InvalidFractionFormatException, NullPointerException {
        if (fraction == null) {
            throw new NullPointerException("String argument is null!");
        }
        fraction = fraction.trim();
        String[] splited = fraction.split("/");
        if (splited.length == 1) {
            int numerator = Integer.valueOf(splited[0]);
            return new Fraction(numerator, 1);
        }
        if (splited.length != 2) {
            throw new InvalidFractionFormatException("Invalid fraction format! Fraction should be in 'X/Y' format");
        } 
        int numerator = Integer.valueOf(splited[0]);
        int denominator = Integer.valueOf(splited[1]);
        return new Fraction(numerator, denominator);
    }
    
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getFractionInteger() {
        return fractionInteger;
    }

    @Override
    public String toString() {
        if (this.numerator == 0) {
            return "0";
        }
        return this.numerator + "\n-\n" + this.denominator;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        FractionUtil fractionUtil = new FractionUtil();
        Fraction irreducibleOther = fractionUtil.irreducibleFraction(other);
        Fraction irreducibleThis = fractionUtil.irreducibleFraction(this);
        if (irreducibleThis.getNumerator() != irreducibleOther.getNumerator()) {
            return false;
        }
        if (irreducibleThis.getDenominator() != irreducibleOther.getDenominator()) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Fraction other) {
        if (other == null) {
            throw new NullPointerException("Compared object is null!");
        }
        FractionUtil fractionUtil = new FractionUtil();
        final Fraction otherCommonDenominator = fractionUtil.findCommonDenominator(other, this);
        if (this.getNumerator() < otherCommonDenominator.getNumerator()) {
            return -1;
        }
        if (this.getNumerator() > otherCommonDenominator.getNumerator()) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Result of dividing the numerator by the denominator.
     * For example: 
     *   Fraction object with numerator value 1 and denomitator value 2 (1/2)
     *   gives 0.5.
     * 
     * @return <code>double</code> value of fraction
     */
    public double doubleValue() { 
        return (double) this.numerator / this.denominator;
    }
  }
