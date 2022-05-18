import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class GC {

    public static void main(String[] args) {

        String name_str= " ";
        String max_name= " ";
        String str= " ";
        int cCount = 0;
        int maxCount = 0;
        double maxp = 0;
        int totolL = 0;
        try {
            File file = new File("src/main/resources/rosalind_gc.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(">"))
                {
                    name_str = line.substring(1);
                    if (maxCount < cCount)
                    {
                        maxCount = cCount;
                        max_name = name_str;
                        maxp = (double)cCount * 100 / totolL;

                    }
                    cCount = 0;
                    totolL = 0;
                }
                else
                {
                    totolL = totolL + line.length() - 1;
                    for ( int i = 0; i <line.length(); i ++)
                    {
                        if (line.charAt(i) == 'C' || line.charAt(i) == 'G')
                        {
                            cCount++;
                        }
                    }
                }

                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( name_str);
        System.out.println( Double.toString(maxp));
        System.out.println( Integer.toString(maxCount));
        System.out.println( Integer.toString(totolL));


    }
}
