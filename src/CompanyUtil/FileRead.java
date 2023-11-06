package CompanyUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {

    //reads the file and handles error this method was used throughout the whole project
    public static ArrayList<String> readFile(String path){
        //We store all the lines in an arrayList, and then we compare the IDs in another while loop afterward
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(new File(path));

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (!line.trim().isEmpty()){data.add(line);}
            }
            fileReader.close();

        }catch (IOException e){
            e.printStackTrace();       }
        return data;
    }

    //Make sure the file exists
    public static boolean fileExists(String path){
        File file = new File(path);
        return file.isFile() && file.exists();
    }


}


