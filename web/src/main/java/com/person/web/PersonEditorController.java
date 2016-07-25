package com.person.web;

import com.person.service.*;
import com.person.model.Roles;
import com.person.dto.*;
import com.person.model.*;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PersonEditorController extends MultiActionController{
	private Service service;
	
	public void setService(Service service){
		this.service=service;
	}
	
	public ModelAndView loadEditor (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("person");
		
		String id = request.getParameter("id");
		if(id==null){
			id="";
		}
		else{
			PersonDto person = service.getPersonById(Integer.parseInt(id));
			model.addObject("person", person);
			model.addObject("personId", id);
			System.out.println(person.getBirthday());
			model.addObject("bday", person.getBirthday());
			
			person.getPerson_contact().stream().forEach(c->{
				model.addObject(c.getContact_type().toString()+"Checked", true);
				model.addObject(c.getContact_type().toString()+"Value", c.getContact_value());
				model.addObject(c.getContact_type().toString()+"Id", c.getId());
			});
			
			person.getRoles().stream().forEach(r->{
				model.addObject(r.getRole_type()+"Type", r.getRole_type());
			});
		}
		
		List roles = new ArrayList();
		roles.add("dev");
		roles.add("qa");
		roles.add("ba");
		
		model.addObject("roles", roles);
		
		List contactList = new ArrayList();
		contactList.add("email");
		contactList.add("mobile");
		contactList.add("landline");
		
		
		model.addObject("contactList", contactList);
        return model;
    }
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return loadEditor(request,response);
	}
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return loadEditor(request,response);
	}
	public ModelAndView success(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return save(request,response);
	}
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView model = new ModelAndView("person");	
		try{
			System.out.println("POST METHOD!");
			String personId = request.getParameter("personId");
			String firstName = request.getParameter("firstName");
			String middleName = request.getParameter("middleName");
			String lastName = request.getParameter("lastName");
			String suffix = request.getParameter("suffix");
			String title = request.getParameter("title");
			String gender = request.getParameter("gender");
			String birthday = request.getParameter("birthday");
			String employed = request.getParameter("employed");
			String dateHired = request.getParameter("dateHired");
			String gwa = request.getParameter("gwa");
			String [] roles = request.getParameterValues("role");
			
			String streetNumber = request.getParameter("streetNumber");
			String barangay = request.getParameter("barangay");
			String city = request.getParameter("city");
			String zipcode = request.getParameter("zipcode");
			
			String [] contactType = request.getParameterValues("contacts");
			String emailValue = request.getParameter("email");
			String mobileValue = request.getParameter("mobile");
			String landlineValue = request.getParameter("landline");
			String emailId = request.getParameter("emailId");
			String mobileId = request.getParameter("mobileId");
			String landlineId = request.getParameter("landlineId");
			
			// for(String s:contactType){
				// System.out.println(s);
			// }
			System.out.println(emailId.isEmpty()?"empty":"not empty");
			System.out.println(mobileId);
			System.out.println(landlineId);
			personId=personId.isEmpty()?"0":personId;
			emailId=emailId.isEmpty()?"0":emailId;
			mobileId=mobileId.isEmpty()?"0":mobileId;
			landlineId=landlineId.isEmpty()?"0":landlineId;
			// NameDto names = new NameDto(firstName, middleName, lastName, suffix, title);
			// AddressDto address = new AddressDto(streetNumber, barangay, city, zipcode);
			// System.out.println(names);
			// System.out.println(address);
			
			PersonDto person = service.createPerson(personId, firstName, middleName, lastName, suffix, title, gender, birthday, employed, dateHired, gwa,roles, streetNumber, barangay, city, zipcode, contactType, emailValue, mobileValue, landlineValue, emailId, mobileId, landlineId);
			
			boolean indicatorFields = service.checkRequired(firstName, middleName, lastName, streetNumber, barangay,city,zipcode);
			boolean indicatorDate = service.checkDate(birthday);
			boolean indicatorDecimal = service.checkDecimal(gwa);
			boolean indicatorEmployed =true;
			if(employed.equals("yes")){
				indicatorEmployed = service.checkEmployed(dateHired, roles);
			}
			System.out.println(gender);
			if(gender.equals("male")){
				person.setGender(Gender.MALE);
			}
			else{
				person.setGender(Gender.FEMALE);
			}
			
			System.out.println("fields "+indicatorFields +" date "+ indicatorDate +" decimal "+ !indicatorDecimal +" employed "+ indicatorEmployed);
			System.out.println("PERSON OUTPUT!!!!:" + person);
			//person.getPerson_contact().forEach(System.out::println);
			if(indicatorFields && indicatorDate && !indicatorDecimal && indicatorEmployed){
				model = new ModelAndView("redirect:/ListPeople?");
				List message = new ArrayList();
				
				System.out.println("ETO ANG LAMAN NG TAO");
				System.out.println(person);
				//person.getPerson_contact().forEach(System.out::println);
				System.out.println();
				person.getRoles().forEach(System.out::println);
				
				
				if(personId.isEmpty() || personId.equals("0")){
					service.executeCreatePerson(person);
					System.out.println(person.getPerson_contact());
					message.add("Person Created Successfully\nName: " + person.getName());
				}
				else{	
					//PersonDto existingPerson = new Service().getPersonById(Integer.parseInt(personId));
					System.out.println(person.getPerson_contact());
					//person.setPerson_contact(existingPerson.getPerson_contact());
					service.executeUpdatedPerson(person);
					message.add("Person Modified Successfully\nName: " + person.getName());
				}
				model.addObject("message", message);
				
				List<PersonDto> personDtos = service.getPeople();	
				model.addObject("persons", personDtos);
				
			}else{
				//error
				
				List<String> errors = new ArrayList<>();
				if(!indicatorFields){
					errors.add("Missing required fields");
				}
				if(!indicatorDate){
					errors.add("Invalid date format");
				}
				if(indicatorDecimal){
					errors.add("Invalid gwa");
				}
				if(!indicatorEmployed){
					errors.add("Missing fields on employed/invalid format");
				}
			
				model.addObject("errors",errors);
				model.addObject("person",person);
				
				List rolesType = new ArrayList();
				rolesType.add("dev");
				rolesType.add("qa");
				rolesType.add("ba");
				
				model.addObject("roles", rolesType);
				
				List contactList = new ArrayList();
				contactList.add("email");
				contactList.add("mobile");
				contactList.add("landline");
				
				
				if(person.getPerson_contact()!=null){
					/*person.getPerson_contact().stream().forEach(c->{
						model.addObject(c.getContact_type().toString()+"Checked", true);
						model.addObject(c.getContact_type().toString()+"Value", c.getContact_value());
						model.addObject(c.getContact_type().toString()+"Id", c.getId());
					});*/
					for(ContactDto c : person.getPerson_contact()){
						model.addObject(c.getContact_type().toString()+"Checked", true);
						model.addObject(c.getContact_type().toString()+"Value", c.getContact_value());
						model.addObject(c.getContact_type().toString()+"Id", c.getId());
					}
				}
				
				if(person.getRoles()!=null){
					/*person.getRoles().stream().forEach(r->{
						model.addObject(r.getRole_type()+"Type", r.getRole_type());
					});*/
					for(RolesDto r : person.getRoles()){
						model.addObject(r.getRole_type()+"Type", r.getRole_type());
					}
				}
					
				model.addObject("contactList", contactList);
				//System.out.println("PERSON OUTPUT!!!!:" + person);
				//System.out.println("NULL PERSON OUTPUT" + new PersonDto());
			}
			System.out.println(personId);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return model;
	}
}