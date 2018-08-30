package kosta.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SessionAspect {
	
	@Around("execution(public * kosta.controller.*.*exe(..))") //üũ
	public String sessionCheck(ProceedingJoinPoint jointPoint)throws Throwable{
		Object[] obj = jointPoint.getArgs();  
		//proceed �� ���� api ���� request�� �ҷ� �ü� �ִ�.getArgs(); exe�� ���� �Ķ���� ���� �����ü� �ִ�.
		HttpServletRequest request =(HttpServletRequest)obj[0];		
		HttpSession session = request.getSession();
		System.out.println(1);
		String name = (String)session.getAttribute("name");
		
		String view = "session/session_fail";
		
		try {
			System.out.println(2);
			if(name == null){
				throw new Exception("no session");
			}
			System.out.println(3);
			view= (String)jointPoint.proceed(); //session_exe() // .proceed() �ٽɰ��ɻ��� ȣ��
			
		} catch (Exception e) {
			System.out.println(4);
			return view;
		}
		
		return view;
	}
	
	

}
