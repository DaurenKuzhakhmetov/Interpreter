import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

     public class Interpreter{
	                                            
       
          public static void main(String[] args){
	     String[] text = new String[1];
	     text[0] = "2*5*(3+1)";  // 4 4 4 + - 4 4 + +
             //String pattern = "[a-zA-Z\d]";		
	     Lexer lexer = new Lexer();
	     List<Token> tokens =  lexer.toParse(text,""); // second parameter is regex  pattern 
	     
	     Queue<Token> queue  = doSyntax(tokens);  
             while(!queue.isEmpty()){
	         System.out.print(queue.remove().getType() + " ");
	     }
	     execute(queue);
	  }   
          
          // Shounting-Yard algorithm
	  private static Queue<Token> doSyntax(List<Token> tokens) {
             Queue<Token> queue = new LinkedList<>();             
     	     Stack myStack = new Stack(1024);
	     
	     for(int i=0;i<tokens.size();i++){
	       label:	     
	         switch(tokens.get(i).getType()){
			 case NUMBER: queue.offer(tokens.get(i));
				break;
 	                 case LBR:  myStack.push(tokens.get(i));
                                 break;
	         	    
			 case ADD:
				        doOperator(myStack,queue,tokens.get(i));
                                      break; 
                                            
			 case MUL:
					doOperator(myStack,queue,tokens.get(i));     
			              break;
			 case DIV: 
		                        doOperator(myStack,queue,tokens.get(i));
                                      break;

			 case SUB:      doOperator(myStack,queue,tokens.get(i));

                                      break;				
			 case RBR:  
                                  while(!myStack.isEmpty()){   
			 	     Token token = myStack.pop();
			              if(token == null){
					 continue;  
			            }

			              if(token.getType()==Type.LBR){
					 break label; 
				      }else {
					 queue.offer(token);
			              }
				    } 
                                    System.out.println("We don't have '(' in programm");				    
		                   break;		    
		 } 
	     }
	       if(!myStack.isEmpty()){   
		    Token token = myStack.pop();   
	          if(token instanceof TokenCharacter){
		      System.out.println("Присутствует незакрытая скобка ");
		  }else{
		      queue.offer(token); 
		  }
		 
	       }
              
	          return queue;
	                                      
            }

              private static void doOperator(Stack myStack,Queue<Token> queue,Token token){
		          if(!myStack.isEmpty()){
			      Token token2 = myStack.peek();
			      if(token2 instanceof TokenOperand){
			           if(getChoice(token,token2)){
				      queue.offer(token2);
				      myStack.pop();
				   } 
			         
			      }else{
			           myStack.push(token);
			      }  
			  }else{
			      myStack.push(token);
			  }
		      		      
	       }



	       private static boolean getChoice(Token token1,Token token2){
                  TokenOperand operand1 =(TokenOperand) token1;
                  TokenOperand operand2 =(TokenOperand) token2;
                  if((operand1.compareTo(operand2)==-1 || operand1.compareTo(operand2)==0) && operand1.isLeftAssociative()){
                       return false;
                  }else if(!operand1.isLeftAssociative() && operand1.compareTo(operand2)==-1){
                       return false;
                  }
                  return true;

          }
	   
	      private static void execute(Queue<Token> queue){
	            
		    
	      }


   }


      class Stack{
        private int STACK_SIZE;
        private Token[] stack;
        private int stack_pointer; 	
           public Stack(int size){
	       STACK_SIZE = size;	   
	       stack = new Token[STACK_SIZE];
	       stack_pointer=-1;
	   }

        public void push(Token token){
	     stack[++stack_pointer] = token;
	      
	}
       
	public Token pop(){ 
	     return stack[stack_pointer--];  
	}
            
        public Token peek(){
	    return stack[stack_pointer];
	}
      
        public void jump(){
	      
	}
        public boolean isEmpty(){
	   return (stack_pointer == -1);
	}
        
	public boolean isFull(){
	   return (stack_pointer == STACK_SIZE-1);
	}
                      
       }
