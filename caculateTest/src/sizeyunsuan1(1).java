import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//四则运算布局类
class sizeyunsuan1{
    public static void main(String[] args){
        Mydeframe mydeframe = new Mydeframe();
    }

    static class Mydeframe extends JFrame{
        int n,zuobiaoY = 80,p,m;
        Subject subject1 = new Subject();
        JLabel[] jLabels = new JLabel[5];                  //题目是数组
        JTextField textFields = new JTextField(8);           //答案数组
        JLabel label = new JLabel("请输入题目个数:");
        JTextField[] jTextFields = new JTextField[5];
        JButton queding = new JButton("提交");
        JPanel jpanel = new JPanel();//JPanel:面板组件，非顶层容器
        //构造方法
        Mydeframe (){
            JMenuBar menuBar = new JMenuBar();   //创建菜单栏
            this.setJMenuBar(menuBar);    //将菜单栏添加到JFrame
            JMenu menu = new JMenu("操作");  //创建菜单
            menuBar.add(menu);             //将菜单添加到菜单栏上
            //创建两个菜单项
            JMenuItem item1 = new JMenuItem("开始");
            JMenuItem item2 = new JMenuItem("更换背景");
            menu.add(item1);
            menu.addSeparator();
            menu.add(item2);
            this.setTitle("简易四则运算");
            this.setSize(500,500);//设置面板大小
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭子窗口
            this.add(jpanel);
            label.setFont(new Font("宋体", Font.BOLD, 16));
            label.setBounds(100, 30, 400, 30);
            textFields.setBounds(240, 30, 90, 30);
            queding.setFont(new Font("宋体", Font.BOLD, 16));
            queding.setBounds(360, 30, 80, 30);//确认
            jpanel.add(queding);
            queding.setEnabled(false);
            jpanel.add(textFields);
            jpanel.add(label);
            item1.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   p = n = (int) Double.parseDouble(textFields.getText());
                    Subject subject = new Subject(n);
                    subject1 = subject;
                    for (int i = 0; i < n; i++) {
                        if (n > 5 || n < 1) {
                            //如果题目个数大于5或小于1，会弹出提示框
                            JOptionPane.showMessageDialog(null, "输入的题目个数不能大于5或者小于1", "注意", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        } else {
                            queding.setEnabled(true);
                            jLabels[i] = new JLabel("式子:");
                            jTextFields[i] = new JTextField(8);
                            jLabels[i].setFont(new Font("宋体", Font.BOLD, 18));
                            jLabels[i].setForeground(Color.ORANGE);
                            jLabels[i].setBounds(50, zuobiaoY, 300, 80);
                            jTextFields[i].setBounds(360,zuobiaoY+26,90,30);
                            jpanel.add(jTextFields[i]);
                            zuobiaoY = zuobiaoY + 50;
                            jpanel.add(jLabels[i]);
                            jLabels[i].setText(subject.subject[i]);
                            //L5.setForeground(Color.red);
                            jTextFields[i].setText(null);
                        }
                    }
                }
            });
            item2.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Color ch = JColorChooser.showDialog(jpanel, "颜色选择器",
                            jpanel.getBackground());
                    if (ch != null) {
                        jpanel.setBackground(ch);
                        jpanel.repaint();
                    }
                }
            });
            queding.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int count=0;
                    if(e.getSource()==queding)//确认按钮
                    {
                        for (int i = 0;i< n;i++) {
                            m = (int) Double.parseDouble(jTextFields[i].getText());
                            if (m == subject1.answer[i]) {
                                m++;
                                count++;
                                /* s2="回答正确！";
                    L5.setText(s2);*/
                                JOptionPane.showMessageDialog(null, "第"+(i+1)+"条回答正确！！！", "恭喜你！", JOptionPane.INFORMATION_MESSAGE);
                                if(i == n-1){
                                    JOptionPane.showMessageDialog(null, "一共"+p+"道题目。你正确的题数为:"+count,"成绩",JOptionPane.INFORMATION_MESSAGE);
                                    queding.setEnabled(false);
                                    break;
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "第"+(i+1)+"条回答错误！！！", "很抱歉！", JOptionPane.INFORMATION_MESSAGE);
                                if(i == n-1){
                                    JOptionPane.showMessageDialog(null, "一共"+p+"道题目。你正确的题数为:"+count,"成绩",JOptionPane.INFORMATION_MESSAGE);
                                    queding.setEnabled(false);
                                    break;
                                }
                            }
                            queding.setEnabled(false);
                        }
                    }
                }
            });

            jpanel.setLayout(null);
            this.setVisible(true);//设置可见窗口
            this.setResizable(false);//设置面板不可改变大小
            this.setLocationRelativeTo(null);//此窗口将置于屏幕的中央
        }
    }
}
