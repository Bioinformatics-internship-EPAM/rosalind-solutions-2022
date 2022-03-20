import java.io.IOException;

public class IPRB {

    public static double IPRBTask () throws IOException {
        var data = Utils.readFromFile("resources/rosalind_iprb.txt").get(0);
        var splitData = data.split(" ");
        int k = Integer.parseInt(splitData[0]);
        int m = Integer.parseInt(splitData[1]);
        int n = Integer.parseInt(splitData[2]);
        double total = k + m + n;
        double probBothDom = (k/total)*((k-1)/(total-1));
        double probBothHetero = (m/total)*((m-1)/(total-1));
        double probDomRec = ( (k/total)*(n/(total-1)) ) + ((n/total)*(k/(total-1)));
        double probDomHetero = ( (k/total)*(m/(total-1)) ) + ((m/total)*(k/(total-1)));
        double probHeteroRec = ( (m/total)*(n/(total-1)) ) + ((n/total)*(m/(total-1)));

        return probBothDom + probDomHetero + (probBothHetero * 0.75) + probDomRec + (probHeteroRec * 0.5);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(IPRBTask());
    }

}
