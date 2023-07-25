package br.com.g101.processoseletivo.entity;

public class Applicant
{
    private long id;
    private CompleteName completeName;
    private Gender gender;
    private String city;
    private String email;


    public Applicant(){}

    public Applicant(long id, CompleteName completeName, Gender gender)
    {
        this.id = id;
        this.completeName = completeName;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                "\nid='" + id + '\'' +
                ", name='" + completeName.toString() + '\'' +
                ", gender='" + gender + '\'';

    }

}
