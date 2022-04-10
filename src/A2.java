/*
Author: Daniel Beiers c3039134
Date: 10.4.2022
Project: SENG2200 Assignment 2
Description: The main execution class for the assignment. This class parses a file, read from the command line arguments,
            and reads the values through a factory method for planar shapes and calls the appropriate constructors for the information.
            The resultant child objects are stored in a Circularly Linked List, and iterated over to be printed on screen and passed to a new linked list containing the objects
            is descending order of area.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class A2 {

    public static void main(String[] args) {
        //A new type cast list created to hold data as unsorted and sorted items.
        LinkedList<PlanarShape> unsortedList = new LinkedList<PlanarShape>();
        SortedLinkedList<PlanarShape> sortedList = new SortedLinkedList<PlanarShape>();

        //Calling the iterator method and associating it with the unsorted list.
        Iterator<PlanarShape> it = unsortedList.iterator();

        try {
            //Read the file name from the command line arguments.
            File file_ = new File(args[0]);
            Scanner myReader = new Scanner(file_);
            //Loop to parse the data within the text file.
            while (myReader.hasNext()) {
                //Parse for type of Planar Shape
                char type = myReader.next().charAt(0);
                //Loop to store the double parameter arguments until no more doubles found.
                double[] array = new double[0];
                while (myReader.hasNextDouble()){
                    double[] temp = new double[array.length + 1];
                    int i = 0;
                    for(double d:array){
                        temp[i] = array[i];
                        i++;
                    }
                    temp[i] = myReader.nextDouble();
                    array = temp;
                }

                //Type and array passed to the shapeFactory method and the object returned, inserted into the unsorted list in input order as per spec.
                unsortedList.append(shapeFactory(type,array));
            }

            //Loop using iterator to output each object to screen. And insert each object to the sorted list.
            System.out.println("Unsorted list");
            while(it.hasNext()){
                PlanarShape next = it.next();
                System.out.println(next);
                sortedList.insertInOrder(next);
            }

            //Re-use iterator for sorted list and output each object to screen.
            it = sortedList.iterator();
            System.out.println("Sorted list");
            while(it.hasNext()){
                System.out.println(it.next());
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with locating file.");
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("An error occurred reading from the file. Data might be incorrect format");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("An unknown error occurred.");
            e.printStackTrace();
        }
    }

    //Factory method to allocate incoming parameters into the appropriate child class constructors and return object to call.
    private static PlanarShape shapeFactory(char a, double[] b) {
        switch(a){
            case 'P':
                return new Polygon(b);
            case 'S':
                return new SemiCircle(b);
            case 'C':
                return new Circle(b);
            default:
                return null;
        }
    };
}
