public class Fraction {
   private int nom,denom;

    public Fraction (int nom, int denom) {
        if (denom == 0) {
            throw new IllegalStateException("denom cannot be 0");
        }
        this.nom = nom;
        this.denom = denom;
    }

    public Fraction (Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException ("other must not be null");
        }
        this.nom = other.nom;
        this.denom = other.denom;
    }

    public int getNom() {
        return nom;
    }

    public int getDenom() {
        return denom;
    }

    public void setNom(int nom){
        this.nom = nom;
    }

    public void setDenom(int denom) {
        if (denom == 0) {
            throw new IllegalStateException("denom cannot be 0");
        }
        this.denom = denom;
    }

    public void normalizeSign() {
        if (getNom() == 0) {
            setDenom(1);
        }
        if (getDenom() < 0 && getNom() <0 ) { //Both negative
            setNom(getNom() * (-1)); //Nom *(-1) -> positive
            setDenom(getDenom() * (-1)); //Denom * (-1) -> positive
        }
        if (getDenom() < 0 && getNom() > 0 ) { //Denom negative
            setNom(getNom() * (-1)); //Nom *(-1) -> negative
            setDenom(getDenom() * (-1)); //Denom * (-1) -> positive
        }

    }

    private int gcd(int p, int q){
        p = Math.abs(p);
        q = Math.abs(q);
        return (q != 0 ? gcd(q, p % q) : p); // is q != 0? false-> p, true -> gcd(q, p % q)
    }

    public Fraction asReduced() {
        int x = gcd(getNom(), getDenom());
        return new Fraction ((getNom())/(x), (getDenom())/(x));
    }

    public double value() {
        double x= (double) (getNom()) /(getDenom());
        return Math.round(x*10000)/10000.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) //wenn null immer falsch
            return false;
        if (getClass() != obj.getClass()) //Klassen Vergleichen
            return false;

        Fraction objFraction = (Fraction) obj;
        if (getNom()!= objFraction.getNom())
            return false;
        if (getDenom()!= objFraction.getDenom())
            return false;

        return true;
    }

    public boolean valueEquals(Fraction f){
        return asReduced().value() == f.asReduced().value();
    }

}
