package br.com.g101.processoseletivo.applicant;

public enum Gender
{
    MALE("Masculino"),
    FEMALE("Feminino"),
    OTHER("Outro");
    private final String name;

    private Gender(String name)
    {
        this.name = name;
    }
    @Override
    public String toString()
    {
        return name;
    }
}
