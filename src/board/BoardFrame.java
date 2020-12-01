package board;

import javax.swing.*;
import java.awt.*;

import static board.ChessGUI.black_player;
import static board.ChessGUI.white_player;

/* board.BoardFrame.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish:
 */
public class BoardFrame extends JFrame{
    Component component;
    public static JLabel label;
    public BoardFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chess");
        setResizable(false);
        component = new Board();
        add(component, BorderLayout.CENTER);

        label = new JLabel("White: " + white_player + " vs Black: " + black_player);
        add(label, BorderLayout.NORTH);

        setLocation(200, 50);
        pack();
        setVisible(true);
    }
}
