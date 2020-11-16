import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x=120,y=100;
	Image dowImg,leftImg,rightImg,upImg,currentImg;
	public MainCanvas(){
	try{
		dowImg=Image.createImage("/sayo10.png");
		leftImg=Image.createImage("/sayo12.png");
		rightImg=Image.createImage("/sayo16.png");
		upImg=Image.createImage("/sayo14.png");
		currentImg=dowImg;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
		currentImg=leftImg;
		System.out.println("向左转");
		this.x=this.x-5;
	}
	if(action==RIGHT){
		currentImg=rightImg;
		System.out.println("向右转");
		this.x=this.x+5;
	}
	if(action==UP){
		currentImg=upImg;
		System.out.println("向上转");
		this.y=this.y-5;
	}
	if(action==DOWN){
		currentImg=dowImg;
		System.out.println("向下转");
		this.y=this.y+5;
	}
	repaint();
	}
}