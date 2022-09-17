import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
public class MolecularMass {
    private static Node head;
    private static Node cur;
    private static Node temp;
    public static int h = 1;//Initialize hydrogen weight
    public static int c = 12;//Initialize carbon weight
    public static int o = 16;//Initialize oxygen weight
    public static String input;

    // Helper Node class
    private class Node {
        private String object;
        private Node next;
    }

    public MolecularMass() {
        head = null;
        cur = null;
        temp = null;
    }
    public static void main (String[] args) throws Exception {
        //Reading the input file "molecularmass.in"
        //File file = new File("/u/css/trontw/3460/CS-3460-lab3/molecularmass.in");
        //Creating a Scanner object called input
        //Scanner input = new Scanner(file); 
        //Creating a string buffer to store input
        //StringBuffer strbuff = new StringBuffer();
        //Append new lines to the buffer
        //while (input.hasNext()) {
       //    strbuff.append(" "+input.nextLine());
       //}
        getInput();
        //-----------------------------------------------------
        //Try to push/pop onto IntStack
        //Don't know which string/buffer read command to use???
        //-----------------------------------------------------
        //First create a new stack
        IntStack stack = new IntStack();
        int index = 0;
        int multp = 0;
        int temp = 1;
        int total = 0;
        int var = 0;
        int sum = 0;
        while (index < input.length()) {
            char letter = input.charAt(index);
            //System.out.println("Index is = "+index);
            //System.out.println("Letter inside While is = "+letter);
            if (letter == 'h') {
                //System.out.println("Letter inside 'h' is = "+letter);
                stack.push(h);
                index++;
            } else if (letter == 'c') {
                //System.out.println("Letter inside 'c' is = "+letter);
                stack.push(c);
                index++;
            } else if (letter == 'o') {
                //System.out.println("Letter inside 'o' is = "+letter);
                stack.push(o); 
                index++;   
            } else if (letter == '(') {
                //Use sentinel value of 0 for open parenthesis
                stack.push(0);
                index++;
            } else if (letter == ')') {
                index++;
                //We will pop off the stack until we
                //find a zero (the sentinel)
                var = stack.pop();
                sum = var;
                while (var != 0) { 
                    //System.out.println("var in ) is = "+var);
                    //System.out.println("while pop temp is = "+temp);
                    if ((temp = stack.pop()) != 0) { 
                        sum += temp;
                        //System.out.println("sum in TEMP !=0 is "+sum);
                        //System.out.println("var in TEMP !=0 is "+var);
                        //System.out.println("temp in TEMP !=0 is "+temp);
                    } else {
                    //System.out.println("SETTING VAR to ZERO");
                    var = 0;
                    }
                }
                //System.out.println("var PUSH in ) is = "+var);
                //System.out.println("sum PUSH in ) is = "+sum);
                stack.push(sum);
            } else if (letter <= '0'+9 && letter >= '0'+2) {
                index++;
                multp = letter - '0';
                //System.out.println("Multp is = "+multp);
                //Pop last Molecular mass value entered before the number
                //Multiply the last Molecular value 
                //times the number passed in unless the last character 
                temp = stack.pop();
                stack.push(temp*multp);
            } else if (letter == ' ')
                System.out.println("INVALID INPUT");
        }
        while (!stack.isEmpty()) {
            total += stack.pop();
            //System.out.println("The Total is = "+total);
        }
        input = input.toUpperCase();
        System.out.println("The Molecular Mass of "+input+" is "+total);
    }

    private static void getInput() {
        System.out.print("Enter the molecule: ");
        Scanner scan = new Scanner(System.in);//Used to read Raghu's input
        input = scan.nextLine().toLowerCase();
        //System.out.println("Object is = "+input);
        //System.out.println("Object size is = "+input.length());
        scan.close();//close scanner
    }
}