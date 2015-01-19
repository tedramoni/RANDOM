import java.io.FileInputStream; 
import java.io.IOException;   
import java.util.HashMap;
import java.util.TreeSet; 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
  
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 

public class ParticipantsSansFabrique   {
     
    final int NB_CLASSES = 5 ;
	HashMap <String, Voilier> inscrits = new  HashMap <String, Voilier> ();
	TreeSet <String> [] inscritsParClasse = new TreeSet [NB_CLASSES]   ;     
        
  public ParticipantsSansFabrique (String adresseFichierVoiliers) {
       	lectureFichierInscriptions (  adresseFichierVoiliers ) ;  // construit une hashmap des inscrits
      	inscritsParClasse (); // construit un tableau des inscrits par classe, chaque case contient un 
   }
        
  public void lectureFichierInscriptions (String adresseFichierVoiliers ) {
		             
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {builder = builderFactory.newDocumentBuilder();
             Document document = builder.parse(new FileInputStream(adresseFichierVoiliers));
             NodeList listeNoeudsVoiliers = document.getElementsByTagName("voilier");
            for (int i=0 ; i < listeNoeudsVoiliers.getLength() ; i++)      
               {
                   Element courant =  (Element) listeNoeudsVoiliers.item(i);
                   String nom = courant.getAttribute("nom");
                   String nomSkipper = courant.getAttribute("nomSkipper");
                   String classeDuRhum = courant.getAttribute("classe");
                   String monocoque = courant.getAttribute("monocoque");
                      
                   FabriqueMonocoque fabmono = new FabriqueMonocoque();
                   FabriqueMulticoque fabmulti = new FabriqueMulticoque();
                   
                   Voilier voilier  = null; 
                   switch (classeDuRhum)
                   	{case "RHUM" :  voilier = monocoque.equals("oui")? fabmono.factoryMethod(nom,classeDuRhum) :
                   	 fabmulti.factoryMethod(nom,classeDuRhum); break;                   					 
                   	case "CLASS40" : voilier = fabmono.factoryMethod(nom,classeDuRhum); break;
                   	case "MULTI_50" : voilier = fabmulti.factoryMethod(nom,classeDuRhum); break;
                   	case "IMOCA": 	voilier = fabmono.factoryMethod(nom,classeDuRhum);  break;
                   	case "ULTIME" :  voilier = fabmulti.factoryMethod(nom,classeDuRhum); break;
                   }
                    inscrits.put (nomSkipper,voilier);
               }// for
            // Affichage pour tester
            System.out.println( inscrits); 
            
			
        } //try
        catch (SAXException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParserConfigurationException e) {e.printStackTrace();}
             
         }//


    	private void inscritsParClasse() {
    		  
         for (int i = 0; i< NB_CLASSES;  i++) 
        	  inscritsParClasse[i] = new TreeSet <String>();
         
         //Remplissage :
         for (String skipper : inscrits.keySet()) 
         {
        	 
        	 String classeDuRhum = inscrits.get(skipper).getClass().toString() ;
		 	 switch (classeDuRhum) {
		 		case "class RHUM_Mono" : inscritsParClasse[0].add(skipper); break; 
		 		case "class RHUM_Multi" : inscritsParClasse[0].add(skipper); break;
		 		case "class CLASS40" : inscritsParClasse[1].add(skipper); break;
		 		case "class MULTI_50" : inscritsParClasse[2].add(skipper); break;
		 		case "class IMOCA": inscritsParClasse[3].add(skipper); break;
		 		case "class ULTIME" :inscritsParClasse[4].add(skipper);break;
		 	 }
		 }	     
         
         	//Affichage :
	     System.out.println("RHUM :");
	     System.out.println(inscritsParClasse[0].toString()+"\n");
	     System.out.println("CLASS40 :");
	     System.out.println(inscritsParClasse[1].toString()+"\n");
	     System.out.println("MULTI_50 :");
	     System.out.println(inscritsParClasse[2].toString()+"\n");
	  	 System.out.println("IMOCA :");
	     System.out.println(inscritsParClasse[3].toString()+"\n");
	     System.out.println("ULTIME :");
		 System.out.println(inscritsParClasse[4].toString()+"\n");

    	}
	
		public static void main(String[] args) { 
			
			ParticipantsSansFabrique part = new ParticipantsSansFabrique  ("data/inscriptions_Route_Du_Rhum_2014.xml");
		}
 
}// classe  ParticipantsSansFabrique