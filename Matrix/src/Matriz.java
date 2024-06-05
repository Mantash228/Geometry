
import javax.swing.*;
import java.awt.*;

public class Matriz {
    public static void main(String[] args) {
        int n = 500;
        int[][] Z = new int[2*n+1][2*n+1];
        int p = 1;
        for (int i = 0; i < Z.length; i++) {
            for (int j = 0; j < Z[i].length; j++) {
                Z[i][j] = p;
                p++;
            }
        }
        Matriz.ThyFrame zv = new Matriz.ThyFrame(Z);
        zv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zv.show();
    }
    public static boolean Prime(int Prime){
        boolean a = true;
        for (int i = 2; i <= Math.sqrt(Prime); i++) {
            if (Prime%i==0){
                a = false;
                break;
            }
        }
        return a;
    }
    public static class ThyPanel extends JPanel {
        static int[][] zv;
        public ThyPanel(int[][] zv){
            Matriz.ThyPanel.zv = zv;
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for (int i = 0; i < zv.length; i++) {
                for (int j = 0; j < zv[i].length; j++) {
                    if (Prime(zv[i][j])){
                        g.drawOval(j,i,1,1);
                    }
                }
            }
        }
    }
    public static class ThyFrame extends JFrame{
        static int[][] zv;
        public ThyFrame(int[][] zv){
            Matriz.ThyFrame.zv = zv;
            setSize(1000,1000);
            Matriz.ThyPanel a = new Matriz.ThyPanel(zv);
            Container pane = getContentPane();
            pane.add(a);
        }
    }
}