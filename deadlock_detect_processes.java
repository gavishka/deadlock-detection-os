/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign4os;

/**
 *
 * @author gavis
 */
public class Assign4OS {

    /**
     * @param args the command line arguments
     */
    private static int[][] allocation = { { 0,1,0 }, 
			 { 2,0,0 }, 
			 { 3,0,3 }, 
			 { 2,1,1 },
			 { 0,0,2 } };
     
     private static int[][] request = { { 0,0,0 }, 
			 { 2,0,2 }, 
			 { 0,0,0 }, 
			 { 1,0,0 },
			 { 0,0,2 } };
     
     
     
     private static int[] available={0,0,0};
     private static int[] dead=new int[5];

    public static void main(String[] args) {
        // TODO code application logic here
        
                int processes=5;
        int[] work=available;
        int[] allocated=new int[5];
        boolean[] finished=new boolean[5];
        
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                allocated[i]=allocated[i]+allocation[i][j];
            }
            
            if(allocated[i]!=0){
                finished[i]=false;
            }else{
                finished[i]=true;
            }
        }
        boolean reset=true;
        
        while(reset){
            reset=false;
            for(int i=0;i<5;i++){
                if(finished[i]==false){
                    boolean check=true;
                    
                    for(int j=0;j<3;j++){
                        if(request[i][j]>work[j]){
                            check=false;
                        }
                    }
                        if(check==true){
                            System.out.println("process: "+i+" running.");
                            for(int j=0;j<3;j++){
                                work[j]=work[j]+allocation[i][j];
                            }
                            finished[i]=true;
                            reset=true;
                           
                        }
                    }
                }
            }
        
                int j=0;
                int check2=0;
                for(int i=0;i<5;i++)
                {
                              if(finished[i]==false)
                              {
                                             dead[j]=i;
                                             j++;
                                             check2=1;
                              }
               }
               if(check2==1)
               {
                              System.out.println("\n\nDeadlock has been detected and the Deadlock process are\n");
                              for(int i=0;i<5;i++)
                              {
                                             System.out.println("Process is "+dead[i]);
                              }
               }
               else
               {
                              System.out.println("\n\nDeadlock has not been detected.");
               }  
        
    
    }
    
}
