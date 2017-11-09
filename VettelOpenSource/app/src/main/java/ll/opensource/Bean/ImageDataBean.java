package ll.opensource.Bean;

import java.util.List;

/**
 * Created by Percy on 11-9 0009.
 */

public class ImageDataBean {


    /**
     * responseCode : 0
     * responseMsg :
     * data : [{"fileName":"15101087699190.jpg","filetypeid":"381","format":"jpg","loanID":"4053367","padocId":"91245b767e4eb644216ac3136c06c4e3ea2","pagenum":"4"},{"fileName":"{527B2DA3-66BA-40A2-9643-E79C4130B4CE}.jpg","filetypeid":"381","format":"jpg","loanID":"4053367","padocId":"9121a9bb446ff474f2083612fc03377342a","pagenum":"1"},{"fileName":"{527B2DA3-66BA-40A2-9643-E79C4130B4CE}.jpg","filetypeid":"382","format":"jpg","loanID":"4053367","padocId":"9124f236d6a33b144eba36af95d49c2ecb8","pagenum":"3"},{"fileName":"{527B2DA3-66BA-40A2-9643-E79C4130B4CE}.jpg","filetypeid":"380","format":"jpg","loanID":"4053367","padocId":"9128f3b651a100d4b9db4cb78de51af4ce8","pagenum":"2"}]
     */

    private String responseCode;
    private String responseMsg;
    private List<DataBean> data;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ImageDataBean{" +
        "responseCode='" + responseCode + '\'' +
        ", responseMsg='" + responseMsg + '\'' +
        ", data=" + data +
        '}';
    }

    public static class DataBean {
        /**
         * fileName : 15101087699190.jpg
         * filetypeid : 381
         * format : jpg
         * loanID : 4053367
         * padocId : 91245b767e4eb644216ac3136c06c4e3ea2
         * pagenum : 4
         */

        private String fileName;
        private String filetypeid;
        private String format;
        private String loanID;
        private String padocId;
        private String pagenum;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFiletypeid() {
            return filetypeid;
        }

        public void setFiletypeid(String filetypeid) {
            this.filetypeid = filetypeid;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getLoanID() {
            return loanID;
        }

        public void setLoanID(String loanID) {
            this.loanID = loanID;
        }

        public String getPadocId() {
            return padocId;
        }

        public void setPadocId(String padocId) {
            this.padocId = padocId;
        }

        public String getPagenum() {
            return pagenum;
        }

        public void setPagenum(String pagenum) {
            this.pagenum = pagenum;
        }

        @Override
        public String toString() {
            return "DataBean{" +
            "fileName='" + fileName + '\'' +
            ", filetypeid='" + filetypeid + '\'' +
            ", format='" + format + '\'' +
            ", loanID='" + loanID + '\'' +
            ", padocId='" + padocId + '\'' +
            ", pagenum='" + pagenum + '\'' +
            '}';
        }
    }
}
