import org.dreambot.api.script.AbstractScript;

import static java.lang.Thread.sleep;

public class PlayerManager {

    private AbstractScript s;

    public PlayerManager(AbstractScript s) {
        this.s = s;
    }


    public void WaitForPlayerAnimation() {
        try {
            sleep(500);
        } catch (Exception e) {
            System.out.println("Sleep interrupted");
        }
    }

    public boolean ReadyToChop() {
        return !(s.getInventory().isFull() || s.getLocalPlayer().isAnimating());
    }



}
