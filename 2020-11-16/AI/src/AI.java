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
	int pre=LEFT;
	int x=120,y=100;
	Image dowImg,leftImg,rightImg,upImg,currentImg;
	Image [] dow,left,right,up,current;
	public MainCanvas(){
	try{
		dowImg=Image.createImage("/sayo10.png");
		leftImg=Image.createImage("/sayo12.png");
		rightImg=Image.createImage("/sayo16.png");
		upImg=Image.createImage("/sayo14.png");
		dow={Image.createImage("/sayo20.png"),Image.createImage("/sayo10.png"),Image.createImage("/sayo00.png")};
		up={Image.createImage("/sayo24.png"),Image.createImage("/sayo14.png"),Image.createImage("/sayo04.png")};
		left={Image.createImage("/sayo02.png"),Image.createImage("/sayo12.png"),Image.createImage("/sayo22.png")};
		right={Image.createImage("/sayo26.png"),Image.createImage("/sayo16.png"),Image.createImage("/sayo06.png")};
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
		if (pre==LEFT){
			currentImg=left[(i++)%3];
			this.x=this.x-5;
		}else{
			i=0;
			currentImg=leftImg;
		}	
	}
	if(action==RIGHT){
		if(per==RIGHT){
			currentImg=right[(i++)%3];
			this.x=this.x+5;
		}else{
			i=0;
			currentImg=rightImg;
		}
	}
	if(action==UP){
		if(per==UP){
			currentImg=up[(i++)%3];
			this.y=this.y-5;
		}else{
			i=0;
			currentImg=upImg;
		}		
	}
	if(action==DOWN){
		if(per==DOWN){
			currentImg=dow[(i++)%3];
			this.y=this.y+5;
		}else{
			i=0;
			currentImg=dowImg;
		}
	}
	pre=action;
	repaint();
	}
}