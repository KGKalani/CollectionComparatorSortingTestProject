import java.util.Date;

/**
 * Created by Gayathri on 10/28/2017.
 */
public class AuditLog implements Comparable<AuditLog>{
    int id;
    String action;
    Date createdTimeStamp;
    Date modifiedTimeStamp;
    String createdBy;
    String modifiedBy;


    public AuditLog(int id, String action, Date createdTimeStamp, Date modifiedTimeStamp, String createdBy, String modifiedBy) {
        this.id = id;
        this.action = action;
        this.createdTimeStamp = createdTimeStamp;
        this.modifiedTimeStamp = modifiedTimeStamp;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Date getModifiedTimeStamp() {
        return modifiedTimeStamp;
    }

    public void setModifiedTimeStamp(Date modifiedTimeStamp) {
        this.modifiedTimeStamp = modifiedTimeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public int compareTo(AuditLog o) {
        /*Create - create*/
        if(this.getCreatedTimeStamp() != null && o.getCreatedTimeStamp() != null){
            return o.getCreatedTimeStamp().compareTo(this.getCreatedTimeStamp());

        }
        /*create - update*/
        else if(this.getCreatedTimeStamp() != null && o.getModifiedTimeStamp() != null){
            return o.getModifiedTimeStamp().compareTo(this.getCreatedTimeStamp());
        }
        /*update - create*/
        else if(this.getModifiedTimeStamp() != null && o.getCreatedTimeStamp() != null){
            return o.getCreatedTimeStamp().compareTo(this.getModifiedTimeStamp());
        }
        else{
            int i = o.getModifiedTimeStamp().compareTo(this.getModifiedTimeStamp());
            if(i == 0){
                return this.getModifiedBy().compareTo(o.getModifiedBy());
            }
            return i;

        }

    }
}
