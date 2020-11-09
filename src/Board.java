import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
    public ArrayList<DrawingShape> Piece_Graphics;

    public Piece Active_Piece;

    private final int rows = 8;
    private final int cols = 8;
    private Integer[][] BoardGrid;
    private String board_file_path = "images" + File.separator + "active_square.png";
    private String active_square_file_path = "images" + File.separator + "active_square.png";

    public void initGrid(){
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; i++)
                BoardGrid[i][j] = 0;

        // Image white_piece = loadImage("images/white_pieces/" + piece_name + ".png");
        // Image black_piece = loadImage("images/black_pieces/" + piece_name + ".png");

        // The inner brackets will be filled after the pieces file is written
        White_Pieces.add(new King());
        White_Pieces.add(new Queen());
        White_Pieces.add(new Bishop());
        White_Pieces.add(new Bishop());
        White_Pieces.add(new Knight());
        White_Pieces.add(new Knight());
        White_Pieces.add(new Rook());
        White_Pieces.add(new Rook());
        White_Pieces.add(new Pawn());
        White_Pieces.add(new Pawn());
        White_Pieces.add(new Pawn());
        White_Pieces.add(new Pawn());
        White_Pieces.add(new Pawn());
        White_Pieces.add(new Pawn());
        White_Pieces.add(new Pawn());
        White_Pieces.add(new Pawn());

        Black_Pieces.add(new King());
        Black_Pieces.add(new Queen());
        Black_Pieces.add(new Bishop());
        Black_Pieces.add(new Bishop());
        Black_Pieces.add(new Knight());
        Black_Pieces.add(new Knight());
        Black_Pieces.add(new Rook());
        Black_Pieces.add(new Rook());
        Black_Pieces.add(new Pawn());
        Black_Pieces.add(new Pawn());
        Black_Pieces.add(new Pawn());
        Black_Pieces.add(new Pawn());
        Black_Pieces.add(new Pawn());
        Black_Pieces.add(new Pawn());
        Black_Pieces.add(new Pawn());
        Black_Pieces.add(new Pawn());
    }

    public Board(){
        BoardGrid = new Integer[rows][cols];
        Static_Shapes = new ArrayList();
        Piece_Graphics = new ArrayList();
        White_Pieces = new ArrayList();
        Black_Pieces = new ArrayList();
    }

}
