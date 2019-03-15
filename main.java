import java.util.*;

class Java_task{
	
    static Scanner sc = new Scanner(System.in);
    String[] student;
    String[][] list,qu;
    int[] taken_action;
    float[] cgpa;
    Java_task(){
	
	}
	void take_input()
	{
		int test_case=Integer.parseInt(sc.nextLine());
		student=new String[test_case];
        list=new String[test_case][];
        taken_action=new int[test_case];
        cgpa=new float[test_case];
        qu=new String[0][0];
		for(int i=0;i<test_case;i++){
            student[i]=sc.nextLine();
		}
        for(int i=0;i<test_case;i++){
            list[i]=student[i].split(" ");
            cgpa[i]=-1;
            if(list[i][0].equals("ENTER")){
                taken_action[i]=0;
            }
            else{
                taken_action[i]=1;
            }
        }
        
    }
   
	private String[][] store(String[][] ar, String[] store) {
        String[][] var_t = new String[ar.length + 1][];
        for (int i = 0; i < ar.length; i++){
            var_t[i] = ar[i];
        }
        var_t[ar.length] = store;
        return var_t;
    }
	
	
	
    private String[][] retrieve(String[][] ar){
        if(ar.length == 0){
            return ar;
        }
        else{
            String[][] var_t = new String[ar.length - 1][];
            for (int i = 1; i < ar.length; i++){
                var_t[i-1] = ar[i];
            }
            return var_t;
        }
    }

   void calculate(){
        int j=0;
        for(int i=0;i<taken_action.length;i++){
            if(taken_action[i]==0){
                qu=store(qu,list[i]);
            }
            else{
                qu=priority(qu);
                qu=retrieve(qu);
            }
        }
   }
   void display()
   {   
	 if(qu.length == 0){
            System.out.println("EMPTY");
        }
        else{
        	qu=priority(qu);
            for(int i=0;i<qu.length;i++ ){
                System.out.println(qu[i][1]);
            }
        }
    }
   

   String[][] priority(String[][] ar){
        String[] n1,n2;
        n2=new String[2];
        float num1,num2;
        for(int i=0;i<ar.length-1;i++){
            for(int j=0;j<ar.length-i-1;j++){
                num1=Float.parseFloat(ar[j][2]);
                num2=Float.parseFloat(ar[j+1][2]);
                if(num1<num2){
                    n1=ar[j];ar[j]=ar[j+1];ar[j+1]=n1;
                }
                else if(num1==num2){
                    n2[0]=ar[j][1];
                    n2[1]=ar[j+1][1];
                    if(n2[0].equals(n2[1])){
                        int tm1=Integer.parseInt(ar[j][3]);
                        int tm2=Integer.parseInt(ar[j+1][3]);
                        if(tm1>tm2){
                            n1=ar[j];
                            ar[j]=ar[j+1];
                            ar[j+1]=n1;
                        }
                    }
                    else{
                        String tm=n2[1];
                        List tls;
                        Arrays.sort(n2);
                        if(n2[0].equals(tm)){
                            n1=ar[j];
                            ar[j]=ar[j+1];
                            ar[j+1]=n1;
                        }
                    }
                }
            }
        }
        return qu;
    }
    
    
}
