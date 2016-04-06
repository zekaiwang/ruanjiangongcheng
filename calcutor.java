import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class calcutor extends JFrame {

    private static final long serialVersionUID = 1L;
    File file1 = new File("fuli.txt");
    File file2 = new File("danli.txt");
    File file3 = new File("benjin.txt");
    File file4 = new File("lilv.txt");
    File file5 = new File("nianxian.txt");
    File file6 = new File("yuehuankuan.txt");

    public static void main(String[] args) {
	calcutor frame = new calcutor();
	frame.setVisible(true);
	frame.setBounds(100, 100, 500, 600);
	frame.setTitle("复利计算器5.1");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JPanel jpanel;
    private JLabel label, label00, label01, label02, label03, label04, label05,
	    label06, label07, label08, label09, label10, label11;
    private JComboBox<Object> box;
    private JTextField field01, field02, field03, field04, field05;
    private JButton button;
    private static double benjin, lilv, nianxian, zhongzhi, dingtou, huankuan,
	    daikuan;
    private int index = 0;

    public calcutor() {

	jpanel = new JPanel();
	jpanel.setBounds(0, 0, 500, 600);
	jpanel.setLayout(null);
	add(jpanel);

	label = new JLabel("计算类型：");
	label.setFont(new Font(null, Font.BOLD, 15));
	label.setBounds(10, 10, 80, 30);
	jpanel.add(label);

	label06 = new JLabel();
	label06.setBounds(10, 320, 500, 40);
	jpanel.add(label06);

	label07 = new JLabel();
	label07.setBounds(10, 350, 500, 40);
	jpanel.add(label07);

	label08 = new JLabel();
	label08.setBounds(10, 380, 500, 40);
	jpanel.add(label08);

	label09 = new JLabel();
	label09.setBounds(10, 410, 500, 40);
	jpanel.add(label09);

	label10 = new JLabel();
	label10.setBounds(10, 440, 500, 40);
	jpanel.add(label10);

	label11 = new JLabel();
	label11.setBounds(10, 470, 500, 40);
	jpanel.add(label11);

	label00 = new JLabel("@113wangzekai、114jihan");
	label00.setFont(new Font(null, Font.BOLD, 15));
	label00.setBounds(290, 520, 200, 30);
	jpanel.add(label00);

	label01 = new JLabel("本金：");
	label01.setFont(new Font(null, Font.BOLD, 15));
	label01.setBounds(30, 80, 80, 30);
	jpanel.add(label01);

	label02 = new JLabel("年利率%：");
	label02.setFont(new Font(null, Font.BOLD, 15));
	label02.setBounds(30, 130, 80, 30);
	jpanel.add(label02);

	label03 = new JLabel("年限：");
	label03.setFont(new Font(null, Font.BOLD, 15));
	label03.setBounds(30, 180, 80, 30);
	jpanel.add(label03);

	label04 = new JLabel("定投金额：");
	label04.setFont(new Font(null, Font.BOLD, 15));
	label04.setBounds(30, 230, 80, 30);
	jpanel.add(label04);

	label05 = new JLabel("终值：");
	label05.setFont(new Font(null, Font.BOLD, 15));
	label05.setBounds(30, 280, 80, 30);
	jpanel.add(label05);

	// 文本框
	field01 = new JTextField();
	field01.setBounds(120, 80, 150, 30);
	jpanel.add(field01);

	field02 = new JTextField();
	field02.setBounds(120, 130, 150, 30);
	jpanel.add(field02);

	field03 = new JTextField();
	field03.setBounds(120, 180, 150, 30);
	jpanel.add(field03);

	field04 = new JTextField();
	field04.setBounds(120, 230, 150, 30);
	jpanel.add(field04);

	field05 = new JTextField();
	field05.setBounds(120, 280, 150, 30);
	jpanel.add(field05);

	// 初始化文本框
	field05.setText("计算所得");
	field05.setEnabled(false);

	// 计算按钮
	button = new JButton("计算");
	button.setBounds(250, 10, 80, 30);
	button.setFont(new Font(null, Font.BOLD, 15));
	jpanel.add(button);
	// 按钮监听
	button.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent e) {
		if (index == 0) {
		    zhongzhi = fulicalcutor();
		    if (zhongzhi != -1) {
			field05.setText(Double.toString(zhongzhi));
			field05.setEnabled(true);
		    }
		} else if (index == 1) {
		    zhongzhi = danlicalcutor();
		    if (zhongzhi != -1) {
			field04.setText(Double.toString(zhongzhi));
			field04.setEnabled(true);
		    }
		} else if (index == 2) {
		    benjin = benjincalcutor();
		    if (benjin != -1) {
			field01.setText(Double.toString(benjin));
			field01.setEnabled(true);
		    }
		} else if (index == 3) {
		    lilv = lilvcalcutor();
		    if (lilv != -1) {
			field02.setText(Double.toString(lilv));
			field02.setEnabled(true);
		    }
		} else if (index == 4) {
		    nianxian = nianxiancalcutor();
		    if (nianxian != -1) {
			field03.setText(Double.toString(nianxian));
			field03.setEnabled(true);
		    }
		} else if (index == 5) {
		    huankuan = yuehuankuanejisuan();
		    if (huankuan != -1) {
			field04.setText(Double.toString(huankuan));
			field04.setEnabled(true);
		    }
		}
	    }
	});

	//下拉菜单
	box = new JComboBox<Object>();
	box.setFont(new Font(null, Font.BOLD, 15));
	box.setModel(new DefaultComboBoxModel<Object>(new Object[] { "复利计算",
		"单利计算", "本金计算", "利率计算", "年限计算", "月还款额计算" }));
	box.setBounds(90, 10, 130, 30);
	jpanel.add(box);
	box.addItemListener(new ItemListener() {
	    @Override
	    public void itemStateChanged(ItemEvent e) {
		if (box.getSelectedIndex() == 0) {
		    index = 0;
		    change01();
		    clear();
		    field05.setText("计算所得");
		    field05.setEnabled(false);
		} else if (box.getSelectedIndex() == 1) {
		    index = 1;
		    change();
		    clear();
		    field04.setText("计算所得");
		    field04.setEnabled(false);
		} else if (box.getSelectedIndex() == 2) {
		    index = 2;
		    change();
		    clear();
		    field01.setText("计算所得");
		    field01.setEnabled(false);
		} else if (box.getSelectedIndex() == 3) {
		    index = 3;
		    change();
		    clear();
		    field02.setText("计算所得");
		    field02.setEnabled(false);
		} else if (box.getSelectedIndex() == 4) {
		    index = 4;
		    change();
		    clear();
		    field03.setText("计算所得");
		    field03.setEnabled(false);
		} else if (box.getSelectedIndex() == 5) {
		    index = 5;
		    change02();
		    clear();
		    field04.setText("计算所得");
		    field04.setEnabled(false);
		}
	    }

	});
    }

    // 清除数据
    private void clear() {
	field01.setText(null);
	field02.setText(null);
	field03.setText(null);
	field04.setText(null);
	field05.setText(null);
	field01.setEnabled(true);
	field02.setEnabled(true);
	field03.setEnabled(true);
	field04.setEnabled(true);
	field05.setEnabled(true);
    }

    // 改变内容
    private void change02() {
	label01.setText("贷款金额：");
	label02.setText("年利率%：");
	label03.setText("还款期限：");
	label04.setText("月还款额：");
	label05.setText("");
	field05.setVisible(false);
    }

    private void change01() {
	label01.setText("本金：");
	label02.setText("年利率%：");
	label03.setText("年限：");
	label04.setText("定投金额：");
	label05.setText("终值：");
	field05.setVisible(true);
    }

    private void change() {
	label01.setText("本金：");
	label02.setText("年利率%：");
	label03.setText("年限：");
	label04.setText("终值：");
	label05.setText("");
	field05.setVisible(false);
    }

    // 月还款额计算
    private double yuehuankuanejisuan() {
	try {
	    daikuan = Double.parseDouble(field01.getText());
	    lilv = Double.parseDouble(field02.getText());
	    nianxian = Double.parseDouble(field03.getText());
	    // 小于或等于0的处理
	    if (daikuan <= 0 || lilv <= 0 || nianxian <= 0) {
		JOptionPane.showMessageDialog(jpanel, "你输入的数据不能小于或等于零\n"
			+ "               请重新输入");
	    } else {
		double yuehuankuan = yuehuankuan(daikuan, lilv, nianxian);
		try {
		    FileOutputStream fos = new FileOutputStream(file6);
		    OutputStreamWriter osw = new OutputStreamWriter(fos,
			    "UTF-8");
		    BufferedWriter bw = new BufferedWriter(osw);
		    bw.write("月还款额计算：");
		    bw.write(" 贷款金额：" + daikuan);
		    bw.write(" 利率：" + lilv);
		    bw.write(" 年限：" + nianxian);
		    bw.write(" 月还款额：" + yuehuankuan);
		    bw.close();
		    osw.close();
		    fos.close();
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		String line = null;
		try {
		    FileInputStream fis = new FileInputStream("yuehuankuan.txt");
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);

		    try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			    label11.setText(line);
			}
		    } catch (IOException e1) {
			e1.printStackTrace();
		    }
		    try {
			br.close();
			isr.close();
			fis.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		return yuehuankuan;
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jpanel, "请输入正确的数据");
	}
	return -1;

    }

    // 月还款额计算公式
    public final double yuehuankuan(double daikuan, double lilv, double nianxian) {
	huankuan = daikuan * (lilv / 12)
		* Math.pow(1 + lilv / 12, 12 * nianxian)
		/ (Math.pow(1 + lilv / 12, 12 * nianxian) - 1);
	huankuan = Math.round(huankuan * 100) / 100;
	return huankuan;
    }

    // 年限计算
    private double nianxiancalcutor() {
	try {
	    zhongzhi = Double.parseDouble(field04.getText());
	    lilv = Double.parseDouble(field02.getText());
	    benjin = Double.parseDouble(field01.getText());
	    // 小于或等于0的处理
	    if (zhongzhi <= 0 || lilv <= 0 || benjin <= 0) {
		JOptionPane.showMessageDialog(jpanel, "你输入的数据不能小于或等于零\n"
			+ "               请重新输入");
	    } else {
		double nianxian = nianxian(zhongzhi, lilv, benjin);
		try {
		    FileOutputStream fos = new FileOutputStream(file5);
		    OutputStreamWriter osw = new OutputStreamWriter(fos,
			    "UTF-8");
		    BufferedWriter bw = new BufferedWriter(osw);
		    bw.write("年限计算：");
		    bw.write(" 本金：" + benjin);
		    bw.write(" 利率：" + lilv);
		    bw.write(" 终值：" + zhongzhi);
		    bw.write(" 年限：" + nianxian);
		    bw.close();
		    osw.close();
		    fos.close();
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		String line = null;
		try {
		    FileInputStream fis = new FileInputStream("nianxian.txt");
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);
		    try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			    label10.setText(line);
			}
		    } catch (IOException e1) {
			e1.printStackTrace();
		    }
		    try {
			br.close();
			isr.close();
			fis.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		return nianxian;
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jpanel, "请输入正确的数据");
	}
	return -1;
    }

    // 年限计算公式
    public final double nianxian(double zhongzhi, double lilv, double benjin) {
	nianxian = (Math.log(zhongzhi / benjin) / Math.log(1 + lilv));
	nianxian = Math.round(nianxian);
	return nianxian;
    }

    // 利率计算
    private double lilvcalcutor() {
	try {
	    zhongzhi = Double.parseDouble(field04.getText());
	    nianxian = Double.parseDouble(field03.getText());
	    benjin = Double.parseDouble(field01.getText());
	    // 小于或等于0的处理
	    if (zhongzhi <= 0 || benjin <= 0 || nianxian <= 0) {
		JOptionPane.showMessageDialog(jpanel, "你输入的数据不能小于或等于零\n"
			+ "               请重新输入");
	    } else {
		double lilv = lilv(zhongzhi, nianxian, benjin);
		try {
		    FileOutputStream fos = new FileOutputStream(file4);
		    OutputStreamWriter osw = new OutputStreamWriter(fos,
			    "UTF-8");
		    BufferedWriter bw = new BufferedWriter(osw);
		    bw.write("利率计算：");
		    bw.write(" 终值：" + zhongzhi);
		    bw.write(" 年限：" + nianxian);
		    bw.write(" 本金：" + benjin);
		    bw.write(" 利率：" + lilv);
		    bw.close();
		    osw.close();
		    fos.close();
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		String line = null;
		try {
		    FileInputStream fis = new FileInputStream("lilv.txt");
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);
		    try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			    label09.setText(line);
			}
		    } catch (IOException e1) {
			e1.printStackTrace();
		    }
		    try {
			br.close();
			isr.close();
			fis.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		return lilv;
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jpanel, "请输入正确的数据");
	}
	return -1;
    }

    // 利率计算公式
    public final double lilv(double zhongzhi, double nianxian, double benjin) {
	lilv = Math.pow((zhongzhi / benjin), (1.0 / nianxian)) - 1;
	lilv = Math.round(lilv * 100) / 100.0;
	return lilv;
    }

    // 本金计算
    private double benjincalcutor() {
	try {
	    zhongzhi = Double.parseDouble(field04.getText());
	    lilv = Double.parseDouble(field02.getText());
	    nianxian = Double.parseDouble(field03.getText());
	    // 小于或等于0的处理
	    if (zhongzhi <= 0 || lilv <= 0 || nianxian <= 0) {
		JOptionPane.showMessageDialog(jpanel, "你输入的数据不能小于或等于零\n"
			+ "               请重新输入");
	    } else {
		double benjin = benjin(zhongzhi, lilv, nianxian);
		try {
		    FileOutputStream fos = new FileOutputStream(file3);
		    OutputStreamWriter osw = new OutputStreamWriter(fos,
			    "UTF-8");
		    BufferedWriter bw = new BufferedWriter(osw);
		    bw.write("本金计算：");
		    bw.write(" 终值：" + zhongzhi);
		    bw.write(" 利率：" + lilv);
		    bw.write(" 年限：" + nianxian);
		    bw.write(" 本金：" + benjin);
		    bw.close();
		    osw.close();
		    fos.close();
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		String line = null;
		try {
		    FileInputStream fis = new FileInputStream("benjin.txt");
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);
		    try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			    label08.setText(line);
			}
		    } catch (IOException e1) {
			e1.printStackTrace();
		    }
		    try {
			br.close();
			isr.close();
			fis.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		return benjin;
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jpanel, "请输入正确的数据");
	}
	return -1;
    }

    // 本金计算公式
    public final double benjin(double zhongzhi, double lilv, double nianxian) {
	benjin = zhongzhi / (Math.pow(1 + lilv, nianxian));
	benjin = Math.round(benjin * 100) / 100;
	return benjin;
    }

    // 单利计算
    private double danlicalcutor() {
	try {
	    benjin = Double.parseDouble(field01.getText());
	    lilv = Double.parseDouble(field02.getText());
	    nianxian = Double.parseDouble(field03.getText());
	    // 小于或等于0的处理
	    if (benjin <= 0 || lilv <= 0 || nianxian <= 0) {
		JOptionPane.showMessageDialog(jpanel, "你输入的数据不能小于或等于零\n"
			+ "               请重新输入");
	    } else {
		double zhongzhi = zhongzhi(benjin, lilv, nianxian);
		try {
		    FileOutputStream fos = new FileOutputStream(file2);
		    OutputStreamWriter osw = new OutputStreamWriter(fos,
			    "UTF-8");
		    BufferedWriter bw = new BufferedWriter(osw);
		    bw.write("单利计算：");
		    bw.write(" 本金：" + benjin);
		    bw.write(" 利率：" + lilv);
		    bw.write(" 年限：" + nianxian);
		    bw.write(" 终值：" + zhongzhi);
		    bw.close();
		    osw.close();
		    fos.close();
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
		String line = null;
		try {
		    FileInputStream fis = new FileInputStream("danli.txt");
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);
		    try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			    label07.setText(line);
			}
		    } catch (IOException e1) {
			e1.printStackTrace();
		    }
		    try {
			br.close();
			isr.close();
			fis.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		return zhongzhi;
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jpanel, "请输入正确的数据");
	}
	return -1;
    }

    // 单利计算公式
    public final double zhongzhi(double benjin, double lilv, double nianxian) {
	zhongzhi = benjin * (1 + lilv * nianxian);
	zhongzhi = Math.round(zhongzhi * 100) / 100;
	return zhongzhi;
    }

    // 複利計算
    private double fulicalcutor() {

	try {
	    benjin = Double.parseDouble(field01.getText());
	    lilv = Double.parseDouble(field02.getText());
	    nianxian = Double.parseDouble(field03.getText());
	    try {
		dingtou = Double.parseDouble(field04.getText());
	    } catch (NumberFormatException e2) {
		dingtou = 0;
	    }
	  //小于或等于0的处理
	    if (benjin <= 0 || lilv <= 0 || nianxian <= 0) {
		JOptionPane.showMessageDialog(jpanel, "你输入的数据不能小于或等于零\n"
			+ "               请重新输入");
	    } else {
		double zhongzhi = zhongzhi(benjin, lilv, nianxian, dingtou);
		try {
		    FileOutputStream fos = new FileOutputStream(file1);
		    OutputStreamWriter osw = new OutputStreamWriter(fos,
			    "UTF-8");
		    BufferedWriter bw = new BufferedWriter(osw);
		    bw.write("复利计算：");
		    bw.write(" 本金：" + benjin);
		    bw.write(" 利率：" + lilv);
		    bw.write(" 年限：" + nianxian);
		    bw.write(" 定投金额：" + dingtou);
		    bw.write(" 终值：" + zhongzhi);
		    bw.close();
		    osw.close();
		    fos.close();
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}

		String line = null;
		try {
		    FileInputStream fis = new FileInputStream("fuli.txt");
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);
		    try {
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			    label06.setText(line);
			}
		    } catch (IOException e1) {
			e1.printStackTrace();
		    }
		    try {
			br.close();
			isr.close();
			fis.close();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		return zhongzhi;
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(jpanel, "请输入正确的数据");
	}
	return -1;
    }

    // 复利计算公式
    public final double zhongzhi(double benjin, double lilv, double nianxian,
	    double dingtou) {
	for (int i = 0; i < nianxian; i++) {
	    benjin = benjin * (1 + lilv);
	    benjin = benjin + dingtou;
	}
	zhongzhi = benjin - dingtou;
	zhongzhi = Math.round(zhongzhi * 100) / 100;
	return zhongzhi;
    }
}
