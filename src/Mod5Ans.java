/**
 * FileName: Mod5Ans
 * Author:   Chris Li
 * Date:     9/6/2018 8:35 PM
 * Description:
 * History:
 */

listing 1
// Average 10 double values.
class Avg {
    public static void main(String args[]) {
        double nums[] = { 1.1, 2.2, 3.3, 4.4, 5.5,
                6.6, 7.7, 8.8, 9.9, 10.1 };
        double sum = 0;

        for(int i=0; i < nums.length; i++)
            sum += nums[i];

        System.out.println("Average: " + sum / nums.length);
    }
}

listing 2
// Demonstrate the Bubble sort with strings.
class StrBubble {
    public static void main(String args[]) {
        String strs[] = {
                "this", "is", "a", "test",
                "of", "a", "string", "sort"
        };
        int a, b;
        String t;
        int size;

        size = strs.length; // number of elements to sort

        // display original array
        System.out.print("Original array is:");
        for(int i=0; i < size; i++)
            System.out.print(" " + strs[i]);
        System.out.println();

        // This is the bubble sort for strings.
        for(a=1; a < size; a++)
            for(b=size-1; b >= a; b--) {
                if(strs[b-1].compareTo(strs[b]) > 0) { // if out of order
                    // exchange elements
                    t = strs[b-1];
                    strs[b-1] = strs[b];
                    strs[b] = t;
                }
            }

        // display sorted array
        System.out.print("Sorted array is:");
        for(int i=0; i < size; i++)
            System.out.print(" " + strs[i]);
        System.out.println();
    }
}

listing 3
// An improved XOR cipher.
class Encode {
    public static void main(String args[]) {
        String msg = "This is a test";
        String encmsg = "";
        String decmsg = "";
        String key = "abcdefgi";
        int j;

        System.out.print("Original message: ");
        System.out.println(msg);

        // encode the message
        j = 0;
        for(int i=0; i < msg.length(); i++) {
            encmsg = encmsg + (char) (msg.charAt(i) ^ key.charAt(j));
            j++;
            if(j==8) j = 0;
        }

        System.out.print("Encoded message: ");
        System.out.println(encmsg);

        // decode the message
        j = 0;
        for(int i=0; i < msg.length(); i++) {
            decmsg = decmsg + (char) (encmsg.charAt(i) ^ key.charAt(j));
            j++;
            if(j==8) j = 0;
        }

        System.out.print("Decoded message: ");
        System.out.println(decmsg);

    }
}

