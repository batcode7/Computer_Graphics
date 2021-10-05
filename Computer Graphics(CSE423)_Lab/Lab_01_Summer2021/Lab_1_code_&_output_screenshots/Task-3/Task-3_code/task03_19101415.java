import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;

class ThirdGLEventListenerrrr implements GLEventListener {
/**
 * Interface to the GLU library.
 */
private GLU glu;

/**
 * Take care of initialization here.
 */
public void init(GLAutoDrawable gld) {
    GL2 gl = gld.getGL().getGL2();
    glu = new GLU();

    gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    gl.glViewport(-250, -150, 250, 150);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
}



/**
 * Take care of drawing here.
 */
public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();

    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    
    
    DDA (gl,-60,-40,-60,100);
    DDA (gl, 60,-40,60,100);
    DDA (gl, -60,29,59,29);
    
   // DDA (gl, -45,-40,-45,40);
   // DDA (gl, 45,-40,45,40);
    
}

private void DDA ( GL2 gl, float x1, float y1, float x2 , float y2) {
	gl.glColor3d(1, 0, 0);
	gl.glPointSize(3.0f);
	
	float x = x1 ;
	float y = y1 ;
	gl.glBegin(GL2.GL_POINTS);
	float m = (y2-y1)/(x2-x1);
	gl.glVertex2d( x, y);
	if ( m > -1 && m < 1 ) {
	  while (x <=x2) {
		  x = x+1*3 ;
		  y = y + m*3;
		  gl.glVertex2d( x, y);
	  }
	}else {
		while (y <=y2) {
			  y = y+1*3 ;
			  x = x + (1/m)*3 ;
			  gl.glVertex2d( x, y);
		  }
	}
	
	
	
	gl.glEnd();
	
}

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}

public void dispose(GLAutoDrawable arg0)
{
 
}
}
public class task03_19101415
{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListenerrrr b=new ThirdGLEventListenerrrr();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(400, 400);
 //creating frame
 final JFrame frame=new JFrame("Task 3 Frame");
 //adding canvas to frame
 frame.add(glcanvas);
 frame.setSize(640,480);
 frame.setVisible(true);
}
}

