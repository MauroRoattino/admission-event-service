package ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.exception;

import org.springframework.http.HttpStatus;

/**
 * Base Service Exception
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 8013209203044555406L;
    private final HttpStatus code;
    private String component;

    /**
     * Creates a new instance of {@link ServiceException}
     *
     * @param message the exception message
     */
    public ServiceException(final String message) {
        super(message);
        code = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Creates a new instance of {@link ServiceException}
     *
     * @param message the exception message
     * @param cause   the exception cause
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
        code = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Creates a new instance of {@link ServiceException}
     *
     * @param message the exception message
     * @param code    the {@link HttpStatus} used that will be used in the REST response
     */
    public ServiceException(final String message, final HttpStatus code) {
        super(message);
        this.code = code;
    }

    /**
     * Creates a new instance of {@link ServiceException}
     *
     * @param message the exception message
     * @param cause   the exception cause
     * @param code    the {@link HttpStatus} used that will be used in the REST response
     */
    public ServiceException(final String message, final Throwable cause, final HttpStatus code) {
        super(message, cause);
        this.code = code;
    }

    /**
     * Creates a new instance of {@link ServiceException}
     *
     * @param message       the exception message
     * @param code          the exception cause
     * @param component     the exception origin component
     */
    public ServiceException(final String message, final HttpStatus code, final String component) {
        super(message);
        this.code = code;
        this.component = component;
    }

    /**
     * Creates a new instance of {@link ServiceException}
     *
     * @param message the exception message
     * @param cause   the exception cause
     * @param code    the {@link HttpStatus} used that will be used in the REST response
     */
    public ServiceException(final String message, final Throwable cause, final HttpStatus code, final String component) {
        super(message, cause);
        this.code = code;
        this.component = component;
    }


    /**
     * Retrieves the {@link HttpStatus} associated to the exception
     *
     * @return the {@link HttpStatus}
     */
    public HttpStatus getCode() {
        return code;
    }

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "ServiceException [code=" + code + ", component=" + component + "]";
	}
    
}
