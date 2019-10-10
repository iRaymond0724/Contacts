package jia.entity;

public class Contacts {
	
    /*
     * 通讯录格式
  		BEGIN:VCARD
  		VERSION:3.0
  		N;CHARSET=UTF-8:张三
  		FN;CHARSET=UTF-8:张三
  		TEL;TYPE=CELL:12345678910
  		END:VCARD
  */
		/*
		 * TEL;HOME:1
TEL;WORK:2
TEL;PREF:3
TEL;WORK;FAX:4
TEL;HOME;FAX:5
TEL;PAGER:6
TEL;VOICE:7
EMAIL;HOME:home@gmail.com
EMAIL;WORK:321company@gmail.com
/*
 begin+version+N+FN+TEL+TEL_second+TEL_HOME+TEL_WORK+TEL_PREF+TEL_WORK_FAX+TEL_HOME_FAX+TEL_PAGER+
 TEL_VOICE+EMAIL_HOME+EMAIL_WORK+ADR_HOME+ADR_WORK+ADR_CHARSET+ORG+TITLE+URL+NOTE+BDAY+X_AIM+X_MSN+
 X_YAHOO+X_SKYPE+X_QQ+X_GOOGLE_TALK+X_ICQ+X_JABBER+end
 */

	private static String begin = "BEGIN:VCARD" + "\n";
	private static String version = "VERSION:3.0" + "\n";
	private String N = "N;CHARSET=UTF-8:";				// 0
	private String FN = "\n"+"FN;CHARSET=UTF-8:";		//0
	private String TEL = "\n" + "TEL;TYPE=CELL:";		//1
	private String TEL_second = "\n" + "TEL;CELL:";		//2
	private String TEL_HOME = "\n" + "TEL;HOME:";		//3
	private String TEL_WORK = "\n" + "TEL;WORK:";		//4
	private String TEL_PREF = "\n" + "TEL;PREF:";		//5
	private String TEL_WORK_FAX = "\n" + "TEL;WORK;FAX:";		//6
	private String TEL_HOME_FAX = "\n" + "TEL;HOME;FAX:";		//7
	private String TEL_PAGER = "\n" + "TEL;PAGER:";		//8
	private String TEL_VOICE = "\n" + "TEL;VOICE:";		//9
	private String EMAIL_HOME = "\n" + "EMAIL;HOME:";		//10
	private String EMAIL_WORK = "\n" + "EMAIL;WORK:";		//11
	
	//屬性名 + _all 代表 拼入的值
	private String N_all = "";
	private String FN_all = "";
	private String TEL_all = "";
	private String TEL_second_all = "";
	private String TEL_HOME_all = "";
	private String TEL_WORK_all = "";
	private String TEL_PREF_all = "";
	private String TEL_WORK_FAX_all = "";
	private String TEL_HOME_FAX_all = "";
	private String TEL_PAGER_all = "";
	private String TEL_VOICE_all = "";
	private String EMAIL_HOME_all = "";
	private String EMAIL_WORK_all = "";
	/*
	 * ADR;HOME;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;=E4=BD=8F=E5=AE=B6=E5=9C=B0=E5=9D=80;;;;
ADR;WORK;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;=E5=85=AC=E5=8F=B8=E4=BD=8F=E5=9D=80;;;;
ADR;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;=E5=85=B6=E4=BB=96=E4=BD=8F=E5=9D=80;;;;
	 */
	
	//插入地址後，後面還需加";;;;"
	private String ADR_HOME = "\n" + "ADR;HOME;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;"; 		//12
	private String ADR_WORK = "\n" + "ADR;WORK;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;";			//13
	private String ADR_CHARSET = "\n" + "ADR;CHARSET=UTF-8;ENCODING=QUOTED-PRINTABLE:;;";			//14
	
	private String ADR_HOME_all = "ADR_HOME";
	private String ADR_WORK_all = "ADR_WORK";
	private String ADR_CHARSET_all = "ADR_CHARSET";
	
	/*
	 ORG:Company
	TITLE:Position
	URL:www.123.com
	NOTE:Note 
	 */
	private String ORG = "\n" + "ORG:";			//15
	private String TITLE = "\n" + "TITLE:";			//16
	private String URL = "\n" + "URL:";			//17
	private String NOTE = "\n" + "NOTE:";			//18
	
