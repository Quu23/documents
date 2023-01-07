package javas.maths;

public class integral {
    /**
     * 
     * @param fx    :被積分関数
     * @param begin :積分下限
     * @param end   :積分上限
     * @param n :帯の数　多ければ多いほどよい近似値が得られる
     * @return 台形公式による定積分の近似値
     */
    public static double trapezoidal_rule(Function fx,double begin,double end,int n){
        if(begin==end)return 0;
        if(fx.isOddFunction()&&begin==-end)return 0;

        double sum=0;
        double width=(end-begin)/n;

        for(double i=begin;i<=end;i+=width){
            sum+=fx.func(i);
            if(!(i==begin||i==end))sum+=fx.func(i);
        }
        sum*=width/2;
        return sum;
    }

    /**
    * 
    * @param fx    :被積分関数
    * @param begin :積分下限
    * @param end   :積分上限
    * @param n :帯の数　多ければ多いほどよい近似値が得られる
    * @return シンプソンの公式による定積分の近似値
    */
    public static double simpson_rule(Function fx,double begin,double end,int n) {
        if(begin==end)return 0;
        if(fx.isOddFunction()&&begin==-end)return 0;

        double sum=0;
        double width=(end-begin)/n;

        for (int i = 0; i < n+1; i++) {
            double temp;
            temp=fx.func(begin+i*width);
            if(!(i==0||i==n))temp*= i%2==0?2:4;
            sum+=temp;
        }
        sum*=width/3;
        return sum;
    }
}
