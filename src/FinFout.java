import java.io.*;

/**
 * Created by Raman on 29/12/2016.
 */
public class FinFout {
    public static void main(String[] args) {
        try {
            /*FileInputStream fin1 = new FileInputStream("1.txt");
            int a;
            do {
                a = fin1.read();
                System.out.print((char) a);
            } while (a != -1);
            System.out.println();
            System.out.println();

            FileInputStream fin2 = new FileInputStream("2.txt");
            int b;
            do {
                b = fin2.read();
                System.out.print((char) b);
            } while (b != -1);*/

            BufferedReader br1 = new BufferedReader(new FileReader("1.txt"));
            String s1;
            do {
                s1 = br1.readLine();
                System.out.println(s1);
            } while (s1 != null);
            BufferedReader br2 = new BufferedReader(new FileReader("2.txt"));
            String s2;
            do {
                s2 = br2.readLine();
                System.out.println(s2);
            } while (s2 != null);

            /*PrintWriter pw = new PrintWriter(new FileWriter("3.txt"));
            pw.println(br1);
            pw.println(br2);
            pw.flush();
            pw.close();*/
            String a1 = "Hello world!";
            String a2 = "Hullu wirld!";
            byte[] wbr1 = a1.getBytes("UTF-8"), wbr2 = a2.getBytes("UTF-8");
            FileOutputStream fout = new FileOutputStream("3.txt");
            fout.write(wbr1);
            fout.write(wbr2);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        byte[] w = a.getBytes();
//        StringBuilder sb = new StringBuilder("1.txt");
//        for (int i = 0; i < ; i++) {
//            sb.append("2.txt");
//        }
    }
}
