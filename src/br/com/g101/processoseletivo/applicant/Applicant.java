package br.com.g101.processoseletivo.applicant;

import java.util.*;

public class Applicant
{

    private CompleteName completeName;
    private Gender gender;
    private Location location;
    private String status;
    private Email email;

    public Applicant(){}

    public Applicant(CompleteName completeName, Gender gender, Location location, Email email)
    {
        this.completeName = completeName;
        this.gender = gender;
        this.location = location;
        this.email = email;
    }

    public String getCompleteName() {
        return completeName.getCompleteName();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return " Applicant{" +
                "completeName=" + completeName +
                ", gender=" + gender +
                ", location=" + location +
                ", status='" + status + '\'' +
                ", email=" + email.getEmail() +
                '}';
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
