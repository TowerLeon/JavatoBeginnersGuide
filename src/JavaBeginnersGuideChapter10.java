/**
 * FileName: JavaBeginnersGuideChapter10
 * Author:   Chris Li
 * Date:     9/6/2018 8:30 PM
 * Description:
 * History:
 */

listing 1
// Read an array of bytes from the keyboard.

import java.io.*;

class ReadBytes {
    public static void main(String args[])
            throws IOException {
        byte data[] = new byte[10];

        System.out.println("Enter some characters.");
        System.in.read(data);
        System.out.print("You entered: ");
        for(int i=0; i < data.length; i++)
            System.out.print((char) data[i]);
    }
}

listing 2
// Demonstrate System.out.write().
class WriteDemo {
    public static void main(String args[]) {
        int b;

        b = 'X';
        System.out.write(b);
        System.out.write('\n');
    }
}

listing 3
/* Display a text file.

   To use this program, specify the name
   of the file that you want to see.
   For example, to see a file called TEST.TXT,
   use the following command line.

   java ShowFile TEST.TXT
*/

        import java.io.*;

class ShowFile {
    public static void main(String args[])
            throws IOException
    {
        int i;
        FileInputStream fin;

        try {
            fin = new FileInputStream(args[0]);
        } catch(FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: ShowFile File");
            return;
        }

        // read bytes until EOF is encountered
        do {
            i = fin.read();
            if(i != -1) System.out.print((char) i);
        } while(i != -1);

        fin.close();
    }
}

listing 4
/* Copy a text file.

   To use this program, specify the name
   of the source file and the destination file.
   For example, to copy a file called FIRST.TXT
   to a file called SECOND.TXT, use the following
   command line.

   java CopyFile FIRST.TXT SECOND.TXT
*/

        import java.io.*;

class CopyFile {
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
            System.out.println("Usage: CopyFile From To");
            return;
        }

        // Copy File
        try {
            do {
                i = fin.read();
                if(i != -1) fout.write(i);
            } while(i != -1);
        } catch(IOException exc) {
            System.out.println("File Error");
        }

        fin.close();
        fout.close();
    }
}

listing 5
// Write and then read back binary data.
        import java.io.*;

class RWData {
    public static void main(String args[])
            throws IOException {

        DataOutputStream dataOut;
        DataInputStream dataIn;

        int i = 10;
        double d = 1023.56;
        boolean b = true;

        try {
            dataOut = new
                    DataOutputStream(new FileOutputStream("testdata"));
        }
        catch(IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }

        try {
            System.out.println("Writing " + i);
            dataOut.writeInt(i);

            System.out.println("Writing " + d);
            dataOut.writeDouble(d);

            System.out.println("Writing " + b);
            dataOut.writeBoolean(b);

            System.out.println("Writing " + 12.2 * 7.4);
            dataOut.writeDouble(12.2 * 7.4);

        }
        catch(IOException exc) {
            System.out.println("Write error.");
        }

        dataOut.close();

        System.out.println();

        // Now, read them back.
        try {
            dataIn = new
                    DataInputStream(new FileInputStream("testdata"));
        }
        catch(IOException exc) {
            System.out.println("Cannot open file.");
            return;
        }

        try {
            i = dataIn.readInt();
            System.out.println("Reading " + i);

            d = dataIn.readDouble();
            System.out.println("Reading " + d);

            b = dataIn.readBoolean();
            System.out.println("Reading " + b);

            d = dataIn.readDouble();
            System.out.println("Reading " + d);
        }
        catch(IOException exc) {
            System.out.println("Read error.");
        }

        dataIn.close();
    }
}

listing 6
/*
   Project 10-1

   Compare two files.

   To use this program, specify the names
   of the files to be compared on the command line.

   java CompFile FIRST.TXT SECOND.TXT
*/

        import java.io.*;

