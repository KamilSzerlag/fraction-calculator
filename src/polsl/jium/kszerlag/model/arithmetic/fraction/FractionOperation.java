package polsl.jium.kszerlag.model.arithmetic.fraction;

import polsl.jium.kszerlag.model.arithmetic.ArithmeticOperation;

/**
 * Provides implementation for basic arithmetic operation on Fraction
 * 
 * @version 3.0
 * @author Kamil Szerląg
 */
public class FractionOperation implements ArithmeticOperation<Fraction> {
    
    /**
     * Provides methods for basic operation on fraction.
     */
    private final FractionUtil fractionUtil;

    /**
     * Constructiong fraction operation and performing fractionUtil field initialization.
     */
    public FractionOperation() {
        this.fractionUtil = new FractionUtil();
    }
    
    @Override
    public Fraction add(Fraction firstSummand, Fraction secondSummand) {
        fractionUtil.validateElementsNotNull(firstSummand, secondSummand);
        Fraction firstSummandCommonDenominator = fractionUtil.findCommonDenominator(firstSummand, secondSummand);
        Fraction secondSummandCommonDenominator = fractionUtil.findCommonDenominator(secondSummand, firstSummand);
        int commonDenominator = firstSummandCommonDenominator.getDenominator();
        return new Fraction(firstSummandCommonDenominator.getNumerator() + secondSummandCommonDenominator.getNumerator(), commonDenominator);
}

    @Override
    public Fraction subtruct(Fraction minuend, Fraction subtrahend) {
        fractionUtil.validateElementsNotNull(minuend, subtrahend);
        Fraction minuendCommonDenominator = fractionUtil.findCommonDenominator(minuend, subtrahend);
        Fraction subtrahendCommonDenominator = fractionUtil.findCommonDenominator(subtrahend, minuend);
        int commonDenominator = minuendCommonDenominator.getDenominator();
        return new Fraction(minuendCommonDenominator.getNumerator() - subtrahendCommonDenominator.getNumerator(), commonDenominator);
    }

    @Override
    public Fraction multiply(Fraction firstFactor, Fraction secondFactor) {
        fractionUtil.validateElementsNotNull(firstFactor, secondFactor);
        return new Fraction(firstFactor.getNumerator() * secondFactor.getNumerator(), firstFactor.getDenominator() * secondFactor.getDenominator());
    }

    @Override
    public Fraction divide(Fraction dividend, Fraction devisor) {
        fractionUtil.validateElementsNotNull(dividend, devisor);
        devisor = fractionUtil.revertFraction(devisor);
        return multiply(dividend, devisor);
    }

    @Override
    public Fraction power(Fraction base, int exponent) {
        fractionUtil.validateElementsNotNull(base);
        if (exponent == 0) {
            return new Fraction(1, 1);
        }
        Fraction power = base;
        if (exponent == 1) {
            return power;
        }
        if (exponent < 0) {
            power = fractionUtil.revertFraction(power);
            exponent = Math.abs(exponent);
        }
        for (int i = 1; i < exponent; i++) {
            power = multiply(power, base);
        }
        return power;
    }
}
