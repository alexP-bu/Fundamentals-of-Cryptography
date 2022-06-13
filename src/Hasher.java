import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
    
    private MessageDigest messageDigest;

    public Hasher(String hashFunction) throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance(hashFunction);
    }

    /** 
     * @param toHash
     */
    public void getHash(String toHash) {
        byte[] digest = messageDigest.digest(toHash.getBytes());        
        System.out.println("hashed value successfully: ");
        System.out.println(digestToString(digest));
        
    }

    
    /** 
     * @param digest
     * @return String
     */
    private String digestToString(byte[] digest){
        BigInteger temp = new BigInteger(1, digest);
        return temp.toString(16);
    }

    
    /** 
     * @param args
     */
    /*
     * Test harness for hasher class
     */
    public static void main(String[] args) {
        try{
            Hasher hasher = new Hasher("SHA-256");
            hasher.getHash("test");
        }catch (Exception err){
            err.printStackTrace();
        }
    }
}
