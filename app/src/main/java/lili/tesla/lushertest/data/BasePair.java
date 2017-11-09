package lili.tesla.lushertest.data;

/**
 * Created by Лилия on 09.11.2017.
 */

public class BasePair {
    private String indexId;
    private String description;

    public BasePair(String indexId) {
        this.indexId = indexId;
        this.description = "";
    }

    public String[] getIndexId() {
        String[] str = new String[1];
        str[0] = indexId;
        return str;
    }

    public String getIndex() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIndexTrue() {
        return (indexId.contains("0")&&indexId.contains("1")&&indexId.contains("2")&&indexId.contains("3"));
    }

}
