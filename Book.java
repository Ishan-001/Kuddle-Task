
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Book {
    private static ArrayList<Classes> classes;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        classes = new ArrayList<>();

        Boolean running = true;

        while (running) {

            System.out.println("Welcome to class booking demo application\n" +
                "Press <1> to add a class\n" +
                "Press <2> to join a class\n" +
                "Press <3> to cancel a class\n" +
                "Press <4> to exit");
            
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter class name (Ex. Yoga, Dance, Music, etc)\n");
                    String name = in.nextLine();
                    System.out.println("Enter class time in the format dd-MM-yyyy HH:mm\n");
                    String time = in.nextLine();
                    time += ":00";
                    System.out.println("Enter number of slots\n");
                    int limit = in.nextInt();

                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    classes.add(new Classes(name, limit, LocalDateTime.parse(time, format)));

                    System.out.println("Class added successfully\n");
                    break;

                case 2:
                    System.out.println("Enter your name");
                    String userName = in.next();
                    System.out.println("You can join the following classes:\n");
                    for (Classes type : classes) {
                        System.out.println(type.getType());
                    }
                    System.out.println("Enter the name of the class you want to join");
                    in.nextLine();
                    String className = in.nextLine();

                    checkIfAdmissible(className, userName);

                    break;

                case 3:
                    System.out.println("Enter your name");
                    String user = in.nextLine();
                    System.out.println("Enter the class you joined");
                    String classType = in.nextLine();

                    cancelClass(user, classType);
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Kindly enter choices from 1-3");

            }
        }
    }

    private static void cancelClass(String user, String className) {
        for (Classes class_: classes){
            if (class_.getType().equals(className)){
                if (class_.isCancellable(user)) {
                    class_.removeUser(user);
                    System.out.println("Class canceled successfully");
                }
                else {
                    System.out.println("Class cannot be cancelled");
                }
            }
        }
    }

    static void checkIfAdmissible(String className, String userName) {
        for (Classes type: classes){
            if (type.getType().equals(className)){
                if (type.isAdmissible()) {
                    type.addUserToClass(userName);
                    System.out.println("Joined Successfully \n");
                }
                else {
                    type.addUserToQueue(userName);
                    System.out.println("Sorry, the slots for this class are full. You'll be added if someone cancels!");
                    System.out.println(type.getQueue().toString());
                }
                break;
            }
        }
    }

    static void addClass(Classes type) {
        classes.add(type);
    }

}