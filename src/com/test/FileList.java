package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Main class
 * Traverses filesystem saving printing filenames
 */
public class FileList {


    public void listFiles () {
        Filter myFilter = new Filter();

        try {
            Files.walk(Paths.get("")).filter(myFilter::applyFilter)
                    .forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}