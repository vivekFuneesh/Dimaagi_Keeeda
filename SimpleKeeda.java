
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

SimpleKeeda.java is part of Dimaagi_Keeda.

    Dimaagi_Keeda is free Game based on 2048(an Android Game)BUT WITH LOT OF DIFFERENT FEATURES: you can redistribute it    and/or modify
    it under the terms of the GNU General Public License as published     by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Dimaagi_Keeda is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Dimaagi_Keeda.  If not, see <http://www.gnu.org/licenses/>.

*******************************************************************
*/





import java.util.Random;

/**
 *
 * @author vivek
 */
/**
 
  
 MODIFY IT FOR NOT MAKING 0 IN BOX WITH SEVEN DIGITS AND NOT ADDING IN THAT FURTHER
 
 **/
public class SimpleKeeda {

   static Random no;
   static int newNo,temp,gameOver=1,NoCount,Score;
   static int[][] virtualArray;
   static KeedaPanel kp;
   static String stage="",str1="",str2="";
   static int tickTockCounter=0;
   
    static int addCriteria(int x,int y){
       
       if(KeedaGUI.Ganit_Ka_Ghoda.isSelected()){
           if((x==y)){
               if(KeedaGUI.BadhaDoMuseebat.isSelected()){
               if((Integer.toString(x).length()<7)&&(Integer.toString(y).length()<7))return 1;
               else return 0;
               }
               if((Integer.toString(x).length()<7)&&(Integer.toString(y).length()<7))
               return 1;
           }
       }
       else if(KeedaGUI.Pappu_Ka_Ghoda.isSelected()){
           if((Integer.toString(x).length()==Integer.toString(y).length())){
               if(KeedaGUI.BadhaDoMuseebat.isSelected()){
               if((Integer.toString(x).length()<7))return 1;
               else return 0;
               }
               if(Integer.toString(x).length()<7)//Note:: This case is needed when on 7 digits matrix entry does not become 0
               return 1;
           }
       }
       return 0;
   }
   
