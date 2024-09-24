package exception;
import java.util.*;

import model.*;

public class EcommerceException extends RuntimeException{
	ErrorCode errorCode;
	String errorMessage;
	
	public EcommerceException(ErrorCode errorcode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorcode;
		this.errorMessage = errorMessage;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
