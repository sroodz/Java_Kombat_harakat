import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {

    @org.junit.jupiter.api.Test
    void setHealth() {

    }

    @org.junit.jupiter.api.Test
    void loseHealth() {
        Soldier soldier = new Soldier("test","haha");
        soldier.loseHealth(5);
        assertEquals(soldier.getHealth(),15);
    }


    @org.junit.jupiter.api.Test
    void damege(){
        Soldier soldier1 = new Soldier("test1","");
        Soldier soldier2 = new Soldier("test2","");
        int dmg = soldier1.getAttack();
        soldier2.loseHealth(dmg);
        assertTrue(soldier2.getHealth() > 16 && soldier2.getHealth() < 20);
    }

    @org.junit.jupiter.api.Test
    void beforeMySQL(){
        List<Soldier> soldiers = new ArrayList<>();
        assertTrue(soldiers.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void AfterMySQL(){
        Match match = new Match();
        List<Soldier> soldiers = new ArrayList<>();
        match.SQL();
        assertEquals(match.getTotalFighters(),16);
    }

    @org.junit.jupiter.api.Test
    void counterAttack(){
        Soldier one = new Soldier("test1","");
        Soldier two = new Soldier("test2","");
        one.setAttack(5);
        two.setDefence(10);

        int dmg, blc, res, cou;

        System.out.println(one.getName() + " Attacks with " + (dmg = one.getAttack()));
        blc = two.getDefence();
        res = (dmg - blc);
        if (res > 0) {
            two.loseHealth(res);
            System.out.println(two.getName() + " lost " + res + " Hp, " + two.getHealth() + "Hp Left");

            assertEquals(two.getHealth(),20-res);

        } else if (res == 0) {
            System.out.println(two.getName() + " Blocks the Attack!");

            assertEquals(two.getHealth(), 20);
            assertEquals(one.getHealth(), 20);
        } else {
            cou = Math.abs(res);
            System.out.println(two.getName() + " Counter attacks with " + cou);
            one.loseHealth(cou);
            System.out.println(one.getName() + " lost " + cou + " Hp, " + one.getHealth() + " Hp Left");

            assertNotEquals(two.getHealth(), 20-res);
            assertEquals(one.getHealth(), 20-cou);
        }

    }

    @org.junit.jupiter.api.Test
    void mottoNull(){
        Soldier one = new Soldier("test1",null);
        Soldier two = new Soldier("test2","");
        assertNull(one.getMotto());
        assertNotNull(two.getMotto());
    }



}
