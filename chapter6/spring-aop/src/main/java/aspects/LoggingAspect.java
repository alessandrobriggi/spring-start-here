package aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* services.*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		Object[] parameters = joinPoint.getArgs();
		logger.info("Method " + methodName + " with parameters " + Arrays.asList(parameters) + " will execute...");
		joinPoint.proceed();
		logger.info("Method " + methodName + " has finished its execution");
	}

}
