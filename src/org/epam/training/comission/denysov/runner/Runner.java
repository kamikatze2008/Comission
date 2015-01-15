package org.epam.training.comission.denysov.runner;

import org.epam.training.comission.denysov.documentQueue.DocumentQueue;
import org.epam.training.comission.denysov.documents.Document;
import org.epam.training.comission.denysov.documents.Orientation;
import org.epam.training.comission.denysov.institutes.BiologistInstitute;
import org.epam.training.comission.denysov.institutes.BothInstitute;
import org.epam.training.comission.denysov.institutes.Institute;
import org.epam.training.comission.denysov.institutes.MathematicianInstitute;

import java.util.ArrayList;

/**
 * Created by asus on 12.01.2015.
 */
public class Runner {
    private static ArrayList<Document> documents= new ArrayList<Document>();

    public static void main(String[] args) {
        fillDocuments();
        DocumentQueue documentQueue=new DocumentQueue(documents);
        documentQueue.start();
        Institute biologistInstitute=new BiologistInstitute(documentQueue);
        Institute bothInstitute = new BothInstitute(documentQueue);
        Institute mathematicianInstitute = new MathematicianInstitute(documentQueue);

        biologistInstitute.start();
        bothInstitute.start();
        mathematicianInstitute.start();


        try {
            biologistInstitute.join();
            bothInstitute.join();
            mathematicianInstitute.join();
            System.out.println(biologistInstitute+"\n*****\n"+bothInstitute+"\n*****\n"+mathematicianInstitute);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int all=biologistInstitute.getAllDocuments().size()+bothInstitute.getAllDocuments().size()+mathematicianInstitute.getAllDocuments().size();
        System.out.println(all);
    }

    private static void fillDocuments() {
        for (int i = 0; i < 200; i++) {
            documents.add( new Document(Orientation.BIOLOGIST, "Sergii", "Denysov", i + 1));
        }
        for (int i = 200; i < 450; i++) {
            documents.add(new Document(Orientation.MATHEMATICIAN, "Kseniya", "Denysova", i - 199));
        }
    }
}
