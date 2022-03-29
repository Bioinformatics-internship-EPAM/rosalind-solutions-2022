import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class ReadQualityDistribution
{
     public static final char LOW_QUALITY = '!';

     public static int getavg(String str)
    {
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
        {
            sum += str.charAt(i) - LOW_QUALITY;
        }
        return sum/str.length();
    }
    
    public static void main(String[] args) 
    {
        String tmp;
        int count = 0;
        int avgqual;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("inputRQD.txt"), StandardCharsets.UTF_8))
        {
            avgqual = Integer.parseInt(reader.readLine());
            tmp = reader.readLine();
            while(tmp != null)
            {
                if (tmp.charAt(0) == '@')
                {
                    reader.readLine();
                    reader.readLine();
                    tmp = reader.readLine();
                    if (tmp == null)
                    {
                        System.out.println("Error format");
                        return;
                    }
                    if (getavg(tmp) < avgqual)
                        count++;
                }
                tmp = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error read input file: " + e.getMessage());
        }
        System.out.println(count);
    }
}
