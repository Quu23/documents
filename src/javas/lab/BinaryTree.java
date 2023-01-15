package javas.lab;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BinaryTree extends JFrame {

    JPanel canvas;

    final double ANGLE = Math.toRadians(45);
    final int FIRST_BRANCH_LENGTH=50;
    final int MAX_GENERATION=5;

    int[] position={/*start position x=*/250,/*start position y=*/430};

    public static void main(String[] args) {
        BinaryTree window = new BinaryTree("test");

        window.position[0]=250;
        window.position[1]=430;
        System.out.println("スタート");
        window.canvas.repaint();

        System.out.println("描画完了");
    }

    public BinaryTree(String title){
        this.setTitle(title);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.red);
                g.drawLine(position[0],position[1], position[0], position[1]-FIRST_BRANCH_LENGTH);
                position[1]-=FIRST_BRANCH_LENGTH;

                draw(g,1,ANGLE);
                
                draw(g,1,Math.PI-ANGLE);
            }
        };
        this.add(canvas);
        this.setVisible(true);
    }


    private void draw(Graphics g,int count,double angle) {
        if(count>MAX_GENERATION)return;

        double dx = (FIRST_BRANCH_LENGTH-20)*Math.cos(angle);
        double dy = (FIRST_BRANCH_LENGTH-20)*Math.sin(-angle);

        g.drawLine(position[0],position[1],position[0]+ (int)(dx), position[1]+(int)(dy));
        
        position[0]+=dx;
        position[1]+=dy;

        System.out.println("x:"+position[0]+"/y:"+position[1]);

        count++;

        draw(g,count,ANGLE);

        position[0]-=2*(int)dx;
        draw(g,count,Math.PI-ANGLE);


        position[0]+=dx;
        position[1]-=dy;
    }

}