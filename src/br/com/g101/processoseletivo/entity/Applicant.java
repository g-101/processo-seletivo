package br.com.g101.processoseletivo.entity;

public class Applicant
{
    private long id;
    private CompleteName completeName;
    private Gender gender;
    private Location location;
    private Email email;


    public Applicant(){}

    public Applicant(long id, CompleteName completeName, Gender gender, Location location, Email email)
    {
        this.id = id;
        this.completeName = completeName;
        this.gender = gender;
        this.location = location;
        this.email = email;
    }



    @Override
    public String toString()
    {
        return
                "\nid='" + id + '\'' +
                ", nome='" + completeName.toString() + '\'' +
                ", gênero='" + gender + '\''+
                ", cidade='" + location.getCity() + '\''+
                ", estado='" + location.getState() + '\'' +
                ", email='" + email.getEmail() + '\'';

    }

}
