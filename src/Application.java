import java.io.File;
import java.util.Scanner;

public class Application {

    void logicOfApplication() throws ScaryException {
        ListOfNumbers soul = new ListOfNumbers();
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        ListOfNumbers test = new ListOfNumbers();
        while (!exit == true) {
            System.out.println("\n" +
                    "Show the catalog - s\n" +
                    "Create the directory - cd\n" +
                    "Write to file - w\n" +
                    "Read from file - r\n" +
                    "exit - e");
            String command = scan.nextLine();
            switch (command) {
                case ("s"):
                    String s = "";
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter full path ('quit' to exit): ");
                    s = sc.nextLine();
                    soul.showTheDirectory(s);
                    break;
                case ("cd"):
                    System.out.println("enter the path where you want create the directory: ('quit' to exit)");
                    String path = scan.nextLine();
                    if (path.equals("quit")) {
                        break;
                    }
                    System.out.println("enter the name for new directory: ");
                    String dirName = path + scan.nextLine();
                    if (dirName.equals(path + "quit")) {
                        break;
                    }
                    soul.folderCreate(dirName);
                    break;
                case ("w"):
                    System.out.println("\nEnter the path to dir where you want to write the content: ('quit' to exit)");
                    String pathName = scan.nextLine();
                    if (pathName.equals("quit")) {
                        break;
                    }
                    System.out.println("\nEnter the file name: ('quit' to exit)");
                    String fileName = pathName + scan.nextLine();
                    if (fileName.equals(pathName + "quit")) {
                        break;
                    }
                    soul.writeContentToFile(fileName);
                    break;
                case ("r"):
                    int flag = 0;
                    while (flag == 0) {
                        System.out.println("\nEnter the path to file: ('quit' to exit)");
                        String pathFile = scan.nextLine();
                        if (pathFile.equals("quit")) {
                            break;
                        }
                        File file = new File(pathFile);
                        if (file.isFile()) {
                            soul.readConntentFromFile(pathFile);
                            flag = 1;
                        } else {
                            soul.showTheDirectory(pathFile);
                        }
                    }
                    break;
                case ("e"):
                    exit = true;
                    break;
            }
        }
    }
}
