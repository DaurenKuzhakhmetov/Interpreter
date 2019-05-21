





       public class TokenNumber extends Token{
         private String id;
	 private Type type;
	 private int number;
          
         public TokenNumber(int number,Type type,String id){
	    this.id = id;
	    this.type = type;
	    this.number = number;
	 } 

        @Override
	 public Type getType(){
	   return type;
	 }

        @Override
        public String getId(){
	  return id;
	}

	 public int getNumber(){
	  return number;
	 }

          
       }
