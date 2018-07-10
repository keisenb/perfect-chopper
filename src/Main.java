import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.GameObject;


@ScriptManifest(author = "imperfect", category = Category.WOODCUTTING,
        description = "Perfect Woodcutter by Imperfect :)", name="Perfect Woodcutter", version=1.0)
public class Main extends AbstractScript {

    private InventoryManager inventoryManager = new InventoryManager(this);
    private TreeManager treeManager = new TreeManager(this);
    private PlayerManager playerManager = new PlayerManager(this);

    private static int Log = 1511;
    private static String Tree = "Tree";
    private GameObject currentTree = null;

    @Override
    public int onLoop() {
        ExecuteScript();
        return 500;
    }


    private void ExecuteScript() {

        if(playerManager.ReadyToChop()) {
            currentTree = treeManager.GetNew(Tree);
            if(currentTree != null) {
                treeManager.Chop(currentTree);
                playerManager.WaitForPlayerAnimation();
            }
        }
        else if(inventoryManager.ReadyToDrop()){
            inventoryManager.Drop(Log);
        }
        else {
            if(!currentTree.exists()) {
                inventoryManager.Drop(Log);
            }
        }
    }
}
