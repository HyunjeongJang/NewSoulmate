package tk.newsoulmate.domain.vo.response;
public class Header{
    private long reqNo;
    private String resultCode;
    private String resultMsg;
    private String errorMsg;

    public long getReqNo() {
        return reqNo;
    }

    public void setReqNo(long reqNo) {
        this.reqNo = reqNo;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
