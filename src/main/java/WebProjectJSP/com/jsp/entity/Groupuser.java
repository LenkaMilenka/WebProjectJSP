package WebProjectJSP.com.jsp.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "groupuser")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Goupuser.findAll", query = "SELECT g FROM Groupuser g"),
	@NamedQuery(name = "Groupuser.findByName", query = "SELECT g FROM Groupuser g WHERE g.name=:name")})
public class Groupuser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "groupuserCollection")
	private Collection<Articles> articlesCollection;
	@JoinColumn(name = "users_login", referencedColumnName = "login")
	@ManyToOne(optional = false)
	private Users userLogin;

	
	public Groupuser(){
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@XmlTransient
	public Collection<Articles> getArticlesCollection() {
		return articlesCollection;
	}


	public Groupuser(String name) {
		this.name = name;
	}


	public void setArticlesCollection(Collection<Articles> articlesCollection) {
		this.articlesCollection = articlesCollection;
	}


	public Users getUserLogin() {
		return userLogin;
	}


	public void setUserLogin(Users userLogin) {
		this.userLogin = userLogin;
	}
	
	@Override
	public int hashCode(){
		int hash = 0;
		hash += (name != null ? name.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Groupuser)){
			return false;
		}
		Groupuser other = (Groupuser) object;
		if((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))){
			return false;
		}
		return true;
		
	}
	
	@Override
	public String toString(){
		return "entity.Groupuser[ user = " + name + " ]";
	}
	
	public void setup(){
		this.name = "First groupuser";
		this.userLogin = new Users();
		
	}


}
