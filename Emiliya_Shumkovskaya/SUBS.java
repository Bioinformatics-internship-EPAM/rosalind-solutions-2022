import java.util.ArrayList;
import java.util.List;

public class SUBS {

    public  List<Integer> getLocations(String dna, String part) {
        List<Integer> locations =  new ArrayList<>();
        int index = 0;
        while(index != -1) {
            index =dna.indexOf(part, index);
            if(index != -1) {
                index++;
                locations.add(index);
            }
        }
        return locations;
    }

}
