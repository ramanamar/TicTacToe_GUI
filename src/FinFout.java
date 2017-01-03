import java.io.*;
import java.util.Arrays;

/**
 * Created by Raman on 29/12/2016.
 */
public class FinFout {
    public static void main(String[] args) {
        try {
            /*Byte reading*/
            FileInputStream fin = new FileInputStream("1.txt");
            FileOutputStream fout = new FileOutputStream("3.txt");

            int a;
            do {
                a = fin.read();
                if (a != -1) fout.write(a);
            } while (a != -1);
            fin.close();

            fin = new FileInputStream("2.txt");
            do {
                a = fin.read();
                if (a != -1) fout.write(a);
            } while (a != -1);
            if (fin != null) fin.close();
            if (fout != null) fout.close();

//            String a1 = "Hello world! \n";
//            String a2 = "Hullu wirld!";
//            byte[] wbr1 = a1.getBytes("UTF-8"), wbr2 = a2.getBytes("UTF-8");

            /*PrintWriter pw = new PrintWriter(new FileWriter("3.txt"));

            BufferedReader br1 = new BufferedReader(new FileReader("1.txt"));
            String s1;
            do {
                s1 = br1.readLine();
                pw.write(s1, 1, s1.length());
//                System.out.println(s1);
            } while (s1 != null);
            BufferedReader br2 = new BufferedReader(new FileReader("2.txt"));
            String s2;
            do {
                s2 = br2.readLine();
//                pw.write(s2);
//                System.out.println(s2);
            } while (s2 != null);

            pw.println(br1);
//            pw.println(br2);
            pw.flush();
            pw.close();
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        long t1 = System.currentTimeMillis();
        find();
        long t2 = System.currentTimeMillis();
        System.out.println(t2 -t1);

    }

    /*Byte Find text in file*/
    public static void find() {
        String a = "Best";
        byte[] b = a.getBytes();
        System.out.println(Arrays.toString(b));
        int c = 0;
        int pointer = 0;

        try {
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream("3.txt"));
//            FileInputStream reader = new FileInputStream("3.txt");

            int x;
            do {
                pointer++;
                x = reader.read();
                if (b[c] == x) {
                    c++;
                    if (c == b.length) {
                        System.out.println("WIN at " + (pointer - c));
                        break;
                    }
                } else c = 0;
            } while (x != -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
