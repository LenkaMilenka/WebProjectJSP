package WebProjectJSP.com.jsp.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import WebProjectJSP.com.jsp.entity.Groupuser;

@Stateless
public class GroupuserFacade extends AbstractFacade<Groupuser>{

	@PersistenceContext(unitName = "WebProjectJSP")
	private EntityManager em;
	
	public GroupuserFacade() {
		super(Groupuser.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
