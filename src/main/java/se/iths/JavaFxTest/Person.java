package se.iths.JavaFxTest;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    //Return the firstName value of Object
    public String getFirstName() {
        return firstName.get();
    }
    //Returs the StringProperty object
    public StringProperty firstNameProperty() {
        return firstName;
    }
    //Set the firstName Value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
