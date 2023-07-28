import br.com.g101.processoseletivo.entity.*;
import br.com.g101.processoseletivo.service.IdUtils;
import br.com.g101.processoseletivo.service.StringUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicantsList applicantsList = new ApplicantsList();
        boolean running = true;

        while (running)
        {
            showMenu();
            String choice = scanner.nextLine();



            switch (choice)
            {

                case "1":

                    String applicantName;
                    String applicantLastName;
                    String city;
                    String state;
                    String emailAddress;
                    System.out.println("Digite as informações do candidato");


                    try
                    {
                        System.out.print("Nome: ");
                        applicantName = scanner.nextLine();
                        StringUtils.isWordValid(applicantName);
                        applicantName = StringUtils.capitalize(applicantName);

                        System.out.print("Sobrenome: ");
                        applicantLastName = scanner.nextLine();
                        StringUtils.isWordValid(applicantLastName);
                        applicantLastName = StringUtils.capitalize(applicantLastName);
                        CompleteName completeName= new CompleteName(applicantName, applicantLastName);
                        System.out.println(completeName);

                        System.out.print("Cidade: ");
                        city = scanner.nextLine();
                        StringUtils.isWordValid(city);
                        city = StringUtils.capitalize(city);
                        System.out.print("Estado: ");
                        state = scanner.nextLine();
                        StringUtils.isWordValid(state);
                        Location location = new Location(city, state.toUpperCase());

                        System.out.print("Email: ");
                        emailAddress = scanner.nextLine();
                        Email email = new Email(emailAddress);


                        Applicant applicant = new Applicant(completeName,
                                Gender.OTHER, location, email);
                        System.out.println(applicant);

                        applicantsList.insertApplicant(applicant);
                        applicant.setId(IdUtils.nextId());
                        System.out.println(applicantsList.getApplicants());
                        System.out.println(applicantsList.getTotalApplicants());
                        System.out.println();



                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.printf("Erro: %s%n ", e.getMessage());

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
        scanner.close();
    }


    private static void showMenu()
    {

        System.out.println("==== Sistema de RH - Processo seletivo ====");

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
}