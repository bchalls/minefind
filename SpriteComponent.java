import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Brandon
 */
public class SpriteComponent extends JLabel
{
    public BufferedImage image;
    private String name;
    //<editor-fold defaultstate="collapsed" desc="spriteData">
    private static char[][] spriteData =
    {
        ("          " +
            "    11    " +
            " 11111    " +
            "    11    " +
            "    11    " +
            "    11    " +
            "    11    " +
            "    11    " +
            " 11111111 " +
            "          ").toCharArray(),
        
        ("          " +
            "   2222   " +
            " 22    22 " +
            "       22 " +
            "       22 " +
            "     22   " +
            "   22     " +
            " 22       " +
            " 22222222 " +
            "          ").toCharArray(),
        
        ("          " +
            "   3333   " +
            " 33    33 " +
            "       33 " +
            "   3333   " +
            "       33 " +
            "       33 " +
            " 33    33 " +
            "   3333   " +
            "          ").toCharArray(),
        
        ("          " +
            "      44  " +
            "    4444  " +
            "  44  44  " +
            " 44444444 " +
            "      44  " +
            "      44  " +
            "      44  " +
            "     4444 " +
            "          ").toCharArray(),
        
        ("          " +
            " 55555555 " +
            " 55       " +
            " 55       " +
            "   5555   " +
            "       55 " +
            "       55 " +
            " 55    55 " +
            "   5555   " +
            "          ").toCharArray(),
        
        ("          " +
            "   666666 " +
            "  66      " +
            " 66       " +
            " 66 666   " +
            " 666   66 " +
            " 66    66 " +
            " 66    66 " +
            "   6666   " +
            "          ").toCharArray(),
        
        ("          " +
            " 77777777 " +
            " 77    77 " +
            "      77  " +
            "     77   " +
            "    77    " +
            "    77    " +
            "   77     " +
            "   77     " +
            "          ").toCharArray(),
        
        ("          " +
            "   8888   " +
            " 88    88 " +
            " 88    88 " +
            "   8888   " +
            " 88    88 " +
            " 88    88 " +
            " 88    88 " +
            "   8888   " +
            "          ").toCharArray(),
        
        ("          " +
            "   9999   " +
            " 99    99 " +
            " 99  9999 " +
            "   99  99 " +
            "       99 " +
            "       99 " +
            "     99   " +
            "   99     " +
            "          ").toCharArray(),
        
        ("          " +
            "   0000   " +
            " 00    00 " +
            " 00    00 " +
            " 00    00 " +
            " 00    00 " +
            " 00    00 " +
            " 00    00 " +
            "   0000   " +
            "          ").toCharArray(),
        
           ("R YRY R   " +
            "  RWWR    " +
            "   WWW    " +
            "  BBBBBB  " +
            " BSSSWWGB " +
            "BSSSSSSWSB" +
            "BSSSSSSWSB" +
            "BSSSSSSSSB" +
            " BSSSSSSB " +
            "  BBBBBB  ").toCharArray(),
        
           ("  BBBBBB  " +
            " BYYYYYYB " +
            "BYYYYYYYYB" +
            "BYBBYYBBYB" +
            "BYBBYYBBYB" +
            "BYYYYYYYYB" +
            "BYBYYYYBYB" +
            "BYYBBBBYYB" +
            " BYYYYYYB " +
            "  BBBBBB  ").toCharArray(),
        
           ("  BBBBBB  " +
            " BYYYYYYB " +
            "BBYBYYBYBB" +
            "BYBYYYYBYB" +
            "BBYBYYBYBB" +
            "BYYYYYYYYB" +
            "BYYBBBBYYB" +
            "BYBYYYYBYB" +
            " BYYYYYYB " +
            "  BBBBBB  ").toCharArray(),
        
        ("          " +
            "          " +
            "          " +
            "          " +
            "          " +
            "          " +
            "          " +
            "          " +
            "          " +
            "          ").toCharArray(),
        
           ("     WWWBB" +
            "  WWW000BB" +
            "WW000000BB" +
            "W0000000BB" +
            "W0000000BB" +
            " WWWWWWBB " +
            "       BB " +
            "      BB  " +
            "      BB  " +
            "    BBBBBB").toCharArray(),
           
           (" BBBBBBB  " +
            "BWWWWWWWB " +
            "BWWBBBBWWB" +
            " BWB  BWWB" +
            "     BWWB " +
            "    BBBB  " +
            "          " +
            "    BBBB  " +
            "    BWWB  " +
            "    BBBB  ").toCharArray(),
           
           ("  BBBBBB  " +
            " BYYYYYYB " +
            "BBBWYYBWBB" +
            "BYBBBBBBYB" +
            "BYBBYYBBYB" +
            "BYYYYYYYYB" +
            "BYBBBBBBYB" +
            "BYYBBBBYYB" +
            " BYYYYYYB " +
            "  BBBBBB  ").toCharArray(),
            
    };
    //</editor-fold>
    
