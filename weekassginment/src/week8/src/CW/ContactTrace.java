package CW;

import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactTrace extends JFrame {
	File file = new File("TraceMatrix.txt");
	private JPanel contentPane;
	JComboBox<Combo> per_1;
	JComboBox<Combo> per_2;
	private ArrayList<String[]> array_string;
	int[][] adjacency_matrix = new int[61][61];
	private ArrayList<String[]> all_data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ContactTrace frame = new ContactTrace();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ContactTrace() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Person - 1");
		lblNewLabel.setBounds(104, 99, 148, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblPerson = new JLabel("Person - 2");
		lblPerson.setBounds(104, 172, 148, 25);
		contentPane.add(lblPerson);
		
		per_1 = new JComboBox<>();
		per_1.setBounds(255, 103, 235, 25);
		contentPane.add(per_1);
		
		per_2 = new JComboBox<>();
		per_2.setBounds(255, 172, 235, 25);
		contentPane.add(per_2);
		
		JLabel lblNewLabel_1 = new JLabel("Contacted");
		lblNewLabel_1.setBounds(255, 148, 87, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Save information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object p1 = per_1.getSelectedItem();
				assert p1 != null;
				int s1 = ((Combo) p1).getValue();

				Object p2 = per_2.getSelectedItem();
				int s2 = ((Combo) p2).getValue();

				trace(s1,s2);
				JOptionPane.showMessageDialog(btnNewButton,"Matrix written!");

			}
		});
		btnNewButton.setBounds(255, 225, 235, 29);
		contentPane.add(btnNewButton);
		
		JButton btnGoToDashboard = new JButton("Go to dashboard");
		btnGoToDashboard.setBounds(255, 295, 235, 29);
		contentPane.add(btnGoToDashboard);
		
		JButton btnHighRisk = new JButton("High Risk");
		btnHighRisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HighRisk(adjacency_matrix).setVisible(true);
			}
		});
		btnHighRisk.setBounds(107, 377, 235, 29);
		contentPane.add(btnHighRisk);
		
		JButton btnGoToDashboard_1_1 = new JButton("Low Risk");
		btnGoToDashboard_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ModerateRisk(adjacency_matrix).setVisible(true);
			}
		});
		btnGoToDashboard_1_1.setBounds(350, 377, 235, 29);
		contentPane.add(btnGoToDashboard_1_1);
		read_MatrixFirst();
		fetch_data();
		fillCombo();
	}

	public void fillCombo(){
		for(String[] i: array_string){
			per_1.addItem(new Combo(i[1], Integer.parseInt(i[0])));
			per_2.addItem(new Combo(i[1], Integer.parseInt(i[0])));
		}
	}

	public void fetch_data() {
		File f = new File("citizen.txt");
		Object[] tablelines;
		array_string = new ArrayList<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			tablelines = br.lines().toArray();
			for (int i = 0; i < tablelines.length; i++) {
				String taine = tablelines[i].toString().trim();
				String[] arr = taine.split(",");
//				System.out.println(Arrays.toString(arr));
				array_string.add(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void trace(int source, int destination){
		System.out.println("Source: "+source);
		System.out.println("Destiantion: "+destination);
		adjacency_matrix[source][destination] = 1;
		writeMatrix();

	}

	void writeMatrix()  {
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					builder.append(adjacency_matrix[i][j]);
					if (j < 19) {
						builder.append(",");
					}
				}
				builder.append("\n");
			}

			BufferedWriter wr = new BufferedWriter(new FileWriter("TraceMatrix.txt"));
			wr.write(builder.toString());
			wr.close();
		}

		catch(Exception e){
			System.out.println();
		}
	}

	public void makeMatrix(){
		adjacency_matrix = new int[20][20];
		file = new File("TraceMatrix.txt");
		if (!file.exists()){
			try {
				file.createNewFile();
				writeNextMatrix();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	void writeNextMatrix()  {
		adjacency_matrix =new int[61][61];
		StringBuilder builder = new StringBuilder();
		try {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					builder.append(adjacency_matrix[i][j] + "");
					if (j < 19) {
						builder.append(",");
					}
				}
				builder.append("\n");
			}

			BufferedWriter wr = new BufferedWriter(new FileWriter("TraceMatrix.txt"));
			wr.write(builder.toString());
			wr.close();
		}

		catch(Exception e){
			System.out.println();
		}
	}


	public void read_MatrixFirst() {
		all_data = new ArrayList<String []>();
		if(!file.exists()){
			makeMatrix();
			writeNextMatrix();
		}

		try {
			Object[] currentLine;
			BufferedReader br = new BufferedReader(new FileReader(new File("TraceMatrix.txt")));
			currentLine = br.lines().toArray();
			for (Object s : currentLine) {
				String ln = s.toString().trim();
				String[] row = ln.split(",");
				all_data.add(row);

			}
			br.close();

			int len = all_data.size();
			if(len!=0){
				for(int i=0;i<len-1;i++){
					for(int j=0;j<all_data.get(0).length;j++){
						adjacency_matrix[i][j] = Integer.parseInt(all_data.get(i)[j]);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
