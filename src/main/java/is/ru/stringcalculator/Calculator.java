package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
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
      
    private static int sum(String[] numbers){
 	    ArrayList<String> negatives = new ArrayList<String>();
 	    int total = 0;
        for(String number : numbers){
        	if (toInt(number) < 0)
        		negatives.add(number);
        	else if (toInt(number) <= 1000)
		    	total += toInt(number);
        	}

	    if (negatives.size() > 0) {
	    	int counter = 0;
	    	StringBuilder tmp = new StringBuilder("");
	    	for (String i : negatives) {
	    		tmp.append(i);
	    		if (counter < negatives.size() - 1)
	    			tmp.append(", ");
	    		counter++;
	    	}
	    	//tmp.deleteCharAt(tmp.length() - 1);
	    	String neg = tmp.toString();
	    	throw new IllegalArgumentException("Negatives not allowed: " + neg);
	    }
		return total;
    }
}