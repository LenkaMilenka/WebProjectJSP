package WebProjectJSP.com.jsp.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MyClass")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "MyClass.findAll", query = "SELECT c FROM c"),
	@NamedQuery(name = "MyClass.findById", query = "SELECT c FROM c WHERE c.id = :id"),
	@NamedQuery(name = "MyClass.findByName", query = "SELECT c FROM c WHERE c.name = :name")})
public class MyClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Basic(optional = false)
	@Size(min = 1, max = 50)
	@NotNull
	@Column(name = "name")
	private String name;
	
	private Collection<MyClass> myClassCollection;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<MyClass> getMyClassCollection() {
		return myClassCollection;
	}

	public void setMyClassCollection(Collection<MyClass> myClassCollection) {
		this.myClassCollection = myClassCollection;
	}

	public MyClass() {
	}

	public MyClass(Integer id) {
		this.id = id;
	}

	public MyClass(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode(){
		int hash = 0;
		hash += ( id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof MyClass))
			return false;
		MyClass other = (MyClass) object;
		if((this.id == null && other.id != null) || (this.id != null && this.equals(other.id)))
			return false;
		
		return true;
	}
	
	@Override
	public String toString(){
		return "entity.MyClass id = [ " + id + " ]";
	}
	
	public void setup(){
		this.id = 455;
		this.name = "It's my first class";
	}
	

}
