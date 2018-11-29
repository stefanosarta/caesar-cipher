package caesarCipher;

public class Cipher2 {

    /* Creating a char array variable named message
     * Creating an int variable named key
     * Creating a char array variable named cipher*/
    private char[] message;
    private int key;
    private char[] cipher;

    /* Constructor that gets message and key variables. To be used on CipherApp.
     * It was asked that message needs to be saves as string so we are using .toCharArray*/
    public Cipher2(String M, int K ){
        message = M.toCharArray ();
        key = K;
    }

    /* Encipher method that encrypts the message that user gave and saves it to encipher char[] array we created.
     * I had the same problem here too. Using cipher as it is, it didn't work. I had to covert cipher to String and
     * then covert again to another char array to use it on the for loop. I couldn't even do myStringArrayCipher = cipher
     * and get it work.
     * Same with cArray. I created it using the converted String named test.
     * encipher may be declared as private because we are using a getter getcipher*/
    public void encipher(){
        char[] engArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String test = String.valueOf ( message );
        char[] myStringArrayCipher = test.toCharArray();
        int inputedOffset = key;

        for (int j = 0; j < engArray.length; j++) {
            for (int i = 0; i < message.length; i++) {
                /* Whenever the loop finds a letter on engArray that is at cArray too it saves the index position
                 * of that letter at engPosition variable.*/
                if (engArray[j] == message[i]) {
                    /* I am saving to textPosition the number that comes from i % offset. Whenever this if is running
                     * i takes the numbers from 0 to cArray.length. So it goes like this:
                     * First time: 0 % inputedOffset = 0
                     * Second time: 1 % inputedOffset = 1
                     * Third time: 2 % inputedOffset = 2
                     * Fourth time: 3 % inputedOffset = 3 etc. (This knowing offset is 4 for an example )
                     *
                     * For j knowing the word is show
                     * First time: newPosition = 18 + 0 so it remains at same position meaning S
                     * Second time: newPosition = 7 + 1 so it goes at 8 position which is I
                     * Third time: newPosition = 14 + 2 so it goes at 16 position which is Q
                     * Fourth time: newPosition = 22 + 3 so its goes at 25 position which is Z
                     * Simply knowing these it's easy to continue */
                    int textPosition = (i % inputedOffset);
                    int newPosition = (j + textPosition);

                    /*This if is only needed for the case that our new position is more than engArray.length. In this case 26
                     * Message that is ciphered is being saved at myStringArrayCipher*/
                    if (newPosition < engArray.length) {
                        myStringArrayCipher[i] = engArray[newPosition];
                    } else {
                        newPosition = newPosition - engArray.length;
                        myStringArrayCipher[i] = engArray[newPosition];
                    }
                }
            }
        }
        /* Saving the output to cipher as requested. */
        cipher = myStringArrayCipher;
    }


    public String decipher(){
        String test = String.valueOf ( message );
        char[] myStringArrayDecipher = test.toCharArray();
        char[] engArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int inputedOffset = key;
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < engArray.length; j++) {

                if (engArray[j] == cipher[i]) {

                    int textPosition = (i % inputedOffset);
                    int newPotition = (j - textPosition);
                    /*We are taking care of the times that subtracting goes less than 0 so we need to add
                     * cArray.length (meaning 26) just so we find the right index position on engArray.
                     * Decrypted message is being saved on myStringArrayDecipher*/
                    if (newPotition >= 0) {
                        myStringArrayDecipher[i] = engArray[newPotition];
                    } else {
                        newPotition = newPotition + engArray.length;
                        myStringArrayDecipher[i] = engArray[newPotition];
                    }
                }
            }
        }
        return String.valueOf ( myStringArrayDecipher );
    }

    /* This method returns the String value of message. Saying message we mean the inputed text from user. */
    public String getmessage() {
        return String.valueOf (message);
    }

    /*This method returns the String value of cipher. And to be more specific it returns the encrypted message.*/
    public String getcipher(){
        return String.valueOf ( cipher );
    }
}
