package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    /**
     * Method for testCreateSave
     * @throws IOException
     */
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog();
        catalog.setName("Java Resources");
        catalog.setPath("D:\\java\\catalog.ser");
        Document doc = new Document();
        doc.setId("java1");
        doc.setName("Java Course 1");
        doc.setLocation("D:\\java\\catalog.ser");
        doc.addTag("type", "Slides");
        System.out.println(doc);
        catalog.add(doc);
        System.out.println(catalog);
        CatalogUtil.save(catalog);
    }

    /**
     * Method for testLoadView
     * @throws InvalidCatalogException
     */
    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("D:\\java\\catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }


}