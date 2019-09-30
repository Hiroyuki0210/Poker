package poker.domain.model;

public enum PlayerName{
     PLAYER("プレイヤー",0),
     COMPUTER1("コンピュータ1",1),
     COMPUTER2("コンピュータ2",2),
     ;

     //Field
     public final String playerName;
     public final int index;

     //Constructor
     PlayerName(String playerName, int index) {
          this.playerName = playerName;
          this.index = index;
     }

     //getter
     public String getName() {
          return playerName;
     }

     public int getIndex() {
          return index;
     }

}