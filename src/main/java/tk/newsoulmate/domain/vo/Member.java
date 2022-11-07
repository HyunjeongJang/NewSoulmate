package tk.newsoulmate.domain.vo;

import java.sql.Date;

public class Member {
    private int memberNo;
    private String memberId;
    private String memberPwd;
    private String memberName;//
    private String Phone;//전화번호
    private String Email;//이메일
    private String nickName;//닉네임
    private MemberGreed memberGreed;//유저등급
    private long shelterNo;
    private Date resentConnection;//최근접속일
    private Date enrollDate;
    public Member() {
    }


    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public MemberGreed getMemberGreed() {
        return memberGreed;
    }

    public void setMemberGreed(MemberGreed memberGreed) {
        this.memberGreed = memberGreed;
    }

    public long getShelterNo() {
        return shelterNo;
    }

    public void setShelterNo(long shelterNo) {
        this.shelterNo = shelterNo;
    }

    public Date getResentConnection() {
        return resentConnection;
    }

    public void setResentConnection(Date resentConnection) {
        this.resentConnection = resentConnection;
    }
}
