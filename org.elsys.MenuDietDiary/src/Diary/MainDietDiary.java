package Diary;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PiePlot;

public class MainDietDiary {
	protected Shell shlDietdiary;
	protected Shell regDietDiary;
	protected Shell startDietDiary;
	protected Shell loadDietdiary;
	private Table table;
	private ArrayList<Button> buttons = new ArrayList<Button>();
	private ArrayList<Label> lab = new ArrayList<Label>(2000);
	private Text text_1;
	private ArrayList<String> names = new ArrayList<String>();
	private Table table_1;
	private DefaultPieDataset dataset;
	private JFreeChart piechart;
	private ChartComposite chartcomposite;
	private ArrayList<String> datas = new ArrayList<String>();
	private Text text_6;
	private Diary diary = new Diary();
	private double loadedCalories = 0;
	private double loadedProtein = 0;
	private double loadedCarbs = 0;
	private double loadedFat = 0;

	// Array<Double> arr=new Array<Double>();

	// private HashMap<String,Product> map= new HashMap<String,Product>();
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainDietDiary window = new MainDietDiary();
			window.open(true, false, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Label> getLables() {

		return lab;
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}

	public void setDatas(String height, String weight, String age, String name,
			String gender, String perpose, String times) {
		datas.clear();
		datas.add(height);
		datas.add(weight);
		datas.add(age);
		datas.add(name);
		datas.add(gender);
		datas.add(perpose);
		datas.add(times);

	}

	/**
	 * Open the window.
	 */

	public void open(boolean test,boolean test2,boolean test3) {
		Display display = Display.getDefault();
		// mapTheData();

		createContents(test,test2,test3);
		shlDietdiary.open();
		shlDietdiary.layout();
		if(test==true)
		while (!shlDietdiary.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public boolean firstTime() {
		return true;
	}

	boolean checkInput(String name, int height, int weight, int age,
			String gender, int physicalActivity, String purpose) {
		if (name.matches("^[a-zA-Z]+$") && height <= 250 && age <= 100
				&& weight <= 150 && physicalActivity <= 10)
			return true;

		return false;
	}

	protected void register(Shell parentShell,boolean test) {
		Display display = Display.getDefault();

		regDietDiary = new Shell(parentShell, SWT.TITLE | SWT.CLOSE
				| SWT.BORDER);// shell
		regDietDiary.setSize(529, 317);
		regDietDiary.setText("DietDiary");

		TabFolder tabFolder = new TabFolder(regDietDiary, SWT.NONE);
		tabFolder.setBounds(0, 0, 523, 575);

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Registration");

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite_1);

		final Text text_2 = new Text(composite_1, SWT.BORDER);
		text_2.setBounds(249, 116, 76, 21);

		final Text text_3 = new Text(composite_1, SWT.BORDER);
		text_3.setBounds(249, 143, 76, 21);

		final Text text_4 = new Text(composite_1, SWT.BORDER);
		text_4.setBounds(249, 170, 76, 21);

		Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setBounds(188, 119, 59, 21);
		label_5.setText("Height(sm)");

		Label label_6 = new Label(composite_1, SWT.NONE);
		label_6.setBounds(188, 146, 59, 18);
		label_6.setText("Weight(kg)");

		Label label_7 = new Label(composite_1, SWT.NONE);
		label_7.setBounds(188, 173, 55, 18);
		label_7.setText("Age");

		Label label_8 = new Label(composite_1, SWT.NONE);
		label_8.setBounds(10, 49, 33, 18);
		label_8.setText("Name");

		Label label_12 = new Label(composite_1, SWT.NONE);
		label_12.setBounds(30, 205, 215, 15);
		label_12.setText("How many times per week do you train?");

		final Text text_5 = new Text(composite_1, SWT.BORDER);
		text_5.setBounds(49, 46, 439, 21);

		final Button btnCheckButton = new Button(composite_1, SWT.CHECK);
		btnCheckButton.setEnabled(true);

		btnCheckButton.setBounds(424, 118, 93, 16);
		btnCheckButton.setText("Lose");

		Label label_9 = new Label(composite_1, SWT.NONE);
		label_9.setBounds(363, 119, 55, 15);
		label_9.setText("I want to :");
		final Button button_1 = new Button(composite_1, SWT.CHECK);

		button_1.setEnabled(true);
		button_1.setBounds(424, 145, 93, 16);
		button_1.setText("Gain");

		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setBounds(424, 196, 75, 15);
		label_10.setText("weight");

		Button btnCalculate = new Button(composite_1, SWT.NONE);

		btnCalculate.setBounds(413, 231, 75, 25);
		btnCalculate.setText("Submit");

		Label label_11 = new Label(composite_1, SWT.NONE);
		label_11.setBounds(10, 119, 55, 15);
		label_11.setText("Gender");

		final Button button_2 = new Button(composite_1, SWT.RADIO);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_2.setBounds(10, 145, 90, 16);
		button_2.setText("male");

		final Button button_3 = new Button(composite_1, SWT.RADIO);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_3.setBounds(10, 172, 90, 16);
		button_3.setText("female");

		final Button button_4 = new Button(composite_1, SWT.CHECK);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button_1.setSelection(false);
				btnCheckButton.setSelection(false);

			}

		});

		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnCheckButton.setSelection(false);
				button_4.setSelection(false);
			}
		});
		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button_1.setSelection(false);
				button_4.setSelection(false);
			}
		});

		button_4.setBounds(424, 172, 93, 16);
		button_4.setText("Keep");

		text_6 = new Text(composite_1, SWT.BORDER);
		text_6.setBounds(249, 202, 76, 21);

		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println(text_2.getText());
				System.out.println(text_3.getText());
				System.out.println(text_4.getText());
				System.out.println(text_5.getText());
				datas.add(text_2.getText());
				datas.add(text_3.getText());
				datas.add(text_4.getText());
				datas.add(text_5.getText());
				if (button_2.getSelection()) {
					datas.add("мъж");
				}
				if (button_3.getSelection()) {
					datas.add("жена");
				}

				if (btnCheckButton.getSelection()) {
					datas.add("Сваля");
				}
				if (button_1.getSelection()) {
					datas.add("Кача");
				}
				if (button_4.getSelection()) {
					datas.add("Задържа");
				}
				if (!btnCheckButton.getSelection() && !button_1.getSelection()
						&& !button_4.getSelection())
					datas.add("0");

				datas.add(text_6.getText());
				int height = 0;
				int weight = 0;
				int age = 0;
				String gender = "";
				String name = "";
				int physicalActivity = 0;
				String purpose = "";
				if (datas.size() == 7) {

					name = datas.get(3);
					height = Integer.valueOf(datas.get(0));
					weight = Integer.valueOf(datas.get(1));
					age = Integer.valueOf(datas.get(2));
					gender = datas.get(4);
					physicalActivity = Integer.valueOf(datas.get(6));
					purpose = datas.get(5);
				}

				if (checkInput(name, height, weight, age, gender,
						physicalActivity, purpose)) {
					BodyCalculator bc = new BodyCalculator(name, height,
							weight, age, gender, physicalActivity, purpose);
					try {
						diary.saveCalculator(bc);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						System.out
								.println("At saving body calculaotr register()");
					}
					regDietDiary.dispose();
				} else {
					MessageBox registrationError = new MessageBox(regDietDiary,
							SWT.ICON_WARNING);
					registrationError.setMessage("Please fill correct data");
					int rc = registrationError.open();
					datas.removeAll(datas);
				}

			}
		});
		lab.add(label_5);
		lab.add(label_6);
		lab.add(label_7);
		lab.add(label_8);
		lab.add(label_12);
		lab.add(label_9);
		lab.add(label_10);
		lab.add(label_11);
		regDietDiary.open();
		regDietDiary.layout();
		if(test==true)
		while (!regDietDiary.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		regDietDiary.dispose();

	}

	protected void StartMenu(final boolean test) {
		Display display = Display.getDefault();
		startDietDiary = new Shell(SWT.TITLE | SWT.CLOSE | SWT.BORDER);// shell
		startDietDiary.setSize(117, 190);
		startDietDiary.setText("DietDiary");

		TabFolder tabFolder = new TabFolder(startDietDiary, SWT.NONE);
		tabFolder.setBounds(0, 0, 126, 167);

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Start");

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite_1);

		Button btnNewDiary = new Button(composite_1, SWT.NONE);
		btnNewDiary.setBounds(22, 20, 75, 25);
		btnNewDiary.setText("New Diary");

		Button btnLoadDiary = new Button(composite_1, SWT.NONE);
		btnLoadDiary.setBounds(22, 51, 75, 25);
		btnLoadDiary.setText("Diaries");

		btnNewDiary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				register(startDietDiary,test);

			}
		});
		btnLoadDiary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				loaddata(startDietDiary);

			}
		});

		startDietDiary.addListener(SWT.Close, new Listener() {

			@Override
			public void handleEvent(Event event) {
				MessageBox messageBox = new MessageBox(startDietDiary,
						SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
				messageBox.setText("Exit");
				messageBox.setMessage("Close the diary?");
				// event.doit = messageBox.open() == SWT.YES;
				int choice = messageBox.open();
				switch (choice) {
				case SWT.YES:
					System.exit(0);
					break;

				case SWT.NO:

					break;

				}

			}

		});
		buttons.add(btnNewDiary);
		buttons.add(btnLoadDiary);
		startDietDiary.open();
		startDietDiary.layout();
		if(test==true)
		while (!startDietDiary.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}

		}

	}

	protected void loaddata(final Shell parentShell) {

		Display display = Display.getDefault();
		loadDietdiary = new Shell(parentShell, SWT.TITLE | SWT.CLOSE
				| SWT.BORDER);// shell
		loadDietdiary.setSize(258, 262);
		loadDietdiary.setText("DietDiary");

		TabFolder tabFolder = new TabFolder(loadDietdiary, SWT.NONE);
		tabFolder.setBounds(0, 0, 252, 234);

		TabItem tbtmLoadDiary = new TabItem(tabFolder, SWT.NONE);
		tbtmLoadDiary.setText("Load Diary");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmLoadDiary.setControl(composite);

		final Table table_2 = new Table(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table_2.setBounds(10, 10, 224, 186);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		Menu menu = new Menu(loadDietdiary, SWT.POP_UP);
		table_2.setMenu(menu);
		TableColumn tblclmnDnevnika = new TableColumn(table_2, SWT.NONE);
		tblclmnDnevnika.setWidth(220);
		tblclmnDnevnika.setText("Name of the diary");

		table_2.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Menu menu = new Menu(loadDietdiary, SWT.POP_UP);
				table_2.setMenu(menu);
				final MenuItem item2 = new MenuItem(menu, SWT.NONE);
				MenuItem item = new MenuItem(menu, SWT.PUSH);
				// System.out.println(table.getSelectionIndex());
				item2.setText("Load");
				item.setText("Delete Selection");

				item.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						TableItem item3 = table_2.getItem(table_2
								.getSelectionIndex());
						try {
							diary.deleteCalculator(item3.getText());
							table_2.remove(table_2.getSelectionIndex());

						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				});

				item2.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						TableItem item3 = table_2.getItem(table_2
								.getSelectionIndex());
						try {
							BodyCalculator calc = diary.loadCalculator(item3
									.getText());
							datas.add("" + calc.getHeight());
							datas.add("" + calc.getWeight());
							datas.add("" + calc.getAge());
							datas.add(calc.getName());
							datas.add(calc.getGender());
							datas.add(calc.getDietPerpose());
							datas.add("" + calc.getPhysicalActivity());
							loadDietdiary.dispose();
							parentShell.dispose(); // to close the start menu
													// window;
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				});

			}
		});

		int h = 0;
		try {
			for (String s : diary.getAllUsers()) {
				TableItem tabItem = new TableItem(table_2, SWT.NONE);
				System.out.println(s);
				tabItem.setText(h++, s);
				h = 0;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// double click listener
		table_2.addListener(SWT.MouseDoubleClick, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				TableItem item3 = table_2.getItem(table_2.getSelectionIndex());
				try {
					BodyCalculator calc = diary.loadCalculator(item3.getText());
					datas.add("" + calc.getHeight());
					datas.add("" + calc.getWeight());
					datas.add("" + calc.getAge());
					datas.add(calc.getName());
					datas.add(calc.getGender());
					datas.add(calc.getDietPerpose());
					datas.add("" + calc.getPhysicalActivity());

					loadDietdiary.dispose();
					parentShell.dispose(); // to close the start menu window;

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		loadDietdiary.open();
		loadDietdiary.layout();

		/*
		 * while (!loadDietdiary.isDisposed()) { if (!display.readAndDispatch())
		 * display.sleep();
		 * 
		 * }
		 */
	}

	// Shitnite v Prozoreca

	private void setTotalTable(ArrayList<Meal> dailymeals, Table table_1) {
		double calories = 0;
		double fat = 0;
		double carbs = 0;
		double protein = 0;
		for (Meal meal : dailymeals) {
			calories += meal.getCalories();
			fat += meal.getFat();
			protein += meal.getProtein();
			carbs += meal.getCarbs();
		}
		table_1.removeAll();
		table_1.clearAll();
		int m = 0;
		TableItem tableItem = new TableItem(table_1, SWT.NONE);
		tableItem.setText(m++, String.valueOf(convertDouble(calories)));
		tableItem.setText(m++, String.valueOf(convertDouble(fat)));
		tableItem.setText(m++, String.valueOf(convertDouble(protein)));
		tableItem.setText(m++, String.valueOf(convertDouble(carbs)));

		// setChart function
		setChart(tableItem);
	}

	// often set in setTotalTable()
	private void setChart(TableItem tableItem) {
		dataset.setValue("Carbs", new Double(tableItem.getText(3)));
		dataset.setValue("Prot", new Double(tableItem.getText(2)));
		dataset.setValue("Fat", new Double(tableItem.getText(1)));
		int m = 0;
		if (Double.valueOf((tableItem.getText(m++))) == 0.0
				&& Double.valueOf((tableItem.getText(m++))) == 0.0
				&& Double.valueOf((tableItem.getText(m++))) == 0.0
				&& Double.valueOf((tableItem.getText(m++))) == 0.0) {
			chartcomposite.setVisible(false);
		}
	}

	private double convertDouble(double d) { // Converting double to some format
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("#.##", symbols);
		return Double.valueOf(df.format(d));
	}

	protected void createContents(boolean test,boolean test2,boolean test3) {

		// final Diary diary = new Diary();
		if(datas.isEmpty()){
			for(int i=0;i<=6;i++)
				datas.add(""+ i);
		}
		final ArrayList<Meal> dailymeals = new ArrayList<Meal>();
		shlDietdiary = new Shell(SWT.TITLE | SWT.CLOSE | SWT.BORDER);// shell
		shlDietdiary.setSize(529, 613);
		shlDietdiary.setText("DietDiary");

		TabFolder tabFolder = new TabFolder(shlDietdiary, SWT.NONE);
		tabFolder.setBounds(0, 0, 524, 575);

		// Item (foldera)
		// Hranene : sudurga se vsichko svurzano s taba
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Хранене");

		TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("Диета");

		if(test==true){
			StartMenu(test);
		}
		if(test2==true){
			register(startDietDiary,test);
		}
		if(test3==true){
			StartMenu(test);
		}

		// suzdavane na obekt vuv foldera
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
		// label vuv foldera
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBounds(10, 23, 56, 18);
		label_1.setText("Продукт");
		// button vuv foldera
		Button btnGetRates = new Button(composite, SWT.NONE);
		btnGetRates.setBounds(10, 74, 68, 23);
		btnGetRates.setText("Get Rates");
		// Combo cc prozorec moge da go smenq sus suggestion
		final Text combo = new Text(composite, SWT.BORDER);
		combo.setBounds(10, 47, 240, 21);

		try {
			new AutoCompleteField(combo, new TextContentAdapter(),
					diary.getAllProducts());
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			System.out.println("problem at autocomplete");
		}

		// label za kolichestvo vuv foldera
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBounds(422, 23, 74, 19);
		label_2.setText("Net- grams");

		// text za gramag
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(431, 47, 45, 21);
		text_1.setText("1");

		// Tablicata s izbranite hrani ot auto complete-a
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 101, 499, 331);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(199);
		tableColumn_5.setText("Name");

		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(77);
		tableColumn_4.setText("Time");

		final TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(55);
		tableColumn_3.setText("Kcal");

		final TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(55);
		tableColumn.setText("Fat");

		final TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(55);
		tableColumn_1.setText("Protein");

		final TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(55);
		tableColumn_2.setText("Carbs");
		// deletvane na item ot table chrez menu
		Menu menu = new Menu(shlDietdiary, SWT.POP_UP);
		table.setMenu(menu);
		// item za ime na produkta i delete selectiona mu
		// final MenuItem item2 = new MenuItem(menu, SWT.NONE);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		// System.out.println(table.getSelectionIndex());
		item.setText("Delete Selection");
		// data
		final DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(211, 4, 110, 24);
		// ////////////////////////////////////END TABLE
		// ////////////////////////////////////END TABLE
		// ////////////////////////////////////END TABLE
		// ////////////////////////////////////END TABLE

		// /TABLE 2 v koito se pomestvat daily neshtata - izqdeni
		// /TABLE 2 v koito se pomestvat daily neshtata - izqdeni
		// /TABLE 2 v koito se pomestvat daily neshtata - izqdeni
		// /TABLE 2 v koito se pomestvat daily neshtata - izqdeni

		table_1 = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(10, 472, 499, 65);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		// final TableItem tableItem2 = new TableItem(table_1, SWT.NONE);
		TableColumn tblclmnKcal = new TableColumn(table_1, SWT.NONE);
		// Listener v koito se advat elementite na table_1

		table.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Menu menu = new Menu(shlDietdiary, SWT.POP_UP);
				table.setMenu(menu);

				MenuItem item = new MenuItem(menu, SWT.PUSH);
				// System.out.println(table.getSelectionIndex());
				// String h = names.get(table.getSelectionIndex());
				item.setText("Delete Selection");
				item.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
						Meal meal1 = dailymeals.get(table.getSelectionIndex());

						dailymeals.remove(table.getSelectionIndex());
						String day;
						String month;
						int monthh = dateTime.getMonth();
						monthh++;
						TableItem tableItem2 = new TableItem(table_1, SWT.NONE);
						if (dateTime.getDay() < 10) {
							day = "0" + dateTime.getDay();
						} else
							day = "" + dateTime.getDay();
						if (monthh < 10) {
							month = "0" + monthh;
						} else
							month = "" + monthh;
						String datee = day + "/" + month + "/"
								+ dateTime.getYear();
						try {
							diary.deleteMeal(meal1, datee);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						table.remove(table.getSelectionIndices());

						setTotalTable(dailymeals, table_1);

						/*
						 * double calories = 0; double fat = 0; double carbs =
						 * 0; double protein = 0; for (Meal meal : dailymeals) {
						 * calories += meal.getCalories(); fat += meal.getFat();
						 * protein += meal.getProtein(); carbs +=
						 * meal.getCarbs(); } System.out.println(fat +
						 * "in delete"); table_1.removeAll();
						 * table_1.clearAll(); int m = 0; TableItem tableItem7 =
						 * new TableItem(table_1, SWT.NONE);
						 * tableItem7.setText(m++, "asd");
						 * tableItem7.setText(m++, String.valueOf(fat));
						 * tableItem7.setText(m++, String.valueOf(protein));
						 * tableItem7.setText(m++, String.valueOf(carbs));
						 */
						/*
						 * dataset.setValue("Carbs", new
						 * Double(tableItem7.getText(3)));
						 * dataset.setValue("Prot", new
						 * Double(tableItem7.getText(2)));
						 * dataset.setValue("Fat", new
						 * Double(tableItem7.getText(1))); if (calories == 0.0
						 * && fat == 0.0 && protein == 0.0 && carbs == 0.0) {
						 * chartcomposite.setVisible(false); }
						 */

					}
				});

			}
		});
		tblclmnKcal.setWidth(126);
		tblclmnKcal.setText("Kcal");

		TableColumn tblclmnFat = new TableColumn(table_1, SWT.NONE);
		tblclmnFat.setWidth(126);
		tblclmnFat.setText("Fat");

		TableColumn tblclmnProtein = new TableColumn(table_1, SWT.NONE);
		tblclmnProtein.setWidth(126);
		tblclmnProtein.setText("Protein");

		TableColumn tblclmnCarbs = new TableColumn(table_1, SWT.NONE);
		tblclmnCarbs.setWidth(126);
		tblclmnCarbs.setText("Carbs");

		Label label = new Label(composite, SWT.NONE);
		label.setBounds(10, 451, 55, 15);
		label.setText("Total");

		Button button = new Button(tabFolder, SWT.RADIO);

		Label label_4 = new Label(tabFolder, SWT.NONE);
		label_4.setText("New Label");
		button.setText("Radio Button");

		dataset = new DefaultPieDataset();

		piechart = ChartFactory.createPieChart("Хранителни Вещества", dataset,
				false, true, false);
		PiePlot plot = (PiePlot) piechart.getPlot();
		plot.setCircular(false);

		// tabFolder.setSelection(tabItem_1);

		final Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tabItem_1.setControl(composite_1);

		Label label_5 = new Label(composite_1, SWT.NONE);
		label_5.setBounds(26, 48, 55, 21);
		label_5.setText("Ръст см.");

		Label label_6 = new Label(composite_1, SWT.NONE);
		label_6.setBounds(26, 75, 55, 18);
		label_6.setText("Тегло кг.");

		Label label_7 = new Label(composite_1, SWT.NONE);
		label_7.setBounds(26, 99, 55, 18);
		label_7.setText("Години");

		chartcomposite = new ChartComposite(composite_1, SWT.NONE);
		chartcomposite.setLocation(68, 260);
		chartcomposite.setLayout(new FillLayout(SWT.HORIZONTAL));

		chartcomposite.setSize(361, 255);

		chartcomposite.setChart(piechart);
		chartcomposite.setVisible(false);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		DateFormat df = new SimpleDateFormat("       HH:mm");
		java.util.Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);

		double calories = 0.0;
		double protein = 0.0;
		double carbs = 0.0;
		double fat = 0.0;
		try {
			ArrayList<Meal> todayMeals = diary.findEatenMealsByDate(todayDate);
			for (Meal meal : todayMeals) {
				int count = 0;
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(count++, meal.getName());
				tableItem.setText(count++, reportDate);
				tableItem.setText(count++, String.valueOf(meal.getCalories()));
				tableItem.setText(count++, String.valueOf(meal.getFat()));
				tableItem.setText(count++, String.valueOf(meal.getProtein()));
				tableItem.setText(count++, String.valueOf(meal.getCarbs()));

				calories += meal.getCalories();
				protein += meal.getProtein();
				carbs += meal.getCarbs();
				fat += meal.getFat();
			}
			loadedCalories = calories;
			loadedProtein = protein;
			loadedCarbs = carbs;
			loadedFat = fat;
			TableItem tableItem = new TableItem(table_1, SWT.NONE);
			tableItem.setText(0, String.valueOf(calories));
			tableItem.setText(1, String.valueOf(fat));
			tableItem.setText(2, String.valueOf(protein));
			tableItem.setText(3, String.valueOf(carbs));

			dataset.setValue("Carbs", new Double(tableItem.getText(3)));
			dataset.setValue("Prot", new Double(tableItem.getText(2)));
			dataset.setValue("Fat", new Double(tableItem.getText(1)));
			chartcomposite.setVisible(true);
			dailymeals.addAll(todayMeals); // eddited by alex
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		Label label_8 = new Label(composite_1, SWT.NONE);
		label_8.setBounds(26, 13, 47, 18);
		label_8.setText("\u0418\u043C\u0435");

		final Button btnCheckButton = new Button(composite_1, SWT.CHECK);

		btnCheckButton.setBounds(398, 47, 93, 16);
		btnCheckButton.setText("Сваля");

		Label label_9 = new Label(composite_1, SWT.NONE);
		label_9.setBounds(337, 48, 55, 15);
		label_9.setText("Искам да :");
		final Button button_1 = new Button(composite_1, SWT.CHECK);
		button_1.setBounds(398, 74, 93, 16);
		button_1.setText("Кача");

		Label label_10 = new Label(composite_1, SWT.NONE);
		label_10.setEnabled(false);
		label_10.setBounds(398, 120, 75, 15);
		label_10.setText("теглото си");

		Label label_11 = new Label(composite_1, SWT.NONE);
		label_11.setBounds(26, 138, 36, 15);
		label_11.setText("Пол");

		Button button_2 = new Button(composite_1, SWT.RADIO);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_2.setBounds(68, 137, 55, 16);
		button_2.setText("мъж");

		Button button_3 = new Button(composite_1, SWT.RADIO);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_3.setBounds(129, 137, 90, 16);
		button_3.setText("жена");

		final Button button_4 = new Button(composite_1, SWT.CHECK);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button_1.setSelection(false);
				btnCheckButton.setSelection(false);

			}
		});

		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnCheckButton.setSelection(false);
				button_4.setSelection(false);
			}
		});

		btnCheckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				button_1.setSelection(false);
				button_4.setSelection(false);
			}
		});
		button_4.setBounds(398, 98, 104, 16);
		button_4.setText("Задържа ");

		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setBounds(87, 13, 238, 15);

		lblNewLabel.setText(datas.get(3));

		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setBounds(87, 48, 55, 15);
		lblNewLabel_1.setText(datas.get(0));

		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setBounds(87, 75, 55, 15);
		lblNewLabel_2.setText(datas.get(1));

		Label lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setBounds(87, 99, 55, 15);
		lblNewLabel_3.setText(datas.get(2));

		Label label_3 = new Label(composite_1, SWT.NONE);
		label_3.setBounds(315, 229, 98, 15);
		label_3.setText("\u041A\u0430\u043B\u043E\u0440\u0438\u0435\u043D \u041B\u0438\u043C\u0438\u0442");

		Label label_12 = new Label(composite_1, SWT.NONE);
		label_12.setBounds(26, 172, 200, 15);
		label_12.setText("Колко пъти стренирате седмично?");

		text_6 = new Text(composite_1, SWT.BORDER);
		text_6.setEnabled(false);
		text_6.setBounds(232, 169, 76, 21);
		text_6.setText(datas.get(6));

		String dietPerpose = "Задържа";

		if (datas.get(4).equals("мъж")) {
			button_2.setSelection(true);
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		}
		if (datas.get(4).equals("жена")) {
			button_3.setSelection(true);
			button_2.setEnabled(false);
			button_3.setEnabled(false);
		}
		if (datas.get(5).equals("Сваля")) {
			dietPerpose = btnCheckButton.getText();
			btnCheckButton.setSelection(true);
			btnCheckButton.setEnabled(false);
			button_1.setEnabled(false);
			button_4.setEnabled(false);
		}
		if (datas.get(5).equals("Кача")) {
			dietPerpose = button_1.getText();
			button_1.setSelection(true);
			btnCheckButton.setEnabled(false);
			button_1.setEnabled(false);
			button_4.setEnabled(false);
		}
		if (datas.get(5).equals("Задържа")) {
			dietPerpose = button_4.getText();
			button_4.setSelection(true);
			btnCheckButton.setEnabled(false);
			button_1.setEnabled(false);
			button_4.setEnabled(false);
		}

		BodyCalculator calculator = new BodyCalculator(lblNewLabel.getText(),
				Integer.parseInt(lblNewLabel_1.getText()),
				Integer.parseInt(lblNewLabel_2.getText()),
				Integer.parseInt(lblNewLabel_3.getText()), datas.get(4),
				Integer.parseInt(text_6.getText()), dietPerpose);
		final Label lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setBounds(419, 229, 55, 15);
		lblNewLabel_4.setText("" + calculator.getCaloriesLimit());

		Button btnTrainDiary = new Button(composite_1, SWT.NONE);
		btnTrainDiary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Display display = Display.getDefault();
				Shell brShell = new Shell(SWT.TITLE | SWT.CLOSE | SWT.BORDER);// shell
				brShell.setSize(1370, 768);
				brShell.setText("Browser");

				TabFolder tabFolder = new TabFolder(brShell, SWT.NONE);
				TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
				tabItem.setText("Browser");

				DBrowser dbr = new DBrowser();
				dbr.Start(display, brShell);

			}
		});
		btnTrainDiary.setBounds(427, 512, 75, 25);
		btnTrainDiary.setText("Train Diary");
		try {
			diary.saveCalculator(calculator);
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		System.out.println(calculator.getCaloriesLimit());

		try {
			// browser.computeTrim(0,0,0,0);

		} catch (SWTError e) {
			System.out.println("problem init the borwser");
		}

		// getRatesListener

		btnGetRates.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				String text = combo.getText();
				Meal dummy = null;

				String day;
				String month;

				int monthh = dateTime.getMonth();
				monthh++;
				if (dateTime.getDay() < 10) {
					day = "0" + dateTime.getDay();
				} else
					day = "" + dateTime.getDay();
				if (monthh < 10) {
					month = "0" + monthh;
				} else
					month = "" + monthh;
				int i = Integer.parseInt(text_1.getText());
				try {
					dummy = diary.searchMeal(text, i, day + "/" + month + "/"
							+ dateTime.getYear());
					if (dummy != null) {

						table_1.removeAll();
						names.add(dummy.getName());
						TableItem tableItem = new TableItem(table, SWT.NONE);

						int h = 0;
						int m = 0;
						DateFormat df = new SimpleDateFormat("       HH:mm");
						java.util.Date today = Calendar.getInstance().getTime();
						String reportDate = df.format(today);

						double calories = 0;
						double fat = 0;
						double protein = 0;
						double carbs = 0;

						// tableItem.setText(h++, Integer.toString(++b));
						tableItem.setText(h++, dummy.getName());
						tableItem.setText(h++, reportDate);
						System.out.println(dummy.getCalories());
						tableItem.setText(h++,
								String.valueOf(dummy.getCalories()));
						tableItem.setText(h++, String.valueOf(dummy.getFat()));
						tableItem.setText(h++,
								String.valueOf(dummy.getProtein()));
						tableItem.setText(h++, String.valueOf(dummy.getCarbs()));

						// calculate total table and set chart
						dailymeals.add(dummy);
						setTotalTable(dailymeals, table_1);

						/*
						 * for (Meal meal : dailymeals) { calories +=
						 * meal.getCalories(); fat += meal.getFat(); protein +=
						 * meal.getProtein(); carbs +=meal.getCarbs(); }
						 * 
						 * TableItem tableItem1000 = new TableItem(table_1,
						 * SWT.NONE); tableItem1000.setText(m++,
						 * String.valueOf(calories)); tableItem1000.setText(m++,
						 * String.valueOf(fat)); tableItem1000.setText(m++,
						 * String.valueOf(protein)); tableItem1000.setText(m++,
						 * String.valueOf(carbs)); dataset.setValue("Carbs", new
						 * Double(tableItem1000.getText(3)));
						 * dataset.setValue("Prot", new
						 * Double(tableItem1000.getText(2)));
						 * dataset.setValue("Fat", new
						 * Double(tableItem1000.getText(1)));
						 * chartcomposite.setVisible(true);
						 */

					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		dateTime.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// den mesec godina
				table.removeAll();
				table_1.removeAll();

				dailymeals.removeAll(dailymeals);
				String day;
				String month;
				int m = 0;
				int monthh = dateTime.getMonth();
				monthh++;
				if (dateTime.getDay() < 10) {
					day = "0" + dateTime.getDay();
				} else
					day = "" + dateTime.getDay();
				if (monthh < 10) {
					month = "0" + monthh;
				} else
					month = "" + monthh;
				try {
					ArrayList<Meal> mealls = diary.findEatenMealsByDate(day
							+ "/" + month + "/" + dateTime.getYear());
					DateFormat df = new SimpleDateFormat("       HH:mm");
					java.util.Date today = Calendar.getInstance().getTime();
					String reportDate = df.format(today);

					for (Meal meeal : mealls) {
						System.out.println(meeal.getName());
						TableItem item = new TableItem(table, SWT.NONE);

						// tableItem.setText(h++, Integer.toString(++b));
						item.setText(m++, meeal.getName());
						item.setText(m++, reportDate);
						item.setText(m++, String.valueOf(meeal.getCalories()));
						item.setText(m++, String.valueOf(meeal.getFat()));
						item.setText(m++, String.valueOf(meeal.getProtein()));
						item.setText(m++, String.valueOf(meeal.getCarbs()));
						dailymeals.add(new Meal(meeal.getName(), meeal
								.getCalories(), meeal.getCarbs(), meeal
								.getProtein(), meeal.getFat()));
						m = 0;
					}
					double calories = 0;
					double fat = 0;
					double protein = 0;
					double carbs = 0;
					setTotalTable(mealls, table_1);
					/*
					 * for (Meal meal : mealls) { calories +=
					 * meal.getCalories(); fat += meal.getFat(); protein +=
					 * meal.getProtein(); carbs += meal.getCarbs(); } m=0;
					 * TableItem tableItem2000 = new TableItem(table_1,
					 * SWT.NONE); // loadedCalories = calories; // loadedProtein
					 * = protein; // loadedCarbs = carbs; // loadedFat = fat;
					 * System.out.println(loadedCalories +
					 * "*********************"); tableItem2000.setText(m++,
					 * String.valueOf(calories)); tableItem2000.setText(m++,
					 * String.valueOf(fat)); tableItem2000.setText(m++,
					 * String.valueOf(protein)); tableItem2000.setText(m++,
					 * String.valueOf(carbs)); dataset.setValue("Carbs", new
					 * Double(tableItem2000.getText(3)));
					 * dataset.setValue("Prot", new
					 * Double(tableItem2000.getText(2)));
					 * dataset.setValue("Fat", new
					 * Double(tableItem2000.getText(1)));
					 * chartcomposite.setVisible(true); System.out.println(m); m
					 * = 0;
					 */

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		lab.add(label_1);
		lab.add(label_2);
		lab.add(label);
		lab.add(label_4);
		lab.add(label_5);
		lab.add(label_6);
		lab.add(label_7);
		lab.add(label_8);
		lab.add(label_9);
		lab.add(label_10);
		lab.add(label_11);
		lab.add(label_12);
		
	}
}