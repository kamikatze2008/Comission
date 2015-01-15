package org.epam.training.comission.denysov.documentQueue;

import org.epam.training.comission.denysov.documents.Document;
import org.epam.training.comission.denysov.institutes.Institute;

import java.util.ArrayList;

/**
 * Created by asus on 13.01.2015.
 */
public class DocumentQueue extends Thread {
    private ArrayList<Document> documents;
    private ArrayList<Document> temp = new ArrayList<Document>();
    private boolean isAvailable = true;

    public ArrayList<Document> getTemp() {
        return temp;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public DocumentQueue(ArrayList<Document> documents) {
        this.documents = documents;
    }

    @Override
    public void run() {
        while (true) {
            if (!isCompletelyEmpty()) {
                if (isAvailable == true) {
                    fillTemp(temp);
                    //System.out.println("lol\t"+documents.size()+"\t"+temp.size());
                    Institute.setInstitutesWorked(3);
                    isAvailable = false;
                }
                Thread.yield();
            } else {
                break;
            }
        }
    }

    public boolean isCompletelyEmpty() {
        return documents.isEmpty() && temp.isEmpty();
    }

    public void fillTemp(ArrayList<Document> temp) {
        Document tempDocument;
        while (temp.size() != 50) {
            if (documents.size() == 0) {
                break;
            }
            tempDocument = documents.get((int) (Math.random() * documents.size()));
            temp.add(tempDocument);
            documents.remove(tempDocument);
        }
    }
}
