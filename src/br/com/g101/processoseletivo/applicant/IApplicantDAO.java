package br.com.g101.processoseletivo.applicant;

import java.util.Collection;

public interface IApplicantDAO {

    public Boolean register(Applicant applicant);
    public Collection<Applicant> getAll();
    public Applicant getById(Integer id);
    public void update(Integer id, String status);
    public void delete(Integer id);
}
