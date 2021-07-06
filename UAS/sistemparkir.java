package parkir;

import java.sql.Connection;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JRadioButtonMenuItem;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.AbstractListModel;
import javax.swing.JSplitPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class sistemparkir {

	private JFrame frame;
	private JTextField txtNopol;
	private JTextField txtTipe;
	private JTextField txtJam_masuk;
	private JTextField txtJam_keluar;
	private JTextField textField;
	private JTextField txt;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/adel";
    static final String USER = "adel";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    private JTable tabelData;
    private JTable table;
    private JTextField txtTanggal;
    private JTextField txtJam;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sistemparkir window = new sistemparkir();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Jam()
	{
		Thread Jam = new Thread()
			{
				public void run()
				{
					try {
						for(;;) {
							Date t = new Date();
							SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
							txtJam.setText(formatter.format(t));
							
							sleep(1000);
						}
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			};
			
			Jam.start();
	}
	
	public void Tanggal()
	{
		Thread Tanggal = new Thread()
		{
			public void run()
			{
				try {
					for(;;) {
						Date d = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						txtTanggal.setText(formatter.format(d));
						
						sleep(1000);
					}
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		
		Tanggal.start();
		
	}
	
	
	/**
	 * Create the application.
	 */
	public sistemparkir() {
		initialize();
		Tanggal();
		Jam();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSistemParkirPt = new JLabel("Sistem Parkir PT. FULLSUN");
		lblSistemParkirPt.setBounds(115, 11, 207, 23);
		lblSistemParkirPt.setFont(new Font("Verdana", Font.BOLD, 14));
		frame.getContentPane().add(lblSistemParkirPt);
		
		txtTanggal = new JTextField();
		txtTanggal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTanggal.setFont(new Font("Verdana", Font.BOLD, 13));
		txtTanggal.setText("Tanggal :");
		txtTanggal.setBounds(22, 45, 175, 23);
		frame.getContentPane().add(txtTanggal);
		txtTanggal.setColumns(10);
		
		txtJam = new JTextField();
		txtJam.setHorizontalAlignment(SwingConstants.CENTER);
		txtJam.setFont(new Font("Verdana", Font.BOLD, 13));
		txtJam.setText("Jam :");
		txtJam.setBounds(217, 45, 188, 23);
		frame.getContentPane().add(txtJam);
		txtJam.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("No. Polisi");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel.setBounds(22, 87, 58, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtNopol = new JTextField();
		txtNopol.setBounds(131, 84, 106, 17);
		frame.getContentPane().add(txtNopol);
		txtNopol.setColumns(10);
		
		JLabel lblJenisKendaraan = new JLabel("Jenis Kendaraan");
		lblJenisKendaraan.setFont(new Font("Verdana", Font.BOLD, 10));
		lblJenisKendaraan.setBounds(22, 112, 101, 14);
		frame.getContentPane().add(lblJenisKendaraan);
		
		JComboBox txtTipe = new JComboBox();
		txtTipe.setModel(new DefaultComboBoxModel(new String[] {"Mobil", "Motor", "Truk"}));
		txtTipe.setToolTipText("");
		txtTipe.setBounds(131, 111, 106, 17);
		frame.getContentPane().add(txtTipe);		
		
		JButton btnJamMasuk = new JButton("Jam Masuk");
		btnJamMasuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nopol = txtNopol.getText().toString().trim();
				String tipe = (String)txtTipe.getSelectedItem().toString().trim();
				String tanggal = txtTanggal.getText().toString().trim();
				int jam_masuk = Integer.parseInt(txtJam_masuk.getText());
						
				insert(nopol,tipe,tanggal,jam_masuk);//method digunakan untuk insert data
				show();
				txtNopol.setText("");
				txtTipe.setSelectedItem("");
				txtTanggal.setText("");
				txtJam_masuk.setText("");
			}
		});
		
		btnJamMasuk.setFont(new Font("Verdana", Font.BOLD, 10));
		btnJamMasuk.setForeground(SystemColor.text);
		btnJamMasuk.setBounds(10, 147, 101, 33);
		btnJamMasuk.setBackground(new Color(70, 130, 180));
		btnJamMasuk.setOpaque(true);
		frame.getContentPane().add(btnJamMasuk);
		
		JButton btnJamKeluar = new JButton("Jam Keluar");
		btnJamKeluar.setForeground(SystemColor.text);
		btnJamKeluar.setBackground(new Color(70, 130, 180));
		btnJamKeluar.setFont(new Font("Verdana", Font.BOLD, 10));
		btnJamKeluar.setBounds(121, 147, 100, 33);
		frame.getContentPane().add(btnJamKeluar);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(SystemColor.text);
		btnEdit.setBackground(new Color(70, 130, 180));
		btnEdit.setFont(new Font("Verdana", Font.BOLD, 10));
		btnEdit.setBounds(231, 147, 89, 33);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(SystemColor.text);
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 10));
		btnDelete.setBackground(new Color(70, 130, 180));
		btnDelete.setBounds(330, 147, 89, 33);
		frame.getContentPane().add(btnDelete);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 191, 409, 118);
		frame.getContentPane().add(scrollPane);
		
		
		tabelData = new JTable();
		tabelData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
	
	public void insert(String nopol,String tipe, String tanggal, int jam_masuk)
	{
		try {
            Class.forName(JDBC_DRIVER);
            
   
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
 
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO parkir (nopol,tipe,tanggal,jam_masuk) VALUES (?,?,?,?)";
            
            PreparedStatement pms = conn.prepareStatement(sql);
            pms.setString(1, nopol);
            pms.setString(2, tipe);
            pms.setString(3, tanggal);
            pms.setInt(4, jam_masuk);
            
            pms.execute();
           
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void show()
	{

		try {
			Class.forName(JDBC_DRIVER);
            
			   
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nomor Polisi");
            model.addColumn("Tipe");
            model.addColumn("Tanggal");
            model.addColumn("Jam Masuk");
            model.addColumn("Jam Keluar");
            model.addColumn("Biaya");
            model.addColumn("Jenis Kendaaran");
 
            stmt = conn.createStatement();
            String sql = "SELECT * FROM parkir";
            int i = 1;
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	model.addRow(new Object[] {
            		rs.getString("id"),
            		rs.getString("nopol"),
            		rs.getString("tipe"),
            		rs.getString("tanggal"),
            		rs.getString("jam_masuk"),
            		rs.getString("jam_keluar")
            	});
            	i++;
            }
            rs.close();
            conn.close();
            stmt.close();
            
            tabelData.setModel(model);
            tabelData.setAutoResizeMode(0);
            //modifikasi lebar kolom (optional)
            tabelData.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelData.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelData.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelData.getColumnModel().getColumn(3).setPreferredWidth(100);
           
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        
	}
}
