package aop;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.aspectj.lang.reflect.CodeSignature;

import org.json.simple.*;


public aspect Autolog {
	
	/**
	 * create pointcut that captures all public and private methods.
	 * execution( return_type package_class_method arguments).
	 */
    pointcut methodExecuted(): ( call(* *.*(..)) ) && !within(Autolog);
    // call or execution?

    before(): methodExecuted(){
        // TODO record argument values before the method gets executed? Can they be changed otherwise? Possible approach with around.
    }
    
    // get information from method (name, arguments, return value, ...)
    after() returning (Object returnValue): methodExecuted() {
    	
        CodeSignature codeSignature = (CodeSignature) thisJoinPoint.getSignature();
        
        String signature = codeSignature.toString();
        String[] argumentNames = codeSignature.getParameterNames();
        Object[] argumentValues = thisJoinPoint.getArgs();
        
        Logging logger = new Logging();
        logger.logManualFormat(signature, argumentNames, argumentValues, returnValue);
        //logger.logStructuredFormat(signature, argumentNames, argumentValues, returnValue);
        
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
	
    class Logging{
    	
    	
    	/**
    	 * This method logs in a human readable format e.g., [LOGGING] 2019-09-20 14:12:27 | METHOD: double java.lang.Math.min(double, double), ARGUMENTS: a=5.0 b=6.0 , RETURNS: 5.0
    	 */
    	public void logManualFormat(String signature, String[] argumentNames, Object[] argumentValues, Object returnValue) {
            
    		List<Argument> args = new ArrayList<Argument>();
    		
    		for (int i =0; i < argumentValues.length; i++){
                Object argument = argumentValues[i];
                String name = argumentNames[i];	
                
                if(argument != null) {
                	Argument arg = new Argument(name, argument.toString(), argument.getClass().toString());
                	args.add(arg);
                }
            }

        	LocalDateTime now = LocalDateTime.now();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.print("[LOGGING] ");
            System.out.print(now.format(formatter) + " | ");
            System.out.print("METHOD: " + signature);
            System.out.print(", ARGUMENTS: ");
            for(Argument a : args) {
            	System.out.print(a.name + "=" + a.value + " ");
            }
            System.out.print(", RETURNS: " + returnValue);
            System.out.println();
    	}
    	
    	/**
    	 * This method logs in a machine readable format i.e., in JSON format.
    	 */
    	public void logStructuredFormat(String signature, String[] argumentNames, Object[] argumentValues, Object returnValue) {
    		
    		List<Argument> args = new ArrayList<Argument>();
    		
    		for (int i =0; i < argumentValues.length; i++){
                Object argument = argumentValues[i];
                String name = argumentNames[i];	
                
                if(argument != null) {
                	Argument arg = new Argument(name, argument.toString(), argument.getClass().toString());
                	args.add(arg);
                }
            }

    		
    		
    		
    		
    	}
    }
     
}