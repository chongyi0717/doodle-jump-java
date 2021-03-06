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
package World;

import Entity.Entity;
import Player.Player;
import Player.Score;
import Util.DebugGuiHandler;
import Util.DrawImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Platform implements Entity{
    public Rectangle platform;
    private Color color;
    private int score;
    private boolean isHit = false;
    BufferedImage sprite;
    DrawImage di;
    
    public Platform(int x, int y, Color color, int scoreWorth, String file) {
        this.di = new DrawImage();
        this.sprite = di.load("World/"+file);
        this.platform = new Rectangle(x, y, this.sprite.getWidth(), this.sprite.getHeight());
        this.score = scoreWorth;
        this.color = color;
    }
    public void changeY(int newY){
        this.platform.y = newY;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void tick() {
        if(Player.rect.intersects(platform)) {
            addToScore();
            Player.gravity.changeDirection();
            Player.gravity.changeThreshold(Player.rect.y);
            specialFunction();
        }
    }
    public void addToScore() {
        if(this.isHit == false) {
            Score.SCORE += this.score;
            this.isHit = true;
        }
    }
    
    public void render(Graphics g) {
        g.setColor(this.color);
        g.drawImage(sprite, this.platform.x, this.platform.y, this.platform.width, this.platform.height, null);
        
        if(DebugGuiHandler.debugGUIEnabled == true) {
            g.drawRect(this.platform.x, this.platform.y, this.platform.width, this.platform.height);
        }
    }
    public abstract void specialFunction();
}
