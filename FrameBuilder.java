import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <i>FrameBuilder is just a simple class for create JFrame</i>
 * @author WarzouMc
 *
 * @ClassNeed LabelBuilder :
 */

public class FrameBuilder {

    private JFrame jFrame;

    /**
     * Instance without parameter
      */
    public FrameBuilder(){
        jFrame = new JFrame();
    }

    /**
     * Instance with JFrame parameter
     * @param jFrame
     */
    public FrameBuilder(JFrame jFrame){
        this.jFrame = jFrame;
    }

    /**
     * clone your frame
     * @return
     */
    public FrameBuilder clone(){
        return new FrameBuilder(jFrame);
    }

    public FrameBuilder default_(){
        int width = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width/1.2);
        int height = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height/1.2);
        return new FrameBuilder()
                .setTitle("Default Title")
                .setXAndZSize(width, height)
                .setLocationRelativeTo(null)
                .setBackground(Color.DARK_GRAY)
                .visible(true);
    }

    public FrameBuilder setMaxXandZSizeFromWindowsSize(){
        int width = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width/1.0);
        int height = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height/1.0);
        setXAndZSize(width, height);
        return this;
    }

    public FrameBuilder setMaxXandZSizeFromDivWindowsSize(float div){
        int width = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width/div);
        int height = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height/div);
        setXAndZSize(width, height);
        return this;
    }

    /**
     * Set the title of your frame
     * @param title
     * @return
     */
    public FrameBuilder setTitle(String title){
        jFrame.setTitle(title);
        return this;
    }

    /**
     * set x size of the frame
     * @param xSize
     * @return
     */
    public FrameBuilder setXSize(int xSize){
        jFrame.setSize(xSize, getZSize());
        return this;
    }

    /**
     * set z size of the frame
     * @param zSize
     * @return
     */
    public FrameBuilder setZSize(int zSize){
        jFrame.setSize(getXSize(), zSize);
        return this;
    }

    /**
     * set x and z size of the frame
     * @param xSize
     * @param zSize
     * @return
     */
    public FrameBuilder setXAndZSize(int xSize, int zSize){
        jFrame.setSize(xSize, zSize);
        return this;
    }

    /**
     * Show/hide (true/false) top of your frame
     * @param b
     * @return
     */
    public FrameBuilder setDecorated(boolean b){
        jFrame.setUndecorated(!b);
        return this;
    }

    /**
     * Set location relative to
     * null = middle
     * @param c
     * @return
     */
    public FrameBuilder setLocationRelativeTo(Component c){
        jFrame.setLocationRelativeTo(c);
        return this;
    }

    /**
     * Set close default operation
     * @param i
     * @return
     */
    public FrameBuilder setCloseAction(int i){
        jFrame.setDefaultCloseOperation(i);
        return this;
    }

    /**
     * Define if user could resize the frame
     * @param b
     * @return
     */
    public FrameBuilder setResizable(boolean b){
        jFrame.setResizable(b);
        return this;
    }

    /**
     * Set icon on your frame
     * @param path
     * @return
     */
    public FrameBuilder icon(String path){
        ImageIcon imageIcon = new ImageIcon(path);
        jFrame.setIconImage(imageIcon.getImage());
        return this;
    }

    /**
     * Set colored background
     * @param color
     * @return
     */
    public FrameBuilder setBackground(Color color){
        jFrame.getContentPane().setBackground(color);
        return this;
    }

    /**
     * Apply an existent JLabel
     * @param jLabel
     * @return
     */
    public FrameBuilder setJLabel(JLabel jLabel){
        jFrame.add(jLabel);
        return this;
    }

    /**
     * add JMenuBar with name
     * @param name
     * @return
     */
    public FrameBuilder setJMenuBar(String name){
        JMenuBar jMenuBar = new JMenuBar();
        if (jFrame.getJMenuBar() != null) jMenuBar = jFrame.getJMenuBar();
        JMenu menu = new JMenu(name);
        jMenuBar.add(menu);
        jFrame.setJMenuBar(jMenuBar);
        return this;
    }

    /**
     * add JMenuBar with name and menu icon
     * Icons precision : set null for no icon
     * @param name
     * @return
     */
    public FrameBuilder setJMenuBar(String name, String menuIcon){
        JMenuBar jMenuBar = new JMenuBar();
        if (jFrame.getJMenuBar() != null) jMenuBar = jFrame.getJMenuBar();
        JMenu menu = new JMenu(name);
        if (!menuIcon.equalsIgnoreCase("null")) {
            menu.setIcon(new ImageIcon(menuIcon));
        }
        jMenuBar.add(menu);
        jFrame.setJMenuBar(jMenuBar);
        return this;
    }

    /**
     * add JMenuBar with name, menu icon and submenus
     * Icons precision : set null for no icon
     * @param name
     * @return
     */
    public FrameBuilder setJMenuBar(String name, String menuIcon, List<String> menuItemString){
        JMenuBar jMenuBar = new JMenuBar();
        if (jFrame.getJMenuBar() != null) jMenuBar = jFrame.getJMenuBar();
        JMenu menu = new JMenu(name);
        for (String string : menuItemString) {
            JMenuItem jMenuItem = new JMenuItem(string);
            menu.add(jMenuItem);
        }
        jMenuBar.add(menu);
        jFrame.setJMenuBar(jMenuBar);
        return this;
    }

    /**
     * add JMenuBar with name, menu icon, submenus and submenus icon
     * Icons precision : set null for no icon
     * @param name
     * @return
     */
    public FrameBuilder setJMenuBar(String name, String menuIcon, List<String> menuItemString, List<String> menuItemIcon){
        JMenuBar jMenuBar = new JMenuBar();
        if (jFrame.getJMenuBar() != null) jMenuBar = jFrame.getJMenuBar();
        JMenu menu = new JMenu(name);
        if (!menuIcon.equalsIgnoreCase("null")) {
            menu.setIcon(new ImageIcon(menuIcon));
        }
        Map<String, String> menuItemLogo = new HashMap<>();
        for (int i = 0; i < menuItemString.size(); i++) {
            menuItemLogo.put(menuItemString.get(i), menuItemIcon.get(i));
        }
        
        for (Map.Entry<String, String> entry : menuItemLogo.entrySet()) {
            JMenuItem jMenuItem = new JMenuItem(entry.getKey());
            if (!entry.getValue().equalsIgnoreCase("null")){
                jMenuItem.setIcon(new ImageIcon(entry.getValue()));
            }
            menu.add(jMenuItem);
        }
        jMenuBar.add(menu);
        jFrame.setJMenuBar(jMenuBar);
        return this;
    }

    /**
     * get x size of the frame
     * @return
     */
    public int getXSize(){
        return jFrame.getSize().width;
    }

    /**
     * get z size of the frame
     * @return
     */
    public int getZSize(){
        return jFrame.getSize().height;
    }

    /**
     * Open the frame to the user
     */
    public FrameBuilder visible(boolean b){
        try{
            jFrame.setVisible(b);
        }catch (NullPointerException exeption){
            new FrameBuilder().default_();
        }
        return this;
    }

    public LabelBuilder callLabelBuilder(){
        return new LabelBuilder(this);
    }

    /**
     * return you JFrame
     * @return
     */
    public JFrame toJFrame(){
        return this.jFrame;
    }

}
