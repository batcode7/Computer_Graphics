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

class ThirdGLEventListenerrrrrrr implements GLEventListener {
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
          Zone1 (gl,   0, 100, 100) ;  // the main big circle
          Zone1 (gl,   0,   0,  50) ;  // the down small circle
          Zone1 (gl,   0, 100,  50) ;  // the up small circle
          Zone1 (gl,  50,  50,  50) ;  // the right small circle
          Zone1 (gl, -50,  50,  50) ;  // the left small circle
     }
     
     
     private static void Zone1 (GL2 gl, float x1 , float y1 , float r ) {   
          gl.glColor3d(1, 0, 0);
          gl.glPointSize(3.0f);
          gl.glBegin(GL2.GL_POINTS);
          
          float X1 = x1 ;
          float Y1 = y1 ;
          
          // this if block works if the given format is not (0, r, r)
          if (x1 != 0 || y1 != r){
               x1 = 0 ;
               y1 = r ;
          }
          float d = 1 - r ;
          while (x1 < y1) {
               if ( d < 0) {
                    d = d + 2*x1 + 3 ;
                    x1 = x1 + 1 ;
                    y1 = y1 + 0 ;
                    
                    gl.glVertex2d( y1+X1 ,  x1+(Y1-r)) ; // zone - 0
                    gl.glVertex2d( x1+X1 ,  y1+(Y1-r)) ; // zone - 1
                    gl.glVertex2d(-x1+X1 ,  y1+(Y1-r)) ; // zone - 2
                    gl.glVertex2d(-y1+X1 ,  x1+(Y1-r)) ; // zone - 3
                    gl.glVertex2d(-y1+X1 , -x1+(Y1-r)) ; // zone - 4
                    gl.glVertex2d(-x1+X1 , -y1+(Y1-r)) ; // zone - 5
                    gl.glVertex2d( x1+X1 , -y1+(Y1-r)) ; // zone - 6
                    gl.glVertex2d( y1+X1 , -x1+(Y1-r)) ; // zone - 7
               }else if (d >= 0){
                    d = d + 2*x1 - 2*y1 + 5 ;
                    x1 = x1 + 1 ;
                    y1 = y1 - 1 ;
                    
                    gl.glVertex2d( y1+X1 ,  x1+(Y1-r)) ; // zone - 0
                    gl.glVertex2d( x1+X1 ,  y1+(Y1-r)) ; // zone - 1
                    gl.glVertex2d(-x1+X1 ,  y1+(Y1-r)) ; // zone - 2
                    gl.glVertex2d(-y1+X1 ,  x1+(Y1-r)) ; // zone - 3
                    gl.glVertex2d(-y1+X1 , -x1+(Y1-r)) ; // zone - 4
                    gl.glVertex2d(-x1+X1 , -y1+(Y1-r)) ; // zone - 5
                    gl.glVertex2d( x1+X1 , -y1+(Y1-r)) ; // zone - 6
                    gl.glVertex2d( y1+X1 , -x1+(Y1-r)) ; // zone - 7
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
public class ParthaBhoumik_19101415_10_CSE423Lab3_Code {
     public static void main(String args[]) {
//getting the capabilities object of GL2 profile
          final GLProfile profile=GLProfile.get(GLProfile.GL2);
          GLCapabilities capabilities=new GLCapabilities(profile);
// The canvas
          final GLCanvas glcanvas=new GLCanvas(capabilities);
          ThirdGLEventListenerrrrrrr b=new ThirdGLEventListenerrrrrrr();
          glcanvas.addGLEventListener(b);
          glcanvas.setSize(640, 400);
          
//creating frame
          final JFrame frame=new JFrame("19101415_Task_Frame");
//adding canvas to frame
          frame.add(glcanvas);
          frame.setSize(640,600);
          frame.setVisible(true);
     }
}