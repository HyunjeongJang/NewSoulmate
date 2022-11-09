package tk.newsoulmate.domain.vo;

import java.sql.Date;

public class Board {
    private int boardNo;
    private int memberNo;
    private String boardType;
    private String boardTitle;
    private String boardContent;
    private int readCount;
    private int reportNo;
    private String memberName;
    private Date createDate;
    private Date issueDate;
    private Board(){}
    /*
        새로운 생성자가 필요할시 생성자를 호출하게 하지말고 펙토리얼메소드를 호출하도록 작성할것
     */
    /**
     * 봉사 후기,입양 후기 글작성용 펙토리얼메소드
     * @param memberNo
     * @param issueDate
     * @param boardType
     * @param boardTitle
     * @param boardContent
     * @return
     */
    public static Board enrollBoard(int memberNo,Date issueDate,String boardType,String boardTitle,String boardContent ){
        Board b=new Board();
        b.setBoardTitle(boardTitle);
        b.setBoardContent(boardContent);
        b.setBoardType(boardType);
        b.setMemberNo(memberNo);
        return b;
    }

    /**
     * 신고접수용 펙토리얼메소드
     * @param memberNo
     * @param boardType
     * @param boardTitle
     * @param boardContent
     * @param reportNo 신고분류
     * @return
     */
    public static Board enrollReport(int memberNo,String boardType,String boardTitle,String boardContent,int reportNo){
        Board b=new Board();
        b.setBoardTitle(boardTitle);
        b.setBoardContent(boardContent);
        b.setBoardType(boardType);
        b.setMemberNo(memberNo);
        return b;
    }

    /**
     *  QnA FnA 리스트용 펙토리얼메소드
     * @param boardNo
     * @param boardTitle
     * @param createDate
     * @param readCount
     * @return
     */
    public static Board selectList(int boardNo,String boardTitle,Date createDate,int readCount){
        Board b=new Board();
        b.setBoardTitle(boardTitle);
        b.setBoardNo(boardNo);
        b.setCreateDate(createDate);
        b.setReadCount(readCount);
        return b;
    }

    /**
     * DB에서 입양후기리스트,봉사후기리스트를 불러오기 위한 생성함수
     * @param boardNo
     * @param boardTitle
     * @return
     */
    public static Board selectThumbList(int boardNo,String boardTitle){
        Board b=new Board();
        b.setBoardTitle(boardTitle);
        b.setBoardNo(boardNo);
        return b;
    }

    public static Board selectReviewDetail(int boardNo,String boardName,String boardTitle,Date createDate,Date issueDate,int readCount){
        Board b=new Board();
        b.setBoardNo(boardNo);
        b.setBoardTitle(boardTitle);
        b.setCreateDate(createDate);
        b.setReadCount(readCount);
        b.setIssueDate(issueDate);
        return b;
    }

    public static Board selectAdoptDetail(String boardTitle,String memberName,Date issueDate ,Date createDate,int readCount,String boardContent){
        Board b = new Board();
        b.setBoardTitle(boardTitle);
        b.setMemberName(memberName);
        b.setIssueDate(issueDate);
        b.setCreateDate(createDate);
        b.setReadCount(readCount);
        b.setBoardContent(boardContent);
        return b;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getReportNo() {
        return reportNo;
    }

    public void setReportNo(int reportNo) {
        this.reportNo = reportNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }


}
