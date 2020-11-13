package board;

import pieces.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* board.BoardFrame.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish:
 */
public class Board extends JComponent{
    public int turnCounter = 0;
    private static Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

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
        White_Pieces.add(new Queen(4,0,true,"Queen.png",this));
        White_Pieces.add(new Bishop(2,0,true,"Bishop.png",this));
        White_Pieces.add(new Bishop(5,0,true,"Bishop.png",this));
        White_Pieces.add(new Knight(1,0,true,"Knight.png",this));
        White_Pieces.add(new Knight(6,0,true,"Knight.png",this));
        White_Pieces.add(new Rook(0,0,true,"Rook.png",this));
        White_Pieces.add(new Rook(7,0,true,"Rook.png",this));
        White_Pieces.add(new Pawn(0,1,true,"Pawn.png",this));
        White_Pieces.add(new Pawn(1,1,true,"Pawn.png",this));
        White_Pieces.add(new Pawn(2,1,true,"Pawn.png",this));
        White_Pieces.add(new Pawn(3,1,true,"Pawn.png",this));
        White_Pieces.add(new Pawn(4,1,true,"Pawn.png",this));
        White_Pieces.add(new Pawn(5,1,true,"Pawn.png",this));
        White_Pieces.add(new Pawn(6,1,true,"Pawn.png",this));
        White_Pieces.add(new Pawn(7,1,true,"Pawn.png",this));

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

    public Piece getPiece(int x, int y){
        for(Piece p : White_Pieces){
            if(p.getX() == x && p.getY() == y)
                return p;
        }

        for(Piece p : Black_Pieces){
            if(p.getX() == x && p.getY() == y)
                return p;
        }
        return null;
    }

    private MouseAdapter mouseAdapter = new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){

        }

        @Override
        public void mousePressed(MouseEvent e){
            int d_X = e.getX();
            int d_Y = e.getY();
            int Clicked_Row = d_Y / Square_Width;
            int Clicked_Column = d_X / Square_Width;
            boolean is_Whites_Turn = true;
            if(turnCounter % 2 == 1)
                is_Whites_Turn = false;

            Piece clicked_Piece = getPiece(Clicked_Column, Clicked_Row);

            if(Active_Piece == null && clicked_Piece != null &&
               ((is_Whites_Turn && clicked_Piece.isWhite()) || (!is_Whites_Turn && Active_Piece.isBlack())))
                Active_Piece = clicked_Piece;

            else if(Active_Piece != null && Active_Piece.getX() == Clicked_Column && Active_Piece.getY() == Clicked_Row)
                Active_Piece = null;

            else if(Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row) &&
                    ((is_Whites_Turn && clicked_Piece.isWhite()) || (!is_Whites_Turn && Active_Piece.isBlack()))){
                // If piece is there, remove it so we can be there
                if(clicked_Piece != null){
                    if(clicked_Piece.isWhite())
                        White_Pieces.remove(clicked_Piece);
                    else
                        Black_Pieces.remove(clicked_Piece);
                }
                // Do move
                Active_Piece.setX(Clicked_Column);
                Active_Piece.setY(Clicked_Row);

                // If piece is a pawn set has_moved to true
                if(Active_Piece.getClass().equals(Pawn.class)){
                    Pawn castedPawn = (Pawn)(Active_Piece);
                    castedPawn.setHas_moved(true);
                }

                drawBoard();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e){
        }
        @Override
        public void mouseReleased(MouseEvent e){
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e){
        }
    };

    private Image loadImage(String imageFile){
        // https://www.w3schools.com/java/java_try_catch.asp
        try{
            return ImageIO.read(new File(imageFile));
        }
        catch(IOException e){
            return NULL_IMAGE;
        }
    }
}
