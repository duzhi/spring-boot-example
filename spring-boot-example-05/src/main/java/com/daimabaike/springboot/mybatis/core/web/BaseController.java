package com.daimabaike.springboot.mybatis.core.web;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.daimabaike.springboot.mybatis.core.entity.BaseEntity;
import com.daimabaike.springboot.mybatis.core.entity.Result;

public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected Validator validator;

	public <T extends BaseEntity<?>> Result<T> validate(T t, Class<?>... groups) throws ConstraintViolationException {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(t, groups);
		if (!constraintViolations.isEmpty()) {
			String message = "";
			for (Iterator<ConstraintViolation<Object>> a = constraintViolations.iterator(); a.hasNext();) {

				message += a.next().getMessage();
			}

			return Result.fail(message);
		}

		if (!t.validate()) {
			return Result.fail(t.getVerifymessage());
		}
		return null;
	}

	
	
}
