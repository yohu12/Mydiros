package com.diros.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class TotalAction   {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	public TotalAction() {
		super();
	}
	/**
	 * 日志器
	 */
	protected static final Log logger = LogFactory.getLog(new TotalAction().getClass());   
	
	public static final String RESULT_CODE = "resultCode";
	
	public static final String RESULT_MSG = "resultMsg";
	
}
