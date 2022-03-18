import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import javax.xml.parsers.DocumentBuilder;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GenBankIntroduction
{
    public static final String base_url = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi";

    public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException, SAXException, ParserConfigurationException
    {
        Scanner in = new Scanner(System.in);
        String genname = in.nextLine();
        String from = in.nextLine();
        String to = in.nextLine();

        String test_url = String.format("%s?db=nucleotide&term=(%s[Organism])+AND+(\"%s\"[PDAT]:\"%s\"[PDAT])", base_url, genname, from, to);

        URL url =  new URL(test_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");


        try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) 
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(connection.getInputStream());

            NodeList root = doc.getElementsByTagName("eSearchResult");
            NodeList count_nodes = root.item(0).getChildNodes();
            for (int i = 0; i < count_nodes.getLength(); i++)
            {
                if (count_nodes.item(i).getNodeType() != Node.ELEMENT_NODE)
                    continue;

                if (Objects.equals(count_nodes.item(i).getNodeName(), "Count"))
                {
                    System.out.println(count_nodes.item(i).getTextContent());
                    break;
                }
            }
        }
        connection.disconnect();
    }
}