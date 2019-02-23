package pl.jaceksysiak.designpatterns.demo1.controller;

import java.sql.SQLException;

import pl.jaceksysiak.designpatterns.demo1.model.Model;
import pl.jaceksysiak.designpatterns.demo1.model.Person;
import pl.jaceksysiak.designpatterns.demo1.model.PersonDAO;
import pl.jaceksysiak.designpatterns.demo1.view.LoginFormEvent;
import pl.jaceksysiak.designpatterns.demo1.view.LoginListener;
import pl.jaceksysiak.designpatterns.demo1.view.View;

public class Controller implements LoginListener {
	private View view;
	private Model model;
	
	private PersonDAO personDAO = new PersonDAO();
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void loginPerformed(LoginFormEvent event) {
		
		System.out.println("Login event received." + " Name: " +event.getName() + " passwrrd: " + event.getPassword());
		System.out.println("Jestem w: controller.loginPerformed() - implementacja metody interfejsu LoginListener ");
		
		try {
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}
