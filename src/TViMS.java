import ui.ComponentPanel;
import ui.MainWindow;

public class TViMS {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.add(new ComponentPanel());
        mainWindow.revalidate();
    }
}
