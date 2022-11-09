package tk.newsoulmate.domain.vo;

import java.util.List;

public class ResponseMapper {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
    public class Response {
        private Header header;
        private Body body;

        public Header getHeader() {
            return header;
        }

        public void setHeader(Header header) {
            this.header = header;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

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
        public class Body{
            private Items items;
            private int totalCount;

            public int getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
            }

            public Items getItems() {
                return items;
            }

            public void setItems(Items items) {
                this.items = items;
            }
            public class Items{
                private List<Notice> item;
                public List<Notice> getItem() {
                    return item;
                }
                public void setItem(List<Notice> item) {
                    this.item = item;
                }
            }
        }

    }
}
