import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.util.List;
import java.util.logging.ConsoleHandler;

/**
 * <i>LabelBuilder is just a simple class for create JLabel</i>
 * @author WarzouMc
 *
 * @ClassNeed FrameBuilder
 */
public class LabelBuilder {

    private JLabel jLabel;

    private FrameBuilder frameBuilder = null;

    /**
     * Instance without parameter
     */
    public LabelBuilder(){
        this.jLabel = new JLabel();
    }

    /**
     * Instance with JFrame parameter
     * @param jLabel
     */
    public LabelBuilder(JLabel jLabel){
        this.jLabel = jLabel;
    }

    /**
     * Instance with JFrame parameter
     * @param frameBuilder
     */
    public LabelBuilder(FrameBuilder frameBuilder){
        this.frameBuilder = frameBuilder;
        this.jLabel = new JLabel();
    }

    public LabelBuilder clone(){
        return new LabelBuilder(jLabel);
    }

    public LabelBuilder writeText(String text){
        jLabel.setText(text);
        return this;
    }

    public LabelBuilder writeText(String text, boolean b){
        jLabel.setText(text);
        jLabel.setOpaque(b);
        return this;
    }

    public LabelBuilder setXSize(int xSize){
        jLabel.setSize(xSize, getZSize());
        return this;
    }

    public LabelBuilder setZSize(int zSize){
        jLabel.setSize(getXSize(), zSize);
        return this;
    }

    public LabelBuilder setXandZSize(int xSize, int zSize){
        jLabel.setSize(xSize, zSize);
        return this;
    }

    public LabelBuilder setBackground(String path){
        jLabel.setIcon(new ImageIcon(path));
        jLabel.setLayout(new FlowLayout());
        return this;
    }



    public LabelBuilder put(){
        try{
            frameBuilder.setJLabel(toJLabel());
        }catch (NullPointerException error){
            this.frameBuilder = new FrameBuilder().default_();
            frameBuilder.setJLabel(toJLabel());
            error.printStackTrace();
            System.err.println("[LabelBuilder][public LabelBuilder put() : NPE");
            System.out.println("[FrameBuilderLib] : programme continue !");
        }
        return this;
    }

    public int getXSize(){
        return jLabel.getSize().width;
    }

    public int getZSize(){
        return jLabel.getSize().height;
    }

    public FrameBuilder callFrameBuilder(){
        return frameBuilder;
    }

    /**
     * Return JLabel
     * @return
     */
    public JLabel toJLabel(){
        return this.jLabel;
    }

}