	private String ORG_all = "";
	private String TITLE_all = "";
	private String URL_all = "";
	private String NOTE_all = "";
	/*
	 * BDAY:1904-10-09
	 */
	private String BDAY = "\n" + "BDAY:";			//19
	private String BDAY_all = "";
	/*
	 X-AIM:A instant messenger
X-MSN:Windows live
X-YAHOO:yahoo
X-SKYPE-USERNAME:skype
X-QQ:QQ
X-GOOGLE-TALK:Hangouts
X-ICQ:ICQ
X-JABBER:Jabber
	 */
	private String X_AIM = "\n" + "X-AIM:";			//20
	private String X_MSN = "\n" + "X-MSN:";			//21
	private String X_YAHOO = "\n" + "X-YAHOO:";			//22
	private String X_SKYPE = "\n" + "X-SKYPE-USERNAME:";			//23
	private String X_QQ = "\n" + "X-QQ:";			//24
	private String X_GOOGLE_TALK = "\n" + "X-GOOGLE-TALK:";			//25
	private String X_ICQ = "\n" + "X-ICQ:";			//26
	private String X_JABBER = "\n" + "X-JABBER:";			//27
	private static String end = "\n" + "END:VCARD" + "\n";			
	
	private String X_AIM_all = "";
	private String X_MSN_all = "";
	private String X_YAHOO_all = "";
	private String X_SKYPE_all = "";
	private String X_QQ_all = "";
	private String X_GOOGLE_TALK_all = "";
	private String X_ICQ_all = "";
	private String X_JABBER_all = "";
	
	public Contacts() {
	
	}
	
	public Contacts(String n, String fN, String tEL) {
		
		N = Auto_setN_Name(n);
		FN = Auto_setFN(fN);
		TEL = Auto_setTEL(tEL);
	}
	
	public Contacts(String n, String fN, String tEL, String tEL_second, String tEL_HOME, String tEL_WORK,
			String tEL_PREF, String tEL_WORK_FAX, String tEL_HOME_FAX, String tEL_PAGER, String tEL_VOICE,
			String eMAIL_HOME, String eMAIL_WORK, String aDR_HOME, String aDR_WORK, String aDR_CHARSET, String oRG,
			String tITLE, String uRL, String nOTE, String bDAY, String x_AIM, String x_MSN, String x_YAHOO,
			String x_SKYPE, String x_QQ, String x_GOOGLE_TALK, String x_ICQ, String x_JABBER) {
		
		N = Auto_setN_Name(n);
		FN = Auto_setFN(fN);
		TEL = Auto_setTEL(tEL);
		TEL_second = Auto_setTEL_second(tEL_second);
		TEL_HOME = Auto_setTEL_HOME(tEL_HOME);
		TEL_WORK = Auto_setTEL_WORK(tEL_WORK);
		TEL_PREF = Auto_setTEL_PREF(tEL_PREF);
		TEL_WORK_FAX = Auto_setTEL_WORK_FAX(tEL_WORK_FAX);
		TEL_HOME_FAX = Auto_setTEL_HOME_FAX(tEL_HOME_FAX);
		TEL_PAGER = Auto_setTEL_PAGER(tEL_PAGER);
		TEL_VOICE = Auto_setTEL_VOICE(tEL_VOICE);
		EMAIL_HOME = Auto_setEMAIL_HOME(eMAIL_HOME);
		EMAIL_WORK = Auto_setEMAIL_WORK(eMAIL_WORK);
		ADR_HOME = Auto_setADR_HOME(aDR_HOME);
		ADR_WORK = Auto_setADR_WORK(aDR_WORK);
		ADR_CHARSET = Auto_setADR_CHARSET(aDR_CHARSET);
		ORG = Auto_setORG(oRG);
		TITLE = Auto_setTITLE(tITLE);
		URL = Auto_setURL(uRL);
		NOTE = Auto_setNOTE(nOTE);
		BDAY = Auto_setBDAY(bDAY);
		X_AIM = Auto_setX_AIM(x_AIM);
		X_MSN = Auto_setX_MSN(x_MSN);
		X_YAHOO = Auto_setX_YAHOO(x_YAHOO);
		X_SKYPE = Auto_setX_SKYPE(x_SKYPE);
		X_QQ = Auto_setX_QQ(x_QQ);
		X_GOOGLE_TALK = Auto_setX_GOOGLE_TALK(x_GOOGLE_TALK);
		X_ICQ = Auto_setX_ICQ(x_ICQ);
		X_JABBER = Auto_setX_JABBER(x_JABBER);
	}

