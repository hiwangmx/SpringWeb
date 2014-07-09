package com.star.tag;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.star.utils.NumberUtils;

public class NumberTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(getClass());

	private String value;
	private String type;
	private int scale;

	@Override
	public int doStartTag() throws JspException {
		logger.info("Number tag start");
		StringBuffer sb = new StringBuffer();
		BigDecimal number = null;
		if (StringUtils.isBlank(value)) {
			number = BigDecimal.ZERO;
		} else {
			number = BigDecimal.valueOf(Double.valueOf(value));
		}
		sb.append(NumberUtils.formateNumber(number, type, scale));
		try {
			super.pageContext.getOut().print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

}
