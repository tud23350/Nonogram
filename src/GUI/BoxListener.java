/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import FileIO.Nonogram;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
//Class that defines what happens (i.e: the color changes) when a panel is clicked
    public class BoxListener extends MouseAdapter
    {
        Nonogram n;
        GridPane gridPane;
        
        public BoxListener(Nonogram n, GridPane gridPane){
            this.n = n;
            this.gridPane = gridPane;
        }
        
    	public void mouseClicked(MouseEvent me)
    	{
              JPanel clickedBox =(JPanel)me.getSource(); // get the reference to the box that was clicked 
              
              System.out.println(clickedBox.getName());
              
              if(clickedBox.getBackground().equals(Color.WHITE)){
                clickedBox.setBackground(Color.BLACK);
              }else{
                  clickedBox.setBackground(Color.WHITE);
              }
              
              System.out.println(gridPane.isCorrect());
              
        }
    }
