


      public class TokenCharacter extends Token{
         private Type type;
	 private String id;
	 
             public TokenCharacter(Type type,String id){
	        this.id = id;
	        this.type = type;	
	     }
         @Override
         public Type getType(){
	   return type;
	 }	 
         @Override
	 public String getId(){
	   return id;
	 }
      } 
