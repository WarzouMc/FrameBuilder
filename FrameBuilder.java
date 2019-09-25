import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FrameBuilder {

    private JFrame jFrame;

    public FrameBuilder(){
        jFrame = new JFrame();
    }

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
    public FrameBuilder setResiable(boolean b){
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
     * Set background image
     * @param path
     * @return
     */
    public FrameBuilder setBackground(String path){
        jFrame.setLayout(new BorderLayout());
        JLabel jLabel = new JLabel(new ImageIcon(path));
        jFrame.add(jLabel);
        jLabel.setLayout(new FlowLayout());
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
        jFrame.setVisible(b);
        return this;
    }

    /**
     * return you JFrame
     * @return
     */
    public JFrame toJFrame(){
        return this.jFrame;
    }

}
