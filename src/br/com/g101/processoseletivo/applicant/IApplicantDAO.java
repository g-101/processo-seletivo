package br.com.g101.processoseletivo.applicant;

import java.util.Collection;

public interface IApplicantDAO {

    public Boolean register(Applicant applicant);
    public Collection<Applicant> getAll();
//    public Applicant getById(Long id);
//    public void update(Applicant applicant);
//    public void delete(Long id);
}
