import br.com.g101.processoseletivo.entities.Applicant;
import br.com.g101.processoseletivo.services.UniqueId;

public class Main {
    public static void main(String[] args) {

        Applicant applicant1 = new Applicant
                ("João Silva", "Masculino", "Olinda", "josilva@mail.com");

        applicant1.setId(UniqueId.nextId());

        Applicant applicant2 = new Applicant
                ("Maria José", "Feminino", "João Pessoa", "mary@mail.com");
        applicant2.setId(UniqueId.nextId());


        System.out.println(applicant1.toString());
        System.out.print(applicant2.toString());
    }
}