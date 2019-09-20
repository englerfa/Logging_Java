package aop;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.aspectj.lang.reflect.CodeSignature;

public aspect Autolog {
	
	
	/**
	 * configuration of output.
	 * 0 human readable like [LOGGING] 2019-09-20 14:12:27 | METHOD: double java.lang.Math.min(double, double), ARGUMENTS: a=5.0 b=6.0 , RETURNS: 5.0
	 * 1 machine readable e.g., in JSON format
	 */
    pointcut publicMethodExecuted(): ( call(* *.*(..)) || execution(* *.*(..)) ) && !within(Autolog);
    
    // TODO record argument values before the method gets executed? Can they be changed otherwise?
    
    // get information from method (name, arguments, return value, ...)
    after() returning (Object returnValue): publicMethodExecuted() {
    	List<Argument> args = new ArrayList<Argument>();
    	LocalDateTime now = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	
        String signature = thisJoinPoint.getSignature().toString();
        CodeSignature codeSignature = (CodeSignature) thisJoinPoint.getSignature();
        
        // collect argument values and names
        Object[] argumentValues = thisJoinPoint.getArgs();
        String[] argumentNames = codeSignature.getParameterNames();
        for (int i =0; i < argumentValues.length; i++){
            Object argument = argumentValues[i];
            String name = argumentNames[i];	
            if (argument != null){
            	Argument arg = new Argument(name, argument.toString(), argument.getClass().toString());
            	args.add(arg);
            }
        }
        
        
        System.out.print(now.format(formatter) + " | ");
        System.out.print("METHOD: " + signature);
        System.out.print(", ARGUMENTS: ");
        for(Argument a : args) {
        	System.out.print(a.name + "=" + a.value + " ");		// TODO Add type, too?
        }
        System.out.print(", RETURNS: " + returnValue);
        System.out.println();
        
    }
    
	class Argument {
		String name;
		String value;
		String type;
		
		public Argument(String name, String value, String type){
			this.name = name;
			this.value = value;
			this.type = type;
		}
		
		public String toString() {
			return "name=" + name + ", value=" + value + ", type=" + type;
		}
	}
     
}