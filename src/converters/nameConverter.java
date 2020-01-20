package converters;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converters.nameConverter")
public class nameConverter implements Converter{ // on implemente pour convertir 

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		// ici on convertit les object de type string, elle prend 3 parametres , le 3e etant ce que nous voulons convetir
		
		String valueConverted= value.toString().toUpperCase();
		System.out.println("test"+valueConverted);
		
		return valueConverted;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
