package org.jcryptool.visual.des.view;




import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.jcryptool.visual.des.algorithm.DESController;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DesView extends ViewPart {
	// Auto Gen
	public static final String ID = "org.jcryptool.visual.des.view.DesView"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	
	// Controller
	private DESController DESCon = null;

	// Layout Components
	// Algorithm Study
	ScrolledComposite wrapper = null;
	TabFolder tfolder = null;
	TabItem tabAlg = null;;
	Composite comAlg = null;
	Composite comAlgHeader = null;
	Label lblAlgorithm = null;
	Composite comAlgMain = null;
	Composite comAlgMainDown = null;
	Composite comAlgMainLeft = null;
	Composite comAlgMainRight = null;
	Composite comAlgMainRightUp = null;
	Composite comAlgMainRightDown = null;
	Group grpAlgInput = null;
	Group grpAlgOutput = null;
	Group grpAlgInformation = null;
	Group grpAlgStatus = null;
	Text txtAlgStatus = null;
	Composite comAlgInputMode = null;
	Composite comAlgInputKey = null;
	Composite comAlgInputData = null;
	Button btnAlgDecrypt = null;
	Button btnAlgEncrypt = null;
	Label lblAlgMode = null;
	Button btnAlgK0 = null;
	Button btnAlgK3 = null;
	Button btnAlgK5 = null;
	Button btnAlgK6 = null;
	Button btnAlgK9 = null;
	Button btnAlgK10 = null;
	Button btnAlgK12 = null;
	Button btnAlgK15 = null;
	Label lblAlgInputKey = null;
	Button btnAlgManual = null;
	Label lblAlgInputData = null;
	Label lblAlgInputPlaintext = null;
	Text txtAlgKeyManual = null;
	Text txtAlgInputData = null;
	TabFolder tfAlgOutput = null;
	TabItem tbtmAlgStandard = null;
	TabItem tbtmAlgM0M17 = null;
	TabItem tbtmAlgDES = null;
	TabItem tbtmAlgHamming = null;
	TabItem tbtmAlgRoundkeys = null;
	TabItem tbtmAlgCDMatrix = null;
	Button btnAlgEvaluate = null;
	Button btnAlgReset = null;
	Table tblAlgOutputDeskpei = null;
	Composite comAlgOutputDeskpei = null;
	Composite comAlgOutputRoundkeys = null;
	Table tblAlgOutputRoundkeys = null;
	Table tblAlgOutputCDMatrix = null;
	Composite comAlgOutputCDMatrix = null;
	Group grpAlgHeader = null;
	Table tblAlgOutputM0M17 = null;
	Composite comAlgInputSepOut = null;
	Label lblAlgInputSeparator = null;
	Label lblAlgInputCipherOut = null;
	Label lblAlgInputManualCurChar = null;
	Label lblAlgInputDataCurChar = null;
	Table tblAlgOutputHamming1 = null;
	Table tblAlgOutputHamming2 = null;
	Composite comAlgOutputHamming = null;
	Label lblAlgInfoDes = null;
	Label lblAlgInfoKey = null;
	Label lblAlgInfoData = null;
	Label lblAlgInfoTableRoundkeys = null;
	Label lblAlgInfoTableCDMatrix = null;
	
	// FPoints Study
	TabItem tabFPoints = null;
	Composite comFPoints = null;
	Composite comFPointsHeader = null;
	Label lblFPoints = null;
	Composite comFPointsMain = null;
	Composite comFPointsMainDown = null;
	Composite comFPointsMainLeft = null;
	Composite comFPointsMainRight = null;
	Composite comFPointsMainRightUp = null;
	Composite comFPointsMainRightDown = null;
	Group grpFPointsInput = null;
	Group grpFPointsOutput = null;
	Group grpFPointsInformation = null;
	Group grpFPointsStatus = null;
	Text txtFPointsStatus = null;
	Button btnFPointsEvaluate = null;
	Button btnFPointsReset = null;
	Composite comFPointsInputKey = null;
	Composite comFPointsInputTarget = null;
	Label lblFPointsInputTarget = null;
	Button btnFPointsFixedpoint = null;
	Button btnFPointsAntifixedPoint = null;
	Label lblFPointsInputKey = null;
	Button btnFPointsK0 = null;
	Button btnFPointsK1 = null;
	Button btnFPointsK2 = null;
	Button btnFPointsK3 = null;
	Composite comFPointsInputM8 = null;
	Label lblFPointsInputData = null;
	Text txtFPointsInputM8 = null;
	Label lblFPointsInputM8 = null;
	Group grpFPointsHeader = null;
	Table tblFPointsOutputAFP = null;
	Composite comFPointsOutput = null;
	Label lblFPointsOutputAFPoint = null;
	Label lblFPointsInfoDes = null;
	Label lblFPointsInfoKey = null;
	Label lblFPointsInfoM8 = null;
	Label lblFPointsInfoTable = null;
	Label lblAlgInfoTableM0M17 = null;
	Label lblAlgInfoTableDeskpei = null;
	
	//SBox Study
	TabItem tabSBox = null;
	Composite comSBox = null;
	Composite comSBoxHeader = null;
	Label lblSBox = null;
	Composite comSBoxMain = null;
	Composite comSBoxMainDown = null;
	Composite comSBoxMainLeft = null;
	Composite comSBoxMainRight = null;
	Composite comSBoxMainRightUp = null;
	Composite comSBoxMainRightDown = null;
	Group grpSBoxInput = null;
	Group grpSBoxOutput = null;
	Group grpSBoxInformation = null;
	Group grpSBoxStatus = null;
	Text txtSBoxStatus = null;
	Composite comSBoxInput = null;
	Label lblSBoxInputData = null;
	Label lblSBoxInputDeltap = null;
	Label lblSBoxInputDeltapCur = null; 
	Text txtSBoxInputDeltap = null;
	Button btnSBoxEvaluate = null;
	Button btnSBoxReset = null;
	Button btnSBoxEvaluateSeries = null;
	Table tblSBoxOutput = null;
	Composite comSBoxInputDataSeries = null;
	Slider slSBoxInputSeriesCount = null;
	Slider slSBoxInputSeriesTime = null;
	Label lblSBoxInputSeries = null;
	Label lblSBoxInputSeriesTime = null;
	Label lblSBoxInputSeriesCount = null;
	int intSBoxOutputCurStep = 0;
	Label lblSBoxOutputCurStep = null;
	Label lblSBoxOutputP = null;
	Label lblSBoxOutputK = null;
	Group grpSBoxHeader = null;
	Label lblSBoxInfoDes = null;
	Label lblSBoxInfoDeltap = null;
	Label lblSBoxInfoRandomP = null;
	Label lblSBoxInfoRandomK = null;
	Label lblSBoxInfoYBox = null;
	Label lblSBoxInfoRBox = null;
	Label lblFPointsInputM8cur = null;
	
	public DesView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		
		// Wrapper Start
		wrapper = new ScrolledComposite(parent,SWT.V_SCROLL | SWT.H_SCROLL);
		wrapper.setExpandHorizontal(true);
		wrapper.setExpandVertical(true);
		
	    // Folder
		tfolder = new TabFolder(wrapper,SWT.TOP);
		
		// Algorithm Study Tab
	    createAlgTab();
	    // Fixed Points Study tab
	    createFPointsTab();
	    // S-Box Tab
	    createSBoxTab();
	    
	    // Wrapper Final
	    wrapper.setMinSize(1100, 760);
		wrapper.setContent(tfolder);
	    
	    // Create DES Controller
		DESCon = new DESController();
	    	
		createActions();
		initializeToolBar();
		initializeMenu();
	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager tbm = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager manager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	
	private void createAlgTab() {
		tabAlg = new TabItem(tfolder,SWT.NONE);
		tabAlg.setText("Algorithm Study");
		   
		// Tab Layout
		comAlg = new Composite(tfolder,SWT.NONE);
		comAlg.setLayout(new FillLayout());
		
		comAlgMain = new Composite(comAlg, SWT.NONE);
		comAlgMain.setLayout(new FormLayout());

		comAlgMainLeft = new Composite(comAlgMain, SWT.NONE);
		comAlgMainLeft.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_comAlgMainLeft = new FormData(250,480);
		fd_comAlgMainLeft.left = new FormAttachment(0,10);
		fd_comAlgMainLeft.top = new FormAttachment(0,10);
		comAlgMainLeft.setLayoutData(fd_comAlgMainLeft);
		
		comAlgMainRight = new Composite(comAlgMain, SWT.NONE);
		comAlgMainRight.setLayout(new FormLayout());
		FormData fd_comAlgMainRight = new FormData(600,480);
		fd_comAlgMainRight.top = new FormAttachment(0,10);
		fd_comAlgMainRight.left = new FormAttachment(comAlgMainLeft,10);
		fd_comAlgMainRight.right = new FormAttachment(100,-10);
		comAlgMainRight.setLayoutData(fd_comAlgMainRight);
		
		comAlgMainDown = new Composite(comAlgMain, SWT.NONE);
		FormData fd_comAlgMainDown = new FormData(0,100);
		fd_comAlgMainDown.top = new FormAttachment(comAlgMainLeft, 10);
		fd_comAlgMainDown.left = new FormAttachment(0, 10);
		fd_comAlgMainDown.right = new FormAttachment(100,-10);
		comAlgMainDown.setLayout(new FillLayout(SWT.HORIZONTAL));
		comAlgMainDown.setLayoutData(fd_comAlgMainDown);		
		
		comAlgMainRightUp = new Composite(comAlgMainRight, SWT.NONE);
		comAlgMainRightUp.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_comAlgMainRightUp = new FormData();
		fd_comAlgMainRightUp.top = new FormAttachment(0);
		fd_comAlgMainRightUp.left = new FormAttachment(0);
		fd_comAlgMainRightUp.right = new FormAttachment(100);
		comAlgMainRightUp.setLayoutData(fd_comAlgMainRightUp);
			
		comAlgMainRightDown = new Composite(comAlgMainRight, SWT.NONE);
		FormData fd_comAlgMainRightDown = new FormData(0,150);
		fd_comAlgMainRightDown.right = new FormAttachment(100);
		fd_comAlgMainRightDown.top = new FormAttachment(comAlgMainRightUp, 10);
		fd_comAlgMainRightDown.left = new FormAttachment(0);
		fd_comAlgMainRightDown.bottom = new FormAttachment(100);
		comAlgMainRightDown.setLayout(new FillLayout(SWT.HORIZONTAL));
		comAlgMainRightDown.setLayoutData(fd_comAlgMainRightDown);
		
		grpAlgInput = new Group(comAlgMainRightUp, SWT.NONE);
		grpAlgInput.setText("Input");
		grpAlgInput.setLayout(new FormLayout());
			
		grpAlgOutput = new Group(comAlgMainRightDown, SWT.NONE);
		grpAlgOutput.setText("Output");
		grpAlgOutput.setLayout(new FillLayout());
			
		grpAlgInformation = new Group(comAlgMainLeft, SWT.NONE);
		grpAlgInformation.setText("Information");
		grpAlgInformation.setLayout(new FormLayout());
		
		grpAlgStatus = new Group(comAlgMainDown, SWT.NONE);
		grpAlgStatus.setText("Status");
		grpAlgStatus.setLayout(new FormLayout());
			
		txtAlgStatus = new Text(grpAlgStatus, SWT.MULTI | SWT.V_SCROLL);
		txtAlgStatus.setEditable(false);
		FormData fd_txtAlgStatus = new FormData();
		fd_txtAlgStatus.bottom = new FormAttachment(100,-10);
		fd_txtAlgStatus.right = new FormAttachment(100, -10);
		fd_txtAlgStatus.top = new FormAttachment(0, 10);
		fd_txtAlgStatus.left = new FormAttachment(0, 10);
		txtAlgStatus.setLayoutData(fd_txtAlgStatus);
		
		// Input Tab
		comAlgInputMode = new Composite(grpAlgInput, SWT.NONE);
		FormData fd_comAlgInputMode = new FormData();
		fd_comAlgInputMode.left = new FormAttachment(0, 10);
		fd_comAlgInputMode.top = new FormAttachment(0,0);
		fd_comAlgInputMode.bottom = new FormAttachment(100);
		comAlgInputMode.setLayoutData(fd_comAlgInputMode);
			
		btnAlgDecrypt = new Button(comAlgInputMode, SWT.RADIO);
		btnAlgDecrypt.setText("Decrypt");
		btnAlgDecrypt.setBounds(0, 40, 67, 22);
		
		btnAlgDecrypt.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				lblAlgInputPlaintext.setText("Ciphertext:");
				lblAlgInputCipherOut.setText("Plaintext:");
			}
			
		});
			
		btnAlgEncrypt = new Button(comAlgInputMode, SWT.RADIO);
		btnAlgEncrypt.setText("Encrypt");
		btnAlgEncrypt.setBounds(0, 20, 67, 22);
		btnAlgEncrypt.setSelection(true);
		
		btnAlgEncrypt.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				lblAlgInputPlaintext.setText("Plaintext:");
				lblAlgInputCipherOut.setText("Ciphertext:");
			}
			
		});
		
		lblAlgMode = new Label(comAlgInputMode, SWT.NONE);
		lblAlgMode.setBounds(0, 3, 51, 15);
		lblAlgMode.setText("Mode");
				
		comAlgInputKey = new Composite(grpAlgInput, SWT.NONE);
		FormData fd_comAlgInputKey = new FormData();
		fd_comAlgInputKey.top = new FormAttachment(0);
		fd_comAlgInputKey.bottom = new FormAttachment(100);
		fd_comAlgInputKey.left = new FormAttachment(comAlgInputMode);
		comAlgInputKey.setLayoutData(fd_comAlgInputKey);
				
		btnAlgK0 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK0.setText("k[0]");
		btnAlgK0.setBounds(0, 20, 43, 22);
		btnAlgK0.setSelection(true);
				
		lblAlgInputKey = new Label(comAlgInputKey, SWT.NONE);
		lblAlgInputKey.setBounds(0, 3, 51, 15);
		lblAlgInputKey.setText("Key");
				
		btnAlgK3 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK3.setText("k[3]");
		btnAlgK3.setBounds(50, 20, 43, 22);
				
		btnAlgK5 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK5.setText("k[5]");
		btnAlgK5.setBounds(110, 20, 43, 22);
				
		btnAlgK6 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK6.setText("k[6]");
		btnAlgK6.setBounds(170, 20, 43, 22);
				
		btnAlgK9 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK9.setText("k[9]");
		btnAlgK9.setBounds(0, 40, 43, 22);
				
		btnAlgK10 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK10.setText("k[10]");
		btnAlgK10.setBounds(50, 40, 56, 22);
				
		btnAlgK12 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK12.setText("k[12]");
		btnAlgK12.setBounds(110, 40, 56, 22);
				
		btnAlgK15 = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgK15.setText("k[15]");
		btnAlgK15.setBounds(170, 40, 55, 22);
				
		btnAlgManual = new Button(comAlgInputKey, SWT.RADIO);
		btnAlgManual.setText("Manual Key (16 HexDigits):");
		btnAlgManual.setBounds(220, 23, 155, 15);
		
		lblAlgInputManualCurChar = new Label(comAlgInputKey, SWT.NONE);
		lblAlgInputManualCurChar.setBounds(368, 43, 25, 15);
		lblAlgInputManualCurChar.setText("(0)");
			
		txtAlgKeyManual = new Text(comAlgInputKey, SWT.BORDER);
		txtAlgKeyManual.setBounds(237, 41, 128, 20);
		txtAlgKeyManual.setTextLimit(16);
		
		txtAlgKeyManual.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				lblAlgInputManualCurChar.setText("("+txtAlgKeyManual.getText().length()+")");
			}
			
		});
				
		comAlgInputData = new Composite(grpAlgInput, SWT.NONE);
		FormData fd_comAlgInputData = new FormData();
		fd_comAlgInputData.top = new FormAttachment(0);
		fd_comAlgInputData.bottom = new FormAttachment(100);
		fd_comAlgInputData.left = new FormAttachment(comAlgInputKey, 10);
		comAlgInputData.setLayoutData(fd_comAlgInputData);
				
		lblAlgInputData = new Label(comAlgInputData, SWT.NONE);
		lblAlgInputData.setText("Data");
		lblAlgInputData.setBounds(0, 3, 51, 15);
				
		txtAlgInputData = new Text(comAlgInputData, SWT.BORDER);
		txtAlgInputData.setBounds(0, 41, 119, 20);
		txtAlgInputData.setTextLimit(16);
		
		txtAlgInputData.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				lblAlgInputDataCurChar.setText("("+txtAlgInputData.getText().length()+")");
			}
			
		});
		
		lblAlgInputDataCurChar = new Label(comAlgInputData, SWT.NONE);
		lblAlgInputDataCurChar.setBounds(125, 41, 30, 15);
		lblAlgInputDataCurChar.setText("(0)");
				
		lblAlgInputPlaintext = new Label(comAlgInputData, SWT.NONE);
		lblAlgInputPlaintext.setBounds(0, 22, 150, 15);
		lblAlgInputPlaintext.setText("Plaintext (16 HexDigits):");
		
		comAlgInputSepOut = new Composite(grpAlgInput,SWT.NONE);
		FormData fd_comAlgInputSepOut = new FormData();
		fd_comAlgInputSepOut.top = new FormAttachment(0);
		fd_comAlgInputSepOut.bottom = new FormAttachment(100);
		fd_comAlgInputSepOut.left = new FormAttachment(comAlgInputData,10);
		fd_comAlgInputSepOut.right = new FormAttachment(100);
		comAlgInputSepOut.setLayoutData(fd_comAlgInputSepOut);
		comAlgInputSepOut.setLayout(new FormLayout());
		
		lblAlgInputSeparator = new Label (comAlgInputSepOut, SWT.SEPARATOR | SWT.VERTICAL);
		FormData fd_lblAlgInputSeparator = new FormData();
		fd_lblAlgInputSeparator.top = new FormAttachment(0,10);
		fd_lblAlgInputSeparator.bottom = new FormAttachment(100,-10);
		fd_lblAlgInputSeparator.left = new FormAttachment(0);
		lblAlgInputSeparator.setLayoutData(fd_lblAlgInputSeparator);
				
		lblAlgInputCipherOut = new Label (comAlgInputSepOut,SWT.NONE);
		FormData fd_lblAlgInputCipherOut = new FormData();
		fd_lblAlgInputCipherOut.top = new FormAttachment(0,23);
		fd_lblAlgInputCipherOut.bottom = new FormAttachment(100);
		fd_lblAlgInputCipherOut.left = new FormAttachment(lblAlgInputSeparator, 15);
		fd_lblAlgInputCipherOut.right = new FormAttachment(100,5);
		lblAlgInputCipherOut.setLayoutData(fd_lblAlgInputCipherOut);
		lblAlgInputCipherOut.setText("Ciphertext: ");
		
		
		//Output Tab
		tfAlgOutput = new TabFolder(grpAlgOutput, SWT.NONE);
		
		tbtmAlgM0M17 = new TabItem(tfAlgOutput, SWT.NONE);
		tbtmAlgM0M17.setText("RoundCiphers");
		
		Composite comAlgOutputM0M17 = new Composite(tfAlgOutput, SWT.NONE);
		tbtmAlgM0M17.setControl(comAlgOutputM0M17);
		comAlgOutputM0M17.setLayout(new FormLayout());
		
		tblAlgOutputM0M17 = new Table(comAlgOutputM0M17,SWT.MULTI | SWT.V_SCROLL | SWT.VIRTUAL);
		FormData fd_tblAlgOutputM0M17 = new FormData();
		fd_tblAlgOutputM0M17.left = new FormAttachment(0,0);
		fd_tblAlgOutputM0M17.right = new FormAttachment(100,0);
		fd_tblAlgOutputM0M17.top = new FormAttachment(0,0);
		fd_tblAlgOutputM0M17.bottom = new FormAttachment(100,0);
		tblAlgOutputM0M17.setLayoutData(fd_tblAlgOutputM0M17);
		tblAlgOutputM0M17.setHeaderVisible(true);
		tblAlgOutputM0M17.setLinesVisible(true);
		
		TableColumn[] tblAlgOutputM0M17Column = new TableColumn[34];
		tblAlgOutputM0M17Column[0] = new TableColumn(tblAlgOutputM0M17, SWT.NONE);
		tblAlgOutputM0M17Column[0].setWidth(45);
		tblAlgOutputM0M17Column[0].setAlignment(SWT.CENTER);
		for (int i=1;i<33;i++){
			tblAlgOutputM0M17Column[i] = new TableColumn(tblAlgOutputM0M17, SWT.NONE);
			tblAlgOutputM0M17Column[i].setWidth(25);
			tblAlgOutputM0M17Column[i].setAlignment(SWT.CENTER);
			tblAlgOutputM0M17Column[i].setText(i+"");
			
		}
		tblAlgOutputM0M17Column[33] = new TableColumn(tblAlgOutputM0M17, SWT.NONE);
		tblAlgOutputM0M17Column[33].setWidth(70);
		tblAlgOutputM0M17Column[33].setAlignment(SWT.CENTER);
		tblAlgOutputM0M17Column[33].setText("DIST");
		
		TableItem[] tblAlgM0M17Item = new TableItem[18];
		for (int i=0;i<18;i++){
			tblAlgM0M17Item[i] = new TableItem(tblAlgOutputM0M17, SWT.BORDER);
		}
		cleanTable(tblAlgOutputM0M17);
		for (int i=0;i<18;i++){
			tblAlgM0M17Item[i].setText(0, "m["+(i)+"]");
		}
		
		
		tbtmAlgDES = new TabItem(tfAlgOutput, SWT.NONE);
		tbtmAlgDES.setText("DES(k,p+e_i)");
		
		comAlgOutputDeskpei = new Composite(tfAlgOutput, SWT.NONE);
		tbtmAlgDES.setControl(comAlgOutputDeskpei);
		comAlgOutputDeskpei.setLayout(new FormLayout());
		
		tblAlgOutputDeskpei = new Table(comAlgOutputDeskpei, SWT.V_SCROLL | SWT.H_SCROLL | SWT.VIRTUAL | SWT.MULTI);
		FormData fd_tblAlgOutputDeskpei = new FormData();
		fd_tblAlgOutputDeskpei.left = new FormAttachment(0,0);
		fd_tblAlgOutputDeskpei.right = new FormAttachment(100,0);
		fd_tblAlgOutputDeskpei.top = new FormAttachment(0,0);
		fd_tblAlgOutputDeskpei.bottom = new FormAttachment(100,0);
		tblAlgOutputDeskpei.setLayoutData(fd_tblAlgOutputDeskpei);
		tblAlgOutputDeskpei.setHeaderVisible(true);
		tblAlgOutputDeskpei.setLinesVisible(true);
		
		TableColumn[] tblAlgOutputDESColumn = new TableColumn[66];
		tblAlgOutputDESColumn[0] = new TableColumn(tblAlgOutputDeskpei, SWT.NONE);
		tblAlgOutputDESColumn[0].setWidth(70);
		tblAlgOutputDESColumn[0].setAlignment(SWT.CENTER);
		for (int i=1;i<65;i++){
			tblAlgOutputDESColumn[i] = new TableColumn(tblAlgOutputDeskpei, SWT.NONE);
			tblAlgOutputDESColumn[i].setWidth(25);
			tblAlgOutputDESColumn[i].setAlignment(SWT.CENTER);
			tblAlgOutputDESColumn[i].setText(i+"");
			
		}
		tblAlgOutputDESColumn[65] = new TableColumn(tblAlgOutputDeskpei, SWT.NONE);
		tblAlgOutputDESColumn[65].setWidth(50);
		tblAlgOutputDESColumn[65].setAlignment(SWT.CENTER);
		tblAlgOutputDESColumn[65].setText("DIST");
		
		TableItem[] tblAlgDESItem = new TableItem[65];
		for (int i=0;i<65;i++){
			tblAlgDESItem[i] = new TableItem(tblAlgOutputDeskpei, SWT.BORDER);
		}
		cleanTable(tblAlgOutputDeskpei);
		tblAlgDESItem[0].setText(0, "DES(k,p)");
		for (int i=1;i<65;i++){
			tblAlgDESItem[i].setText(0, "DES("+i+")");
		}
		
		// Create Hamming Tab
		tbtmAlgHamming = new TabItem(tfAlgOutput, SWT.NONE);
		tbtmAlgHamming.setText("Distance Matrix");
		
		comAlgOutputHamming = new Composite(tfAlgOutput,SWT.NONE);
		tbtmAlgHamming.setControl(comAlgOutputHamming);
		
		Label lblAlgOutputHamming1 = new Label(comAlgOutputHamming,SWT.NONE);
		lblAlgOutputHamming1.setBounds(130, 20, 100, 20);
		lblAlgOutputHamming1.setText("A[i,j]");
		
		Composite t1 = new Composite(comAlgOutputHamming,SWT.BORDER);
		t1.setBounds(30, 50, 225, 161);
		
		tblAlgOutputHamming1 = new Table(t1,SWT.NONE);
		tblAlgOutputHamming1.setHeaderVisible(false);
		tblAlgOutputHamming1.setLinesVisible(true);
		tblAlgOutputHamming1.setBounds(0, 0, 224, 160);
		
		TableColumn[] tblAlgOutputHamming1Column = new TableColumn[8];
		for (int i=0;i<8;i++){
			tblAlgOutputHamming1Column[i] = new TableColumn(tblAlgOutputHamming1, SWT.NONE);
			tblAlgOutputHamming1Column[i].setWidth(28);
			tblAlgOutputHamming1Column[i].setAlignment(SWT.CENTER);
		}
		TableItem[] tblAlgOutputHamming1TableItem = new TableItem[8];
		for (int i=0;i<8;i++){
			tblAlgOutputHamming1TableItem[i] = new TableItem(tblAlgOutputHamming1,SWT.BORDER);
		}
		cleanTable(tblAlgOutputHamming1);
		
		Label lblAlgOutputHamming2 = new Label(comAlgOutputHamming,SWT.NONE);
		lblAlgOutputHamming2.setBounds(400, 20, 100, 20);
		lblAlgOutputHamming2.setText("B[i,j]");
		
		Composite t2 = new Composite(comAlgOutputHamming,SWT.BORDER);
		t2.setBounds(300, 50, 225, 161);
		
		tblAlgOutputHamming2 = new Table(t2,SWT.NONE);
		tblAlgOutputHamming2.setHeaderVisible(false);
		tblAlgOutputHamming2.setLinesVisible(true);
		tblAlgOutputHamming2.setBounds(0, 0, 224, 160);
		
		TableColumn[] tblAlgOutputHamming2Column = new TableColumn[8];
		for (int i=0;i<8;i++){
			tblAlgOutputHamming2Column[i] = new TableColumn(tblAlgOutputHamming2, SWT.NONE);
			tblAlgOutputHamming2Column[i].setWidth(28);
			tblAlgOutputHamming2Column[i].setAlignment(SWT.CENTER);
		}
		TableItem[] tblAlgOutputHamming2TableItem = new TableItem[8];
		for (int i=0;i<8;i++){
			tblAlgOutputHamming2TableItem[i] = new TableItem(tblAlgOutputHamming2,SWT.BORDER);
		}
		cleanTable(tblAlgOutputHamming2);
		
		Label tblAlgOutputHammingDes = new Label(comAlgOutputHamming, SWT.NONE);
		tblAlgOutputHammingDes.setBounds(30, 230, 700, 40);
		tblAlgOutputHammingDes.setText("The matrices A and B visualizes Hamming distances between " +
									   "DES(k,Input_1) and DES(k,Input_2)\n where Input_1,Input_2 have a " +
									   "Hamming distance of 1 (for A) and 2 (for B).\n");
		
		// Roundkeys
		
		tbtmAlgRoundkeys = new TabItem(tfAlgOutput, SWT.NONE);
		tbtmAlgRoundkeys.setText("Roundkeys");
		
		comAlgOutputRoundkeys = new Composite(tfAlgOutput, SWT.NONE);
		tbtmAlgRoundkeys.setControl(comAlgOutputRoundkeys);
		comAlgOutputRoundkeys.setLayout(new FormLayout());
		
		tblAlgOutputRoundkeys = new Table(comAlgOutputRoundkeys, SWT.V_SCROLL | SWT.H_SCROLL | SWT.VIRTUAL | SWT.MULTI);
		FormData fd_tblAlgOutputRoundkeys = new FormData();
		fd_tblAlgOutputRoundkeys.left = new FormAttachment(0,0);
		fd_tblAlgOutputRoundkeys.right = new FormAttachment(100,0);
		fd_tblAlgOutputRoundkeys.top = new FormAttachment(0,0);
		fd_tblAlgOutputRoundkeys.bottom = new FormAttachment(100,0);
		tblAlgOutputRoundkeys.setLayoutData(fd_tblAlgOutputRoundkeys);
		tblAlgOutputRoundkeys.setHeaderVisible(true);
		tblAlgOutputRoundkeys.setLinesVisible(true);
		
		TableColumn[] tblAlgOutputRoundkeysColumn = new TableColumn[49];
		tblAlgOutputRoundkeysColumn[0] = new TableColumn(tblAlgOutputRoundkeys, SWT.NONE);
		tblAlgOutputRoundkeysColumn[0].setWidth(40);
		tblAlgOutputRoundkeysColumn[0].setAlignment(SWT.CENTER);
		for (int i=1;i<49;i++){
			tblAlgOutputRoundkeysColumn[i] = new TableColumn(tblAlgOutputRoundkeys, SWT.NONE);
			tblAlgOutputRoundkeysColumn[i].setWidth(25);
			tblAlgOutputRoundkeysColumn[i].setAlignment(SWT.CENTER);
			tblAlgOutputRoundkeysColumn[i].setText(i+"");
			
		}
		TableItem[] tblAlgRoundkeysItem = new TableItem[16];
		for (int i=0;i<16;i++){
			tblAlgRoundkeysItem[i] = new TableItem(tblAlgOutputRoundkeys, SWT.BORDER);
		}
		cleanTable(tblAlgOutputRoundkeys);
		for (int i=0;i<16;i++){
			tblAlgRoundkeysItem[i].setText(0,"K["+(i+1)+"]");
		}
		
		tbtmAlgCDMatrix = new TabItem(tfAlgOutput, SWT.NONE);
		tbtmAlgCDMatrix.setText("CD-Matrix");
		
		comAlgOutputCDMatrix = new Composite(tfAlgOutput, SWT.NONE);
		tbtmAlgCDMatrix.setControl(comAlgOutputCDMatrix);
		comAlgOutputCDMatrix.setLayout(new FormLayout());
		
		tblAlgOutputCDMatrix = new Table(comAlgOutputCDMatrix, SWT.V_SCROLL | SWT.H_SCROLL | SWT.VIRTUAL | SWT.MULTI);
		FormData fd_tblAlgOutputCDMatrix = new FormData();
		fd_tblAlgOutputCDMatrix.left = new FormAttachment(0,0);
		fd_tblAlgOutputCDMatrix.right = new FormAttachment(0,675);
		fd_tblAlgOutputCDMatrix.top = new FormAttachment(0,0);
		fd_tblAlgOutputCDMatrix.bottom = new FormAttachment(100,0);
		tblAlgOutputCDMatrix.setLayoutData(fd_tblAlgOutputCDMatrix);
		tblAlgOutputCDMatrix.setLinesVisible(true);
		
		TableColumn[] tblAlgOutputCDMatrixColumn = new TableColumn[29];
		tblAlgOutputCDMatrixColumn[0] = new TableColumn(tblAlgOutputCDMatrix, SWT.NONE);
		tblAlgOutputCDMatrixColumn[0].setWidth(40);
		tblAlgOutputCDMatrixColumn[0].setAlignment(SWT.CENTER);
		for (int i=1;i<29;i++){
			tblAlgOutputCDMatrixColumn[i] = new TableColumn(tblAlgOutputCDMatrix, SWT.NONE);
			tblAlgOutputCDMatrixColumn[i].setWidth(22);
			tblAlgOutputCDMatrixColumn[i].setAlignment(SWT.CENTER);
		}
		
		TableItem[] tblAlgCDMatrixItem = new TableItem[34];
		for (int i=0;i<34;i++){
			tblAlgCDMatrixItem[i] = new TableItem(tblAlgOutputCDMatrix, SWT.BORDER);
		}
		cleanTable(tblAlgOutputCDMatrix);
		for (int i=0,j=0;i<34;i=i+2,j++){
			tblAlgCDMatrixItem[i].setText(0, "C["+j+"]");
			tblAlgCDMatrixItem[i+1].setText(0,"D["+j+"]");
		}	
				
		// Information Tab		
		lblAlgInfoDes = new Label(grpAlgInformation,SWT.NONE);
		FormData fd_lblAlgInfoDes = new FormData();
		fd_lblAlgInfoDes.right = new FormAttachment(100,-10);
		fd_lblAlgInfoDes.top = new FormAttachment(0,10);
		fd_lblAlgInfoDes.left = new FormAttachment(0, 10);
		lblAlgInfoDes.setLayoutData(fd_lblAlgInfoDes);
		lblAlgInfoDes.setText("Different aspects of the encryption or\n" +
							  "decryption process are visualized.\n");
		
		lblAlgInfoKey = new Label(grpAlgInformation,SWT.NONE);
		FormData fd_lblAlgInfoKey = new FormData();
		fd_lblAlgInfoKey.right = new FormAttachment(100,-10);
		fd_lblAlgInfoKey.top = new FormAttachment(lblAlgInfoDes,10);
		fd_lblAlgInfoKey.left = new FormAttachment(0, 10);
		lblAlgInfoKey.setLayoutData(fd_lblAlgInfoKey);
		lblAlgInfoKey.setText("Key:\nThe Key k used to encrypt or decrypt\n" +
							  "the data.");
		/*
		lblAlgInfoData = new Label(grpAlgInformation,SWT.NONE);
		FormData fd_lblAlgInfoData = new FormData();
		fd_lblAlgInfoData.right = new FormAttachment(100,-10);
		fd_lblAlgInfoData.top = new FormAttachment(lblAlgInfoDes,10);
		fd_lblAlgInfoData.left = new FormAttachment(0, 10);
		lblAlgInfoData.setLayoutData(fd_lblAlgInfoData);
		lblAlgInfoData.setText("Data:\nThe data which will be encrypted\n" +
								 "or decrypted.");
		*/			
		lblAlgInfoTableM0M17 = new Label(grpAlgInformation,SWT.NONE);
		FormData fd_lblAlgInfoTableM0M17 = new FormData();
		fd_lblAlgInfoTableM0M17.right = new FormAttachment(100,-10);
		fd_lblAlgInfoTableM0M17.top = new FormAttachment(lblAlgInfoKey,10);
		fd_lblAlgInfoTableM0M17.left = new FormAttachment(0, 10);
		lblAlgInfoTableM0M17.setLayoutData(fd_lblAlgInfoTableM0M17);
		lblAlgInfoTableM0M17.setText("Output Table \"RoundCiphers\":\n" +
									"The table shows the intermediate round\n" +
									"ciphers m[0]-m[17] for the same process\n" +
									"(en-/decryption).\n" +
									"For each column: Adjacent bit-colors \n" +
									"change iff adjacent bit-values change.");
									
									
		lblAlgInfoTableDeskpei = new Label(grpAlgInformation,SWT.NONE);
		FormData fd_lblAlgInfoTableDeskpei = new FormData();
		fd_lblAlgInfoTableDeskpei.right = new FormAttachment(100,-10);
		fd_lblAlgInfoTableDeskpei.top = new FormAttachment(lblAlgInfoTableM0M17,10);
		fd_lblAlgInfoTableDeskpei.left = new FormAttachment(0, 10);
		lblAlgInfoTableDeskpei.setLayoutData(fd_lblAlgInfoTableDeskpei);
		lblAlgInfoTableDeskpei.setText("Output Table \"DES(k,p+e_i)\":\n" +
									   "For i = 1, ..., 64: Plaintexts p and p+e_i\n" +
									   "differ at position i by one bit.\n" +
									   "Each DES(k; p+e_i) is presented and\n" +
									   "compared with DES(k,p) using the\n" +
									   "Hamming distance DIST as measure.");
									   
		
		lblAlgInfoTableRoundkeys = new Label(grpAlgInformation,SWT.NONE);
		FormData fd_lblAlgInfoTableRoundkeys = new FormData();
		fd_lblAlgInfoTableRoundkeys.right = new FormAttachment(100,-10);
		fd_lblAlgInfoTableRoundkeys.top = new FormAttachment(lblAlgInfoTableDeskpei,10);
		fd_lblAlgInfoTableRoundkeys.left = new FormAttachment(0, 10);
		lblAlgInfoTableRoundkeys.setLayoutData(fd_lblAlgInfoTableRoundkeys);
		lblAlgInfoTableRoundkeys.setText("Output Table \"Roundkeys\":\nThe table shows the 16 round keys.\n");
		
		lblAlgInfoTableCDMatrix = new Label(grpAlgInformation,SWT.NONE);
		FormData fd_lblAlgInfoTableCDMatrix = new FormData();
		fd_lblAlgInfoTableCDMatrix.right = new FormAttachment(100,-10);
		fd_lblAlgInfoTableCDMatrix.top = new FormAttachment(lblAlgInfoTableRoundkeys,10);
		fd_lblAlgInfoTableCDMatrix.left = new FormAttachment(0, 10);
		lblAlgInfoTableCDMatrix.setLayoutData(fd_lblAlgInfoTableCDMatrix);
		lblAlgInfoTableCDMatrix.setText("Output Table \"CD-Matrix\":\n" +
										"Round key k_i is generated from C[i], D[i]\n" +
										"by cyclic operations combined with\n" +
										"specific bit-selections.");
		
		// Action Buttons
		btnAlgReset = new Button(comAlgMain, SWT.NONE);
		FormData fd_btnAlgReset = new FormData();
		fd_btnAlgReset.top = new FormAttachment(comAlgMainDown, 10);
		fd_btnAlgReset.left = new FormAttachment(0, 10);
		btnAlgReset.setLayoutData(fd_btnAlgReset);
		btnAlgReset.setText("Reset");
	
		btnAlgReset.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				btnAlgEncrypt.setSelection(true);
				btnAlgDecrypt.setSelection(false);
				btnAlgK0.setSelection(true);
				btnAlgK3.setSelection(false);
				btnAlgK5.setSelection(false);
				btnAlgK6.setSelection(false);
				btnAlgK9.setSelection(false);
				btnAlgK10.setSelection(false);
				btnAlgK12.setSelection(false);
				btnAlgK15.setSelection(false);
				btnAlgManual.setSelection(false);
				txtAlgKeyManual.setText("");
				lblAlgInputPlaintext.setText("Plaintext (16 HexDigits):");
				txtAlgInputData.setText("");
				lblAlgInputCipherOut.setText("Ciphertext: ");
				lblAlgInputManualCurChar.setText("(0)");
				lblAlgInputDataCurChar.setText("(0)");
				cleanTable(tblAlgOutputDeskpei);
				cleanTable(tblAlgOutputRoundkeys);
				cleanTable(tblAlgOutputCDMatrix);
				cleanTable(tblAlgOutputM0M17);
				cleanTable(tblAlgOutputHamming1);
				cleanTable(tblAlgOutputHamming2);
				TableItem[] tblItems = tblAlgOutputM0M17.getItems();
				for (int i=0;i<18;i++){
					tblItems[i].setText(0, "m["+(i)+"]");
				}
				tblItems = tblAlgOutputDeskpei.getItems();
				tblItems[0].setText(0,"DES(k,p)");
				for (int i=1;i<65;i++){
					tblItems[i].setText(0, "DES("+i+")");
				}
				tblItems = tblAlgOutputRoundkeys.getItems();
				for (int i=0;i<16;i++){
					tblItems[i].setText(0, "K["+(i+1)+"]");
				}
				tblItems = tblAlgOutputCDMatrix.getItems();
				for (int i=0,j=0;i<34;i=i+2,j++){
					tblItems[i].setText(0, "C["+j+"]");
					tblItems[i+1].setText(0,"D["+j+"]");
				}	
				
				
				txtAlgStatus.append(getCurrentTime()+" Data Reset\n");
				    
			}
		});
		
		
		btnAlgEvaluate = new Button(comAlgMain, SWT.NONE);
		FormData fd_btnAlgEvaluate = new FormData();
		fd_btnAlgEvaluate.top = new FormAttachment(comAlgMainDown, 10);
		fd_btnAlgEvaluate.left = new FormAttachment(btnAlgReset, 10);
		btnAlgEvaluate.setLayoutData(fd_btnAlgEvaluate);
		btnAlgEvaluate.setText("Evaluate");
	
		btnAlgEvaluate.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				String sKey = "";
				String sMode = "";
				String err = "";
				
				DESCon.Alg_In_Data = txtAlgInputData.getText();
				if (btnAlgEncrypt.getSelection()){
					DESCon.Alg_In_Mode = 0;
					sMode = "Encrypt";
				} else {
					DESCon.Alg_In_Mode = 1;
					sMode  ="Decrypt";
				}
				if (btnAlgK0.getSelection()){
					DESCon.Alg_In_selectedKey = 0;
					sKey = "K[0]";
				} else if (btnAlgK3.getSelection()){
					DESCon.Alg_In_selectedKey = 3;
					sKey = "K[3]";
				} else if (btnAlgK5.getSelection()){
					DESCon.Alg_In_selectedKey = 5;
					sKey = "K[5]";
				} else if (btnAlgK6.getSelection()){
					DESCon.Alg_In_selectedKey = 6;
					sKey = "K[6]";
				} else if (btnAlgK9.getSelection()){
					DESCon.Alg_In_selectedKey = 9;
					sKey = "K[9]";
				} else if (btnAlgK10.getSelection()){
					DESCon.Alg_In_selectedKey = 10;
					sKey = "K[10]";
				} else if (btnAlgK12.getSelection()){
					DESCon.Alg_In_selectedKey = 12;
					sKey = "K[12]";
				} else if (btnAlgK15.getSelection()){
					DESCon.Alg_In_selectedKey = 15;
					sKey = "K[15]";
				} else if (btnAlgManual.getSelection()){
					DESCon.Alg_In_selectedKey = 16;
					DESCon.Alg_In_manualKey = txtAlgKeyManual.getText();
					sKey = "Manual Key ("+txtAlgKeyManual.getText()+")";
				}
				
				if (DESCon.AlgorithmStudy()==0){
					if (btnAlgEncrypt.getSelection()){
						lblAlgInputCipherOut.setText("Ciphertext: \n"+DESCon.Alg_Out_EncDecResult);
					} else {
						lblAlgInputCipherOut.setText("Plaintext: \n"+DESCon.Alg_Out_EncDecResult);
					}
					fillTable(tblAlgOutputM0M17, 0, 17, 1, 32, DESCon.Alg_Out_M0M17);
					colorTable(tblAlgOutputM0M17,1);
					for (int i=1;i<tblAlgOutputM0M17.getItemCount();i++){
						tblAlgOutputM0M17.getItem(i).setText(tblAlgOutputM0M17.getColumnCount()-1, Integer.toString(DESCon.Alg_Out_M0M17_Dist[i]));
					}
	               
					fillTable(tblAlgOutputDeskpei, 0, 64, 1, 64, DESCon.Alg_Out_cipherMatrix);
					 // doColoring(0, 64, 1, 64, output2, true, 3, DES_C.DES_action_type);
					for (int i=1;i<tblAlgOutputDeskpei.getItemCount();i++){
						tblAlgOutputDeskpei.getItem(i).setText(tblAlgOutputDeskpei.getColumnCount()-1, Integer.toString(DESCon.Alg_Out_cipherMatrix_Dist[i]));
					}
					colorTable(tblAlgOutputDeskpei,1);
					
					fillTable(tblAlgOutputRoundkeys, 0, 15, 1, 48, DESCon.Alg_Out_Roundkeys);
					
					fillTable(tblAlgOutputCDMatrix, 0, 33, 1, 28, DESCon.Alg_Out_CDMatrix);
					colorTable(tblAlgOutputCDMatrix,3);
                 
					fillTable(tblAlgOutputHamming1, 0, 7, 0, 7, DESCon.Alg_Out_DistMatrix1);
					fillTable(tblAlgOutputHamming2, 0, 7, 0, 7, DESCon.Alg_Out_DistMatrix2);
					
					txtAlgStatus.append(getCurrentTime()+" Data Evaluation: Mode="+sMode+", Key="+sKey+", Data="+txtAlgInputData.getText() +"\n");
				} else {
					for (int i=0;i<DESCon.errMsg.length;i++){
						if (i!=DESCon.errMsg.length-1){
							err += DESCon.errMsg[i]+", ";
						} else {
							err += DESCon.errMsg[i];
						}
					}
					txtAlgStatus.append(getCurrentTime() + " "+ err+"\n");
				}
			}
		});
			
		tabAlg.setControl(comAlg);
		
	}
	
	private void createFPointsTab() {
		tabFPoints = new TabItem(tfolder,SWT.NONE);
		tabFPoints.setText("Anti- / Fix Point Study");
		   
		// Tab Layout    
		comFPoints = new Composite(tfolder,SWT.NONE);
		comFPoints.setLayout(new FillLayout());
		
		comFPointsMain = new Composite(comFPoints, SWT.NONE);
		comFPointsMain.setLayout(new FormLayout());		
		
		comFPointsMainLeft = new Composite(comFPointsMain, SWT.NONE);
		comFPointsMainLeft.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_comFPointsMainLeft = new FormData(250,480);
		fd_comFPointsMainLeft.left = new FormAttachment(0,10);
		fd_comFPointsMainLeft.top = new FormAttachment(0,10);
		comFPointsMainLeft.setLayoutData(fd_comFPointsMainLeft);
		
		comFPointsMainRight = new Composite(comFPointsMain, SWT.NONE);
		comFPointsMainRight.setLayout(new FormLayout());
		FormData fd_comFPointsMainRight = new FormData(600,480);
		fd_comFPointsMainRight.top = new FormAttachment(0,10);
		fd_comFPointsMainRight.left = new FormAttachment(comFPointsMainLeft,10);
		fd_comFPointsMainRight.right = new FormAttachment(100,-10);
		comFPointsMainRight.setLayoutData(fd_comFPointsMainRight);
		
		comFPointsMainDown = new Composite(comFPointsMain, SWT.NONE);
		FormData fd_comFPointsMainDown = new FormData(0,100);
		fd_comFPointsMainDown.top = new FormAttachment(comFPointsMainLeft, 10);
		fd_comFPointsMainDown.left = new FormAttachment(0, 10);
		fd_comFPointsMainDown.right = new FormAttachment(100,-10);
		comFPointsMainDown.setLayout(new FillLayout(SWT.HORIZONTAL));
		comFPointsMainDown.setLayoutData(fd_comFPointsMainDown);		
		
		comFPointsMainRightUp = new Composite(comFPointsMainRight, SWT.NONE);
		comFPointsMainRightUp.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_comFPointsMainRightUp = new FormData();
		fd_comFPointsMainRightUp.top = new FormAttachment(0);
		fd_comFPointsMainRightUp.left = new FormAttachment(0);
		fd_comFPointsMainRightUp.right = new FormAttachment(100);
		comFPointsMainRightUp.setLayoutData(fd_comFPointsMainRightUp);
			
		comFPointsMainRightDown = new Composite(comFPointsMainRight, SWT.NONE);
		FormData fd_comFPointsMainRightDown = new FormData(0,150);
		fd_comFPointsMainRightDown.right = new FormAttachment(100);
		fd_comFPointsMainRightDown.top = new FormAttachment(comFPointsMainRightUp, 10);
		fd_comFPointsMainRightDown.left = new FormAttachment(0);
		fd_comFPointsMainRightDown.bottom = new FormAttachment(100);
		comFPointsMainRightDown.setLayout(new FillLayout(SWT.HORIZONTAL));
		comFPointsMainRightDown.setLayoutData(fd_comFPointsMainRightDown);
		
		
		
		grpFPointsInput = new Group(comFPointsMainRightUp, SWT.NONE);
		grpFPointsInput.setText("Input");
		grpFPointsInput.setLayout(new FormLayout());
			
		grpFPointsOutput = new Group(comFPointsMainRightDown, SWT.NONE);
		grpFPointsOutput.setText("Output");
		grpFPointsOutput.setLayout(new FormLayout());
			
		grpFPointsInformation = new Group(comFPointsMainLeft, SWT.NONE);
		grpFPointsInformation.setText("Information");
		grpFPointsInformation.setLayout(new FormLayout());
		
		grpFPointsStatus = new Group(comFPointsMainDown, SWT.NONE);
		grpFPointsStatus.setText("Status");
		grpFPointsStatus.setLayout(new FormLayout());
			
		txtFPointsStatus = new Text(grpFPointsStatus, SWT.MULTI | SWT.V_SCROLL);
		txtFPointsStatus.setEditable(false);
		FormData fd_txtFPointsStatus = new FormData();
		fd_txtFPointsStatus.bottom = new FormAttachment(100,-10);
		fd_txtFPointsStatus.right = new FormAttachment(100, -10);
		fd_txtFPointsStatus.top = new FormAttachment(0, 10);
		fd_txtFPointsStatus.left = new FormAttachment(0, 10);
		txtFPointsStatus.setLayoutData(fd_txtFPointsStatus);
		
		// Input Tab
		comFPointsInputTarget = new Composite(grpFPointsInput, SWT.NONE);
		FormData fd_comFPointsInputTarget = new FormData();
		fd_comFPointsInputTarget.left = new FormAttachment(0, 10);
		fd_comFPointsInputTarget.top = new FormAttachment(0, 0);
		fd_comFPointsInputTarget.bottom = new FormAttachment(100);
		comFPointsInputTarget.setLayoutData(fd_comFPointsInputTarget);
		
		lblFPointsInputTarget = new Label(comFPointsInputTarget, SWT.NONE);
		lblFPointsInputTarget.setBounds(0, 0, 51, 15);
		lblFPointsInputTarget.setText("Target");
		
		btnFPointsFixedpoint = new Button(comFPointsInputTarget, SWT.RADIO);
		btnFPointsFixedpoint.setBounds(0, 20, 87, 22);
		btnFPointsFixedpoint.setText("Fixed-Point");
		btnFPointsFixedpoint.setSelection(true);
		
		btnFPointsFixedpoint.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				btnFPointsK0.setText("k[0]");
				btnFPointsK1.setText("k[10]");
				btnFPointsK2.setText("k[5]");
				btnFPointsK3.setText("k[15]");
				lblFPointsOutputAFPoint.setText("Fixed-Point: x");
				
			}
		});
		
		
		btnFPointsAntifixedPoint = new Button(comFPointsInputTarget, SWT.RADIO);
		btnFPointsAntifixedPoint.setBounds(0, 40, 108, 22);
		btnFPointsAntifixedPoint.setText("Anti-Fixed-Point");
		
		btnFPointsAntifixedPoint.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				btnFPointsK0.setText("k[3]");
				btnFPointsK1.setText("k[9]");
				btnFPointsK2.setText("k[6]");
				btnFPointsK3.setText("k[11]");
				lblFPointsOutputAFPoint.setText("Anti-Fixed-Point: x");
				
			}
		});
		
		comFPointsInputKey = new Composite(grpFPointsInput, SWT.NONE);
		FormData fd_comFPointsInputKey = new FormData();
		fd_comFPointsInputKey.left = new FormAttachment(0, 142);
		fd_comFPointsInputKey.top = new FormAttachment(0);
		fd_comFPointsInputKey.bottom = new FormAttachment(100);
		comFPointsInputKey.setLayoutData(fd_comFPointsInputKey);
		
		lblFPointsInputKey = new Label(comFPointsInputKey, SWT.NONE);
		lblFPointsInputKey.setBounds(0, 0, 51, 15);
		lblFPointsInputKey.setText("Key");
		
		btnFPointsK0 = new Button(comFPointsInputKey, SWT.RADIO);
		btnFPointsK0.setBounds(0, 20, 51, 22);
		btnFPointsK0.setText("k[0]");
		btnFPointsK0.setSelection(true);
		
		btnFPointsK1 = new Button(comFPointsInputKey, SWT.RADIO);
		btnFPointsK1.setBounds(0, 40, 51, 22);
		btnFPointsK1.setText("k[10]");
		
		btnFPointsK2 = new Button(comFPointsInputKey, SWT.RADIO);
		btnFPointsK2.setBounds(55, 20, 49, 22);
		btnFPointsK2.setText("k[5]");
		
		btnFPointsK3 = new Button(comFPointsInputKey, SWT.RADIO);
		btnFPointsK3.setBounds(55, 40, 60, 22);
		btnFPointsK3.setText("k[15]");
		
		comFPointsInputM8 = new Composite(grpFPointsInput, SWT.NONE);
		fd_comFPointsInputKey.right = new FormAttachment(comFPointsInputM8, -6);
		FormData fd_comFPointsInputM8 = new FormData();
		fd_comFPointsInputM8.left = new FormAttachment(0, 273);
		fd_comFPointsInputM8.top = new FormAttachment(comFPointsInputTarget, 0, SWT.TOP);
		comFPointsInputM8.setLayoutData(fd_comFPointsInputM8);
		
		lblFPointsInputData = new Label(comFPointsInputM8, SWT.NONE);
		lblFPointsInputData.setText("Data");
		lblFPointsInputData.setBounds(0, 0, 24, 13);
		
		txtFPointsInputM8 = new Text(comFPointsInputM8, SWT.BORDER);
		txtFPointsInputM8.setBounds(0, 40, 120, 20);
		
		txtFPointsInputM8.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				lblFPointsInputM8cur.setText("("+txtFPointsInputM8.getText().length()+")");
			}	
		});
		
		lblFPointsInputM8 = new Label(comFPointsInputM8, SWT.NONE);
		lblFPointsInputM8.setText("m[8] (8 HexDigits):");
		txtFPointsInputM8.setTextLimit(8);
		lblFPointsInputM8.setBounds(0, 20, 120, 15);
		
		lblFPointsInputM8cur = new Label(comFPointsInputM8, SWT.NONE);
		lblFPointsInputM8cur.setText("(0)");
		lblFPointsInputM8cur.setBounds(125,43,24,13);
		
		// Output Tab
		
		comFPointsOutput = new Composite(grpFPointsOutput,SWT.NONE);
		comFPointsOutput.setLayout(new FillLayout());
		FormData fd_comFPointsOutput = new FormData();
		fd_comFPointsOutput.left = new FormAttachment(0, 10);
		fd_comFPointsOutput.top = new FormAttachment(0,10);
		fd_comFPointsOutput.bottom = new FormAttachment(0, 240);
		fd_comFPointsOutput.right = new FormAttachment(100,-10);
		comFPointsOutput.setLayoutData(fd_comFPointsOutput);
		
		
		tblFPointsOutputAFP = new Table(comFPointsOutput, SWT.NO_FOCUS | SWT.VIRTUAL);
		tblFPointsOutputAFP.setHeaderVisible(true);
		tblFPointsOutputAFP.setLinesVisible(true);
		
		TableColumn[] tblFPointsColumn = new TableColumn[34];
		tblFPointsColumn[0] = new TableColumn(tblFPointsOutputAFP, SWT.NONE);
		tblFPointsColumn[0].setWidth(45);
		tblFPointsColumn[0].setAlignment(SWT.CENTER);
		for (int i=1;i<33;i++){
			tblFPointsColumn[i] = new TableColumn(tblFPointsOutputAFP, SWT.NONE);
			tblFPointsColumn[i].setWidth(25);
			tblFPointsColumn[i].setAlignment(SWT.CENTER);
			tblFPointsColumn[i].setText(i+"");
			
		}
		tblFPointsColumn[33] = new TableColumn(tblFPointsOutputAFP, SWT.NONE);
		tblFPointsColumn[33].setWidth(70);
		tblFPointsColumn[33].setAlignment(SWT.CENTER);
		tblFPointsColumn[33].setText("DIST");
		
		TableItem[] tblFPointsItem = new TableItem[10];
		for (int i=0;i<10;i++){
			tblFPointsItem[i] = new TableItem(tblFPointsOutputAFP, SWT.BORDER);
		}
		cleanTable(tblFPointsOutputAFP);
		for (int i=0;i<10;i++){
			tblFPointsItem[i].setText(0, "m["+(i+8)+"]");
		}
			
		lblFPointsOutputAFPoint = new Label(grpFPointsOutput,SWT.None);
		FormData fd_lblFPointsOutputAFPoint = new FormData();
		fd_lblFPointsOutputAFPoint.left = new FormAttachment(0,10);
		fd_lblFPointsOutputAFPoint.right = new FormAttachment(100,-10);
		fd_lblFPointsOutputAFPoint.top = new FormAttachment(comFPointsOutput,10);
		lblFPointsOutputAFPoint.setLayoutData(fd_lblFPointsOutputAFPoint);
		lblFPointsOutputAFPoint.setText("Fixed Point: x");
		
		// Information Tab
		
		lblFPointsInfoDes = new Label(grpFPointsInformation,SWT.NONE);
		FormData fd_lblFPointsInfoDes = new FormData();
		fd_lblFPointsInfoDes.right = new FormAttachment(100,-10);
		fd_lblFPointsInfoDes.top = new FormAttachment(0,10);
		fd_lblFPointsInfoDes.left = new FormAttachment(0, 10);
		lblFPointsInfoDes.setLayoutData(fd_lblFPointsInfoDes);
		lblFPointsInfoDes.setText("A fixed-point F with respect to a key k\n" +
								  "is defined by DES(k;F) = F, whereas an\n"+
								  "anti-fixed-point A with respect to a key k\n" +
								  "is defined by DES(k;A) = com_A. The result\n" + 
								  "com_A is the bitwise complement of A.\n");
	
		lblFPointsInfoKey = new Label(grpFPointsInformation,SWT.NONE);
		FormData fd_lblFPointsInfoKey = new FormData();
		fd_lblFPointsInfoKey.right = new FormAttachment(100,-10);
		fd_lblFPointsInfoKey.top = new FormAttachment(lblFPointsInfoDes,10);
		fd_lblFPointsInfoKey.left = new FormAttachment(0, 10);
		lblFPointsInfoKey.setLayoutData(fd_lblFPointsInfoKey);
		lblFPointsInfoKey.setText("Key:\n" +
								"So far known, fixed-points (resp.\n" +
								"anti-fixed-points) only exist with respect\n" +
								"to the special keys k[0],k[5],k[10], and\n" +
								"k[15] (resp. k[3],k[6],k[9], and k[11]).");
			
		lblFPointsInfoM8 = new Label(grpFPointsInformation,SWT.NONE);
		FormData fd_lblFPointsInfoM8 = new FormData();
		fd_lblFPointsInfoM8.right = new FormAttachment(100,-10);
		fd_lblFPointsInfoM8.top = new FormAttachment(lblFPointsInfoKey,10);
		fd_lblFPointsInfoM8.left = new FormAttachment(0, 10);
		lblFPointsInfoM8.setLayoutData(fd_lblFPointsInfoM8);
		lblFPointsInfoM8.setText("m[i]:\n" +
								"The i-th intermediate round cipher of\n" +
								"en-/decryption process. The value m[8]\n" +
								"is user-defined due to the way, the\n" +
								"appropriate (anti-)fixed-points are\n" +
								"internally evaluated.");
						
		lblFPointsInfoTable = new Label(grpFPointsInformation,SWT.NONE);
		FormData fd_lblFPointsInfoTable = new FormData();
		fd_lblFPointsInfoTable.right = new FormAttachment(100,-10);
		fd_lblFPointsInfoTable.top = new FormAttachment(lblFPointsInfoM8,10);
		fd_lblFPointsInfoTable.left = new FormAttachment(0, 10);
		lblFPointsInfoTable.setLayoutData(fd_lblFPointsInfoTable);
		lblFPointsInfoTable.setText("Output Table:\n" +
								"The table only shows the 32 bit wide\n" +
								"round ciphers from m[8] to m[17],\n" +
								"since missing m[i] can be retrieved\n" +
								"using the relation m[i] = m[17-i] for\n" +
								"fixed-points (resp. m[i] = com_m[17-i]\n" +
								"for anti-fixed-points). For each column:\n" +
								"Adjacent bit-colors change iff their\n" +
								"bit-values change. The column DIST\n" +
								"reflects the Hamming distance between\n" +
								"rows m[i-1] and m[i].");
		
		// Action Buttons
		btnFPointsReset = new Button(comFPointsMain, SWT.NONE);
		FormData fd_btnFPointsReset = new FormData();
		fd_btnFPointsReset.top = new FormAttachment(comFPointsMainDown, 10);
		fd_btnFPointsReset.left = new FormAttachment(0, 10);
		btnFPointsReset.setLayoutData(fd_btnFPointsReset);
		btnFPointsReset.setText("Reset");
				
		btnFPointsReset.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				btnFPointsFixedpoint.setSelection(true);
				btnFPointsAntifixedPoint.setSelection(false);
				btnFPointsK0.setSelection(true);
				btnFPointsK0.setText("K[0]");
				btnFPointsK1.setSelection(false);
				btnFPointsK1.setText("K[10]");
				btnFPointsK2.setSelection(false);
				btnFPointsK2.setText("K[5]");
				btnFPointsK3.setSelection(false);
				btnFPointsK3.setText("K[15]");
				txtFPointsInputM8.setText("");
				cleanTable(tblFPointsOutputAFP);
				lblFPointsOutputAFPoint.setText("Fixed Point: x");
				
				TableItem[] tblItems = tblFPointsOutputAFP.getItems();
				for (int i=0;i<10;i++){
					tblItems[i].setText(0, "m["+(i+8)+"]");
				}
				
				txtFPointsStatus.append(getCurrentTime()+" Data Reset\n");
			}
		});
		
		btnFPointsEvaluate = new Button(comFPointsMain, SWT.NONE);
		FormData fd_btnFPointsEvaluate = new FormData();
		fd_btnFPointsEvaluate.top = new FormAttachment(comFPointsMainDown, 10);
		fd_btnFPointsEvaluate.left = new FormAttachment(btnFPointsReset, 10);
		btnFPointsEvaluate.setLayoutData(fd_btnFPointsEvaluate);
		btnFPointsEvaluate.setText("Evaluate");
		
		btnFPointsEvaluate.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				DESCon.FPoints_In_FixedPoints = btnFPointsFixedpoint.getSelection();
				DESCon.FPoints_In_M8 = txtFPointsInputM8.getText();
				String err = "";
				
				if (btnFPointsK0.getSelection()&&btnFPointsK0.getText().equals("K[0]")){
					DESCon.FPoints_In_selectedKey = 0;
				} else if (btnFPointsK0.getSelection()&&btnFPointsK0.getText().equals("K[3]")){
					DESCon.FPoints_In_selectedKey = 0;
				} else if (btnFPointsK1.getSelection()&&btnFPointsK1.getText().equals("K[10]")){
					DESCon.FPoints_In_selectedKey = 10;
				} else if (btnFPointsK1.getSelection()&&btnFPointsK1.getText().equals("K[9]")){
					DESCon.FPoints_In_selectedKey = 9;
				} else if (btnFPointsK2.getSelection()&&btnFPointsK2.getText().equals("K[5]")){
					DESCon.FPoints_In_selectedKey = 5;
				} else if (btnFPointsK2.getSelection()&&btnFPointsK2.getText().equals("K[6]")){
					DESCon.FPoints_In_selectedKey = 6;
				} else if (btnFPointsK3.getSelection() && btnFPointsK3.getText().equals("K[15]")){
					DESCon.FPoints_In_selectedKey = 15;
				} else if (btnFPointsK3.getSelection() && btnFPointsK3.getText().equals("K[11]")){
					DESCon.FPoints_In_selectedKey = 11;
				}
				 
				if (DESCon.FPointsStudy()==0){
					txtFPointsStatus.append(getCurrentTime()+" Anti-/Fixed Point Calculations with m[8]="+txtFPointsInputM8.getText()+"\n");
					fillTable(tblFPointsOutputAFP,0,9, 1, 32, DESCon.FPoints_Out_M8M17);
					if (btnFPointsFixedpoint.getSelection()){
						lblFPointsOutputAFPoint.setText("Fixed Point: "+DESCon.FPoints_Out_AFpoints);
					} else {
						lblFPointsOutputAFPoint.setText("Anti-Fixed Point: "+DESCon.FPoints_Out_AFpoints);
					}
					colorTable(tblFPointsOutputAFP,1);
					for (int i=1;i<tblFPointsOutputAFP.getItemCount();i++){
						tblFPointsOutputAFP.getItem(i).setText(tblFPointsOutputAFP.getColumnCount()-1, Integer.toString(DESCon.FPoints_Out_Distances[i]));
					}		
				} else {
					for (int i=0;i<DESCon.errMsg.length;i++){
						if (i!=DESCon.errMsg.length-1){
							err += DESCon.errMsg[i]+", ";
						} else {
							err += DESCon.errMsg[i];
						}
					}
					txtFPointsStatus.append(getCurrentTime()+" "+err+"\n");
					
				}
			}
		});
							
			
		tabFPoints.setControl(comFPoints);
	}
	
	
	private void createSBoxTab() {
		tabSBox = new TabItem(tfolder,SWT.NONE);
		tabSBox.setText("S-Box Study");
		   
		// Tab Layout    
		comSBox = new Composite(tfolder,SWT.NONE);
		comSBox.setLayout(new FillLayout());
			
		comSBoxMain = new Composite(comSBox, SWT.NONE);
		comSBoxMain.setLayout(new FormLayout());		
		
		comSBoxMainLeft = new Composite(comSBoxMain, SWT.NONE);
		comSBoxMainLeft.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_comSBoxMainLeft = new FormData(250,480);
		fd_comSBoxMainLeft.left = new FormAttachment(0,10);
		fd_comSBoxMainLeft.top = new FormAttachment(0,10);
		comSBoxMainLeft.setLayoutData(fd_comSBoxMainLeft);
		
		comSBoxMainRight = new Composite(comSBoxMain, SWT.NONE);
		comSBoxMainRight.setLayout(new FormLayout());
		FormData fd_comSBoxMainRight = new FormData(600,480);
		fd_comSBoxMainRight.top = new FormAttachment(0,10);
		fd_comSBoxMainRight.left = new FormAttachment(comSBoxMainLeft,10);
		fd_comSBoxMainRight.right = new FormAttachment(100,-10);
		comSBoxMainRight.setLayoutData(fd_comSBoxMainRight);
		
		comSBoxMainDown = new Composite(comSBoxMain, SWT.NONE);
		FormData fd_comSBoxMainDown = new FormData(0,100);
		fd_comSBoxMainDown.top = new FormAttachment(comSBoxMainLeft, 10);
		fd_comSBoxMainDown.left = new FormAttachment(0, 10);
		fd_comSBoxMainDown.right = new FormAttachment(100,-10);
		comSBoxMainDown.setLayout(new FillLayout(SWT.HORIZONTAL));
		comSBoxMainDown.setLayoutData(fd_comSBoxMainDown);		
		
		comSBoxMainRightUp = new Composite(comSBoxMainRight, SWT.NONE);
		comSBoxMainRightUp.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_comSBoxMainRightUp = new FormData();
		fd_comSBoxMainRightUp.top = new FormAttachment(0);
		fd_comSBoxMainRightUp.left = new FormAttachment(0);
		fd_comSBoxMainRightUp.right = new FormAttachment(100);
		comSBoxMainRightUp.setLayoutData(fd_comSBoxMainRightUp);
			
		comSBoxMainRightDown = new Composite(comSBoxMainRight, SWT.NONE);
		FormData fd_comSBoxMainRightDown = new FormData(0,150);
		fd_comSBoxMainRightDown.right = new FormAttachment(100);
		fd_comSBoxMainRightDown.top = new FormAttachment(comSBoxMainRightUp, 10);
		fd_comSBoxMainRightDown.left = new FormAttachment(0);
		fd_comSBoxMainRightDown.bottom = new FormAttachment(100);
		comSBoxMainRightDown.setLayout(new FillLayout(SWT.HORIZONTAL));
		comSBoxMainRightDown.setLayoutData(fd_comSBoxMainRightDown);
			
		grpSBoxInput = new Group(comSBoxMainRightUp, SWT.NONE);
		grpSBoxInput.setText("Input");
		grpSBoxInput.setLayout(new FormLayout());
			
		grpSBoxOutput = new Group(comSBoxMainRightDown, SWT.NONE);
		grpSBoxOutput.setText("Output");
		grpSBoxOutput.setLayout(null);
			
		grpSBoxInformation = new Group(comSBoxMainLeft, SWT.NONE);
		grpSBoxInformation.setLayout(new FormLayout());
		grpSBoxInformation.setText("Information");
		
		grpSBoxStatus = new Group(comSBoxMainDown, SWT.NONE);
		grpSBoxStatus.setText("Status");
		grpSBoxStatus.setLayout(new FormLayout());
		
		txtSBoxStatus = new Text(grpSBoxStatus, SWT.MULTI | SWT.V_SCROLL);
		txtSBoxStatus.setEditable(false);
		FormData fd_txtSBoxStatus = new FormData();
		fd_txtSBoxStatus.bottom = new FormAttachment(100,-10);
		fd_txtSBoxStatus.right = new FormAttachment(100, -10);
		fd_txtSBoxStatus.top = new FormAttachment(0, 10);
		fd_txtSBoxStatus.left = new FormAttachment(0, 10);
		txtSBoxStatus.setLayoutData(fd_txtSBoxStatus);
		
		// Input Tab
		comSBoxInput = new Composite(grpSBoxInput, SWT.NONE);
		FormData fd_comSBoxInput = new FormData();
		fd_comSBoxInput.right = new FormAttachment(0, 254);
		fd_comSBoxInput.bottom = new FormAttachment(100);
		fd_comSBoxInput.top = new FormAttachment(0);
		fd_comSBoxInput.left = new FormAttachment(0, 10);
		comSBoxInput.setLayoutData(fd_comSBoxInput);
		
		lblSBoxInputData = new Label(comSBoxInput, SWT.NONE);
		lblSBoxInputData.setBounds(0, 0, 51, 13);
		lblSBoxInputData.setText("Data");
		
		lblSBoxInputDeltap = new Label(comSBoxInput, SWT.NONE);
		lblSBoxInputDeltap.setBounds(0, 19, 181, 15);
		lblSBoxInputDeltap.setText("Delta_p (16 HexDigits):");
		
		lblSBoxInputDeltapCur = new Label(comSBoxInput, SWT.NONE);
		lblSBoxInputDeltapCur.setBounds(185, 43, 50, 20);
		lblSBoxInputDeltapCur.setText("(0)");
		
		txtSBoxInputDeltap = new Text(comSBoxInput, SWT.BORDER);
		txtSBoxInputDeltap.setBounds(0, 38, 181, 20);
		txtSBoxInputDeltap.setTextLimit(16);
		
		txtSBoxInputDeltap.addModifyListener(new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				lblSBoxInputDeltapCur.setText("("+txtSBoxInputDeltap.getText().length()+")");
				
			}
			
		});
		
		
		comSBoxInputDataSeries = new Composite(grpSBoxInput,SWT.NONE);
		FormData fd_comSBoxInputDataSeries = new FormData();
		fd_comSBoxInputDataSeries.bottom = new FormAttachment(100);
		fd_comSBoxInputDataSeries.top = new FormAttachment(0);
		fd_comSBoxInputDataSeries.left = new FormAttachment(comSBoxInput, 10);
		comSBoxInputDataSeries.setLayoutData(fd_comSBoxInputDataSeries);
		
		lblSBoxInputSeries = new Label(comSBoxInputDataSeries,SWT.NONE);
		lblSBoxInputSeries.setBounds(0, 0, 150, 13);
		lblSBoxInputSeries.setText("Series Options");
		
		slSBoxInputSeriesTime = new Slider(comSBoxInputDataSeries, SWT.NONE);
		slSBoxInputSeriesTime.setBounds(0, 43, 120, 15); 
		slSBoxInputSeriesTime.setMinimum(1);
		slSBoxInputSeriesTime.setMaximum(1000);
		slSBoxInputSeriesTime.setSelection(100);
		
		slSBoxInputSeriesTime.addSelectionListener( new SelectionAdapter(){
			
			public void widgetSelected(SelectionEvent e) {
				lblSBoxInputSeriesTime.setText("Step Time in ms: "  + slSBoxInputSeriesTime.getSelection());
			}
		});
		
		lblSBoxInputSeriesTime = new Label(comSBoxInputDataSeries,SWT.NONE);
		lblSBoxInputSeriesTime.setBounds(0, 19, 181, 13);
		lblSBoxInputSeriesTime.setText("Step Time in ms: " + slSBoxInputSeriesTime.getSelection());
		
		slSBoxInputSeriesCount = new Slider(comSBoxInputDataSeries, SWT.NONE);
		slSBoxInputSeriesCount.setBounds(180, 43, 120, 15); 
		slSBoxInputSeriesCount.setMinimum(1);
		slSBoxInputSeriesCount.setMaximum(200);
		slSBoxInputSeriesCount.setSelection(20);
		
		slSBoxInputSeriesCount.addSelectionListener( new SelectionAdapter(){
			
			public void widgetSelected(SelectionEvent e) {
				lblSBoxInputSeriesCount.setText("Step Count: " + slSBoxInputSeriesCount.getSelection());
			}
		});
		
		
		lblSBoxInputSeriesCount = new Label(comSBoxInputDataSeries,SWT.NONE);
		lblSBoxInputSeriesCount.setBounds(180, 19, 181, 13);
		lblSBoxInputSeriesCount.setText("Step Count: " + slSBoxInputSeriesCount.getSelection());
		
		
		// Output Tab
		tblSBoxOutput = new Table(grpSBoxOutput,SWT.NO_FOCUS | SWT.VIRTUAL);
		tblSBoxOutput.setHeaderVisible(true);
		tblSBoxOutput.setLinesVisible(true);
		
		TableColumn[] tblSBoxColumn = new TableColumn[8];
		for (int i=0;i<8;i++){
			tblSBoxColumn[i] = new TableColumn(tblSBoxOutput, SWT.BORDER);
			tblSBoxColumn[i].setWidth(30);
			tblSBoxColumn[i].setAlignment(SWT.CENTER);
			tblSBoxColumn[i].setText("S"+(i+1));
			
		}
		
		TableItem[] tblSBoxItem = new TableItem[16];
		for (int i=0;i<16;i++){
			tblSBoxItem[i] = new TableItem(tblSBoxOutput, SWT.BORDER);
		}
		cleanTable(tblSBoxOutput);
				
		tblSBoxOutput.setBounds(10, 20, 245, 345);
		
		lblSBoxOutputCurStep = new Label(grpSBoxOutput, SWT.NONE);
		lblSBoxOutputCurStep.setBounds(300, 50, 200, 20);
		lblSBoxOutputCurStep.setText("Current Step: 0");
		
		lblSBoxOutputP = new Label(grpSBoxOutput, SWT.NONE);
		lblSBoxOutputP.setBounds(300, 80, 200, 20);
		lblSBoxOutputP.setText("Random p: x");
		
		lblSBoxOutputK = new Label(grpSBoxOutput, SWT.NONE);
		lblSBoxOutputK.setBounds(300,110,200,20);
		lblSBoxOutputK.setText("Random k: x");
		
		// Information Tab
		lblSBoxInfoDes = new Label(grpSBoxInformation,SWT.NONE);
		FormData fd_lblSboxInfoDes = new FormData();
		fd_lblSboxInfoDes.right = new FormAttachment(100,-10);
		fd_lblSboxInfoDes.top = new FormAttachment(0,10);
		fd_lblSboxInfoDes.left = new FormAttachment(0, 10);
		lblSBoxInfoDes.setLayoutData(fd_lblSboxInfoDes);
		lblSBoxInfoDes.setText("A (randomly selected) plaintext p\n" +
					"and another plaintext p + Delta_p\n" +
					"undergo an encryption under the\n" +
					"same (randomly selected) key k.\n" +
					"Each of these plaintexts generates\n" +
					"inputs in each of the 16 rounds for the 8\n" +
					"S-Boxes S1, ..., S8. The 16 x 8 matrix\n" +
					"visualizes by its cell colors whether\n" +
					"these inputs are (per round and per\n" +
					"S-Box) the same (yellow) or not the\n" +
					"same (red). Hence the overall color\n" +
					"pattern reflects the spread (avalanche)\n" +
					"of the input-difference Delta_p over\n" +
					"the whole encryption process.");
		
		lblSBoxInfoDeltap = new Label(grpSBoxInformation,SWT.NONE);
		FormData fd_lblSBoxInfoDeltap = new FormData();
		fd_lblSBoxInfoDeltap.right = new FormAttachment(100,-10);
		fd_lblSBoxInfoDeltap.top = new FormAttachment(lblSBoxInfoDes,10);
		fd_lblSBoxInfoDeltap.left = new FormAttachment(0, 10);
		lblSBoxInfoDeltap.setLayoutData(fd_lblSBoxInfoDeltap);
		lblSBoxInfoDeltap.setText("Delta_p:\nDifference between the two inputs.");
		
		lblSBoxInfoRandomP = new Label(grpSBoxInformation,SWT.NONE);
		FormData fd_lblSBoxInfoRandomP = new FormData();
		fd_lblSBoxInfoRandomP.right = new FormAttachment(100,-10);
		fd_lblSBoxInfoRandomP.top = new FormAttachment(lblSBoxInfoDeltap,10);
		fd_lblSBoxInfoRandomP.left = new FormAttachment(0, 10);
		lblSBoxInfoRandomP.setLayoutData(fd_lblSBoxInfoRandomP);
		lblSBoxInfoRandomP.setText("Random p:\nA randomly choosen plaintext");
				
		lblSBoxInfoRandomK = new Label(grpSBoxInformation,SWT.NONE);
		FormData fd_lblSBoxInfoRandomK = new FormData();
		fd_lblSBoxInfoRandomK.right = new FormAttachment(100,-10);
		fd_lblSBoxInfoRandomK.top = new FormAttachment(lblSBoxInfoRandomP,10);
		fd_lblSBoxInfoRandomK.left = new FormAttachment(0, 10);
		lblSBoxInfoRandomK.setLayoutData(fd_lblSBoxInfoRandomK);
		lblSBoxInfoRandomK.setText("Random k:\nA randomly choosen key.");
		
		lblSBoxInfoYBox = new Label(grpSBoxInformation,SWT.NONE);
		FormData fd_lblSBoxInfoYBox = new FormData();
		fd_lblSBoxInfoYBox.right = new FormAttachment(100,-10);
		fd_lblSBoxInfoYBox.top = new FormAttachment(lblSBoxInfoRandomK,10);
		fd_lblSBoxInfoYBox.left = new FormAttachment(0, 10);
		lblSBoxInfoYBox.setLayoutData(fd_lblSBoxInfoYBox);
		lblSBoxInfoYBox.setText("Yellow S-Box:\nS-Box with the same input feeds.");
		
		lblSBoxInfoRBox = new Label(grpSBoxInformation,SWT.NONE);
		FormData fd_lblSBoxInfoRBox = new FormData();
		fd_lblSBoxInfoRBox.right = new FormAttachment(100,-10);
		fd_lblSBoxInfoRBox.top = new FormAttachment(lblSBoxInfoYBox,10);
		fd_lblSBoxInfoRBox.left = new FormAttachment(0, 10);
		lblSBoxInfoRBox.setLayoutData(fd_lblSBoxInfoRBox);
		lblSBoxInfoRBox.setText("Red S-Box:\nS-Box with different input feeds.");
		
		
		// Action Buttons
		btnSBoxReset = new Button(comSBoxMain, SWT.NONE);
		FormData fd_btnSBoxReset = new FormData();
		fd_btnSBoxReset.top = new FormAttachment(comSBoxMainDown, 10);
		fd_btnSBoxReset.left = new FormAttachment(0, 10);
		btnSBoxReset.setLayoutData(fd_btnSBoxReset);
		btnSBoxReset.setText("Reset");
		
		btnSBoxReset.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				txtSBoxStatus.append(getCurrentTime()+" Data Reset\n");
				txtSBoxInputDeltap.setText("");
				lblSBoxOutputCurStep.setText("Current Step: 0");
				intSBoxOutputCurStep = 0;
				lblSBoxOutputP.setText("Random P: x");
				lblSBoxOutputK.setText("Random K: x");
				slSBoxInputSeriesCount.setSelection(20);
				slSBoxInputSeriesTime.setSelection(100);
				lblSBoxInputSeriesCount.setText("Step Count: 20");
				lblSBoxInputSeriesTime.setText("Step Time in ms: 100");
				cleanTable(tblSBoxOutput);
				txtSBoxInputDeltap.setEnabled(true);
				slSBoxInputSeriesTime.setEnabled(true);
				slSBoxInputSeriesCount.setEnabled(true);
				cleanTable(tblSBoxOutput);
			}
		});
		
		
				
		btnSBoxEvaluate = new Button(comSBoxMain, SWT.NONE);
		FormData fd_btnSBoxEvaluate = new FormData();
		fd_btnSBoxEvaluate.top = new FormAttachment(comSBoxMainDown, 10);
		fd_btnSBoxEvaluate.left = new FormAttachment(btnSBoxReset, 10);
		btnSBoxEvaluate.setLayoutData(fd_btnSBoxEvaluate);
		btnSBoxEvaluate.setText("Evaluate");
		
		btnSBoxEvaluate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DESCon.SBox_In_Deltap = txtSBoxInputDeltap.getText();
				String err = "";
				
				if (DESCon.SBoxStudy()==0){
					txtSBoxStatus.append(getCurrentTime()+" S-Box Evaluation: Delta_P="+txtSBoxInputDeltap.getText()+"\n");
					txtSBoxInputDeltap.setEnabled(false);
					intSBoxOutputCurStep++;
					lblSBoxOutputCurStep.setText("Current Step: "+intSBoxOutputCurStep);
					lblSBoxOutputP.setText("Random P: "+DESCon.SBox_Out_randomm);
					lblSBoxOutputK.setText("Random K: "+DESCon.SBox_Out_randomk);
					fillTable(tblSBoxOutput, 0, 15, 0, 7, DESCon.SBox_Out_activeBoxes);
					colorTable(tblSBoxOutput,0);
				} else {
					for (int i=0;i<DESCon.errMsg.length;i++){
						if (i!=DESCon.errMsg.length-1){
							err += DESCon.errMsg[i]+", ";
						} else {
							err += DESCon.errMsg[i];
						}
					}
					txtSBoxStatus.append(getCurrentTime()+" "+err+"\n");
					
				}
			}
		});
		
		btnSBoxEvaluateSeries = new Button(comSBoxMain, SWT.NONE);
		FormData fd_btnSBoxEvaluateSeries = new FormData();
		fd_btnSBoxEvaluateSeries.top = new FormAttachment(comSBoxMainDown, 10);
		fd_btnSBoxEvaluateSeries.left = new FormAttachment(btnSBoxEvaluate, 10);
		btnSBoxEvaluateSeries.setLayoutData(fd_btnSBoxEvaluateSeries);
		btnSBoxEvaluateSeries.setText("Evaluate Series");
		btnSBoxEvaluateSeries.setAlignment(SWT.CENTER);
		
		btnSBoxEvaluateSeries.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String err = "";
				DESCon.SBox_In_Deltap = txtSBoxInputDeltap.getText();			
				Display curdis = Display.getCurrent();
							
				if (DESCon.SBoxStudy()==0){
					txtSBoxStatus.append(getCurrentTime()+" S-Box Evaluation Series: Delta_P="+txtSBoxInputDeltap.getText()+", Steps="+slSBoxInputSeriesCount.getSelection()+", Time="+slSBoxInputSeriesTime.getSelection()+"\n");
					txtSBoxInputDeltap.setEnabled(false);
					slSBoxInputSeriesTime.setEnabled(false);
					slSBoxInputSeriesCount.setEnabled(false);
					btnSBoxEvaluate.setEnabled(false);
					btnSBoxReset.setEnabled(false);
					btnSBoxEvaluateSeries.setEnabled(false);

					for (int i=0;i<slSBoxInputSeriesCount.getSelection()-1;i++){
						intSBoxOutputCurStep++;
						lblSBoxOutputCurStep.setText("Current Step: "+intSBoxOutputCurStep);
						lblSBoxOutputP.setText("Random P: "+DESCon.SBox_Out_randomm);
						lblSBoxOutputK.setText("Random K: "+DESCon.SBox_Out_randomk);
						fillTable(tblSBoxOutput, 0, 15, 0, 7, DESCon.SBox_Out_activeBoxes);
						colorTable(tblSBoxOutput,0);
						tblSBoxOutput.redraw();
						tblSBoxOutput.update();
						curdis.update();
						try {
							Thread.sleep(slSBoxInputSeriesTime.getSelection());
						} catch (Exception ex){
							ex.printStackTrace();
						}
						DESCon.SBoxStudy();
					}		
					intSBoxOutputCurStep++;
					lblSBoxOutputCurStep.setText("Current Step: "+intSBoxOutputCurStep);
					
					slSBoxInputSeriesTime.setEnabled(true);
					slSBoxInputSeriesCount.setEnabled(true);
					btnSBoxEvaluate.setEnabled(true);
					btnSBoxReset.setEnabled(true);
					btnSBoxEvaluateSeries.setEnabled(true);
					
				} else {
					for (int i=0;i<DESCon.errMsg.length;i++){
						if (i!=DESCon.errMsg.length-1){
							err += DESCon.errMsg[i]+", ";
						} else {
							err += DESCon.errMsg[i];
						}
					}
					txtSBoxStatus.append(getCurrentTime()+" "+err+"\n");
				}
		
			}
		});
		
		
			
		tabSBox.setControl(comSBox);	
	}
	
	// Helper Functions
	
	private void fillTable(Table table, int start_row,  int end_row, int start_column, int end_column, int data[][]){; 
	    TableItem ti = null;
	    
		for(int r=start_row; r<=end_row; r++){
			for (int c=start_column;c<=end_column;c++){
				ti = table.getItem(r);
		    	ti.setText(c,Integer.toString((data[r-start_row][c-start_column])));
			}
	    } 	
	}
	
	private void colorTable(Table table,int mode){
		TableItem ti = null;
		TableItem tiOld = null;
		Display display = null;
		Color yellow = null;
		Color red = null;
		Color blue=null;
		Color gray =null;
		Color curColor = null;
		int i=0,j=0;
		
		display = Display.getCurrent();
		yellow = display.getSystemColor(SWT.COLOR_YELLOW);
		red = display.getSystemColor(SWT.COLOR_RED);
		blue = display.getSystemColor(SWT.COLOR_BLUE);
		gray = display.getSystemColor(SWT.COLOR_GRAY);
		
		// Coloring S-Box Tab
		if (mode==0){
			for (int r =0;r < table.getItemCount();r++){
				ti = table.getItem(r);
				for (int c=0;c < table.getColumnCount();c++){
					if (ti.getText(c).equals("1")){
						ti.setBackground(c,red);
					}
					else if (ti.getText(c).equals("0")){
						ti.setBackground(c,yellow);
					}
				}
			
			}
		// Coloring FPoints Tab, Alg Tab M0M17 Output, Alg Tab DES(k,p+e_i) Output (Bit Change Coloring)
		} else if (mode==1){
			for (int r=1;r< table.getItemCount();r++){
				ti = table.getItem(r);
				tiOld = table.getItem(r-1);
				for (int c=1;c < table.getColumnCount()-1;c++){
					if (!(ti.getText(c).equals(tiOld.getText(c)))){
						ti.setForeground(c, red);
					}
				}
			}
		// Coloring Alg Tab Roundkeys Output
		} else if (mode==2){
			
		// Coloring Alg Tab CD Matrix Output
		} else if (mode==3){
			while (i<table.getItemCount()){
				curColor = j%2 == 0 ? yellow : gray;
				for (int c=0;c< table.getColumnCount();c++){
					ti = table.getItem(i);
					ti.setBackground(c,curColor);
					ti = table.getItem(i+1);
					ti.setBackground(c,curColor);
				}
				i = i + 2;
				j++;
			}
		}
		
	}
		
	private String[] intArrayToStringArray(int[] ar){
		String[] strAr = new String[ar.length];
		
		for (int i=0;i<ar.length;i++){
			strAr[i] = Integer.toString(ar[i]);
		}
		
		return strAr;
	}
		
	private void cleanTable(Table table){
		TableItem[] items = table.getItems();
		Color white = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
		Color gray = Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
		String[] str = new String[table.getColumnCount()];
		
		for (int i=0;i<str.length;i++){
			str[i] = " ";
		}
		
		for (int i=0;i<table.getItemCount();i++){
			items[i].setText(str);
			for (int j=0;j<table.getColumnCount();j++){
				
				if ((i%2)==0){
					items[i].setBackground(j,white);
				} else {
					items[i].setBackground(j,gray);
				}
			}
		}
	}
	
	private String getCurrentTime(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		
		return df.format(d);
	}
		
		
	
}
