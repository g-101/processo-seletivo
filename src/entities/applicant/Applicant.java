package entities.applicant;

public class Applicant {
    private long id;
    private CompleteName completeName;
    private String gender;
    private String city;
    private String email;


    public Applicant() {
    }

    public Applicant(long id) {
        this.id = id;
    }

    public Applicant(String completeName, String gender, String city, String email) {
        this.completeName = new CompleteName(completeName);
        this.gender = gender;
        this.city = city;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }


    // ###-- MÉTODOS -- ###
    public String getApplicantName() {
        return completeName.getFirstName();
    }

    public String getApplicantLastName() {
        return completeName.getLastName();
    }

    @Override
    public String toString() {
        return
                "name='" + completeName.toString() + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'';
    }

}
