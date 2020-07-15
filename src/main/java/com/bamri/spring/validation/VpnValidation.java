package com.bamri.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VpnValidation implements ConstraintValidator<Vpn, Integer>{

	@Override
	public boolean isValid(Integer event, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return event > 10 && event < 100;
	}

}
