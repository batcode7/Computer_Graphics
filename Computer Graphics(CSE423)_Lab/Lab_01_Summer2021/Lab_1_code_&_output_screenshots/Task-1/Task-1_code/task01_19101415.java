import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;
import java.util.Random;

class ThirdGLEventListenerrr implements GLEventListener {
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
    gl.glColor3d(1, 0, 0);
    gl.glPointSize(10.0f);
    gl.glBegin(GL2.GL_POINTS);
    
  
    Random random = new Random() ;
    int x,y;
    int i = 0;
    while ( i < 50 ) { 
    	 x = random.nextInt(150) ;
    	 y = random.nextInt(100) + 5 ;
    	 gl.glVertex2d(x,y);
    	 i++ ;
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
public class task01_19101415
{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListenerrr b=new ThirdGLEventListenerrr();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(640, 400);
 //creating frame
 final JFrame frame=new JFrame("Task 1 Frame");
 //adding canvas to frame
 frame.add(glcanvas);
 frame.setSize(640,600);
 frame.setVisible(true);
}
}


