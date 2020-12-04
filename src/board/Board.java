package board;

import pieces.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import static board.ChessGUI.black_player;
import static board.ChessGUI.white_player;

/* board.BoardFrame.java
 * By: Faun Schutz
 * Start: 09/11/2020
 * Finish: 04/12/2020
 */
public class Board extends JComponent implements Serializable{
    public static int turnCounter = 0;
    private static final Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

    private final int Square_Width = 65;
    public ArrayList<Piece> White_Pieces;
    public ArrayList<Piece> Black_Pieces;

    public ArrayList<DrawingShape> Static_Shapes;
    public ArrayList<DrawingShape> Piece_Graphics;

    public Piece Active_Piece;

    private final int rows = 8;
    private final int cols = 8;
    private final Integer[][] BoardGrid;
    private final String board_file_path = "images" + File.separator + "board.png";
    private final String active_square_file_path = "images" + File.separator + "active_square.png"; // Will be used later

    public ArrayList<Piece> getBlack_Pieces() {
        return Black_Pieces;
    }
    public ArrayList<Piece> getWhite_Pieces() {
        return White_Pieces;
    }

    public void initGrid(){
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                BoardGrid[i][j] = 0;

        // Image white_piece = loadImage("images/white_pieces/" + piece_name);
        // Image black_piece = loadImage("images/black_pieces/" + piece_name);

        // Need to test if this works
        White_Pieces.add(new King(4,0,true,"King.png",this));
        White_Pieces.add(new Queen(3,0,true,"Queen.png",this));
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

        Black_Pieces.add(new King(3,7,false,"King.png",this));
        Black_Pieces.add(new Queen(4,7,false,"Queen.png",this));
        Black_Pieces.add(new Bishop(2,7,false,"Bishop.png",this));
        Black_Pieces.add(new Bishop(5,7,false,"Bishop.png",this));
        Black_Pieces.add(new Knight(1,7,false,"Knight.png",this));
        Black_Pieces.add(new Knight(6,7,false,"Knight.png",this));
        Black_Pieces.add(new Rook(0,7,false,"Rook.png",this));
        Black_Pieces.add(new Rook(7,7,false,"Rook.png",this));
        Black_Pieces.add(new Pawn(0,6,false,"Pawn.png",this));
        Black_Pieces.add(new Pawn(1,6,false,"Pawn.png",this));
        Black_Pieces.add(new Pawn(2,6,false,"Pawn.png",this));
        Black_Pieces.add(new Pawn(3,6,false,"Pawn.png",this));
        Black_Pieces.add(new Pawn(4,6,false,"Pawn.png",this));
        Black_Pieces.add(new Pawn(5,6,false,"Pawn.png",this));
        Black_Pieces.add(new Pawn(6,6,false,"Pawn.png",this));
        Black_Pieces.add(new Pawn(7,6,false,"Pawn.png",this));
    }

    public Board(){
        BoardGrid = new Integer[rows][cols];
        Static_Shapes = new ArrayList();
        Piece_Graphics = new ArrayList();
        White_Pieces = new ArrayList();
        Black_Pieces = new ArrayList();

        initGrid();

        // these maybe edited later
        setBackground(new Color(37,13,84));
        setPreferredSize(new Dimension(520,520));
        setMinimumSize(new Dimension(100, 100));
        setMaximumSize(new Dimension(1000, 1000));

        addMouseListener(mouseAdapter);
        addComponentListener(componentAdapter);
        addKeyListener(keyAdapter);

        setVisible(true);
        requestFocus();
        drawBoard();
    }

