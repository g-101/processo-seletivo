package br.com.g101.processoseletivo.entity;

public class Applicant
{
    private long id;
    private CompleteName completeName;
    private Gender gender;
    private Location location;
    private String email;


    public Applicant(){}

    public Applicant(long id, CompleteName completeName, Gender gender, Location location)
    {
        this.id = id;
        this.completeName = completeName;
        this.gender = gender;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }




    @Override
    public String toString()
    {
        return
                "\nid='" + id + '\'' +
                ", nome='" + completeName.toString() + '\'' +
                ", gênero='" + gender + '\''+
                ", cidade='" + location.getCity() + '\''+
                ", estado='" + location.getState() + '\'';

    }

}
