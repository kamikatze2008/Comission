package org.epam.training.comission.denysov.institutes;

import org.epam.training.comission.denysov.documentQueue.DocumentQueue;
import org.epam.training.comission.denysov.documents.Document;

import java.util.ArrayList;

/**
 * Created by asus on 13.01.2015.
 */
public abstract class Institute extends Thread {
    protected ArrayList<Document> documents = new ArrayList<Document>();
    protected DocumentQueue documentQueue;

    protected Boolean isBusy=false;
    protected static Integer institutesWorked = 0;

    public static int getInstitutesWorked() {
        return institutesWorked;
    }

    public static void setInstitutesWorked(int institutesWorked) {
        Institute.institutesWorked = institutesWorked;
    }

    public ArrayList<Document> getAllDocuments() {
        return documents;
    }

    public abstract void getDocuments();

    @Override
    public void run() {
        getDocuments();
    }

    @Override
    public String toString() {
        return "Institute{ " + this.getClass().getName().replace("org.epam.training.comission.denysov.institutes.", "") +
                "\n" + documents.size() + " students" +
                "\ndocuments=" + documents +
                '}';
    }
}