	public String getN() {
		return N;
	}
	public void setN_Name(String n) {
		N_all = N+n;
	}
	public String Auto_setN_Name(String n) {
		N_all = N+n;
		return N_all;
	}
	public String getFN() {
		return FN;
	}
	public void setFN(String fN) {
		FN_all = FN + fN;
	}
	public String Auto_setFN(String fN) {
		FN_all = FN + fN;
		return FN_all;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL_all = TEL + tEL;
	}
	public String Auto_setTEL(String tEL) {
		TEL_all = TEL + tEL;
		return TEL_all;
	}
	public String getTEL_second() {
		return TEL_second;
	}
	public void setTEL_second(String tEL_second) {
		TEL_second_all = TEL_second + tEL_second;
	}
	public String Auto_setTEL_second(String tEL_second) {
		TEL_second_all = TEL_second + tEL_second;
		return TEL_second_all;
	}
	public String getTEL_HOME() {
		return TEL_HOME;
	}
	public void setTEL_HOME(String tEL_HOME) {
		TEL_HOME_all = TEL_HOME + tEL_HOME;
	}
	public String Auto_setTEL_HOME(String tEL_HOME) {
		TEL_HOME_all = TEL_HOME + tEL_HOME;
		return TEL_HOME_all;
	}
	public String getTEL_WORK() {
		return TEL_WORK;
	}
	public void setTEL_WORK(String tEL_WORK) {
		TEL_WORK_all = TEL_WORK + tEL_WORK;
	}
	public String Auto_setTEL_WORK(String tEL_WORK) {
		TEL_WORK_all = TEL_WORK + tEL_WORK;
		return TEL_WORK_all;
	}
	public String getTEL_PREF() {
		return TEL_PREF;
	}
	public void setTEL_PREF(String tEL_PREF) {
		TEL_PREF_all = TEL_PREF + tEL_PREF;
	}
	public String Auto_setTEL_PREF(String tEL_PREF) {
		TEL_PREF_all = TEL_PREF + tEL_PREF;
		return TEL_PREF_all;
	}
	public String getTEL_WORK_FAX() {
		return TEL_WORK_FAX;
	}
	public void setTEL_WORK_FAX(String tEL_WORK_FAX) {
		TEL_WORK_FAX_all = TEL_WORK_FAX + tEL_WORK_FAX;
	}
	public String Auto_setTEL_WORK_FAX(String tEL_WORK_FAX) {
		TEL_WORK_FAX_all = TEL_WORK_FAX + tEL_WORK_FAX;
		return TEL_WORK_FAX_all;
	}
	public String getTEL_HOME_FAX() {
		return TEL_HOME_FAX;
	}
	public void setTEL_HOME_FAX(String tEL_HOME_FAX) {
		TEL_HOME_FAX_all = TEL_HOME_FAX + tEL_HOME_FAX;
	}
	public String Auto_setTEL_HOME_FAX(String tEL_HOME_FAX) {
		TEL_HOME_FAX_all = TEL_HOME_FAX + tEL_HOME_FAX;
		return TEL_HOME_FAX_all;
	}
	public String getTEL_PAGER() {
		return TEL_PAGER;
	}
	public void setTEL_PAGER(String tEL_PAGER) {
		TEL_PAGER_all = TEL_PAGER + tEL_PAGER;
	}
	public String Auto_setTEL_PAGER(String tEL_PAGER) {
		TEL_PAGER_all = TEL_PAGER + tEL_PAGER;
		return TEL_PAGER_all;
	}
	public String getTEL_VOICE() {
		return TEL_VOICE;
	}
	public void setTEL_VOICE(String tEL_VOICE) {
		TEL_VOICE_all = TEL_VOICE + tEL_VOICE;
	}
	public String Auto_setTEL_VOICE(String tEL_VOICE) {
		TEL_VOICE_all = TEL_VOICE + tEL_VOICE;
		return TEL_VOICE_all;
	}
	public String getEMAIL_HOME() {
		return EMAIL_HOME;
	}
	public void setEMAIL_HOME(String eMAIL_HOME) {
		EMAIL_HOME_all = EMAIL_HOME + eMAIL_HOME;
	}
	public String Auto_setEMAIL_HOME(String eMAIL_HOME) {
		EMAIL_HOME_all = EMAIL_HOME + eMAIL_HOME;
		return EMAIL_HOME_all;
	}
	public String getEMAIL_WORK() {
		return EMAIL_WORK;
	}
	public void setEMAIL_WORK(String eMAIL_WORK) {
		EMAIL_WORK_all = EMAIL_WORK + eMAIL_WORK;
	}
	public String Auto_setEMAIL_WORK(String eMAIL_WORK) {
		EMAIL_WORK_all = EMAIL_WORK + eMAIL_WORK;
		return EMAIL_WORK_all;
	}
	public String getADR_HOME() {
		return ADR_HOME;
	}
	public void setADR_HOME(String aDR_HOME) {
		  ADR_HOME_all = ADR_HOME + aDR_HOME + ";;;;";
		//ADR_HOME = ADR_HOME + aDR_HOME + ";;;;";
	}
	public String Auto_setADR_HOME(String aDR_HOME) {
		  ADR_HOME_all = ADR_HOME + aDR_HOME + ";;;;";
		//ADR_HOME = ADR_HOME + aDR_HOME + ";;;;";
		  return ADR_HOME_all;
	}
	public String getADR_WORK() {
		return ADR_WORK;
	}
	public void setADR_WORK(String aDR_WORK) {
		ADR_WORK_all = ADR_WORK + aDR_WORK + ";;;;";
		//ADR_WORK = ADR_WORK + aDR_WORK;
	}
	public String Auto_setADR_WORK(String aDR_WORK) {
		ADR_WORK_all = ADR_WORK + aDR_WORK + ";;;;";
		//ADR_WORK = ADR_WORK + aDR_WORK;
		return ADR_WORK_all;
	}
	public String getADR_CHARSET() {
		return ADR_CHARSET;
	}
	public void setADR_CHARSET(String aDR_CHARSET) {
		ADR_CHARSET_all = ADR_CHARSET + aDR_CHARSET + ";;;;";
		//ADR_CHARSET = ADR_CHARSET + aDR_CHARSET;
	}
	public String Auto_setADR_CHARSET(String aDR_CHARSET) {
		ADR_CHARSET_all = ADR_CHARSET + aDR_CHARSET + ";;;;";
		//ADR_CHARSET = ADR_CHARSET + aDR_CHARSET;
		return ADR_CHARSET_all;
	}
	public String getORG() {
		return ORG;
	}
	public void setORG(String oRG) {
		ORG_all = ORG + oRG;
	}
	public String Auto_setORG(String oRG) {
		ORG_all = ORG + oRG;
		return ORG_all;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE_all = TITLE + tITLE;
	}
	public String Auto_setTITLE(String tITLE) {
		TITLE_all = TITLE + tITLE;
		return TITLE_all;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL_all = URL + uRL;
	}
	public String Auto_setURL(String uRL) {
		URL_all = URL + uRL;
		return URL_all;
	}
	public String getNOTE() {
		return NOTE;
	}
	public void setNOTE(String nOTE) {
		NOTE_all = NOTE + nOTE;
	}
	public String Auto_setNOTE(String nOTE) {
		NOTE_all = NOTE + nOTE;
		return NOTE_all;
	}
	public String getBDAY() {
		return BDAY;
	}
	public void setBDAY(String bDAY) {
		BDAY_all = BDAY + bDAY;
	}
	public String Auto_setBDAY(String bDAY) {
		BDAY_all = BDAY + bDAY;
		return BDAY_all;
	}
	public String getX_AIM() {
		return X_AIM;
	}
	public void setX_AIM(String x_AIM) {
		X_AIM_all = X_AIM + x_AIM;
	}
	public String Auto_setX_AIM(String x_AIM) {
		X_AIM_all = X_AIM + x_AIM;
		return X_AIM_all;
	}
	public String getX_MSN() {
		return X_MSN;
	}
	public void setX_MSN(String x_MSN) {
		X_MSN_all = X_MSN + x_MSN;
	}
	public String Auto_setX_MSN(String x_MSN) {
		X_MSN_all = X_MSN + x_MSN;
		return X_MSN_all; 
	}
	public String getX_YAHOO() {
		return X_YAHOO;
	}
	public void setX_YAHOO(String x_YAHOO) {
		X_YAHOO_all = X_YAHOO + x_YAHOO;
	}
	public String Auto_setX_YAHOO(String x_YAHOO) {
		X_YAHOO_all = X_YAHOO + x_YAHOO;
		return X_YAHOO_all;
		
	}
	public String getX_SKYPE() {
		return X_SKYPE;
	}
	public void setX_SKYPE(String x_SKYPE) {
		X_SKYPE_all = X_SKYPE + x_SKYPE;
	}
	public String Auto_setX_SKYPE(String x_SKYPE) {
		X_SKYPE_all = X_SKYPE + x_SKYPE;
		return X_SKYPE_all;
	}
	public String getX_QQ() {
		return X_QQ;
	}
	public void setX_QQ(String x_QQ) {
		X_QQ_all = X_QQ + x_QQ;
	}
	public String Auto_setX_QQ(String x_QQ) {
		X_QQ_all = X_QQ + x_QQ;
		return X_QQ_all;
	}
	public String getX_GOOGLE_TALK() {
		return X_GOOGLE_TALK;
	}
	public void setX_GOOGLE_TALK(String x_GOOGLE_TALK) {
		X_GOOGLE_TALK_all = X_GOOGLE_TALK + x_GOOGLE_TALK;
	}
	public String Auto_setX_GOOGLE_TALK(String x_GOOGLE_TALK) {
		X_GOOGLE_TALK_all = X_GOOGLE_TALK + x_GOOGLE_TALK;
		return X_GOOGLE_TALK_all;
	}
	public String getX_ICQ() {
		return X_ICQ;
	}
	public void setX_ICQ(String x_ICQ) {
		X_ICQ_all = X_ICQ + x_ICQ;
	}
	public String Auto_setX_ICQ(String x_ICQ) {
		X_ICQ_all = X_ICQ + x_ICQ;
		return X_ICQ_all;
	}
	public String getX_JABBER() {
		return X_JABBER;
	}
	public void setX_JABBER(String x_JABBER) {
		X_JABBER_all = X_JABBER + x_JABBER;
	}
	public String Auto_setX_JABBER(String x_JABBER) {
		X_JABBER_all = X_JABBER + x_JABBER;
		return X_JABBER_all;
	}

	
	
