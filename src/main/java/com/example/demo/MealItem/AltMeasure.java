
package com.example.demo.MealItem;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AltMeasure {

    @SerializedName("measure")
    private String mMeasure;
    @SerializedName("qty")
    private Long mQty;
    @SerializedName("seq")
    private Long mSeq;
    @SerializedName("serving_weight")
    private Long mServingWeight;

    public String getMeasure() {
        return mMeasure;
    }

    public void setMeasure(String measure) {
        mMeasure = measure;
    }

    public Long getQty() {
        return mQty;
    }

    public void setQty(Long qty) {
        mQty = qty;
    }

    public Long getSeq() {
        return mSeq;
    }

    public void setSeq(Long seq) {
        mSeq = seq;
    }

    public Long getServingWeight() {
        return mServingWeight;
    }

    public void setServingWeight(Long servingWeight) {
        mServingWeight = servingWeight;
    }

}
