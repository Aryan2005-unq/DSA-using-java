import java.io.*;
import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogcolor=image[sr][sc];
        if(ogcolor==color){
            return image;    
        }    
        
        dfs(image,sr,sc,color,ogcolor);
        return image;
        
    }
    public void dfs(int[][] image, int sr, int sc, int color,int ogcolor){
        if(sc<0 || sr<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=ogcolor){
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr,sc+1,color,ogcolor);
        dfs(image,sr,sc-1,color,ogcolor);
        dfs(image,sr-1,sc,color,ogcolor);
        dfs(image,sr+1,sc,color,ogcolor);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int sr=0,sc=0,color=0;
        System.out.println("Enter the Size of the row ofimage grid:");
        
        int m = scn.nextInt();
        System.out.println("Enter the Size of the column ofimage grid:");
         int n = scn.nextInt();
        int[][] image = new int[m][n];
        int i,j;
        System.out.println("Enter the pixel content:");
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.println("Enter the pixel [" + i + "][" + j + "]:");
                image[i][j]= scn.nextInt();
            }
        }
        
        Solution obj = new Solution();
        int[][] result=obj.floodFill(image,sr,sc,color);
        System.out.println("Image after applying flood fill:");
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }
}