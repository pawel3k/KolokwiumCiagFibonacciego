import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KolokwiumFibonacci  extends JFrame implements ActionListener {
	
	JTextField pole_gorne;
	JTextField pole_dolne;
	
	public int liczba;
	public String podajWartosc;
	
	JButton oblicz;
	
	public static void main(String[] args) {
		
		KolokwiumFibonacci frame = new KolokwiumFibonacci();
		frame.initUI();

	}

	private void initUI() {
		
		pole_gorne = new JTextField("Podaj numer wyrazu ci¹gu.");
		pole_dolne = new JTextField("Wynik");
		
		oblicz = new JButton("Oblicz!");
		oblicz.addActionListener(this);
		
		this.add(pole_gorne);
		this.add(oblicz);
		this.add(pole_dolne);
		
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setTitle("Ci¹g Fibonacciego");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(oblicz.equals(e.getSource())) {
			oblicz();
		}
		
	}

	private void oblicz() {
		
		try {
			
		podajWartosc = pole_gorne.getText();
		
		} catch(NumberFormatException e1) {
			
			pole_dolne.setText("Nie poda³eœ numeru wyrazu ci¹gu!");
			
		}
		
		liczba = Integer.parseInt(podajWartosc);
		
		if(liczba <= 0) {
			
			pole_dolne.setText("Podaj dodatni¹ wartoœæ!");
			
		}
		
		if (pole_gorne.getText().isBlank()) {
			pole_dolne.setText("Proszê podaæ wartoœæ!");
		}
		
		pole_dolne.setText(String.valueOf(fibo(liczba)));
	
	}

	
    public static int fibo(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return fibo(x - 1) + fibo(x - 2);
        }
    }
	
}
