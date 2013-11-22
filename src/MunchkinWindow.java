import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class MunchkinWindow {
	private final LevelCounter counter;
	
	private final JButton levelUp = new JButton("+");
	private final JButton levelDown = new JButton("-");
	private final JButton gearUp = new JButton("+");
	private final JButton gearDown = new JButton("-");
	private final JButton bonusUp = new JButton("+");
	private final JButton bonusDown = new JButton("-");
	
	private JLabel levelLabel;
	private JLabel gearLabel;
	private JLabel bonusLabel;
	
	public MunchkinWindow(final LevelCounter counter) {
		this.counter = counter;
		
		JFrame mainWindow = new JFrame("Munchkin Level Counter");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setBackground(Color.WHITE);
		
		JPanel levelControls = new JPanel();
		levelControls.setBorder(BorderFactory.createTitledBorder("Level"));
		levelControls.setLayout(new BoxLayout(levelControls, BoxLayout.X_AXIS));
		levelControls.add(levelUp);
		levelControls.add(levelDown);
		
		JPanel gearControls = new JPanel();
		gearControls.setBorder(BorderFactory.createTitledBorder("Gear"));
		gearControls.setLayout(new BoxLayout(gearControls, BoxLayout.X_AXIS));
		gearControls.add(gearUp);
		gearControls.add(gearDown);
		
		JPanel bonusControls = new JPanel();
		bonusControls.setBorder(BorderFactory.createTitledBorder("Bonus"));
		bonusControls.setLayout(new BoxLayout(bonusControls, BoxLayout.X_AXIS));
		bonusControls.add(bonusUp);
		bonusControls.add(bonusDown);
		
		JPanel controls = new JPanel();
		controls.add(levelControls);
		controls.add(gearControls);
		controls.add(bonusControls);
		
		JPanel state = new JPanel();
	    levelLabel = new JLabel("Level: " + counter.getLevel());
	    levelLabel.setFont(new Font("Verdana",1,20));
	    
	    
	    gearLabel = new JLabel("Gear: " + counter.getGear());
	    gearLabel.setFont(new Font("Verdana",1,20));
	    
	    bonusLabel = new JLabel("Bonus: " + counter.getBonus());
	    bonusLabel.setFont(new Font("Verdana",1,20));
	    
	    state.add(levelLabel);
	    state.add(gearLabel);
	    state.add(bonusLabel);
	    state.setBorder(new LineBorder(Color.BLACK));
		// add action listeners
	    
	    
	    // TODO need to be able to dynamically change the value displayed
		levelUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                counter.incLevel();
                levelLabel.setText("Level: " + counter.getLevel());
			}
		});
		
		levelDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                counter.decLevel();
                levelLabel.setText("Level: " + counter.getLevel());
			}
		});
	    
		gearUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                counter.incGear();
                gearLabel.setText("Gear: " + counter.getGear());
			}
		});
		
		gearDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                counter.decGear();
                gearLabel.setText("Gear: " + counter.getGear());
			}
		});
		
		bonusUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                counter.incBonus();
                bonusLabel.setText("Bonus: " + counter.getBonus());
			}
		});
		
		bonusDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
                counter.decBonus();
                bonusLabel.setText("Bonus: " + counter.getBonus());
			}
		});
		
		// finalize the main window
		mainWindow.add(controls, BorderLayout.NORTH);
		mainWindow.add(state, BorderLayout.CENTER);
		mainWindow.getContentPane().setPreferredSize(new Dimension(800, 800));
		mainWindow.pack();
        mainWindow.setVisible(true);

	}	
}
