

/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

KeedaGUI.java is part of Dimaagi_Keeda.

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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author vivek
 */

public class KeedaGUI implements ActionListener,ItemListener{
    static JMenuBar jmb;//-------------------------------------------INCLUDE INTRO,HELP,ABOUT.....-------------------------------------
    static JMenu Game,Noise,High_Scores,Theme,Help,Museebat;
    //static JMenu Stage,Player;
    static JMenu matrix,Akshar,Ghoda;
    static JMenuItem Play,Quit,HighScores,About,Developer;
    //static JRadioButtonMenuItem Single_Player,Multi_Player;
    static JCheckBoxMenuItem Music,BadhaDoMuseebat;
    //static ButtonGroup Players_play,Stages_stage;
    //static JRadioButtonMenuItem Stage1,Stage2,Stage3;
    static ButtonGroup matrixG,ThemeG,AksharG,GhodaG;
    static JRadioButtonMenuItem _7x7,_5x5,_10x10,Bageecha,Gulabo,Haldi,GhisePite,DesiRokde,UncheDaam;
    static JRadioButtonMenuItem Ganit_Ka_Ghoda,Pappu_Ka_Ghoda;
    static AboutFrame w;
    static DeveloperPanel dp;
    static KeedaPanel keedapanel;
    static KeedaFrame kf;
    
