package org.harshil.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameFrame() {
    Board board=new Board();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setTitle("Game Dev in Java");
    setSize(1600,900); 
    setResizable(false);
    setLocationRelativeTo(null);
    add(board);
    setVisible(true);
    }
	public static void main(String[] args){
		new GameFrame();
	}

}
