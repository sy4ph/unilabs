package lab20;
public class zadanie1<T, V, K> {
    private T varT;
    private V varV;
    private K varK;

    public zadanie1 (T t, V v, K k) {
        varT = t;
        varV = v;
        varK = k;
    }

    public T getVariableT() { return varT; }
    public V getVariableV() { return varV; }
    public K getVariableK() { return varK; }

    public void printClassNames() {
        System.out.println("Variable classes: ");
        System.out.println("Variable T class: " + varT.getClass().getName());
        System.out.println("Variable V class: " + varV.getClass().getName());
        System.out.println("Variable K class: " + varK.getClass().getName());
    }
    public static void main(String[] args) {
        zadanie1<String, Integer, Double> test1 = new zadanie1<>("ttt", 33, 33.3);
        test1.printClassNames();

        zadanie1<Integer, String, Double> test2 = new zadanie1<>(444, "htd", 4.44);
        test2.printClassNames();

        zadanie1<Double, Integer, String> test3 = new zadanie1<>(4554.45454554, 24432, "end");
        test3.printClassNames();
    }}