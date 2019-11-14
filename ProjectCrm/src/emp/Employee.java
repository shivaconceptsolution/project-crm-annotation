package emp;

import javax.persistence.*;

@Entity
@Table(name="emp")
public class Employee {
@Id
@Column
private String username;
@Column
private String password;
@Column
private String email;
@Column
private String designation;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
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
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}


}
