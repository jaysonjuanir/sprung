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
import org.springframework.web.servlet.view.RedirectView;

public class PersonController extends MultiActionController{
	private Service service;
	
	public void setService(Service service){
		this.service=service;
	}
	
	public ModelAndView listPeople (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("index");
		String sort = request.getParameter("sort");
		if(sort==null)
			sort="";
		
		try{
			List<PersonDto> personDtos = new ArrayList<>();
			
			if(sort.equals("byDateHired")){
				personDtos = service.getPersonByDateHired();
			}
			else if(sort.equals("byLastName")){
				personDtos = service.getPersonByLastName();
			}
			else if(sort.equals("byGWA")){
				personDtos = service.getPersonByGWA();
			}
			else{
				personDtos = service.getPeople();	
			}
			personDtos.forEach(System.out::print);
			model.addObject("persons", personDtos);
		}catch(Exception ex){ex.printStackTrace();}
		
        return model;
    }
	public ModelAndView delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("index");
		String id = request.getParameter("id");
		PersonDto person = service.getPersonById(Integer.parseInt(id));
		List message = new ArrayList();
		message.add("Person Deleted Succesfully" + "\nID: " + id + "\t"+person.getName());
		service.deletePerson(person);
		model.addObject("message",message);
		List<PersonDto> personDtos = new ArrayList<>();
		personDtos = service.getPeople();	
		model.addObject("persons", personDtos);
		return model;
    }
   
}