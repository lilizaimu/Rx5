package com.airlook.kwapp.rx5;

import java.util.List;

public class Translation {


    /**
     * status : 0
     * content : {"word_mean":["int. 哈喽，喂;你好，您好;表示问候;打招呼;","n. \u201c喂\u201d的招呼声或问候声;","vi. 喊\u201c喂\u201d;"]}
     */

    private int status;
    private ContentBean content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        private List<String> word_mean;

        public List<String> getWord_mean() {
            return word_mean;
        }

        public void setWord_mean(List<String> word_mean) {
            this.word_mean = word_mean;
        }
    }
}
