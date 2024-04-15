package customRecipeReply.dto;

public class ReplyDto {
	//private String m_id;
	private int cus_no;
    private int cus_re_no;
    private String cus_re_regdate;
    private String cus_re_content;
 /*   
    public String getM_id() {
        return m_id;
    }
    public void setM_id(String m_id) {
        this.m_id = m_id;
    }
*/    
    public int getCus_no() {
    	System.out.println("Dto getCus_no 진입");
    	return cus_no;
    }
    public void setCus_no(int cus_no) {
    	System.out.println("Dto setCus_no 진입");
    	this.cus_no = cus_no;
    }
    
    public int getCus_re_no() {
    	System.out.println("Dto getCus_re_no 진입");
    	return cus_re_no;
    }
    public void setCus_re_no(int cus_re_no) {
    	System.out.println("Dto setCus_re_no 진입");
    	this.cus_re_no = cus_re_no;
    }
    
    public String getCus_re_regdate() {
    	System.out.println("Dto getCus_re_regdate 진입");
    	return cus_re_regdate;
    }
    public void setCus_re_regdate(String cus_re_regdate) {
    	System.out.println("Dto setCus_re_regdate 진입");
    	this.cus_re_regdate = cus_re_regdate;
    }
    
    public String getCus_re_content() {
    	System.out.println("Dto getCus_re_content 진입");
        return cus_re_content;
    }
    public void setCus_re_content(String cus_re_content) {
    	System.out.println("Dto setCus_re_content 진입");
        this.cus_re_content = cus_re_content;
    }
    @Override
    public String toString() {
	return "ReplyDto [cus_no=" + cus_no + ", cus_re_no=" + cus_re_no + ", cus_re_no=" + cus_re_no + ", cus_re_regdate=" + cus_re_regdate + "]";
    }
}