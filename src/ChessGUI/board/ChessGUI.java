package ChessGUI.board;

import javax.swing.*;

/* ChessGUI.board.ChessGUI.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish: 04/12/2020
 *
 *
 */
public class ChessGUI {
    public BoardFrame boardFrame;
    public static String white_player, black_player;
    public static void main(String[] args){

        /* There is an issue with loading from the file with this and I did not have enough time left to figure it out.
         * I however kept the code for it and the file in for you to look at. */
        //Records.load_previous_match_details();

        white_player = JOptionPane.showInputDialog("Who is playing white?");
        black_player = JOptionPane.showInputDialog("Who is playing black?");

        ChessGUI gui = new ChessGUI();
        gui.boardFrame = new BoardFrame();
        gui.boardFrame.setVisible(true);
    }
}
