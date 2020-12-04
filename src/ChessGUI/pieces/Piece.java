package ChessGUI.pieces;
import ChessGUI.board.Board;
/* Piece.java
 * By: Faun Schutz
 * Start: 10/11/2020
 * Finish: 13/11/2020
 */
public class Piece {
    private int x;
    private int y;
    final private boolean is_white;
    private String file_Path;
    public Board board;

    public Piece(int x, int y, boolean is_white, String file_path, Board board){
        this.is_white = is_white;
        this.x = x;
        this.y = y;
        this.file_Path = file_path;
        this.board = board;
    }

    public String getFile_Path(){
        return file_Path;
    }
    public void setFile_Path(String file_path){
        this.file_Path = file_path;
    }
    public boolean isWhite(){
        return is_white;
    }
    public boolean isBlack(){
        return !is_white;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean canMove(int destination_x, int destination_y){
        return false;
    }
}
