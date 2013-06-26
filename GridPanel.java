
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * 
 * @author Brandon
 */
public class GridPanel extends JPanel
{
    private static final int W = 20, H = 20;
    private boolean isBomb, clicked, hover, down;
    private int num, X, Y;
    private SpriteComponent sComp, flag, qMark;
    public Graphics g;
    private boolean flagged = false, marked = false;
    
    /**
     * Set up the grid panel's state, size, and location
     * @param x - local X coordinate of panel
     * @param y - local Y coordinate of panel
     * @param bomb - is it a bomb?
     */
    public GridPanel( int x, int y, boolean bomb )
    {
        super(null);
        isBomb = bomb;
        X = x;
        Y = y;
        this.setLocation(x, y);
        this.setSize(W, H);
        this.setMaximumSize(new Dimension(W, H));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        num = 0;
        clicked = false;
        hover = false;
        down = false;
        this.setVisible(true);
        g = getGraphics();
        
    }
    
    /**
     * 
     * @return - true if square contains a bomb
     */
    public boolean isBomb() { return isBomb; }
    /**
     * 
     * @return - returns number of mines surrounding square
     */
    public int getNum() { return num; }
    /**
     * 
     * @param click
     */
    public void setClicked(boolean click) { clicked = click; updateState(); }
    /**
     * 
     * @param hov
     */
    public void setHover(boolean hov) { hover = hov; if(!clicked) updateState(); }
    /**
     * 
     * @param d
     */
    public void setDown(boolean d) { down = d; if(!clicked) updateState(); }
    /**
     * 
     * @return
     */
    public boolean getClicked() { return clicked; }
    /**
     * 
     * @return
     */
    public boolean getHover() { return hover; }
    /**
     * 
     * @return
     */
    public boolean getDown() { return down; }
    /**
     * 
     * @param n
     */
    public void setNum(int n) 
    { 
        num = n;
        if(!isBomb)
        {
            sComp = new SpriteComponent(Integer.toString(num));
        }
        else
        {
            sComp = new SpriteComponent("bomb");
            
        }
        this.add(sComp);
        this.setLocation(X, Y);
        this.setSize(20, 20);
        this.setBounds(X, Y, W, H);
        this.addMouseListener((MouseListener) this.getParent());
        this.addMouseMotionListener((MouseMotionListener) this.getParent());
        flag = new SpriteComponent("flag");
        qMark = new SpriteComponent("mark");
        this.add(flag);
        this.add(qMark);
    }

    private void updateState() 
    {
        if(clicked)
        {
            this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            sComp.setVisible(true);
            update(this.getGraphics());
        }
        else if(hover)
        {
            this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.YELLOW));
        }
        else if(!hover)
        {
            this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            update(this.getGraphics());
        }
        if(flagged)
        {
            flag.setVisible(true);
            update(this.getGraphics());
        }
        else if(!flagged)
        {
            flag.setVisible(false);
            update(this.getGraphics());
        }
        if(marked)
        {
            qMark.setVisible(true);
            update(this.getGraphics());
        }
        else if(!marked)
        {
            qMark.setVisible(false);
            update(this.getGraphics());
        }
    }

    boolean isFlagged() 
    {
        return flagged;
    }

    void setFlagged(boolean b) 
    {
        flagged = b;
        updateState();
    }

    void setMarked(boolean b) 
    {
        marked = b;
        updateState();
    }

    boolean isMarked() 
    {
        return marked;
    }
}
