import java.math.BigInteger;

//in this class, I experiment with several different PRG implementations
//From Boneh-Shoup, Applied Cryptography, page 82:

/*
 * Let us briefly describe the PRGs underlying the Salsa and ChaCha stream cipher families.
 * These PRGs take as input a 256-bit seed and a 64-bit nonce. For now we ignore the nonce and
 * simply set it to 0. We discuss the purpose of the nonce at the end of this section. The Salsa
 * and ChaCha PRGs follow the same high level structure shown in Fig. 3.8. They make use of two
 * components:
 * • A padding function denoted pad(s, j, 0) that combines a 256-bit seed s with a 64-bit counter
 * j to form a 512-bit block. The third input, a 64-bit nonce, is always set to 0 for now.
 * • A fixed public permutation π : {0, 1}
 * 512 → {0, 1}
 * 512
 * .
 * These components are used to output L < 2
 * 64 pseudorandom blocks, each 512 bits long, using the
 * following algorithm (Fig. 3.8):
 * input: seed s ∈ {0, 1}
 * 256
 * 1. for j ← 0 to L − 1
 * 2. hj ← pad(s, j, 0) ∈ {0, 1}
 * 512
 * 3. rj ← π(hj ) ⊕ hj
 * 4. output (r0, . . . , rL−1).
 */


public class PRG {
    
    private void  pad(BigInteger s, BigInteger j){

    }
}
