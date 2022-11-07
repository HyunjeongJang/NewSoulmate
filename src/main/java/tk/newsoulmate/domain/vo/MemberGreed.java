package tk.newsoulmate.domain.vo;

/**
 *
 */
public enum MemberGreed {
    USER("사용자",0),SHELTER_MANAGER("보호소관계자",1),SITE_MANAGER("사이트관리자",2);
    public String greedName;
    public int greedNumber;
    private MemberGreed(String greedName,int greedNumber){
        this.greedNumber=greedNumber;
        this.greedName=greedName;
    }

    public int getGreedNumber() {
        return greedNumber;
    }
}
