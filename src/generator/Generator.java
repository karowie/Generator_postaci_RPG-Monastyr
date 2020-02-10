package generator;

import java.awt.BorderLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class Generator implements ActionListener {
    //Ramki
    private static JFrame f = new JFrame("Generator postaci do gry RPG Monastyr");
    private static JPanel p =new JPanel();
    
    //Wszystko związane z menu
    private static JMenuBar mb;;
    private static JMenu postac;  
    private static JMenu widok;
    private static JMenuItem losuj;
    private static JMenuItem wczytaj;  
    private static JMenuItem zapisz;
    private static JMenuItem umiejetnosci;  
    private static JMenuItem rapier;
    private static JMenuItem miecz;
     
    
    //Tworzenie postaci
    Postac WP = new Postac(); 
    
    //Buttony i Labele
    private static ArrayList<JButton> GWB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów współczynników głównych
    private static ArrayList<JButton> PWB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów współczynników pomocniczych
    private static ArrayList<JButton> RB = new ArrayList<JButton>(); //Tworzy tablicę małego buttona rany
    private static ArrayList<JButton> AZB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów Akcji zwarcie
    private static ArrayList<JButton> ARB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów akcji ruchu po prawej
    private static ArrayList<JButton> ARBL = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów akcji ruchu po lewej BUTTON RUCH KROKI
    private static ArrayList<JButton> ARAB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów akcji rapier atak
    private static ArrayList<JButton> AROB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów akcji rapier obrona
    private static ArrayList<JButton> AMAB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów akcji miecz atak
    private static ArrayList<JButton> AMOB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów akcji miecz obrona
    private static ArrayList<JButton> UBL = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów umiejetnosci z lewej
    private static ArrayList<JButton> UBP = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów umiejetnosci z prawej
    private static ArrayList<JButton> RTB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów rany
    private static ArrayList<JButton> WGTB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów współczynników głównych
    private static ArrayList<JButton> WPTB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów współczynników pomocniczych
    private static ArrayList<JButton> AZTB = new ArrayList<JButton>(); //Tworzy tablicę małych buttonów Akcji zwarcie
    private static ArrayList<JButton> ARTB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów akcji ruchu po prawej
    private static ArrayList<JButton> ARTBL = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów akcji ruchu po lewej BUTTON RUCH KROKI
    private static ArrayList<JButton> ARATB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów akcji rapier atak
    private static ArrayList<JButton> AROTB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów akcji rapier obrona
    private static ArrayList<JButton> AMATB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów akcji miecz atak
    private static ArrayList<JButton> AMOTB = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów akcji miecz obrona
    private static ArrayList<JButton> UTBL = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów umiejetnosci z lewej
    private static ArrayList<JButton> UTBP = new ArrayList<JButton>(); //Tworzy tablicę dużych buttonów umiejetnosci z prawej
    private static String[] WGT = new String[] {"Budowa","Zrecznosc","Spryt","Spostrzegawczosc","Wiarygodnosc","Opanowanie","Wytrwalosc","Wiara"}; // Tablica nazw współczynników głównych
    private static String[] WPT = new String[] {"Refleks","Autorytet","Wiedza ogolna","Fechtunek","Strzelanie"}; //Tablica nazw współczynników pomocniczych
    private static String[] AZT = new String[] {"Zwarcie: atak", "Zwarcie: obrona"}; //Tablica nazw akcji zwarcia
    private static String[] ART = new String[] {"Praca nóg", "Unik","Odksok"}; //Tablica nazw akci ruchu
    private static String[] ARAT = new String[] {"Pchniecie proste","Ciecie zwykle","Zwod","Ponowienie","Wypad","Pchniecie pozorne","Zbicie"}; //Tablica nazw akcji rapier atak
    private static String[] AROT = new String[] {"Zaslona II","Zaslona I","Riposta","Wyprzedzenie"}; //Tablica nazw akcji rapier obrona
    private static String[] AMAT = new String[] {"Ciecie zwykle","Ciecie z zamachu", "Ponowienie","Zbicie miecza"}; //Tablica nazw akcji miecz atak
    private static String[] AMOT = new String[] {"Odbicie","Zaslona","Wyprzedzenie"}; //Tablica nazw akcji miecz obrona
    private static String[] UTL = new String[] {"Atletyka","Wysportowanie","Rapier","Bron bitewna","Pistolet","Muszkiet","W. magiczna","Okultyzm","Blef","Czytanie emocji","Nasłuch. i wypatr."}; //Tablica nazw umiejetnosci z lewej
    private static String[] UTP = new String[] {"Zbieranie infor.","Jezdziectwo","Post. ze zwierz.","Teologia","Historia","Naprawa","Opatrywanie","Przetrwanie","Ukrywanie","Plotki","Etykieta"}; //Tablica nazw umiejetnosci z  prawej
    private static ArrayList<JLabel> IPL = new ArrayList<JLabel>(); //Tworzy liste labeli na imie postaci
    private static ArrayList<JLabel> RMLL = new ArrayList<JLabel>(); //Tworzy liste labeli na Zwarcie, ruch  lewe
    private static ArrayList<JLabel> RMLP = new ArrayList<JLabel>(); //Tworzy liste labeli na Zwarcie, ruch  prawe
    private static String[] MLTL = new String[] {"Zwarcie i atak w ruchu","Miecz: atak"}; //Tablica nazw lewej strony labeli miecza
    private static String[] MLTP = new String[] {"Ruch: obrona","Miecz: obrona"}; //Tablica nazw prawej strony labeli miecza
    private static String[] RLTL = new String[] {"Zwarcie i atak w ruchu","Rapier: atak"}; //Tablica nazw lewej strony labeli rapiera
    private static String[] RLTP = new String[] {"Ruch: obrona","Rapier: obrona"}; //Tablica nazw prawej strony labeli rapiera
    
    /**
     *
     */
    Generator(){ 
        
        //Ustawienie okna
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Scrollbar scrollB1 = new Scrollbar(Scrollbar.VERTICAL, 0, 40, 0, 100);
        f.add(scrollB1,BorderLayout.EAST);
        f.setVisible(true);
        f.setSize(700,700);
        f.add(p);
        p.setLayout(null);
   
        //Menu
        mb =new JMenuBar();
        postac=new JMenu("Postac");  
        widok=new JMenu("Widok"); 
        losuj=new JMenuItem("Losuj postac");  
        wczytaj=new JMenuItem("Wczytaj postac");  
        zapisz=new JMenuItem("Zapisz postac");  
        umiejetnosci=new JMenuItem("Umiejetnosci");  
        rapier=new JMenuItem("Rapier"); 
        miecz=new JMenuItem("Miecz");
        postac.add(losuj); postac.add(wczytaj); postac.add(zapisz);  
        widok.add(umiejetnosci); widok.add(rapier); widok.add(miecz);
        mb.add(postac); mb.add(widok); 
        f.setJMenuBar(mb); 
       
        
        
        
        //Potrzebne do actionPerformed (wykonuje się przy kliknięciu)
        losuj.addActionListener(this);
        wczytaj.addActionListener(this);
        zapisz.addActionListener(this);
        umiejetnosci.addActionListener(this);
        rapier.addActionListener(this);
        widok.addActionListener(this);
        
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {    
        if(e.getSource()==losuj)
        {
            try {
            WP.losujpostac();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
            AllButtonsUnvisible();
            LabelVisibility(RMLL,false);
            LabelVisibility(RMLP,false);
        
            IPL.get(0).setVisible(true);
            IPL.get(0).setText(WP.imie);
            setButtonText(GWB,WP.WspolczynnikiGlowne);
            setButtonText(PWB,WP.WspolczynnikiPomocnicze);
            setButtonText(AZB,WP.AkcjeZwarcie);
            setButtonText(ARAB,WP.AkcjeRapierAtak);
            setButtonText(AROB,WP.AkcjeRapierObrona);
            setButtonText(AMAB,WP.AkcjeMieczAtak);
            setButtonText(AMOB,WP.AkcjeMieczObrona);
            for(int i=0; i<11;i++)
                UBL.get(i).setText(Integer.toString(WP.Umiejetnosci[i]));
            for(int i=11; i<22;i++)
                UBP.get(i-11).setText(Integer.toString(WP.Umiejetnosci[i]));
            ARBL.get(0).setText(Integer.toString(WP.AkcjeRuch[0]));
            for(int i=1; i<4;i++)
                ARB.get(i-1).setText(Integer.toString(WP.AkcjeRuch[i]));
            RB.get(0).setText("0");

            MainButtonsVisible();
        }else if(e.getSource()==wczytaj)
        {
            
        }else if(e.getSource()==zapisz)
        {
            try{
                WP.zapis();
                JOptionPane.showMessageDialog(null,"Postac zapisana!","Zapisywanie",JOptionPane.PLAIN_MESSAGE);
            }catch(Exception error){
                JOptionPane.showMessageDialog(null,"Cos poszlo nie tak. Nie udalo sie zapisac postaci.","Zapisywanie",JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(e.getSource()==umiejetnosci)
        {
            AllButtonsUnvisible();
            MainButtonsVisible();
            LabelVisibility(RMLL,false);
            LabelVisibility(RMLP,false);
            Visibility(UTBL,true);
            Visibility(UTBP,true);
            Visibility(UBL,true);
            Visibility(UBP,true);
            
        }else if(e.getSource()==rapier)
        {
            AllButtonsUnvisible();
            MainButtonsVisible();
        
            NamedLabels(RMLL,RLTL);
            NamedLabels(RMLP,RLTP);
        
            LabelVisibility(RMLL,true);
            LabelVisibility(RMLP,true);
        
            Visibility(AZB,true);
            Visibility(ARBL,true);
            Visibility(ARB,true);
            Visibility(AZTB,true);
            Visibility(ARTBL,true);
            Visibility(ARTB,true);
            Visibility(ARATB,true);
            Visibility(ARAB,true);
            Visibility(AROTB,true);
            Visibility(AROB,true);
            
        }else if(e.getSource()==miecz)
        {
            AllButtonsUnvisible();
            MainButtonsVisible();
        
            NamedLabels(RMLL,MLTL);
            NamedLabels(RMLP,MLTP);
        
            LabelVisibility(RMLL,true);
            LabelVisibility(RMLP,true);
        
            Visibility(AZB,true);
            Visibility(ARBL,true);
            Visibility(ARB,true);
            Visibility(AZTB,true);
            Visibility(ARTBL,true);
            Visibility(ARTB,true);
            Visibility(AMATB,true);
            Visibility(AMAB,true);
            Visibility(AMOTB,true);
            Visibility(AMOB,true);
        }

}     
    
    private static void newButtons(ArrayList<JButton> a, int n, int height, int width, int above, int under, int left) {  //Funkcja tworząca nowe buttony i dodająca je do tablicy
        for(int i=0;i<n;i++)
        {
            a.add(new javax.swing.JButton());
            a.get(i).setBounds(left,above+i*under,width,height);
            p.add(a.get(i));
            a.get(i).setVisible(false);
        }
    }
    
    private static void newLabels(ArrayList<JLabel> a, int n, int height, int width, int above, int under, int left) {  //Funkcja tworząca nowe buttony i dodająca je do tablicy
        for(int i=0;i<n;i++)
        {
            a.add(new javax.swing.JLabel());
            a.get(i).setBounds(left,above+i*under,width,height);
            p.add(a.get(i));
            a.get(i).setVisible(false);

        }
    }
    private static void Named(ArrayList<JButton> a, String[] s)
    {
        int dl = a.size();
        int dt = s.length;
        
        if(dl == dt)
        {
            for (int i=0;i<dl;i++)
            {
                a.get(i).setText(s[i]);
            }
        }
    }
    
    private static void NamedLabels(ArrayList<JLabel> a, String[] s)
    {
        int dl = a.size();
        int dt = s.length;
        
        if(dl == dt)
        {
            for (int i=0;i<dl;i++)
            {
                a.get(i).setText(s[i]);
            }
        }
    }
    
    private static void setButtonText(ArrayList<JButton> a, int[] l){
        for(int i=0; i<a.size();i++)
            a.get(i).setText(Integer.toString(l[i]));
    }
    
    private static void LabelVisibility(ArrayList<JLabel> a, Boolean vision) // Funkcja ustawiająca widoczność labeli z list
    {
         for (int i=0;i<a.size();i++)
            a.get(i).setVisible(vision);   
    }

    
    private static void Visibility(ArrayList<JButton> a, Boolean vision) // Funkcja ustawiająca widoczność buttonów z list
    {
        for (int i=0;i<a.size();i++)
            a.get(i).setVisible(vision);   
    }
    
    private static void AllButtonsUnvisible() //Funkcja, która wszytskie buttony robi niewidoczne
    {
    Visibility(GWB,false);
    Visibility(PWB,false);
    Visibility(RB ,false);
    Visibility(AZB,false);
    Visibility(ARB,false);
    Visibility(ARBL,false);
    Visibility(ARAB,false);
    Visibility(AROB,false);
    Visibility(AMAB,false);
    Visibility(AMOB,false);
    Visibility(UBL,false);
    Visibility(UBP,false);
    Visibility(RTB,false);
    Visibility(WGTB,false);
    Visibility(WPTB,false);
    Visibility(AZTB,false);
    Visibility(ARTB,false);
    Visibility(ARTBL,false);
    Visibility(ARATB,false);
    Visibility(AROTB,false);
    Visibility(AMATB,false);
    Visibility(AMOTB,false);
    Visibility(UTBL,false);
    Visibility(UTBP ,false);
    }
    
    private static void MainButtonsVisible() //Funkcja która robi glowne buttony widoczne
    {
        Visibility(GWB,true);
        Visibility(WGTB,true);
        Visibility(PWB,true);
        Visibility(WPTB,true);
        Visibility(RB,true);
        Visibility(RTB,true);
    }

    
    
    
    public static void main(String[] args) {
        
        new Generator();
        newButtons(WGTB,8,50,150,30,55,20); //Tworzy puste buttony na nazwy współczynników głównych
        Named(WGTB,WGT); //Wpisuje nazwy umiejetnosci wspolczynnikow głównych do buttonów
        newButtons(GWB,8,50,50,30,55,250);//Tworzy puste buttony na wartości współczynników głównych
        newButtons(RTB,1,50,150,30,55,450); //Tworzy puste buttony na nazwy ran
        RTB.get(0).setText("Rany");
        newButtons(RB,1,50,50,30,55,320); //Tworzy puste buttony na wartości ran
        newButtons(WPTB,5,50,150,140,55,450); //Tworzy puste buttony na nazwy współczynników pomocniczych
        Named(WPTB,WPT); //Wpisuje nazwy umiejetnosci wspolczynnikow pomocniczych do buttonów
        newButtons(PWB,5,50,50,140,55,320); //Tworzy puste buttony na wartości współczynników pomocniczych
        newLabels(IPL,1,30,150,0,0,250); // Tworzy label z imieniem postaci
        newLabels(RMLL,2,30,150,470,200,20); //Tworzy dwa labele z lewej do akcji miecza i rapiera
        newLabels(RMLP,2,30,150,470,200,450); //Tworzy dwa labele z prawej do akcji miecza i rapiera
        newButtons(AZTB,2,50,150,505,55,20); //Tworzy puste buttony na nazwy akcji zwarcia
        Named(AZTB,AZT); //Wpisuje nazwy zwarcia do buttonow
        newButtons(AZB,2,50,50,505,55,250); //Buttony na wartosc akcji zwarcia
        newButtons(ARTBL,1,50,150,615,55,20); //Tworzy button na nazwę ruchu po lewej
        ARTBL.get(0).setText("Ruch: kroki"); //Wpisuje tekst do buttonu ruchu po lewej
        newButtons(ARBL,1,50,50,615,55,250); //Buttony na wartosc akcjiruchu po lewej
        newButtons(ARTB,3,50,150,505,55,450); // Tworzy buttony na nazwę akcji ruchu (Po pprawej)
        Named(ARTB,ART); //Wpisuje nazwy ruchu do buttonow
        newButtons(ARB,3,50,50,505,55,320); //Buttony na wartosc akcji ruchu po prawej
        newButtons(ARATB,7,50,150,705,55,20); //Tworzy puste buttony na nazwy akcji rapiera atak
        Named(ARATB,ARAT); //Wpisuje nazwy akacji rapiera atak do buttonow
        newButtons(ARAB,7,50,50,705,55,250); //Buttony na wartosc akcji rapiera atak
        newButtons(AROTB,4,50,150,705,55,450); //Tworzy puste buttony na nazwy akcji rapiera obrona
        Named(AROTB,AROT); //Wpisuje nazwy akacji rapiera obrona do buttonow
        newButtons(AROB,4,50,50,705,55,320); //Buttony na wartosc akcji rapiera obrona
        newButtons(AMATB,4,50,150,705,55,20); //Tworzy puste buttony na nazwy akcji miecza atak
        Named(AMATB,AMAT); //Wpisuje nazwy akacji miecza atak do buttonow
        newButtons(AMAB,4,50,50,705,55,250); //Buttony na wartosc akcji miecza atak
        newButtons(AMOTB,3,50,150,705,55,450); //Tworzy puste buttony na nazwy akcji miecza obrona
        Named(AMOTB,AMOT); //Wpisuje nazwy akacji miecz obrona do buttonow
        newButtons(AMOB,3,50,50,705,55,320); //Buttony na wartosc akcji miecza obrona
        newButtons(UTBL,11,50,150,470,55,20); //Tworzy puste buttony umeijetnosci po lewej
        Named(UTBL,UTL); //Nazwy umeijetnosci po lewej
        newButtons(UBL,11,50,50,470,55,250); //Buttony na wartosc umiejetnosci po lewej
        newButtons(UTBP,11,50,150,470,55,450); //Tworzy puste buttony umeijetnosci po lewej
        Named(UTBP,UTP); //nazwy umiejetnosci po prawej
        newButtons(UBP,11,50,50,470,55,320); //Buttony na wartosc umiejetnosci po prawej 
    }
    
    
    
    
}
