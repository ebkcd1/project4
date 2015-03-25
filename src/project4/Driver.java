/**
 *
 * Managed all I/O of the program. This is the quarterback of the program.
 */
package project4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 *
 */
public class Driver {

    private static Collection bubbleCollection,
            selectionCollection,
            insertionCollection,
            sortCollection,
            statisticsCollection;
    private static String contestA;
    private static String contestB;
    private static String contestC;
    private static String contestSearch;
    private static String[] studentsToSearchFor;

    /**
     * Constructor for Driver.
     */
    Driver() {
        bubbleCollection = new Collection(15);
            selectionCollection = new Collection(15);
            insertionCollection = new Collection(15);
            sortCollection = new Collection(15);
            statisticsCollection = new Collection(50);
            contestA = "Contest.Input.A.txt";
            contestB = "Contest.Input.B.txt";
            contestC = "Contest.Input.C.txt";
            contestSearch = "Contest.Search.txt";
            studentsToSearchFor = new String[15];
    }

    /**
     * 
     * @param file Defines the file that contains the students to be read into
     * the Collection
     * @param coll The collection that the Students will be read into

     */
    public static void readFileIntoCollection(String file, Collection coll) throws IOException {
        String fileName = file; // Creates a file name variable so we dont need to remember the name always
        String line = new String();
        BufferedReader br;
        FileReader fileR;

        try {
            fileR = new FileReader(fileName);
            br = new BufferedReader(fileR);
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {  //Reads the file and stores it in the array
                coll.add(new Student(line));
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
 * Reads the Contest file that contains the students to be searched for the
 * search algorithms
 */
    public static void readContest() throws IOException {

        String line = new String();
        String fileName = "Contest.Search.txt"; // Creates a file name variable so we dont need to remember the name always
        BufferedReader br;
        FileReader fileR;
        int i = 0;                              // Counter = 0;
        try {

            fileR = new FileReader(fileName);
            br = new BufferedReader(fileR);

            while ((line = br.readLine()) != null) {  //Reads the file and stores it in the array
                studentsToSearchFor[i] = line;
                i++;
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
     * 
     * @param coll The collection whose contents will be written to a file
     * @throws IOException 
     */
    public static void writeCollectionContents(Collection coll) throws IOException {
        try {
            File file = new File("output.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            int i = 0;

            while (!coll.isEmpty()) {
                bw.write(coll.outputStudent(i));
                bw.newLine();
                coll.remove(0);
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException er) {
            System.out.println("Out of bounds");
            System.exit(0);

        }
    }

    /**
     * Calls the methods to meets the requirements of the porject and match
     * the output
     */
    public static void execute() throws IOException {
        
        //Reads the ContestA into the three different collections which will 
        //perform the three different sorts
        readFileIntoCollection(contestA, bubbleCollection);
        readFileIntoCollection(contestA, selectionCollection);
        readFileIntoCollection(contestA, insertionCollection);

        //Performs the sorts
        bubbleCollection.bubbleSort();
        selectionCollection.selectionSort();
        insertionCollection.insertionSort();

        //Outputs the results of the sorts related to the number of copies required
        System.out.println("The Bubble Sort algorithm required " + bubbleCollection.getCopies() + " copies");
        System.out.println("The Selection Sort algorithm required " + selectionCollection.getCopies() + " copies");
        System.out.println("The Insertion Sort algorithm required " + insertionCollection.getCopies() + " copies");
        System.out.println("");
        insertionCollection.display();
        System.out.println("");

        //Reads all three files into one Collection
        readFileIntoCollection(contestA, statisticsCollection);
        readFileIntoCollection(contestB, statisticsCollection);
        readFileIntoCollection(contestC, statisticsCollection);

        //Sorts the array based upon total points and gives some stats on the 
        //points of the collection of students
        statisticsCollection.sortArray();
        System.out.println("The maximum points earned was: " + statisticsCollection.getMax());
        System.out.println("The minimum points earned was: " + statisticsCollection.getMin());
        System.out.println("The average points earned was: " + String.format("%.2f", statisticsCollection.getAverage()));
        System.out.println("The median points earned was: " + String.format("%.2f", statisticsCollection.getMedian()));

        //Sorts the Collection based on the students name to prepare it for testing
        //with the searching algorithms
        statisticsCollection.selectionSort();
        readContest(); //Reads the contest file into a String

        System.out.println();
        System.out.println("Resuls for Linear Search:");
        for (int i = 0; i < studentsToSearchFor.length && studentsToSearchFor[i] != null; i++) {
            statisticsCollection.displaySearchResults(statisticsCollection.linearSearch(studentsToSearchFor[i]), studentsToSearchFor[i]);
        }

        System.out.println();
        System.out.println("Resuls for Binary Search:");
        for (int i = 0; i < studentsToSearchFor.length && studentsToSearchFor[i] != null; i++) {
            statisticsCollection.displaySearchResults(statisticsCollection.binarySearch(studentsToSearchFor[i]), studentsToSearchFor[i]);
        }

        writeCollectionContents(statisticsCollection);
    }

}
