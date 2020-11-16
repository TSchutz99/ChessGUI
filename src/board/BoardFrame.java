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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Chess");
        setResizable(false);
        component = new Board();
        add(component, BorderLayout.CENTER);

        setLocation(200, 50);
        pack();
        setVisible(true);
    }
}
