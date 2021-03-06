package main.java.classement;

import main.java.metier.Classement;
import main.java.metier.ClassementEquipe;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadAndPrintXMLFile
{

    public static void getXMLFromClassement(Classement classement, String filename)
    {
        try
        {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("poule");
            doc.appendChild(rootElement);
            rootElement.setAttribute("poule", classement.getDivision());

            for(ClassementEquipe team : classement.getClassementEquipes())
            {
                Element elemTeam = doc.createElement("equipe");
                elemTeam.setAttribute("rank", team.getRang());
                elemTeam.setAttribute("logo", team.getLogo());
                elemTeam.setAttribute("team", team.getNomEquipe());
                elemTeam.setAttribute("points", team.getPoints());
                elemTeam.setAttribute("mj", team.getMatchJoue());
                elemTeam.setAttribute("first", team.getPremierePlace());
                elemTeam.setAttribute("second", team.getDeuxiemePlace());
                elemTeam.setAttribute("third", team.getTroisiemePlace());
                elemTeam.setAttribute("forfeit", team.getForfait());
                elemTeam.setAttribute("nbPeriodes", team.getNbPeriode());
                elemTeam.setAttribute("fairPlay", team.getEspritSportif());
                rootElement.appendChild(elemTeam);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }
    }

    public static Classement getClassementFromXML(String url)
    {

        Classement classement = new Classement();
        List<ClassementEquipe> teams = new ArrayList<ClassementEquipe>();
        try
        {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            // Document doc = docBuilder.parse(new File("book.xml"));
            Document doc = docBuilder.parse(new File(url));

            // normalize text representation
            doc.getDocumentElement().normalize();

            String poule = doc.getDocumentElement().getAttribute("poule");

            // System.out.println("Poule : " + poule);
            classement.setDivision(poule);

            NodeList listeEquipes = doc.getElementsByTagName("equipe");

            int totalEquipe = listeEquipes.getLength();

            for(int s = 0; s < totalEquipe; s++)
            {

                Node team = listeEquipes.item(s);
                if(team.getNodeType() == Node.ELEMENT_NODE)
                {

                    NamedNodeMap namedNodeMap = team.getAttributes();

                    String rank = namedNodeMap.getNamedItem("rank").getNodeValue();
                    String logo = namedNodeMap.getNamedItem("logo").getNodeValue();
                    String sTeam = namedNodeMap.getNamedItem("team").getNodeValue();
                    String points = namedNodeMap.getNamedItem("points").getNodeValue();
                    String mj = namedNodeMap.getNamedItem("mj").getNodeValue();
                    String first = namedNodeMap.getNamedItem("first").getNodeValue();
                    String second = namedNodeMap.getNamedItem("second").getNodeValue();
                    String third = namedNodeMap.getNamedItem("third").getNodeValue();
                    String forfeit = namedNodeMap.getNamedItem("forfeit").getNodeValue();
                    String nbPeriodes = namedNodeMap.getNamedItem("nbPeriodes").getNodeValue();
                    String fairPlay = namedNodeMap.getNamedItem("fairPlay").getNodeValue();

                    ClassementEquipe oTeam =
                        new ClassementEquipe(rank, logo, sTeam, points, mj, first, second, third, forfeit, nbPeriodes, fairPlay);
                    teams.add(oTeam);

                    // System.out.println(team.toString());
                    // System.out.println("--------------------------------------------------------");
                }
            }
        }
        catch(SAXParseException err)
        {
            System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());

        }
        catch(SAXException e)
        {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();

        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }
        classement.setClassementEquipes(teams);
        return classement;
    }

    public static void main(String argv[])
    {
        Classement classement = getClassementFromXML("C:/Users/thierry/Desktop/classement_D1.xml");
        System.out.println(classement.getDivision());
        List<ClassementEquipe> teams = classement.getClassementEquipes();
        for(ClassementEquipe team : teams)
        {
            System.out.println(team.toString());
        }
    }// end of main
}
