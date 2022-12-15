package app;

public class Constants {
	
	// input parameters

	public String depart = 		"GOULBURN";
	public String arrive = 		"WOLLONGONG";
	public String date_plan =	"30/12/2022";

	//application
	
	static int delay = 800;
	boolean is_headless = false;
	String browser_c = "chrome";
	String browser_f = "firefox";
	String base_uri="https://online.murrays.com.au/murrayscoaches/";
	String hub = "http://localhost:4444/wd/hub";
	String path_browser_f = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	

	// id for web elements
	
	public String route_id = 	"CbrWlg";
	public String depart_id = 	"ddOrigin";  
	public String arrive_id = 	"ddDestination";
	public String trip_id = 	"rad0";
	public String date_id =		"cal0";
		
	// relative xpath for web elements
	
	public String more_adult = 		"//*[@id='divAdult']//*[@class='more']";
	public String more_student = 	"//*[@id='panStudentPax']//*[@class='custom-num-input']//*[@class='more']";
	public String more_child = 		"//*[@class='input-tog input-tog-2']//*[@class='more']";
	public String child_text = 		"//*[@class='input-tog-ctrls']//*[contains(text(),'2-15 years')]";
	public String adult_pos = 		"//*[@id='divAdult']//a[@class='pos']";
	public String child_pos = 		"//*[@class='input-tog input-tog-2']//*[@class='pos']";
	public String student_pos = 	"//*[@id='panStudentPax']//a[@class='pos']";
	public String btn_do_booking = 	"//*[@id='btnContinue']";

	// page dates
	public String btn_confirm = 	"//*[@class='tdActive']//*[@class='price']";
	
	// page tickets
	public String btn_go_payment =	"//*[@id='btnContinueToPayment']";
	
	// page travellers, it's out of scope for this project
	
	public int delay() {
		return delay;
	}
	
	public String data(String x) {
		return x = "x-"+Math.random();
	}

	public long number() {
		long value = 0;
		return value = (long) (Math.random()*100000);
	}
	

}
