import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
public class MolecularMass {
    private static Node head;
    private static Node cur;
    private static Node temp;

    public MolecularMass() {
        head = null;
        cur = null;
        temp = null;
    }
    public static void main (String[] args) throws Exception {
        //Reading the input file "molecularmass.in"
        File file = new File("/u/css/trontw/3460/CS-3460-lab3/molecularmass.in");
        //Creating a Scanner object called input
        Scanner input = new Scanner(file); 
        //Creating a string buffer to store input
        StringBuffer strbuff = new StringBuffer();
        //Append new lines to the buffer
        while (input.hasNext()) {
            strbuff.append(" "+input.nextLine());
        }
        System.out.println(strbuff);
    }
}