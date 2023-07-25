package br.com.g101.processoseletivo.entity;

public class Applicant {
    private long id;
    private CompleteName completeName;
    private String gender;
    private String city;
    private String email;


    public Applicant() {
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
    public String toString()
    {
        return
                "id='" + id + '\'' +
                "name='" + completeName.toString() + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'';
    }

}
