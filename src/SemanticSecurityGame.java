import java.security.Key;
import java.util.LinkedList;
import java.util.List;

public class SemanticSecurityGame {
    //For a given cipher Ec = (E, D) defined over (K, M, C)
    //We can define adversary a and challenger c 
    //in two (or one, for bit guessing) experiments
    
    public static byte[] E(Key k, byte[] message){
        //USE AN ENCRYPTION METHOD HERE
        //DO NOT JUST RETURN THE MESSAGE AS DEFAULTED
        byte[] ciphertext = message;
        return ciphertext;
    }

    //adversary class for SS security game
    public class Adversary {        
        private int numResultsTrue;
        private int numResultsFalse; 
        private byte[] m0;
        private byte[] m1;
        
        public Adversary(){
            super();
        }

        //implement message 0 computation 
        public byte[] computeM0(){
            this.m0 = new byte[0];
            return this.m0;
        }

        //implement message 1 computation
        public byte[] computeM1(){
            this.m1 = new byte[0];
            return this.m1;
        }

        //function which runs upon recieving ciphertexts
        public void recieveCipherText(byte[] ciphertext){
            if(compute(ciphertext)){
                numResultsTrue++;
            }else{
                numResultsFalse++;
            }
        }
        
        //implement function for adversary to compute
        public boolean compute(byte[] ciphertext){
            //implement adversary computation on ciphertext here
            //we have access to m0 and m1 as private vars
            
            //default true would give perfect secrecy since Pr[b] = 0 = 1/2
            return true;
        }

        //run function for the game given a challenger
        public void run(Challenger c){
            c.recieveMessages(computeM0(), computeM1(), this); 
        }

        public int[] getResult(){
            return new int[]{numResultsTrue, numResultsFalse};
        }
    }


    //challenger for SS security game
    public class Challenger {
        private Key k;
        private boolean b = false;

        public Challenger(Key k, boolean b){
            this.b = b;
        }

        //routine which runs on recieving m0, m1
        public void recieveMessages(byte[] m0, byte[] m1, Adversary a){
            if(b){
                a.recieveCipherText(E(k, m0));
            }else{
                a.recieveCipherText(E(k, m1));
            }
        }
    }
}
