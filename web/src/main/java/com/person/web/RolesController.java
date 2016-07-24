package com.person.web;

import com.person.service.Service;
import com.person.model.Roles;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class RolesController extends MultiActionController{
	private Service service;
	
	public void setService(Service service){
		this.service=service;
	}
	
	public ModelAndView viewRoles (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Roles> roleNames= service.getAllRoles();
        ModelAndView model = new ModelAndView("viewRoles");
        model.addObject("roles", roleNames);
        return model;
    }
	public ModelAndView test (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId= Integer.parseInt(request.getParameter("roleId"));
        List<Roles> roleNames= service.getAllRoles();
        ModelAndView model = new ModelAndView("test");
        model.addObject("roles", roleNames);
		model.addObject("id", roleId);
        return model;
    }
}