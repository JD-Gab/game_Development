package gameDevPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Mock up game by Dr.Fuentes
//Sprite file incharged - John Joms

public class BasicSpriteGame1 extends JFrame implements KeyListener, ActionListener {
    private ImageIcon warriorImage;
    private ImageIcon backgroundImage; // Background image
    private int warriorX = 0; // X-coordinate of the warrior
    private int warriorY = 400; // Y-coordinate of the warrior
    private boolean warriorVisible = true;
    private Timer timer;
    //private Image offscreenImage;

    public BasicSpriteGame1() {
        setTitle("Basic Sprite Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Load the warrior sprite image (replace "warrior.gif" with your image file)
        warriorImage = new ImageIcon("character.gif");

        // Load the background image (replace "back.png" with your image file)
        backgroundImage = new ImageIcon("C:\\Users\\user\\Documents\\Gabutin_John-Daryll_GameDev_Output\\Sprite sheet\\bg.gif");
        
        //offscreenImage = createImage(getWidth(), getHeight());

        // Set up a timer for animation
        timer = new Timer(10000, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paint(Graphics g) {
        super.paint(g);
        //Graphics offscreenGraphics = offscreenImage.getGraphics();

        // Draw the background image only once
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
        //offscreenGraphics.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
       

        // Draw the warrior if it's visible
        if (warriorVisible) {
            warriorImage.paintIcon(this, g, warriorX, warriorY);
        }
        
        /*if (warriorVisible) {
            warriorImage.paintIcon(this, offscreenGraphics, warriorX, warriorY);
        }*/
        
        //g.drawImage(offscreenImage, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Repaint the frame to update animation
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for this example
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Move the warrior left when the left arrow key is pressed
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            warriorX -= 10;
        }

        // Move the warrior right when the right arrow key is pressed
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            warriorX += 10;
        }
        
     // Move the warrior up when the up arrow key is pressed
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            warriorY -= 10;
        }
        
     // Move the warrior down when the down arrow key is pressed
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            warriorY += 10;
        }

        // Make the warrior disappear when the spacebar is pressed
        if (key == KeyEvent.VK_SPACE) {
            warriorVisible = !warriorVisible;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for this example
    	
    	int key = e.getKeyCode();
    	// Make the warrior appear when the spacebar is released
        if (key == KeyEvent.VK_SPACE) {
            if (warriorVisible = !warriorVisible) {
            	warriorVisible = warriorVisible;
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            BasicSpriteGame1 game = new BasicSpriteGame1();
            game.setVisible(true);
        });
    }
}