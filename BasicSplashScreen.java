package RPGGame;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import java.awt.event.ActionListener;
	
public class BasicSplashScreen extends JWindow {
	/**
	 * this code adopted from example code here:
	 * http://www.java2s.com/Tutorials/Java/Swing_How_to/JWindow/Create_Swing_Splash_screen_with_progress_bar.htm
	 */
	private static final long serialVersionUID = 1L;

	
	//splashscreen items
	private JProgressBar progressBar = new JProgressBar();
    private int count = 1;
    private int TIMER_PAUSE = 25;
    private int PROGBAR_MAX=100;
    private Timer progressBarTimer;
    public ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            progressBar.setValue(count);
            if (PROGBAR_MAX == count) {
                //splashScreen1.dispose();//dispose of splashscreen1
                progressBarTimer.stop();//stop the timer
                
                //createAndShowFrame();
            	Game game = new Game();
            	killMe();
            }
            count++;//increase counter
        }
    }; 
		
	public BasicSplashScreen(){
		createSplash();
		
	}
	private void createSplash() {
        Container container = getContentPane();

        JPanel panel = new JPanel();
        container.add(panel, BorderLayout.CENTER);
        
        JLabel lblSplash = new JLabel();
        lblSplash.setIcon(new ImageIcon(GUI.class.getResource("/img/splash.png")));
		panel.add(lblSplash);

        progressBar.setMaximum(PROGBAR_MAX);
        container.add(progressBar, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        progressBarTimer = new Timer(TIMER_PAUSE, al);
        progressBarTimer.start();
    }


    private void killMe(){
    	this.dispose();
    }
  
}
