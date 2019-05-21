import java.util.ArrayList;
import java.util.List;   
        public class Lexer{
		
	// 4-(4+4)+(4+4)
                 // забыл добавить строчки кода которым принадлежат те или иные выражения 
	   public List<Token> toParse(String[] text,String pattern){
	 	List<Token> tokens = new ArrayList<>(); 		
                    for(int i=0;i<text.length;i++){
		      for(int j=0;j<text[i].length();j++){
		        String num =  text[i].charAt(j)+"";	
                         if(isNumber(num)){ 
			     tokens.add(new TokenNumber(Integer.parseInt(num),Type.NUMBER,""));
			     continue;
			 }	 
                      
		         switch(text[i].charAt(j)+""){
		              		 
			   case "(": 
                                tokens.add(new TokenCharacter(Type.LBR,""));
			      break;
			   case ")":
			        tokens.add(new TokenCharacter(Type.RBR,""));
			      break;

                           case "+":
			        tokens.add(new TokenOperand(true,1,Type.ADD,""));
			      break;
			   case "-":
			        tokens.add(new TokenOperand(true,1,Type.SUB,""));
			      break;   
			   case "*":
			        tokens.add(new TokenOperand(true,2,Type.MUL,""));
			      break;
		           case "/":
		                tokens.add(new TokenOperand(true,2,Type.DIV,""));
		              break;
			   case "%":
                                tokens.add(new TokenOperand(true,2,Type.MODULE,""));
                              break;
                           
			 }	
		    }     
	        //    tokens.add(new TokenCharacter(Type.EOF,""));

	    
	        }
	
		return tokens;
	   } 

	    private static boolean isNumber(String s){
	          try {
                        Integer.parseInt(s);
                        return true;
                     } catch (NumberFormatException ex)
                    {
                     return false;
                    }
 	     } 

	      
	
       	}
