package com.star.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.star.tag.info.NumberTagInfo;

public class NumberTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(getClass());

	private NumberTagInfo numberInfo;
	private String value;

	@Override
	public int doStartTag() throws JspException {
		logger.info("Number tag start");
		StringBuffer sb = new StringBuffer();
		if (value == null) {
			sb.append("0");
		}else{
			sb.append(value);
		}
		try {
			super.pageContext.getOut().print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public NumberTagInfo getNumberInfo() {
		return numberInfo;
	}

	public void setNumberInfo(NumberTagInfo numberInfo) {
		this.numberInfo = numberInfo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
