package com.yilv.common.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

public class BaseController {
	@Autowired
	protected Validator validator;

	//注意两个名字可以不一样
	@Value("${travelPath}")
	protected String adminPath;
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 数据完整性校验
	 * 
	 * @param model
	 * @param object
	 */
	protected void validate(Model model, Object object) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
		if (constraintViolations.size() != 0) {
			List<String> list = new ArrayList<String>();
			for (ConstraintViolation<Object> violation : constraintViolations) {
				list.add(violation.getMessage());
			}
			constraintViolations = null;
			model.addAttribute("validate", list);
		} else {
			constraintViolations = null;
		}
	}

	/**
	 * 添加Model消息
	 * 
	 * @param message
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message).append(messages.length > 1 ? "<br/>" : "");
		}
		model.addAttribute("message", sb.toString());
	}
}
