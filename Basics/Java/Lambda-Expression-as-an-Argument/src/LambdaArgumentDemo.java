interface StringFunc {
	String func(String str);
}

public class LambdaArgumentDemo {
		
		//This demo has a function interface as the type of its first parameter. it can be passed a reference to any instance of that interface
		// including an instance created by a lambda expression. the second parameter specifies the string to operate on
		static String changeStr(StringFunc sf, String s) {
			return sf.func(s);
		}
		
	public static void main(String[] args) {
		
		String inStr = "Lambda Expressions Expand Java";
		String outStr;
		
		System.out.println("Here is input string: " + inStr);
		
		//define a lambda expression that reverses the contents of a string and assign it to a StringFunc reference variable.
		StringFunc reverse = (str) -> {
			String result = "";
			
			for(int i = str.length()-1;i >= 0; i--)
				result += str.charAt(i);
			
			return result;
		};
		
		//pass reverse to the first argument to changeStr().
		//pass the input string as the second argument
		outStr = changeStr(reverse, inStr);
		System.out.println("The string reverseed: " + outStr);
		
		// this lambda expression replaces spaces with hyphens.
		// it is embedded directly inn the call to changeStr().
		outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
		System.out.println("The string with spaces replaced: " + outStr);
		
		// this block lambda inverts the case of the characters in the string.
		// it is also embedded directly in the call to change str().
		outStr = changeStr((str) -> {
			String result = "";
			char ch;
			
			for(int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if(Character.isUpperCase(ch))
					result += Character.toLowerCase(ch);
				else
					result += Character.toUpperCase(ch);
			}
			return result;
		}, inStr);
		
		System.out.println("The string in reversed case: " + outStr);
	}	
}

