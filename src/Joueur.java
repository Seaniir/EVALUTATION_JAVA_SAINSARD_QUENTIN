import java.util.Random;

public class Joueur
{
    private String nom;
    private int sante;
    private int force;
    private int experience;
    private Arme arme;

    public int getForce() {
        return force;
    }

    public Arme getArme() {
        return arme;
    }

    public String getNom() {
        return nom;
    }

    public int getSante() {
        return sante;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public void setArme(Arme arme) {
        if (this.getSante() == 0)
        {
            System.out.println("Aucune action possible, vous êtes mort !");
            return;
        }
        this.arme = arme;
    }

    public Joueur(String nom)
    {
        this.nom = nom;
        this.sante = 10;
        Random r = new Random();
        this.force = r.nextInt(11-5) + 5;
        this.experience = 1;
    }

    public void desarmPlayer()
    {
        this.arme = null;
    }

    public void attackPlayer(Joueur player)
    {
        if (this.sante == 0)
        {
            System.out.println("\nAucune action possible, vous êtes mort !");
            return;
        }
        else if (player.getSante() == 0)
        {
            System.out.println("\nCe joueur ne peut pas être attaqué, il est déjà mort !");
            return;
        }
        else if(this.arme == null)
        {
            System.out.println("\nVeuillez armez " + this.nom + " !");
            return;
        }
        int attackingPlayerDamage = this.force * this.sante * this.experience * arme.getPuissance();
        int attackedPlayerDamage = player.getForce() * player.getSante() * player.getExperience() * player.getArme().getPuissance();
        if(attackingPlayerDamage > attackedPlayerDamage) {
            this.force += 1;
            player.setSante(player.getSante() - 1);
            this.experience += 1;
            player.setExperience(player.getExperience() + 1);
            if (player.getSante() == 0) {
                player.desarmPlayer();
                System.out.println("\nLe grand vainqueur du combat est " + this.nom + ", le perdant, qui à été tué est " + player.getNom());
            }
            else
                System.out.println("\nLe vainqueur du combat est " + this.nom + ", le perdant est " + player.getNom());
        }
        else if(attackingPlayerDamage < attackedPlayerDamage)
        {
            player.setSante(player.getForce() + 1);
            this.sante -= 1;
            this.experience += 1;
            player.setExperience(player.getExperience() + 1);
            if (this.sante == 0) {
                this.desarmPlayer();
                System.out.println("\nLe grand vainqueur du combat est " + player.getNom() + ", le perdant, qui à été tué est " + this.nom);
            }
            else
                System.out.println("\nLe vainqueur du combat est " + player.getNom() + ", le perdant est " + this.nom);
        }
        else
        {
            System.out.println("Match nul !");
        }
    }

    @Override
    public String toString() {
        if (this.arme == null)
        {
            System.out.println("\n" + this.nom + " : Santé = " + this.sante + " ; Force = " + this.force + " ; Expérience = " + experience);
        }
        else
        {
            System.out.println("\n" + this.nom + " : Santé = " + this.sante + " ; Force = " + this.force + " ; Expérience = " + experience);
            System.out.println("Arme de " + this.nom + " : " + this.arme.getNom() + " ; Puissance = " + this.arme.getPuissance() + " ; Type d'arme = " + this.getArme().getType());
        }

        return null;
    }
}
