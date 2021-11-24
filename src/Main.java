import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Joueur quentin = new Joueur("Quentin");
        Joueur julien = new Joueur("Julien");
        quentin.toString();
        julien.toString();
        Arme exca = new Arme("Excalibur", WeaponTypes.EPEE);
        quentin.setArme(exca);
        quentin.toString();
        Arme marteau = new Arme("Marteau", WeaponTypes.MASSE);
        julien.setArme(marteau);
        julien.toString();
        for (int i = 0; i < 100; i++) {
            if (quentin.getSante() == 0 || julien.getSante() == 0)
                break;
            quentin.attackPlayer(julien);
            quentin.toString();
            julien.toString();
        }
    }
}
