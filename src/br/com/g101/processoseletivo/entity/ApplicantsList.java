package br.com.g101.processoseletivo.entity;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ApplicantsList {
    private Set<Applicant> applicants = new TreeSet<>();

    public ApplicantsList() {
    }

    public void insertApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public Set<Applicant> getApplicants() {
        return applicants;
    }

    // total de candidatos
    public int getTotalApplicants() {
        return applicants.size();
    }
}
