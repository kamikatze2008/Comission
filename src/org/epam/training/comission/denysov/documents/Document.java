package org.epam.training.comission.denysov.documents;

/**
 * Created by asus on 13.01.2015.
 */
public class Document {
    int id;
    private String name;
    private String surname;
    private Orientation orientation;

    public Document(Orientation orientation, String name, String surname, int id) {
        this.orientation = orientation;
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "\nDocument{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", orientation=" + orientation +
                '}';
    }
}
