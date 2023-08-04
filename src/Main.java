import br.com.g101.processoseletivo.applicant.*;
import br.com.g101.processoseletivo.service.IdUtils;
import br.com.g101.processoseletivo.service.StringUtils;

import java.util.*;

public class Main {
    private static IApplicantDAO iApplicantDAO;
    public static void main(String[] args) {

        iApplicantDAO = new ApplicantMapDAO();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            showMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":

                    String applicantName;
                    String applicantLastName;
                    String city;
                    String state;
                    String emailAddress;
                    System.out.println("Digite as informações do candidato");
                    try {
                        System.out.print("Nome: ");
                        applicantName = sc.nextLine();
                        StringUtils.isWordValid(applicantName);
                        applicantName = StringUtils.capitalize(applicantName);
                        System.out.print("Sobrenome: ");
                        applicantLastName = sc.nextLine();
                        StringUtils.isWordValid(applicantLastName);
                        applicantLastName = StringUtils.capitalize(applicantLastName);
                        CompleteName completeName = new CompleteName(applicantName, applicantLastName);

                        System.out.print("Cidade: ");
                        city = sc.nextLine();
                        StringUtils.isWordValid(city);
                        city = StringUtils.capitalize(city);
                        System.out.print("Estado: ");
                        state = sc.nextLine();
                        StringUtils.isWordValid(state);
                        Location location = new Location(city, state.toUpperCase());

                        System.out.print("Email: ");
                        emailAddress = sc.nextLine();
                        Email email = new Email(emailAddress);

                        Applicant applicant = new Applicant(completeName,
                                Gender.OTHER, location, email);

//                        System.out.println(applicantData.get(1));
                        startProcess(applicant);
//                        System.out.println(applicant);
                    } catch (IllegalArgumentException e) {
                        System.out.print("Erro: " + e.getMessage());

                    }
                    break;

                case "2":
                    System.out.println(" === Marcar Entrevista ===");
                    try {
                        System.out.print("Id do candidato: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        scheduleInterview(id);

                    } catch (IllegalArgumentException e) {
                        System.out.print("Erro: " + e.getMessage());

                    }
                    break;
                case "3":
                    System.out.println(" === Desqualificar Candidato ===");
                    try {
                        System.out.print("Id do candidato: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        disqualifyApplicant(id);


                    } catch (IllegalArgumentException e) {
                        System.out.print("Erro: " + e.getMessage());

                    }
                    break;
                case "4":
                    System.out.println(" === Verificar status do candidato ===");
                    try {
                        System.out.print("Id do candidato: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        String status = checkApplicantStatus(id);
                        System.out.println("Status do candidato: " + status);


                    } catch (IllegalArgumentException e) {
                        System.out.print("Erro: " + e.getMessage());

                    }
                    break;
                case "5":
                    System.out.println(" === Aprovar candidato ===");
                    try {
                        System.out.print("Id do candidato: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        approveApplicant(id);


                    } catch (IllegalArgumentException e) {
                        System.out.print("Erro: " + e.getMessage());

                    }
                    break;
                case "6":
                    System.out.println(" ===  Listar candidatos aprovados ===");
                    try {

                        getAllSuccessfulApplicants();


                    } catch (IllegalArgumentException e) {
                        System.out.print("Erro: " + e.getMessage());

                    }
                    break;
                case "0":
                    running = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                  System.out.println("Opção inválida. Tente novamente.");
                  break;
            }

        }
        sc.close();

    }


    private static void showMenu()
    {
        System.out.println();

        System.out.println("=== Sistema de RH - Processo seletivo ===");

        System.out.println("Selecione uma opção:");

        System.out.println("1. Registrar candidato");

        System.out.println("2. Marcar entrevista para candidato");

        System.out.println("3. Desqualificar candidato");

        System.out.println("4.Verificar status do candidato");

        System.out.println("5. Aprovar candidato");

        System.out.println("6. Listar candidatos aprovados");

        System.out.println("0. Sair do sistema");

        System.out.print("Opção: ");
    }

    private static void startProcess(Applicant applicant) {
        boolean isRegisteredEmail = iApplicantDAO.checkIfEmailExists(applicant.getEmail());
        if (isRegisteredEmail)
        {
            throw new IllegalArgumentException("Candidato ja participa do processo.");

        }

        applicant.setStatus(Status.RECEIVED.toString());
        Integer id = IdUtils.nextId();
        iApplicantDAO.createData(id, applicant);

        System.out.println("Cadastro realizado com sucesso.");
        System.out.println(iApplicantDAO);




    }

    private static void scheduleInterview(Integer id) {
        Applicant applicant = iApplicantDAO.getById(id);
        if (applicant == null || !applicant.getStatus().equals(Status.RECEIVED.toString())) {
            throw new IllegalArgumentException("Candidato não encontrado.");
        }
        iApplicantDAO.update(id, "Qualificado");
        System.out.println("Entrevista marcada para o candidato.");
    }

    private static void disqualifyApplicant(Integer id) {
        Applicant applicant = iApplicantDAO.getById(id);
        if (applicant == null) {
            throw new IllegalArgumentException("Candidato não encontrado.");
        }
        iApplicantDAO.delete(id);
        System.out.println("Candidato desqualificado com sucesso.");

    }

    private static String checkApplicantStatus(Integer id) {
        Applicant applicant = iApplicantDAO.getById(id);
        if (applicant == null) {
            throw new IllegalArgumentException("Candidato não encontrado.");
        }
        return applicant.getStatus();

    }

    private static void approveApplicant(Integer id) {
        Applicant applicant = iApplicantDAO.getById(id);
        if (applicant == null || !applicant.getStatus().equals(Status.QUALIFIED.toString())) {
            throw new IllegalArgumentException("Candidato não encontrado.");
        }
        iApplicantDAO.update(id, "Aprovado");
        System.out.println("Candidato aprovado com sucesso.");
    }

    private static void getAllSuccessfulApplicants() {
       Collection<Applicant> allApplicants = iApplicantDAO.getAll();
       int count = 0;
        if (allApplicants.isEmpty() ) {
            throw new IllegalArgumentException("Não há candidatos aprovados.");
        }

        for ( Applicant a : allApplicants) {
            if (a.getStatus().equals(Status.APPROVED.toString())) {
                System.out.println(a.getCompleteName());
            }
            else {
                count++;
            }
        }

        if(count > 0) {
            throw new IllegalArgumentException("Não há candidatos aprovados.");
        }


    }

}