package caesarCipher;

/*Title: Caesar Cipher
 * Created: Monday November 12, 2018
 * Updated: Monday November 12, 2018
 * Owner: Stefanos Moungkoulis
 * Email: stefanos.moungkoulis@gmail.com
 * Description: */

import java.util.Scanner;

public class CipherApp {
    public static void main(String[] args) {

        /* Using do-while in order to accomplish the repeat loop
         * Creating input Scanner so i can handle the user inputs
         * Saving user's message as a String named text
         * Saving the offset as an int named offset
         * Creating a Cipher2 object using the inputed String and int*/

        String answer = "";
        do {
            Scanner input = new Scanner ( System.in );
            System.out.print ( "Message to be encrypted: " );
            String text = input.nextLine ().toUpperCase ();
            System.out.print ( "Offset to be used " );
            int offset = input.nextInt ();
            Cipher2 first = new Cipher2 ( text, offset );

            /* Calling encipher so it encrypts the inputted message using desired offset.
              Outputting getcipher that contains the encrypted message.
              Outputting decipher that contains the decrypted message.
              Obviously those two need to be the same. We aren't programmatically.
              checking it though.
              Asking user about repeating the whole thing. Typing Y or y will repeat. Anything
              else is going to quit the program.*/


            first.encipher ();
            System.out.println(" ");
            System.out.println ( "Encrypted message is: " + first.getcipher () );
            System.out.println ( "Decrypted message is: " + first.decipher () );
            System.out.println("Continue(Y/N)");
            answer = input.next().toUpperCase();
        }while (answer.equals("Y"));
    }
}