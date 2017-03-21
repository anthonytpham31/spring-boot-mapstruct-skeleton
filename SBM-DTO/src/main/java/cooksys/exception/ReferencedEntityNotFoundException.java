package cooksys.exception;

import java.io.Serializable;

public class ReferencedEntityNotFoundException extends RuntimeException{
	
	/**
	 * Generated this serial
	 */
	private static final long serialVersionUID = 8325686795111629224L;

	public ReferencedEntityNotFoundException(Class<?> entityClass, Serializable id) {
		super("Cannot find [" + entityClass.getSimpleName() + "] with ID of [" + id + "]");
	}
}
