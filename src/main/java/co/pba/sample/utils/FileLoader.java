package co.pba.sample.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileLoader {

    private FileLoader() {
    }

    public static BufferedReader load(String fileLocation) throws FileNotFoundException {
        File file = new File(fileLocation);
        return new BufferedReader(new FileReader(file));
    }
}
