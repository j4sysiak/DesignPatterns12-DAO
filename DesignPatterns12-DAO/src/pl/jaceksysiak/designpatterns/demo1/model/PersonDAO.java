package pl.jaceksysiak.designpatterns.demo1.model;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 One DAO class person table
 CRUD - Create, retrive, update, delete
 * */
public class PersonDAO {

	
	public void addPerson (Person person) throws SQLException {
		
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = conn.prepareStatement("INSERT into people (name, password) values (?, ?)");
		
		p.setString(1, person.getName());
		p.setString(2, person.getPassword());
		
		p.executeUpdate();
		p.close();
		
	}
	
	
	public Person getPerson (int id) {
		
		return null;
	}
	
	public List<Person> getPerson () {
		
		return null;
	}
	
	public void updatePerson (Person person) {
		
	}
	
	
	public void deletePerson (int id) {
		
	}
}
