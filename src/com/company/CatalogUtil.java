package com.company;

import java.awt.*;
import java.io.*;


public class CatalogUtil {

    /**
     * Saving data to nameoffile
     * @param catalog
     * @throws IOException
     */
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }


    /**
     * loading data from file at path...
     * @param path
     * @return
     * @throws InvalidCatalogException
     */
    public static Catalog load(String path) throws InvalidCatalogException {

        Catalog data = null;

        FileInputStream fileIn = null;
        try {
            ObjectInputStream in = null;
            fileIn = new FileInputStream(path);
            in = new ObjectInputStream(fileIn);
            data = (Catalog) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            /**
             * using the class InvalidCatalogException
             */
            throw new InvalidCatalogException(e);
        }


        return data;


    }

    /**
     * Opening the content of document
     * @param doc
     */

    public static void view(Document doc) {

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(doc.getLocation()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}














