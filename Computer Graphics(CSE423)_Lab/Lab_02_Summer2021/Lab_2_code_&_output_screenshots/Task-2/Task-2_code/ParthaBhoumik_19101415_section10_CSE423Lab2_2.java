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

class ThirdGLEventListenerrrrrr implements GLEventListener {
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

mid (gl, -70, -15, 70, -15) ; // draws " - "
mid (gl, -100, 10, 100, 10) ; // draws " - "
mid (gl, -100, 10, -70, -15) ; // draws " \ "
mid (gl, 100, 10, 70, -15) ; // draws " / "

mid (gl, 0, 10, 0, 85) ; // draws " | "
mid (gl, -35, 10, 0, 55) ; // draws " / "
mid (gl, 55, 10, 0, 85) ; // draws " \ "

}

//returns the actual zone of the given line
private static int find_Zone (double x1, double y1, double x2,double y2) {
double dx = x2 - x1 ;
double dy = y2 - y1 ;
double a = Math.abs(dx);
double b = Math.abs(dy);
int zone = 0 ;
if (dx >= 0 && dy >= 0) { // dx,dy both positive
if (a > b) {
zone = 0 ;
} else {
zone = 1 ;
}
} else if (dx < 0 && dy >= 0) { // dx negative, dy positive
if (b > a) {
zone = 2 ;
} else {
zone = 3 ;
}

} else if (dx < 0 && dy < 0) { // dx,dy both negative
if (a > b) {
zone = 4 ;
} else {
zone = 5 ;
}
} else if (dx >= 0 && dy < 0) { // dx positive, dy negative
if (b > a) {
zone = 6 ;
} else {
zone = 7 ;
}
}
return zone ;
}

/*converts the given two points from their corresponding zone into zone 0 coordinate
and returns as an array.
*/
private static double [] zone_0_Conversion (double x1, double y1, double x2, double y2, int a) {
double convertedArray [] = new double [4] ;
if ( a == 0) {
convertedArray[0] = x1 ;
convertedArray[1] = y1 ;
convertedArray[2] = x2 ;
convertedArray[3] = y2 ;
}
else if ( a == 1) {
convertedArray[0] = y1 ;
convertedArray[1] = x1 ;
convertedArray[2] = y2 ;
convertedArray[3] = x2 ;
} else if ( a == 2 ) {
convertedArray[0] = y1 ;

convertedArray[1] = -x1 ;
convertedArray[2] = y2 ;
convertedArray[3] = -x2 ;
} else if ( a == 3 ) {
convertedArray[0] = -x1 ;
convertedArray[1] = y1 ;
convertedArray[2] = -x2 ;
convertedArray[3] = y2 ;
} else if ( a == 4 ) {
convertedArray[0] = -x1 ;
convertedArray[1] = -y1 ;
convertedArray[2] = -x2 ;
convertedArray[3] = -y2 ;
} else if ( a == 5 ) {
convertedArray[0] = -y1 ;
convertedArray[1] = -x1 ;
convertedArray[2] = -y2 ;
convertedArray[3] = -x2 ;
} else if ( a == 6 ) {
convertedArray[0] = -y1 ;
convertedArray[1] = x1 ;
convertedArray[2] = -y2 ;
convertedArray[3] = x2 ;
} else if ( a == 7 ) {
convertedArray[0] = x1 ;
convertedArray[1] = -y1 ;
convertedArray[2] = x2 ;
convertedArray[3] = -y2 ;
}
return convertedArray ;
}

//converts the final zone0 coordinate to their original zone coordinate
private static double [] original_zone_Conversion (double x1, double y1, int a) {
double convertedOriginalArray [] = new double [2] ;

if (a == 0) {
convertedOriginalArray[0] = x1 ;
convertedOriginalArray[1] = y1 ;
}
else if (a == 1) {
convertedOriginalArray[0] = y1 ;
convertedOriginalArray[1] = x1 ;
}else if (a == 2) {
convertedOriginalArray[0] = -y1 ;
convertedOriginalArray[1] = x1 ;
}else if (a == 3) {
convertedOriginalArray[0] = -x1 ;
convertedOriginalArray[1] = y1 ;
}else if (a == 4) {
convertedOriginalArray[0] = -x1 ;
convertedOriginalArray[1] = -y1 ;
}else if (a == 5) {
convertedOriginalArray[0] = -y1 ;
convertedOriginalArray[1] = -x1 ;
}else if (a == 6) {
convertedOriginalArray[0] = y1 ;
convertedOriginalArray[1] = -x1 ;
}else if (a == 7) {
convertedOriginalArray[0] = x1 ;
convertedOriginalArray[1] = -y1 ;
}
return convertedOriginalArray ;

}

/* The way "mid" method runs -
step - 1 = calls "find_Zone" method and finds out the zone of the given line ;
step - 2 = calls "zone_0_Conversion" and converts the given points into zone-0 points and stores them in
"convertedToZone0" array ;
step - 3 = stores the converted points

step - 4 = calculates dx, dy and initial d , delE and delNE
step - 5 = then applies the mid point line algorithm

step - 6 = within the mid point while loop whenever it finds the new value of X0 and Y0 they are in zone-
0,

so they are converted to their original zone using the "original_zone_Conversion" method and
then draws that pixel.
*/
private static void mid (GL2 gl,double x1, double y1, double x2,double y2) {
gl.glColor3d(1, 0, 0);
gl.glPointSize(3.0f);
gl.glBegin(GL2.GL_POINTS);

int a = find_Zone(x1, y1, x2, y2) ;
double [] convertedToZone0 = zone_0_Conversion (x1, y1, x2, y2, a) ;
double X1 = convertedToZone0[0] ;
double Y1 = convertedToZone0[1] ;
double X2 = convertedToZone0[2] ;
double Y2 = convertedToZone0[3] ;
double dx = X2 - X1 ;
double dy = Y2 - Y1 ;
double d = 2*dy - dx ;
double delE = 2*dy ;
double delNE = 2*dy - 2*dx ;
double original_zone [] = new double[2] ;

while (X1 < X2) { // mid point line algorithm
if (d <= 0) {
d = d + delE ;
X1 = X1 + 1 ;
Y1 = Y1 + 0 ;
original_zone = original_zone_Conversion (X1, Y1, a) ;
gl.glVertex2d(original_zone[0] , original_zone[1]) ;

}else {
d = d + delNE ;
X1 = X1 + 1 ;

Y1 = Y1 + 1 ;
original_zone = original_zone_Conversion (X1, Y1, a) ;
gl.glVertex2d(original_zone[0] , original_zone[1]) ;
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
public class ParthaBhoumik_19101415_section10_CSE423Lab2_2 {
public static void main(String args[]) {
//getting the capabilities object of GL2 profile
final GLProfile profile=GLProfile.get(GLProfile.GL2);
GLCapabilities capabilities=new GLCapabilities(profile);
// The canvas
final GLCanvas glcanvas=new GLCanvas(capabilities);
ThirdGLEventListenerrrrrr b=new ThirdGLEventListenerrrrrr();
glcanvas.addGLEventListener(b);
glcanvas.setSize(640, 400);

//creating frame
final JFrame frame=new JFrame("19101415_Task-2_Frame");
//adding canvas to frame
frame.add(glcanvas);
frame.setSize(640,600);
frame.setVisible(true);
}
}