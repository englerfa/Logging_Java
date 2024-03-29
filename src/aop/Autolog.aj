package aop;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.aspectj.lang.reflect.CodeSignature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public aspect Autolog {
	
	/**
	 * create pointcut that captures all public and private methods.
	 * execution( return_type package_class_method arguments).
	 */
    pointcut methodExecuted(): ( call(* *.*(..)) ) && !within(Autolog);
    // call or execution?
    
    // get information from method (name, arguments, return value, ...)
    after() returning (Object returnValue): methodExecuted() {
    	
        CodeSignature codeSignature = (CodeSignature) thisJoinPoint.getSignature();
        
        String signature = codeSignature.toString();
        String[] argumentNames = codeSignature.getParameterNames();
        Object[] argumentValues = thisJoinPoint.getArgs();
        
        Logging logger = new Logging();
        //logger.logManualFormat(signature, argumentNames, argumentValues, returnValue);
        logger.logStructuredFormat(signature, argumentNames, argumentValues, returnValue);
        
    }
    
    
    before(): methodExecuted(){
        // Not used yet.
    }
    
    
    class Logging{
    	
    	/**
    	 * This method logs in a human readable format e.g., 
    	 * Output = LOGGING] 2019-09-20 14:12:27 | METHOD: double java.lang.Math.min(double, double), ARGUMENTS: a=5.0 b=6.0 , RETURNS: 5.0
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
    	 * JSON = {"name":..., "arguments": [{"type":..., "name":..., "value":...}, {"type":..., "name":..., "value":...},...], "return_type":..., "return_value",..., "time":...}
    	 */
    	public void logStructuredFormat(String signature, String[] argumentNames, Object[] argumentValues, Object returnValue) {
    		
    		JSONObject json = new JSONObject();
    		JSONArray arguments = new JSONArray();
    		
    		List<Argument> args = new ArrayList<Argument>();
    		
    		for (int i =0; i < argumentValues.length; i++){
    			String type = "int";
    			String name = argumentNames[i];	
                Object value = argumentValues[i];
                
                if(value != null) {
                	JSONObject arg = new JSONObject();
                	arg.put("type", argumentValues[i].getClass().getSimpleName());
                	arg.put("name", name);
                	arg.put("value", value);
                	arguments.add(arg);
                	
                }
            }
    		
    		json.put("name", signature);
    		json.put("arguments", arguments);
    		json.put("return_type", returnValue.getClass().getSimpleName());
            json.put("return_value", returnValue);
        	LocalDateTime now = LocalDateTime.now();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            json.put("time", now.format(formatter));
            
            System.out.println(json);
    	}
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
