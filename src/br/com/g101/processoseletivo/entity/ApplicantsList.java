package br.com.g101.processoseletivo.entity;

import java.util.ArrayList;
import java.util.List;

public class ApplicantsDB {
    private List<Applicant> applicants = new ArrayList();

    public void insertApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    // checar pelo nome
    // checar pelo id
    // listar candidatos
    // add
    // remover

}
