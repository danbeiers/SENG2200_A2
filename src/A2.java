import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class A2 {

    public static void main(String[] args) {
        //A new list object created to hold data
        LinkedList<PlanarShape> unsortedList = new LinkedList<PlanarShape>();
        SortedLinkedList<PlanarShape> sortedList = new SortedLinkedList<PlanarShape>();

        Iterator<PlanarShape> it = unsortedList.iterator();

        try {
            //File file_ = new File(args[0]);
            File file_ = new File("C:\\Users\\User\\IdeaProjects\\SENG2200_A2\\src\\a.txt");
            Scanner myReader = new Scanner(file_);
            //Loop to parse the data within the text file.
            while (myReader.hasNext()) {
                char type = myReader.next().charAt(0);
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
                unsortedList.append(shapeFactory((char) type,array));
            }

            System.out.println("Unsorted list");
            while(it.hasNext()){
                PlanarShape next = it.next();
                System.out.println(next);
                sortedList.insertInOrder(next);
            }

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
