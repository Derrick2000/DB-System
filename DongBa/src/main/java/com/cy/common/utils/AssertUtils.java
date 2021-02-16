package com.cy.common.utils;

import com.cy.common.exception.ServiceException;

public class AssertUtils {

	  public static void isArgValid(boolean statement,String msg) {
		  if(statement)
			  throw new IllegalArgumentException(msg);
	  }
	  
	  public static void isServiceValid(boolean statement,String msg) {
		  if(statement)
			  throw new ServiceException(msg);
	  }
}