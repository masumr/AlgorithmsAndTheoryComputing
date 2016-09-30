class CS6084ATolani {
	public static void main(String[] args) {
		myStack operatorsStack = new myStack(10);	
		String[] infixExpressions = {"a+b* c ^d+b*a","a+b","a+b","a+b","a+b","a+b"};
		String infixExpression;
		for (int k = 0; k< infixExpressions.length; k++) {
			infixExpression = infixExpressions[k];
			String output = "";
			for (int i = 0; i<infixExpression.length(); i++) {
				char currentChar = infixExpression.charAt(i);
				if(currentChar >= 'a' && currentChar <= 'z'){
					output += currentChar;
				}else{
					switch(currentChar){
						case '+' :
						case '-' :
						if(operatorsStack.isEmpty())
							operatorsStack.push(currentChar);
						else{
							while(!operatorsStack.isEmpty())
								output += (char) operatorsStack.pop();
							operatorsStack.push(currentChar);
						}
						break;
						case '*' :
						case '/' :
						if(operatorsStack.isEmpty() || operatorsStack.topElement() == '+' || operatorsStack.topElement() == '-')
							operatorsStack.push(currentChar);
						else{
							while(!operatorsStack.isEmpty() && operatorsStack.topElement() != '+' && operatorsStack.topElement() != '-')
								output += (char)operatorsStack.pop();
							operatorsStack.push(currentChar);
						}
						break;
						case '^' :
						if(operatorsStack.isEmpty() || operatorsStack.topElement() == '+' || operatorsStack.topElement() == '-'|| operatorsStack.topElement() == '*')
							operatorsStack.push(currentChar);
						else{
							while(!operatorsStack.isEmpty() && operatorsStack.topElement() != '+' && operatorsStack.topElement() != '-' && operatorsStack.topElement() == '*')
								output += (char)operatorsStack.pop();
							operatorsStack.push(currentChar);
						}
						break;
						case ' ' : break;
					}
				}
			}
			while(!operatorsStack.isEmpty())
				output += (char)operatorsStack.pop();
			System.out.println("Given Expression: "+ infixExpression);
			System.out.println("Postfix Expression: " + output);
		}
	}
}
class myStack{
	private int top;
	private char[] operatorsArray;

	public myStack(int size){
		operatorsArray = new char[size];
		top =- 1;
	}
	public void push(char op){
		top++;
		operatorsArray[top] = op;
	}
	public char pop(){
		return operatorsArray[top--];
	}
	int topElement(){
		return operatorsArray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
}