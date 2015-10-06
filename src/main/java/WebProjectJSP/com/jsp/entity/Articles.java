package WebProjectJSP.com.jsp.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 * 
 * @author Lena Korsak
 * @serial 08.09.2015 16:35:00
 */

@Entity
@Table(name="articles")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a"),
	@NamedQuery(name = "Articles.findById", query = "SELECT a FROM Articles a WHERE a.id=:id"),
	@NamedQuery(name = "Articles.findByTitle", query = "SELECT a FROM Articles a WHERE a.title=:title"),
	@NamedQuery(name = "Articles.findByDate", query = "SELECT a FROM Articles a WHERE a.date=:date")})


public class Articles implements Serializable{

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
	@NotNull
	@Column(name = "title")
	private String title;
	
	@Basic(optional=false)
	@NotNull
	@Lob
	@Size(min = 1, max = 65535)
	@Column(name = "text")
	private String text;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@JoinTable(name = "groupuser_has_articles", joinColumns = {
	        @JoinColumn(name = "articles_id", referencedColumnName = "id")}, inverseJoinColumns = {
	        @JoinColumn(name = "groupuser_name", referencedColumnName = "name")})
	@ManyToMany
	private Collection<Groupuser> groupuserCollection;
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		try{
			return new SimpleDateFormat("dd.MM.yyy").format(this.date);
		}catch(NullPointerException e){
			return "Дата не определена";
		}
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "articlesId")
	private Collection<Messages> messagesCollection;
	
	public Articles(){
		
	}
	
	public Articles(Integer id){
		this.id = id;
	}

	/**
	 * 
	 * @param id - Identification articles
	 * @param title - title articles
	 * @param text  - text in the articles
	 * @param date - create date to articles
	 */
	public Articles(Integer id, String title, String text, Date date) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = date;
	}

	@XmlTransient
	public Collection<Groupuser> getGroupuserCollection() {
		return groupuserCollection;
	}

	public void setGroupuserCollection(Collection<Groupuser> groupuserCollection) {
		this.groupuserCollection = groupuserCollection;
	}

	@XmlTransient
	public Collection<Messages> getMessagesCollection() {
		return messagesCollection;
	}

	public void setMessagesCollection(Collection<Messages> messagesCollection) {
		this.messagesCollection = messagesCollection;
	}
	
	@Override
	public int hashCode(){
		int hash = 0;
		hash += (id !=null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Articles)){
			return false;
		}
		
		Articles other = (Articles) object;
		if((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))){
			return false;
		}
		return true;
	}

	@Override
	public String toString(){
		return "entity.Articles[ id = " + id + "]";
	}
	
	public void setup(){
		this.date = new Date();
		this.id = 123;
		this.text = "This is new articles for me!";
		this.title = "First articles";
	}



}
