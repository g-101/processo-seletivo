package br.com.g101.processoseletivo.entity;


public class CompleteName {
    private String firstName;
    private String lastName;

    public CompleteName() {
    }

    public CompleteName(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;

    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCompleteName() {
        return firstName + " " + lastName;
    }





    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