    static void moveLeft(int[][] arr,int[][] flag){
        for(int curr=0;curr<arr.length;curr++){   
        int j=1;
        while(j<arr[0].length){
            if(flag[curr][j-1]==1){
                if(arr[curr][j]!=0)j++;
                else{
                    temp=j;while((j<arr.length)&&(arr[curr][j]==0))j++;
                    if((j!=arr[0].length)&&(j!=temp))
                    for(int i=0;j+i<arr[0].length;i++){gameOver=0;
                        arr[curr][temp+i]=arr[curr][j+i];flag[curr][temp+i]=flag[curr][j+i];
                        flag[curr][j+i]=0;arr[curr][j+i]=0;
                    }j=temp;j++;
                }
            }
            else if((arr[curr][j-1]!=0)){////System.out.println("arr[curr-1]!=0");
                if((arr[curr][j]!=0)&&(flag[curr][j]!=1)){////System.out.println("arr[curr]!=0");
                    if(addCriteria(arr[curr][j],arr[curr][j-1])==1){gameOver=0;
                        arr[curr][j-1]+=arr[curr][j];flag[curr][j-1]=1;if(Score<arr[curr][j-1])Score=arr[curr][j-1];
                        arr[curr][j]=0;flag[curr][j]=0;
                    }else{j++;}
                }
                else if(arr[curr][j]==0){////System.out.println("arr[curr]==0");
                    temp=j;////System.out.println("temp is"+temp);
                    while((j<arr[0].length)&&(arr[curr][j]==0)){j++;}
                    if(j!=arr[0].length){
                        if(j!=temp){////System.out.println("curr!=temp");
                            for(int i=0;(j+i)<arr[0].length;i++){gameOver=0;////System.out.println("curr+1!<arr.length");
                                arr[curr][temp+i]=arr[curr][j+i];flag[curr][j+i]=flag[curr][j+i];
                                arr[curr][j+i]=0;flag[curr][j+i]=0;////System.out.println("Inside loop");
                            }////System.out.println("outside loop");
                        }
                        j=temp;
                        if((flag[curr][j]!=1)&&(addCriteria(arr[curr][j],arr[curr][j-1]))==1){
                            arr[curr][j-1]+=arr[curr][j];flag[curr][j-1]=1;if(Score<arr[curr][j-1])Score=arr[curr][j-1];
                            arr[curr][j]=0;flag[curr][j]=0;gameOver=0;
                        }else {////System.out.println("arr[curr]!=arr[curr-1]");
                            j++;}
                    }
                }
            }
            else if(arr[curr][j-1]==0){
                
                if(arr[curr][j]!=0){////System.out.println(curr);
                    arr[curr][j-1]=arr[curr][j];flag[curr][j-1]=flag[curr][j];
                    flag[curr][j]=0;arr[curr][j]=0;gameOver=0;
                }
                else if(arr[curr][j]==0){
                    ////System.out.println("arr[curr]=0");
                    temp=j-1;
                    while((j<arr[0].length)&&(arr[curr][j]==0))j++;
                    if(j!=arr[0].length){
                        for(int i=0;i+j<arr[0].length;i++){gameOver=0;
                            arr[curr][temp+i]=arr[curr][j+i];flag[curr][i+temp]=flag[curr][j+i];
                            arr[curr][j+i]=0;flag[curr][j+i]=0;
                        }if(temp!=0)j=temp;else j=1;
                    }
                }
            }
            if((SimpleKeeda.gameOver!=1)){tickTockCounter=1;kp.createImage(kp.matrix);kp.paintScreen();}
           // //System.out.println("value of curr="+curr);
        }
        
    }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            flag[i][j]=0;
        }////System.out.println("Outside main loop");
       
    }
    
    static void moveUP(int[][] arr,int[][] flag){
      for(int j=0;j<arr[0].length;j++){  
        int curr=1;
        while(curr<arr.length){
            if(flag[curr-1][j]==1){
                if(arr[curr][j]!=0)curr++;
                else{
                    temp=curr;while((curr<arr.length)&&(arr[curr][j]==0))curr++;
                    if((curr!=arr.length)&&(curr!=temp))///---------------------------------------------------------
                    for(int i=0;curr+i<arr.length;i++){gameOver=0;
                        arr[temp+i][j]=arr[curr+i][j];flag[temp+i][j]=flag[curr+i][j];
                        flag[curr+i][j]=0;arr[curr+i][j]=0;
                    }curr=temp;curr++;
                }
            }
            else if((arr[curr-1][j]!=0)){////System.out.println("arr[curr-1]!=0");
                if((arr[curr][j]!=0)&&(flag[curr][j]!=1)){////System.out.println("arr[curr]!=0");
                    if(addCriteria(arr[curr][j],arr[curr-1][j])==1){
                        arr[curr-1][j]+=arr[curr][j];flag[curr-1][j]=1;if(Score<arr[curr-1][j])Score=arr[curr-1][j];
                        arr[curr][j]=0;flag[curr][j]=0;gameOver=0;
                    }else{curr++;}
                }
                else if(arr[curr][j]==0){////System.out.println("arr[curr]==0");
                    temp=curr;////System.out.println("temp is"+temp);
                    while((curr<arr.length)&&(arr[curr][j]==0)){curr++;}
                    if(curr!=arr.length){
                        if(curr!=temp){////System.out.println("curr!=temp");
                            for(int i=0;(curr+i)<arr.length;i++){gameOver=0;////System.out.println("curr+1!<arr.length");
                                arr[i+temp][j]=arr[i+curr][j];flag[i+temp][j]=flag[curr+i][j];
                                arr[curr+i][j]=0;flag[curr+i][j]=0;////System.out.println("Inside loop");
                            }////System.out.println("outside loop");
                        }
                        curr=temp;
                        if((flag[curr][j]!=1)&&(addCriteria(arr[curr][j],arr[curr-1][j])==1)){
                            arr[curr-1][j]+=arr[curr][j];flag[curr-1][j]=1;gameOver=0;
                            arr[curr][j]=0;flag[curr][j]=0;if(Score<arr[curr-1][j])Score=arr[curr-1][j];
                        }else {////System.out.println("arr[curr]!=arr[curr-1]");
                            curr++;}
                    }
                }
            }
            else if(arr[curr-1][j]==0){
                
                if(arr[curr][j]!=0){////System.out.println(curr);
                    arr[curr-1][j]=arr[curr][j];flag[curr-1][j]=flag[curr][j];
                    flag[curr][j]=0;arr[curr][j]=0;gameOver=0;
                }
                else if(arr[curr][j]==0){
                    ////System.out.println("arr[curr]=0");
                    temp=curr-1;
                    while((curr<arr.length)&&(arr[curr][j]==0))curr++;
                    if(curr!=arr.length){
                        for(int i=0;i+curr<arr.length;i++){gameOver=0;
                            arr[i+temp][j]=arr[curr+i][j];flag[i+temp][j]=flag[curr+i][j];
                            arr[curr+i][j]=0;flag[curr+i][j]=0;
                        }if(temp!=0)curr=temp;else curr=1;
                    }
                }
            }
        if((SimpleKeeda.gameOver!=1)){tickTockCounter=1;kp.createImage(kp.matrix);kp.paintScreen();}    
           // //System.out.println("value of curr="+curr);
        }
        
    }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            flag[i][j]=0;
        }////System.out.println("Outside main loop");
        /*for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                //System.out.print(matrix[i][j]);
            //System.out.println();
        }*/
    }
    
    static void moveDown(int[][] arr,int[][] flag){
        for(int j=0;j<arr[0].length;j++){   
        int curr=arr.length-2;
        while(curr>=0){
            if(flag[curr+1][j]==1){
                if(arr[curr][j]!=0)curr--;
                else{
                    temp=curr;while((curr>=0)&&(arr[curr][j]==0))curr--;
                    if((curr!=-1)&&(curr!=temp))
                    for(int i=0;curr-i>=0;i++){gameOver=0;
                        arr[temp-i][j]=arr[curr-i][j];flag[temp-i][j]=flag[curr-i][j];
                        flag[curr-i][j]=0;arr[curr-i][j]=0;
                    }curr=temp;curr--;
                }
            }
            else if((arr[curr+1][j]!=0)){////System.out.println("arr[curr-1]!=0");
                if((arr[curr][j]!=0)&&(flag[curr][j]!=1)){////System.out.println("arr[curr]!=0");
                    if(addCriteria(arr[curr][j],arr[curr+1][j])==1){gameOver=0;
                        arr[curr+1][j]+=arr[curr][j];flag[curr+1][j]=1;if(Score<arr[curr+1][j])Score=arr[curr+1][j];
                        arr[curr][j]=0;flag[curr][j]=0;
                    }else{curr--;}
                }
                else if(arr[curr][j]==0){////System.out.println("arr[curr]==0");
                    temp=curr;////System.out.println("temp is"+temp);
                    while((curr>=0)&&(arr[curr][j]==0)){curr--;}
                    if(curr!=-1){
                        if(curr!=temp){////System.out.println("curr!=temp");
                            for(int i=0;(curr-i)>=0;i++){gameOver=0;////System.out.println("curr+1!<arr.length");
                                arr[temp-i][j]=arr[curr-i][j];flag[temp-i][j]=flag[curr-i][j];
                                arr[curr-i][j]=0;flag[curr-i][j]=0;////System.out.println("Inside loop");
                            }////System.out.println("outside loop");
                        }
                        curr=temp;
                        if((flag[curr][j]!=1)&&(addCriteria(arr[curr][j],arr[curr+1][j])==1)){
                            arr[curr+1][j]+=arr[curr][j];flag[curr+1][j]=1;if(Score<arr[curr+1][j])Score=arr[curr+1][j];
                            arr[curr][j]=0;flag[curr][j]=0;gameOver=0;
                        }else {////System.out.println("arr[curr]!=arr[curr-1]");
                            curr--;}
                    }
                }
            }
            else if(arr[curr+1][j]==0){
                
                if(arr[curr][j]!=0){////System.out.println(curr);
                    arr[curr+1][j]=arr[curr][j];flag[curr+1][j]=flag[curr][j];
                    flag[curr][j]=0;arr[curr][j]=0;gameOver=0;
                }
                else if(arr[curr][j]==0){
                    ////System.out.println("arr[curr]=0");
                    temp=curr+1;
                    while((curr>=0)&&(arr[curr][j]==0))curr--;
                    if(curr!=-1){
                        for(int i=0;curr-i>=0;i++){gameOver=0;
                            arr[temp-i][j]=arr[curr-i][j];flag[temp-i][j]=flag[curr-i][j];
                            arr[curr-i][j]=0;flag[curr-i][j]=0;
                        }if(temp!=arr.length-1)curr=temp;else curr=arr.length-2;
                    }
                }
            }
        if((SimpleKeeda.gameOver!=1)){tickTockCounter=1;kp.createImage(kp.matrix);kp.paintScreen();}    
           // //System.out.println("value of curr="+curr);
        }
        
        
        
        
    }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            flag[i][j]=0;
        }////System.out.println("Outside main loop");
        
    }
    
    static void moveRight(int[][] arr,int[][] flag){
        
        
        for(int curr=0;curr<arr.length;curr++){   
        int j=arr[0].length-2;
        while(j>=0){
            if(flag[curr][j+1]==1){
                if(arr[curr][j]!=0)j--;
                else{
                    temp=j;while((j>=0)&&(arr[curr][j]==0))j--;
                    if((j!=-1)&&(j!=temp))
                    for(int i=0;j-i>=0;i++){gameOver=0;
                        arr[curr][temp-i]=arr[curr][j-i];flag[curr][temp-i]=flag[curr][j-i];
                        flag[curr][j-i]=0;arr[curr][j-i]=0;
                    }j=temp;j--;
                }
            }
            else if((arr[curr][j+1]!=0)){////System.out.println("arr[curr-1]!=0");
                if((arr[curr][j]!=0)&&(flag[curr][j]!=1)){////System.out.println("arr[curr]!=0");
                    if(addCriteria(arr[curr][j],arr[curr][j+1])==1){gameOver=0;
                        arr[curr][j+1]+=arr[curr][j];flag[curr][j+1]=1;if(Score<arr[curr][j+1])Score=arr[curr][j+1];
                        arr[curr][j]=0;flag[curr][j]=0;
                    }else{j--;}
                }
                else if(arr[curr][j]==0){////System.out.println("arr[curr]==0");
                    temp=j;////System.out.println("temp is"+temp);
                    while((j>=0)&&(arr[curr][j]==0)){j--;}
                    if(j!=-1){
                        if(j!=temp){gameOver=0;////System.out.println("curr!=temp");
                            for(int i=0;(j-i)>=0;i++){////System.out.println("curr+1!<arr.length");
                                arr[curr][temp-i]=arr[curr][j-i];flag[curr][j-i]=flag[curr][j-i];
                                arr[curr][j-i]=0;flag[curr][j-i]=0;////System.out.println("Inside loop");
                            }////System.out.println("outside loop");
                        }
                        j=temp;
                        if((flag[curr][j]!=1)&&(addCriteria(arr[curr][j],arr[curr][j+1])==1)){
                            arr[curr][j+1]+=arr[curr][j];flag[curr][j+1]=1;if(Score<arr[curr][j+1])Score=arr[curr][j+1];
                            arr[curr][j]=0;flag[curr][j]=0;gameOver=0;
                        }else {////System.out.println("arr[curr]!=arr[curr-1]");
                            j--;}
                    }
                }
            }
            else if(arr[curr][j+1]==0){
                
                if(arr[curr][j]!=0){////System.out.println(curr);
                    arr[curr][j+1]=arr[curr][j];flag[curr][j+1]=flag[curr][j];
                    flag[curr][j]=0;arr[curr][j]=0;gameOver=0;
                }
                else if(arr[curr][j]==0){
                    ////System.out.println("arr[curr]=0");
                    temp=j+1;
                    while((j>=0)&&(arr[curr][j]==0))j--;
                    if(j!=-1){
                        for(int i=0;j-i>=0;i++){gameOver=0;
                            arr[curr][temp-i]=arr[curr][j-i];flag[curr][temp-i]=flag[curr][j-i];
                            arr[curr][j-i]=0;flag[curr][j-i]=0;
                        }if(temp!=arr[0].length-1)j=temp;else j=arr[0].length-2;
                    }
                }
            }
        if((SimpleKeeda.gameOver!=1)){tickTockCounter=1;kp.createImage(kp.matrix);kp.paintScreen();}    
           // //System.out.println("value of curr="+curr);
        }
        
    }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            flag[i][j]=0;
        }//System.out.println("Outside main loop");
        
    }
    
    static void generate_no(int[][]matrix){
        if(KeedaGUI.Pappu_Ka_Ghoda.isSelected()){generateNoForPappu(matrix);}
        else{
     
        
            newNo=no.nextInt(6);
        if(KeedaGUI.GhisePite.isSelected()){
            if(newNo!=5)newNo=3;
            else newNo=12;
        }
        
        else if (KeedaGUI.DesiRokde.isSelected()){
            if((newNo!=5)&&(newNo!=4))newNo=10;
            else newNo=50;
        }
        
        else {
            if((newNo==0)||(newNo==1)||(newNo==2))newNo=10;
            else if((newNo==4)||(newNo==3))newNo=50;
            else newNo=100;
        }
        
            if((newNo==10)||(newNo==3))
            {NoCount++;}
            if(NoCount==30){NoCount=0;
            if(KeedaGUI.GhisePite.isSelected())newNo=12;
            else newNo=50;
            }
        }
        setMatrixNo(matrix);
    
    }
    
    static void generateNoForPappu(int[][] matrix){
        
      
        newNo=no.nextInt(9);
        if(KeedaGUI.GhisePite.isSelected()){
            if((newNo==0)||(newNo==1)||(newNo==2))newNo=11;
            else if((newNo==3)||(newNo==4)||(newNo==5))newNo=51;
            else if((newNo==6)||(newNo==7))newNo=101;
            else newNo=1001;
        }
        
        else if (KeedaGUI.DesiRokde.isSelected()){
            if((newNo==0)||(newNo==1))newNo=1;
            else if((newNo==2)||(newNo==3))newNo=5;
            else if((newNo==4)||(newNo==5)||(newNo==6)||(newNo==7))newNo=160;
            else newNo=1051;
        }
        
        else {
            if((newNo==0)||(newNo==1)&&(newNo==2))newNo=5;
            else if((newNo==5)||(newNo==3)||(newNo==4))newNo=160;
            else if((newNo==6)||(newNo==7))newNo=500;
            else newNo=1051;
        }
        
        if((newNo==5)||((newNo==11)))
            {NoCount++;}
            if(NoCount==30){NoCount=0;
            if(KeedaGUI.GhisePite.isSelected())newNo=1001;//Dushmani mein kanyadaan ke
            else newNo=1051;//Bada BONUS
            }
        
    }
    
    static void setMatrixNo(int[][] matrix){int gameover=0;
        for(int j=0;j<matrix.length;j++){
            
                if(matrix[matrix.length-1][j]==0){gameover=1;
                    matrix[matrix.length-1][j]=newNo;break;
                }
            
            
               else if(matrix[j][matrix[0].length-1]==0){gameover=1;
                    matrix[j][matrix[0].length-1]=newNo;break;
                }
            
            
               else if(matrix[0][j]==0){gameover=1;
                    matrix[0][j]=newNo;break;
                }
            
            
               else if(matrix[j][0]==0){gameover=1;
                    matrix[j][0]=newNo;break;
                }
               
            
            
        }
        if(gameover!=1){check_for_OUT(matrix);}
    }
    
    static void check_for_OUT(int[][] matrix){
        gameOver=1;
        VirtualChecking(matrix);
        
    }
    
    static void VirtualChecking(int[][] matrix){
       
        virtualArray=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<KeedaPanel.matrix[0].length;j++){
                virtualArray[i][j]=KeedaPanel.matrix[i][j];
            }
        }
       moveUP(virtualArray,KeedaPanel.flag);moveDown(virtualArray,KeedaPanel.flag);
       moveLeft(virtualArray,KeedaPanel.flag);moveRight(virtualArray,KeedaPanel.flag);
       virtualArray=null;
       if(gameOver==1){showOUT();}
    }
    
    static void showOUT(){
        //try{Thread.sleep(1000);}catch(Exception er){}
        if(KeedaPanel.key1!=null)kp.removeKeyListener(KeedaPanel.key1);
        resetMemory();
        
        KeedaPanel.GameOUT=1;
        kp.saveScores(0);
        kp.setIgnoreRepaint(false);kp.repaint();kp.resetPanel();
        
        
    }
    
    static void resetMemory(){
        virtualArray=null;gameOver=1;
        NoCount=0;
    }
   
    static void setKP(KeedaPanel kp){
        SimpleKeeda.kp=kp;
    }
    
    
}
