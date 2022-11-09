package tk.newsoulmate.domain.vo.response;
public class Header{
    private int reqNo;
    private int resultCode;
    private String resultMsg;
    private String errorMsg;

    public int getReqNo() {
        return reqNo;
    }

    public void setReqNo(int reqNo) {
        this.reqNo = reqNo;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
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
