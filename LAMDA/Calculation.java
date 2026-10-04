package LAMDA;

public class Calculation{
    Myjava sub = (a, b) -> a + b;
    Calculation(){}
    Calculation(Myjava sub){
        this.sub = sub;
    }
    public int ans(int a, int b){
        return sub.calculation(a, b);
    }
}
