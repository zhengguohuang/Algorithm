import javax.swing.*;
import java.awt.*;

public class App {

    public void CreateJFrame(String title)
    {
        JFrame jf = new JFrame(title);//窗口标题
        Container container = jf.getContentPane();//创建容器
        JLabel jl = new JLabel("快说你爱我，对着屏幕大喊三遍“我爱XX哥哥”，窗口就会关闭。");
        //使标签上的文字居中
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jl);//添加上面的组件，不添加就显示不到
        container.setBackground(Color.WHITE);
        jf.setVisible(true);//窗口可视
        jf.setSize(500, 200);//窗口大小
        jf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//DO_NOTHING_ON_CLOSE 的意思是关不掉，哈哈，可以捉弄下小白

    }


    public static void main(String args[]) {
        new App().CreateJFrame("");

    }

}
