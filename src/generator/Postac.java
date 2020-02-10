package generator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class Postac {
	
    String imie="";
    int SumaWspolczynnikowGlownych;
    int Rany = 0;
    int[] WspolczynnikiGlowne= new int[8];
    int[] WspolczynnikiPomocnicze = new int[5];
    int[] Umiejetnosci = new int[22];
    int[] AkcjeRuch = new int[4];
    int[] AkcjeZwarcie = new int[2];
    int[] AkcjeRapierAtak = new int[7];
    int[] AkcjeRapierObrona = new int[4];
    int[] AkcjeMieczAtak = new int [4];
    int[] AkcjeMieczObrona = new int[3];
    Random generator= new Random();
	 
    public void losujpostac() throws FileNotFoundException 
    {
        //name of this creature
        int plec= generator.nextInt(2);
        String[] meskieimiona = new String[2000];
        String[] damskieimiona = new String[2000];
        
        if(plec==0) {
            int m=0;
            try {
            File meskie = new File("imionam.txt");
            BufferedReader br = new BufferedReader(new FileReader(meskie));
            String input;
            while ((input = br.readLine()) != null) {
                meskieimiona[m]=input;
                m++;
                }
            br.close();
            } catch (IOException ex) {
                Logger.getLogger(Postac.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            int losowaniem =(int)(Math.round(Math.random()*(m-1)));
            this.imie=meskieimiona[losowaniem];
   	}
   	else {
            int k=0;
            try {
            File damskie=new File("imionak.txt");
            BufferedReader br = new BufferedReader(new FileReader(damskie));
            String input;
            while ((input = br.readLine()) != null) {
                damskieimiona[k]=input;
                k++;
                }
            br.close();
            } catch (IOException ex) {
                Logger.getLogger(Postac.class.getName()).log(Level.SEVERE, null, ex);
            }
	int losowanied =(int)(Math.round(Math.random()*(k-1)));
	this.imie=damskieimiona[losowanied];
   	}
   	 
   	 //main coefficients
   	for(int i=0;i<this.WspolczynnikiGlowne.length;i++) {
            this.WspolczynnikiGlowne[i] = generator.nextInt(14)+6;
            SumaWspolczynnikowGlownych += WspolczynnikiGlowne[i];
   	}
   	 
   	//auxiliary coefficients
   	WspolczynnikiPomocnicze[0]=(int)(WspolczynnikiGlowne[1]+WspolczynnikiGlowne[3]+WspolczynnikiGlowne[5])/3;
   	WspolczynnikiPomocnicze[1]=(int)(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[4]+WspolczynnikiGlowne[7])/3;
   	WspolczynnikiPomocnicze[2]=20;
   	WspolczynnikiPomocnicze[3]=(int)(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[1]+WspolczynnikiGlowne[2])/3;
   	WspolczynnikiPomocnicze[4]=(int)(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[3]+WspolczynnikiGlowne[5])/3;
   	 
   	 //auxiliary coefficients without faith
   	int SumaUmiejetnosci=8;
   	for(int i = 0;i<22;i++) {
            if(i<4) Umiejetnosci[i]=2;
            else {
                Umiejetnosci[i]=1;
   		SumaUmiejetnosci++;
            }
   	}

        while(SumaUmiejetnosci<=(int)(SumaWspolczynnikowGlownych/2)) {
            int los = generator.nextInt(22);
            Umiejetnosci[los]++;
            SumaUmiejetnosci++;
   	}
   	 
   	 //determination of combat actions	
   	AkcjeRuch[0] = WspolczynnikiPomocnicze[3] - 10;
        AkcjeRuch[1] = WspolczynnikiPomocnicze[3] - 9;
        AkcjeRuch[2] = WspolczynnikiPomocnicze[3] - 12;
        AkcjeRuch[3] = (int)(WspolczynnikiPomocnicze[3]/3)+4;

        for(int i=0;i<Umiejetnosci[1];i++) {
            int los = generator.nextInt(4);
            AkcjeRuch[los]++;
        }
        
       //movements 
        AkcjeRapierAtak[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
        AkcjeRapierAtak[1] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
        AkcjeRapierAtak[2] = WspolczynnikiPomocnicze[3] -15;
        AkcjeRapierAtak[3] = (int)(WspolczynnikiPomocnicze[3] / 2) - 7;
        AkcjeRapierAtak[4] = WspolczynnikiPomocnicze[3] -12;
        AkcjeRapierAtak[2] = WspolczynnikiPomocnicze[3] -8;
        AkcjeRapierAtak[5] = (int)(WspolczynnikiPomocnicze[3] / 3) - 1;

        AkcjeRapierObrona[0] = (int)(WspolczynnikiPomocnicze[3]/2)-2;
        AkcjeRapierObrona[1] = (int)(WspolczynnikiPomocnicze[3]/2)-2;
        AkcjeRapierObrona[2] = (int)(WspolczynnikiPomocnicze[3]/2)-5;
        AkcjeRapierObrona[3] = WspolczynnikiPomocnicze[3]-18;

        for(int i=0;i<Umiejetnosci[2]*3;i++) {
            int los= generator.nextInt(11);
            if(los<=6) AkcjeRapierAtak[los]++;
            else {
                los=los-7;
                AkcjeRapierObrona[los]++;
        }
        }
      //rapier
        AkcjeMieczAtak[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 7;
        AkcjeMieczAtak[1] = WspolczynnikiPomocnicze[3] - 17;
        AkcjeMieczAtak[2] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
        AkcjeMieczAtak[3] = (int)(WspolczynnikiPomocnicze[3] / 3) - 3;

        AkcjeMieczObrona[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 4;
        AkcjeMieczObrona[1] = (int)(WspolczynnikiPomocnicze[3] / 2) - 4;
        AkcjeMieczObrona[2] = WspolczynnikiPomocnicze[3] - 20;

        for(int i=0;i<Umiejetnosci[3]/2;i++) {
            int los = generator.nextInt(7);
            if(los<4) AkcjeMieczAtak[los]++;
            else {
                los=los-4;
       		AkcjeMieczObrona[los]++;
            }
        }
      //sword  
        AkcjeZwarcie[0] = (int)(WspolczynnikiPomocnicze[3] / 2) - 5;
        AkcjeZwarcie[1] = (int)(WspolczynnikiPomocnicze[3] / 2) - 3;

        for(int i=0;i<Umiejetnosci[0];i++) {
            int los = generator.nextInt(2);
            AkcjeZwarcie[los]++;
        }
    }
public void wyswietlpostac() {
    System.out.println(imie);
    System.out.println(SumaWspolczynnikowGlownych);
    System.out.println(Rany);
    for(int i=0;i< 8;i++) {
	System.out.println(WspolczynnikiGlowne[i]);
    }
    for(int i=0;i<5 ;i++) {
	System.out.println(WspolczynnikiPomocnicze[i]);
    }
    for(int i=0;i< 22;i++) {
	System.out.println(Umiejetnosci[i]);
    }
    for(int i=0;i< 4;i++) {
	System.out.println(AkcjeRuch[i]);
    }
    for(int i=0;i<2 ;i++) {
	System.out.println(AkcjeZwarcie[i]);
    }
    for(int i=0;i< 7;i++) {
	System.out.println(AkcjeRapierAtak[i]);
    }
    for(int i=0;i< 4;i++) {
	System.out.println(AkcjeRapierObrona[i]);
    }
    for(int i=0;i<4 ;i++) {
	
	System.out.println(AkcjeMieczAtak[i]);
    }
    for(int i=0;i<3 ;i++) {
	System.out.println(AkcjeMieczObrona[i]);
    }
      
    }
//healing or hurting
public void Rany(Boolean ranka) {
		
    if(ranka==false) {
	for(int i=0;i<3;i++) {
            AkcjeZwarcie[i]++;
	}
	for(int i=0;i<4;i++) {
            AkcjeMieczObrona[i]++;
	}
	for(int i=0;i<5;i++) {
            AkcjeRuch[i]++;
            AkcjeRapierObrona[i]++;
            AkcjeMieczAtak[i]++;
	}
	for(int i=0;i<6;i++) {
            WspolczynnikiPomocnicze[i]++;
	}
	for(int i=0;i<8;i++) {
            AkcjeRapierAtak[i]++;
	}
	for(int i=0;i<9;i++) {
            WspolczynnikiGlowne[i]++;
	}

    }
    else {
        for(int i=0;i<3;i++) {
            AkcjeZwarcie[i]--;
	}
	for(int i=0;i<4;i++) {
            AkcjeMieczObrona[i]--;
	}
	for(int i=0;i<5;i++) {
            AkcjeRuch[i]--;
            AkcjeRapierObrona[i]--;
            AkcjeMieczAtak[i]--;
	}
	for(int i=0;i<6;i++) {
            WspolczynnikiPomocnicze[i]--;
	}
	for(int i=0;i<8;i++) {
            AkcjeRapierAtak[i]--;
	}
	for(int i=0;i<9;i++) {
            WspolczynnikiGlowne[i]--;
	}
    }
    }
	
//refreshing auxiliary coefficients
    public void odswiez() {
        WspolczynnikiPomocnicze[0]=(int)(WspolczynnikiGlowne[1]+WspolczynnikiGlowne[3]+WspolczynnikiGlowne[5])/3;
	WspolczynnikiPomocnicze[1]=(int)(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[4]+WspolczynnikiGlowne[7])/3;
	WspolczynnikiPomocnicze[3]=(int)(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[1]+WspolczynnikiGlowne[2])/3;
	WspolczynnikiPomocnicze[4]=(int)(WspolczynnikiGlowne[0]+WspolczynnikiGlowne[3]+WspolczynnikiGlowne[5])/3;
    }
	

//SAvE YOUR CHARACTER! NEW IMPOSSIBLE OPTION! ONLY HERE XD
    public void zapis() {
	try {
            String path = "zapisanapostac."+" "+ this.imie +".txt";
            PrintStream zapis = new PrintStream(path);
            zapis.println(imie);
            zapis.println(SumaWspolczynnikowGlownych);
            zapis.println(Rany);
            for(int i=0;i< 8;i++) {
                zapis.println(WspolczynnikiGlowne[i]);
            }
            for(int i=0;i<4 ;i++) {
		zapis.println(WspolczynnikiPomocnicze[i]);
            }
            for(int i=0;i< 22;i++) {
		zapis.println(Umiejetnosci[i]);
            }
            for(int i=0;i< 4;i++) {
		zapis.println(AkcjeRuch[i]);
            }
            for(int i=0;i<2 ;i++) {
                zapis.println(AkcjeZwarcie[i]);
            }
            for(int i=0;i< 7;i++) {
		zapis.println(AkcjeRapierAtak[i]);
            }
            for(int i=0;i< 4;i++) {
		zapis.println(AkcjeRapierObrona[i]);
            }
            for(int i=0;i<4 ;i++) {
		zapis.println(AkcjeMieczAtak[i]);
            }
            for(int i=0;i<3 ;i++) {
		zapis.println(AkcjeMieczObrona[i]);
            }
            zapis.flush();
            zapis.close();
            System.out.print("Zapisano postać");
	} catch (FileNotFoundException e) {
            System.out.print("Blad!" +e.getLocalizedMessage());
            
	}
    }
}
