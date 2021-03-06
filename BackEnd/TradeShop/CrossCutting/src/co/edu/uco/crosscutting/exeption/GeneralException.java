package co.edu.uco.crosscutting.exeption;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class GeneralException extends RuntimeException{
	
	private static final long serialVersionUID = 184494626304025991L;
	/**
	 * 
	 */
	private String userMessage;
	private String tecnicalMessage;
	private Exception rootExeption;
	
	protected GeneralException(String userMessage, String tecnicalMessage, Exception rootExeption) {
		super();
		setUserMessage(userMessage);
		setTecnicalMessage(tecnicalMessage);
		setRootExeption(rootExeption);
	}
	
	
	public static GeneralException build(String technicalMessage) {
		return new GeneralException(null, technicalMessage, null);
	}
	
	public static GeneralException build(String technicalMessage, Exception rootExeption) {
		return new GeneralException(null, technicalMessage,rootExeption);
	}
	
	
	public String getUserMessage() {
		return userMessage;
	}
	public String getTecnicalMessage() {
		return tecnicalMessage;
	}
	public Exception getRootExeption() {
		return rootExeption;
	}
	private void setUserMessage(String userMessage) {
		this.userMessage = UtilText.trim(userMessage);
	}
	private void setTecnicalMessage(String tecnicalMessage) {
		this.tecnicalMessage = UtilText.trim(tecnicalMessage);
	}
	private void setRootExeption(Exception rootExeption) {
		this.rootExeption = UtilObject.getUtilObject().getDefault(rootExeption, new Exception());
	}
}
