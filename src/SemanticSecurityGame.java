import java.util.function.Predicate;
import java.util.function.Supplier;
public class SemanticSecurityGame {
    //For a given cipher Ec = (E, D) defined over (K, M, C)
    //We can define adversary a and challenger c 
    //in two (or one, for bit guessing) experiments
    public Challenger game0 = new Challenger("test".getBytes(), true);
    public Challenger game1 = new Challenger("hello".getBytes(), false);
    
    public static Byte[] E(Byte[] key, Byte[] message){
        //USE AN ENCRYPTION METHOD HERE
        //DO NOT JUST RETURN THE MESSAGE AS DEFAULTED
        Byte[] ciphertext = message;
        return ciphertext;
    }

    //adversary class for SS security game
    public class Adversary {        
        private int numResultsTrue;
        private int numResultsFalse; 
        private Byte[] m0;
        private Byte[] m1;
        private Byte[] c;
        
        public Adversary(){
            super();
        }

        //message 0 computation 
        public void computeM0(Supplier<Byte[]> m2Supplier){
            this.m0 = m2Supplier.get();
        }

        //message 1 computation
        public void computeM1(Supplier<Byte[]> m1Supplier){
            this.m1 = m1Supplier.get();
        }

        //function which runs upon recieving ciphertexts
        public void recieveCipherText(Byte[] ciphertext){
            this.c = ciphertext;
        }
        
        //function for adversary to compute
        public boolean computeBHat(Predicate<Byte[]> f){
            return f.test(this.c);
        }



        //IMPLEMENT TESTING FUNCTIONS HERE
        //run function for the game given a challenger
        //as well as the predicate here
        public void run(Challenger c){
            
            this.computeM0( () -> {
                //IMPLEMENT FUNCTION TO GENERATE M0 HERE
                return new Byte[16];
            });

            this.computeM1( () -> {
                //IMPLEMENT FUNCTION TO GENERATE M1 HERE
                return new Byte[16];
            });

            c.recieveMessages(m0, m1, this);

            //IMPLEMENT ADVERSARY FUNCTION HERE
            this.computeBHat( ciphertext -> {
                return true;
            });
        }

        public double getSSAdv(){
            return ((double) numResultsTrue) / numResultsFalse;
        }
    }


    //challenger for SS security game
    public class Challenger {
        private Byte[] k;
        private boolean b = false;

        public Challenger(Byte[] k, boolean b){
            this.k = k;
            this.b = b;
        }

        //routine which runs on recieving m0, m1
        public void recieveMessages(Byte[] m0, Byte[] m1, Adversary A){
            if(b){
                A.recieveCipherText(E(k, m0));
            }else{
                A.recieveCipherText(E(k, m1));
            }
        }
    }
}
