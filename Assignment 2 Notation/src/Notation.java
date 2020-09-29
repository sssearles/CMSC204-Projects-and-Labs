/**
 * Assignment 2: Notation
 * This class contains methods that convert infix to postfix
 * and postfix to infix. It also contains a method to evaluate
 * a postfix expression, taking in a string and returning a
 * double
 * @author Susan Searles
 * CMSC 204 with Professor Alexander
 * Due September 30, 2020
 *
 */
public class Notation {

	/**
	 * No-arg default constructor for this class
	 */
	public Notation() {

	}

	/**
	 * This method assigns a precedence to an operator
	 * character.
	 * @param c operator character
	 * @return assigned precedence value
	 */
	public static int precedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}

	/**
	 * This method converts an expression with infix notation to 
	 * a postfix expression.
	 * @param infixExp the infix string expression to be converted
	 * @return postfix expression in string format
	 * @throws InvalidFormatNotationException if the infix expression is invalid
	 */
	public static String convertInfixToPostfix(String infixExp) throws InvalidNotationFormatException {
		// Create a stack to hold operators from the infix expression
		NotationStack<Character> operatorStack = new NotationStack<>(infixExp.length());

		// Create a queue to hold the postfix solution
		NotationQueue<Character> postfixSoltn = new NotationQueue<>(infixExp.length());						

//		System.out.println("We are converting "+ infixExp);

		for (int index = 0; index < infixExp.length(); index++ )	
		{					
			char nextCharacter = infixExp.charAt(index);

			// If the character is a space, ignore it.
			if (nextCharacter == ' ') {
				continue;									
			}

			// If the character is a digit, copy it to the postfix solution queue.
			if (Character.isDigit(nextCharacter)) 			
			{
				postfixSoltn.enqueue(nextCharacter);
				System.out.println("queue:" + postfixSoltn);
				System.out.println("stack: " + operatorStack);
				continue;
			}

			switch (nextCharacter)
			{
			// If the character is a left parenthesis, push it onto the stack
			case '(':				
				operatorStack.push(nextCharacter);		
				break;

			case '+': case '-': case '*': case '/':		
					
				while (!operatorStack.isEmpty() && (precedence(nextCharacter) <= precedence((char)operatorStack.top()))) {
					postfixSoltn.enqueue(operatorStack.pop());
				}
				operatorStack.push(nextCharacter);
				break;

			case ')':				

					while (!operatorStack.isEmpty() && operatorStack.top() !='(' ) {
						postfixSoltn.enqueue(operatorStack.pop());
					}
					if (!operatorStack.isEmpty()) {
						operatorStack.pop();
					} else if (operatorStack.isEmpty()) {
						throw new InvalidNotationFormatException();
					}
					break;									
	
			default: break;								
			}											

//			System.out.println("queue:" + postfixSoltn);
//			System.out.println("stack: " + operatorStack);
		}
		while (!operatorStack.isEmpty()) {
			postfixSoltn.enqueue(operatorStack.pop());

		}
		return postfixSoltn.toString();

	}

	/**
	 * This method converts an expression with postfix notation
	 * to an infix expression.
	 * @param postfixExp the postfix expression to be converted
	 * @return infix expression
	 * @throws InvalidNotationFormatException if the postfix expression is invalid
	 */
	public static String convertPostfixToInfix(String postfixExp) throws InvalidNotationFormatException {

		// Instantiate a new stack for the infix solution expression and initialize
		// it to empty. 
		NotationStack<String> infixExp = new NotationStack<>(postfixExp.length()); 

		for (char c: postfixExp.toCharArray()) {
			// Create a loop to fetch each token from the postfix expression being translated.

			String nextCharacter = String.valueOf(c);	

			// If the character is a space, ignore it.
			if (nextCharacter == " ")
				continue;

			// If the character is an operand, push it onto the stack.
			if (Character.isDigit(c)) {
				infixExp.push(nextCharacter);
			}
			else if (c == '+' || c == '-' || c =='*' || c == '/') {
				if (infixExp.size()<2) {
					throw new InvalidNotationFormatException();
				} 
				String operand2 = infixExp.pop();
				String operand1 = infixExp.pop();
				String result = '(' + operand1 + nextCharacter + operand2 + ')';
				infixExp.push(result);
			}
		}
		if (infixExp.size() >1)
			throw new InvalidNotationFormatException();
		return infixExp.toString();
	}
	/**
	 * This method evaluates a postfix expression and returns
	 * a double value of the expression
	 * @param postfix
	 * @return 
	 */
	public static double evaluatePostfixExpression(String postfix) {

		NotationStack<Double> evaluationStack = new NotationStack<>(postfix.length());

		// How do i set the stack to empty?
		char[] array = postfix.toCharArray();

		for (char c: array) {
			if (c == ' ') {
				continue;
			}

			if (Character.isDigit(c) || c == '(') {
				evaluationStack.push(Double.parseDouble(Character.toString(c)));
				continue;
			}


			if (c == '+' || c == '-' || c == '*' || c == '/') {
				if (evaluationStack.size()<2) {
					throw new InvalidNotationFormatException();
				}

				double operand2 = evaluationStack.pop();
				double operand1 = evaluationStack.pop();

				switch (c) {
				case '+':
					evaluationStack.push(operand1 + operand2);
					break;
				case '-':
					evaluationStack.push(operand1 - operand2);
					break;
				case '*':
					evaluationStack.push(operand1 * operand2);
					break;
				case '/':
					evaluationStack.push(operand1 / operand2);
				default: break;
				}

			}
		}
		if (evaluationStack.size() >1) {
			throw new InvalidNotationFormatException();
		}
		return Double.parseDouble(evaluationStack.toString());
	}

	public static double evaluateInfixExpression(String infixExp) throws InvalidNotationFormatException {
		return evaluatePostfixExpression(convertInfixToPostfix(infixExp));
	}
}
