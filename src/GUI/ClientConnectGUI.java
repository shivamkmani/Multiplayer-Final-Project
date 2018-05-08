package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.Client;
import main.Server;

public class ClientConnectGUI implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	
	private JTextField IPField;
	private JButton connectB;
	
	private Client client;
	
	public ClientConnectGUI() {
		initialize();
	}
	
	private void initialize(){
		frame = new JFrame("Connect to Server");
		frame.setBounds(0,0,500,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		addComponents();
		frame.setVisible(true);
		panel.setBackground(Color.CYAN);
	}
	
	private void addComponents() {
		IPField = new JTextField();
		IPField.setBounds(20, 20, 440, 50);
		IPField.setForeground(Color.GRAY);
		IPField.setText("Server IP");
		panel.add(IPField);
		
		connectB = new JButton("Connect to Server");
		connectB.setBounds(300, 85, 150, 50);
		connectB.setForeground(Color.BLUE);
		connectB.setActionCommand("connect");
		connectB.addActionListener(this);
		panel.add(connectB);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if(command.equals("connect")) {
			System.out.println("connecting...");
			
			try {
				frame.hide();
				String name = JOptionPane.showInputDialog(
				          frame,
				            "Enter name",
				            "Enter name",
				            JOptionPane.QUESTION_MESSAGE);
				client = new Client(IPField.getText(), name);
				LobbyGUI lGUI = new LobbyGUI(client);
				lGUI.start();
				client.start();

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
	
