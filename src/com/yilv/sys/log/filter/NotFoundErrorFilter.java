package com.yilv.sys.log.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter()//或者还可以通过这样的方式配置filter，不需要在web.xml中，只能在web3.0中使用；具体使用方式，以及特性以后可以研究，暂时就不讨论，现在还是使用传统的方式
public class NotFoundErrorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		System.out.println("====================================发生了404异常");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
