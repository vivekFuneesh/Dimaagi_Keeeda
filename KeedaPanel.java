
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

KeedaPanel.java is part of Dimaagi_Keeda.

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


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vivek
 */

public class KeedaPanel extends JPanel implements Runnable{
    
    static int[][] flag;
    static int[][] matrix;
    static int[] syncFlag;
    static int  direction,fontSize=25,boxCount,boxFlag,GameOUT=0,syncTurn=0;
    static Graphics rdg;
    static Graphics2D rdg2;
    Image rdi=null;
    static int blockWidth,blockHeight,pWidth,pHeight;
    static String stagestage="";
    static KeyAdapter key1;
    Thread t;
    //-------------------------SLEEPING--TIME--VARIABLES-------------------------------------
    static long beforetime,aftertime,timediff,sleeptime,oversleeptime,excess;
    static int skip=0;
    static long period=(long)Math.pow(10, 9)/20;
  //--------------------------------------------------------------------  
    
    KeedaPanel(int pWidth,int pHeight){
        KeedaPanel.pWidth=pWidth;KeedaPanel.pHeight=pHeight;
        blockHeight=pHeight/10;blockWidth=pWidth/10;
        //System.out.println(blockWidth+"  "+blockHeight);
        setPreferredSize(new Dimension(pWidth,pHeight));
        setLayout(new BorderLayout());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.BLACK);
        Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 40);
        g.setFont(font);
        FontMetrics fm=getFontMetrics(font);
        
        String str="Dimaagi_Keeda";
        setForeground(Color.red);
        g.drawString(str, (pWidth-fm.stringWidth(str))/2,pHeight/2);
            
        
    }
    
    void resetPanel(){Champu.x=pWidth/2;Champu.y=pHeight/2;Champu.dir=2;
        matrix=null;SimpleKeeda.resetMemory();
        flag=null;KeedaFrame.stopMusic();
        stagestage="";rdi=null;rdg2=null;rdg=null;
        if(key1!=null)removeKeyListener(key1);
        GameOUT=1;
    }
    
    void ActivatePanel(){GameOUT=0;t=null;
        SimpleKeeda.resetMemory();boxFlag=boxCount=0;
        setIgnoreRepaint(true);
        if(KeedaGUI._5x5.isSelected())matrix=new int[5][5];
        if(KeedaGUI._7x7.isSelected())matrix=new int[7][7];
        if(KeedaGUI._10x10.isSelected())matrix=new int[10][10];
        SimpleKeeda.Score=0;
        flag=new int[matrix.length][matrix[0].length];
        SimpleKeeda.no=new Random();
        SimpleKeeda.generate_no(matrix);
        stagestage="";rdi=null;rdg2=null;rdg=null;
        syncFlag=new int[2];syncFlag[0]=syncFlag[1]=0;
        setFocusable(true);
        requestFocusInWindow();
        processKeyEvent();
        t=new Thread(this);
        t.start();
        
    }
  
    @Override
    public void run(){try{
        beforetime=System.nanoTime();
        
        while(GameOUT==0){
            
            syncFlag[0]=1;syncTurn=1;
            while(true){if((syncFlag[1]!=1)||(syncTurn!=1))break;else System.out.print("");}
            
            if(GameOUT!=1){
               // System.out.println("Inside run matrix="+matrix+"GameOUT="+GameOUT);
            createImage(matrix);paintScreen();
            }
            aftertime=System.nanoTime();
          timediff=aftertime-beforetime;
         // System.out.println("time_difference::::::::"+timediff);
          sleeptime=period -timediff-oversleeptime;//System.out.println(timediff);
          if(sleeptime>0){//System.out.println(">0"); 
          try{ Thread.sleep(sleeptime/1000000L);}catch(InterruptedException e){}
          oversleeptime=(System.nanoTime()-aftertime)-sleeptime;}
          else{//System.out.println("it is <0");
              excess-=sleeptime;
              oversleeptime=0;
              
          
          
          while((excess>period)&&(skip<5)&&(GameOUT!=1)){//System.out.println("SKIPPING_PAINTING");
              excess-=period;
              
              skip++;
          }
          }
          beforetime=System.nanoTime();
            if(GameOUT==0)
            syncFlag[0]=0;
        }
        
        
    }catch(Exception err){}
    
    }
    
    void processKeyEvent(){
               
               
        this.addKeyListener(key1=new KeyAdapter(){
           
            @Override
           public void keyPressed(KeyEvent ke){////System.out.println("Inside addKeyListener's KeyPressed");
               syncFlag[1]=1;
               syncTurn=0;
               while(true){if((syncFlag[0]!=1)||(syncTurn!=0))break;else System.out.print("");}
               if(key1!=null)removeKeyListener(key1);
               int y=ke.getKeyCode();
               switch(y){
                   
                   case KeyEvent.VK_ESCAPE:{setIgnoreRepaint(false);if(key1!=null)removeKeyListener(key1);
                   if(KeedaGUI.BadhaDoMuseebat.isSelected()){checkForBoxCount(matrix);}else if(boxFlag==1)boxCount++;
                   saveScores(0);KeedaGUI.jmb.setVisible(true);KeedaGUI.jmb.setEnabled(true);
                   repaint();resetPanel();GameOUT=1;break;}
                   
                   case KeyEvent.VK_UP:{direction=1;Champu.dir=1;if(!KeedaGUI.BadhaDoMuseebat.isSelected())Champu.resCd();
                      try{SimpleKeeda.moveUP(matrix, flag);check_for_WINNING(matrix);
                      if(KeedaGUI.BadhaDoMuseebat.isSelected()){checkForBoxCount(matrix);}else if(boxFlag==1)boxCount++;
                      SimpleKeeda.generate_no(matrix);}catch(Exception er){
                      //JOptionPane.showMessageDialog(null,"Game_Finished");resetPanel();
                      }
                       
                       break;
                   }
                   case KeyEvent.VK_DOWN:{direction=3;Champu.dir=3;if(!KeedaGUI.BadhaDoMuseebat.isSelected())Champu.resCd();
                       try{SimpleKeeda.moveDown(matrix, flag);check_for_WINNING(matrix);
                       if(KeedaGUI.BadhaDoMuseebat.isSelected()){checkForBoxCount(matrix);}else if(boxFlag==1)boxCount++;
                       SimpleKeeda.generate_no(matrix);
                       }catch(Exception er){
                      //JOptionPane.showMessageDialog(null,"Game_Finished");resetPanel();
                      }
                       break;
                   }
                   case KeyEvent.VK_LEFT:{direction=4;Champu.dir=4;if(!KeedaGUI.BadhaDoMuseebat.isSelected())Champu.resCd();
                       try{SimpleKeeda.moveLeft(matrix, flag);check_for_WINNING(matrix);
                       if(KeedaGUI.BadhaDoMuseebat.isSelected()){checkForBoxCount(matrix);}else if(boxFlag==1)boxCount++;
                       SimpleKeeda.generate_no(matrix);
                       }catch(Exception er){
                      //JOptionPane.showMessageDialog(null,"Game_Finished");resetPanel();
                      }
                       break;
                   }
                   case KeyEvent.VK_RIGHT:{direction=2;Champu.dir=2;if(!KeedaGUI.BadhaDoMuseebat.isSelected())Champu.resCd();
                       try{SimpleKeeda.moveRight(matrix, flag);check_for_WINNING(matrix);
                       if(KeedaGUI.BadhaDoMuseebat.isSelected()){checkForBoxCount(matrix);}else if(boxFlag==1)boxCount++;
                       SimpleKeeda.generate_no(matrix);
                       }catch(Exception er){
                      //JOptionPane.showMessageDialog(null,"Game_Finished");resetPanel();
                      }
                       break;
                   }    
                   default:{}
        }
                  if((SimpleKeeda.gameOver!=1)&&(y!=KeyEvent.VK_ESCAPE)){
                      createImage(matrix);paintScreen();boxFlag=0;
                  }
              syncFlag[1]=0;if(y!=KeyEvent.VK_ESCAPE)processKeyEvent();
           }
        });
    }
    
     void createImage(int[][] matrix){//System.out.println("create Image");
   // if(matrix==null)System.out.println("Inside Image matrix="+matrix+"GameOUT="+GameOUT);
        if(rdi==null)rdi=createImage(pWidth,pHeight);
        if(rdi==null){System.out.println("Still NULL");
            return;
        }
            rdg=this.getGraphics();rdg2=(Graphics2D)rdg;
            rdg2=(Graphics2D)rdi.getGraphics();
       String str="";
        if(KeedaGUI.Bageecha.isSelected()){rdg2.setPaint(new GradientPaint(50,100,Color.GREEN,60,20,Color.BLACK,true));}
        else if(KeedaGUI.Gulabo.isSelected())rdg2.setPaint(new GradientPaint(50,100,Color.MAGENTA,60,20,Color.BLACK,true));
        else rdg2.setPaint(new GradientPaint(50,100,Color.CYAN,60,20,Color.BLACK,true));
        rdg2.fill(new Rectangle2D.Double(0,0,pWidth,pHeight));
        
   // if(matrix==null)System.out.println("Inside Image matrix="+matrix+"GameOUT="+GameOUT);   
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            str=Integer.toString(matrix[i][j]);
            if((str.length()==4))rdg2.setColor(Color.GREEN);
            else if((str.length()==5))rdg2.setColor(Color.red); 
            else if(str.length()==6)rdg2.setColor(Color.blue);
            else if((str.length()>=7))rdg2.setColor(Color.pink);
            
            else rdg2.setColor(Color.black);
            
            rdg2.fillRect(j*blockWidth+5, i*blockHeight+5, blockWidth-10, blockHeight-10);
        }
    }   
    
       
       
            Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
            rdg2.setFont(font);
            FontMetrics fm=getFontMetrics(font);
        
        
        int xCord=0,yCord=0;
        
        //if(KeedaGUI.Bageecha.isSelected()){
        rdg2.setColor(Color.white);//}
        //    else if(KeedaGUI.Gulabo.isSelected())rdg2.setColor(Color.white);
          //  else rdg2.setColor(Color.WHITE);
         
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
            str=Integer.toString(matrix[i][j]);
            if(str.length()<4)fontSize=40;
            else if((str.length()==4)||(str.length()==5))fontSize=25;
            else if(str.length()==6)fontSize=20;
            if(KeedaGUI.BadhaDoMuseebat.isSelected()){
               if(str.length()>=7)fontSize=17;   
            }
            font=null;fm=null;
            font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
            rdg2.setFont(font);
            fm=getFontMetrics(font);
            xCord=(j*blockWidth+5)+(blockWidth-10-fm.stringWidth(str))/2;
            yCord=(i*blockHeight+5)+(fm.getAscent()+(blockHeight-10-(fm.getAscent()+fm.getDescent()))/2);
            if(str.length()>=7){
                if(!KeedaGUI.BadhaDoMuseebat.isSelected())
                {matrix[i][j]=0;boxFlag=1;}
            }
            if(matrix[i][j]==0)str="";
            rdg2.drawString(str, xCord,yCord);
            }
        }
        
        if(SimpleKeeda.tickTockCounter==0){Champu.addChampu(rdg2, pWidth, pHeight);
        }
       // try{Thread.sleep(100);}catch(Exception er){}
        
        SimpleKeeda.tickTockCounter=0;
    }
    
    void paintScreen(){Graphics g;//System.out.println("Inside paintScreen()");
    try{
        g=this.getGraphics();
        if((g!=null)&&(rdi!=null)){
                g.drawImage(rdi, 0, 0, null);}
        Toolkit.getDefaultToolkit().sync();
        if(g!=null)g.dispose();
    //System.out.println("Outside paintScreen");
    }catch(Exception error){//System.out.println(error);}
    
    }
    
    
}

    void check_for_WINNING(int[][] matrix){
        int count=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            { 
                if(KeedaGUI.BadhaDoMuseebat.isSelected()){
                         if(Integer.toString(matrix[i][j]).length()<7){count=1;break;}
                }
                else if(matrix[i][j]!=0){count=1;break;}
                
            }
        }
        if(count==0){SimpleKeeda.gameOver=1;
            saveScores(1);
            JOptionPane.showMessageDialog(null,"U Ar Really Head Of Brain!!ACCcEpT iTtt");
            resetPanel();
            setIgnoreRepaint(false);repaint();
        }
        
    }
    
    static void saveScores(int count){
        
        
        try{//KeedaGUI.jmb.setVisible(false);
            String name11="PLAYER_1",stage="";
            if(KeedaGUI.Ganit_Ka_Ghoda.isSelected()){
        if((KeedaGUI.GhisePite.isSelected()))stage=",WiTh MaTheMaTiCaL_HoRsE anD LoW_QuAlItY";
        else if((KeedaGUI.DesiRokde.isSelected()))stage=",WiTh MaTheMaTiCaL_HoRsE anD  LoCal_MaDe";
        else if((KeedaGUI.UncheDaam.isSelected()))stage=",WiTh MaTheMaTiCaL_HoRsE anD  HiGhEr_RaTeS";
            }
            else if(KeedaGUI.Pappu_Ka_Ghoda.isSelected()){
        if((KeedaGUI.GhisePite.isSelected()))stage=",WiTh Pappu's_HoRsE buT LoW_QuAlItY";
        else if((KeedaGUI.DesiRokde.isSelected()))stage=",WiTh Pappu's_HoRsE buT  LoCal_MaDe";
        else if((KeedaGUI.UncheDaam.isSelected()))stage=",WiTh Pappu's_HoRsE buT HiGhEr_RaTeS";
            }
        if(count==1)SimpleKeeda.Score=9999999;
        else if((SimpleKeeda.Score>=1000000)&&(count==0))SimpleKeeda.Score=999999+boxCount;
        name11="Keeda_1";//SimpleKeeda.Score=9002;
       // System.out.println(name11);
        name11=JOptionPane.showInputDialog("Ank ::"+SimpleKeeda.Score+"\n MaKeRr Dimaagi_Keede_'s_Namee::",name11);
       // System.out.println(name11);
        if(name11==null)name11="Player";
       // System.out.println(SimpleKeeda.stage+"thus usus in paint_out");
        Scores.write(name11, (int) SimpleKeeda.Score,stage);
        }catch(Exception er){JOptionPane.showMessageDialog(null,er);}
        KeedaGUI.jmb.setEnabled(true);KeedaGUI.jmb.setVisible(true);
    }
    
    static void checkForBoxCount(int[][] matrix){
        boxCount=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]>=1000000)boxCount++;
            }
        }
    }
    
    
}
