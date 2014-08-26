
/**********************
  *************************
        @author::Vivek Mangla
**************************
*****************************/

/*******************************************************************

AboutFrame.java is part of Dimaagi_Keeda.

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


/**
 *
 * @author vivek
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


/**
 *
 * @author vivek
 */

class AboutFrame extends JFrame implements ActionListener{
    
    static JButton Close;
    static JPanel buttonPanel;
   
    
    AboutFrame(){
       
        super("ChAmPu_N_CHaaNdnI");
       
       
    setUndecorated(true);
    setLayout(new BorderLayout());
    Container c=getContentPane();
    
    c.add(new AboutPane(),BorderLayout.CENTER);
    Close=new JButton("Close");
    buttonPanel=new JPanel();buttonPanel.add(Close);
    c.add(buttonPanel,BorderLayout.EAST);Close.addActionListener(this);
    pack();setSize(KeedaFrame.pWidth,KeedaFrame.pHeight);
    setResizable(false);setVisible(true);
    addWindowListener(
       new WindowAdapter(){
       @Override public void windowClosing(WindowEvent s){setEnabled(false);dispose();setVisible(false);}});
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==Close){setEnabled(false);setVisible(false);this.dispose();}
    }
     
    
}

class AboutPane extends JTabbedPane{

    static AboutPanel AbP1,AbP2;
    static String name;
    static String msg=""; 
    AboutPane(){
       
            AbP1=new AboutPanel();
            AbP1=new AboutPanel();
            AbP1.setLayout(new GridLayout(1,2));
            AbP1.add(new image(0));
            AbP1.add(new JScrollPane(create(0)));
            addTab(getName(0),AbP1);
            
            AbP2=new AboutPanel();
            AbP2=new AboutPanel();
            AbP2.setLayout(new GridLayout(1,2));
            AbP2.add(new image(1));
            AbP2.add(new JScrollPane(create(1)));
            addTab(getName(1),AbP2);
        
        
        
    }
    
  //-SET FONT-STYLE,SIZE,BACKGROUNDCOLOR,FOREGROUNDCOLOR  
    
     JTextArea create(int i){
    
        JTextArea jt;
        Font font;
        font = new Font(Font.SERIF, Font.BOLD, 50);
        jt=new JTextArea(getInfo(i),5,5);
        jt.setFont(font);jt.setEditable(false);
        jt.setBackground(Color.black);jt.setLineWrap(true);jt.setWrapStyleWord(true);
        jt.setForeground(Color.MAGENTA);
        return jt;
        
    }
    
     String getName(int i){name="";
    if(i==0)return "MaTheMaTiCaL_HoRsE";
    else if(i==1)return "Pappu's_HoRsE";
    else if(i==2)return "PuZZIE";
    else if(i==3)return "CHallenge";
    else return "Adventure";
        
    }
    
     String getInfo(int i){
         
         if(i==0){
             msg="FoR::MaTheMaTiCaL_HoRsEee Sada Dimaagi Keeda a TyPe Of GaMe iN WhIcH u hv To   "
                     + " maKe aS MuCh PoSsIbLe BoXeS wiTh 7 diGitS ,,ORRRrrr"
                     + "hv tO EmPtY if:: u Hv NoT SeLecTed To IncReaSe BurDen. "
                     + "In ThiS OnLy SAmE WoRds WilL AdD Up if NoNe oF ThEm iS of 7 DiGitS. "
                     + ".WithoUt IncReAsEd BurDeNn, BoXeS WiLl BE EmPtIeD OnLy WhEn 999999 oRR > ThAn 999999 iS ThErE. "
                     + " BuT It StIll CaN Be FiLlED."
                     + " MaDe oF 3 TyPeS Of NuMbErS:: "
                     + "\n1.> LoW_QuAlItY-- 3,12. "
                     + "\n2.> LoCaL_MaDe-- 10,50 UsE Ur BrAiN ." 
                     + "\n3.> HiGhEr_RaTeS--10,50,100 Nowee,OpeN Ur BRaIn HoRsE.e.@ BeCaUse I WiLl NoT LeAvE Uu."
                     + " u Hv  JuMpEd a lOT , PlAy WiTh ThEsEe."
                     + "\n"
                     
                     + "Esc Perse To LeaVe My(CrEdItS's) ScReen. "
                     + "AARAM SE KHELEN AUR SHANTI SE KHELEN !! DIMAAGI GHODA DOODAYEN??"
                     + "";
             return msg;}
         else if(i==1){
             msg="FoR::Pappu's_HoRsE Sada Dimaagi Keeda a TyPe Of GaMe iN WhIcH u hv To  "
                     + " maKe aS MuCh PoSsIbLe BoXeS wiTh 7 diGitS ,,ORRRrrr"
                     + "hv tO EmPtY if:: u Hv NoT SeLecTed To IncReaSe BurDen."
                     + "OnLy NuMbErS WiTh SaMe NuMbEr Of DiGiTs WiLl Be AdEd."
                     + ".WithoUt IncReAsEd BurDeNn,BoXeS WiLl BE EmPtIeD OnLy WhEn 999999 oRR > ThAn 999999 iS ThErE. "
                     + " BuT It StIll CaN Be FiLlED."
                     + " MaDe Of 3 TyPeS Of NuMbErS:: "
                     + "\n1.> LoW_QuAlItY--11,51,101,1001 ThEsE Ar UsDD By PaPpu To DoNaTe In KanYaa_DaaN(MaHaDaAn).."
                     + "\n11:: FoR  FrEiNdS  ."
                     + "\n51:: FoR BiG_BrO's TyPe. "
                     + "\n101:: In ReLaTiOn ."
                     + "\n1001:: VeRy LeSs & ThAt ToO FoRr EnEMIEs."
                     + ""
                     + ""
                     + "\n2.> LoCaL_MaDe-- 1,5,160,1051 UsDd By PaPu At DiFfErEnT PlAcEs://!!!??.."
                     + "\n1:: FoR GiViNg To BeGGgggaRrrs..  "
                     + "\n5:: Used of StEaL ??Fr EaTiNg ChOcLaTes and PaTee In ChIlDhOoD."
                     + "\n160:: SaMoSaa TrEaT For Frnds ."
                     + "\n1051:: PaPpu GoT SiCk_Of_WaitInG foR GetTing TheSe BoRrOwInGs FrOm hIs ss. "
                     + ""
                     + "\n3.> HiGhEr_RaTeS--5,160,500,1051--Ahh!! THeSe aRe FoR JusT EnJoYmEnT."
                     + ""
                     + "\n"
                     
                     + " Esc PreSS!! To LeAvE CrEdIt's ScReEn"
                     + "AARAM SE KHELEN AUR SHANTI SE KHELEN !! DIMAAGI GHODA DOODAYEN??";
             return msg;}
         
         
         
         return "Hey_"+i+"_YOU_ARE_SEEING_ME";
     }
    
}
