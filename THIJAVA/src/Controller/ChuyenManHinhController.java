package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.*;

import Bean.DanhMucBean;
import View.*;

public class ChuyenManHinhController extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel root;
	private String kindSelected = "";
	private List<DanhMucBean> listItem= null;

	public ChuyenManHinhController(JPanel pnRoot) {
		this.root = pnRoot;
	}

	public void setView(JPanel pnItem, JLabel lbItem) {
		kindSelected = "Menu";
		pnItem.setBackground(new Color(96, 100, 191));
		lbItem.setBackground(new Color(96, 100, 191));

		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new FruitPanel());
		root.validate();
		root.repaint();
	}

	public void setEvent(List<DanhMucBean> listDanhMuc) {
		this.listItem = listDanhMuc;
		for (DanhMucBean item : listDanhMuc) {
			item.getLb().addMouseListener(new LabelEvent(item.getKind(), item.getPn(), item.getLb()));
		}
	}

	class LabelEvent implements MouseListener {
		private JPanel node;
		private String kind;
		
		private JPanel pnItem;
		private JLabel lbItem;

		public LabelEvent(String kind, JPanel pnItem, JLabel lbItem) {
			this.kind = kind;
			this.pnItem = pnItem;
			this.lbItem = lbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {

			switch (kind) {
			case "Menu":
				node = new FruitPanel();
				break;
			case "Chat":
				node = new ChatView();
				break;
			
			default:
				break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackground(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			kindSelected = kind;
			pnItem.setBackground(new Color(96, 100, 191));
			lbItem.setBackground(new Color(96, 100, 191));

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			pnItem.setBackground(new Color(96, 100, 191));
			lbItem.setBackground(new Color(96, 100, 191));

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!kindSelected.equalsIgnoreCase(kind)) {
				pnItem.setBackground(new Color(0, 250,0));
				lbItem.setBackground(new Color(0, 250, 0));
			}

		}
	}

	private void setChangeBackground(String kind) {
	
		for (DanhMucBean item : listItem) {
			if (item.getKind().equalsIgnoreCase(kind)) {
				item.getPn().setBackground(new Color(96, 100, 191));
				item.getLb().setBackground(new Color(96, 100, 191));
				
			} else {
				item.getPn().setBackground(new Color(0, 250, 0));
				item.getLb().setBackground(new Color(0, 250, 0));
			}
		}
	}
}
