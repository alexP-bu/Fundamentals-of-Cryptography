import java.math.BigInteger;

public class PRG {

    /* 
    * The Blum–Micali algorithm is a cryptographically secure pseudorandom number generator. 
    * The algorithm gets its security from the difficulty of computing discrete logarithms.
    * Let p be an odd prime, x0 be a seed
    * then x.i+1 = g^x mod p
    */

    String type;
    BigInteger p; //a large probablitisticly generated prime
    BigInteger g; //primive root mod p
    BigInteger x; //current output of PRG

    public PRG(String type){
        super();
        this.type = type;
        this.p = Prime.getPrime();
        this.g = Prime.getPrimitiveRoot(p);
    }

    //return next value of PRG
    public BigInteger getNext(){
        BigInteger nextX = g.modPow(x, p);
        this.x = nextX;
        return nextX;
    }
}
