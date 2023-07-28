package br.com.g101.processoseletivo.entity;

import java.util.Objects;

public class Applicant implements Comparable<Applicant>
{
    private Long id;
    private CompleteName completeName;
    private Gender gender;
    private Location location;
    private Email email;


    public Applicant(){}

    public Applicant(CompleteName completeName, Gender gender, Location location, Email email)
    {
        this.completeName = completeName;
        this.gender = gender;
        this.location = location;
        this.email = email;
    }

    public Applicant(Long id, CompleteName completeName, Gender gender, Location location, Email email)
    {
        this(completeName, gender, location, email);
        this.id = id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return

                "\nnome='" + completeName + '\'' +
                ", gênero='" + gender + '\''+
                ", cidade='" + location.getCity() + '\''+
                ", estado='" + location.getState() + '\'' +
                ", email='" + email.getEmail() + '\'';

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

    @Override
    public int compareTo(Applicant applicant) {
        return this.email.getEmail().compareTo(applicant.email.getEmail());
    }
}
