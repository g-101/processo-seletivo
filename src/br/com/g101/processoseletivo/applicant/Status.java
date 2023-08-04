package br.com.g101.processoseletivo.applicant;

public enum Status {
    RECEIVED("Recebido"),
    QUALIFIED("Qualificado"),
    APPROVED("Aprovado");
    private final String statusName;

    private Status(String statusName)
    {
        this.statusName = statusName;
    }
    @Override
    public String toString()
    {
        return statusName;
    }
}
