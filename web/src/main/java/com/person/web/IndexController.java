package com.person.web;

import com.person.service.*;
import com.person.model.Roles;
import com.person.dto.*;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class IndexController extends MultiActionController{
	public ModelAndView startUp (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("startup");
		String message = "Hello World!";
		model.addObject("message", message);
        return model;
    }
}