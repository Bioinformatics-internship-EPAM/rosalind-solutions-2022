import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;


public class FASTQformatintroduction
{
    public static void main(String[] args) 
    {
        String tmp;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("inputFASTA.fastq"), StandardCharsets.UTF_8);
               FileWriter output = new FileWriter("output.fasta", false))
        { 
            tmp = reader.readLine();
			while(tmp != null)
			{
				if (tmp.charAt(0) == '@')
				{
						output.append('>');
						output.write(tmp.substring(1));
						output.append('\n');
						
						tmp = reader.readLine();
						for (int i = 0; i < tmp.length(); i+=60)
						{
							output.write(tmp.substring(i, Math.min(i + 60, tmp.length())));
							output.append('\n');
						}
						reader.readLine();
						reader.readLine();
				}
				tmp = reader.readLine();
				output.flush();
			}
        }
        catch (IOException e)
        {
            System.out.println("Error file work: " + e.getMessage());
            return;
        }
    }
}
