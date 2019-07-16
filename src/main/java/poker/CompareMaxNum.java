package poker;

import java.util.List;

//プレイヤーとCPUの手札の役が同じ場合、手札カードの最大値を比較
public class CompareMaxNum {

    //最大値が大きい方の手札を返す。最大値が同じ場合は、nullを返す。
	public static List<Card> compare(List<Card> player, List<Card> cpu, PokerHand ph) {
        Yaku pl = new Yaku(player);
        Yaku cp = new Yaku(cpu);
        List<Card> victory = null;
        pl.changeA();
        cp.changeA();

        switch(ph){
            case STRAIGHT:
            case STRAIGHTFLASH:
                if(pl.straight().getMaxNum() > cp.straight().getMaxNum()){
                    victory = player;
                    break;
                }else if(pl.straight().getMaxNum() < cp.straight().getMaxNum()){
                    victory = cpu;
                    break;
                }else{
                    break;
                }
            case FLASH:
                if(player.get(player.size()-1).getNum() > cpu.get(cpu.size()-1).getNum()){
                    victory = player;
                    break;
                }else if(player.get(player.size()-1).getNum() < cpu.get(cpu.size()-1).getNum()){
                    victory = cpu;
                    break;
                }else{
                    break;
                }
            case ONEPAIR:
            case TWOPAIR:
            case THREECARD:
            case FOURCARD:
            case FULLHOUSE:
                List<Card> l1 = pl.pair().getPairCard();
                List<Card> l2 = cp.pair().getPairCard();
                if(l1.get(l1.size()-1).getNum() > l2.get(l2.size()-1).getNum()){
                    victory = player;
                    break;
                }else if(l1.get(l1.size()-1).getNum() < l2.get(l2.size()-1).getNum()){
                    victory = cpu;
                    break;
                }else{
                    break;
                }
            case NOTHING:
                if(player.get(player.size()-1).getNum() > cpu.get(cpu.size()-1).getNum()){
                    victory = player;
                    break;
                }else if(player.get(player.size()-1).getNum() < cpu.get(cpu.size()-1).getNum()){
                    victory = cpu;
                    break;
                }else{
                    break;
                }
        }
        pl.returnA();
        cp.returnA();
        return victory;
    }
}