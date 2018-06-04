package com.laizi.demo;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by dajuejinxian on 2018/5/27.
 */

public class LaiZi {

    /*
    *
    * 大王0
    * 小王1
    * 2 2
    * 2 3
    * 2 4
    * 2 5
    * 3 6
    * 3 7
    * 3 8
    * 3 9
    *
    * */


    public static int count = 0;

    public static void main(String[] args) {

        List<PokerItem> aList = new ArrayList<>();
        aList.add(new PokerItem(0,0,true));
        aList.add(new PokerItem(1, 1, true));
        aList.add(new PokerItem(2,2, false));
        aList.add(new PokerItem(3, 3, false));
        aList.add(new PokerItem(4, 4, false));
        aList.add(new PokerItem(5,5,false));

        List<PokerItem> bList = new ArrayList<>();

        bList.add(new PokerItem(0, 0,true));
        bList.add(new PokerItem(1,1,false));
        bList.add(new PokerItem(2,2,true));
        bList.add(new PokerItem(30, 30,false));

        List<PokerItem> cList = new ArrayList<>();
        List<PokerItem> dList = new ArrayList<>();

        for(PokerItem i : bList){

            if (i.isLaizi){
                cList.add(i);
            }else {
                dList.add(i);
            }
        }

        System.out.println("---begin");
        List<List<PokerItem>> li = new ArrayList<>();
        findIt(dList, cList, li);
        System.out.println(li);
        System.out.println("---end");
    }

    public static void findIt(List<PokerItem> cards, List<PokerItem> laiziList, List<List<PokerItem>> li){

        count++;

        if (cards.size() == 4){

            li.add(cards);
            System.out.println(cards);
            System.out.println(count);
            return;
        }

        boolean jump = true;
        for (PokerItem item : laiziList){

            if (item.use == false){
                jump = false;
            }
        }

        if (jump){
            System.out.println("cannot find it");
            return;
        }

        for (PokerItem item : cards){

            if (item.isLaizi){
                continue;
            }
            //组装 手牌
            PokerItem card = laiziList.get(0);
            card.fakeCard = item.fakeCard;
            boolean ret = check(cards, card);

            List<PokerItem> tempCards = new ArrayList<>();
            tempCards.addAll(cards);

            List<PokerItem> tempLaiziList = new ArrayList<>();
            tempLaiziList.addAll(laiziList);

            if (ret){
                PokerItem c = tempLaiziList.get(0);
                c.use = true;
                tempCards.add(c);
                tempLaiziList.remove(c);
                findIt(tempCards, tempLaiziList, li);

            }else {

                for (PokerItem item_ : tempLaiziList){
                    item_.use = true;
                }
                findIt(tempCards, tempLaiziList, li);
            }
        }

    }

    //判断能不能成为三个连在一起
    public static boolean check(List<PokerItem> lista, PokerItem laizi){

        List<PokerItem> list = new ArrayList<>();
        list.addAll(lista);
        list.add(laizi);
        if (list.size() <= 2){
            return true;
        }

        boolean rs = false;

        ll:for (PokerItem last : list){
            int count = 0;
            for (int i = 0; i < list.size(); i++){

                PokerItem current = list.get(i);
                if (current == last){
                    continue;
                }

                if (last.fakeCard / 4 == current.fakeCard / 4){
                    count++;
                }
            }

            if ((count + 1) == list.size() - 1){
                System.out.println("///");
                rs = true;
                break ll;
            }
        }

        //容忍有一张牌不是一样的情况
        return rs;
    }

}
