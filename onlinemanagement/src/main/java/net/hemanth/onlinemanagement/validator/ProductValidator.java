package net.hemanth.onlinemanagement.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.hemanth.onlinemanagement.dto.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// for custom business validation
		Product product = (Product) target;
		if(product.getName().length()>=10) {
			errors.rejectValue("name", null, "product.name.max.length.invalid");
			return;
		}
	}

}