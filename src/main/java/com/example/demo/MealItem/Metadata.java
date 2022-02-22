
package com.example.demo.MealItem;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Metadata {

    @SerializedName("is_raw_food")
    private Boolean mIsRawFood;

    public Boolean getIsRawFood() {
        return mIsRawFood;
    }

    public void setIsRawFood(Boolean isRawFood) {
        mIsRawFood = isRawFood;
    }

}
