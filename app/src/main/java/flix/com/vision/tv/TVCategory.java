package flix.com.vision.tv;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes2.dex */
public class TVCategory implements Comparable {
    private int CategoryId;
    private String CategoryImageUrl;
    private String CategoryName;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        TVCategory tVCategory = (TVCategory) obj;
        if (getCategoryName() == null || tVCategory.getCategoryName() == null || getCategoryName().equals(tVCategory.getCategoryName())) {
            return 0;
        }
        return this.CategoryName.compareTo(tVCategory.getCategoryName());
    }

    public int getCategoryId() {
        return this.CategoryId;
    }

    public String getCategoryImageurl() {
        return this.CategoryImageUrl;
    }

    public String getCategoryName() {
        return this.CategoryName;
    }

    public void setCategoryId(int i10) {
        this.CategoryId = i10;
    }

    public void setCategoryImageurl(String str) {
        this.CategoryImageUrl = str;
    }

    public void setCategoryName(String str) {
        this.CategoryName = str;
    }
}
