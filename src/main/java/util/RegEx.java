package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static Matcher padrao(String regex, String corresponde) {
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(corresponde);
		
		return matcher;
		
	}
	
}
