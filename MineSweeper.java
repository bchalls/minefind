
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author Brandon
 */
public class MineSweeper extends JFrame
{
    private static MineSweeperGrid grid;
    private static boolean playing = false, running = true;
    private static MineSweeper sweeper;
    private static String difficulty;
    private static Timer gameUpdate;
    
    /**
     * 
     */
    public MineSweeper()
    {
        super("MineSweeper");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        sweeper = new MineSweeper();
        Graphics g = sweeper.getGraphics();
        sweeper.setResizable(false);
        sweeper.setVisible(true);
        sweeper.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        difficulty = "beginner";
        
        grid = newGame(difficulty);
        
       
        //grid.setLocation(5, 20);
    }
    
    private static MineSweeperGrid newGame(String level)
    {
        if(grid != null)
            sweeper.remove(grid);
        grid = new MineSweeperGrid(level, sweeper);
        
        //sweeper.setSize((20*grid.numTilesW)+7, 47 + (25*grid.numTilesH));
        sweeper.addMouseListener(grid);
        sweeper.addMouseMotionListener(grid);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Game");
        JMenuItem menuItem = new JMenuItem("Beginner", KeyEvent.VK_B);
        menuItem.setActionCommand("newBeginnerGame");
        menuItem.addActionListener(grid);
        menu.add(menuItem);

        menuItem = new JMenuItem("Intermediate", KeyEvent.VK_M);
        menuItem.setActionCommand("newIntermediateGame");
        menuItem.addActionListener(grid);
        menu.add(menuItem);

        menuItem = new JMenuItem("Expert", KeyEvent.VK_X);
        menuItem.setActionCommand("newExpertGame");
        menuItem.addActionListener(grid);
        menu.add(menuItem);

        menuItem = new JMenuItem("Quit", KeyEvent.VK_U);
        menuItem.setActionCommand("quitGame");
        menuItem.addActionListener(grid);
        menu.add(menuItem);

        menuBar.add(menu);

        menu = new JMenu("Help");
        menuItem = new JMenuItem("About", KeyEvent.VK_A);
        menuItem.setActionCommand("showAboutBox");
        menuItem.addActionListener(grid);
        menu.add(menuItem);

        menuBar.add(menu);
        sweeper.setJMenuBar(menuBar);

        sweeper.add(grid);

        sweeper.paintAll(sweeper.getGraphics());
        
        return grid;
    }
    
    /**
     * 
     * @param level
     */
    public void setDifficulty(String level)
    {
        difficulty = level;
        newGame(level);
    }
    /**
     * 
     * @param tf
     */
    public void setPlaying(boolean tf)
    {
        playing = tf;
    }
    /**
     * 
     * @param tf
     */
    public void setRunning(boolean tf)
    {
        running = tf;
    }
}