    KeedaGUI(KeedaPanel keedapanel){
    this.keedapanel=keedapanel;
     jmb=new JMenuBar();
         
           
            Game=new JMenu("I");
          //  Stage=new JMenu("Stage");
            Akshar=new JMenu("NumBeRR");
            matrix=new JMenu("CrEaTiOnS");
            Theme=new JMenu("CoLoRs");
            Noise=new JMenu("Shor");
          //  Player=new JMenu("Player");
            High_Scores=new JMenu("OneSiGhT");
            Help=new JMenu("HeLp");
            Ghoda=new JMenu("My_HoRsEeaa");
            Museebat=new JMenu("BuRdEn");
            //Game------------------------------------------------------------------------
            Game.add(Play=new JMenuItem("TeSt_My_HoRsE"));Play.addActionListener(this);
            Game.add(Quit=new JMenuItem("WiThOuT_HoRsE"));Quit.addActionListener(this);
            jmb.add(Game);
            //------------------------------------------------------------------------------------
            //--Akshar---------------------------------------------------------------------------
            Akshar.add(GhisePite=new JRadioButtonMenuItem("LoW_QuAlItY"));GhisePite.addActionListener(this);
            Akshar.add(DesiRokde=new JRadioButtonMenuItem("LoCal_MaDe"));DesiRokde.addActionListener(this);
            Akshar.add(UncheDaam=new JRadioButtonMenuItem("HiGhEr_RaTeS",true));UncheDaam.addActionListener(this);
            AksharG=new ButtonGroup();
            AksharG.add(GhisePite);
            AksharG.add(DesiRokde);
            AksharG.add(UncheDaam);
            jmb.add(Akshar);
            //----------------------------------------------------------------------------------
            //Stage--------------------------------------------------------------------------------
            matrix.add(_5x5=new JRadioButtonMenuItem("TiNy",true));_5x5.addActionListener(this);
            matrix.add(_7x7=new JRadioButtonMenuItem("In_BeTwEeN"));_7x7.addActionListener(this);
            matrix.add(_10x10=new JRadioButtonMenuItem("JuSt_LaRgE"));_10x10.addActionListener(this);
            matrixG=new ButtonGroup();
            matrixG.add(_5x5);
            matrixG.add(_7x7);
            matrixG.add(_10x10);
            
            jmb.add(matrix);
            /* Stage.add(Stage1=new JRadioButtonMenuItem("Practice",true));Stage1.addActionListener(this);
            Stage.add(Stage2=new JRadioButtonMenuItem("Random",new ImageIcon("aqua.gif")));Stage2.addActionListener(this);
            Stage.add(Stage3=new JRadioButtonMenuItem("Get_UP"));Stage3.addActionListener(this);
            Stages_stage=new ButtonGroup();
            Stages_stage.add(Stage1);
            Stages_stage.add(Stage2);
            Stages_stage.add(Stage3);
            jmb.add(Stage);
            *///--------------------------------------------------------------------------------------
            //---Ghoda---------------------------------------------------------------------------
            Ghoda.add(Ganit_Ka_Ghoda=new JRadioButtonMenuItem("MaTheMaTiCaL_HoRsE",true));Ganit_Ka_Ghoda.addActionListener(this);
            Ghoda.add(Pappu_Ka_Ghoda=new JRadioButtonMenuItem("Pappu's_HoRsE",true));Pappu_Ka_Ghoda.addActionListener(this);
            GhodaG=new ButtonGroup();
            GhodaG.add(Ganit_Ka_Ghoda);
            GhodaG.add(Pappu_Ka_Ghoda);
            jmb.add(Ghoda);
            //----------------------------------------------------------------------------------------
            //---Museebat-----------------------------------------------------------------------------
            Museebat.add(BadhaDoMuseebat=new JCheckBoxMenuItem("InCrEaSe"));BadhaDoMuseebat.addActionListener(this);
            jmb.add(Museebat);
            //----------------------------------------------------------------------------------------
            //-------Theme----------------------------------------------------------------------------
            Theme.add(Bageecha=new JRadioButtonMenuItem("GrEeNy"));Bageecha.addActionListener(this);
            Theme.add(Gulabo=new JRadioButtonMenuItem("PiNkYy"));Gulabo.addActionListener(this);
            Theme.add(Haldi=new JRadioButtonMenuItem("SkY_HoNkEr",true));Haldi.addActionListener(this);
            ThemeG=new ButtonGroup();
            ThemeG.add(Bageecha);
            ThemeG.add(Gulabo);
            ThemeG.add(Haldi);
            jmb.add(Theme);
            //----------------------------------------------------------------------------------------
            //Noise----------------------------------------------------------------------------------
            Noise.add(Music=new JCheckBoxMenuItem("BacKWaRd's_PuRr_PuRr"));Music.addItemListener(this);
            jmb.add(Noise);
            //----------------------------------------------------------------------------------------
            //Player----------------------------------------------------------------------------------
            /*Player.add(Single_Player=new JRadioButtonMenuItem("Single",true));Single_Player.addActionListener(this);
            Player.add(Multi_Player=new JRadioButtonMenuItem("Doubles"));Multi_Player.addActionListener(this);
            Players_play=new ButtonGroup();
            Players_play.add(Single_Player);
            Players_play.add(Multi_Player);
            jmb.add(Player);
            *///---------------------------------------------------------------------
            //High_Scores---------------------------------------------------------
            High_Scores.add(HighScores=new JMenuItem("Dimaagi_Keede"));HighScores.addActionListener(this);
            jmb.add(High_Scores);
            //--------------------------------------------------------------------
            //------Help-----------------------------------------------------
            Help.add(About=new JMenuItem("HeLpFuL_InFo"));About.addActionListener(this);
            Help.add(Developer=new JMenuItem("CrEdItSs"));Developer.addActionListener(this);
            jmb.add(Help);
            //--------------------------------------------------------------------
    
    
    }

    public void actionPerformed(ActionEvent ue){
      if(ue.getSource()==Play){
                                  if(Music.isSelected()){kf.playMusic();}    
                           //remove(panel1);
                           reset();
                           keedapanel.ActivatePanel();                            
                            }
      else if(ue.getSource()==Quit){System.exit(0);}
      else if(ue.getSource()==HighScores){Scores.retrieve(6);
      }
      else if(ue.getSource()==About){
         w=new AboutFrame();
                                    }
        else if(ue.getSource()==Developer){
          dp=new DeveloperPanel();  
            
            
        }
                                             }

    @Override
   public void itemStateChanged(ItemEvent i){}
    
   void Activate(){
       jmb.setEnabled(true);KeedaGUI.jmb.setVisible(true);
   }
   
   void reset(){
       KeedaGUI.jmb.setEnabled(false);
       KeedaGUI.jmb.setVisible(false);
   }
   
   static void setKF(KeedaFrame kf){KeedaGUI.kf=kf;}
   
}
