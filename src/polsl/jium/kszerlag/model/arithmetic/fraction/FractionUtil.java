package polsl.jium.kszerlag.model.arithmetic.fraction;

/**
 * Provides most useful method
 * for operating on fraction
 * 
 * @version 3.0
 * @author Kamil Szerląg
 */
class FractionUtil {
    
    /**
     * Validating passed arguments.
     * 
     * @param args - all classes that inherit from Object class.
     * @throws FractionArithmeticException when operation can't be performed due to null value
     */
    void validateElementsNotNull(Object... args) throws FractionArithmeticException {
        for (Object obj : args) {
            if (obj == null) {
                throw new FractionArithmeticException("Arguments must not be null! Operation can't return valid value");
            }
        }
    }
    
    /**
     * Finding a common denominator by multiplying the denominators with each other.
     * 
     * example:<br>
     * <p> 
     *     first fraction: 2/3<br> 
     *     second fraction 1/2<br>
     *     returns: 4/6<br>
     * </p>
     * @param first - first Fraction object
     * @param second - second Fraction object
     * @return the first fraction reduced to the common with second fraction   
     */
    Fraction findCommonDenominator(Fraction first, Fraction second) {
        if (first.getDenominator() == second.getDenominator()) {
            return first;
        }
        int commonDenominator = second.getDenominator();
        return new Fraction(first.getNumerator() * commonDenominator, first.getDenominator() * commonDenominator);
    }
    
    /**
     * Reverting fraction.
     * 
     * example:<br>
     * <p>
     *     fraction: 2/3<br>
     *     returns: 3/2<br>
     * </p>
     * @param fraction Object representing fraction to revert.
     * @return reverted fraction
     */
    Fraction revertFraction(Fraction fraction) {
        return new Fraction(fraction.getDenominator(), fraction.getNumerator());
    }
    
    /**
     * 
     * According to Wikipedia:
     * <i>An irreducible fraction (or fraction in lowest terms or reduced fraction) 
     * is a fraction in which the numerator and denominator are integers that 
     * have no other common divisors than 1 (and -1, when negative numbers are considered).</i>
     * <br>
     * example:<br>
     *      1st fraction: given 2/4 returning 1/2 which is irreducible
     *      2nd fraction: given 5/6 returning 5/6 becouse is irreducible
     * 
     * @param fraction which should be reduce.
     * @return irreducible fraction
     */
    Fraction irreducibleFraction(Fraction fraction) {
        int greatestCommonDivisor = findGreatestCommonDivisor(fraction.getNumerator(), fraction.getDenominator());
        return new Fraction(fraction.getNumerator() / greatestCommonDivisor, fraction.getDenominator() / greatestCommonDivisor);
    }
    
    /**
     * In mathematics, the greatest common divisor (gcd) of two or more integers, 
     * which are not all zero, is the largest positive integer that divides each 
     * of the integers. For example, the gcd of 8 and 12 is 4.
     * 
     * @return greatest common divisor;
     */
    int findGreatestCommonDivisor(int firstNumber, int secondNumber) {
        while(firstNumber != secondNumber){
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber - secondNumber;
            } else {
                secondNumber = secondNumber - firstNumber;
            }   
        }
        return firstNumber;
    }
}
