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

import test.dao.BookDao;
import test.dto.BookDto;

public class BookFrame extends JFrame implements ActionListener, PropertyChangeListener {
	JTextField inputTitle,inputAuthor,inputRating;
	DefaultTableModel model;
	JTable table;
	
	public BookFrame() {
		setLayout(new BorderLayout());
		JLabel label1=new JLabel("제목");
		JLabel label2=new JLabel("작가");
		JLabel label3=new JLabel("평점");
		
		inputTitle=new JTextField(20);
		inputAuthor=new JTextField(10);
		inputRating=new JTextField(10);
		
		JButton saveBtn=new JButton("저장");
		JButton deleteBtn=new JButton("삭제");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete");
		
		JPanel panel=new JPanel();
		panel.add(label1);
		panel.add(inputTitle);
		panel.add(label2);
		panel.add(inputAuthor);
		panel.add(label3);
		panel.add(inputRating);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel,BorderLayout.NORTH);
		
		table=new JTable();
		String[] colNames= {"번호","제목","저자","평점"};
		model=new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row,int column) {
				if(column==0) {
					return false;
				}
				return true;
			}
		};
		table.setModel(model);
		JScrollPane scroll=new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		table.addPropertyChangeListener(this);
		displayBook();
	}
	
	public void displayBook() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		
		BookDao dao=BookDao.getInstance();
		List<BookDto> list=dao.getList();
		for(BookDto tmp:list) {
			Object[] row= {tmp.getNum(),tmp.getTitle(),tmp.getAuthor(),tmp.getRating()};
			model.addRow(row);
		}
		inputTitle.setText("");
		inputAuthor.setText("");
		inputRating.setText("");
		
		
	}
	public static void main(String[] args) {
		BookFrame f=new BookFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setTitle("독서 목록");
	}
	Boolean isEditing=false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("property change");
		if(isEditing) {
			int selectedIndex=table.getSelectedRow();
			int num=(int)model.getValueAt(selectedIndex, 0);
			String title=(String)model.getValueAt(selectedIndex, 1);
			String author=(String)model.getValueAt(selectedIndex, 2);
			double rating=(double)model.getValueAt(selectedIndex, 3);
			BookDto dto=new BookDto(num, title, author, rating);
			BookDao.getInstance().update(dto);
			isEditing=false;
		}else {
			isEditing=true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("save")) {
			String title=inputTitle.getText();
			String author=inputAuthor.getText();
			double rating=Double.parseDouble(inputRating.getText());
			
			BookDto dto=new BookDto();
			dto.setTitle(title);
			dto.setAuthor(author);
			dto.setRating(rating);
			
			boolean isSuccess=BookDao.getInstance().insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, title+" 의 정보 추가함");
			}else {
				JOptionPane.showMessageDialog(this, "정보 추가 실패");
			}
			displayBook();
			
		}else if(command.equals("delete")) {
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1) {
				return;
			}
			int selection=JOptionPane.showConfirmDialog(this, "이 책을 삭제 하겠습니까?");
			if(selection!=JOptionPane.YES_OPTION) {
				return;
			}
			int num=(int)model.getValueAt(selectedIndex, 0);
			BookDao.getInstance().delete(num);
			displayBook();
		}
		
	}

}
