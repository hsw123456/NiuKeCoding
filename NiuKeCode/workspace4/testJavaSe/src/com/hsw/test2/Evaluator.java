package com.hsw.test2;

import java.util.Stack;
import java.util.StringTokenizer;
import static java.lang.Math.*;

/**
 * 一个简单的计算器程序，使用知识点：栈
 * @author Administrator
 */
public class Evaluator {

	private static final int EOL = 0;
	private static final int VALUE = 1;// 表示数字的
	private static final int OPAREN = 2;// (开括弧
	private static final int CPAREN = 3;// ) 闭括弧
	private static final int EXP = 4;// ^
	private static final int MULT = 5;// *
	private static final int DIV = 6;// /
	private static final int PLUS = 7;// +
	private static final int MINUS = 8;// -
	
	//*************************************************************//
	private Stack<Integer> opStack;
	private Stack<Long> postfixStack;
	private StringTokenizer str;
	
	public Evaluator(String s){
		opStack = new Stack<Integer>();opStack.push(EOL);
		postfixStack = new Stack<Long>();
		str = new StringTokenizer(s, "+*-/^()", true);
	}
	
	public long getValue(){
		EvalTokenizer tok = new EvalTokenizer(str);
		Token lastToken;
		do {
			lastToken = tok.getToken();
			processToken(lastToken);
		} while (lastToken.getType() !=EOL);
		
		if(postfixStack.isEmpty()){
			System.err.println("Missing operand!");
			return 0;
		}
		
		long theResult = postfixStack.pop();
		if(!postfixStack.isEmpty()){
			System.err.println("Warnning: missing operators");
		}
		
		return theResult;
	}
	
	private static class EvalTokenizer{
		private StringTokenizer str;
		public EvalTokenizer(StringTokenizer is){str = is;}
		
		public Token getToken(){
			long theValue;
			
			if(!str.hasMoreTokens())
				return new Token();
			String s = str.nextToken();
			if(s.equals(" ")) return getToken();
			if(s.equals("^")) return new Token(EXP);
			if(s.equals("/")) return new Token(DIV);
			if(s.equals("*")) return new Token(MULT);
			if(s.equals("(")) return new Token(OPAREN);
			if(s.equals(")")) return new Token(CPAREN);
			if(s.equals("+")) return new Token(PLUS);
			if(s.equals("-")) return new Token(MINUS);
			
			try {
				theValue = Long.parseLong(s);
			} catch (NumberFormatException e) {
				System.out.println("Parse error");
				return new Token();
			}
			
			return new Token(VALUE, theValue);
					
		}
	}
	private static class Token {
		private int type = 0;
		private long value = 0;

		public Token() {this(EOL);}
		public Token(int t) {this(t, 0);}
		public Token(int t, long v) {this.type = t;this.value = v;}
		public int getType() {return type;}
		public long getValue() {return value;}

	}
	

	/**
	 * After a token is read user operator precdence parsing
	 * algorithm to process it; missing opening parentheses'
	 * are deleted here
	 * @param lastToken
	 */
	public void processToken(Token lastToken){
		int topOp;
		int lastType = lastToken.getType();
		switch (lastType) {
		case VALUE:
				postfixStack.push(lastToken.getValue());//当遇到一个运算数时立刻放入后缀栈中
				return;
		case CPAREN:
				//遇到右括号，重复弹出并处理运算符栈中的项，直到左括号出现
				while((topOp =opStack.peek())!=OPAREN && topOp !=EOL)
						binaryOp(topOp);
				if(topOp == OPAREN)
					opStack.pop();//弹出左括号
				else
					System.err.println("Missing open Parenthesis");
				break;
		default:
				while(Precendence.precTable[lastType].inputSymbol<=
				Precendence.precTable[topOp = opStack.peek()].topOfStack)
					binaryOp(topOp);
				if(lastType !=EOL)
					opStack.push(lastType);
				break;
		}
	}
	
	public long getTop(){
		if(postfixStack.isEmpty()){
			System.out.println("Missing operand~~");//
			return 0;
		}
		
		return postfixStack.pop();
	}
	//计算后缀表达式的值
	public void binaryOp(int topOp){
		if(topOp == OPAREN){
			System.err.println("UNBalanced Parentheses");
			opStack.pop();return;
		}
		
		long rhs = getTop();
		long lhs = getTop();
		if(topOp == EXP)
			postfixStack.push((long) pow(lhs,rhs));
		else if (topOp == PLUS)
			postfixStack.push(lhs + rhs);
		else if(topOp == MINUS)
			postfixStack.push(lhs - rhs);
		else if(topOp == MULT)
			postfixStack.push(lhs*rhs);
		else if (topOp == DIV) {
			if(rhs !=0)
				postfixStack.push(lhs/rhs);
			else {
				System.err.println("Division by Zero");
				postfixStack.push(lhs);
			}
			opStack.pop();
		}
	}

	/* 用于定义运算优先级的类 */
	private static class Precendence {

		public int inputSymbol;
		public int topOfStack;

		public Precendence(int inSymbol, int topSymbol) {
			inputSymbol = inSymbol;
			topOfStack = topSymbol;
		}

		private static Precendence[] precTable = { new Precendence(0, -1),// EOL
				new Precendence(0, 0), // VALUE
				new Precendence(100, 0),// OPAREN
				new Precendence(0, 99),// CPAREN
				new Precendence(6, 5), // EXP
				new Precendence(3, 4), // MULT
				new Precendence(3, 4), // DIV
				new Precendence(1, 2), // PLUS
				new Precendence(1, 2) // MINUS
		};

	}
}
