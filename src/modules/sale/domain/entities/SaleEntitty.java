package modules.sale.domain.entities;
import java.util.HashMap;
import java.util.Map;

public class SaleEntitty {
    private int announcementId;
    private int userId;
    private int id = -1;
    private int sellerId;
    private String purchasePrice;

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String value) {
        this.purchasePrice = value;
    }

    public Map toMap(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("announcementId", this.announcementId);
        map.put("id", this.id);
        map.put("userId", this.userId);
        map.put("sellerId", this.sellerId);
        map.put("purchasePrice", this.purchasePrice);

        return map;
    }

    public static SaleEntitty fromMap(Map<String, Object> map){

        SaleEntitty model = new SaleEntitty();
        model.setAnnouncementId((int) map.get("announcementId"));
        model.setId((int) map.get("id"));
        model.setSellerId((int) map.get("sellerId"));
        model.setPurchasePrice((String) map.get("purchasePrice"));
        model.setUserId((int) map.get("userId"));

        return model;
    }
}
