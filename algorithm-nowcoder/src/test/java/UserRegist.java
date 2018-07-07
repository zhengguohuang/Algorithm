import javax.swing.*;

/**
 * 用户注册
 * @author Administrator
 *
 */
public class UserRegist extends JFrame {
    JLabel jl1,jl2,jl3,jl4,jl5;
    JTextField jtf1,jtf2,jtf3;
    JPasswordField jpf;
    JButton jb1,jb2;
    JRadioButton jrb1,jrb2;
    public static void main(String[] args) {
        UserRegist u = new UserRegist();
    }
    public UserRegist(){
        //设置布局
        this.setLayout(null);
        //创建组件
        jl1 = new JLabel("用户名");
        //设置位置
        jl1.setBounds(50, 50, 50, 30);
        jtf1 = new JTextField();
        jtf1.setBounds(100, 55, 150, 25);

        jl2 = new JLabel("密码");
        jl2.setBounds(56, 90, 50, 30);
        jtf2 = new JTextField();
        jtf2.setBounds(100, 95, 150, 25);

        jl3 = new JLabel("性别");
        jl3.setBounds(56, 130, 50, 30);
        jrb1 = new JRadioButton("男");
        jrb1.setBounds(120, 135, 50, 25);
        jrb2 = new JRadioButton("女");
        jrb2.setBounds(170, 135, 50, 25);

        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jtf2);
        this.add(jl3);
        this.add(jrb1);
        this.add(jrb2);

        this.setTitle("用户注册");
        this.setVisible(true);
        this.setSize(320, 430);
        this.setLocation(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
