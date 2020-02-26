package startUp;
/**
 * @author Zhenzhong Zhou
 * 111956966
 * zhz028
 */

import interfacegui.*;

public class StartupAll {

    /**
     * Get into GUI or Console
     * @param args
     */
    public static void main(String[] args) {
        GraphicOrDialogOrConsole graphicOrDialogOrConsole = new GraphicOrDialogOrConsole();
        graphicOrDialogOrConsole.setVisible(true);
    }
}
