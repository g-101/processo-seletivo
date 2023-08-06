package br.com.g101.processoseletivo.exception;

public class ApplicantException {
    public static class ApplicantNotFound extends BaseException {

        public ApplicantNotFound(String errorMessage) {
            super(errorMessage);
        }

    }

    public static class ApplicantAlreadyRegistered extends BaseException {

        public ApplicantAlreadyRegistered(String errorMessage) {
            super(errorMessage);
        }
    }
}
