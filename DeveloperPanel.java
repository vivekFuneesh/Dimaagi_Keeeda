

/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

DeveloperPanel.java is part of Dimaagi_Keeda.

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
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;






/**
 *
 * @author vivek
 */

 public class DeveloperPanel extends JFrame{
    
    

    
    
    public  DeveloperPanel(){super("ChAmPu_N_CHaaNdnI");

    
        setLayout(new BorderLayout());
        getContentPane().add(new dpPanel(),BorderLayout.CENTER);
        getContentPane().add(new JLabel("Coder+Designer+Tester"),BorderLayout.SOUTH);
        setUndecorated(true); 
        pack();setResizable(false);setIgnoreRepaint(true);
        
        setVisible(true);
        
        addWindowListener(new WindowAdapter(){@Override public void windowClosing(WindowEvent s){
       
        setEnabled(false);dispose();setVisible(false);}});
        addKeyListener(new KeyAdapter(){
            @Override
        public void keyPressed(KeyEvent ke){
        if(ke.getKeyCode()==KeyEvent.VK_ESCAPE){
                          setEnabled(false);dispose();setVisible(false);
        }
        }
        });
    
    
    }

public static void main(String[] arg){new DeveloperPanel();}

}
class dpPanel extends JPanel implements Runnable{

    Graphics2D g2d;static byte count=0;
    static String name="Developer::BRaInLeSss$$_VIVEK(BIG_BRO)",name1="Music::EHMA Pizzicato";
    static int curr_x=200,curr_y=100,pre_x=199,pre_y=99;
    Image buffer=null;
    static Thread thread;
    
    public dpPanel(){
        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(KeedaFrame.pWidth,KeedaFrame.pHeight));
                      thread=new Thread(this);
                      thread.start();
                    }
    
    
    @Override
    public void run(){
        
      while(true){
        
          move_name();
          createImage();
          paintScreen();
          try{Thread.sleep(100);}catch(Exception er){}
      
      }
    
    }
    
    void createImage(){
        if(buffer==null)buffer=createImage(KeedaFrame.pWidth,KeedaFrame.pHeight);
        
        if(buffer==null){//System.out.println("Still NUll");
            return;}
        else
            g2d=(Graphics2D)buffer.getGraphics();
        g2d.fillRect(0,0,KeedaFrame.pWidth,KeedaFrame.pHeight);  
        
         
        if(count==0){
        g2d.setPaint(new GradientPaint(50,100,Color.yellow,60,20,Color.blue,true)); count=1;
        }else{
        g2d.setPaint(new GradientPaint(50,10,Color.green,60,20,Color.red,true));count=0;
        }   
        Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 50);
        g2d.setFont(font);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.drawString(name, curr_x, curr_y);
        g2d.drawString(name1,100,100);
        
    
    }
    
    public void paintScreen(){
        
        Graphics g;
        
    try{
        
        
        
        
        g=this.getGraphics();
        
        if((g!=null)&&(buffer!=null))g.drawImage(buffer, 0,0,null);
        Toolkit.getDefaultToolkit().sync();
        if(g!=null)g.dispose();
        
    }catch(Exception err){} 
        
        }
    
    static void move_name(){
       
                                 if(curr_x<pre_x){curr_x-=10;pre_x-=10;}
                                 else if(curr_x>pre_x){curr_x+=10;pre_x+=10;}
                                 if(curr_y<pre_y){curr_y-=10;pre_y-=10;}
                                 else if(curr_y>pre_y){curr_y+=10;pre_y+=10;}
                                 
                                 if(curr_x>KeedaFrame.pWidth-400){curr_x=pre_x-1;}
                                 else if(curr_x<0){curr_x=pre_x+1;}
                                 if(curr_y>KeedaFrame.pHeight-100){curr_y=pre_y-1;}
                                 else if(curr_y<100){curr_y=pre_y+1;}
                                 
                                         
                                      }

    

}
