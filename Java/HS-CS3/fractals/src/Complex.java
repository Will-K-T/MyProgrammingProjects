public class Complex {
    private final double a;
    private final double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Complex add(Complex o)
    {
        double addA;
        double addB;
        addA = (a+o.getA());
        addB = (b+o.getB());
        return new Complex(addA, addB);
    }

    public Complex subtract(Complex o)
    {
        double subA;
        double subB;
        subA = (a-o.getA());
        subB = (b-o.getB());
        return new Complex(subA, subB);
    }

    public Complex multiply(Complex o)
    {
        double multA;
        double multB;
        multA = (a*o.getA()-b*o.getB());
        multB = (b*o.getA()+a*o.getB());
        return new Complex(multA, multB);
    }

    public Complex divide(Complex o) {
        double divA;
        double divB;
        divA = ((this.a*o.getA())+(this.b*o.getB()))/(Math.pow(o.getA(), 2)+Math.pow(o.getB(), 2));
        divB = ((this.b*o.getA())-(this.a*o.getB()))/(Math.pow(o.getA(), 2)+Math.pow(o.getB(), 2));
        return new Complex(divA, divB);
    }

    @Override
    public String toString() {
        return a +" + " + b +"i";
    }
}