	public String toString_1() {
		return "Contacts [N=" + N + ", FN=" + FN + ", TEL=" + TEL + "]";
	}
	
	@Override
	public String toString() {
		return "Contacts [N=" + N + ", FN=" + FN + ", TEL=" + TEL + ", TEL_second=" + TEL_second + ", TEL_HOME="
				+ TEL_HOME + ", TEL_WORK=" + TEL_WORK + ", TEL_PREF=" + TEL_PREF + ", TEL_WORK_FAX=" + TEL_WORK_FAX
				+ ", TEL_HOME_FAX=" + TEL_HOME_FAX + ", TEL_PAGER=" + TEL_PAGER + ", TEL_VOICE=" + TEL_VOICE
				+ ", EMAIL_HOME=" + EMAIL_HOME + ", EMAIL_WORK=" + EMAIL_WORK + ", ADR_HOME=" + ADR_HOME_all + ", ADR_WORK="
				+ ADR_WORK_all + ", ADR_CHARSET=" + ADR_CHARSET_all + ", ORG=" + ORG + ", TITLE=" + TITLE + ", URL=" + URL
				+ ", NOTE=" + NOTE + ", BDAY=" + BDAY + ", X_AIM=" + X_AIM + ", X_MSN=" + X_MSN + ", X_YAHOO=" + X_YAHOO
				+ ", X_SKYPE=" + X_SKYPE + ", X_QQ=" + X_QQ + ", X_GOOGLE_TALK=" + X_GOOGLE_TALK + ", X_ICQ=" + X_ICQ
				+ ", X_JABBER=" + X_JABBER + "]";
	}
	public String generateContact(Contacts contacts) {
		
		return( begin+version+N_all+FN+TEL_all+TEL_second_all+TEL_HOME_all+TEL_WORK_all+TEL_PREF_all+TEL_WORK_FAX_all+TEL_HOME_FAX_all+TEL_PAGER_all+
				 TEL_VOICE_all+EMAIL_HOME_all+EMAIL_WORK_all+ADR_HOME_all+ADR_WORK_all+ADR_CHARSET_all+ORG_all+TITLE_all+URL_all+NOTE_all+BDAY_all+X_AIM_all+X_MSN_all+
				 X_YAHOO_all+X_SKYPE_all+X_QQ_all+X_GOOGLE_TALK_all+X_ICQ_all+X_JABBER_all+end);
	}
	public String ori_generateContact(Contacts contacts) {
		return (begin
				+version
				+N
				+FN
				+TEL
				+end);
		
	}


}
