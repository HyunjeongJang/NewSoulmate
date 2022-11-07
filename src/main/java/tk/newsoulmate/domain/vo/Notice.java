package tk.newsoulmate.domain.vo;

import java.util.Date;

public class Notice{
    private long desertionNo;
    private String noticeNo;
    private String filename;
    private Date happenDt;
    private String happenPlace;
    private String  kindCd;
    private String color;
    private String age;
    private String  weight;
    private Date noticeSdt;
    private Date noticeEdt;
    private String popfile;
    private String processState ;
    private char sexCd;
    private char neuterYn;
    private String specialMark;
    private String careNm;
    private String careTel;
    private String careAddr;
    private String orgNm;
    private String chargeNm;
    private String officetel;

    public long getDesertionNo() {
        return desertionNo;
    }

    public void setDesertionNo(long desertionNo) {
        this.desertionNo = desertionNo;
    }

    public String getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getHappenDt() {
        return happenDt;
    }

    public void setHappenDt(Date happenDt) {
        this.happenDt = happenDt;
    }

    public String getHappenPlace() {
        return happenPlace;
    }

    public void setHappenPlace(String happenPlace) {
        this.happenPlace = happenPlace;
    }

    public String getKindCd() {
        return kindCd;
    }

    public void setKindCd(String kindCd) {
        this.kindCd = kindCd;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getNoticeSdt() {
        return noticeSdt;
    }

    public void setNoticeSdt(Date noticeSdt) {
        this.noticeSdt = noticeSdt;
    }

    public Date getNoticeEdt() {
        return noticeEdt;
    }

    public void setNoticeEdt(Date noticeEdt) {
        this.noticeEdt = noticeEdt;
    }

    public String getPopfile() {
        return popfile;
    }

    public void setPopfile(String popfile) {
        this.popfile = popfile;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public char getSexCd() {
        return sexCd;
    }

    public void setSexCd(char sexCd) {
        this.sexCd = sexCd;
    }

    public char getNeuterYn() {
        return neuterYn;
    }

    public void setNeuterYn(char neuterYn) {
        this.neuterYn = neuterYn;
    }

    public String getSpecialMark() {
        return specialMark;
    }

    public void setSpecialMark(String specialMark) {
        this.specialMark = specialMark;
    }

    public String getCareNm() {
        return careNm;
    }

    public void setCareNm(String careNm) {
        this.careNm = careNm;
    }

    public String getCareTel() {
        return careTel;
    }

    public void setCareTel(String careTel) {
        this.careTel = careTel;
    }

    public String getCareAddr() {
        return careAddr;
    }

    public void setCareAddr(String careAddr) {
        this.careAddr = careAddr;
    }

    public String getOrgNm() {
        return orgNm;
    }

    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    public String getChargeNm() {
        return chargeNm;
    }

    public void setChargeNm(String chargeNm) {
        this.chargeNm = chargeNm;
    }

    public String getOfficetel() {
        return officetel;
    }

    public void setOfficetel(String officetel) {
        this.officetel = officetel;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "desertionNo=" + desertionNo +
                ", noticeNo='" + noticeNo + '\'' +
                ", filename='" + filename + '\'' +
                ", happenDt=" + happenDt +
                ", happenPlace='" + happenPlace + '\'' +
                ", kindCd='" + kindCd + '\'' +
                ", color='" + color + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                ", noticeSdt=" + noticeSdt +
                ", noticeEdt=" + noticeEdt +
                ", popfile='" + popfile + '\'' +
                ", processState='" + processState + '\'' +
                ", sexCd=" + sexCd +
                ", neuterYn=" + neuterYn +
                ", specialMark='" + specialMark + '\'' +
                ", careNm='" + careNm + '\'' +
                ", careTel='" + careTel + '\'' +
                ", careAddr='" + careAddr + '\'' +
                ", orgNm='" + orgNm + '\'' +
                ", chargeNm='" + chargeNm + '\'' +
                ", officetel='" + officetel + '\'' +
                '}';
    }
}
