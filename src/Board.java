import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/* BoardFrame.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish:
 */
public class Board extends JComponent{
    public int turnCounter = 0;
    private static Image NULL_IMAGE =new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

    private final int Square_Width = 65;
    public ArrayList<Piece> White_Pieces;
    public ArrayList<Piece> Black_Pieces;

    public ArrayList<DrawingShape> Static_Shapes;
    public ArrayList<DrawingShape> Static_Graphics;

    public Piece Active_Piece;

    private final int rows = 8;
    private final int cols = 8;
    private Integer[][] BoardGrid;

}
