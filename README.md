# Poker

## ポーカーゲーム  

### <概要>  
チップの賭けなしverポーカーをプレイします！  
まず、初めに5枚のカードが配られます。その後、交換したいカードを選び交換していきます。より強いカードの組み合わせ(役)を目指しましょう！  

  
### <コンパイル手順>  
ポーカーをプレイするためにはコンパイルが必要となります。cmd上でソースコードのコンパイルをする手順を示します。まず、適当な場所にディレクトリを作成し、こちらのPokerリポジトリをcloneしてください。
例として、copyという名前のディレクトリを作成し、ここにcloneします。    
`mkdir copy`  
`clone https://github.com/Hiroyuki0210/Poker copy`  
次に、リポジトリ内のPlayPoker.javaを下のようにコンパイルします。  
        `javac -encoding UTF-8 PlayPoker.java`  
ここで、PlayPoker.javaにはUTF-8の文字コードを使用していますので、コンパイルの際にエンコードしています。PlayPoker.javaをコンパイルすると、そのソースファイルにおいて参照されたクラスがあるファイル(cardディレクトリ内のCard.java、Deck.java、Suit.java と Judgeディレクトリ内のJudge.java、JudgeParam.java、Judgement.java)もコンパイルされ、それぞれのclassファイルが作成されます。  
        (ex) cardディレクトリ内に Card.class 、 Deck.class 、Suit.class　が作成。  
        
  
### <実行方法>  
まず、cmd上でPlayPoker.classがあるディレクトリまで進んでください。そして、  
   `chcp  65001`  
    `java -Dfile.encoding=UTF-8　PlayPoker`  
と入力していただくと、ゲームが始まります。ここで、1行目では chcp 65001 でcmd側の文字コードをUTF-8に、2行目では -Dfile.encoding=UTF-8 でclassファイルの文字コードをUTF-8 にそれぞれエンコードしています。  

  
### <操作説明>  
1.　PlayPokerを実行していただくと, startの記入を求められるので start を記入します。  
       Let's do Poker!! Write start  
       > start
2.　5枚のカードが配られます。特別な組み合わせ(役)がある場合は、手札の下に表示されます。  
      (ex)　手札 : 　♦5　♥8　♦11　♥13　♦13  
            　1ペア 　← 役
3.　その中に不要なカードがあればそのカード番号を記入してください。カード番号は左から0,1,2,3,4と割り振られております。  
  　※ 複数交換したい場合は、 "," で区切って入力してください。  
   　　(ex)　手札 : 　♦5　♥8　♦11　♥13　♦13 　
     　　　  ♦5　♥8　♦11が不要　→　0,1,2 と記入    
3.　カード交換を3回行います。  
