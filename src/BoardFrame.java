import javax.swing.*;
import java.awt.*;

/* BoardFrame.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish:
 */
public class BoardFrame extends JFrame{
    Component component;
    public BoardFrame(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Chess");
        this.setResizable(false);
        component = new Board();
    }
}
