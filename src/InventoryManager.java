import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.script.AbstractScript;

public class InventoryManager {

    private AbstractScript s;

    public InventoryManager(AbstractScript s) {
        this.s = s;
    }

    public boolean ReadyToDrop() {
        return s.getInventory().isFull();
    }

    public void Drop(int id) {
        s.getInventory().drop(id);
    }
}
