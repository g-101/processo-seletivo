package entities.applicant;


public class CompleteName {
    private String[] completeName;
    private String firstName;
    private String lastName;

    public CompleteName() {
    }

    public CompleteName(String completeName) {
        this.completeName = completeName.split(" ");
        if (isValidCompleteName(this.completeName[0], this.completeName[1])) {
            this.firstName = this.completeName[0];
            this.lastName = this.completeName[1];
        }
    }


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    // ###-- MÉTODOS -- ###
    public boolean isValidCompleteName(String name, String lastName) {
        boolean isNameValid = false;
        boolean isLastNameValid = false;

        if(name.length() > 3 && name.length() < 150 && name.matches("^[\\p{L}\\s]+$") ) {
            isNameValid = true;
        }

        if(lastName.length() > 3 && lastName.length() < 150 && lastName.matches("^[\\p{L}\\s]+$")) {
            isLastNameValid = true;
        }

        return isNameValid && isLastNameValid;

    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
