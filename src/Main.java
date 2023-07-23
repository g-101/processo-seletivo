import entities.applicant.Applicant;

public class Main {
    public static void main(String[] args) {
        Applicant applicant1 = new Applicant
                ("João Silva", "Feminino", "Olinda", "angel@mail.com");
        System.out.print(applicant1.toString());
    }
}