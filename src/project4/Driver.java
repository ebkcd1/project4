package project4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 *
 * @author eric
 */
public class Driver {

    private BinaryTree bTree = new BinaryTree();
    private Stack stack = new Stack();
    private int[] deleteArray = new int[17];

    /**
     * The exexcute method performs projects requirements step by step.
     *
     * @param file An array of file names that will be read for input
     * @throws IOException
     */
    public void execute(String[] file) throws IOException {

        readFilesIntoStack(file[0], file[1], stack);
        System.out.println("");
        System.out.println(String.format("%-15s %-15s %-4s %-12s %-15s %-1s", "State", "Capital", "Abbr", "Population", "Region", "Region #"));
        stack.display();
        while (!stack.isEmpty()) {
            bTree.insert(stack.pop());
        }
        System.out.println("");
        System.out.println("State Data (Ascending by Population):");
        System.out.println(String.format("%-15s %-15s %-4s %-12s %-15s %-1s", "State", "Capital", "Abbr", "Population", "Region", "Region #"));
        bTree.display(true);
        System.out.println("");
        System.out.println("State Data (Descending by Population):");
        System.out.println(String.format("%-15s %-15s %-4s %-12s %-15s %-1s", "State", "Capital", "Abbr", "Population", "Region", "Region #"));
        bTree.display(false);

        readFilesIntoDelete(file[2], deleteArray);

        for (int x = 0; x < 17; x++) {
            if (!bTree.isEmpty()) {
                bTree.remove(deleteArray[x]);
            }
        }
        System.out.println("");
        System.out.println("State Data (Ascending by Population):");
        System.out.println(String.format("%-15s %-15s %-4s %-12s %-15s %-1s", "State", "Capital", "Abbr", "Population", "Region", "Region #"));
        bTree.display(true);
        System.out.println("");
        System.out.println("State Data (Descending by Population):");
        System.out.println(String.format("%-15s %-15s %-4s %-12s %-15s %-1s", "State", "Capital", "Abbr", "Population", "Region", "Region #"));
        bTree.display(false);
    }


    /**
     * Reads input from two files into a stack
     * @param file1
     * @param file2
     * @param stack
     * @throws IOException 
     */
    public static void readFilesIntoStack(String file1, String file2, Stack stack) throws IOException {
        String fileName1 = file1; // Creates a file name variable so we dont need to remember the name always
        String fileName2 = file2;

        //Needs some text for 
        String line1 = new String("INITIALIZE TEXT");
        String line2 = new String("INITIALIZE TEXT");
        BufferedReader br1, br2;
        FileReader fileR1, fileR2;

        try {
            fileR1 = new FileReader(fileName1);
            fileR2 = new FileReader(fileName2);
            br1 = new BufferedReader(fileR1);
            br2 = new BufferedReader(fileR2);
            while (line1 != null || line2 != null) {  //Reads the file and stores it in the array
                line1 = br1.readLine();
                line2 = br2.readLine();

                //if (line1 != null && line2 != null) {
                if (line1 == null && line2 != null) {
                    Node node2 = new Node(new State(line2));
                    stack.push(node2);
                } else if (line1 != null && line2 == null) {
                    Node node1 = new Node(new State(line1));
                    stack.push(node1);
                } else if (line1 != null && line2 != null) {
                    Node node1 = new Node(new State(line1));
                    Node node2 = new Node(new State(line2));
                    if (node1.toString().compareTo(node2.toString()) < 0) {
                        stack.push(node1);
                        stack.push(node2);
                    } else {
                        stack.push(node2);
                        stack.push(node1);
                    }

                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException er) {
            System.out.println("Out of bounds");
            System.exit(0);
        }
    }

    /**
     * Reads a file and stores the values in an array for processing later
     * @param file
     * @param deleteArray
     * @throws IOException 
     */
    public static void readFilesIntoDelete(String file, int[] deleteArray) throws IOException {
        String fileName = file; // Creates a file name variable so we dont need to remember the name always

        //Needs some text for 
        String line = new String("INITIALIZE TEXT");

        BufferedReader br;
        FileReader fileR;
        int x = 0;

        try {
            fileR = new FileReader(fileName);

            br = new BufferedReader(fileR);

            while ((line = br.readLine()) != null) {  //Reads the file and stores it in the array
                deleteArray[x] = parseInt(line);
                x++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException er) {
            System.out.println("Out of bounds");
            System.exit(0);
        }
    }

}
