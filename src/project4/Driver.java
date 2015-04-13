package project4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author eric
 */
public class Driver {
    private BinaryTree bTree = new BinaryTree();
    public void execute() throws IOException{
        Stack stack = new Stack();
        readFilesIntoBTree("States.Input.A.txt", "States.Input.B.txt", bTree);
        bTree.display(true);
        System.out.println("");
        bTree.display(false);
    }
    public static void readFilesIntoBTree(String file1, String file2, BinaryTree bTree) throws IOException {
        String fileName1 = file1; // Creates a file name variable so we dont need to remember the name always
        String fileName2 = file2;
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
                if((line1 = br1.readLine()) != null){
                    Node node1 = new Node(new State(line1));
                    bTree.insert(node1);
                }
                if((line2 = br2.readLine()) != null){
                    Node node2 = new Node(new State(line2));
                    bTree.insert(node2);
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
}
