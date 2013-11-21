package mrMarco_gui;
//Benjamin's Tester ProgramsÂ©


public class HC_Tester {

	public static void main(String[] args) {
	// allow them to chose
		int i = 1;
		if (i==1){
			System.out.println(" you chose LogMeIn");		
	        LogMeIn.initialize();	
		}else if (i == 2){
			System.out.println(" you chose Sample_Gui");
			Sample_Gui.initialize();
		}else
				main(args);
		
	}

}
