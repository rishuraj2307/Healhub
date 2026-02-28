package jsp.hospitalmanagement.exception;

import org.springframework.stereotype.Repository;

@Repository
public class PatientAlreadyHasAppointmentException extends RuntimeException{
    public PatientAlreadyHasAppointmentException(String message) {
        super(message);
    }
    public PatientAlreadyHasAppointmentException() {
        super();
    }

}
