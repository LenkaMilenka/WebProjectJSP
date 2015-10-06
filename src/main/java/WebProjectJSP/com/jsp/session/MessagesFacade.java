package WebProjectJSP.com.jsp.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import WebProjectJSP.com.jsp.entity.Messages;

@Stateless
public class MessagesFacade extends AbstractFacade<Messages> {

	@PersistenceContext(unitName = "WebProjectJSP")
	private EntityManager em;
	
	public MessagesFacade() {
		super(Messages.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	
	
}
