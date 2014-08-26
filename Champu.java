

/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

Champu.java is part of Dimaagi_Keeda.

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


import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author vivek
 */
public class Champu //extends Applet
{
 
    static int x=100,y=100,dir=2;

  /*  
    @Override
    public void paint(Graphics g){
        int count=0;
        while(true){g.setColor(Color.white);
            g.fillRect(0,0,200,200);
        addChampu((Graphics2D)g,1024,768);count++;
        if(count%10==0)dir+=1;if(dir==5)dir=1;
        try{Thread.currentThread().sleep(100);}catch(Exception er){}
        }
    }
    
    */
    
   static void resCd(){
       Champu.x=KeedaPanel.pWidth/2;Champu.y=KeedaPanel.pHeight/2;
   }
    
    static void addChampu(Graphics2D g2d,int Width,int Height){
     
        if((x<Width)&&(y<Height)&&(x>0)&&(y>0)){
        fixCord();
        addBody(g2d);
        addWheel(g2d);
        addDhuan(g2d);
        }
        else
        {
            SimpleKeeda.showOUT();
        }
    }
    
    static void fixCord(){
       if(dir==2){x+=5;}
       else if(dir==3){y+=5;}
       else if(dir==4){x-=5;}
       else{y-=5;}
       
    }
    
    static void addBody(Graphics2D g2d){
        g2d.setColor(Color.red);
        g2d.fillRect(x, y, 10, 10);
        if(dir==1){g2d.fillRect(x, y+15, 10, 10);
            g2d.setColor(Color.black);
            g2d.fillRect(x+4, y+10, 3,5);}
        else if(dir==2){g2d.fillRect(x-15, y, 10, 10);
            g2d.setColor(Color.black);
            g2d.fillRect(x-5, y+4, 5,3);}
        else if(dir==3){g2d.fillRect(x, y-15, 10, 10);
            g2d.setColor(Color.black);
            g2d.fillRect(x+4, y-5, 3,5);}
        else{
            g2d.fillRect(x+15, y, 10, 10);
            g2d.setColor(Color.black);
            g2d.fillRect(x+10, y+4, 5,3);
        }
    }
    
    static void addWheel(Graphics2D g2d){g2d.setColor(Color.black);
        if(dir==2)
        {
            g2d.fillOval(x, y+10, 4, 4);g2d.fillOval(x+5, y+10, 4, 4);
            g2d.fillOval(x-15, y+10, 4, 4);g2d.fillOval(x-10, y+10, 4, 4);
        }
        else if(dir==3)
        {
            g2d.fillOval(x-4, y, 4, 4);g2d.fillOval(x-4, y+5, 4, 4);
            g2d.fillOval(x-4, y-15, 4, 4);g2d.fillOval(x-4, y-10, 4, 4);
        }
        else if(dir==4)
        {
            g2d.fillOval(x, y+10, 4, 4);g2d.fillOval(x+5, y+10, 4, 4);
            g2d.fillOval(x+15, y+10, 4, 4);g2d.fillOval(x+20, y+10, 4, 4);
        }
        else if(dir==1)
        {
            g2d.fillOval(x-4, y, 4, 4);g2d.fillOval(x-4, y+5, 4, 4);
            g2d.fillOval(x-4, y+15, 4, 4);g2d.fillOval(x-4, y+20, 4, 4);
        }
        
    }
    
    static void addDhuan(Graphics2D g2d){g2d.setColor(Color.black);
        if(dir==2){
            g2d.fillRect(x+8, y-2, 2, 2);g2d.fillOval(x+4, y-5, 4, 4);
        }
        else if(dir==3){
            g2d.fillRect(x+10, y+8, 2, 2);g2d.fillOval(x+12, y+4, 4, 4);
        }
        else if(dir==4){
            g2d.fillRect(x, y-2, 2, 2);g2d.fillOval(x+2, y-6, 4, 4);
        }
        else {
            g2d.fillRect(x+10, y, 2, 2);g2d.fillOval(x+11, y+2, 4, 4);
        }
        
    }
    
   
    
}
