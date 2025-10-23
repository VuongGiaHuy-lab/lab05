package vn.edu.tdtu.ntan.lab05;

import android.graphics.drawable.Drawable;

import java.util.Date;

public class ApplicationProfile {
    private String packageName;
    private String title;
    private Drawable appIcon;
    private long size;
    private Date lastModifiedDate;

    public ApplicationProfile(String packageName, String title,
                              Drawable appIcon, long size, Date lastModifiedDate) {
        this.packageName = packageName;
        this.title = title;
        this.appIcon = appIcon;
        this.size = size;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
