package br.edu.univas.si.frameCalc;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	private JLabel labelResultTitle = null;
	private JLabel labelResult = null;
	
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
	private GridBagConstraints gbcLabelResultTitle = null;
	private GridBagConstraints gbcLabelResult = null;
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
	private final int X_LABEL_RESULT_TITLE = 0;
	private final int Y_LABEL_RESULT_TITLE = 10;
	private final int X_LABEL_RESULT = 0;
	private final int Y_LABEL_RESULT = 11;
	
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
		
		contentpane.add(getLabelTitleResult(),getGbcLabelTitleResult());
		contentpane.add(getlabelResult(),getGbcResult());
		
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
			radioButtonErro.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					if(radioButtonErro.isSelected()){
						getLabelErroTamanho().setText("Tamanho da Amostra");
						getLabelTitleResult().setText("Margem de Erro:");
						getlabelResult().setText("");
					}
				}
			});
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
			radioButtonTamanho.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					if(radioButtonTamanho.isSelected()){
						getLabelErroTamanho().setText("Margem de erro (%)");
						getLabelTitleResult().setText("Tamanho Necessário");
						getlabelResult().setText("");
					}					
				}
			});
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
	
	private JLabel getLabelTitleResult(){
		if(labelResultTitle==null){
			labelResultTitle = new JLabel("Tamanho Necessário: ");
			labelResultTitle.setFont(new Font("Century",Font.BOLD,20));
			labelResultTitle.setForeground(Color.BLUE);
			labelResultTitle.setPreferredSize(new Dimension(250,50));
		}
		return labelResultTitle;
	}
	
	private JLabel getlabelResult(){
		if(labelResult==null){
			labelResult = new JLabel("");
			labelResult.setFont(new Font("Century",Font.BOLD,18));
			labelResult.setForeground(Color.BLUE);
			labelResult.setPreferredSize(new Dimension(220,50));
		}
		return labelResult;
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
	
	private GridBagConstraints getGbcLabelTitleResult(){
		if(gbcLabelResultTitle== null){
			gbcLabelResultTitle = new GridBagConstraints();
			gbcLabelResultTitle.gridx = X_LABEL_RESULT_TITLE;
			gbcLabelResultTitle.gridy = Y_LABEL_RESULT_TITLE;
		}
		return gbcLabelResultTitle;
	}
	
	private GridBagConstraints getGbcResult(){
		if(gbcLabelResult==null){
			gbcLabelResult = new GridBagConstraints();
			gbcLabelResult.gridx = X_LABEL_RESULT;
			gbcLabelResult.gridy = Y_LABEL_RESULT;
		}
		return gbcLabelResult;
	}
	
	private void buttonClicked(){
		
		float z = 0;
		double populacao =  Double.valueOf((String) getSpnPopulacao().getValue().toString()); 
		double erro_ou_tamanho =  Double.valueOf(getSpnErroTamanho().getValue().toString());
		double result = 0f;
		float p = 0.5f;
		
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
			//CALCULA ERRO DA AMOSTRA
		}else{
			//CALCULA TAMANHO DA AMOSTRA
			//result = (populacao * (z*z) * p *(1-p)) / ((populacao-1) * ((erro_ou_tamanho*erro_ou_tamanho) * (z*z)*p*(1-p))) ; 
			result = ( ((z*z)*erro_ou_tamanho*(1-p)) / (erro_ou_tamanho * erro_ou_tamanho) );
		}
		
		getlabelResult().setText(String.valueOf(result)); //coloca resultado na calculadora
		
		System.out.println("Populacao: "+populacao);
		System.out.println("Erro: "+ erro_ou_tamanho);
		System.out.println("Z: "+ z);
		
		System.out.println("Resultado: "+result);
	}
}
