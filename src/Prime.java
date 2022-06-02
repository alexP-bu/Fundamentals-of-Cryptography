import java.math.BigInteger;

//class which generates large prime numbers

//implementations based on FIPS DSS Standard, link:
//https://nvlpubs.nist.gov/nistpubs/FIPS/NIST.FIPS.186-4.pdf

public class Prime {


    public Prime(){
        super();
    }

    //implementation of OpenSSL's prime generation scheme:
    // 1. Generate n bit odd number, say p
    // 2. Test to see if p is prime, if it is, return p
    // 3. Otherwise, do p += 2, and repeat step 2.

    //fermat primality test can be used to check if a number is prime
    //However, carmichael numbers also satisfy fermat's theorem, so we use Miller-Rabin
    /*
    * Inputs: p: a value to test for primality, p>3; k: a parameter that determines the number of times to test for primality
    * Output: composite if n is composite, otherwise probably prime
    * Repeat k times:
    * Pick a randomly in the range [2, p − 2]
    * If a ^ (p-1) === 1 (mod p) then return composite
    */
    //CODE NEEDS TESTING
    public PRIME_STATUS fermatPrimalityTest(BigInteger p){
        //lets just set k to p - 2 to check all of them (terrible for large numbers)
        BigInteger a = new BigInteger("2");
        
        //if p is 0 or 1 its definitely not prime
        if((p.equals(BigInteger.ZERO)) || (p.equals(BigInteger.ONE))){
            return PRIME_STATUS.COMPOSITE;
        }

        if((p.equals(BigInteger.TWO))){
            return PRIME_STATUS.PRIME;
        }

        //run fermat's forumla
        while(a.compareTo(p.subtract(BigInteger.TWO)) < 0){
            if(a.modPow(p.subtract(BigInteger.ONE), p) != BigInteger.ONE){
                return PRIME_STATUS.COMPOSITE;
            }
        }
        //we must return probably prime because of carmichael numbers
        return PRIME_STATUS.PROBABLY_PRIME;
    }

    /*
     * step 2:
     * We shall use the Miller-Rabin test followed by one Lucas test
     * as described in FIPS page 70.
     * For a 1024 bit prime, we will use the standard for RSA DS w/
     * with a probability error of (2^-100)
     * as these generators are probabilisitc and not deterministic 
    */

    //Miller-Rabin Primality Test Algorithm Implemenation

    public PRIME_STATUS millerRabin(BigInteger w, int iterations){        
        return PRIME_STATUS.COMPOSITE;
    }

    public static BigInteger getPrime() {
        return null;
    }

    public static BigInteger getPrimitiveRoot(BigInteger p) {
        return null;
    }
}
