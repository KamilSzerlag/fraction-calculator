package polsl.jium.kszerlag.model.arithmetic.fraction;

import java.util.Objects;
import polsl.jium.kszerlag.model.arithmetic.Calculable;

/**
 * Immutable class representing fraction.
 * In maths fraction represents a part of a whole or, more generally, any 
 * number of equal parts
 * 
 * @version 3.0
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
     * Default Fraction object constructor.
     */
    public Fraction() {
    }
    
    /**
     * Constructing Fraction object from passed numerator and denominator values.
     * 
     * @param numerator could be zero.
     * @param denominator must be different then zero.
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
     * @param numerator could be zero.
     * @param denominator must be different then zero.
     * @param fractionInteger could be zero.
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
     * @return Fraction object from <code>String</code> passed value.
     * @throws FractionArithmeticException when creating properly Fraction object is
     * impossible
     */
    public Fraction parseFraction(String fraction) throws FractionArithmeticException {
        if (fraction == null || fraction.isEmpty()) {
            throw new FractionArithmeticException("String can't be null or empty");
        }
        fraction = fraction.trim();
        String[] splited = fraction.split("/");
        if (splited.length == 1) {
            int numerator = Integer.valueOf(splited[0]);
            return new Fraction(numerator, 1);
        }
        if (splited.length != 2) {
            throw new FractionArithmeticException("Invalid fraction format! Fraction should be in 'X/Y' format");
        } 
        int numerator = Integer.valueOf(splited[0]);
        int denominator = Integer.valueOf(splited[1]);
        return new Fraction(numerator, denominator);
    }
    
    /**
     * Provides access to fraction numerator value.
     * 
     * @return numerator field value.
     */
    public int getNumerator() {
        return numerator;
    }
    
    /**
     * Provides access to fraction denominator value.
     * 
     * @return denominator field value. 
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Provides acces to fraction integer value.
     *
     * @return fraction integer field value.
     */
    public int getFractionInteger() {
        return fractionInteger;
    }

    /**
     * Creating required format of Fraction representation.
     * 
     * @return required format of fraction representation in <code>String</code>
     */
    @Override
    public String toString() {
        if (this.numerator == 0) {
            return "0";
        }
        return this.numerator + "/" + this.denominator;
    }

    /**
     * hashCode code implementation based on Objects.hash() method.
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.numerator, this.denominator);
    }

    /**
     * Compering equality between to Fraction objects.
     * 
     * @param obj object to comparison.
     * @return true if compared objects are equal, otherwise false.
     */
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

    /**
     * Comparing two fraciton objects. 
     * 
     * @param other fraction to comparison.
     * @return -1 if this fraction is lower then compared. 0 if this fraction is
     * equals to compared. 1 if this fraction is greater then compared.
     */
    @Override
    public int compareTo(Fraction other) {
        if (other == null) {
            throw new FractionArithmeticException("Compared object is null!");
        }
        if (this == other) {
            return 0;
        }
        if (getClass() != other.getClass()) {
            throw new FractionArithmeticException("Passed argument is not instance of Fraction");
        }
        FractionUtil fractionUtil = new FractionUtil();
        final Fraction thisCommonDenominator = fractionUtil.findCommonDenominator(this, other);
        final Fraction otherCommonDenominator = fractionUtil.findCommonDenominator(other, this);
        if (thisCommonDenominator.getNumerator() < otherCommonDenominator.getNumerator()) {
            return -1;
        }
        if (thisCommonDenominator.getNumerator() > otherCommonDenominator.getNumerator()) {
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
     * @return result of division numerator and denominator as double value. 
     */
    public double doubleValue() { 
        return (double) this.numerator / this.denominator;
    }
  }
