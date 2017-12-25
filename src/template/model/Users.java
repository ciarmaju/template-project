
package template.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users{

	public Users(){}
	public Users(String pseudo, String password, String role, String sex, String name, String firstname, String lang) {
		super();
		this.pseudo = pseudo;
		this.password = password;
		this.role = role;
		this.sex = sex;
		this.name = name;
		this.firstname=firstname;
		this.lang=lang;
	}
	@Id @GeneratedValue
	private Long id;
	private String pseudo;
	private String name;
	private String firstname;
	private String password;
	private String role;
	private String sex;
	private String lang;
	private boolean hasImage;
	private String urlImage;
	
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHasImage() {
		return hasImage;
	}
	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getId() {
		return id;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int compareTo(Users o) {
		return this.getPseudo().compareTo(o.getPseudo());
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}