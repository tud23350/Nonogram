/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import FileIO.Nonogram;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class GridPane extends JPanel {

    private final int GRID_SIZE = 30;
    private final Dimension BOX_DIM = new Dimension(GRID_SIZE, GRID_SIZE);
    private JPanel tile[][];
    private Nonogram n;

    public GridPane(Nonogram n) {
        this.n = n;
        int count = 0; // use to give a name to each box so that you can refer to them later
        setLayout(new GridLayout(n.height() + n.maxColumnHeight(), n.width() + n.maxRowWidth()));
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tile = new JPanel[n.height()][n.width()];
        int maxHeight = n.maxColumnHeight();
        for (int r = 0; r < maxHeight; r++) {
            
            for( int i = 0; i < n.maxRowWidth(); i++ ){
                add(new EmptyTile(BOX_DIM));
            }
            
            for (int c = 0; c < n.width(); c++) {
                
                int colList[] = n.columnList(c);
                
                if(maxHeight - colList.length > r){
                    add(new EmptyTile(BOX_DIM));
                }else{
                    System.out.println(Arrays.toString(colList));
                    System.out.println(colList.length);
                    int difference = n.maxColumnHeight() - colList.length;
                    add(new NumberTile(BOX_DIM, colList[r-difference]));
                }
                
            }
        }
        
        for (int r = 0; r < n.height(); r++) {

            int rowList[] = n.rowList(r);


            for (int filler = rowList.length; filler < n.maxRowWidth(); filler++) {
                add(new EmptyTile(BOX_DIM));
            }

            for (int i = 0; i < rowList.length; i++) {
                add(new NumberTile(BOX_DIM, rowList[i]));
            }


            for (int c = 0; c < n.width(); c++) {

                tile[r][c] = new JPanel();
                tile[r][c].setEnabled(true);
                tile[r][c].setBackground(Color.WHITE);
                tile[r][c].setPreferredSize(BOX_DIM);
                tile[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                tile[r][c].addMouseListener(new BoxListener(n, this));
                tile[r][c].setName(getName(r, c));
                ++count;
                add(tile[r][c]);
                /*JPanel pan = new JPanel();
                
                 pan.setEnabled(true);
                 pan.setBackground(Color.WHITE);
                 pan.setPreferredSize(BOX_DIM);
                 pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                 pan.addMouseListener(new BoxListener(n)); // add a mouse listener to make the panels clickable
                 pan.setName( getName(r, c) );
                 ++count;
                 add(pan);
                 */
            }
        }

    }

    private String getName(int row, int col) {
        String s = "";
        if (row < 10) {
            s += "0";
        }
        s += String.valueOf(row);

        if (col < 10) {
            s += "0";
        }
        s += String.valueOf(col);
        return s;
    }

    public boolean isCorrect() {
        int board[][] = n.getArray();

        for (int r = 0; r < n.height(); r++) {

            for (int c = 0; c < n.width(); c++) {

                if (board[r][c] == 0 && tile[r][c].getBackground().equals(Color.BLACK) == false) {
                    return false;
                } else if (board[r][c] == 1 && tile[r][c].getBackground().equals(Color.BLACK) == true) {
                    return false;
                }

            }

        }

        return true;
    }
}
