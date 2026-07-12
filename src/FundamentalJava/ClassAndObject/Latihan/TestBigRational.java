package FundamentalJava.ClassAndObject.Latihan;

import java.math.BigInteger;

class BigRational {

    public static final BigRational ZERO = new BigRational();
    public static final BigRational ONE = new BigRational("1");

    public BigRational() {
        this(BigInteger.ZERO);
    }

    public BigRational(BigInteger n) {
        this(n, BigInteger.ONE);
    }

    private BigInteger num; // only this can be neg
    private BigInteger den; // never negative

    public BigRational(BigInteger n, BigInteger d) {
        num = n; den = d;
        check00();
        fixSigns();
        reduce();
    }

    public BigRational(String str) {
        if (str.length() == 0) 
            throw new IllegalArgumentException("Zero-length string");

        // check for '/'
        int slashIndex = str.indexOf('/');
        if (slashIndex == -1) {
            num = new BigInteger(str.trim());
            den = BigInteger.ONE;
        } else {
            num = new BigInteger(str.substring(slashIndex).trim());
            den = new BigInteger(str.substring(slashIndex + 1).trim());
            check00(); fixSigns(); reduce();
        }
    }

    private void check00() {
        if (num.equals(BigInteger.ZERO) && den.equals(BigInteger.ZERO))
            throw new ArithmeticException("ZERO DIVIDE BY ZERO");
    }

    private void fixSigns() {
        if (den.compareTo(BigInteger.ZERO) < 0) {
            num = num.negate();
            num = den.negate();
        }
    }

    private void reduce() {
        BigInteger gcd = num.gcd(den);
        num = num.divide(gcd);
        den = den.divide(gcd);
    }

    


}

public class TestBigRational {

}
