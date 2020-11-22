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
	int i=0;
	int pre=LEFT;
	int x=120,y=100;
	Image dowImg,leftImg,rightImg,upImg,currentImg;
	Image [][]image=new Image[4][4];
	public MainCanvas(){
	try{
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(j==3){
					image[i][j]=Image.createImage("/sayo1"+i+".png");
				}else{
					image[i][j]=Image.createImage("/sayo"+j+i+".png");
				}
				
			}
		}
		currentImg=image[1][0];
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
			currentImg=image[2][(i++)%4];
			this.x=this.x-4;
		}else{
			i=0;
			currentImg=image[2][1];
		}	
	}
	if(action==RIGHT){
		if(pre==RIGHT){
			currentImg=image[1][(i++)%4];
			this.x=this.x+4;
		}else{
			i=0;
			currentImg=image[1][1];
		}
	}
	if(action==UP){
		if(pre==UP){
			currentImg=image[3][(i++)%2==1?2:0];
			this.y=this.y-4;
		}else{
			i=0;
			currentImg=image[3][1];
		}		
	}
	if(action==DOWN){
		if(pre==DOWN){
			currentImg=image[0][(i++)%2==1?2:0];
			this.y=this.y+4;
		}else{
			i=0;
			currentImg=image[0][1];
		}
	}
	pre=action;
	repaint();
	}
}