class CompFiles {
    public static void main(String args[])
            throws IOException
    {
        int i=0, j=0;
        FileInputStream f1;
        FileInputStream f2;

        try {
            // open first file
            try {
                f1 = new FileInputStream(args[0]);
            } catch(FileNotFoundException exc) {
                System.out.println(args[0] + " File Not Found");
                return;
            }

            // open second file
            try {
                f2 = new FileInputStream(args[1]);
            } catch(FileNotFoundException exc) {
                System.out.println(args[1] + " File Not Found");
                return;
            }
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: CompFile f1 f2");
            return;
        }

        // Compare files
        try {
            do {
                i = f1.read();
                j = f2.read();
                if(i != j) break;
            } while(i != -1 && j != -1);
        } catch(IOException exc) {
            System.out.println("File Error");
        }
        if(i != j)
            System.out.println("Files differ.");
        else
            System.out.println("Files are the same.");

        f1.close();
        f2.close();
    }
}

listing 7
// Demonstrate random access files.
        import java.io.*;

class RandomAccessDemo {
    public static void main(String args[])
            throws IOException {

        double data[] = { 19.4, 10.1, 123.54, 33.0, 87.9, 74.25 };
        double d;
        RandomAccessFile raf;

        try {
            raf = new RandomAccessFile("random.dat", "rw");
        }
        catch(FileNotFoundException exc) {
            System.out.println("Cannot open file.");
            return ;
        }

        // Write values to the file.
        for(int i=0; i < data.length; i++) {
            try {
                raf.writeDouble(data[i]);
            }
            catch(IOException exc) {
                System.out.println("Error writing to file.");
                return ;
            }
        }

        try {
            // Now, read back specific values
            raf.seek(0); // seek to first double
            d = raf.readDouble();
            System.out.println("First value is " + d);

            raf.seek(8); // seek to second double
            d = raf.readDouble();
            System.out.println("Second value is " + d);

            raf.seek(8 * 3); // seek to fourth double
            d = raf.readDouble();
            System.out.println("Fourth value is " + d);

            System.out.println();

            // Now, read every other value.
            System.out.println("Here is every other value: ");
            for(int i=0; i < data.length; i+=2) {
                raf.seek(8 * i); // seek to ith double
                d = raf.readDouble();
                System.out.print(d + " ");
            }
        }
        catch(IOException exc) {
            System.out.println("Error seeking or reading.");
        }

        raf.close();
    }
}

listing 8
// Use a BufferedReader to read characters from the console.
        import java.io.*;

class ReadChars {
    public static void main(String args[])
            throws IOException
    {
        char c;
        BufferedReader br = new
                BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter characters, period to quit.");

        // read characters
        do {
            c = (char) br.read();
            System.out.println(c);
        } while(c != '.');
    }
}

listing 9
// Read a string from console using a BufferedReader.
        import java.io.*;

class ReadLines {
    public static void main(String args[])
            throws IOException
    {
        // create a BufferedReader using System.in
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        String str;

        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while(!str.equals("stop"));
    }
}

listing 10
// Demonstrate PrintWriter.
        import java.io.*;

public class PrintWriterDemo {
    public static void main(String args[]) {
        PrintWriter pw = new PrintWriter(System.out, true);
        int i = 10;
        double d = 123.67;

        pw.println("Using a PrintWriter.");
        pw.println(i);
        pw.println(d);

        pw.println(i + " + " + d + " is " + i+d);
    }
}

listing 11
/* A simple key-to-disk utilitiy that
   demonstrates a FileWriter. */

        import java.io.*;

class KtoD {
    public static void main(String args[])
            throws IOException {

        String str;
        FileWriter fw;
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        try {
            fw = new FileWriter("test.txt");
        }
        catch(IOException exc) {
            System.out.println("Cannot open file.");
            return ;
        }

        System.out.println("Enter text ('stop' to quit).");
        do {
            System.out.print(": ");
            str = br.readLine();

            if(str.compareTo("stop") == 0) break;

            str = str + "\r\n"; // add newline
            fw.write(str);
        } while(str.compareTo("stop") != 0);

        fw.close();
    }
}

