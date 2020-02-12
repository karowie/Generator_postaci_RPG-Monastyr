package generator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;




public class Generator implements ActionListener {
    //Ramki
    private static JFrame f = new JFrame("Generator postaci do gry RPG Monastyr");
    private static JPanel p = new JPanel();
    
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
    private static String[] UTP = new String[] {"Zbieranie informacji","Jezdziectwo","Post. ze zwierz.","Teologia","Historia","Naprawa","Opatrywanie","Przetrwanie","Ukrywanie","Plotki","Etykieta"}; //Tablica nazw umiejetnosci z  prawej
    private static ArrayList<JLabel> IPL = new ArrayList<JLabel>(); //Tworzy liste labeli na imie postaci
    private static ArrayList<JLabel> RMLL = new ArrayList<JLabel>(); //Tworzy liste labeli na Zwarcie, ruch  lewe
    private static ArrayList<JLabel> RMLP = new ArrayList<JLabel>(); //Tworzy liste labeli na Zwarcie, ruch  prawe
    private static ArrayList<JLabel> WO = new ArrayList<JLabel>(); //Tworzy liste labeli na informacje i wpisy
    private static ArrayList<JButton> WB = new ArrayList<JButton>(); //Tworzy button do wczytania postaci
    private static String[] MLTL = new String[] {"Zwarcie i atak w ruchu","Miecz: atak"}; //Tablica nazw lewej strony labeli miecza
    private static String[] MLTP = new String[] {"Ruch: obrona","Miecz: obrona"}; //Tablica nazw prawej strony labeli miecza
    private static String[] RLTL = new String[] {"Zwarcie i atak w ruchu","Rapier: atak"}; //Tablica nazw lewej strony labeli rapiera
    private static String[] RLTP = new String[] {"Ruch: obrona","Rapier: obrona"}; //Tablica nazw prawej strony labeli rapiera
    private static JTextArea input = new JTextArea();
    
    
    
