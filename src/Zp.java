import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Zp {
    
    private BigInteger p;
    private BigInteger g;
    private List<BigInteger> zpStar;

    public Zp(int p){
        this.p = BigInteger.valueOf(p);
        zpStar = new ArrayList<>();
        for(int i = 1; i < p; i++){
           zpStar.add(BigInteger.valueOf(i)); 
        }
    }

    public BigInteger getElement(int i){
        return zpStar.get(i).mod(p);
    }

    public void setGenerator(int i){
        this.g = zpStar.get(i - 1);
        System.out.println("set generator to: " + this.g);
    }

    public BigInteger generateWithExp(int exp){
        return this.g.modPow(BigInteger.valueOf(exp), p);
    }

    public void generateVals(int numGenerated){
        for(int i = 1; i < numGenerated + 1; i++){
            System.out.println((g.pow(i)).mod(p));
        } 
    }

    public void generateSquares(int numGenerated){
        int curr = 2;
        for(int i = 1; i < numGenerated; i++){
            System.out.println("exponent: " + curr + " g^x: " + g.pow(curr));
            System.out.println("resulting key: " + (g.pow(curr)).mod(p));
            curr += 2;
        } 
    }

    public void generateValsByExponent(int numGenerated, int exponent){
        int curr = exponent;
        for(int i = 0; i < numGenerated; i++){
            System.out.println("exponent: " + curr + " g^x: " + g.pow(curr));
            System.out.println("resulting key: " + (g.pow(curr)).mod(p));
            curr += exponent;
        } 
    }

    public void printGenerator(){
        System.out.println(this.g.intValue());
    }

    public void printZp(){
        zpStar.forEach(bigint -> {
            System.out.println(bigint.mod(p).intValue());
        });
    }


    public static void main(String[] args) {
        Zp zp = new Zp(17);
        zp.setGenerator(3);
        //zp.generateVals(16);
        zp.generateValsByExponent(10, 2);
    }
}
