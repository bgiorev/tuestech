package UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.junit.Before;
import org.junit.Test;
import Diary.*;
public class DietDiarySwtTests {
	private ArrayList<Label> lables=new ArrayList<Label>(2000);
	private ArrayList<Label> lables2=new ArrayList<Label>(2000);
	private ArrayList<Button> buttons=new ArrayList<Button>(2000);
	private MainDietDiary MainDietDiary=new MainDietDiary();
	private MainDietDiary MainDietDiary2=new MainDietDiary();
	private MainDietDiary MainDietDiary3=new MainDietDiary();
	
	@Before
	public void setUp() throws ClassNotFoundException{
		MainDietDiary.open(false,false,false);
		MainDietDiary2.open(false, true,false);
		MainDietDiary3.open(false, false,true);
		MainDietDiary.setDatas("180","93","17","Vaso","мъж","Сваля","7");
		lables=MainDietDiary.getLables();
		lables2=MainDietDiary2.getLables();
		buttons=MainDietDiary3.getButtons();
	}
	@Test
	public void testLables() {		
		//create contents
		assertEquals("Продукт",lables.get(0).getText());
		assertEquals("Net- grams",lables.get(1).getText());
		assertEquals("Total",lables.get(2).getText());
		assertEquals("New Label",lables.get(3).getText());
		assertEquals("Ръст см.",lables.get(4).getText());
		assertEquals("Тегло кг.",lables.get(5).getText());
		assertEquals("Години",lables.get(6).getText());
		assertEquals("Име",lables.get(7).getText());
		assertEquals("Искам да :",lables.get(8).getText());
		assertEquals("теглото си",lables.get(9).getText());
		assertEquals("Пол",lables.get(10).getText());
		assertEquals("Колко пъти стренирате седмично?",lables.get(11).getText());
		
		
		

		
	
		
	}
	
	@Test
	public void testButtons(){
		assertEquals("New Diary",buttons.get(0).getText());
		assertEquals("Diaries",buttons.get(1).getText());
	}
}
