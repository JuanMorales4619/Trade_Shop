package co.edu.uco.tradeShop.crosscutting.exception;

import co.edu.uco.crosscutting.exeption.GeneralException;
import co.edu.uco.tradeShop.crosscutting.exception.enumeration.ExceptionLocation;
import co.edu.uco.tradeShop.crosscutting.exception.enumeration.ExceptionType;
import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;

public class TradeShopException extends GeneralException{

	private static final long serialVersionUID = 6894466519536139891L;
	private ExceptionType type;
	private ExceptionLocation location;
	
	
	private TradeShopException(String userMessage, String tecnicalMessage, Exception rootExeption, ExceptionType type,
			ExceptionLocation location) {
		super(userMessage, tecnicalMessage, rootExeption);
		setType(type);
		setLocation(location);
	}
	
	public static TradeShopException build(String userMessage, String technicalMessage) {
		return new TradeShopException(userMessage, technicalMessage, null, null, null);
	}
	
	public static TradeShopException build(String userMessage, String tecnicalMessage, Exception rootExeption) {
		return new TradeShopException(userMessage, tecnicalMessage,rootExeption, null, null);
	}
	
	public static TradeShopException build(String userMessage) {
		return new TradeShopException(userMessage, userMessage, null, ExceptionType.BUSINESS, null);
	}
	
	public static TradeShopException buildTechnicalExeption(String tecnicalMessage) {
		return new TradeShopException(null, tecnicalMessage, null, ExceptionType.TECHNICAL, null);
	}
	 
	public static TradeShopException buildTechnicalExeption(String tecnicalMessage, Exception rootException, ExceptionType type, ExceptionLocation location) {
		return new TradeShopException(null, tecnicalMessage, rootException, ExceptionType.TECHNICAL , location);
	}
	
	public static TradeShopException buildTechnicalDataExeption(String tecnicalMessage) {
		return new TradeShopException(null, tecnicalMessage, null, ExceptionType.TECHNICAL , ExceptionLocation.DATA);
	}
	
	public static TradeShopException buildTechnicalBusinessLogicExeption(String tecnicalMessage) {
		return new TradeShopException(null, tecnicalMessage, null, ExceptionType.TECHNICAL , ExceptionLocation.BUSINESS_LOGIC);
	}
	
	public static TradeShopException buildBusinessLogicExeption(String businessMessage) {
		return new TradeShopException(businessMessage, null, null, ExceptionType.BUSINESS , ExceptionLocation.BUSINESS_LOGIC);
	}
	
	public static TradeShopException buildTechnicalDataExeption(String tecnicalMessage, Exception rootException) {
		return new TradeShopException(null, tecnicalMessage, rootException, ExceptionType.TECHNICAL , ExceptionLocation.DATA);
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ExceptionType getType() {
		return type;
	}
	public ExceptionLocation getLocation() {
		return location;
	}
	
	private void setType(ExceptionType type) {
		this.type = getUtilObject().getDefault(type, ExceptionType.GENERAL);
	}
	private void setLocation(ExceptionLocation location) {
		this.location = getUtilObject().getDefault(location, ExceptionLocation.GENERAL);
	}
	
}