    /**
     *
     */
    Generator(){ 
        
        try {
            //Ustawienie okna
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        p.setBackground(Color.LIGHT_GRAY);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Scrollbar scrollB1 = new Scrollbar(Scrollbar.VERTICAL, 0, 40, 0, 100);
        //f.add(scrollB1,BorderLayout.EAST);
        f.setVisible(true);
        f.setSize(660,720);
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
        miecz.addActionListener(this);
        widok.addActionListener(this);      
        
        
        newButtons(WB,1,25,100,300,30,265); //Tworzy Button na wczytanie posatci
        WB.get(0).setText("Wczytaj");
        WB.get(0).addActionListener(this);
        
        newLabels(WO,2,25,300,200,30,200);//Tworzy puste Labele na komunikaty
        newButtons(WGTB,8,25,150,30,30,20); //Tworzy puste buttony na nazwy współczynników głównych
        Named(WGTB,WGT); //Wpisuje nazwy umiejetnosci wspolczynnikow głównych do buttonów
        newButtonsN(GWB,8,25,50,30,30,250);//Tworzy puste buttony na wartości współczynników głównych
        newButtons(RTB,1,25,150,30,30,450); //Tworzy puste buttony na nazwy ran
        RTB.get(0).setText("Rany");
        newButtons(RB,1,25,50,30,30,320); //Tworzy puste buttony na wartości ran
        newButtons(WPTB,5,25,150,90,30,450); //Tworzy puste buttony na nazwy współczynników pomocniczych
        Named(WPTB,WPT); //Wpisuje nazwy umiejetnosci wspolczynnikow pomocniczych do buttonów
        newButtonsN(PWB,5,25,50,90,30,320); //Tworzy puste buttony na wartości współczynników pomocniczych
        newLabels(IPL,1,25,150,0,0,250); // Tworzy label z imieniem postaci
        newLabels(RMLL,2,25,150,270,120,20); //Tworzy dwa labele z lewej do akcji miecza i rapiera
        newLabels(RMLP,2,25,150,270,120,450); //Tworzy dwa labele z prawej do akcji miecza i rapiera
        newButtons(AZTB,2,25,150,300,30,20); //Tworzy puste buttony na nazwy akcji zwarcia
        Named(AZTB,AZT); //Wpisuje nazwy zwarcia do buttonow
        newButtonsN(AZB,2,25,50,300,30,250); //Buttony na wartosc akcji zwarcia
        newButtons(ARTBL,1,25,150,360,30,20); //Tworzy button na nazwę ruchu po lewej
        ARTBL.get(0).setText("Ruch: kroki"); //Wpisuje tekst do buttonu ruchu po lewej
        newButtonsN(ARBL,1,25,50,360,30,250); //Buttony na wartosc akcjiruchu po lewej
        newButtons(ARTB,3,25,150,300,30,450); // Tworzy buttony na nazwę akcji ruchu (Po pprawej)
        Named(ARTB,ART); //Wpisuje nazwy ruchu do buttonow
        newButtonsN(ARB,3,25,50,300,30,320); //Buttony na wartosc akcji ruchu po prawej
        newButtons(ARATB,7,25,150,420,30,20); //Tworzy puste buttony na nazwy akcji rapiera atak
        Named(ARATB,ARAT); //Wpisuje nazwy akacji rapiera atak do buttonow
        newButtonsN(ARAB,7,25,50,420,30,250); //Buttony na wartosc akcji rapiera atak
        newButtons(AROTB,4,25,150,420,30,450); //Tworzy puste buttony na nazwy akcji rapiera obrona
        Named(AROTB,AROT); //Wpisuje nazwy akacji rapiera obrona do buttonow
        newButtonsN(AROB,4,25,50,420,30,320); //Buttony na wartosc akcji rapiera obrona
        newButtons(AMATB,4,25,150,420,30,20); //Tworzy puste buttony na nazwy akcji miecza atak
        Named(AMATB,AMAT); //Wpisuje nazwy akacji miecza atak do buttonow
        newButtonsN(AMAB,4,25,50,420,30,250); //Buttony na wartosc akcji miecza atak
        newButtons(AMOTB,3,25,150,420,30,450); //Tworzy puste buttony na nazwy akcji miecza obrona
        Named(AMOTB,AMOT); //Wpisuje nazwy akacji miecz obrona do buttonow
        newButtonsN(AMOB,3,25,50,420,30,320); //Buttony na wartosc akcji miecza obrona
        newButtons(UTBL,11,25,150,270,30,20); //Tworzy puste buttony umeijetnosci po lewej
        Named(UTBL,UTL); //Nazwy umeijetnosci po lewej
        newButtonsN(UBL,11,25,50,270,30,250); //Buttony na wartosc umiejetnosci po lewej
        newButtons(UTBP,11,25,150,270,30,450); //Tworzy puste buttony umeijetnosci po lewej
        Named(UTBP,UTP); //nazwy umiejetnosci po prawej
        newButtonsN(UBP,11,25,50,270,30,320); //Buttony na wartosc umiejetnosci po prawej
        input.setBounds(100,250,460,25);
        input.setVisible(false);
        p.add(input);
        
        WO.get(0).setText("Wylosuj lub wczytaj swoja postac.");
        WO.get(0).setVisible(true);    
    }
   
           static  ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String text = ((JButton) e.getSource()).getText();
                ((JButton) e.getSource()).setText(Integer.toString(Integer.parseInt(text)-1));
                
            }
        }
        
        
    };
