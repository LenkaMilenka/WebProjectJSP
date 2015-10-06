package WebProjectJSP.com.jsp.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import WebProjectJSP.com.jsp.entity.Users;
/**
 * 
 * @author Lena Korsak
 * @serial 08.09.2015 16:33:00 
 */
@Stateless
public class UserFacade extends AbstractFacade<Users>{

	@PersistenceContext(unitName = "WebProjectJSP")
	private EntityManager em;
	
	public UserFacade() {
		super(Users.class);
	
	}

	@Override
	protected EntityManager getEntityManager() {
	
		return em;
	}

}
