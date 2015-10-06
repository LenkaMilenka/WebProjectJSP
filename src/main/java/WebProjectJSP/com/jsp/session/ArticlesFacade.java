package WebProjectJSP.com.jsp.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import WebProjectJSP.com.jsp.entity.Articles;

@Stateless
public class ArticlesFacade extends AbstractFacade<Articles> {

	 @PersistenceContext(unitName = "WebProjectJSP")
	 private EntityManager em;
	


	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}
	
	
	
	public ArticlesFacade() {
		super(Articles.class);
	}	

}
