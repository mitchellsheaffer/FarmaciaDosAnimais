package views;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ProductForm extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField[] fields;
	private final String[] labels = { "Codigo:", "Nome:", "Unidade:", "Quantidade em estoque:", "Preco em dinheiro: ", "Preco a prazo:", "Preco final:", "Descricao:" };
    private final char[] mnemonics = { 'F', 'M', 'L', 'A','F','F','F','F'};
    private final int[] widths = { 4, 20, 2, 3, 4, 4, 4, 20};
    private final String[] description = { "Codigo:", "Nome:", "Unidade:", "Quantidade em estoque:", "Preco em dinheiro: ", "Preco a prazo:", "Preco final:", "Descricao:" };

	public ProductForm(){

		// Create a form with the specified labels, tooltips, and sizes.
		super(new BorderLayout());
		JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
		JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
		add(labelPanel, BorderLayout.WEST);
		add(fieldPanel, BorderLayout.CENTER);
		this.fields = new JTextField[labels.length];

		for(int i = 0; i < labels.length; i += 1) {
		   this.fields[i] = new JTextField();
		   if (i < this.description.length)
		        this.fields[i].setToolTipText(this.description[i]);
		   if (i < widths.length)
		        this.fields[i].setColumns(widths[i]);

		   JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
		   lab.setLabelFor(fields[i]);
		   if (i < mnemonics.length)
		        lab.setDisplayedMnemonic(mnemonics[i]);

		   labelPanel.add(lab);
		   JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		   p.add(this.fields[i]);
		   fieldPanel.add(p);
		}
	}

	public String getText(int i) {
	    return (this.fields[i].getText());
	 }
}
