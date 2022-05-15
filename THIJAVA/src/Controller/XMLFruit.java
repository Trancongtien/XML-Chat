package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import Model.Fruit;
import Utinity.ClassTableModel;


public class XMLFruit implements ActionListener, MouseListener {
	private JPanel pnView;
	public static File f = new File("fruit.xml");
	private JTextField txtId,txtTen,txtPrice;
	private JButton btNew;
	public XMLFruit(JPanel pnView, JTextField txtId, JTextField txtTen, JTextField txtPrice, JButton btNew) {
		super();
		this.pnView = pnView;
		this.txtId = txtId;
		this.txtTen = txtTen;
		this.txtPrice = txtPrice;
		this.btNew = btNew;
	}
	private final String[] Columns = {  "ID", "Tên", "Price" };
	private TableRowSorter<TableModel> rowSorter = null;
	private Vector<Fruit> listItem;
	private Fruit a = null;
	private DefaultTableModel model;
	private JTable table;
	public void XMLConnect() throws Exception {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		listItem = (Vector<Fruit>) readList(doc);
		model = new ClassTableModel().setTableFruit(listItem, Columns);
		table = new JTable(model);
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);
		table.addMouseListener(this);
		btNew.addActionListener(this);
		
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();

		JScrollPane scollPane = new JScrollPane();
		scollPane.getViewport().add(table);
		scollPane.setPreferredSize(new Dimension(1300, 400));
		pnView.removeAll();
		pnView.setLayout(new BorderLayout());
		pnView.add(scollPane);
		pnView.validate();
		pnView.repaint();
	}
	public Document insert() throws Exception {
		Document doc = null;
		Element root = null;

		if (!f.exists()) {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			root = doc.createElement("Class");
			doc.appendChild(root);
		} else {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
			root = doc.getDocumentElement();
		}
		Element fruit = doc.createElement("Fruit");
		root.appendChild(fruit);
		Element nickname = doc.createElement("ID");
		Text txtNick = doc.createTextNode(txtId.getText());
		nickname.appendChild(txtNick);
		fruit.appendChild(nickname);

		Element fullname = doc.createElement("Name");
		Text txtFull = doc.createTextNode(txtTen.getText());
		fullname.appendChild(txtFull);
		fruit.appendChild(fullname);

		Element email = doc.createElement("Price");
		Text txtE = doc.createTextNode(txtPrice.getText());
		email.appendChild(txtE);
		fruit.appendChild(email);

		return doc;

	}
		public static void writeXML(Document doc) {
	        try {
	            Source source = new DOMSource(doc);
	            Result result = new StreamResult(f);
	            Transformer trans = TransformerFactory.newInstance().
	                    newTransformer();
	            trans.transform(source, result);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
		public List<Fruit> readList(Document doc) {
			List<Fruit> listFruit = new Vector<Fruit>();
			try {
				doc.getDocumentElement().normalize();

				NodeList nodeListAuthor = doc.getElementsByTagName("Fruit");

				for (int i = 0; i < nodeListAuthor.getLength(); i++) {
					a = new Fruit();
					Node nNode = nodeListAuthor.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						a.setId(Integer.parseInt(eElement.getElementsByTagName("ID").item(0).getTextContent().trim()));
						a.setName(eElement.getElementsByTagName("Name").item(0).getTextContent().trim());
						a.setPrice(Double.parseDouble(eElement.getElementsByTagName("Price").item(0).getTextContent().trim()));
					}
					listFruit.add(a);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listFruit;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			int selectedRowIndex = table.getSelectedRow();
			selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
			a = (Fruit) listItem.elementAt(selectedRowIndex);
			txtId.setText(String.valueOf(a.getId()));
			txtPrice.setText(String.valueOf(a.getPrice()));
			txtTen.setText(a.getName());
			
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btNew) {
				if (txtId.getText().equals("") || txtTen.getText().equals("")
						|| txtPrice.getText().equals("") 
						) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				} else {
					try {	
						Document d=insert();
						writeXML(d);
						XMLConnect();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}	
			}
			
		}


}
