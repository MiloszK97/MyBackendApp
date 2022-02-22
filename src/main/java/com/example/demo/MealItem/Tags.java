
package com.example.demo.MealItem;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Tags {

    @SerializedName("food_group")
    private Long mFoodGroup;
    @SerializedName("item")
    private String mItem;
    @SerializedName("measure")
    private Object mMeasure;
    @SerializedName("quantity")
    private String mQuantity;
    @SerializedName("tag_id")
    private Long mTagId;

    public Long getFoodGroup() {
        return mFoodGroup;
    }

    public void setFoodGroup(Long foodGroup) {
        mFoodGroup = foodGroup;
    }

    public String getItem() {
        return mItem;
    }

    public void setItem(String item) {
        mItem = item;
    }

    public Object getMeasure() {
        return mMeasure;
    }

    public void setMeasure(Object measure) {
        mMeasure = measure;
    }

    public String getQuantity() {
        return mQuantity;
    }

    public void setQuantity(String quantity) {
        mQuantity = quantity;
    }

    public Long getTagId() {
        return mTagId;
    }

    public void setTagId(Long tagId) {
        mTagId = tagId;
    }

}
