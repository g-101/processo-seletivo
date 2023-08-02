package br.com.g101.processoseletivo.applicant;

import br.com.g101.processoseletivo.service.IdUtils;

import java.util.*;

public class ApplicantMapDAO implements IApplicantDAO{
    private Map<String, Applicant> applicantsByEmail;
    private Map<Integer, Applicant> applicantsById;



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

    @Override
    public Applicant getById(Integer id) {
        return this.applicantsById.get(id);

    }

    @Override
    public void update(Integer id, String status) {
        Applicant applicant = this.applicantsById.get(id);
        applicant.setStatus(status);


    }

    @Override
    public void delete(Integer id) {
        applicantsById.remove(id);
    }
}
