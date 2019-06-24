import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public void writeContentToFile(String fileName) {
            File file = new File(fileName);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintWriter pw = new PrintWriter(file);
                for (int i = 0; i < SIZE; i++) {
                    pw.println(list.get(i));
                }
                System.out.println("\nFile write successfully");
                pw.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }

    public void folderCreate(String fullPath) {
            File file = new File(fullPath);
            int folderCounter = 1;
            try {
                if (!file.exists()) {
                    new File(fullPath).mkdir();
                } else {
                    new File(fullPath + "(" + folderCounter + ")").mkdir();
                    folderCounter += 1;
                }
                System.out.println("directory is created.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void readConntentFromFile(String fileLocation) throws ScaryException {
            try {
                File file = new File(fileLocation);
                FileReader fr = new FileReader(file);
                int c;
                while ((c = fr.read()) != -1) {
                    System.out.print((char) c);
                }
                fr.close();
            } catch (FileNotFoundException ex) {
                throw new ScaryException("Such file doesn`t exist: " + ex);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    public void showTheDirectory(String pathname) {
        while (!pathname.equals("quit")) {
            File show = new File(pathname);
            if (!show.exists()) {
                System.out.println("\nNot found: " + pathname);
                break;
            }
            if (!show.isDirectory()) {
                System.out.println("\nNot directory: " + pathname);
                break;
            }
            System.out.println("this directory contain such files and directories :\n");
            String[] sDirList = show.list();
            for (String value : sDirList) {
                File f1 = new File(pathname + File.separator + value);
                if (f1.isFile()) {
                    System.out.println(value);
                    pathname = "quit";
                } else {
                    System.out.println("-dir- " + value);
                    pathname = "quit";
                }
            }
        }
    }
}




