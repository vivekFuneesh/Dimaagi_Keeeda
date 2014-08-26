

/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

KeedaFrame.java is part of Dimaagi_Keeda.

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



import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author vivek
 */


public class KeedaFrame extends JFrame implements Runnable {
    
    static KeedaFrame kf;
    static KeedaPanel kp;
    static KeedaGUI kg;
    static int pWidth,pHeight;
    private File sound;
    private File music;
    private static AudioClip p1;
    private Thread musicThread;
     public static void main(String[] arg){
        
        kf=new KeedaFrame();
    }
    
     KeedaFrame(){
    super("ChAmPu_N_CHaaNdnI");
       
    
    setResizable(false);
    calculateSizes(); 
    setResizable(true);   
    Container c=getContentPane();
    kp=new KeedaPanel(pWidth,pHeight);
    SimpleKeeda.setKP(kp);KeedaGUI.setKF(this);
    kg=new KeedaGUI(kp);setUndecorated(true);
    c.add(kp,BorderLayout.CENTER); 
   // c.add(new JLabel("I am South"),BorderLayout.SOUTH); 
    pack();
    setResizable(false);
    setJMenuBar(KeedaGUI.jmb);
    kp.resetPanel();
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //System.out.println(pWidth+" "+pHeight);
    }

     private void calculateSizes(){
    
        GraphicsConfiguration gc=getGraphicsConfiguration();
        Rectangle screenRect=gc.getBounds();
        //Toolkit tk=Toolkit.getDefaultToolkit();
        //Insets desktopInsets=tk.getScreenInsets(gc);
        //Insets frameInsets=getInsets();//System.out.println(frameInsets);
        pWidth=screenRect.width;;//-(desktopInsets.left+desktopInsets.right)-(frameInsets.left+frameInsets.right);
        pHeight=screenRect.height;//-(desktopInsets.bottom+desktopInsets.top)-(frameInsets.bottom+frameInsets.top);
        
                                 }
     
    
        
      void playMusic(){
    
        musicThread=null;
        musicThread=new Thread(this);
        musicThread.start();
     
                     }
    @Override
     public void run() {
        try{music=new File("Noise/music.wav");
    p1=java.applet.Applet.newAudioClip(music.toURI().toURL());
    if(p1!=null){p1.loop();}
    }catch(Exception er){//System.out.println("MUSIC_FILE_ERROR::"+er);
        }
    }

    static void stopMusic(){
        if(p1!=null)p1.stop();
        
                           }
    
}
