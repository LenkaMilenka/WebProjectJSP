package WebProjectJSP.com.jsp.entity;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {
	
	private static ApplicationContext ctx;

	@Bean(initMethod = "setup", destroyMethod = "cleanup")	
	@Scope("prototype")
	public Messages messages(){
		Messages mes = new Messages();
		return mes;
	}
	
	@Bean(initMethod = "setup", destroyMethod="cleanup")
	@Scope("prorotype")
	public Articles articles(){
		return new Articles();
	}
	
	@Bean(initMethod = "setup", destroyMethod="cleanup")
	@Scope("prototype")
	public Groupuser groupuser(){
		return new Groupuser();
	}
	
	@Bean(initMethod = "setup", destroyMethod = "cleanup")
	@Scope("prototype")
	public MyClass myClass(){
		return new MyClass();
	}
	
	@Bean(initMethod = "setup", destroyMethod = "cleanup") 
	@Scope("prototype")
	public Users users(){
		return new Users();
	}
	
	public static void main(String[] args){
		ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Users users = ctx.getBean(Users.class);
		users.getLogin();
	}

	
}


