package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;

import sun.security.validator.ValidatorException;
@FacesValidator("validators.codeValidators")

public class codeValidators { // validator pour des lettres en majuscule

	public void validate(FacesContext ctx, UIComponent cmpt, Object value) throws  ValidatorException {
		System.out.println("test");
		if(!value.toString().startsWith("P")) {
			System.out.println(value.toString());
			FacesMessage msg= new FacesMessage("Erreur de validation code","le code doit commencer par P");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			
			
		}
		
	}
}

//	System.out.println("test");
//	if (!value.toString().startsWith("P")) {
//		System.out.println(value.toString());
//		FacesMessage msg = new FacesMessage
//		("Erreur de validation code", "le code doit commencer par P");
//		msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
//		throw new ValidationException(msg);
//		}
//}
