import java.math.BigDecimal;

public class LIA {
    double countProp(int k, int N){
        //при скрещивании AaBb с любым генотипом потомок AaBb появится с вероятностью 25%
        double prop = 0;
        double children = Math.pow(2, k);
        for(int i = N; i<=children; i++){
            BigDecimal binom = factorial(children).divide(factorial(i).multiply(factorial(children-i)));
            prop += (binom.multiply(BigDecimal.valueOf(Math.pow(0.25, i) * Math.pow(0.75, children-i)))).doubleValue();
        }
        return prop;
    }


    private static BigDecimal factorial(double x){
        BigDecimal result= BigDecimal.valueOf(1);
        for (int i = 1; i <= x; i++) {
            result = BigDecimal.valueOf(i).multiply(result);
        }
        return result;
    }
}
