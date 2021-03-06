/*
 * All code is made by the author and is
 * not available for use other than the author
 * and his/her team.
 * 
 * Contact the author for details if you want 
 * to use his/her code.
 * 
 * Any unauthorized use of the author's code will 
 * result in the author having full control over the 
 * usage of the code as well as power to confiscate
 * the code. If this header is found deleted, then all
 * of the penalties mentioned above will apply.   
 * 
 * @author Ankur Gupta
 * @date Mar 3, 2015
 */
package Physics;

/**
 *
 * @author ankurgupta
 */
public class PlayerGravitySetup {
    public static int pixelsPerSecond = 300;
    public static int gravitySpeed = PlayerGravitySetup.pixelsPerSecond / 60;
    public static int jumpHeight = 200;
    
    public static int speed = 4;
    public static double acceleration = 9.8;
    public static double velocityInital = Math.sqrt(8.96112);
    public static int ppf = 30;
}
