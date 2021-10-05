import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;

class ThirdGLEventListener implements GLEventListener {
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
    gl.glPointSize(3.0f);
    gl.glBegin(GL2.GL_LINES);
    
    gl.glVertex2d(-50, 20);
    gl.glVertex2d(-20, 50);
    
    gl.glVertex2d(-20, 50);
    gl.glVertex2d(10, 20);
    
    gl.glVertex2d(-20, 50);
    gl.glVertex2d(70, 50);
    
    
    
    gl.glVertex2d(70, 50);
    gl.glVertex2d(100, 20);
    
    gl.glVertex2d(10, 20);
    gl.glVertex2d(100, 20);
    
    gl.glVertex2d(-45, -10);
    gl.glVertex2d(-45, 25);
    
    gl.glVertex2d(5, -22);
    gl.glVertex2d(5, 25);
    
    gl.glVertex2d(95, 20);
    gl.glVertex2d(95, -10);
    
    gl.glVertex2d(-45, -10);
    gl.glVertex2d(5, -22);
    
    gl.glVertex2d(5, -22);
    gl.glVertex2d(95, -10);
    
    gl.glVertex2d(45, 0);
    gl.glVertex2d(45, -17);
    
    gl.glVertex2d(55, 0);
    gl.glVertex2d(55, -15);
    
    gl.glVertex2d(55, 0);
    gl.glVertex2d(45, 0);
    
    gl.glVertex2d(-25, 15);
    gl.glVertex2d(-25, 5);
    
    gl.glVertex2d(-15, 15);
    gl.glVertex2d(-15, 5);
    
    gl.glVertex2d(-25, 15);
    gl.glVertex2d(-15, 15);
    
    gl.glVertex2d(-25, 5);
    gl.glVertex2d(-15, 5);
    
    
    
    gl.glEnd();
    
    gl.glBegin(GL2.GL_POINTS);
    gl.glVertex2d(48, -10);
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
public class task02_19101415
{
public static void main(String args[])
{
 //getting the capabilities object of GL2 profile
 final GLProfile profile=GLProfile.get(GLProfile.GL2);
 GLCapabilities capabilities=new GLCapabilities(profile);
 // The canvas
 final GLCanvas glcanvas=new GLCanvas(capabilities);
 ThirdGLEventListener b=new ThirdGLEventListener();
 glcanvas.addGLEventListener(b);
 glcanvas.setSize(400, 400);
 //creating frame
 final JFrame frame=new JFrame("Task 2 Frame");
 //adding canvas to frame
 frame.add(glcanvas);
 frame.setSize(640,480);
 frame.setVisible(true);
}
}

