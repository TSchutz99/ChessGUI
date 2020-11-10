import ChessGUI.pieces.*;
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

        // Need to test if this works
        White_Pieces.add(new King(3,0,true,"King.png",this));
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

        initGrid();

        // these maybe edited later
        this.setBackground(new Color(37,13,84));
        this.setPreferredSize(new Dimension(520,520));
        this.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(1000, 1000));

        // will define ''mouseAdaptor, componentAdaptor, keyAdapter'' later
        this.addMouseListener(mouseAdaptor);
        this.addComponentListener(componentAdaptor);
        this.addKeyListener(keyAdapter);

        this.setVisible(true);
        this.requestFocus();
        drawBoard();
    }

    private void drawBoard(){
        Piece_Graphics.clear();
        Static_Shapes.clear();

        // loadImage will be defined later
        Image board = loadImage(board_file_path);
        // DrawingImage will be defined later and filled at all relevant locations
        Static_Shapes.add(new DrawingImage());
        if(Active_Piece != null){
            Image active_square = loadImage("images" + File.separator + "active_square.png");
            // DrawingImage to be filled later
            Static_Shapes.add(new DrawingImage());
        }
        for(int i = 0; i < White_Pieces.size(); i++){
            int COL = White_Pieces.get(i).getX();
            int ROW = White_Pieces.get(i).getY();
                                                                                  // .getFilePath() will be defined in the pieces file
            Image piece = loadImage("images" + File.separator + "white_pieces" + File.separator + White_Pieces.get(i).getFilePath());
            // DrawingImage to be filled later
            Piece_Graphics.add(new DrawingImage());
        }
        for(int i = 0; i < Black_Pieces.size(); i++){
            int COL = Black_Pieces.get(i).getX();
            int ROW = Black_Pieces.get(i).getX();
            Image piece = loadImage("images" + File.separator + "black_pieces" + File.separator + Black_Pieces.get(i).getFilePath());
            // DrawingImage to be filled later
            Piece_Graphics.add(new DrawingImage());
        }
        this.repaint();
    }

    public Piece getPiece(){
        // must write the Piece file before I continue with writing the file.
    }
}
