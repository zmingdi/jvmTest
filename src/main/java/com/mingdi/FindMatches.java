package com.mingdi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: failed to complete
 * @author mzhang457
 *
 */
public class FindMatches {

	public static String q = "{\r\n" + 
			"    \"FirstName\": \"Krisha'test.\",\r\n" + 
			"    \"LastName\": null,\r\n" + 
			"    \"OrganizationID\": null,\r\n" + 
			"    \"EmailAddress\": null,\r\n" + 
			"    \"Office\": \"Chicago Office\",\r\n" + 
			"    \"ErrorTitle\": \"Row validation failed for the user record\",\r\n" + 
			"    \"ErrorDesc\": \"Invalid FirstName Format\",\r\n" + 
			"    \"ErrorType\": \"Invalid\"\r\n" + 
			"},\r\n" + 
			"{\r\n" + 
			"    \"FirstName\": \"Krisha'test.\",\r\n" + 
			"    \"LastName\": null,\r\n" + 
			"    \"OrganizationID\": null,\r\n" + 
			"    \"EmailAddress\": null,\r\n" + 
			"    \"Office\": \"Chicago Office\",\r\n" + 
			"    \"ErrorTitle\": \"Row validation failed for the user record\",\r\n" + 
			"    \"ErrorDesc\": \"LastName is required\",\r\n" + 
			"    \"ErrorType\": \"Blank\"\r\n" + 
			"}";
	public static void main(String[] args) {

		final String regex = "\\{(.*\\r\\n)*\\}";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(q);

		while (matcher.find()) {
		    System.out.println("Full match: " + matcher.group(0));
		    for (int i = 1; i < matcher.groupCount(); i++) {
		        System.out.println("Group " + i + ": " + matcher.group(i));
		    }
		}}

}
