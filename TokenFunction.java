



         public class TokenFunction extends Token{ 
	     private String id;
	     private Type type;
	        public Function(Type type,String id){
		   this.id = id;
		   this.type = type;
		}
           @Override
	   public String getId(){
	     return id;
	   } 
	   @Override
	   public Type getType(){
	     return type;
	   }
		 
	 } 
