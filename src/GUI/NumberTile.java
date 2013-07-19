/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;

/**
 *
 * @author Owner
 */
public class NumberTile extends JPanel{
    
    private int number;
    private JLabel numberLabel;
    private Map fontMap;
    private Font originalFont;
    
    public NumberTile(Dimension dim, int number){
        super(new BorderLayout());
        numberLabel = new JLabel(String.valueOf(number), JLabel.CENTER);
        originalFont = numberLabel.getFont();
        fontMap = originalFont.getAttributes();
        fontMap.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        numberLabel.setFont(originalFont.deriveFont(fontMap));
        
        setEnabled(true);
        setBackground(Color.WHITE);
        setPreferredSize(dim);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        add(numberLabel);
        
        this.number = number;
    }
    
}
