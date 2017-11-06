package br.edu.univas.si.frameCalc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FrameCalculadora extends JFrame{
	
	private static final long serialVersionUID = -2930681070156963374L;
	
	private JPanel contentpane = null;
	private JButton buttonCalcula = null;
	private JLabel labelPopulacao = null;
	private JSpinner spnPopulacao = null;
	private JLabel labelErroTamanho = null;
	private JSpinner spnErroTamanho = null;
	private JLabel labelConfiabilidade = null;
	private JComboBox<String> comboBoxConfiabilidade = null;
	private JLabel labelRadioBoxErro = null;
	private JLabel labelCheckBoxTamanho = null;
	private JRadioButton radioButtonErro = null;
	private JRadioButton radioButtonTamanho = null;
	private ButtonGroup buttonGroupCalc = new ButtonGroup();
	
	private GridBagConstraints gbcLabelCheckBoxErro = null;
	private GridBagConstraints gbcRadioButtonErro = null; 
	private GridBagConstraints gbcLabelCheckBoxTamanho = null;
	private GridBagConstraints gbcLabelPopupacao = null;
	private GridBagConstraints gbcSpndPopulacao = null;
	private GridBagConstraints gbcLabelErroTamanho = null;
	private GridBagConstraints gbcSpnErroTamanho = null;
	private GridBagConstraints gbcLabelConfiabilidade = null;
	private GridBagConstraints gbcComboBoxConfiabilidade = null;
	private GridBagConstraints gbcRadioButtonTamanho = null;
	private GridBagConstraints gbcButtonCalcula = null;
	//constantes dos gridsBagConstraints
	private final int X_LABEL_RADIO_BUTTON_ERRO = 0;
	private final int Y_LABEL_RADIO_BUTTON_ERRO = 0;
	private final int X_RADIO_BUTTON_ERRO = 0;
	private final int Y_RADIO_BUTTON_ERRO = 1; 
	private final int X_LABEL_RADIO_BUTTON_TAMANHO = 1;
	private final int Y_LABEL_RADIO_BUTTON_TAMANHO = 0;
	private final int X_RADIO_BUTTON_TAMANHO = 1;
	private final int Y_RADIO_BUTTON_TAMANHO = 1;
	private final int X_LABEL_POPULACAO = 0;
	private final int Y_LABEL_POPULACAO = 2;
	private final int X_SPN_POPULACAO = 0;
	private final int Y_SPN_POPULACAO = 3;
	private final int X_LABEL_ERRO_TAMANHO = 0;
	private final int Y_LABEL_ERRO_TAMANHO = 4;
	private final int X_SPN_ERRO_TAMANHO = 0;
	private final int Y_SPN_ERRO_TAMANHO = 5;
	private final int X_LABEL_CONFIABILIDADE = 0;
	private final int Y_LABEL_CONFIABILIDADE = 6;
	private final int X_COMBO_BOX_CONFIABILIDADE = 0;
	private final int Y_COMBO_BOX_CONFIABILIDADE = 7;
	private final int X_BUTTON_CALCULA = 0;
	private final int Y_BUTTON_CALCULA = 8;
	
	public FrameCalculadora(){
		super("Calculadora");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCalculadora.class.getResource("/br/edu/univas/si/imagens/calculadora.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,600));
		setResizable(false);
		
		
		initialize();
		add(contentpane, BorderLayout.NORTH);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		contentpane = new JPanel(new GridBagLayout());
		contentpane.add(getLabelRadioButtonErro(), getGbcLabelRadioButtonErro());
		contentpane.add(getRadioButtonErro()	  , getGbcRadioButtonErro());
		contentpane.add(getLabelRadioButtonTamanho(), getGbcLabelRadioButtonTamanho());
		contentpane.add(getRadioButtonTamanho() , getGbcRadioButtonTamanho());
		contentpane.add(getLabelPopulacao()  , getGbcLabelPopupacao());
		contentpane.add(getSpnPopulacao()	 , getGbcSpndPopulacao());
		contentpane.add(getLabelErroTamanho(), getGbcLabelErroTamanho());
		contentpane.add(getSpnErroTamanho()	 , getGbcSpnErroTamanho());
		contentpane.add(getLabelConfiabilidade()   , getGbcLabelConfiabilidade());
		contentpane.add(getComboBoxConfiabilidade(), getGbcComboBoxConfiabilidade());
		contentpane.add(getButtonCalcula(), getGbcButtonCalcula());
	}
	
	private JLabel getLabelRadioButtonErro(){
		if(labelRadioBoxErro==null){
			labelRadioBoxErro = new JLabel("Margem de erro");
			labelRadioBoxErro.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelRadioBoxErro;
	}
	
	private JRadioButton getRadioButtonErro(){
		if(radioButtonErro==null){
			radioButtonErro = new JRadioButton();
			buttonGroupCalc.add(radioButtonErro);
		}
		return radioButtonErro;
	}
	
	private JLabel getLabelRadioButtonTamanho(){
		if(labelCheckBoxTamanho==null){
			labelCheckBoxTamanho = new JLabel("Tamanho da Amostra");
			labelCheckBoxTamanho.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelCheckBoxTamanho;
	}
	
	private JRadioButton getRadioButtonTamanho(){
		if(radioButtonTamanho==null){
			radioButtonTamanho = new JRadioButton();
			radioButtonTamanho.setSelected(true);
			buttonGroupCalc.add(radioButtonTamanho);
		}
		return radioButtonTamanho;
	}

	private JLabel getLabelPopulacao() {
		if(labelPopulacao == null){
			labelPopulacao = new JLabel("População");
			labelPopulacao.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelPopulacao;
	}

	private JSpinner getSpnPopulacao() {
		if(spnPopulacao == null){
			spnPopulacao = new JSpinner();
			spnPopulacao.setModel(new SpinnerNumberModel(1, 1, 2147483647, 1));
			spnPopulacao.setPreferredSize(new Dimension(256, 40));
		}
		return spnPopulacao;
	}

	private JLabel getLabelErroTamanho() {
		if(labelErroTamanho==null){
			labelErroTamanho = new JLabel("Margem de erro (%)");
			labelErroTamanho.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelErroTamanho;
	}

	private JSpinner getSpnErroTamanho() {
		if(spnErroTamanho==null){
			spnErroTamanho = new JSpinner();
			spnErroTamanho.setModel(new SpinnerNumberModel(1, 1, 2147483647, 1));
			spnErroTamanho.setPreferredSize(new Dimension(256, 40));
		}
		return spnErroTamanho;
	}
	
	private JLabel getLabelConfiabilidade(){
		if(labelConfiabilidade==null){
			labelConfiabilidade = new JLabel("Confiabilidade (%)");
			labelConfiabilidade.setFont(new Font("Century",Font.PLAIN,14));
		}
		return labelConfiabilidade;
	}

	private JComboBox<String> getComboBoxConfiabilidade() {
		if(comboBoxConfiabilidade==null){
			comboBoxConfiabilidade = new JComboBox<String>();
			comboBoxConfiabilidade.addItem("90");
			comboBoxConfiabilidade.addItem("95");
			comboBoxConfiabilidade.addItem("99");
			comboBoxConfiabilidade.setPreferredSize(new Dimension(245, 30));
		}
		return comboBoxConfiabilidade;
	}
	
	private JButton getButtonCalcula(){
		if(buttonCalcula==null){
			buttonCalcula = new JButton("Calcular");
			buttonCalcula.setFont(new Font("Century",Font.PLAIN,14));
			buttonCalcula.setPreferredSize(new Dimension(90,90));
			buttonCalcula.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					buttonClicked();
				}
			});
		}
		return buttonCalcula;
	}
	
	private GridBagConstraints getGbcLabelPopupacao() {
		if(gbcLabelPopupacao==null){
			gbcLabelPopupacao = new GridBagConstraints();
			gbcLabelPopupacao.gridx = X_LABEL_POPULACAO;
			gbcLabelPopupacao.gridy = Y_LABEL_POPULACAO;
			gbcLabelPopupacao.insets = new Insets(35, 5, 5, 5);
		}
		return gbcLabelPopupacao;
	}

	private GridBagConstraints getGbcSpndPopulacao() {
		if(gbcSpndPopulacao==null){
			gbcSpndPopulacao = new GridBagConstraints();
			gbcSpndPopulacao.gridx = X_SPN_POPULACAO;
			gbcSpndPopulacao.gridy = Y_SPN_POPULACAO;
		}
		return gbcSpndPopulacao;
	}

	private GridBagConstraints getGbcLabelErroTamanho() {
		if(gbcLabelErroTamanho==null){
			gbcLabelErroTamanho = new GridBagConstraints();
			gbcLabelErroTamanho.gridx = X_LABEL_ERRO_TAMANHO;
			gbcLabelErroTamanho.gridy = Y_LABEL_ERRO_TAMANHO;
			gbcLabelErroTamanho.insets =  new Insets(25, 5, 5, 5);
		}
		return gbcLabelErroTamanho;
	}

	private GridBagConstraints getGbcSpnErroTamanho() {
		if(gbcSpnErroTamanho==null){
			gbcSpnErroTamanho = new GridBagConstraints();
			gbcSpnErroTamanho.gridx = X_SPN_ERRO_TAMANHO;
			gbcSpnErroTamanho.gridy = Y_SPN_ERRO_TAMANHO;
		}
		return gbcSpnErroTamanho;
	}
	
	private GridBagConstraints getGbcLabelConfiabilidade(){
		if(gbcLabelConfiabilidade==null){
			gbcLabelConfiabilidade = new GridBagConstraints();
			gbcLabelConfiabilidade.gridx = X_LABEL_CONFIABILIDADE;
			gbcLabelConfiabilidade.gridy = Y_LABEL_CONFIABILIDADE;
			gbcLabelConfiabilidade.insets = new Insets(25, 5, 5, 5);
		}
		return gbcLabelConfiabilidade;
	}

	private GridBagConstraints getGbcComboBoxConfiabilidade() {
		if(gbcComboBoxConfiabilidade==null){
			gbcComboBoxConfiabilidade = new GridBagConstraints();
			gbcComboBoxConfiabilidade.gridx = X_COMBO_BOX_CONFIABILIDADE;
			gbcComboBoxConfiabilidade.gridy = Y_COMBO_BOX_CONFIABILIDADE;
		}
		return gbcComboBoxConfiabilidade;
	}
	
	private GridBagConstraints getGbcRadioButtonErro(){
		if(gbcRadioButtonErro==null){
			gbcRadioButtonErro = new GridBagConstraints();
			gbcRadioButtonErro.gridx = X_RADIO_BUTTON_ERRO;
			gbcRadioButtonErro.gridy = Y_RADIO_BUTTON_ERRO;
		}
		return gbcRadioButtonErro;
	}
	
	private GridBagConstraints getGbcRadioButtonTamanho(){
		if(gbcRadioButtonTamanho==null){
			gbcRadioButtonTamanho = new GridBagConstraints();
			gbcRadioButtonTamanho.gridx = X_RADIO_BUTTON_TAMANHO;
			gbcRadioButtonTamanho.gridy = Y_RADIO_BUTTON_TAMANHO;
		}
		return gbcRadioButtonTamanho;
	}
	
	private GridBagConstraints getGbcLabelRadioButtonErro(){
		if(gbcLabelCheckBoxErro==null){
			gbcLabelCheckBoxErro = new GridBagConstraints();
			gbcLabelCheckBoxErro.gridx = X_LABEL_RADIO_BUTTON_ERRO;
			gbcLabelCheckBoxErro.gridx = Y_LABEL_RADIO_BUTTON_ERRO;
			gbcLabelCheckBoxErro.insets = new Insets(10, 3, 3, 3);
		}
		return gbcLabelCheckBoxErro;
	}
	
	private GridBagConstraints getGbcLabelRadioButtonTamanho(){
		if(gbcLabelCheckBoxTamanho==null){
			gbcLabelCheckBoxTamanho = new GridBagConstraints();
			gbcLabelCheckBoxTamanho.gridx = X_LABEL_RADIO_BUTTON_TAMANHO;
			gbcLabelCheckBoxTamanho.gridy = Y_LABEL_RADIO_BUTTON_TAMANHO;
			gbcLabelCheckBoxTamanho.insets = new Insets(10, 3, 3, 3);
		}
		return gbcLabelCheckBoxTamanho;
	}
	
	private GridBagConstraints  getGbcButtonCalcula(){
		if(gbcButtonCalcula==null){
			gbcButtonCalcula = new  GridBagConstraints();
			gbcButtonCalcula.gridx = X_BUTTON_CALCULA;
			gbcButtonCalcula.gridy = Y_BUTTON_CALCULA; 
		}
		return gbcButtonCalcula;
	}
	
	private void buttonClicked(){
		
		//TODO implements... Fazer o calculo
		float z = 0;
		float populacao =  Float.valueOf((String) getSpnPopulacao().getValue()); 
		float erro_tamanho =  (float) getSpnErroTamanho().getValue();
		int result = 0;
		
		//Pega valor Z
		if(getComboBoxConfiabilidade().getSelectedItem().equals("90")){
			z = 1.64f; 
		}
		if(getComboBoxConfiabilidade().getSelectedItem().equals("95")){
			z = 1.96f;
		}
		if(getComboBoxConfiabilidade().getSelectedItem().equals("99")){
			z = 2.57f;
		} 		
		
		if(getRadioButtonErro().isSelected()){
			
		}else{
			
		}
	}
}
