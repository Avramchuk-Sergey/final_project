package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	
	public static final long SerialVersionUID = 2L;
	
	private Integer id;
	private String firstName;
	private String surname;
	private String login;
	private String password;
	private String email;
	private String role;
	
	public User() {
		
	}
	
	public User(Integer id, String firstName, String surname, String login, String password, String email, String role) {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(surname, user.surname) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname, login, password, email, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
	
	

}
