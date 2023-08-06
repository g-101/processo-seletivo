package br.com.g101.processoseletivo.applicant;

import java.util.Collection;


public interface IApplicantDAO {

    boolean checkIfEmailExists(String email);
    void createData(Integer id, Applicant applicant);
    Collection<Applicant> getAll();
    Applicant getById(Integer id);
    void update(Integer id, String status);
    void delete(Integer id);
}
