import java.util.ArrayList;
import java.util.List;

public class WarZone {

    Soldier soldier1;
    Soldier soldier2;

    Match match = new Match();
    BattleRoyale battleRoyale = new BattleRoyale();


    public void fight() {

        match.SQL();

        do {
            System.out.println("\nName: Hp : Pwr");
            for (int i = 0; i < match.getTotalFighters(); i++) {
                System.out.println("\n" + match.soldiers.get(i).getName() + " " + match.soldiers.get(i).getHealth() +
                        " " + (match.soldiers.get(i).getAttack() + match.soldiers.get(i).getDefence()));
            }

            for (int i = 0; i < match.getTotalFighters(); i = i + 2) {

                this.soldier1 = match.soldiers.get(i);
                this.soldier2 = match.soldiers.get(i + 1);

                battleRoyale.battle(this.soldier1, this.soldier2);
            }


            System.out.println("The LOSERS!\n");
            List<Soldier> remainingSoldiers = new ArrayList<>();

            for (int i = 0; i < match.getTotalFighters(); i++) {
                if (match.soldiers.get(i).getHealth() <= 0) {
                    System.out.println(match.soldiers.get(i).getName() + " " + match.soldiers.get(i).getHealth());
                } else {
                    match.soldiers.get(i).setHealth(20);
                    remainingSoldiers.add(match.soldiers.get(i));
                }
            }
            System.out.println("-------------------\n");
            match.soldiers = remainingSoldiers;

        }
        while (match.soldiers.size() > 1);

        System.out.println("THE CHAMPION IS NOBODY BUT " +
                match.soldiers.get(0).getName().toUpperCase() + "!!!!!!!!!!!!!!!");

    }

}

