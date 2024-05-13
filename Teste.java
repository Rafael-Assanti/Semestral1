import javax.swing.*;

public class Teste {
        public static void main(String[] args) {
            
            SwingUtilities.invokeLater(new Runnable(){
                public void run() {
                    Tela tela = new Tela();
                }
            });
        }
    }
