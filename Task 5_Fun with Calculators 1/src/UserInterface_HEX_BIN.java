import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class UserInterface_HEX_BIN extends UserInterface_HEX {

	protected ButtonGroup BINButtons = new ButtonGroup();
	
	JTextField BINdisplay;
	
	public UserInterface_HEX_BIN(CalcEngine engine, int Amount_Checkboxes) {
		super(engine, Amount_Checkboxes);
		addLayout_BIN();
	}
	private void addLayout_BIN() {
		
		Boxes[2] = new JCheckBox("BIN");
		
		Boxes[2].addActionListener(this);
		
		BINdisplay = new JTextField("0");
		
		CheckBoxGrp.add(Boxes[2]);
		
        addCheckbox(Checkboxes, Boxes[2]);
        Checkboxes.add(BINdisplay);
        
        frame.pack();
        
        assignButtonGrps_BIN();
        GreyButtons_BIN();
	}
	protected void assignButtonGrps_BIN() {
		
		assignButtonGrps_HEX();
		
		comp = buttonPanel.getComponents();
		
    	for(Component E : comp) {
    		if(E instanceof JButton)
    			if(isNumber(((JButton)E).getText()))
    				if(isBetween(Integer.parseInt(((JButton)E).getText()), 0, 1))
    	        		BINButtons.add((JButton)E);		
    	}
	}
	protected void GreyButtons_BIN() {
		
		GreyButtons_HEX();
		
		if(Boxes[2].isSelected()) {
    		Enumeration<AbstractButton> BIN = BINButtons.getElements();
        	while(BIN.hasMoreElements()) {
        		JButton Button = (JButton) BIN.nextElement();
        		Button.setEnabled(true);
        	}
    	}	
	}
    public void actionPerformed(ActionEvent event)
    {	
    	String command = event.getActionCommand();
    	boolean BaseChange = false;
    	
    	for(JCheckBox E : Boxes) {
    		if(E.getText().equals(command))
    			BaseChange = true;
    	} 	
    	if(BaseChange) {
    		setBase_BIN();
    		GreyButtons_BIN();
    	}	
    	else if(isNumber(command)) {
            	int number = Hexa.HEXToDEC(new Hexa(command));       	
                calc.numberPressed(number, Base);
        }
        else
        	ChooseCommand(command);
    	
        redisplay_BIN();
        updateTextfields_BIN();
        GreyButtons_BIN();
    }
	protected void updateTextfields_BIN() {
		updateTextfields_HEX();
		
		BINdisplay.setText("" + Bin.DECtoBIN(calc.getDisplayValue()));
	}
	protected void redisplay_BIN() {
		redisplay_HEX();
		if(Boxes[2].isSelected()) {
    		display.setText("" + Bin.DECtoBIN(calc.getDisplayValue()));
    	}
	}
    protected void setBase_BIN() {
    	setBase_HEX();
    	
    	if(Boxes[2].isSelected()) {
    		System.out.println("BIN");
    		Base = 2;
    	}

    	redisplay_BIN();
    }
}