//                  static  ActionListener listenerT = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() instanceof JButton) {
//                String text = ((JButton) e.getSource()).getText();
//                ((JButton) e.getSource()).setText(Integer.toString(Integer.parseInt(text)-1));
//                
//            }
//        }
        
        
  //  };
    
    
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
            LabelVisibility(WO,false);
            LabelVisibility(RMLL,false);
            LabelVisibility(RMLP,false);
            input.setVisible(false);
        
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
            AllButtonsUnvisible();
            LabelVisibility(WO,false);
            LabelVisibility(RMLL,false);
            LabelVisibility(RMLP,false);
            LabelVisibility(IPL,false);
                    
            WO.get(0).setText("Podaj ścieżkę do pliku z postacią: ");
            WO.get(0).setVisible(true);
            WB.get(0).setVisible(true);
            input.setVisible(true);
            
        }else if(e.getSource()==WB.get(0)){
            String WczytPath = input.getText();
            File wczyt=new File(WczytPath);
            if(wczyt.exists()){    
                WP.wczytaj(wczyt);
                AllButtonsUnvisible();
                LabelVisibility(WO,false);
                LabelVisibility(RMLL,false);
                LabelVisibility(RMLP,false);
                input.setVisible(false);
        
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
                RB.get(0).setText(Integer.toString(WP.Rany));

                MainButtonsVisible();
                JOptionPane.showMessageDialog(null,"Postac zostala wczytana!","Wczytywanie",JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Cos poszlo nie tak. Sprwadz poprawnosc wpisanej sciezki.","Wczytywanie",JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource()==zapisz)
        {
            if(!WP.imie.equals(""))
            {
                try{
                    WP.zapis();
                    JOptionPane.showMessageDialog(null,"Postac zapisana!","Zapisywanie",JOptionPane.PLAIN_MESSAGE);
                }catch(Exception error){
                    JOptionPane.showMessageDialog(null,"Cos poszlo nie tak. Nie udalo sie zapisac postaci.","Zapisywanie",JOptionPane.ERROR_MESSAGE);
                }
            }else
            {
                JOptionPane.showMessageDialog(null,"Najpierw musisz wylosowac albo wczytac postac.","Zapisywanie",JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(e.getSource()==umiejetnosci)
        {
            if(!WP.imie.equals("")){
             AllButtonsUnvisible();
             MainButtonsVisible();
             LabelVisibility(RMLL,false);
             LabelVisibility(RMLP,false);
             LabelVisibility(WO,false);
             Visibility(UTBL,true);
             Visibility(UTBP,true);
             Visibility(UBL,true);
             Visibility(UBP,true);
             input.setVisible(false);
            }
            else{
             JOptionPane.showMessageDialog(null,"Najpierw musisz wylosowac postac.","Widok",JOptionPane.ERROR_MESSAGE);   
            
            }
            
        }else if(e.getSource()==rapier)
        {
            if(!WP.imie.equals("")){
            AllButtonsUnvisible();
            MainButtonsVisible();
            input.setVisible(false);
        
            NamedLabels(RMLL,RLTL);
            NamedLabels(RMLP,RLTP);
        
            LabelVisibility(RMLL,true);
            LabelVisibility(RMLP,true);
            LabelVisibility(WO,false);
        
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
        }
            else{
             JOptionPane.showMessageDialog(null,"Najpierw musisz wylosowac postac.","Widok",JOptionPane.ERROR_MESSAGE);   
            
            }
            
        }else if(e.getSource()==miecz)
        {
            if(!WP.imie.equals("")){
            AllButtonsUnvisible();
            MainButtonsVisible();
            input.setVisible(false);
        
            NamedLabels(RMLL,MLTL);
            NamedLabels(RMLP,MLTP);
        
            LabelVisibility(RMLL,true);
            LabelVisibility(RMLP,true);
            LabelVisibility(WO,false);
        
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
          
            else{
             JOptionPane.showMessageDialog(null,"Najpierw musisz wylosowac postac.","Widok",JOptionPane.ERROR_MESSAGE);   
            
            }
            
        } 
        else if(e.getSource()==RB.get(0)){
              
                WP.Rany(true);
                
        
                WP.Rany--;
                setButtonText(GWB,WP.WspolczynnikiGlowne);
                setButtonText(PWB,WP.WspolczynnikiPomocnicze);
                setButtonText(AZB,WP.AkcjeZwarcie);
                setButtonText(ARAB,WP.AkcjeRapierAtak);
                setButtonText(AROB,WP.AkcjeRapierObrona);
                setButtonText(AMAB,WP.AkcjeMieczAtak);
                setButtonText(AMOB,WP.AkcjeMieczObrona);
                ARBL.get(0).setText(Integer.toString(WP.AkcjeRuch[0]));
                for(int i=1; i<4;i++)
                    ARB.get(i-1).setText(Integer.toString(WP.AkcjeRuch[i]));
                RB.get(0).setText(Integer.toString(WP.Rany));

                
                
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
    
    private static void newButtonsN(ArrayList<JButton> a, int n, int height, int width, int above, int under, int left) {  //Funkcja tworząca nowe buttony i dodająca je do tablicy
        for(int i=0;i<n;i++)
        {
            a.add(new javax.swing.JButton());
            a.get(i).setBounds(left,above+i*under,width,height);
            p.add(a.get(i));
            a.get(i).setVisible(false);
            a.get(i).addActionListener(listener);
        
    
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
    Visibility(WB ,false);
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
    }
    
    
    
    
}
