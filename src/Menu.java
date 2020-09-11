import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Menu extends MouseAdapter{

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }


    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //play button
        if(Game.gameState == Game.STATE.Menu) {
        if(mouseOver(mx, my, 210, 150, 200, 64)){
            game.gameState = Game.STATE.Select;
            return;
        }
        //Help button
        if(mouseOver(mx, my, 210, 250, 200, 64)){
            Game.gameState = Game.STATE.Help;
        }
        //quit button
        if(mouseOver(mx, my, 210, 350, 200, 64)){
            System.exit(1);
        }
    }
         //Normal button
         if(Game.gameState == Game.STATE.Select) {
            if(mouseOver(mx, my, 210, 150, 200, 64)){
                Game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                
                game.diff = 0;
            }
            //Hard button
            if(mouseOver(mx, my, 210, 250, 200, 64)){
                Game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemys();
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                
                game.diff = 1;
            }
            //back button
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                Game.gameState = Game.STATE.Menu;
            return;
            }
        }

        //back button
        if(Game.gameState == Game.STATE.Help) {
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                Game.gameState = Game.STATE.Menu;
            return;
          }
        }

        //try again
        if(Game.gameState == Game.STATE.End) {
            if(mouseOver(mx, my, 150, 330, 360, 64)){
                Game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
			    hud.setScore(0);
          }
        }
    
        
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            } else return false;
        }else return false;
    }

    public void tick(){

    }

    public void render(Graphics g) {
        if(Game.gameState == Game.STATE.Menu) {

        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 240, 70);

        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("Play", 280, 190);

        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("Help", 280, 290);

        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("Quit", 280, 390);

        g.setColor(Color.WHITE);
        g.drawRect(210, 150, 200, 64);

        g.setColor(Color.WHITE);
        g.drawRect(210, 250, 200, 64);

        g.setColor(Color.WHITE);
        g.drawRect(210, 350, 200, 64);
    }else if(Game.gameState == Game.STATE.Help) {

        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 20);
        Font fnt3 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Help", 255, 70);

        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("Use WASD keys to move a dodge enemies", 110, 200);

        g.setFont(fnt3);
        g.setColor(Color.white);
        g.drawString("Press Space to enter shop", 125, 250);

        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Back", 250, 400);

        g.setColor(Color.WHITE);
        g.drawRect(210, 350, 200, 64);
    } else if(Game.gameState == Game.STATE.End) {

        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 20);
        Font fnt3 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.RED);
        g.drawString("Game Over", 190, 90);

        g.setFont(fnt3);
        g.setColor(Color.CYAN);
        g.drawString("You lost with a score of: " + hud.getScore(), 130, 220);

        g.setFont(fnt);
        g.setColor(Color.GREEN);
        g.drawString("Try AGAIN!", 195, 380);

        g.setColor(Color.WHITE);
        g.drawRect(150, 330, 360, 64);
    }else if(Game.gameState == Game.STATE.Select) {

        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("SELECT DIFFICULTY", 140, 70);

        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("Normal", 280, 190);

        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("Hard", 280, 290);

        g.setFont(fnt2);
        g.setColor(Color.white);
        g.drawString("Back", 280, 390);

        g.setColor(Color.WHITE);
        g.drawRect(210, 150, 200, 64);

        g.setColor(Color.WHITE);
        g.drawRect(210, 250, 200, 64);

        g.setColor(Color.WHITE);
        g.drawRect(210, 350, 200, 64);
    }
    }
}
