package lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**

 The lt.eif.viko.tadasviliusis._3uzdv_JAXRS_WebService package contains classes related to handling
 exceptions in the JAX-RS web service.
 <p>
 This package includes the {@link ComputerShopNotFoundAdvice} class, which serves as an advice class
 annotated with {@link ControllerAdvice}. It handles exceptions of type {@link ComputerShopNotFoundException}
 and provides a response with the HTTP status code {@link HttpStatus#NOT_FOUND} and the exception message.


 To handle the {@link ComputerShopNotFoundException} exception, the {@link ExceptionHandler} annotation is used
 along with the {@link ResponseBody} annotation to indicate that the return value of the method should be
 serialized directly into the response body. The {@link ResponseStatus} annotation is used to set the HTTP
 status code of the response to {@link HttpStatus#NOT_FOUND}.

 @see ComputerShopNotFoundAdvice
 @see ControllerAdvice
 @see ExceptionHandler
 @see ResponseBody
 @see ResponseStatus
 @see HttpStatus
 @see ComputerShopNotFoundException
 */

@ControllerAdvice
class ComputerShopNotFoundAdvice {


	@ResponseBody
	@ExceptionHandler(ComputerShopNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(ComputerShopNotFoundException ex) {
		return ex.getMessage();
	}
}
