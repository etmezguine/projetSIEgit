import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;




public class JDOM1
{
	static org.jdom2.Document document;
    static org.jdom2.Element racine;
    
	public static void main(String[] args) {
    //On crée une instance de SAXBuilder
    SAXBuilder sxb = new SAXBuilder();
    try
    {
       //On crée un nouveau document JDOM avec en argument le fichier XML
       //Le parsing est terminé ;)
       document = sxb.build(new File("test.xml"));
    }
    catch(Exception e){}

    //On initialise un nouvel élément racine avec l'élément racine du document.
    racine = document.getRootElement();

    //Méthode définie dans la partie 3.2. de cet article
    afficheALL();
	}
	
	static void afficheALL()
	{
	   //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
	   List listEtudiants = racine.getChildren("etudiant");

	   //On crée un Iterator sur notre liste
	   Iterator i = listEtudiants.iterator();
	   while(i.hasNext())
	   {
	      //On recrée l'Element courant à chaque tour de boucle afin de
	      //pouvoir utiliser les méthodes propres aux Element comme :
	      //sélectionner un nœud fils, modifier du texte, etc...
		   org.jdom2.Element courant = (org.jdom2.Element)i.next();
	      //On affiche le nom de l’élément courant
	      System.out.println(courant.getChild("nom").getText());
	   }
	}

}