    private void drawBoard(){
        Piece_Graphics.clear();
        Static_Shapes.clear();
        // initGrid();

        if(turnCounter % 2 == 1 && turnCounter != 0)
            BoardFrame.label.setText("Black turn: " + black_player);
        else if(turnCounter % 2 == 0 && turnCounter != 0)
            BoardFrame.label.setText("White turn: " + white_player);

        Image board = loadImage(board_file_path);

        Static_Shapes.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null))));
        if(Active_Piece != null){
            Image active_square = loadImage("images" + File.separator + "active_square.png");
            Static_Shapes.add(new DrawingImage(active_square, new Rectangle2D.Double(Square_Width * Active_Piece.getX(), Square_Width * Active_Piece.getY(), active_square.getWidth(null), active_square.getHeight(null))));
        }
        for(int i = 0; i < White_Pieces.size(); i++){
            int COL = White_Pieces.get(i).getX();
            int ROW = White_Pieces.get(i).getY();

            Image piece = loadImage("images" + File.separator + "white_pieces" + File.separator + White_Pieces.get(i).getFile_Path());
            Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width * COL, Square_Width * ROW, piece.getWidth(null), piece.getHeight(null))));
        }
        for(int i = 0; i < Black_Pieces.size(); i++){
            int COL = Black_Pieces.get(i).getX();
            int ROW = Black_Pieces.get(i).getY();

            Image piece = loadImage("images" + File.separator + "black_pieces" + File.separator + Black_Pieces.get(i).getFile_Path());
            Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width*COL,Square_Width*ROW, piece.getWidth(null), piece.getHeight(null))));
        }
        repaint();
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

    private final MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int d_X = e.getX();
            int d_Y = e.getY();
            int Clicked_Row = d_Y / Square_Width;
            int Clicked_Column = d_X / Square_Width;
            boolean is_Whites_Turn = true;
            if (turnCounter % 2 == 1)
                is_Whites_Turn = false;

            Piece clicked_Piece = getPiece(Clicked_Column, Clicked_Row);

            if (Active_Piece == null && clicked_Piece != null &&
                    ((is_Whites_Turn && clicked_Piece.isWhite()) || (!is_Whites_Turn && clicked_Piece.isBlack())))
                Active_Piece = clicked_Piece;

            else if (Active_Piece != null && Active_Piece.getX() == Clicked_Column && Active_Piece.getY() == Clicked_Row)
                Active_Piece = null;

            else if (Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row) &&
                    ((is_Whites_Turn && Active_Piece.isWhite()) || (!is_Whites_Turn && Active_Piece.isBlack()))) {
                // If piece is there, remove it so we can be there
                if (clicked_Piece != null) {
                    if (clicked_Piece.isWhite())
                        White_Pieces.remove(clicked_Piece);
                    else
                        Black_Pieces.remove(clicked_Piece);
                }
                // Do move
                Active_Piece.setX(Clicked_Column);
                Active_Piece.setY(Clicked_Row);

                // If piece is a pawn set has_moved to true
                if (Active_Piece.getClass().equals(Pawn.class)) {
                    Pawn castedPawn = (Pawn) (Active_Piece);
                    castedPawn.setHas_moved(true);
                }

                // If piece takes an enemy King Game Over, Match Details recorded.
                if (clicked_Piece != null && clicked_Piece.getClass().equals(King.class)) {
                    drawBoard();

                    String match_info;
                    if (clicked_Piece.isWhite()) {
                        JOptionPane.showMessageDialog(null, "Black - " + black_player + " Wins", "Game Over", JOptionPane.INFORMATION_MESSAGE);

                        match_info = "Black: " + black_player + " beats White: " + white_player +
                                " - Black wins in " + (turnCounter / 2 + 1) + " moves.";
                    } else {
                        JOptionPane.showMessageDialog(null, "White - " + white_player + " Wins", "Game Over", JOptionPane.INFORMATION_MESSAGE);

                        match_info = "White: " + white_player + " beats Black: " + black_player +
                                " - White wins in " + (turnCounter / 2 + 1) + " moves.";
                        ;
                    }

                    JOptionPane.showMessageDialog(null, match_info, "Match Details", JOptionPane.INFORMATION_MESSAGE);

                    /* There is an issue with writing to the file with this and I did not have enough time left to figure it out.
                     * I however kept the code for it and the file in for you to look at. */
                    //Records.save_match_details(match_info);

                    System.exit(0);
                }

                Active_Piece = null;
                turnCounter++;
            }

            drawBoard();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }
    };

    private void adjustShapePositions(double dx, double dy){
        // .adjustPosition() need to writ this
        Static_Shapes.get(0).adjustPosition(dx, dy);
        repaint();
    }

    private Image loadImage(String imageFile){
        // https://www.w3schools.com/java/java_try_catch.asp
        try{
            return ImageIO.read(new File(imageFile));
        }
        catch(IOException e){
            return NULL_IMAGE;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        drawBackground(g2);
        drawShapes(g2);
    }

    private void drawBackground(Graphics2D g2){
        g2.setColor(getBackground());
        g2.fillRect(0 ,0, getWidth(), getHeight());
    }

    private void drawShapes(Graphics2D g2){
        for(DrawingShape shape : Static_Shapes)
            shape.draw(g2);
        for(DrawingShape shape : Piece_Graphics)
            shape.draw(g2);
    }

    private final ComponentAdapter componentAdapter = new ComponentAdapter(){
        @Override
        public void componentHidden(ComponentEvent e){
        }
        @Override
        public void componentMoved(ComponentEvent e){
        }
        @Override
        public void componentResized(ComponentEvent e){
        }
        @Override
        public void componentShown(ComponentEvent e){
        }
    };

    private final KeyAdapter keyAdapter = new KeyAdapter(){
        @Override
        public void keyPressed(KeyEvent e){
        }
        @Override
        public void keyReleased(KeyEvent e){
        }
        @Override
        public void keyTyped(KeyEvent e){
        }
    };

    interface DrawingShape{
        //
        boolean contains(Graphics2D g2, double x, double y);
        void adjustPosition(double dx, double dy);
        void draw(Graphics2D g2);
    }

    class DrawingImage implements DrawingShape{
        public Image image;
        public Rectangle2D rect;

        public DrawingImage(Image image, Rectangle2D rect){
            this.image = image;
            this.rect = rect;
        }

        @Override
        public boolean contains(Graphics2D g2, double x, double y){
            return rect.contains(x, y);
        }

        @Override
        public void adjustPosition(double dx, double dy){
            // https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Rectangle2D.Double.html
            rect.setRect(rect.getX() + dx, rect.getY() + dy, rect.getWidth(), rect.getHeight());
        }

        @Override
        public void draw(Graphics2D g2){
            // https://docs.oracle.com/javase/7/docs/api/java/awt/Shape.html
            Rectangle2D bounds = rect.getBounds2D();
            g2.drawImage(image, (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(),
                                            0, 0, image.getWidth(null), image.getHeight(null), null);
        }
    }
}
