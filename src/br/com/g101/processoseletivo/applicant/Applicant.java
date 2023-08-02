package br.com.g101.processoseletivo.applicant;

import java.util.Objects;

public class Applicant
{
    private Integer id;
    private CompleteName completeName;
    private Gender gender;
    private Location location;
    private Email email;
    private String status;


    public Applicant(){}

    public Applicant(CompleteName completeName, Gender gender, Location location, Email email)
    {
        this.completeName = completeName;
        this.gender = gender;
        this.location = location;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email.getEmail();
    }



    @Override
    public String toString()
    {
        return
                "id='" + id + '\'' +
                ", nome='" + completeName + '\'' +
                ", gênero='" + gender + '\''+
                ", cidade='" + location.getCity() + '\''+
                ", estado='" + location.getState() + '\'' +
                ", email='" + email.getEmail() + '\'' +
                ", status='" + status + '\'';

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email.getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(email.getEmail(), applicant.email);

    }


}
