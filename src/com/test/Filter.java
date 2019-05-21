package com.test;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;


/**
 * Class for matching
 */
public class Filter {

    private HashSet<String> ignoreFiles;


    Filter() {
        ignoreFiles = new HashSet<>();


        File ignore = new File(".ignore");

        if (!ignore.exists() || ignore.isDirectory())
            return;


        try {
            BufferedReader reader = new BufferedReader(new FileReader(ignore));
            String line;
            while((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.length() == 0 || line.charAt(0) == '#')
                    continue;
                ignoreFiles.add(Paths.get(line).toAbsolutePath().toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean applyFilter (Path path) {
        String p = path.toAbsolutePath().toString();
        for (String it: ignoreFiles) {
            if (p.contains(it))
                return false;
        }
        return true;
    }

}