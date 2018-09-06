/**
 * FileName: Mod10Ans
 * Author:   Chris Li
 * Date:     9/6/2018 8:35 PM
 * Description:
 * History:
 */

listing 1
/* Copy a text file, substituting hyphens for spaces.

   This version uses bytes streams.

   To use this program, specify the name
   of the source file and the destination file.
   For example,

   java Hyphen source target
*/

import java.io.*;

class Hyphen {
    public static void main(String args[])
            throws IOException
    {
        int i;
        FileInputStream fin;
        FileOutputStream fout;

        try {
            // open input file
            try {
                fin = new FileInputStream(args[0]);
            } catch(FileNotFoundException exc) {
                System.out.println("Input File Not Found");
                return;
            }

            // open output file
            try {
                fout = new FileOutputStream(args[1]);
            } catch(FileNotFoundException exc) {
                System.out.println("Error Opening Output File");
                return;
            }
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: Hyphen From To");
            return;
        }

        // Copy File
        try {
            do {
                i = fin.read();
                if((char)i == ' ') i = '-';
                if(i != -1) fout.write(i);
            } while(i != -1);
        } catch(IOException exc) {
            System.out.println("File Error");
        }

        fin.close();
        fout.close();
    }
}

listing 2
/* Copy a text file, substituting hyphens for spaces.

   This version uses character streams.

   To use this program, specify the name
   of the source file and the destination file.
   For example,

   java Hyphen2 source target
*/

        import java.io.*;

class Hyphen2 {
    public static void main(String args[])
            throws IOException
    {
        int i;
        FileReader fin;
        FileWriter fout;

        try {
            // open input file
            try {
                fin = new FileReader(args[0]);
            } catch(FileNotFoundException exc) {
                System.out.println("Input File Not Found");
                return;
            }

            // open output file
            try {
                fout = new FileWriter(args[1]);
            } catch(IOException exc) {
                System.out.println("Error Opening Output File");
                return;
            }
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: Hyphen2 From To");
            return;
        }

        // Copy File
        try {
            do {
                i = fin.read();
                if((char)i == ' ') i = '-';
                if(i != -1) fout.write(i);
            } while(i != -1);
        } catch(IOException exc) {
            System.out.println("File Error");
        }

        fin.close();
        fout.close();
    }
}

