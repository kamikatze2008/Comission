package org.epam.training.comission.denysov.institutes;

import org.epam.training.comission.denysov.documentQueue.DocumentQueue;
import org.epam.training.comission.denysov.documents.Document;

/**
 * Created by asus on 13.01.2015.
 */
public class BothInstitute extends Institute {
    public BothInstitute(DocumentQueue documentQueue) {
        this.documentQueue = documentQueue;
    }

    @Override
    public void getDocuments() {
        int randomNumber;
        Document tempDocument;
        while (!documentQueue.isCompletelyEmpty()) {
            synchronized (isBusy) {
                if (!documentQueue.isAvailable()) {
                    randomNumber = (int) (Math.random() * 5);
                    for (int i = 0; i < randomNumber && documentQueue.getTemp().size() > 0; i++) {
                        tempDocument = documentQueue.getTemp().get((int) (Math.random() * documentQueue.getTemp().size()));
                        documents.add(tempDocument);
                        documentQueue.getTemp().remove(tempDocument);
                    }
                    if (--institutesWorked == 0) {
                        documentQueue.setAvailable(true);
                    }
                    Thread.yield();
                }
            }
        }

    }
}
