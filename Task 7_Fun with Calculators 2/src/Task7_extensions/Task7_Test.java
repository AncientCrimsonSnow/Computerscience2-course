package Task7_extensions;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

import Calculator.Calculator;
import numeric_systems.BinF;
import numeric_systems.BinFSystem;
import numeric_systems.HexaF;
import numeric_systems.HexaFSystem;
import numeric_systems.OktaF;
import numeric_systems.OktaFSystem;

class Task7_Test {

	Calculator Test;
	ActionEvent event;
	
	@Test
	void testActionPerformed() {
		Test = new Calculator(4);
		//Button
		
		//Numbers from 1-9
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "2");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "3");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "4");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "5");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "6");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "7");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "8");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "9");
			Test.gui.actionPerformed(event);
			
		//Now all of them should be in the engine.input field.
		assertEquals(123456789, Double.valueOf(Test.engine.getinput()));
		
		//Now if we press "=" they should be in DisplayCalue before its pressed Display is empty
		assertEquals("", Test.engine.getDisplayValue());
		event = new ActionEvent(Test.gui, 0, "=");
		Test.gui.actionPerformed(event);
		assertEquals(123456789, Double.valueOf(Test.engine.getDisplayValue()));
		//Now we clear it
		event = new ActionEvent(Test.gui, 0, "Clear");
		Test.gui.actionPerformed(event);
		assertEquals("", Test.engine.getDisplayValue());
		
		//for 4 15 Test cases:
		Test = MULToverADD(Test, '1', '+', '2', 'x', '3', '+', '4');
		assertEquals("11.0",Test.engine.result);
		Test = MULToverADD(Test, '2', '+', '1', 'x', '4', '+', '3');
		assertEquals("9.0",Test.engine.result);
		Test = MULToverADD(Test, '1', '+', '2', 'x', '3', '+', '4');
		assertEquals("11.0",Test.engine.result);
		Test = MULToverADD(Test, '2', '+', '5', 'x', '5', '+', '2');
		assertEquals("29.0",Test.engine.result);
		Test = MULToverADD(Test, '1', 'x', '2', '+', '3', 'x', '4');
		assertEquals("14.0",Test.engine.result);
		Test = MULToverADD(Test, '2', 'x', '1', '+', '4', 'x', '3');
		assertEquals("14.0",Test.engine.result);
		Test = MULToverADD(Test, '2', 'x', '5', '+', '5', 'x', '2');
		assertEquals("20.0",Test.engine.result);
		Test = MULToverADD(Test, '1', 'x', '2', 'x', '3', '+', '5');
		assertEquals("11.0",Test.engine.result);
		Test = MULToverADD(Test, '2', 'x', '1', 'x', '4', '+', '1');
		assertEquals("9.0",Test.engine.result);
		Test = MULToverADD(Test, '2', 'x', '5', 'x', '5', '+', '2');
		assertEquals("52.0",Test.engine.result);
		Test = MULToverADD(Test, '1', '+', '2', 'x', '3', 'x', '4');
		assertEquals("25.0",Test.engine.result);
		Test = MULToverADD(Test, '2', '+', '1', 'x', '4', 'x', '3');
		assertEquals("14.0",Test.engine.result);
		Test = MULToverADD(Test, '2', '+', '5', 'x', '5', 'x', '2');
		assertEquals("52.0",Test.engine.result);
		Test = MULToverADD(Test, '1', '+', '2', 'x', '1', '0', '0');
		assertEquals("201.0",Test.engine.result);
		Test = MULToverADD(Test, '4', '+', '3', 'x', '2', '/', '6');
		assertEquals("5.0",Test.engine.result);
		
		event = new ActionEvent(Test.gui, 0, "Clear");
		Test.gui.actionPerformed(event);
		
		//lets now make a really complicated calculation like: -4.2*-1*(5.35+6.789) = 50.9838.
		//Picture
		Test = DECComplicatedCalc(Test);
		assertEquals(Test.engine.result, "50.9838");
		
		//now lets see if we can work with this result: i want -10 so we need -60.9838.
		Test = DEC_negativ(Test);
		//u know Java stupid round things -9.999999999999993 PICTURE
		double result = Math.round(Double.valueOf(Test.engine.result)*1000000000)/1000000000;
		assertEquals(-10, result);
		
		//Lets do some simple HEXF BINF and OKTF calculations
		event = new ActionEvent(Test.gui, 0, "Clear");
		Test.gui.actionPerformed(event);
		
		//HEX -A.A*-1*(B.CD+E.FAB) = 11C.89AE
		//First lets simulate a BOX selection
		Test.gui.Boxes[1].setSelected(true);
		event = new ActionEvent(Test.gui, 0, "HEX");
		Test.gui.actionPerformed(event);
		assertEquals(16, Test.gui.Base);
		//now the Calculation
		Test = HEXComplicatedCalc(Test);
		HexaF number_HEX = HexaFSystem.DECtoHEXF(Double.valueOf(Test.engine.result));
		assertEquals("11C.89AE", number_HEX.toString());
		
		event = new ActionEvent(Test.gui, 0, "Clear");
		Test.gui.actionPerformed(event);
		
		//At least lets Test BIN cos we cant really Test OKT
		//-4.5*-1*(5.75+6.25) = 54
		//-100.1*-1*(101.11+110.01) = 110110.0
		Test.gui.Boxes[2].setSelected(true);
		event = new ActionEvent(Test.gui, 0, "BIN");
		Test.gui.actionPerformed(event);
		assertEquals(2, Test.gui.Base);
		//now the Calculation
		Test = BINComplicatedCalc(Test);
		BinF number_BIN = BinFSystem.DECtoBINF(Double.valueOf(Test.engine.result));
		System.out.println(number_BIN);
		assertEquals("110110.0", number_BIN.toString());
		
		event = new ActionEvent(Test.gui, 0, "Clear");
		Test.gui.actionPerformed(event);
		
		//For Assignment 6 and with Okta:
		//1.5*2^2 = 6
		Test.gui.Boxes[3].setSelected(true);
		event = new ActionEvent(Test.gui, 0, "OKT");
		Test.gui.actionPerformed(event);
		assertEquals(8, Test.gui.Base);
		//now the Calculation
		Test = OKTComplicatedCalc(Test);
		OktaF number_OKT = OktaFSystem.DECtoOKTF(Double.valueOf(Test.engine.result));
		System.out.println(number_OKT);
		assertEquals("6.4", number_OKT.toString());
		
	}
	private Calculator MULToverADD(Calculator Test,char num1, char op1, char num2, char op2, char num3, char op3, char num4){
	event = new ActionEvent(Test.gui, 0, "Clear");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0,""+num1);
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, ""+op1);
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0,""+num2);
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0,""+op2);
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0,""+num3);
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0,""+op3);
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0,""+num4);
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "=");
		Test.gui.actionPerformed(event);
		return Test;
	}
	private Calculator OKTComplicatedCalc(Calculator Test) {
		
	event = new ActionEvent(Test.gui, 0, "1");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, ".");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "5");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "x");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "2");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "^");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "2");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "=");
		Test.gui.actionPerformed(event);
		return Test;
	}
	private Calculator DECComplicatedCalc(Calculator Test) {
		event = new ActionEvent(Test.gui, 0, "-");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "4");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "2");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "x");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "-");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "x");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "(");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "5");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "3");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "5");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "+");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "6");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "7");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "8");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "9");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ")");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "=");
			Test.gui.actionPerformed(event);		
		return Test;
	}
	private Calculator DEC_negativ(Calculator Test) {
	event = new ActionEvent(Test.gui, 0, "-");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "6");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "0");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, ".");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "9");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "8");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "3");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "8");
		Test.gui.actionPerformed(event);
	event = new ActionEvent(Test.gui, 0, "=");
		Test.gui.actionPerformed(event);
		return Test;
	}
	private Calculator HEXComplicatedCalc(Calculator Test) {
		event = new ActionEvent(Test.gui, 0, "-");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "A");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "A");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "x");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "-");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "x");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "(");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "B");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "C");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "D");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "+");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "E");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "F");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "A");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "B");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ")");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "=");
			Test.gui.actionPerformed(event);		
		return Test;
	}
	private Calculator BINComplicatedCalc(Calculator Test) {
		event = new ActionEvent(Test.gui, 0, "-");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "0");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "0");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "x");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "-");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "x");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "(");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "0");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "+");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "0");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ".");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "0");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "1");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, ")");
			Test.gui.actionPerformed(event);
		event = new ActionEvent(Test.gui, 0, "=");
			Test.gui.actionPerformed(event);		
		return Test;
	}
}
