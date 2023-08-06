package br.com.g101.processoseletivo.applicant;


import java.util.*;

public class ApplicantMapDAO implements IApplicantDAO {
    private Map<Integer, Applicant > applicantsMap;


    public ApplicantMapDAO() {
        this.applicantsMap = new TreeMap<>();

    }

    @Override
    public boolean checkIfEmailExists(String email) {
        boolean isExists = false;
        if (!applicantsMap.isEmpty()) {
            for (Integer key : applicantsMap.keySet()) {
//                System.out.println("Chave: " + key + ", Valor: " + applicantsMap.get(key));
                if (applicantsMap.get(key).getEmail().equals(email)) {
                    isExists = true;
                    break;
                }
            }
        }
        return isExists;
    }

    @Override
    public void createData(Integer id, Applicant applicant) {
        applicantsMap.put(id, applicant);
    }

    @Override
    public Collection<Applicant> getAll() {

        return applicantsMap.values();
    }



    @Override
    public Applicant getById(Integer id) {

       return applicantsMap.get(id);

    }

    @Override
    public void update(Integer id, String status) {
        for (Integer key : applicantsMap.keySet()) {
            if (Objects.equals(key, id)) {
                applicantsMap.get(key).setStatus(status);
                break;

            }
        }
    }

    @Override
    public void delete(Integer id) {
        applicantsMap.remove(id);


    }

    @Override
    public String toString() {
        return "ApplicantMapDAO{ " + applicantsMap + " }";
    }
}





