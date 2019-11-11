/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.arithmetic.fraction;

import polsl.jium.kszerlag.model.arithmetic.ArithmeticOperation;

/**
 * Provides implementation for basic arithmetic operation on Fraction
 * 
 * @version 1.0
 * @author szerlag
 */
public class FractionOperation implements ArithmeticOperation<Fraction> {
    
    @Override
    public Fraction add(Fraction firstSummand, Fraction secondSummand) {
            FractionUtil.validateElementsNotNull(firstSummand, secondSummand);
            Fraction firstSummandCommonDenominator = FractionUtil.findCommonDenominator(firstSummand, secondSummand);
            Fraction secondSummandCommonDenominator = FractionUtil.findCommonDenominator(secondSummand, firstSummand);
            int commonDenominator = firstSummandCommonDenominator.getDenominator();
            return new Fraction(firstSummandCommonDenominator.getNumerator() + secondSummandCommonDenominator.getNumerator(), commonDenominator);
    }

    @Override
    public Fraction subtruct(Fraction minuend, Fraction subtrahend) {
            FractionUtil.validateElementsNotNull(minuend, subtrahend);
            Fraction minuendCommonDenominator = FractionUtil.findCommonDenominator(minuend, subtrahend);
            Fraction subtrahendCommonDenominator = FractionUtil.findCommonDenominator(subtrahend, minuend);
            int commonDenominator = minuendCommonDenominator.getDenominator();
            return new Fraction(minuendCommonDenominator.getNumerator() - subtrahendCommonDenominator.getNumerator(), commonDenominator);
    }

    @Override
    public Fraction multiply(Fraction firstFactor, Fraction secondFactor) {
            FractionUtil.validateElementsNotNull(firstFactor, secondFactor);
            return new Fraction(firstFactor.getNumerator() * secondFactor.getNumerator(), firstFactor.getDenominator() * secondFactor.getDenominator());
    }

    @Override
    public Fraction divide(Fraction dividend, Fraction devisor) {
            FractionUtil.validateElementsNotNull(dividend, devisor);
            devisor = FractionUtil.revertFraction(devisor);
            return multiply(dividend, devisor);
    }

    @Override
    public Fraction power(Fraction base, int exponent) {
            FractionUtil.validateElementsNotNull(base);
            if (exponent == 0) {
                return new Fraction(1, 1);
            }
            Fraction power = base;
            if (exponent == 1) {
                return power;
            }
            if (exponent < 0) {
                power = FractionUtil.revertFraction(power);
                exponent = Math.abs(exponent);
            }
            for (int i = 1; i < exponent; i++) {
                power = multiply(power, base);
            }
            return power;
    }
}
