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
       //	inscritsParClasse (); // construit un tableau des inscrits par classe, chaque case contient un 
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
                      
                   Voilier voilier  = null; 
                   switch (classeDuRhum)
                   	{case "RHUM" :  voilier = monocoque.equals("oui")? new RHUM_Mono (nom ) : new RHUM_Multi (nom );break;                   					 
                   	case "CLASS40" :    voilier = new CLASS40(nom);  break;
                   	case "MULTI_50" : voilier = new MULTI_50(nom); break;
                   	case "IMOCA": 	voilier = new IMOCA(nom);  break;
                   	case "ULTIME" :  voilier = new ULTIME(nom); break;
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
         
         for (String skipper : inscrits.keySet()) 
			{String classeDuRhum = inscrits.get(skipper).getClass().toString() ;
		 	switch (classeDuRhum) {
				// à compléter
		 	 }	           	
			}  // for
          // Affichage pour tester
        // à compléter 
		}
	
		public static void main(String[] args) { 
			
		  new ParticipantsSansFabrique  ("data\\inscriptions_Route_Du_Rhum_2014.xml");
		 
		}
 
}// classe  ParticipantsSansFabrique