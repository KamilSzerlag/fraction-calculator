/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.model.arithmetic.fraction;

import polsl.jium.kszerlag.model.arithmetic.Calculable;

/**
 *
 * @author szerlag
 */
public class Fraction implements Calculable, Comparable<Fraction>{
    
    private int numerator;
    private int denominator;
    private int fractionInteger;
       
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must not be 0!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public Fraction(int numerator, int denominator, int fractionInteger) {
        this(numerator, denominator);
        this.fractionInteger = fractionInteger;
    }

    public static Fraction valueOf(String fraction) {
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
        Fraction irreducibleOther = FractionUtil.getIrreducibleFraction(other);
        Fraction irreducibleThis = FractionUtil.getIrreducibleFraction(this);
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
        final Fraction otherCommonDenominator = FractionUtil.findCommonDenominator(other, this);
        if (this.getNumerator() < otherCommonDenominator.getNumerator()) {
            return -1;
        }
        if (this.getNumerator() > otherCommonDenominator.getNumerator()) {
            return 1;
        }
        return 0;
    }
    
    public double doubleValue() { 
        return this.numerator / this.denominator;
    }
  }
