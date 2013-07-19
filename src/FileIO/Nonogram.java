/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Owner
 */
public class Nonogram {
    
    private int BMPboard[][];
    private ArrayList row[];
    private ArrayList col[];
    private int width;
    private int height;
    
    public Nonogram(String filename){
        BMPboard = BMP.read(filename);
        width = BMPboard[0].length;
        height = BMPboard.length;
        process();
    }
    
    
    public void printArray(){
        for(int i=0; i<BMPboard.length; i++){
            for(int j=0; j<BMPboard[i].length; j++){
                System.out.print(BMPboard[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
    public int[][] getArray(){
        return BMPboard;
    }
    
    public void printRows(){
        for(int i=0; i<row.length; i++){
            for(int s=0; s < row[i].size(); s++){
                System.out.print(row[i].get(s)+" ");
            }
            System.out.println();
        }
    }
    
    public void printColumns(){
        for(int i=0; i<col.length; i++){
            for(int s=0; s < col[i].size(); s++){
                System.out.print(col[i].get(s)+" ");
            }
            System.out.println();
        }
    }
    
    private void process(){
        row = new ArrayList[BMPboard.length];
        col = new ArrayList[BMPboard[0].length];
        
        boolean start;
        
        for(int i=0; i<row.length; i++){
            
            start = false;
            int hor_count = 0;
            row[i] = new ArrayList();
            
            for(int j=0; j<col.length; j++){
                
                
                if(BMPboard[i][j]==0){
                    if(start==false){
                        start = true;
                    }
                    hor_count++;
                }else{
                    if(start==true){
                        row[i].add(hor_count);
                        hor_count = 0;
                        start = false;
                    }
                }
            }
            
            if(start==true){
                row[i].add(hor_count);
            }
            
            if(row[i].isEmpty()){
                row[i].add((int) 0);
            }
        }
        
        for(int j=0; j<col.length; j++){
            
            start = false;
            int hor_count = 0;
            col[j] = new ArrayList();
            
            for(int i=0; i<row.length; i++){
                
                if(BMPboard[i][j]==0){
                    
                    if(start==false){
                        start = true;
                    }
                    hor_count++;
                    
                }else{
                    if(start==true){
                        col[j].add(hor_count);
                        hor_count = 0;
                        start = false;
                    }
                }
            }
            
            if(start==true){
                col[j].add(hor_count);
            }
            
            if(col[j].isEmpty()){
                col[j].add((int) 0);
            }
        }
    }
    
    public int width(){
        return width;
    }
    
    public int height(){
        return height;
    }
    
    public int[] rowList(int index){
        Object tmp[] = row[index].toArray();
        int a[] = new int[tmp.length];
        for(int i=0; i<a.length; i++){
            a[i] = (Integer) tmp[i];
        }
        return a;  
    }
    
    public int[] columnList(int index){
       
        Object tmp[] =  col[index].toArray();
        int a[] = new int[tmp.length];
        for(int i=0; i<a.length; i++){
            a[i] = (Integer) tmp[i];
        }
        return a;  
    }
        
    
    public int maxRowWidth(){
        int max = 0;
        
        for(int r = 0; r < row.length; r++){
            if(row[r].size()>max){
                max = row[r].size();
            }
        }
        
        return max;
    }
    
    public int maxColumnHeight(){
        
        int max = 0;
        
        for(int c = 0; c < col.length; c++){
            if(col[c].size()>max){
                max = col[c].size();
            }
        }
        
        return max;
        
    }
    
    public static void main(String args[]){
        Nonogram n = new Nonogram("test.bmp");
        n.printArray();
        System.out.println();
        n.printRows();
        System.out.println();
        n.printColumns();
        System.out.println();
        System.out.println("Max Row Width: "+n.maxRowWidth());
        System.out.println("Max Column Height: "+n.maxColumnHeight());
        
    }
    
    
}