listing 12
/* A simple disk-to-screen utilitiy that
   demonstrates a FileReader. */

        import java.io.*;

class DtoS {
    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;

        while((s = br.readLine()) != null) {
            System.out.println(s);
        }

        fr.close();
    }
}

listing 13
/* This program averages a list of numbers entered
   by the user.  */

        import java.io.*;

class AvgNums {
    public static void main(String args[])
            throws IOException
    {
        // create a BufferedReader using System.in
        BufferedReader br = new
                BufferedReader(new InputStreamReader(System.in));
        String str;
        int n;
        double sum = 0.0;
        double avg, t;

        System.out.print("How many numbers will you enter: ");
        str = br.readLine();
        try {
            n = Integer.parseInt(str);
        }
        catch(NumberFormatException exc) {
            System.out.println("Invalid format");
            n = 0;
        }

        System.out.println("Enter " + n + " values.");
        for(int i=0; i < n ; i++)  {
            System.out.print(": ");
            str = br.readLine();
            try {
                t = Double.parseDouble(str);
            } catch(NumberFormatException exc) {
                System.out.println("Invalid format");
                t = 0.0;
            }
            sum += t;
        }
        avg = sum / n;
        System.out.println("Average is " + avg);
    }
}

listing 14
        #if
        if(condition) statement;
        else statement;

        #switch
        switch(expression) {
        case constant:
        statement sequence
        break;
        // ...
        }

        #for
        for(init; condition; iteration) statement;

        #while
        while(condition) statement;

        #do
        do {
        statement;
        } while (condition);

        #break
        break; or break label;

        #continue
        continue; or continue label;

        listing 15
/*
   Project 10-2

   A help program that uses a disk file
   to store help information.
*/

        import java.io.*;

/* The Help class opens a help file,
   searches for an topic, and then displays
   the information associated with that topic.
   Notice that it handles all I/O exceptions
   itself, avoiding the need for calling
   code to do so. */
class Help {
    String helpfile; // name of help file

    Help(String fname) {
        helpfile = fname;
    }

    // Display help on a topic.
    boolean helpon(String what) {
        FileReader fr;
        BufferedReader helpRdr;
        int ch;
        String topic, info;

        try {
            fr = new FileReader(helpfile);
            helpRdr = new BufferedReader(fr);
        }
        catch(FileNotFoundException exc) {
            System.out.println("Help file not found.");
            return false;
        }
        catch(IOException exc) {
            System.out.println("Cannot open file.");
            return false;
        }

        try {
            do {
                // read characters until a # is found
                ch = helpRdr.read();

                // now, see if topics match
                if(ch == '#') {
                    topic = helpRdr.readLine();
                    if(what.compareTo(topic) == 0) { // found topic
                        do {
                            info = helpRdr.readLine();
                            if(info != null) System.out.println(info);
                        } while((info != null) &&
                                (info.compareTo("") != 0));
                        return true;
                    }
                }
            } while(ch != -1);
        }
        catch(IOException exc) {
            System.out.println("File error.");
            try {
                helpRdr.close();
            }
            catch(IOException exc2) {
                System.out.println("Error closing file.");
            }
            return false;
        }
        try {
            helpRdr.close();
        }
        catch(IOException exc) {
            System.out.println("Error closing file.");
        }
        return false; // topic not found
    }

    // Get a Help topic.
    String getSelection() {
        String topic = "";

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Enter topic: ");
        try {
            topic = br.readLine();
        }
        catch(IOException exc) {
            System.out.println("Error reading console.");
        }
        return topic;
    }
}

// Demonstrate the file-based Help system.
class FileHelp {
    public static void main(String args[]) {
        Help hlpobj = new Help("helpfile.txt");
        String topic;

        System.out.println("Try the help system. " +
                "Enter 'stop' to end.");
        do {
            topic = hlpobj.getSelection();

            if(!hlpobj.helpon(topic))
                System.out.println("Topic not found.\n");

        } while(topic.compareTo("stop") != 0);
    }
}

