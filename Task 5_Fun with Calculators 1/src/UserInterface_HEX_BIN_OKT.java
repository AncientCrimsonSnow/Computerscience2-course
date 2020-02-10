import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class UserInterface_HEX_BIN_OKT extends UserInterface_HEX_BIN {
	
	protected ButtonGroup OKTButtons = new ButtonGroup();
	
	JTextField OKTdisplay;
	
	public UserInterface_HEX_BIN_OKT(CalcEngine engine, int Amount_Checkboxes) {
		super(engine, Amount_Checkboxes);
		addLayout_OKT();
	}
	private void addLayout_OKT() {
		
		Boxes[3] = new JCheckBox("OKT");
		
		Boxes[3].addActionListener(this);
		
		OKTdisplay = new JTextField("0");
		
		CheckBoxGrp.add(Boxes[3]);
		
        addCheckbox(Checkboxes, Boxes[3]);
        Checkboxes.add(OKTdisplay);
        
        frame.pack();
        
        assignButtonGrps_OKT();
        GreyButtons_OKT();
	}
	protected void assignButtonGrps_OKT() {
		
		assignButtonGrps_BIN();
		
		comp = buttonPanel.getComponents();
		
    	for(Component E : comp) {
    		if(E instanceof JButton)
    			if(isNumber(((JButton)E).getText()))
    				if(isBetween(Integer.parseInt(((JButton)E).getText()), 0, 7))
    	        		OKTButtons.add((JButton)E);		
    	}
	}
	protected void GreyButtons_OKT() {
		
		GreyButtons_BIN();
		
		if(Boxes[3].isSelected()) {
    		Enumeration<AbstractButton> OKT = OKTButtons.getElements();
        	while(OKT.hasMoreElements()) {
        		JButton Button = (JButton) OKT.nextElement();
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
    		setBase_OKT();
    		GreyButtons_OKT();
    	}	
    	else if(isNumber(command)) {
            	int number = Hexa.HEXToDEC(new Hexa(command));       	
                calc.numberPressed(number, Base);
        }
        else
        	ChooseCommand(command);
    	
        redisplay_OKT();
        updateTextfields_OKT();
        GreyButtons_OKT();
    }
	private void setBase_OKT() {
		setBase_BIN();
		
    	if(Boxes[3].isSelected()) {
    		System.out.println("OKT");
    		Base = 8;	
    	}
    	redisplay_OKT();
	}
	private void updateTextfields_OKT() {
		updateTextfields_BIN();
		
		OKTdisplay.setText("" + Okta.DECtoOKT(calc.getDisplayValue()));
	}
	private void redisplay_OKT() {
		redisplay_BIN();
		if(Boxes[3].isSelected()) {
    		display.setText("" + Okta.DECtoOKT(calc.getDisplayValue()));
    	}
	}
}

