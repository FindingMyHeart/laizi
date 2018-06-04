
package com.laizi.demo;

/**
 * Created by dajuejinxian on 2018/5/28.
 */
/*
* */
public class PokerItem {

    protected Integer card;
    protected Integer fakeCard;
    protected boolean isLaizi;
    protected boolean use;
    public PokerItem(Integer card, Integer fakeCard, boolean isLaizi) {
        this.card = card;
        this.fakeCard = fakeCard;
        this.isLaizi = isLaizi;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public Integer getFakeCard() {
        return fakeCard;
    }

    public void setFakeCard(Integer fakeCard) {
        this.fakeCard = fakeCard;
    }

    public boolean isLaizi() {
        return isLaizi;
    }

    public void setLaizi(boolean laizi) {
        isLaizi = laizi;
    }

    @Override
    public String toString() {

//        String str = "真值" + card + " " + "代替" + fakeCard;
        String str = "";

        if (isLaizi){
            str += "是癞子:";
        }
        str += "原来值是:" + card;
        str += "代替：" + fakeCard;

        return str;
    }
}
