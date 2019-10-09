import java.awt.*;
import java.util.Arrays;

public class Main {

    private static Main instance;

    public Main(){
        new FrameBuilder()
                .setCloseAction(3)
                .setXAndZSize(500, 500)
                .setLocationRelativeTo(null)
                .setResizable(true)
                .setTitle("test_1")
                .setDecorated(true)
                .icon("src/resource/logo.png")
                .setJMenuBar("test", "null", Arrays.asList("", "mega menu"), Arrays.asList("", "src/resource/bookshelf.png"))
                .setJMenuBar("test1", "null", Arrays.asList("", "je c pas"), Arrays.asList("src/resource/bookshelf.png", ""))
                //param Label and put this on the framebuilder
                .callLabelBuilder()
                .writeText("test")
                .setBackground("src/resource/logo.png")
                .setXandZSize(100, 100)
                .put()
                //now coll framebuilder for set a visable frame
                .callFrameBuilder()
                .setBackground(Color.BLUE)
                .visible(true);

        new LabelBuilder()
                .setXandZSize(10, 10)
                //.writeText("e", true)
                .put()
                .callFrameBuilder()
                .setMaxXandZSizeFromDivWindowsSize(2)
                .setLocationRelativeTo(null)
                .callLabelBuilder()
                .writeText("test")
                .setXandZSize(10, 10)
                .put()
                .callFrameBuilder()
                .visible(true);
    }

    public static void main(String[] args){
        instance = new Main();
    }

    public static Main getInstance() {
        return instance;
    }
}
