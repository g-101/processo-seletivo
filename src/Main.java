import br.com.g101.processoseletivo.applicant.*;
import br.com.g101.processoseletivo.service.StringUtils;

import java.util.Scanner;

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
                        startProcess(applicant);

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

                case "0":
                    running = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                  System.out.println("Opção inválida. Tente novamente.");
                  break;
            }
            System.out.println(iApplicantDAO.getAll());
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

        Boolean isRegistered = iApplicantDAO.register(applicant);
        if (!isRegistered)
        {
            throw new IllegalArgumentException("Candidato ja participa do processo.");

        }
        iApplicantDAO.update(applicant.getId(), "Recebido");
        System.out.println("Cadastro realizado com sucesso.");

    }

    private static void scheduleInterview(Integer id) {
        Applicant applicant = iApplicantDAO.getById(id);
        if (applicant == null || !applicant.getStatus().equals("Recebido")) {
            throw new IllegalArgumentException("Candidato não encontrado.");
        }
        iApplicantDAO.update(applicant.getId(), "Qualificado");
        System.out.println("Entrevista marcada para o candidato.");
    }

    private static void disqualifyApplicant(Integer id) {
        Applicant applicant = iApplicantDAO.getById(id);
        if (applicant == null) {
            throw new IllegalArgumentException("Candidato não encontrado.");
        }
        iApplicantDAO.delete(applicant.getId());
        System.out.println("Candidato desqualificado com sucesso.");
    }

}