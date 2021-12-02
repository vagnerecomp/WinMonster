package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

import javax.swing.*;

public class Componentes {
	Controller control = new Controller();
	
	//Definição de componentes...
	
	

	 public void criaComponentes(){
		 //Definindo tela inicial...
		 final JFrame Tela = new JFrame("WinMonster");
		 Tela.setTitle("WinMOnster 1.0");
		 //Tela.setBounds(50, 100, 400, 150);
		 Tela.setVisible(true);
		 Tela.setIconImages(null);
		 Tela.setSize(400, 300);
		 
		 
		 JPanel painel = new JPanel();
		 painel.setBounds(50, 100, 400, 150);
		 painel.setVisible(true);
		 
		 
		 // Cria uma barra de menu para o JFrame
	        JMenuBar menuBar = new JMenuBar();
	        

	        painel.add(menuBar);

	        JMenu fileMenu = new JMenu("File");
	        JMenu editMenu = new JMenu("Edit");
	        menuBar.add(fileMenu);
	        menuBar.add(editMenu);
	        
	    
	        JMenuItem newAction = new JMenuItem("New");
	        JMenuItem openAction = new JMenuItem("Open");
	        JMenuItem exitAction = new JMenuItem("Exit");
	        JMenuItem cutAction = new JMenuItem("Cut");
	        JMenuItem copyAction = new JMenuItem("Copy");
	        JMenuItem pasteAction = new JMenuItem("Paste");
	        

	        JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Check Action");

	        JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem(
	                "Radio Button1");
	        JRadioButtonMenuItem radioAction2 = new JRadioButtonMenuItem(
	                "Radio Button2");


	        ButtonGroup bg = new ButtonGroup();
	        bg.add(radioAction1);
	        bg.add(radioAction2);
	        fileMenu.add(newAction);
	        fileMenu.add(openAction);
	        fileMenu.add(checkAction);
	        fileMenu.addSeparator();
	        fileMenu.add(exitAction);
	        editMenu.add(cutAction);
	        editMenu.add(copyAction);
	        editMenu.add(pasteAction);

		 
		 
		 //Definindo labels
		 final JLabel saudacao = new JLabel("Bem Vindo ao WinMonster 1.0!");
		 saudacao.setHorizontalAlignment(saudacao.CENTER);
		 saudacao.setVerticalAlignment((int) saudacao.CENTER_ALIGNMENT);
		 saudacao.setFont(null);
		 
		 //saudacao.setBounds(x, y, width, height);
		 
		 //JLabel Icone = new JLabel("V.jpg");
		 
		 
		 
		 //Definindo botões
		 JButton Compactar = new JButton("Comprimir");
		 Compactar.setBounds(20, 40, 120, 60);
		 Compactar.setVisible(true);
		 
		 
		 																						
		 


Compactar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				chooser.setFileFilter(new FileNameExtensionFilter("TXT, CPP, HTML", "txt", "cpp", "html"));
				
				chooser.setAcceptAllFileFilterUsed(false);
			
				int retorno = chooser.showOpenDialog(null);
				
				if (retorno == JFileChooser.APPROVE_OPTION) {
					
					
					try {
						FileReader file = new FileReader(chooser.getSelectedFile());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					String nomeArq = chooser.getSelectedFile().getName();
					
					String extensao = nomeArq.substring(nomeArq.lastIndexOf("."), nomeArq.length());
					
		
					
					
				} else if (retorno == JFileChooser.CANCEL_OPTION) {
					//chooser();
					
				} else if (retorno == JFileChooser.ERROR_OPTION) {

				}
			}
		});
		
		 
		 JButton Descompactar = new JButton("Extrair");
		 Descompactar.setBounds(20,  120, 400, 200);
		 Descompactar.setVisible(true);
		 
		 Descompactar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				saudacao.setText("Te peguei! Pegadinha do Malandro... GuhGuh Dadá!");
				
				
			}
			 
		 });
		 
		 
		 

		 
		 JButton sair = new JButton("Sair");
		 sair.setBounds(20, 80, 80, 60);
		 sair.setVisible(true);
		 
		 sair.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		 });
		 
		 painel.add(menuBar);
		
		 painel.add(saudacao);
		 painel.add(Compactar);
		 painel.add(Descompactar);
		 painel.add(sair);
		 
		 Tela.add(painel);
		 
		 Tela.setLocationRelativeTo(Compactar);
		 Tela.setLocationRelativeTo(Descompactar);
		 Tela.setLocationRelativeTo(sair);
		 Tela.setLocationRelativeTo(saudacao);
		 Tela.setLocationRelativeTo(menuBar);
		 
		

	
		 		 
	 }
	
	

}
