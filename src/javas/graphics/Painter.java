package javas.graphics;

import java.awt.Graphics;
import java.awt.Color;

public class Painter {
    int x,y;

    private double angle=270;

    private Graphics g;

    private boolean isShowThisPoint=false;

    Painter(){throw new IllegalArgumentException("Graphics Object is not set.");}

    Painter(int x,int y,Graphics g){
        this.x=x;
        this.y=y;
        this.g=g;
    }

    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        angle%=360;
        this.angle = angle;
    }

    public void moveAngle(double diff){
        this.setAngle(this.angle+diff);
    }

    public void right(double diff){
        if(diff<0)throw new IllegalArgumentException("this \"diff\" must be positive");
        this.moveAngle(-diff);
    }

    public void left(double diff){
        if(diff<0)throw new IllegalArgumentException("this \"diff\" must be positive");
        this.moveAngle(diff);
    }

    public void move(double x,double y){
        if(isShowThisPoint)drawThisPoint();
        x=this.x;
        y=this.y;
    }

    public void moveTo(double dx,double dy){
        if(isShowThisPoint)drawThisPoint();
        this.x+=dx;
        this.y+=dy;
    }

    // 描画処理メゾット

    public void drawLine(double distance){
        
        double angle_radian=Math.toRadians(this.angle);

        double dx=distance*Math.cos(angle_radian);
        double dy=distance*Math.sin(angle_radian);

        double x1=this.x;
        double y1=this.y;

        this.moveTo(dx, dy);

        this.g.drawLine((int)x1, (int)y1, (int)this.x, (int)this.y);
    }

    public void setColor(Color c){
        this.g.setColor(c);
    }

    public void isShowThisPoint(boolean isShowThisPoint){
        this.isShowThisPoint=isShowThisPoint;
    }

    private void drawThisPoint(){
        Color nowColor=this.g.getColor();

        this.g.setColor(new Color(239,174,4));

        this.g.fillOval(this.x-5, this.y-5, 10, 10);

        this.g.setColor(nowColor);
    }
    
}
