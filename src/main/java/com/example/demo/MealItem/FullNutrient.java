
package com.example.demo.MealItem;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FullNutrient {

    @SerializedName("attr_id")
    private Long mAttrId;
    @SerializedName("value")
    private Double mValue;

    public Long getAttrId() {
        return mAttrId;
    }

    public void setAttrId(Long attrId) {
        mAttrId = attrId;
    }

    public Double getValue() {
        return mValue;
    }

    public void setValue(Double value) {
        mValue = value;
    }

}
