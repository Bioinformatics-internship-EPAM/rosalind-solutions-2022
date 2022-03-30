public class IEV {

    public static double task() {
        String[] values = ReadFile.resFileToStringList("rosalind_iev.txt").get(0).split(" ");
        int domDom = Integer.parseInt(values[0]); //prob to get dominant in this case = 1
        int domHet = Integer.parseInt(values[1]); //prob in this case = 1
        int domRec = Integer.parseInt(values[2]); //prob in this case = 1
        int hetHet = Integer.parseInt(values[3]); //prob in this case = 0.75
        int hetRec = Integer.parseInt(values[4]); //prob in this case = 0.5
        //int recRec = Integer.parseInt(values[5]); //prob in this case = 0

        int coupleOffspring = 2;

        return coupleOffspring * (domDom + domHet + domRec + hetHet * 0.75 + hetRec * 0.5);
    }
}
