package WebProjectJSP.com.jsp.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import WebProjectJSP.com.jsp.entity.MyClass;
/**
 * 
 * @author Lena Korsak
 * @serial 08.09.2015 16:32:00
 *
 */
@Stateless
public class MyClassFacade extends AbstractFacade<MyClass>{

	@PersistenceContext(unitName = "WebProjectJSP")
	private EntityManager em;
	
	public MyClassFacade() {
		super(MyClass.class);
		
	}

	/**
	 * @param em - EntityManager
	 */
	@Override
	protected EntityManager getEntityManager() {
		
		return em;
	}

}
