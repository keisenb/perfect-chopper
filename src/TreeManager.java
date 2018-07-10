import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.GameObject;

public class TreeManager {
    private AbstractScript s;

    public TreeManager(AbstractScript s) {
        this.s = s;
    }



    public GameObject GetNew(String name) {
        return s.getGameObjects().closest(name);
    }

    public void Chop(GameObject tree) {
        tree.interact("Chop down");
    }
}
