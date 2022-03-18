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
import java.lang.Thread;

public class DataFormats
{
    public static final String base_url = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils";
    
    public static int getidmin(String[] accs, int len)
    {
        String term = String.format("%s[ACCN]", accs[0]);
        
        
        for (int i = 1; i < len; i++)
        {
            term += String.format("+OR+%s[ACCN]", accs[i]);
        }
        
        String test_url = String.format("%s/esearch.fcgi?db=nucleotide&term=(%s)&sort=slen", base_url, term);
                
        HttpURLConnection connection = null;
        
        try {
        URL url =  new URL(test_url);
        
        connection = (HttpURLConnection) url.openConnection();
        }  catch (Exception e) {
           System.out.println("fail connect to get id");
           return -1;
        }
        try
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(connection.getInputStream());
            
            NodeList ids = doc.getElementsByTagName("Id");
            connection.disconnect();
            return Integer.parseInt(ids.item(ids.getLength()-1).getTextContent());
        }
        catch (Exception e) {
           System.out.println("fail get id entry id");
           return -1;
        }
    }
    
    public static int getfasta(int uid)
    {
           String test_url = String.format("%s/efetch.fcgi?db=nucleotide&id=%d&rettype=fasta", base_url, uid);
                
        HttpURLConnection connection = null;
        
        try {
        URL url =  new URL(test_url);
        
        connection = (HttpURLConnection) url.openConnection();
        }  catch (Exception e) {
           System.out.println("fail connect uid: " + uid);
           return -1;
        }
        try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) 
        {
            String line;
            while ((line = input.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (Exception e) {
           System.out.println("fail get fasta: " + uid);
           return -1;
        }
        
        connection.disconnect();
        return 0;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        String[] ids = tmp.split("\\s");
        int[] uids = new int[10];
        int len = Math.min(ids.length, 10);
        int idmin = getidmin(ids, len);
        
         try
            {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                System.out.println("Fail sleep");
            }
         
        getfasta(idmin);
    }
}
