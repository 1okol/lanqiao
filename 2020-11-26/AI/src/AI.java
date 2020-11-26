import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.Random;

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
class MainCanvas extends Canvas implements Runnable
{
	Random rand =new Random();
	Thread thread=new Thread(this);
	int i=0;
	int pre=LEFT;
	int x=120,y=100;
	int prex=120,prey=100;
	int bossX,bossY;
	Image bossImg;
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
		bossImg=Image.createImage("/bishamonten.png");
		currentImg=image[1][1];
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		thread.start();
	}
	public void run(){
		while(true){
			if(rand.nextInt(5)!=0){
				if(bossX<x){
				bossX+=3;
				}else if(bossX>x){
					bossX-=3;
				}
				if(bossY<y){
					bossY+=3;
				}else if(bossY>y){
					bossY-=3;
				}
			}else{
				bossY+=(rand.nextInt(4)-4);
				bossX+=(rand.nextInt(4)-4);
			}
			repaint();
				try{
				thread.sleep(300);
			}catch(InterruptedException e){

			e.printStackTrace();}
		}
	}

	public void paint(Graphics g){
				g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
		g.drawImage(bossImg,bossX,bossY,0);
		
	}
	public void move(int key,int move){
		if(pre!=key){
			i=0;
		}
		currentImg=image[move][(i++)%4];
		pre=key;
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
		move(LEFT,2);
		this.x=this.x-4;		
	}
	if(action==RIGHT){
		move(RIGHT,1);
		this.x=this.x+4;
	}
	if(action==UP){
		move(UP,3);
		this.y=this.y-4;		
	}
	if(action==DOWN){
		move(DOWN,0);
		this.y=this.y+4;
	}
	if(x>220||y>265||x<0||y<0){
		x=prex;
		y=prey;
	}else{
		prex=x;
		prey=y;
	}
	pre=action;
	repaint();
	}
}

