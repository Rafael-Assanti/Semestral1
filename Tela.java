
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame implements ActionListener, MouseListener
{
	private JButton botoes[][];
    public Color fundo, fundo2;
    String ultimoString, antString, answString, op ;
    int gira;
    double ant, answ;
    int x[][];
	public Tela()
    {
		super("Nome da tela");

        x = new int[10][10];


        fundo = new Color(24,24,24);
        fundo2 = new Color(236,226,145);
        
        
        gira = 0; //Ver se o usuario esta no modo horizontal ou vertical de colocar nave


        
        //Cria o GUI com um grid 10x10
        Container caixa = getContentPane();

        caixa.setLayout(new GridLayout(10,10));
        setSize(750,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Inicializa os botoes adicionando mouse e action listeners e coloca eles no GUI
        botoes = new JButton[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j<10;j++){
                botoes[i][j] = new JButton();
                caixa.add(botoes[i][j]);
                botoes[i][j].addActionListener(this);
                botoes[i][j].addMouseListener(this);
            }
        }
    }    

    public void actionPerformed(ActionEvent e) //IGNORA ISSO AQUI (N fiz ainda) -------------------
    // Temos q colocar os barcos colocados no sql e toda vez q o usuario passar o mouse por cima
    // tem q fazer uma pesquisa no sql e se tiver barco bloqueando o caminho dele a gnt coloca mais
    // um if else na linha 106 q nao permeti o usuario colocar o barco dele ali
    //--------------------------------------------------------------------------------------------
    {   
        for (int j = 0; j<10;j++){
            for (int i = 0; i<10;i++){
                if(e.getSource()==botoes[j][i]){
                    if((i < 8 && gira == 0) && x[j][i] == 0 && x[j][i+1] == 0 && x[j][i+2] == 0){
                        botoes[j][i].setOpaque(false);
                        botoes[j][i].setContentAreaFilled(false);
                        botoes[j][i].setBorderPainted(false);
                        botoes[j][i].setEnabled(false);
                        x[j][i] = 1;

                        botoes[j][i+1].setOpaque(false);
                        botoes[j][i+1].setContentAreaFilled(false);
                        botoes[j][i+1].setBorderPainted(false);
                        botoes[j][i+1].setEnabled(false);
                        x[j][i+1] = 1;

                        botoes[j][i+2].setOpaque(false);
                        botoes[j][i+2].setContentAreaFilled(false);
                        botoes[j][i+2].setBorderPainted(false);
                        botoes[j][i+2].setEnabled(false);
                        x[j][i+2] = 1;
                    }
                    else if((i < 8 && gira == 1) && x[j][i] == 0 && x[j+1][i] == 0 && x[j+2][i] == 0){
                        botoes[j][i].setOpaque(false);
                        botoes[j][i].setContentAreaFilled(false);
                        botoes[j][i].setBorderPainted(false);
                        botoes[j][i].setEnabled(false);
                        x[j][i] = 1;

                        botoes[j+1][i].setOpaque(false);
                        botoes[j+1][i].setContentAreaFilled(false);
                        botoes[j+1][i].setBorderPainted(false);
                        botoes[j+1][i].setEnabled(false);
                        x[j+1][i] = 1;

                        botoes[j+2][i].setOpaque(false);
                        botoes[j+2][i].setContentAreaFilled(false);
                        botoes[j+2][i].setBorderPainted(false);
                        botoes[j+2][i].setEnabled(false);
                        x[j+2][i] = 1;
                    }
                }
            }
        }
    }
    public void mouseEntered(MouseEvent e) {
        switch (gira) {

            case 0: //Quando o modo de colocar for horizontal
                for (int j = 0; j<10;j++){
                    for (int i = 0; i<10;i++){
                        if(e.getSource()==botoes[j][i]){
                            if(i == 9){ //Se o barco estivel perto demais da borda ele n vai deixar o usuario colocar
                                botoes[j][i].setBackground(Color.RED);
                            }
                            else if(i ==8){ //Se o barco estivel perto demais da borda ele n vai deixar o usuario colocar
                            botoes[j][i].setBackground(Color.RED);
                            botoes[j][i+1].setBackground(Color.RED);
                            }
                            else if(x[j][i] == 1 || x[j][i+1] == 1 || x[j][i+2] == 1){ //O usuario pode colocar o barco aqui
                                botoes[j][i].setBackground(Color.RED);
                                botoes[j][i+1].setBackground(Color.RED);
                                botoes[j][i+2].setBackground(Color.RED);
                            }
                            else{
                                botoes[j][i].setBackground(Color.GREEN);
                                botoes[j][i+1].setBackground(Color.GREEN);
                                botoes[j][i+2].setBackground(Color.GREEN);
                            }
                        }
                    }
                }
                break;

            case 1: //Quando o modo de colocar for vertical
                for (int o = 0; o<10;o++){
                    for (int p = 0; p<10;p++){
                        if(e.getSource()==botoes[o][p]){
                            if(o == 9){ //Se o barco estivel perto demais da borda ele n vai deixar o usuario colocar
                                botoes[o][p].setBackground(Color.RED); //Pinta o fundo de vermelho
                            }
                            else if(o ==8){ //Se o barco estivel perto demais da borda ele n vai deixar o usuario colocar
                            botoes[o][p].setBackground(Color.RED); //Pinta o fundo de vermelho
                            botoes[o+1][p].setBackground(Color.RED); //Pinta o fundo de vermelho
                            
                            }
                            else if(x[o][p] == 1 || x[o+1][p] == 1 || x[o+2][p] == 1){ //O usuario pode colocar o barco aqui
                                botoes[o][p].setBackground(Color.RED);
                                botoes[o+1][p].setBackground(Color.RED);
                                botoes[o+2][p].setBackground(Color.RED);
                            }
                            else{ //O usuario pode colocar o barco aqui
                                botoes[o][p].setBackground(Color.GREEN); //Pinta o fundo de verde
                                botoes[o+1][p].setBackground(Color.GREEN); //Pinta o fundo de verde
                                botoes[o+2][p].setBackground(Color.GREEN); //Pinta o fundo de verde
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
    public void mouseExited(MouseEvent e) {
        switch (gira) {
            case 0:
                for (int j = 0; j<10;j++){
                    for (int i = 0; i<10;i++){
                        if(e.getSource()==botoes[j][i]){ //Acho q isso daqui da pra simplifica ent vou comentar dps
                            if(i == 9){
                                botoes[j][i].setBackground(UIManager.getColor("control"));
                            }
                            else if(i ==8){
                                botoes[j][i].setBackground(UIManager.getColor("control"));
                                botoes[j][i+1].setBackground(UIManager.getColor("control"));
                            }
                            else{
                                botoes[j][i].setBackground(UIManager.getColor("control"));
                                botoes[j][i+1].setBackground(UIManager.getColor("control"));
                                botoes[j][i+2].setBackground(UIManager.getColor("control"));
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int o = 0; o<10;o++){
                    for (int p = 0; p<10;p++){
                        if(e.getSource()==botoes[o][p]){ //Acho q isso daqui da pra simplifica ent vou comentar dps
                            if(o == 9){
                                botoes[o][p].setBackground(UIManager.getColor("control"));
                            }
                            else if(o ==8){
                                botoes[o][p].setBackground(UIManager.getColor("control")); //Restaura a cor pra antes do vermelho/verde
                                botoes[o+1][p].setBackground(UIManager.getColor("control"));
                            
                            }
                            else{
                                botoes[o][p].setBackground(UIManager.getColor("control"));
                                botoes[o+1][p].setBackground(UIManager.getColor("control"));
                                botoes[o+2][p].setBackground(UIManager.getColor("control"));
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
    
    public void mouseReleased(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) { // Verficia se o usuario aperto o botao direito do mouse
            if(gira<1){ //Quando o usuario aperta ele muda o modo de exbicao entre horizontal (0) e horizontal (1)
                gira = gira+1;

            }
            else{
                gira = 0;
                
            }
            for (int j = 0; j<10;j++){ //Isso so limpa a cor do ngc
                for (int i = 0; i<10;i++){
                        botoes[j][i].setBackground(UIManager.getColor("control"));
                        
                }
            }
        }
    }
}