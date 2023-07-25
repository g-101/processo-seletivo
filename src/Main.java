import br.com.g101.processoseletivo.entity.CompleteName;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running)
        {

            showMenu();
            String choice = scanner.nextLine();

            switch (choice)
            {

                case "1":

                    System.out.println("Digite o nome do candidato:");
                    String applicantName = scanner.nextLine();
                    System.out.println("Digite o sobrenome do candidato:");
                    String applicantLastName = scanner.nextLine();
                    CompleteName completeName = new CompleteName();
                    System.out.println();

                    try
                    {
                        completeName.isValidCompleteName(applicantName, applicantLastName);
                        System.out.println("Nome cadastrado com sucesso");

                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.printf("Erro: %s%n", e.getMessage());

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