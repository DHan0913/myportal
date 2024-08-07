package himedia.myportal.repositories.vo;

import java.util.Date;

public class BoardVo {
    private Long no;
    private String title;
    private String content;
    private Long hit;
    private String regDate;
    private Long userNo; // user.no 참조
    private String userName; // user.name
    private String imageName; // 추가할 이미지 이름 필드

    public BoardVo() {
    }

    public BoardVo(String title, String content, Long userNo) {
        this.title = title;
        this.content = content;
        this.userNo = userNo;
    }
    
    public BoardVo(Long no, String title, String content, Long hit, String regDate, Long userNo, String userName) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.regDate = regDate;
        this.userNo = userNo;
        this.userName = userName;
    }

    public BoardVo(Long no, String title, String content, Long hit, String regDate, Long userNo, String userName, String imageName) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.regDate = regDate;
        this.userNo = userNo;
        this.userName = userName;
        this.imageName = imageName;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content.replace("\n", "<br>");
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getHit() {
        return hit;
    }

    public void setHit(Long hit) {
        this.hit = hit;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regDate="
                + regDate + ", userNo=" + userNo + ", userName=" + userName + ", imageName=" + imageName + "]";
    }

}
