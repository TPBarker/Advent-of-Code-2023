package advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class myReader {
    
    private Scanner reader;

    public myReader(String filePath) {
        File file = new File(filePath);
        try {
            this.reader = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();    
        }
    }

    public ArrayList<String> arrayOfStrings() {
        ArrayList<String> stringArray = new ArrayList<String>();
        while(this.reader.hasNextLine()) {
            stringArray.add(reader.nextLine());
        }
        return stringArray;
    }

}
