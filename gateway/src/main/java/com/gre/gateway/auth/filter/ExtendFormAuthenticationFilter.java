package com.gre.gateway.auth.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gre.api.result.Result;
import com.gre.api.utils.UtilResult;

public class ExtendFormAuthenticationFilter extends FormAuthenticationFilter{
	private static final Logger log=LoggerFactory.getLogger(ExtendFormAuthenticationFilter.class);
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		if(this.isLoginRequest(request, response)) {
            if(this.isLoginSubmission(request, response)) {
                if(log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if(log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }

                return true;
            }
        } else {
            if(log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }

//            this.saveRequestAndRedirectToLogin(request, response);
            PrintWriter out=response.getWriter();
            Result result= UtilResult.error("please login");
            result.setResult_code("401");
            ObjectMapper mapper=new ObjectMapper();
            out.println(mapper.writeValueAsString(result));
            out.flush();
            out.close();
            return false;
        }
	}
	
}
