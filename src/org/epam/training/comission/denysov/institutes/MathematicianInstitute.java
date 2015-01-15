package org.epam.training.comission.denysov.institutes;

import org.epam.training.comission.denysov.documentQueue.DocumentQueue;
import org.epam.training.comission.denysov.documents.Document;
import org.epam.training.comission.denysov.documents.Orientation;

/**
 * Created by asus on 13.01.2015.
 */
public class MathematicianInstitute extends Institute {

    public MathematicianInstitute(DocumentQueue documentQueue) {
        this.documentQueue = documentQueue;
    }

    @Override
    public void getDocuments() {
        Document tempDocument;
        while (!documentQueue.isCompletelyEmpty()) {
            synchronized (isBusy) {
                if (!documentQueue.isAvailable()) {
                    if (!documentQueue.getTemp().isEmpty()) {
                        tempDocument = documentQueue.getTemp().get((int) (Math.random() * documentQueue.getTemp().size()));

                        while (tempDocument.getOrientation().equals(Orientation.MATHEMATICIAN)) {
                            documentQueue.getTemp().remove(tempDocument);
                            documents.add(tempDocument);
                            if (!documentQueue.getTemp().isEmpty()) {
                                tempDocument = documentQueue.getTemp().get((int) (Math.random() * documentQueue.getTemp().size()));
                            } else {
                                break;
                            }
                        }
                    } else {
                        continue;
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
