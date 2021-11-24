import java.util.Random;

public class Arme
{
    private String nom;
    private WeaponTypes type;
    private int puissance;

    public int getPuissance() {
        return puissance;
    }

    public String getNom() {
        return nom;
    }

    public WeaponTypes getType() {
        return type;
    }

    public Arme(String nom, WeaponTypes weaponType) {
        this.nom = nom;
        Random r = new Random();
        this.puissance = r.nextInt(11-5) + 5;
        this.type = weaponType;
    }
}

enum WeaponTypes {
    EPEE,
    COUTEAU,
    MASSE,
    PISTOLET,
    ARC
}