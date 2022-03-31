public class LIA {
    double countProp(int k, int N){
        //при скрещивании AaBb с любым генотипом потомок AaBb появится с вероятностью 25%
        double prop = 0;
        double children = Math.pow(2, k);
        for(int i = N; i<=children; i++){
            int binom = factorial(children)/(factorial(i)*factorial(children-i));
            prop += binom*Math.pow(0.25, i) * Math.pow(0.75, children-i);
        }
        return prop;
    }
    private static int factorial(double x){
        int result=1;
        for (int i = 1; i <= x; i++)
        {
            result *= i;
        }
        return  result;
    }
}
