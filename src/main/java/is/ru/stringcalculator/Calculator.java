package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.startsWith("//")) {
			return sum(splitNumbersDiffDelim(text));
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\n");
	}

	// Handling inputs with different delimiter
	private static String[] splitNumbersDiffDelim(String all) {
			String delim = all.substring(2, all.indexOf('\n'));
			String numbers = all.substring(all.indexOf('\n')+1);
			return numbers.split(delim);
	}
	
	// StringBuilder function which builds a string from ArrayList in the correct format to print with exception for negative numbers
	private static String buildString(ArrayList<String> negatives) {
		StringBuilder tmp = new StringBuilder("");
    	int counter = 0;
    	for (String i : negatives) {
    		tmp.append(i);
    		if (counter < negatives.size() - 1)
    			tmp.append(", ");
    		counter++;
    	}
    	return tmp.toString();
	}
      
    private static int sum(String[] numbers){
 	    ArrayList<String> negatives = new ArrayList<String>();
 	    int total = 0;
        for(String number : numbers){
        	// Check for negatives which are added to ArrayList to print out with exception later on
        	if (toInt(number) < 0)				
        		negatives.add(number);			
        	// Numbers larger than 1000 ignored, others summed up
        	else if (toInt(number) <= 1000)		
		    	total += toInt(number);
        	}
        // Check if there were any negatives, if so throw exception along with corresponding numbers
	    if (negatives.size() > 0) {
	    	String neg = buildString(negatives);
	    	throw new IllegalArgumentException("Negatives not allowed: " + neg);
	    }
		return total;
    }
}