    /**
     * 
     * @param n
     */
    public SpriteComponent(String n)
    {
        super();
        name = n;
        super.setName(name);
        image = createSprite(name);
        this.setSize(20, 20);
        this.setLocation(0, 0);
        this.prepareImage(image, this.getParent());
        this.setIcon(new ImageIcon(image));
        this.setVisible(false);
        
        
        
    }
    
    /**
     * 
     * @param n
     */
    public void setNumImage(int n)
    {
        image = createSprite(n);
        this.prepareImage(image, this.getParent());
        this.setIcon(new ImageIcon(image));
    }
    
    private BufferedImage createSprite(int n)
    {
        int dat = 0;
        BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        //int[] buffer = ((DataBufferInt) img.getData().getDataBuffer()).getData();
        int color = 0xFFFF0000;
        char curChar;
        dat = n - 1;
        if(dat == -1)
            dat = 9;
        
        int count = 0;
        for(int x = 0; x < 20; x++)
        {
            for(int y = 0; y < 20; y++)
            {
                
                curChar = spriteData[dat][((x/2)*10 + (y/2)%10)];
                
                color = 0xFFFF0000;
                if(curChar == ' ') color = 0x00000000;

                //buffer[(y%10)+(x*10)] = color;
                img.setRGB(y,x, color);
            }
        }
        return img;
    }
    
    @Override
    public void paintComponents(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(image, 0, 0, this.getParent());
    }

    
    private BufferedImage createSprite(String n)
    {
        int dat = 0;
        BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        //int[] buffer = ((DataBufferInt) img.getData().getDataBuffer()).getData();
        int color = 0x00000000;
        char curChar;
        try
        {
            dat = Integer.parseInt(n) - 1;
        }catch(NumberFormatException e)
        {
            System.out.println(e.getMessage());
        };
        if(dat == -1)
            dat = 13;
        if(n.equalsIgnoreCase("bomb"))
                dat = 10;
        if(n.equalsIgnoreCase("happyFace"))
                dat = 11;
        if(n.equalsIgnoreCase("sadFace"))
                dat = 12;
        if(n.equalsIgnoreCase("coolFace"))
                dat = 16;
        if(n.equalsIgnoreCase("flag"))
                dat = 14;
        if(n.equalsIgnoreCase("mark"))
                dat = 15;
        
        for(int x = 0; x < 20; x++)
        {
            for(int y = 0; y < 20; y++)
            {
                
                curChar = spriteData[dat][((x/2)*10 + (y/2)%10)];
                
                if(curChar == ' ') color = 0x00000000;
                if(curChar == '0') color = 0xFFFF0000;
                if(curChar == '1') color = 0xFF0000FF;
                if(curChar == '2') color = 0xFF008000;
                if(curChar == '3') color = 0xFFFF0000;
                if(curChar == '4') color = 0xFF800080;
                if(curChar == '5') color = 0xFF800000;
                if(curChar == '6') color = 0xFF40E0D0;
                if(curChar == '7') color = 0xFF000000;
                if(curChar == '8') color = 0xFF808080;
                if(curChar == '9') color = 0xFFFF0000;
                if(curChar == 'B') color = 0xFF000000;
                if(curChar == 'S') color = 0xFF161616;
                if(curChar == 'Y') color = 0xFFFFFF00;
                if(curChar == 'G') color = 0xFF808080;
                if(curChar == 'W') color = 0xFFFFFFFF;

                //buffer[(y%10)+(x*10)] = color;
                img.setRGB(y,x, color);
                //if(y < 19)
                //img.setRGB(y+1,x, color);
            }
        }
        
        return img;
        
    }
}
