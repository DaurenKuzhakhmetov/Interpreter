
 
    

 
     public class TokenOperand extends Token implements Comparable<TokenOperand>{
        private boolean leftAssociative;
	private int priority;
	private Type type;
        private String id;

           public TokenOperand(boolean leftAssociative,int priority,Type type,String id){
	         this.leftAssociative = leftAssociative;
		 this.priority = priority;
		 this.type = type;
		 this.id = id;
	   }

	      
        @Override
          public Type getType(){
                return type; 
           }

       
         @Override
            public int compareTo(TokenOperand o){
	      if(this.priority>o.getPriority()){
	            return 1;
	       }else if(this.priority == o.getPriority()){
	            return 0;
	       }else{
	            return -1;
	       }
	 }
        @Override
	   public String getId(){
	     return id; 
	 }

        public int getPriority(){
	   return priority;
	}

	public boolean isLeftAssociative(){
	   return leftAssociative;
	}    
      }
