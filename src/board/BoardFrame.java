package board;

import javax.swing.*;
import java.awt.*;

/* board.BoardFrame.java
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
        this.add(component, BorderLayout.CENTER);

        this.setLocation(200, 50);
        this.pack();
        this.setVisible(true);
    }
}
