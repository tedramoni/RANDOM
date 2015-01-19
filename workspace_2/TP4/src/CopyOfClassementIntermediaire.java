import java.util.Date;
import java.util.TreeSet; 
import java.io.FileInputStream;
import java.io.IOException; 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
   
public class CopyOfClassementIntermediaire  {
		 
	TreeSet <Position> classementIntermediaire = new TreeSet <Position> ();
	
	public CopyOfClassementIntermediaire (String adresseFichierClassement ) {
		lectureFichierXMLclassement (adresseFichierClassement );
	} //constructeur
	
	@SuppressWarnings("deprecation")
	public void lectureFichierXMLclassement (String adresseFichierClassement ) {
		/*
     * effectue la lecture du fichier XML, qui contient un classement intermédiaire
     * @param : une String qui est l'adresse du fichier XML
     *  
     */
            
     DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
     DocumentBuilder builder = null;
     try {builder = builderFactory.newDocumentBuilder();
         Document document = builder.parse(new FileInputStream(adresseFichierClassement));
         NodeList listeElementReleve = document.getElementsByTagName("releve");
         for (int i=0 ; i < listeElementReleve.getLength() ; i++)      
           {   Element courant =  (Element) listeElementReleve.item(i);
               String nomSkipper = courant.getAttribute("nomSkipper");
               String chaineDate = courant.getAttribute("date");
               String chaineHeure = courant.getAttribute("heure");
               double distArrivee = 4000;
               boolean abandon = false;
               Date dateEtHeure = null;
               if (!chaineDate.equals(""))
            	    dateEtHeure = new Date (
            			   Integer.parseInt(chaineDate.substring (6,10)),	  	// annee
            			   Integer.parseInt(chaineDate.substring(3, 5)) - 1, 	// mois : 0 pour janvier
            			   Integer.parseInt(chaineDate.substring (0,2)),		// jour
            			   Integer.parseInt(chaineHeure.substring (0,2)),		// heure
            			   Integer.parseInt(chaineHeure.substring(3,5)),		// minute
            			   Integer.parseInt(chaineHeure.substring(6,8))			// seconde
            			   );
 
                if (!courant.getAttribute("distanceArrivee").equals(""))
            	   distArrivee = Double.parseDouble(courant.getAttribute("distanceArrivee"));
                else  if (dateEtHeure == null)
            	    	abandon = true;
               		else distArrivee=0;
               			 
               Position position =  new Position ( nomSkipper,  distArrivee, dateEtHeure, abandon);
               classementIntermediaire.add(position);
           } 
    } //try
    catch (SAXException e) {e.printStackTrace();}
    catch (IOException e) {e.printStackTrace();}
    catch (ParserConfigurationException e) {e.printStackTrace();}
    } 
 
}
