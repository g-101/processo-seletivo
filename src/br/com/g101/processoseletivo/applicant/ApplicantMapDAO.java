package br.com.g101.processoseletivo.applicant;

import br.com.g101.processoseletivo.service.IdUtils;

import java.util.*;

public class ApplicantMapDAO implements  IApplicantDAO{
    private Map<String, Applicant> applicantsByEmail;
    private Map<Long, Applicant> applicantsById;



    public ApplicantMapDAO() {

        this.applicantsByEmail =  new TreeMap<>();
        this.applicantsById =  new TreeMap<>();
    }


    @Override
    public Boolean register(Applicant applicant) {
        if (this.applicantsByEmail.containsKey(applicant.getEmail())) {
            return false;
        }
        this.applicantsByEmail.put(applicant.getEmail(), applicant);
        applicant.setId(IdUtils.nextId());
        this.applicantsById.put(applicant.getId(), applicant);
        return true;
    }

    @Override
    public Collection<Applicant> getAll() {
        return this.applicantsById.values();
    }
}
