package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.BirthDao;
import test.dto.BirthDto;

public class BirthFrame extends JFrame implements ActionListener, PropertyChangeListener {
	JTextField inputName, inputBirthday;
	DefaultTableModel model;
	JTable table;
	
	public BirthFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1=new JLabel("이름");
		inputName=new JTextField(10);
		JLabel label2=new JLabel("생일");
		inputBirthday=new JTextField(10);
		
		JButton saveBtn=new JButton("저장");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");
		
		JButton deleteBtn=new JButton("삭제");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete");
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputBirthday);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel,BorderLayout.NORTH);
		
		table=new JTable();
		String[] colNames= {"번호","이름","생일"};
		model=new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row,int column) {
				if(column==0 || column==2) {
					return false;
				}
				return true;
			}
		};
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		displayBirthday();
		table.addPropertyChangeListener(this);	
		
	}
	
	public static void main(String[] args) {
		BirthFrame f=new BirthFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void displayBirthday() {
		model.setRowCount(0);
		BirthDao dao=BirthDao.getInstance();
		List<BirthDto> list=dao.getList();
		for(BirthDto tmp:list) {
			Object[] row= {tmp.getNum(),tmp.getName(),tmp.getBirthday()};
			model.addRow(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("save")) {
			String name=inputName.getText();
			String birthday=inputBirthday.getText();
			BirthDto dto=new BirthDto();
			dto.setName(name);
			dto.setBirthday(birthday);
			
			BirthDao dao=BirthDao.getInstance();
			boolean isSuccess=dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, name+"생일 추가 했습니다");
			}else {
				JOptionPane.showMessageDialog(this, "추가실패");
			}
			displayBirthday();
		}else if(command.equals("delete")) {
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1) {
				return;
			}
			int selection=JOptionPane.showConfirmDialog(this, "삭제..?");
			if(selection!=JOptionPane.YES_OPTION) {
				return;
			}
			int num=(int)model.getValueAt(selectedIndex, 0);
			BirthDao dao=BirthDao.getInstance();
			dao.delete(num);
			displayBirthday();
		}
		
	}
	boolean isEditing=false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName().equals("tableCellEditor")) {
			int selectedIndex=table.getSelectedRow();
			int num=(int)model.getValueAt(selectedIndex, 0);
			String name=(String)model.getValueAt(selectedIndex, 1);
			BirthDto dto=new BirthDto();
			dto.setNum(num);
			dto.setName(name);
			BirthDao.getInstance().update(dto);
			isEditing=false;
		}else {
			isEditing=true;
		}
	}

}
