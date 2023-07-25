package br.com.g101.processoseletivo.entity;


public class CompleteName {
    private String firstName;
    private String lastName;

    public CompleteName() {
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }


    public void isValidCompleteName(String name, String lastName)
    {
        if(name.length() < 3 || name.length() > 150 || !name.matches("^[\\p{L}\\s]+$") )
        {
            throw new IllegalArgumentException("Nome Invalido");

        }
        if(lastName.length() < 3 || lastName.length() > 150 || !lastName.matches("^[\\p{L}\\s]+$"))
        {
            throw new IllegalArgumentException("Sobrenome Invalido");

        }
        this.firstName = name;
        this.lastName = lastName;

    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
